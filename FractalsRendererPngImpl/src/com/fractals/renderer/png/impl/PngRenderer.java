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
package com.fractals.renderer.png.impl;

import com.fractals.fractal.generic.Generic;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.security.InvalidParameterException;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author martinr
 */
public class PngRenderer implements com.fractals.renderer.generic.GenericRenderer {

    @Override
    public byte[] Render(Generic fractal) {
        if(!fractal.isDone()) { 
            throw new InvalidParameterException("Can not render an unfinished fractal");
        }
                   
        BufferedImage image = new BufferedImage(fractal.getConfig().getWidth(), fractal.getConfig().getHeight(), BufferedImage.TYPE_INT_RGB);        
        
        for(com.fractals.fractal.generic.GenericColumn[] row: fractal.getGrid()) {
            for(com.fractals.fractal.generic.GenericColumn column : row) {                                               
                image.setRGB(
                        column.getColumnPos(), 
                        column.getRowPos(), 
                        getRgbColor(
                                column.inSet(), 
                                column.getIterations(), 
                                fractal.getConfig().getMaxIterations()));
            }            
        }
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        try {
            ImageIO.write(image, "png", output);
        } catch(IOException ex) {}

        return output.toByteArray();
    }  
    
    /**
     * Return rgb based on parameters
     * 
     * TODO: Add different schemas when configuration for renders is in place
     * 
     * @param inSet
     * @param iterations
     * @param maxIterations
     * @return 
     */
    private int getRgbColor(boolean inSet, int iterations, int maxIterations) {
        if(inSet) {
            return 0;
        }
        
        // TODO: Rewrite
        int max = 300;
        int start = 75;
        int iterationColor = (iterations * max) / maxIterations;               
        
        return new Color(
                iterationColor + start > 250 ? (max + start) - iterationColor : 0,
                0,
                iterationColor + start > 250 ? 250 : iterationColor + start        
        ).getRGB();
        
    }
}
