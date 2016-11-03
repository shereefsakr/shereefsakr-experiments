/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.experiments;

import java.io.File;

/**
 *
 * @author Sherif Saker
 */
public class TestApacheXalan {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis() ;
            //String xmlFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-file.xml";
            String xmlFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-file-large.xml";
            String xsltFilename = "D:\\Work\\Experiments\\Test-XSLT\\files\\test-xslt.xslt";
            
            
            /*//
            String xmlSystemId = new File(xmlFilename).toURL().toExternalForm( );
            String xsltSystemId = new File(xsltFilename).toURL().toExternalForm( );
            
            org.apache.xalan.xslt.XSLTProcessor processor = org.apache.xalan.xslt.XSLTProcessorFactory.getProcessor();
            org.apache.xalan.xslt.XSLTInputSource xmlInputSource = new org.apache.xalan.xslt.XSLTInputSource(xmlSystemId);
            org.apache.xalan.xslt.XSLTInputSource xsltInputSource = new org.apache.xalan.xslt.XSLTInputSource(xsltSystemId);
            org.apache.xalan.xslt.XSLTResultTarget resultTree = new org.apache.xalan.xslt.XSLTResultTarget(System.out);
            processor.process(xmlInputSource, xsltInputSource, resultTree);
            //*/
            
            long transformStartTime = System.currentTimeMillis() ;
            
            
            
            
            
            //System.out.println ( "Result : " + resultWriter.toString()) ;
            System.out.println ( "Transform Time in msecs : " + ( System.currentTimeMillis() - transformStartTime ) ) ;
            System.out.println ( "All Time in msecs : " + ( System.currentTimeMillis() - startTime ) ) ;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
