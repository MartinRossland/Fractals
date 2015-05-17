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
package com.fractal.impl;

/**
 *
 * @author martinr
 */
public abstract class FractalConfig implements com.fractal.FractalConfig {
    // Setting default configurations
    protected int width = 640;
    protected int height = 480;
    protected int maxIterations = 1000;
    
    @Override
    public com.fractal.FractalConfig setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public com.fractal.FractalConfig setHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public com.fractal.FractalConfig setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        return this;
    }

    @Override
    public int getMaxIterations() {
        return this.maxIterations;
    }
}
