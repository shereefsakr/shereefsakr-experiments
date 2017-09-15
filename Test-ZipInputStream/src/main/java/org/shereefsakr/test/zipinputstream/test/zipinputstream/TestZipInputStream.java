/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.zipinputstream.test.zipinputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Sherif Saqr
 */
public class TestZipInputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            FileInputStream fis = new FileInputStream( "C:\\SharedFolder\\CMSWSSimulation\\build\\web\\WEB-INF\\wsdl\\CMSWebService\\CMSWebService.zip" ) ;
            
            //String requestedFilename = "CMSSchema.xsd" ;
            String requestedFilename = "CMSWebService.wsdl" ;
            String result = getFileContentFromZipFile(fis, requestedFilename ) ;
            
            System.out.println( "Result : " + result );
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static String getFileContentFromZipFile(InputStream is, String requestedFilename) {
        String result = null;

        try {
            byte[] buffer = new byte[1024];

            ZipInputStream zis = new ZipInputStream(is);

            ZipEntry ze = null;

            while ((ze = zis.getNextEntry()) != null) {
                if (ze.getName().equals(requestedFilename)) {

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }

                    baos.close();
                    
                    result = baos.toString() ;
                }
            }

            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return (result);
    }

}
