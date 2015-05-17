# Fractals

Fractals is a java library for creating different types of fractals.

### Implemented fractals:

  - Mandelbrot

### Implemented fractal formatters:

  - Ascii formatter

### Todo: 

  - Add unit tests
  - Add thread processing for mandelbrot implementation
  - Add image formatter for creating amazing fractal images
  - Add configuration for formatters
  - Add user interface
    - zoom capabilities
    - animations

### Testing:

Use the MandelbrotTest project to play around with different configurations.

### Mandelbrot result using formatter

Size: 120x80

```

                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
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
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
Execution time (ms): 26, Total iterations: 248450

```

### Mandelbrot result not using formatter (to distinct between match types)

Size: 120x80

```

                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
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
                                                                                                                        
                                                                                                                        
                                                                                                                        
 Execution time (ms): 26, Total iterations: 248450

```
