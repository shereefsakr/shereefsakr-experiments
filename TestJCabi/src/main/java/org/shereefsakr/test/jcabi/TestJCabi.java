/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.jcabi;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SSH;
import com.jcabi.ssh.SSHByPassword;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sherif Saqr
 */
public class TestJCabi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String host = "10.0.20.18";
            
            String user = "root";
            Shell shell = new SSHByPassword(host , 22, user  , "root123" );
            String stdout = new Shell.Plain(shell).exec("pwd");
            
            System.out.println("Result : " + stdout);
        } catch (Exception ex) {
            System.out.println( ex.getMessage());
            ex.printStackTrace();
        }
    }

}
