/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springeltesting;

import java.util.GregorianCalendar;
import java.util.HashMap;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 *
 * @author Sherif Saqr
 */
public class TestSpringELPerformance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, this.getClass().getClassLoader());
               /*
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World ' + 'Shereef'.concat('!').bytes ");
        
        String message = (String) exp.getValue();
        //*/
        
        //SpelParserConfiguration conf = new SpelParserConfiguration(SpelCompi, true)
        
        long startTime = System.currentTimeMillis() ;
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

        //  The constructor arguments are name, birthday, and nationality.
        HashMap islam = new HashMap();
        HashMap tesla = new HashMap();
        
        islam.put("name", "islam");
        
        tesla.put( "name" , "Nikola Tesla" ) ;
        tesla.put( "date" , c.getTime() ) ;
        tesla.put( "nation" , "Serbian" ) ;
        SpringELTesting.testContext t = new SpringELTesting.testContext();
        ExpressionParser parser = new SpelExpressionParser();
        //Expression exp = parser.parseExpression("Shereef is in asset");
        //Expression exp = parser.parseExpression("'Nikola Tesla' ");
        //Expression exp = parser.parseExpression("['name'] == 'Nikola Tesla' ");
        //Expression exp = parser.parseExpression("['nam' + 'e']");
        //Expression exp = parser.parseExpression("['date'] + ' ' + #testVar");
        Expression exp2 = parser.parseExpression("notIn('islam','nosser','Mohamed','ahmed')");
        Expression exp = parser.parseExpression("['nam' + 'e'] == 'Nikola Tesla' ");
        EvaluationContext context = new StandardEvaluationContext(tesla);
        EvaluationContext context2 = new StandardEvaluationContext(t);
        context.setVariable("testVar", "TestVarValue Shereef" );
        
        Object message = null ;
        
        long startTime2 = System.currentTimeMillis() ;
        //message = (Object) exp.getValue(context);
        Object message2 = (Object) exp2.getValue(context2);
        System.out.println ( "First : " + ( System.currentTimeMillis() - startTime2 ) ) ;
        
        long startTime3 = System.currentTimeMillis() ;
        message = (Object) exp.getValue(context);
        System.out.println ( "Second : " + ( System.currentTimeMillis() - startTime3 ) ) ;
        
        //System.out.println ( message ) ;
        //System.out.println(message2);
        
        //System.out.println ( System.currentTimeMillis() - startTime ) ;
    }
    
}
