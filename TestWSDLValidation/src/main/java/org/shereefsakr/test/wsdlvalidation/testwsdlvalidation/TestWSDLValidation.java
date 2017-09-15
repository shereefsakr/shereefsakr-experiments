/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.wsdlvalidation.testwsdlvalidation;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.submit.WsdlMessageExchange;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlValidator;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlResponseMessageExchange;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlError;

/**
 *
 * @author Sherif Saqr
 */
public class TestWSDLValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println ( "starting" ) ;
            //String url = "http://www.dneonline.com/calculator.asmx?WSDL" ;
            String url = "http://www.webservicex.net/globalweather.asmx?wsdl" ;
            //String url = "http://localhost:9999/wsdl/CMSWebService/CMSInvokeService_WSDL/CMSWebService.wsdl" ;
            WsdlContext wsdlContext = new WsdlContext( url ) ;
            
            WsdlValidator wsdlValidator = new WsdlValidator(wsdlContext) ;
            List<XmlError> xmlErrors = new ArrayList<>() ;
            
            // Begin : Calculator WSDL
            /*
            String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soap:Body>\n" +
            "    <Add1 xmlns=\"http://tempuri.org/\">\n" +
            "      <intA1>int</intA1>\n" +
            "      <intB2>int</intB2>\n" +
            "    </Add1>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>" ;
            //*/
            // End : Calculator WSDL
            
            // Begin : Global weather WSDL
            ///*
            String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <GetWeather xmlns=\"http://www.webserviceX.NET\">\n" +
                    "      <CityName>Cairo</CityName>\n" +
                    "      <CountryName>Egypt</CountryName>\n" +
                    "    </GetWeather>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>" ;
            //*/
            // End : Global weather WSDL
            wsdlValidator.validateXml(request , xmlErrors);
            
            wsdlContext.load() ;
            
            WsdlInterface wsdlInterface =  wsdlContext.getInterface() ;
            
            WsdlRequest wsdlRequest = wsdlInterface.getOperationAt(0).addNewRequest("Test");
            
            wsdlRequest.setRequestContent(request);
            
            WsdlResponseMessageExchange msgExchange = new WsdlResponseMessageExchange(wsdlRequest) ;
            
            wsdlValidator.validateMessage(msgExchange, request, null, null, xmlErrors, true);
            
            System.out.println ( "ending" ) ;
        } catch (Exception ex) {
            System.out.println ( ex.getMessage()) ;
            ex.printStackTrace();
        }
    }
}