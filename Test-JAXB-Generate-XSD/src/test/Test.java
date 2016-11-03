/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import test.Response.Property;
import test.Response.Property.MultiValues;

/**
 *
 * @author Administrator
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
           

            List<Property> responseValues =new ArrayList<Property>();
            
            Property TariffInfo =new Property();
            TariffInfo.setName("TariffInfo");
            
            List<Property> tarrifValues =new ArrayList<Property>();
            
            MultiValues tarrifMulti=new MultiValues();
            
            Property serviceClass =new Property();
            serviceClass.setName("serviceClass");
            serviceClass.setSingleValue("810");
            tarrifValues.add(serviceClass);
            
            Property rechargeBalance =new Property();
            rechargeBalance.setName("rechargeBalance");
            rechargeBalance.setSingleValue("0");
            tarrifValues.add(rechargeBalance);
            
            Property virtualRechargeBalance =new Property();
            virtualRechargeBalance.setName("virtualRechargeBalance");
            virtualRechargeBalance.setSingleValue("9505");
            tarrifValues.add(virtualRechargeBalance);
            
            
            Property virtualRechargeBalance1 =new Property();
            virtualRechargeBalance1.setName("virtualRechargeBalance");
            virtualRechargeBalance1.setSingleValue("On");
            tarrifValues.add(virtualRechargeBalance1);
            // TODO code application logic here
            
            
            Property renewalDate =new Property();
            renewalDate.setName("renewalDate");
            renewalDate.setSingleValue(null);
            tarrifValues.add(renewalDate);
            
            Property renewalPostponed =new Property();
            renewalPostponed.setName("renewalPostponed");
            renewalPostponed.setSingleValue("Y");
            tarrifValues.add(renewalPostponed);
            
            
            tarrifMulti.setMultiValues(tarrifValues);
            
            
            TariffInfo.setMultiValues(tarrifMulti);
            
            
            
            
            responseValues.add(TariffInfo);
            
            Property bundle =new Property();
            bundle.setName("bundle");
            List<Property> bundleValues =new ArrayList<Property>();
            
            MultiValues bundleMulti=new MultiValues();
            
            Property voiceOnnet =new Property();
            voiceOnnet.setName("voiceOnnet");
            List<Property> voiceOnnetValues =new ArrayList<Property>();
            MultiValues voiceOnnetMulti=new MultiValues();
            
            Property remaining =new Property();
            remaining.setName("remaining");
            remaining.setSingleValue("0");
            voiceOnnetValues.add(remaining);
            
            voiceOnnetMulti.setMultiValues(voiceOnnetValues);
            
            voiceOnnet.setMultiValues(voiceOnnetMulti);
            
            bundleValues.add(voiceOnnet);
            
            
            Property freeNumber =new Property();
            freeNumber.setName("freeNumber");
            List<Property> freeNumberValues =new ArrayList<Property>();
             MultiValues freeNumberMulti=new MultiValues();
            
            Property MSISDN =new Property();
            MSISDN.setName("MSISDN");
            MSISDN.setSingleValue("0");
            freeNumberValues.add(MSISDN);
            
            
            Property remaining1 =new Property();
            remaining1.setName("remaining");
            remaining1.setSingleValue("0");
            freeNumberValues.add(remaining1);
            
            freeNumberMulti.setMultiValues(freeNumberValues);
            freeNumber.setMultiValues(freeNumberMulti);
            
            bundleValues.add(freeNumber);
            
            
            
            Property dataWhatsApp =new Property();
            dataWhatsApp.setName("dataWhatsApp");
            List<Property> dataWhatsAppValues =new ArrayList<Property>();
             MultiValues dataWhatsAppMulti=new MultiValues();
            
            Property consumed =new Property();
            consumed.setName("consumed");
            consumed.setSingleValue("NAN");
            dataWhatsAppValues.add(consumed);
            
            
            Property remaining2 =new Property();
            remaining2.setName("remaining");
            remaining2.setSingleValue("NAN");
            dataWhatsAppValues.add(remaining2);
            
            
            Property total =new Property();
            total.setName("total");
            total.setSingleValue("0");
            dataWhatsAppValues.add(total);
            
            
            dataWhatsAppMulti.setMultiValues(dataWhatsAppValues);
            
            dataWhatsApp.setMultiValues(dataWhatsAppMulti);
            
            
            
            bundleValues.add(dataWhatsApp);
            
            bundleMulti.setMultiValues(bundleValues);
            
            bundle.setMultiValues(bundleMulti);
            
            
            responseValues.add(bundle);
            
            Property addOns =new Property();
            addOns.setName("addOns");
            List<Property> addOnsValues =new ArrayList<Property>();
             MultiValues addOnsMulti=new MultiValues();
            
            
              Property PayAsYouGoAddon =new Property();
              PayAsYouGoAddon.setName("PayAsYouGoAddon");
              PayAsYouGoAddon.setSingleValue(null);
              
             addOnsValues.add(PayAsYouGoAddon);
            
            
            Property freeNumber1 =new Property();
            freeNumber1.setName("freeNumber");
            List<Property> freeNumber1Values =new ArrayList<Property>();
            MultiValues freeNumber1Multi=new MultiValues();
            
            
            
            Property MSISDN3 =new Property();
            MSISDN3.setName("MSISDN");
            MSISDN3.setSingleValue("0");
            freeNumber1Values.add(MSISDN3);
            
            Property remaining7 =new Property();
            remaining7.setName("remaining");
            remaining7.setSingleValue("0");
            freeNumber1Values.add(remaining7);
            
            freeNumber1Multi.setMultiValues(freeNumber1Values);
            freeNumber1.setMultiValues(freeNumber1Multi);
            
            addOnsValues.add(freeNumber1);
            
            
            
            
            Property dataWhatsApp1 =new Property();
            dataWhatsApp1.setName("dataWhatsApp");
            List<Property> dataWhatsApp1Values =new ArrayList<Property>();
            MultiValues dataWhatsApp1Multi=new MultiValues();
            
            
            
            Property consumed1 =new Property();
            consumed1.setName("consumed");
            consumed1.setSingleValue("NAN");
            dataWhatsApp1Values.add(consumed1);
            
            Property remaining5 =new Property();
            remaining5.setName("remaining");
            remaining5.setSingleValue("NAN");
            dataWhatsApp1Values.add(remaining5);
            
            Property total2 =new Property();
            total2.setName("total");
            total2.setSingleValue("0");
            dataWhatsApp1Values.add(total2);
            
            dataWhatsApp1Multi.setMultiValues(dataWhatsApp1Values);
            dataWhatsApp1.setMultiValues(dataWhatsApp1Multi);
            
            addOnsValues.add(dataWhatsApp1);
            
            addOnsMulti.setMultiValues(addOnsValues);
            addOns.setMultiValues(addOnsMulti);
            
            
            
            responseValues.add(addOns);
            
            Response resp=new Response();
            resp.setProperties(responseValues);
            
            
            String output = "";
            JAXBContext context = null;
            java.io.StringWriter sw = new StringWriter();
            context = JAXBContext.newInstance(Response.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(resp, sw);
            output = sw.toString();
            
            System.out.println(output);
        } catch (JAXBException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
       
        
        
        
        
        
        
       
          
          
         
         
         
         
    }
    
}
