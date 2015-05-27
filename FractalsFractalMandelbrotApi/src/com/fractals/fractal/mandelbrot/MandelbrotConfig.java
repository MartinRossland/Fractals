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
package com.fractals.fractal.mandelbrot;

/**
 *
 * @author martinr
 */
public interface MandelbrotConfig extends com.fractals.fractal.generic.GenericConfig {       
    
    @Override
    public MandelbrotConfig setWidth(int width);
   
    @Override
    public MandelbrotConfig setHeight(int height);
    
    @Override
    public MandelbrotConfig setMaxIterations(int maxIterations);
    
    /**
     * Set complex plane minimum real value (x-axis start)
     * 
     * Example: -2.5
     * 
     * @param reMin 
     * @return  
     */
    public MandelbrotConfig setReMin(double reMin);
    
    /**
     * Returns complex plane minimum real value (x-axis start)     
     * 
     * @return 
     */
    public double getReMin();
    
    /**
     * Set complex plane maximum real value (x-axis end)
     * 
     * Example: 1
     * 
     * @param reMax 
     * @return  
     */
    public MandelbrotConfig setReMax(double reMax);
    
    /**
     * Returns complex plane maximum real value (x-axis end)
     * 
     * @return 
     */
    public double getReMax();
    
    /**
     * Set complex plane minimum imaginary value (y-axis start)
     * 
     * Example: -1
     * 
     * @param imMin
     * @return 
     */
    public MandelbrotConfig setImMin(double imMin);
    
    /**
     * Returns complex plane minimum imaginary value (y-axis start)
     * 
     * @return 
     */
    public double getImMin();
    
    /**
     * Set complex plane maximum imaginary value (y-axis start)
     * 
     * Example: 1
     * 
     * @param imMax
     * @return 
     */
    public MandelbrotConfig setImMax(double imMax);
    
    /**
     * Set complex plane maximum imaginary value (y-axis end)
     * 
     * @return
     */
    public double getImMax();
    
  
    /**
     * Set bailout value
     * 
     * @param bailout
     * @return 
     */
    public MandelbrotConfig setBailoutValue(double bailoutValue);
    
    /**
     * Get bailout value
     * 
     * @return bailout value
     */
    public double getBailoutValue();
    
    /**
     * Set periodicity check decimal precision
     * 
     * @param periodicityPrecision 
     * @return  
     */
    public MandelbrotConfig setPeriodicityPrecision(double periodicityCheckPrecision);
    
    /**
     * Get periodicity check precision
     * 
     * @return 
     */
    public double getPeriodicityPrecision();
}
