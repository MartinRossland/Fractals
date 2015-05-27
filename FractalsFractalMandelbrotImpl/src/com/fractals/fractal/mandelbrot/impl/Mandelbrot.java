/*
 * The MIT License
 *
 * Copyright 2015 martinr.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.fractals.fractal.mandelbrot.impl;

/**
 *
 * @author martinr
 */
public class Mandelbrot 
    extends com.fractals.fractal.generic.impl.Generic
    implements com.fractals.fractal.mandelbrot.Mandelbrot {
    
    private final com.fractals.fractal.mandelbrot.MandelbrotConfig config = new MandelbrotConfig();
    private com.fractals.fractal.mandelbrot.MandelbrotPoint[][] canvas;
    private long executionStart;
            
    @Override
    public void process() {
        // Stop execution if process is already running
        if(this.inProgress()) {
            throw new IllegalStateException("Can not run process when the a process is already running.");
        }

        // Reset points
        this.points = this.config.getWidth() * this.config.getHeight();
        // Reset processed points
        this.processedPoints = 0;        
        
        // Grids contains rows and points representing a row for every vertical
        // height units and a column for every horizontal width units
        this.canvas = new MandelbrotPoint[this.config.getHeight()][this.config.getWidth()];                        
        
        // Scale from canvas to plane
        double scaleX = this.calculateScaleX(this.config.getReMin(), this.config.getReMax(), this.config.getWidth());
        double scaleY = this.calculateScaleY(this.config.getImMin(), this.config.getImMax(), this.config.getHeight());

        // Set execution start time
        this.executionStart = System.currentTimeMillis();
                
        // TODO: run column processing in paralell 
        for(int canvasY = 0; canvasY < this.config.getHeight(); canvasY++) {                       
            double y0 = this.calculatePositionX(this.config.getImMin(), scaleY, canvasY);                
            for(int canvasX = 0; canvasX < this.config.getWidth(); canvasX++) {
                double x0 = this.calculatePositionX(this.config.getReMin(), scaleX, canvasX);                
                this.canvas[canvasY][canvasX] = this.processPoint(
                        x0,
                        y0,
                        this.config.getBailoutValue(),
                        this.config.getMaxIterations(),
                        this.config.getPeriodicityPrecision());
                
                this.iterations += this.canvas[canvasY][canvasX].getIterations();
                this.processedPoints++;
            }
        }           
        
        // Set execition time
        // TODO: change this when doing paralell processing
        this.executionTime = System.currentTimeMillis() - this.executionStart;
    }
    
    @Override
    public com.fractals.fractal.mandelbrot.MandelbrotConfig getConfig() {
        return this.config;
    }
    
    @Override
    public com.fractals.fractal.mandelbrot.MandelbrotPoint[][] getCanvas() {
        return this.canvas;
    } 
    
    /**
     * Process mandelbrot point
     * 
     * Process whether point tends towards infinity or not. If it tends towards
     * infinity it's not part of the mandelbrot set. 
     * 
     * Have following checks to
     * reduce amount of iterations:
     * - cardioid check
     * - period-2 bulb check
     * - periodicity check
     * 
     * @param x0 x position in plane
     * @param y0 y posotion in plane
     * @param bailoutValue
     * @param maxIterations
     * @param periodicityPrecision
     * @return MandelbrotPoint - iterations, inset, type
     */
    private com.fractals.fractal.mandelbrot.MandelbrotPoint processPoint(double x0, double y0, double bailoutValue, int maxIterations, double periodicityPrecision) {                     
        // Start sequence of x and y
        double[] xy = {0, 0};        
        
        // Iterations
        int i = 0;
        
        // Cardioid check to save iterative checks
        if(this.isCardioid(x0, y0)) {
            return new MandelbrotPoint(i, true, com.fractals.fractal.mandelbrot.MandelbrotPoint.MatchType.CARDIOID);
        }
                
        // Period-2 bulb check to save iterative checks
        if(this.isPeriod2Bulb(x0, y0)) {
            return new MandelbrotPoint(i, true, com.fractals.fractal.mandelbrot.MandelbrotPoint.MatchType.BULB);
        }
        
        // Run sequence to see if part of the mandelbrot set
        while(i++ < maxIterations) {                                     
            xy = this.nextSequence(x0, y0, xy[0], xy[1]);                     

            // Check if it's within bailout bounderies
            if(this.isBailout(xy[0], xy[1], bailoutValue)) {
                return new MandelbrotPoint(i, false, com.fractals.fractal.mandelbrot.MandelbrotPoint.MatchType.BAILOUT);
            }
            
            // Periodicity check to save iterative checks
            if(this.isPeriodicity(x0, y0, xy[0], xy[1], periodicityPrecision)) {
                return new MandelbrotPoint(i, true, com.fractals.fractal.mandelbrot.MandelbrotPoint.MatchType.PERIOD);
            } 
        }
        
        // If max iteration is reached, it's part of the set
        return new MandelbrotPoint(i, true, com.fractals.fractal.mandelbrot.MandelbrotPoint.MatchType.PERIOD);
    }
    
    /**
     * Calculate x scale between canvas and plane
     * 
     * Equation:
     * x = (reMax - reMin) / canvasWidth
     * 
     * @param reMin
     * @param reMax
     * @param canvasWidth
     * @return Scale x and y
     */
    private double calculateScaleX(double reMin, double reMax, int canvasWidth) {
        return (reMax - reMin) / canvasWidth;
    }
    
    /**
     * Calculate y scale between canvas and plane
     * 
     * Equation:
     * y = (imMax - imMin) / canvasHeight
     * 
     * @param imMin
     * @param imMax
     * @param canvasHeight
     * @return Scale x and y
     */
    private double calculateScaleY(double imMin, double imMax, int canvasHeight) {
        return (imMax - imMin) / canvasHeight;
    }
    
    /**
     * Calculate x0 position in plane
     * 
     * Equation:
     * x0 = (canvasX * scaleX) + reMax;
     * y0 = (canvasY * scaleY) + imMin;
     * 
     * @param reMin
     * @param scaleX
     * @param canvasX
     * @return Position x0
     */
    private double calculatePositionX(double reMin, double scaleX, int canvasX) {
        return (canvasX * scaleX) + reMin;
    }
    
    /**
     * Calculate y0 position in plane
     * 
     * Equation:
     * y0 = (canvasY * scaleY) + imMin;
     * 
     * @param imMin
     * @param scaleY
     * @param canvasY
     * @return 
     */
    private double calculatePositionY(double imMin, double scaleY, int canvasY) {
        return (canvasY * scaleY) + imMin;
    }
    
    /**
     * Calculate next sequence
     * 
     * Equation:
     * x = Re(z^2+c) = x^2 - y^2 + x0
     * y = Im(z2+c) = 2xy+y0
     * 
     * @param x0 Canvas x position in complex plane
     * @param y0 Canvas y position in complex plane
     * @param x Current x in sequence
     * @param y Current y in sequence
     * @return Next x and y sequence
     */
    private double[] nextSequence(double x0, double y0, double x, double y) {
        return new double[] {
            x*x - y*y + x0,
            2*x*y + y0
        };
    }
    
    /**
     * Check for cardioid
     * 
     * Saves iterations
     * 
     * Equation:
     * q = (x-0.25)^2 + y^2
     * q(q+(x-0.25)) < 0.25y^2
     * 
     * @param x cRe
     * @param y cIm
     */
    private boolean isCardioid(double x, double y) {       
        double q = (x-0.25)*(x-0.25) + y*y;
        return q*(q+(x-0.25)) < 0.25 * (y*y);
    }
    
    /**
     * Check for period-2 bulb
     * 
     * Saves iterations
     * 
     * Equation:
     * (x+1)^2 + y^2 < 0.0625
     * 
     * @param x0 Canvas x position in complex plane
     * @param y0 Canvas y position in complex plane
     */
    private boolean isPeriod2Bulb(double x0, double y0) {
        return (x0+1)*(x0+1) + y0*y0 < 0.0625;         
    }
    
    /**
     * Check for bailout    
     * 
     * Equation:
     * x^2-y^2 >= bailout
     * 
     * @param x Current x in sequence
     * @param y Current y in sequence
     * @param bailout bailout value
     */
    private boolean isBailout(double x, double y, double bailout) {
        return x*x + y*y >= bailout;
    }
    
    /**
     * Check for periodicity
     * 
     * This will check for a sequence that will never hit infinity with a
     * given precision
     * 
     * Example of sequence that will not hit infinity:
     * 0, -1, 0, -1, 0, -1
     * 
     * Example of sequence that will hit infinity:
     * 0, 1, 2, 5, 26, ...
     * 
     * @param x0 Canvas x position in complex plane
     * @param y0 Canvas y position in complex plane
     * @param x Current x in sequence
     * @param y Current y in sequence
     * @param precision decimal precision between sequences
     * @return false if sequence hit infinity and true if not
     */
    private boolean isPeriodicity(double x0, double y0, double x, double y, double precision) {
        // Compare two sequences ahead
        double[] seq1 = this.nextSequence(x0, y0, x, y);
        double[] seq2 = this.nextSequence(x0, y0, seq1[0], seq1[1]);       
                
        if(Math.abs(x - seq2[0]) < precision &&
                Math.abs(y - seq2[1]) < precision) {
            return true;
        }
        
        return false;
    }    
}
