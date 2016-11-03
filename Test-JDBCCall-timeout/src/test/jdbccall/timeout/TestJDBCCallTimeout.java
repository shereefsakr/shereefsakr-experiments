/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jdbccall.timeout;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Shereef Sakr
 */
public class TestJDBCCallTimeout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Properties props = new Properties() ;
            props.put( "user" , "test_schema") ;
            props.put( "password" , "t") ;
            
            props.put( "oracle.net.CONNECT_TIMEOUT" , "10000000") ;
            props.put( "oracle.jdbc.ReadTimeout" , "2000" ) ;
            
            //Connection conn = DriverManager.getConnection( "jdbc:oracle:thin:@10.0.1.9:1521:orcl" , "test_schema" , "t" ) ;
            Connection conn = DriverManager.getConnection( "jdbc:oracle:thin:@10.0.1.9:1521:orcl" , props ) ;
            
            conn.setAutoCommit(true);
            
            //*
            CallableStatement stat = conn.prepareCall("{CALL ? := test_sleep ( 5 , 5 ) }") ;
            
            stat.registerOutParameter(1, Types.NUMERIC );
            System.out.println ( new Date()) ;
            //stat.setQueryTimeout(2);
            stat.execute();
            System.out.println ( new Date()) ;
            //*/
            
            /*
            Statement stat2 = conn.createStatement() ;
            
            System.out.println ( new Date()) ;
            //stat2.setQueryTimeout(3);
            stat2.executeQuery( " select test_sleep ( 5 , 5 ) from dual" );
            System.out.println ( new Date()) ;
            //*/
        } catch (Exception ex) {
            System.out.println ( new Date()) ;
            System.out.println ( ex.getMessage() ) ;
            ex.printStackTrace();
        }
    }
}