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
package mandelbrottest;

import com.fractal.formatter.ascii.impl.AsciiFormatter;
import com.fractal.mandelbrot.Mandelbrot;
import com.fractal.mandelbrot.MandelbrotColumn;
import com.fractal.mandelbrot.MandelbrotConfig;
import com.fractal.mandelbrot.impl.MandelbrotFactory;

/**
 *
 * @author martinr
 */
public class MandelbrotTest {

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
        System.out.println(new String(new AsciiFormatter().Convert(fractal)));
        System.out.println("Execution time (ms): " + fractal.getExecutionTime() + " Total iterations: " + fractal.getIterations());                           
        
        
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
            System.out.println("Execution time (ms): " + fractal.getExecutionTime() + " Total iterations: " + fractal.getIterations());
        }
    }
    /**
     * Result:





                                                                                        X                                     
                                                                                        X                                     
                                                                                      XXXX                                    
                                                                                     XXXXXX                                   
                                                                                     XXXXXX                                   
                                                                                    XXXXXXX                                   
                                                                                     XXXXXX                                   
                                                                                     XXXXXX                                   
                                                                                      XXXX                                    

                                                                               X  XXXXXXXXXXXX  X                             
                                                                          XX    XXXXXXXXXXXXXXXXX                             
                                                                          XX  XXXXXXXXXXXXXXXXXXXX                            
                                                                          XX XXXXXXXXXXXXXXXXXXXXXX XXX                       
                                                                           XXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                          XXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                                                                         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                                                                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                      
                                                                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X                    
                                                                     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                    
                                                                     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                         X          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                    XX   X XX       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                    XXXXXXXXXXX     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                    
                                                     XXXXXXXXXXX    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                    XXXXXXXXXXXX   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                  XXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                  XXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                  XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                  XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                      
                                              XX  XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                             XXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                        XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                         
                                             XXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                                              XX  XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                  XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                      
                                                  XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                  XXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                  XXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                    XXXXXXXXXXXX   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                     XXXXXXXXXXX    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                    XXXXXXXXXXX     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                    
                                                    XX   X XX       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                         X          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                                     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                     
                                                                     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                    
                                                                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X                    
                                                                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                      
                                                                       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                                                                         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX                        
                                                                          XXXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                           XXXXXXXXXXXXXXXXXXXXXXXXXXXX                       
                                                                          XX XXXXXXXXXXXXXXXXXXXXXX XXX                       
                                                                          XX  XXXXXXXXXXXXXXXXXXXX                            
                                                                          XX    XXXXXXXXXXXXXXXXX                             
                                                                               X  XXXXXXXXXXXX  X                             

                                                                                      XXXX                                    
                                                                                     XXXXXX                                   
                                                                                     XXXXXX                                   
                                                                                    XXXXXXX                                   
                                                                                     XXXXXX                                   
                                                                                     XXXXXX                                   
                                                                                      XXXX                                    
                                                                                        X                                     
                                                                                        X                                     





      Execution time (ms): 27 Total iterations: 248450





                                                                                        M                                     
                                                                                        M                                     
                                                                                      MMMM                                    
                                                                                     MMMMMM                                   
                                                                                     MMMMMM                                   
                                                                                    MMMMMMM                                   
                                                                                     MMMMMM                                   
                                                                                     MMMMMM                                   
                                                                                      MMMM                                    

                                                                               M  CCCCCCCCCCCC  M                             
                                                                          MM    CCCCCCCCCCCCCCCCM                             
                                                                          MM  CCCCCCCCCCCCCCCCCCCM                            
                                                                          MM CCCCCCCCCCCCCCCCCCCCCC MMM                       
                                                                           CCCCCCCCCCCCCCCCCCCCCCCCCMMM                       
                                                                          CCCCCCCCCCCCCCCCCCCCCCCCCCCMM                       
                                                                         CCCCCCCCCCCCCCCCCCCCCCCCCCCCC                        
                                                                         CCCCCCCCCCCCCCCCCCCCCCCCCCCCC                        
                                                                      MMCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                       
                                                                       CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                       
                                                                      CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                      
                                                                      CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC M                    
                                                                     CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCMM                    
                                                                     CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                         M          MCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                    MM   M MM       CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                    MMBBBBBBBBM     CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCM                    
                                                     BBBBBBBBBBM    CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                    BBBBBBBBBBBB   CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                  MBBBBBBBBBBBBBB  CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                  MBBBBBBBBBBBBBB  CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                  BBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCM                     
                                                  BBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                      
                                              MM  BBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                       
                                             MMMMBBBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                        
                        MMMMMMMMMMMMMMMMMMMMMMMMMBBBBBBBBBBBBBBBBBMCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                         
                                             MMMMBBBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                        
                                              MM  BBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                       
                                                  BBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                      
                                                  BBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCM                     
                                                  MBBBBBBBBBBBBBB  CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                  MBBBBBBBBBBBBBB  CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                    BBBBBBBBBBBB   CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                     BBBBBBBBBBM    CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                    MMBBBBBBBBM     CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCM                    
                                                    MM   M MM       CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                         M          MCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                                     CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                     
                                                                     CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCMM                    
                                                                      CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC M                    
                                                                      CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                      
                                                                       CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                       
                                                                      MMCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC                       
                                                                         CCCCCCCCCCCCCCCCCCCCCCCCCCCCC                        
                                                                         CCCCCCCCCCCCCCCCCCCCCCCCCCCCC                        
                                                                          CCCCCCCCCCCCCCCCCCCCCCCCCCCMM                       
                                                                           CCCCCCCCCCCCCCCCCCCCCCCCCMMM                       
                                                                          MM CCCCCCCCCCCCCCCCCCCCCC MMM                       
                                                                          MM  CCCCCCCCCCCCCCCCCCCM                            
                                                                          MM    CCCCCCCCCCCCCCCCM                             
                                                                               M  CCCCCCCCCCCC  M                             

                                                                                      MMMM                                    
                                                                                     MMMMMM                                   
                                                                                     MMMMMM                                   
                                                                                    MMMMMMM                                   
                                                                                     MMMMMM                                   
                                                                                     MMMMMM                                   
                                                                                      MMMM                                    
                                                                                        M                                     
                                                                                        M                                     




      Execution time (ms): 27 Total iterations: 248450
     */
    
}
