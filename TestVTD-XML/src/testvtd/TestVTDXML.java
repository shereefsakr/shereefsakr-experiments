/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testvtd;

import com.ximpleware.AutoPilot;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

/**
 *
 * @author shereef.sakr
 */
public class TestVTDXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
             VTDGen vg = new VTDGen();
            if (vg.parseFile("C:\\Users\\shereef.sakr\\Desktop\\BillAuditorTestingData\\billauditortestingdata\\BCH-XMLs-by-Shereef\\SUM6132.82662.xml", true)){
                    VTDNav vn = vg.getNav();
                    //vn.getText();
                    //System.out.println("text data ===>" + vn.toString(vn.getText()));
                    //System.out.println("text data ===>" + vn.getXPathStringVal());
                    
                    AutoPilot autoPilot = new AutoPilot(vn ) ;
                    
                    autoPilot.selectXPath("Summary/CustRef[@Id='CUST0000022696']/Addr" );
                    
                    int idx = -1 ;
                    
                    while ( ( idx = autoPilot.evalXPath() ) != -1 ) {
                        System.out.println ( "in loop" ) ;
                        int t = vn.getText(); // get the index of the text (char data or CDATA)
                        
                        if (t!=-1)
                            System.out.println(" Text  ==> "+vn.toNormalizedString(t));
                    }
                    
                    
                    //System.out.println ("idx : " + idx + ", " + vn.toString(idx));
                    
                    System.out.println ( vn.toString(vn.getAttrVal( "Name" )) ) ;
                    
                    System.out.println ( vn.getXPathStringVal() ) ;
            }
        } catch (Exception e) {
            System.out.println (e.getMessage());
            e.printStackTrace();
        }
    }
    
}
