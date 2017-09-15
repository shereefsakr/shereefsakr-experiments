/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sherif Saqr
 */
public class TestDateFormat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            String originalDate =  "20170406T01:54:05+0200" ;
            String airDateFormat = "yyyyMMdd'T'HH:mm:ss+0200" ;
            
            String pcrfDateFormat = "yyyyMMddHHmmss" ;
            
            SimpleDateFormat sdf = new SimpleDateFormat( airDateFormat ) ;
            SimpleDateFormat sdf2 = new SimpleDateFormat( pcrfDateFormat ) ;
            
            
            
            System.out.println ( sdf.parse( originalDate ) ) ;
            
            String result = sdf2.format( sdf.parse( originalDate ) ) ;
            System.out.println (  result ) ;
            
            //result = sdf2.format( sdf.parse( result ) ) ;
            
            //System.out.println (  result ) ;
            
            String test = "201720201009055455" ;
            //String test = "20172020100905" ;
            
            System.out.println ( sdf2.parse( test ).toString() ) ;
        } catch (ParseException ex) {
            System.out.println( ex.getMessage());
            ex.printStackTrace(); 
        }
    }
    
}
