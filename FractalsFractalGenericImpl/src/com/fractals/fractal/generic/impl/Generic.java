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
package com.fractals.fractal.generic.impl;

/**
 *
 * @author martinr
 */
public abstract class Generic implements com.fractals.fractal.generic.Generic {
    protected int iterations;
    protected int columns;
    protected int processedColumns;
    protected long executionTime;
    
    /**
     * Constructor
 
 Generic generation will run in a separate thread
     * 
     * @param config 
     */
    protected Generic(com.fractals.fractal.generic.GenericConfig config) {
        this.columns = config.getWidth() * config.getHeight();
    }
    
    @Override
    public long getExecutionTime() {
        return executionTime;
    }
    
    @Override
    public int getIterations() {
        return iterations;
    }
    
    @Override
    public int getProgress() {
        return (this.processedColumns * 100) / this.columns;
    }

    @Override
    public boolean isDone() {
        return this.columns == this.processedColumns;
    } 
}
