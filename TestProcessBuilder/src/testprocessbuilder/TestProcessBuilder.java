/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprocessbuilder;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sherif Saker
 */
public class TestProcessBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe", "test", "myArg2");
            ProcessBuilder pb = new ProcessBuilder("cmd.exe");
            /*
            Map<String, String> env = pb.environment();
            env.put("VAR1", "myValue");
            env.remove("OTHERVAR");
            env.put("VAR2", env.get("VAR1") + "suffix");
            pb.directory(new File("C:\\Windows\\System32\\" ) );
            //pb.directory(new File("D:\\" ) );
            //*/
            File log = new File("D:\\");
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
            Process p = pb.start();
            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert p.getInputStream().read() == -1;
        } catch (Exception ex) {
            System.out.println ( ex.getMessage()) ;
            ex.printStackTrace();
        }
    }

}
