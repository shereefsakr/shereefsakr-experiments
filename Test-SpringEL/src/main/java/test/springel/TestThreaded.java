/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.springel;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 *
 * @author Sherif Saker
 */
public class TestThreaded {
    
    public static class ExpressionRunnable implements Runnable {

        private Integer id = null;
        private Expression exp = null;
        private HashMap<String, String> hm = null;
        
        public ExpressionRunnable(Expression exp, HashMap<String, String> hm, int id) {
            this.exp = exp;
            this.hm = hm;
            this.id = id;
        }
        
        @Override
        public void run() {
            String result = this.exp.getValue(this.hm, String.class);
            
            System.out.println(this.id + " , " + result);
        }
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        ArrayList<Thread> threads = null;
        
        SpelParserConfiguration conf = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, TestThreaded.class.getClassLoader());
        ExpressionParser parser = new SpelExpressionParser(conf);
        Expression exp = parser.parseExpression("['id']");
        
        for (int i = 0; i < 1000; i++) {
            if (threads == null) {
                threads = new ArrayList<>();
            }
            
            HashMap<String, String> hm = new HashMap<>();
            
            hm.put("id", String.valueOf(i));
            
            Thread thread = new Thread(new ExpressionRunnable(exp, hm, i));
            
            threads.add(thread);
            
            thread.start();
        }
        
        threads.stream().forEach(th -> {
            try {
                th.join();
            } catch (Exception e) {
                System.out.println ( e.getMessage() ) ;
                e.printStackTrace();
            }
        });
        
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
