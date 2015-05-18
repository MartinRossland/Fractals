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
    
    private final com.fractals.fractal.mandelbrot.MandelbrotConfig config;
    private final com.fractals.fractal.mandelbrot.MandelbrotColumn[][] grid;
    private final double rScale;
    private final double iScale;
    private final long executionStart;
    
    /**
     * Constructor
     * 
     * Mandelbrot generation will run in a separate thread
     * 
     * @param config 
     */
    protected Mandelbrot(com.fractals.fractal.mandelbrot.MandelbrotConfig config) {                
        super(config);       
        
        this.config = config;
        // Grids contains rows and columns representing a row for every vertical
        // height units and a column for every horizontal width units
        this.grid = new MandelbrotColumn[this.config.getHeight()][this.config.getWidth()];
        // Scale from grid to complex plane real value (x-axis)
        this.rScale = (this.config.getReMax() - this.config.getReMin()) / this.config.getWidth();
        // Scale from grid to complex plane imaginary value (y-axis)
        this.iScale = (this.config.getImMax() - this.config.getImMin()) / this.config.getHeight();
        
        // Set execution start time
        this.executionStart = System.currentTimeMillis();
        
        this.process();
    }
    
    /**
     * Process mandelbrot set
     */
    private void process() {
        for(int rowPos = 0; rowPos < this.config.getHeight(); rowPos++) {                        
            for(int columnPos = 0; columnPos < this.config.getWidth(); columnPos++) {
                this.processColumn(rowPos, columnPos);
            }
        }
    }
    
    /**
     * Process mandelbrot set column
     * 
     * @param rowPos
     * @param columnPos 
     */
    private void processColumn(int rowPos, int columnPos) {        
        // Find canvas x-axis position in complex plane
        double cRe = (columnPos * rScale) + this.config.getReMin();     
        
        // Find canvas y-axis position in complex plane
        double cIm = (rowPos * iScale) + this.config.getImMin();        
        
        double[] xy = {0, 0};        
        int iterations = 0;
        
        // Cardioid check to save iterative checks
        if(this.isCardioid(cRe, cIm)) {
            this.updateGrid(rowPos, columnPos, iterations, com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType.CARDIOID);
            return;
        }
        
        
        // Period-2 bulb check to save iterative checks
        if(this.isPeriod2Bulb(cRe, cIm)) {
            this.updateGrid(rowPos, columnPos, iterations, com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType.BULB);
            return;
        }
        
        // Check if column is part of the mandel brot set. If max iteration
        // is reached or periodicity checks bails out, the column is will
        // be part of the mandelbrot set.
        while(xy[0]*xy[0] + xy[1]*xy[1] <= 4 && iterations < this.config.getMaxIterations()) {                  
            iterations++;                    
            xy = this.calculateXY(cRe, cIm, xy);                     

            // Periodicity check to save iterative checks
            if(this.isPeriodicity(cRe, cIm, xy)) {                
                this.updateGrid(rowPos, columnPos, iterations, com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType.PERIOD);
                return;
            } 
        }
        
        // Add final result to grid
        this.updateGrid(rowPos, columnPos, iterations);                
    }
    
    /**
     * Updates grid with processed result
     * 
     * @param rowPos
     * @param columnPos
     * @param iterations
     * @param matchType 
     */
    private void updateGrid(int rowPos, int columnPos, int iterations) {
        this.updateGrid(
                rowPos,
                columnPos,
                iterations, 
                iterations == this.config.getMaxIterations()
                    ? com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType.MAX
                    : com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType.NONE);
    }
    
    /**
     * Updates grid with processed result
     * 
     * @param rowPos
     * @param columnPos
     * @param iterations
     * @param matchType 
     */
    private void updateGrid(int rowPos, int columnPos, int iterations, com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType matchType) {
        this.grid[rowPos][columnPos] = 
                        new MandelbrotColumn(
                                iterations, 
                                matchType != com.fractals.fractal.mandelbrot.MandelbrotColumn.MatchType.NONE, 
                                matchType);
        
        this.iterations += iterations;
        this.processedColumns++;
        
        // Set execution time if  
       if(this.isDone()) {
            this.executionTime = System.currentTimeMillis() - this.executionStart;
        }
    }
    
    /**
     * Calculate xy positions
     * 
     * @param cRe Canvas x-axis position in complex plane
     * @param cIm Canvas y-axis position in complex plane
     * @param xy Current xy position
     * @return New xy position
     */
    private double[] calculateXY(double cRe, double cIm, double[] xy) {
        double[] newXY = {xy[0]*xy[0] - xy[1]*xy[1] + cRe, 2*xy[0]*xy[1] + cIm};
        return newXY;
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
     * @param x cRe
     * @param y cIm
     */
    private boolean isPeriod2Bulb(double x, double y) {
        return (x+1)*(x+1) + y*y < 0.0625;         
    }
    
    /**
     * Check for periodicity
     * 
     * @param cRe Canvas x-axis position in complex plane
     * @param cIm Canvas y-axis position in complex plane
     * @param xy Current xy position
     * @return Whether we hit a periodicity or not
     */
    private boolean isPeriodicity(double cRe, double cIm, double[] xy) {
        double[] xyCompare = this.calculateXY(cRe, cIm, this.calculateXY(cRe, cIm, xy));
                
        if(Math.abs(xy[0] - xyCompare[0]) < this.config.getPeriodicityCheckPrecision() &&
                Math.abs(xy[1] - xyCompare[1]) < this.config.getPeriodicityCheckPrecision()) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public com.fractals.fractal.mandelbrot.MandelbrotColumn[][] getGrid() {
        return this.grid;
    }
}
