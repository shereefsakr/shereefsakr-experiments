/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.experiments;

import java.io.File;
import java.io.StringWriter;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author Sherif Saker
 */
public class TestXslt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis() ;
            String xmlFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-file.xml";
            //String xmlFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-file-large.xml";
            
            File xmlFile = new File(xmlFilename);
            javax.xml.transform.Source xmlSource =
                    new javax.xml.transform.stream.StreamSource(xmlFile);
            
            init();
            doTransform(trans, xmlSource);
            
            System.out.println ( "All Time in msecs : " + ( System.currentTimeMillis() - startTime ) ) ;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    // create an instance of TransformerFactory
    private static javax.xml.transform.TransformerFactory transFact =null ;
    private static javax.xml.transform.Transformer trans = null ;
    
    public static void init () throws TransformerConfigurationException {
        String xsltFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-xslt.xslt";
        
        File xsltFile = new File(xsltFilename);

        javax.xml.transform.Source xsltSource =
                new javax.xml.transform.stream.StreamSource(xsltFile);
        
        long testStartTime = System.currentTimeMillis() ;
        // create an instance of TransformerFactory
        transFact =
                javax.xml.transform.TransformerFactory.newInstance();
        
        
        trans =
                transFact.newTransformer(xsltSource);
        System.out.println ( "Test Time in msecs : " + ( System.currentTimeMillis() - testStartTime ) ) ;
    }
    
    public static void doTransform ( javax.xml.transform.Transformer trans , javax.xml.transform.Source xmlSource ) throws TransformerException {
        System.out.println (trans) ;
        long transformStartTime = System.currentTimeMillis() ;
        
        StringWriter resultWriter = new StringWriter() ;
        
        javax.xml.transform.Result result =
                    new javax.xml.transform.stream.StreamResult(resultWriter);
        trans.transform(xmlSource, result);
        //System.out.println ( "Result : " + resultWriter.toString()) ;
        System.out.println ( "Transform Time in msecs : " + ( System.currentTimeMillis() - transformStartTime ) ) ;
    }
}