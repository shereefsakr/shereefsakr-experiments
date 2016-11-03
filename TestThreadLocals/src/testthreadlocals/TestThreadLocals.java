/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthreadlocals;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sherif Saker
 */
public class TestThreadLocals {
    
    private static ThreadLocal<Integer> transactionId = new ThreadLocal<>() ;
    
    private static class MyThread implements Runnable {
        
        int i = 0 ;

        public MyThread( int i ) {
            this.i = i ;
        }

        @Override
        public void run() {
            try {
                TestThreadLocals.transactionId.set( this.i );
                
                Thread.sleep( 5000 );
                
                System.out.println ( i + " , "  + TestThreadLocals.transactionId.get() ) ;
            } catch (InterruptedException ex) {
                System.out.println (ex.getMessage() ) ;
                ex.printStackTrace();
            }
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            for ( int i = 0 ; i < 50 ; i++ ) {
                new Thread ( new MyThread( i ) ).start();
            }
            
            Thread.sleep(100000 );
        } catch (InterruptedException ex) {
            System.out.println (ex.getMessage() ) ;
            ex.printStackTrace();
        }
    }
    
}
