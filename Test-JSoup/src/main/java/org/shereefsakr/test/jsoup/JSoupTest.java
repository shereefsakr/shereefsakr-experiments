/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Shereef Sakr
 * 
 * Test project for web scraping of exchange currencies in several banks in egypt.
 */
public class JSoupTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = null ;
        String selectExpr = null ;
        String userAgent = null ;
        
        try {
            // Begin : Testing different bank configurations
            
            // National Bank of Egypt
            //*
            url = "http://www.nbe.com.eg/en/ExchangeRate.aspx" ;
            selectExpr = "#dgPrices tr.td1" ;
            //*/
            
            // AAIB
            /*
            url = "http://aaib.com/services/rates" ;
            selectExpr = "#rates-table tr" ;
            //*/
            
            // End : Testing different bank configurations
            
            userAgent = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6" ;
            
            
            Document doc = Jsoup.connect( url ).timeout(10 * 1000).userAgent(userAgent).get();
            
            System.out.println ( "Connected" ) ;
            Elements newsHeadlines = doc.select(selectExpr);
            
            for ( Element e : newsHeadlines ) {
                System.out.println( "Element : " + e.text());
            }
        } catch (IOException ex) {
            System.out.println ( ex.getMessage() ) ;
            ex.printStackTrace();
        }
    }
    
}
