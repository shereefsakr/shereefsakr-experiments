/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.jwt.nimbusjose;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shereef Sakr
 */
public class TestHMAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String token = generate() ;
        System.out.println("Result : " + token ) ;
        System.out.println ( verify(token)) ;
    }

    public static String generate() {
        String result = null;

        try {
            // Create an HMAC-protected JWS object with some payload
            JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256),
                    new Payload("Hello, world!"));

            // We need a 256-bit key for HS256 which must be pre-shared
            byte[] sharedKey = new byte[32];
            new SecureRandom().nextBytes(sharedKey);

            // Apply the HMAC to the JWS object
            jwsObject.sign(new MACSigner(sharedKey));

            // Output to URL-safe format
            result = jwsObject.serialize();

        } catch (JOSEException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return (result);
    }

    public static boolean verify(String s) {
        boolean result = false ;
        try {
            byte[] sharedSecret = new byte[32];
            
            // To parse the JWS and verify it, e.g. on client-side
            JWSObject jwsObject = JWSObject.parse(s);
            
            JWSVerifier verifier = new MACVerifier(sharedSecret);
            
            result = jwsObject.verify(verifier);
            
            //result = ( "Hello, world!".equals( jwsObject.getPayload().toString()));
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return ( result ) ;
    }
}
