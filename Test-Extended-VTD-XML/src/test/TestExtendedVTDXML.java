/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.ximpleware.extended.AutoPilotHuge;
import com.ximpleware.extended.NavExceptionHuge;
import com.ximpleware.extended.VTDGenHuge;
import com.ximpleware.extended.VTDNavHuge;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shereef.sakr
 */
public class TestExtendedVTDXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // 100 mb
            //String filename = ":C\\Users\\shereef.sakr\\Desktop\\Work\\DINA\\XML\\XML\\SUM105667642.82242.xml\\SUM105667642.82242.xml" ;
            
            // 400~ mb
            //String filename = "C:\\Users\\shereef.sakr\\Desktop\\Work\\DINA\\XML\\XML\\SUM45675417.82242.xml\\SUM45675417.82242.xml" ;
            
            // My test file
            String filename = "D:\\Work\\VF\\SPS-SOURCESAFE-2010\\Vodafone\\VFE_AFKARNA_Bill Auditor\\Dynamic\\03. Implementation\\01. Requirements\\References\\References - Organized\\BCH Files\\Samples\\SUM6972.77000 - Copy.xml" ;
            
            long startTime = System.currentTimeMillis();
            VTDGenHuge vg = new VTDGenHuge();
            if (vg.parseFile(filename,true,VTDGenHuge.MEM_MAPPED)){
                    VTDNavHuge vn = vg.getNav();
                    //System.out.println("text data ===>" + vn.toString(vn.getText()));
                    
                    
                    //vn.getText();
                    //System.out.println("text data ===>" + vn.toString(vn.getText()));
                    //System.out.println("text data ===>" + vn.getXPathStringVal());
                    
                    AutoPilotHuge autoPilot = new AutoPilotHuge(vn ) ;
                    
                    
                    autoPilot.selectXPath("//SumItem/@ArticleString" );
                    //autoPilot.selectXPath("//Summary/CustRef[@Id='CUST0000022696']/Addr/@Country" );
                    //autoPilot.selectXPath("//Summary/CustRef[@Id='CUST0000022696']/Addr/@Line6" );
                    //autoPilot.selectXPath("//@City" );
                    //autoPilot.selectXPath("//Addr" );
                    
                    int idx = -1 ;
                    
                    while ( ( idx = autoPilot.evalXPath() ) != -1 ) {
                        //System.out.println ( "in loop" ) ;
                        //System.out.println ( "idx : " + idx) ;
                        
                        if (idx!=-1) {
                            //System.out.println(" Text  ==> "+vn.toNormalizedString(idx));
                            //System.out.println(" Text  ==> "+vn.toNormalizedString(idx));
                            //System.out.println(" Text  ==> "+vn.toString(idx));
                            //System.out.println(" Text  ==> "+vn.toString(vn.ge));
                            //System.out.println( vn.toString(vn.getAttrVal(vn.toString(idx)) ) ) ;
                            //System.out.println(" Text  ==> "+vn.toRawString(idx));
                            
                            String test = vn.toString(vn.getAttrVal(vn.toString(idx)) ) ;
                        }
                        
                        //System.out.println(  "AttrCount : " + vn.get );
                        //System.out.println(  "AttrCount : " + vn.getAttrCount() );
                        
                        /*
                        int t = vn.getText(); // get the index of the text (char data or CDATA)
                        
                        System.out.println ( "t : " + t) ;
                        
                        if (t!=-1)
                            //System.out.println(" Text  ==> "+vn.toNormalizedString(t));
                            System.out.println(" Text  ==> "+vn.toString(t));
                                
                        //*/
                    }
                    
                    //System.out.println ("idx : " + idx + ", " + vn.toString(idx));
                    //System.out.println ( vn.toString(vn.getAttrVal( "Name" )) ) ;
                    //System.out.println ( vn.getXPathStringVal() ) ;
            }
            
            System.out.println ( " Time taken in msec : " + ( System.currentTimeMillis() - startTime ) );
        } catch (Exception e) {
            System.out.println (e.getMessage());
            e.printStackTrace();
        }
    }
}
