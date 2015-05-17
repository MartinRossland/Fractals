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
package com.fractal.formatter.ascii.impl;

import java.security.InvalidParameterException;

/**
 *
 * @author martinr
 */
public class AsciiFormatter implements com.fractal.formatter.Formatter {

    @Override
    public byte[] Convert(com.fractal.Fractal fractal) {                       
        if(!fractal.isDone()) { 
            throw new InvalidParameterException("Can not convert an unfinished fractal");
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for(com.fractal.FractalColumn[] row: fractal.getGrid()) {
            for(com.fractal.FractalColumn column : row) {
                stringBuilder.append(column.inSet() ? "X" : " ");
            }
            stringBuilder.append("\n");
        }
        
        return stringBuilder.toString().getBytes();
    }    
}