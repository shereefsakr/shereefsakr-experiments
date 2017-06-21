/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testregexsplit;

/**
 *
 * @author Sherif Saqr
 */
public class TestRegexSplit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String testStr = "hh//,yy,dddd" ;
        
        //String[] splits = testStr.split( "[^\\\\][^\\\\]," ) ; 
        //String[] splits = testStr.split( "(?!//)," ) ; 
        String[] splits = testStr.split( "(?=(?!//),)" ) ; 
        
        for ( String split : splits ) {
            System.out.println ( split ) ;
        }
    }
}
