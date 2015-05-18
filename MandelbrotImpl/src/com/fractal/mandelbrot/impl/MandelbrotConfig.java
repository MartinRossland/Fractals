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
package com.fractal.mandelbrot.impl;

/**
 *
 * @author martinr
 */
public class MandelbrotConfig 
    extends com.fractal.impl.FractalConfig 
    implements com.fractal.mandelbrot.MandelbrotConfig {

    // Setting default configurations
    private double reMin = -2.5;
    private double reMax = 1;
    private double imMin = -1;
    private double imMax = 1;
    private double periodicityCheckPrecision = 1e-7;    
    
    /**
     * Constructor
     * 
     * Made this protected to make sure it only can be initialized within this
     * package
     */
    protected MandelbrotConfig() {}
    
    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setWidth(int width) {
        super.setWidth(width);
        return this;
    }

    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setHeight(int height) {
        super.setHeight(height);
        return this;
    }

    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setMaxIterations(int maxIterations) {
        super.setMaxIterations(maxIterations);
        return this;
    }
    
    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setReMin(double reMin) {
        this.reMin = reMin;
        return this;
    }

    @Override
    public double getReMin() {
        return this.reMin;
    }

    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setReMax(double reMax) {
        this.reMax = reMax;
        return this;
    }

    @Override
    public double getReMax() {
        return this.reMax;
    }

    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setImMin(double imMin) {
        this.imMin = imMin;
        return this;
    }

    @Override
    public double getImMin() {
        return this.imMin;
    }

    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setImMax(double imMax) {
        this.imMax = imMax;
        return this;
    }

    @Override
    public double getImMax() {
        return this.imMax;
    }

    @Override
    public com.fractal.mandelbrot.MandelbrotConfig setPeriodicityCheckPrecision(double periodicityCheckPrecision) {
        this.periodicityCheckPrecision = periodicityCheckPrecision;
        return this;
    }

    @Override
    public double getPeriodicityCheckPrecision() {
        return this.periodicityCheckPrecision;
    }        
}
