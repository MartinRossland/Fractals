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
package com.fractals.fractal.generic;

/**
 *
 * @author martinr
 */
public interface Generic {
    
    /**
     * Starts processing a fractal
     */
    public void process();
    
    /**
     * Returns configuration set for fractal
     * 
     * Use this to configure the fractal
     * 
     * @return 
     */
    public com.fractals.fractal.generic.GenericConfig getConfig();    
    
    /**
     * Returns a grid of fractal columns
     * 
     * Grids contains rows and columns representing a row for every vertical
     * height units and a column for every horizontal width units
     * 
     * The grid will not be complete before method isDone returns true
     * 
     * @return 
     */
    public com.fractals.fractal.generic.GenericColumn[][] getGrid();       
    
    /**
     * Returns the execution time in milliseconds
     * 
     * @return 
     */
    public long getExecutionTime();
    
    /**
     * Returns the iterations in total
     * 
     * @return 
     */
    public int getIterations();
    
    /**
     * Returns the generation progress in percent
     * 
     * @return 
     */
    public int getProgress();
    
    /**
     * Returns whether the generation is in progress or not
     * 
     * @return 
     */
    public boolean inProgress();
    
    /**
     * Returns whether the generation is done or not
     * 
     * @return 
     */
    public boolean isDone();
}
