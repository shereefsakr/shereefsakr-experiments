/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author Sherif Saqr
 */
public class Test2 {
    private static class MySchemaOutputResolver extends SchemaOutputResolver {
 
    public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
        System.out.println(suggestedFileName);
        File file = new File(suggestedFileName);
        StreamResult result = new StreamResult(file);
        result.setSystemId(file.toURI().toURL().toString());
        return result;
    }
 
}
    public static void main(String[] args) {
        try {
            Class[] classes = new Class[1];
            classes[0] = Response.class;
            
            JAXBContext jaxbContext = JAXBContext.newInstance(classes);
            
            SchemaOutputResolver sor = new MySchemaOutputResolver();
            try {
                jaxbContext.generateSchema(sor);
            } catch (IOException ex) {
                Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JAXBException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
