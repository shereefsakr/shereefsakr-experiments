/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.experiments;

import java.io.File;
import java.io.StringWriter;

/**
 *
 * @author Sherif Saker
 */
public class xslt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis() ;
            String xmlFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-file.xml";
            //String xmlFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-file-large.xml";
            String xsltFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-xslt.xslt";
            
            StringWriter resultWriter = new StringWriter() ;
            File xmlFile = new File(xmlFilename);
            File xsltFile = new File(xsltFilename);
            javax.xml.transform.Source xmlSource =
                    new javax.xml.transform.stream.StreamSource(xmlFile);
            javax.xml.transform.Source xsltSource =
                    new javax.xml.transform.stream.StreamSource(xsltFile);
            javax.xml.transform.Result result =
                    new javax.xml.transform.stream.StreamResult(resultWriter);
            // create an instance of TransformerFactory
            javax.xml.transform.TransformerFactory transFact =
                    javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer trans =
                    transFact.newTransformer(xsltSource);
            
            System.out.println (trans) ;
            
            long transformStartTime = System.currentTimeMillis() ;
            trans.transform(xmlSource, result);
            System.out.println ( "Result : " + resultWriter.toString()) ;
            System.out.println ( "Transform Time in msecs : " + ( System.currentTimeMillis() - transformStartTime ) ) ;
            System.out.println ( "All Time in msecs : " + ( System.currentTimeMillis() - startTime ) ) ;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
