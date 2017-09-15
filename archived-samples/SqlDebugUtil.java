package com.mobinil.PG.interfacing.util;

import java.sql.CallableStatement;
import java.sql.Connection;

public final class SqlDebugUtil 
{
    // Debug Setting : Determines whether Debugging is enabled or not.
    private static final boolean DEBUG = false ;
    
    // Debugging Connection Parameters
    private static final String HOST = "192.9.200.29" ;
    private static final String PORT = "8000" ;
    
    private SqlDebugUtil()
    {
    }
    
    /**
     * @param connection The Connection used for debugging.
     * @return true on success, false on failure or Debugging is disabled.
     */
    public static boolean initializeDebugging ( Connection connection )
    {
        return ( initializeDebugging( connection , HOST , PORT ) ) ;
    }
    
    /**
     * @param connection The Connection used for debugging.
     * @param host IP Address for your local machine that you are going to use for debugging.
     * @param port Port for your local machine that you are going to use for debugging.
     * @return true on success, false on failure or Debugging is disabled.
     */
    public static boolean initializeDebugging ( Connection connection , String host , String port )
    {
        if ( !DEBUG )
            return ( false ) ;
        
        boolean debuggingHasInitialized = false ;
        
        try
        {
            CallableStatement debugStatement = connection.prepareCall( "{ CALL DBMS_DEBUG_JDWP.CONNECT_TCP( '" + host + "', " + port + " ) }" ) ;
            
            debuggingHasInitialized = debugStatement.execute () ;
        }
        catch ( Exception exception )
        {
            System.out.println ( exception.getMessage() ) ;
            exception.printStackTrace () ;
        }
        finally
        {
            return ( debuggingHasInitialized ) ;
        }
    }
}