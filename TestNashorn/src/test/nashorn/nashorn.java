/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author Sherif Saker
 */
public class nashorn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("nashorn");
            
            engine.eval("function test ( a , b ) { print ( a + b ) ; } ; test ( 1 , 1 ) ;  ");
            
            
            
            //long startTime = System.currentTimeMillis() ;
            //engine.eval ( "test (1 , 1 ) ;" ) ;
            
            long startTime = System.currentTimeMillis() ;
            engine.eval ( "test ( 4 , 2  , 3 , 4) ;" ) ;
            
            System.out.println ( "Done in " + ( System.currentTimeMillis() - startTime ) + " msecs" ) ;
        } catch (Exception ex) {
            System.out.println ( ex.getMessage() ) ;
            ex.printStackTrace () ;
        }
    }
}