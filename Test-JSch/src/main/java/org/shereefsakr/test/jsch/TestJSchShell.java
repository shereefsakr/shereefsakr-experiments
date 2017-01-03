/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.jsch;

import com.jcraft.jsch.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
s
/**
 *
 * @author Sherif Saqr
 *//**
 *
 * @author Sherif Saqr
 */
public class TestJSchShell {

    public static void main(String[] arg) {
        try {
            JSch jsch = new JSch();

            //jsch.setKnownHosts("/home/foo/.ssh/known_hosts");
            String host = "10.0.20.18";

            String user = "root";

            Session session = jsch.getSession(user, host, 22);

            session.setPassword("root123");

            UserInfo ui = new MyUserInfo() {
                public void showMessage(String message) {
                    System.out.println("Message : " + message);
                }

                public boolean promptYesNo(String message) {
                    return true;
                }
            };

            session.setUserInfo(ui);

            // It must not be recommended, but if you want to skip host-key check,
            // invoke following,
            // session.setConfig("StrictHostKeyChecking", "no");
            //session.connect();
            session.connect(30000);   // making a connection with timeout.

            Channel channel = session.openChannel("shell");

            // Enable agent-forwarding.
            //((ChannelShell)channel).setAgentForwarding(true);
            
            InputStream inStream = new ByteArrayInputStream("pwd \n".getBytes(StandardCharsets.UTF_8));
            channel.setInputStream(inStream);
            
            ByteArrayOutputStream outStream = new ByteArrayOutputStream() ;

            channel.setOutputStream(outStream);

            /*
      // Choose the pty-type "vt102".
      ((ChannelShell)channel).setPtyType("vt102");
             //*/

 /*
      // Set environment variable "LANG" as "ja_JP.eucJP".
      ((ChannelShell)channel).setEnv("LANG", "ja_JP.eucJP");
             */
            //channel.connect();
            channel.connect(3 * 1000);
            
            Thread.sleep ( 3000 ) ;
            
            String result = new String( outStream.toByteArray() );
            
            System.out.println ( result ) ;
            
            channel.disconnect();
            
            System.out.println( "Done in script" );
            
            session.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static abstract class MyUserInfo
            implements UserInfo, UIKeyboardInteractive {

        public String getPassword() {
            return null;
        }

        public boolean promptYesNo(String str) {
            return false;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return false;
        }

        public boolean promptPassword(String message) {
            return false;
        }

        public void showMessage(String message) {
        }

        public String[] promptKeyboardInteractive(String destination,
                String name,
                String instruction,
                String[] prompt,
                boolean[] echo) {
            return null;
        }
    }
}