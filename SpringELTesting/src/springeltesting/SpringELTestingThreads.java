/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springeltesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import springeltesting.testContext;

/**
 *
 * @author Shereef Sakr
 */
public class SpringELTestingThreads {
    
    public static class testContext {
        public Integer i = null ;
        
        public testContext () {
            this.i = 1 ;
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis() ;
        
        ExpressionParser parser = new SpelExpressionParser();
        
        Expression exp = parser.parseExpression("i++");
        
        for ( int i = 0 ; i < 30 ; i++ ) {
            Thread thread = new Thread( new ExpRunnable(i, exp)) ;
            
            thread.start () ;
        }
    }
    
    
    
    public static class ExpRunnable implements Runnable {
        
        private Integer threadId = null ;
        private Expression exp = null ;
        private testContext ctx = null ;
        
        public ExpRunnable ( Integer threadId , Expression exp ) {
            this.threadId = threadId ;
            this.exp = exp ;
            this.ctx = new testContext() ;
        }

        @Override
        public void run() {
            for ( int i = 0 ; i < 30000 ; i++ ) {
                long startTime = System.currentTimeMillis() ;
                System.out.println ( "ThreadId : " + this.threadId + " , Exp Result : " + this.exp.getValue(this.ctx ) ) ;
                System.out.println ( "ThreadId : " + this.threadId + " Time : " + ( System.currentTimeMillis() - startTime ) ) ;
            }
        }
    }
}
