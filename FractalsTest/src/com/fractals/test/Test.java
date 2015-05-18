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
import com.fractals.fractal.mandelbrot.Mandelbrot;
import com.fractals.fractal.mandelbrot.MandelbrotColumn;
import com.fractals.fractal.mandelbrot.MandelbrotConfig;
import com.fractals.fractal.mandelbrot.impl.MandelbrotFactory;

/**
 *
 * @author martinr
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create mandelbrot 
        MandelbrotConfig config = MandelbrotFactory.getConfig()
                .setWidth(120)
                .setHeight(80);

        Mandelbrot fractal = MandelbrotFactory.generate(config);
        MandelbrotColumn[][] grid = fractal.getGrid();

        
        // 1. Output mandelbrot using formatter
        System.out.println(new String(new AsciiRenderer().Render(fractal)));
        System.out.println("Execution time (ms): " + fractal.getExecutionTime() + ", Total iterations: " + fractal.getIterations());                           
        
        
        // 2. Output mandelbrot without using formatter, using letters for the
        // different match types
        if(fractal.isDone()) {
            for(MandelbrotColumn[] row: grid) {
                for(MandelbrotColumn column: row) {                              
                    switch(column.getMatchType()) {
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
                        case NONE:
                            System.out.print(" ");
                            break;
                    }
                }
                System.out.println();
            }
            System.out.println("Execution time (ms): " + fractal.getExecutionTime() + ", Total iterations: " + fractal.getIterations());
        }
    }
}
