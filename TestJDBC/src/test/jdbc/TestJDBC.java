/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jdbc;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import oracle.jdbc.OracleConnection;

/**
 *
 * @author Sherif Saker
 */
public class TestJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties jdbcProperties = new Properties();
            
            jdbcProperties.put("user", "CITITO_VFE_DEV" );
            jdbcProperties.put("password", "c" );
            jdbcProperties.put("v$session.program", "TestJDBC4");
            jdbcProperties.put("v$session.osuser", "ana");
            jdbcProperties.put("v$session.machine", "ana-machine");
            Connection conn = DriverManager.getConnection( "jdbc:oracle:thin:@10.0.1.9:1521:orcl", jdbcProperties);
            //( ( OracleConnection ) conn ).set
            //conn.set
            conn.setClientInfo("OCSID.ACTION", "Test ClientID");
            System.out.println ( new Gson ().toJson( conn.getClientInfo()) ) ;
            //conn.setClientInfo("ClientWorkstation", "Test ClientWorkstation");
            
            Thread.sleep(100000);
        } catch (Exception ex) {
            System.out.println ( ex.getMessage() ) ;
            ex.printStackTrace();
        }
    }
    
}
