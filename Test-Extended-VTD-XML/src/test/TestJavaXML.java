/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author shereef.sakr
 */
public class TestJavaXML {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            
            // ~12 mb
            //String filename = "C:\\Users\\shereef.sakr\\Desktop\\BillAuditorTestingData\\billauditortestingdata\\BCH-XMLs-by-Shereef\\SUM6132.82662.xml" ;
            
            // 100 mb
            //String filename = "C:\\Users\\shereef.sakr\\Desktop\\Work\\DINA\\XML\\XML\\SUM105667642.82242.xml\\SUM105667642.82242.xml" ;
            
            // My test file
            String filename = "D:\\Work\\VF\\SPS-SOURCESAFE-2010\\Vodafone\\VFE_AFKARNA_Bill Auditor\\Dynamic\\03. Implementation\\01. Requirements\\References\\References - Organized\\BCH Files\\Samples\\SUM6972.77000 - Copy.xml" ;
            
            File f = new File(filename);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            Document document = null;
            builder = builderFactory.newDocumentBuilder();
            
            builder.setEntityResolver( new EntityResolver() {

                @Override
                public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                    return ( new InputSource( new StringReader(""))) ;
                }
            });
            document = builder.parse(f);
            //////////////////////////////////////// start xpaths //////////////////////////////
            //String pathe4 = "/Document/Summary/CustRef/Contract/PerCTInfo/SumItem/PromoItem/PromoElemRef/@*[name()='PackId' or name()='ModelId']";
            
            long parseStartTime = System.currentTimeMillis() ;
            
            for ( int j = 0 ; j < 15 ; j++ ) {
                String pathe4 = "//SumItem/@ArticleString";

                ///////////////////////////////////////////////
                javax.xml.xpath.XPath path = XPathFactory.newInstance().newXPath();
                NodeList node =  (NodeList) path.compile(pathe4).evaluate(document,XPathConstants.NODESET);
                for (int i = 0 ; i< node.getLength() ; i++) {
                    String test = node.item(i).getNodeValue() ;
                    //System.out.println(node.item(i).getNodeValue());

                    //*
                    if ( i > 5 )
                        break ;
                    //*/
                }
            }
            
            System.out.println ( " Parse Time taken in msec : " + ( System.currentTimeMillis() - parseStartTime ) );
            
            System.out.println ( " Time taken in msec : " + ( System.currentTimeMillis() - startTime ) );
        } catch (Exception ex) {
            System.out.println ( ex.getMessage() ) ;
            ex.printStackTrace();
        }
        

    }

}
