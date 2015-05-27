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
package com.fractals.test;

import com.fractals.renderer.ascii.impl.AsciiRenderer;
import com.fractals.renderer.png.impl.PngRenderer;
import com.fractals.fractal.mandelbrot.MandelbrotPoint;
import com.fractals.fractal.mandelbrot.impl.Mandelbrot;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author martinr
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Instansiate mandelbrot fractal
        Mandelbrot fractal = new Mandelbrot();
                
        //Test.PngRenderTest(fractal);        
        Test.AsciiRenderTest(fractal);
        Test.CustomRenderTest(fractal);
    }
    
    /**
     * Render fractal using png renderer
     */
    private static void PngRenderTest(com.fractals.fractal.mandelbrot.Mandelbrot fractal) throws FileNotFoundException, IOException {
        fractal.getConfig()
                .setWidth(800)
                .setHeight(457)
                .setMaxIterations(50);
                
        System.out.println("Renderer: " + PngRenderer.class);

        fractal.process();        
                         
        // TODO: add check whether fractal is done processing when we implement
        // parallel processing   
        File file = new File(
                System.getenv("HOME"), 
                "mandelbrot-" + fractal.getConfig().getWidth() + "x" + fractal.getConfig().getHeight() + "-" + fractal.getConfig().getMaxIterations() + "i.png");        
        
        // Create file if not exists
        if(file.exists()) {
            file.createNewFile();
        }

        // Write rendered byte stream to file
        FileOutputStream stream = new FileOutputStream(file);        
        try {
            stream.write(new PngRenderer().Render(fractal));                       
        } finally {
            stream.close();
        }
        
        System.out.println("File successfully created [" + file.getAbsolutePath() + "].");                
        System.out.println("Execution time (ms): " + fractal.getExecutionTime() + ", Total iterations: " + fractal.getIterations() + "\n");       
    }
    
    /**
     * Render fractal using ascii renderer
     */    
    private static void AsciiRenderTest(com.fractals.fractal.mandelbrot.Mandelbrot fractal) {
        fractal.getConfig()
                .setWidth(120)
                .setHeight(80);
                
        System.out.println("Renderer: " + AsciiRenderer.class);
        
        fractal.process();
        
        // TODO: add check whether fractal is done processing when we implement
        // parallel processing        
        System.out.println(new String(new AsciiRenderer().Render(fractal)));
        System.out.println("Execution time (ms): " + fractal.getExecutionTime() + ", Total iterations: " + fractal.getIterations() + "\n");                           
    }
    
    /**
     * Render fractal using custom renderer
     * 
     * This to test the different match types
     */
    private static void CustomRenderTest(com.fractals.fractal.mandelbrot.Mandelbrot fractal) {
        fractal.getConfig()
                .setWidth(120)
                .setHeight(80);
                
        System.out.println("Renderer: custom");
        
        fractal.process();
        
        // TODO: add check whether fractal is done processing when we implement
        // parallel processing        
        for(MandelbrotPoint[] row: fractal.getCanvas()) {
            for(MandelbrotPoint point: row) {                              
                switch(point.getMatchType()) {
                    case CARDIOID:
                        System.out.print("C");
                        break;
                    case BULB:
                        System.out.print("B");
                        break;
                    case PERIOD:
                        System.out.print("P");
                        break;
                    case MAX:
                        System.out.print("M");
                        break;
                    case BAILOUT:
                    default:
                        System.out.print(" ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println("Execution time (ms): " + fractal.getExecutionTime() + ", Total iterations: " + fractal.getIterations() + "\n");
    } 
}
