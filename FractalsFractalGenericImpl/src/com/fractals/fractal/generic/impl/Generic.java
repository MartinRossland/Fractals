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
    protected int points;
    protected int processedPoints;
    protected long executionTime;   
    
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
        if(this.points == 0) {
            return this.isDone() ? 100 : 0;
        }
        return (this.processedPoints * 100) / this.points;
    }

    @Override
    public boolean inProgress() {
        return this.executionTime > 0 && !this.isDone();
    } 
    
    @Override
    public boolean isDone() {
        return this.points == this.processedPoints;
    } 
}
