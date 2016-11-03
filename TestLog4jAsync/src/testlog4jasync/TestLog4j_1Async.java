/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlog4jasync;

/*
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//*/

/**
 *
 * @author Sherif Saker
 */
public class TestLog4j_1Async {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*
            long mainStartTime = System.currentTimeMillis() ;
            Logger logger = LogManager.getLogger(TestLog4j_1Async.class ) ;
            
            long logStartTime = System.currentTimeMillis() ;
            
            for ( int i = 0 ; i < 100000 ; i++ ) {
                logger.info( "test" );
            }
            
            System.out.println ( "Log End in " + ( System.currentTimeMillis() - logStartTime ) + " msecs" ) ;
            System.out.println ( "Main End in " + ( System.currentTimeMillis() - mainStartTime ) + " msecs" ) ;
            
            logger.info( "Logging Ended" );
            //Thread.sleep(10000);
            //*/
        } catch (Exception ex) {
            System.out.println ( ex.getMessage() ) ;
            ex.printStackTrace();
        }
    }
}
