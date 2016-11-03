/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springeltesting;

/**
 *
 * @author Islam
 */
public class testContext {
    public boolean in(String x, String... actuals){
        boolean exist = false;
        for(String actual : actuals){
            if(actual.equals(x)){
                exist = true;
            }
        }
        return exist;
    }
    
    public boolean notIn(String x, String... valuesList){
       boolean exist = true;
        for(String actual : valuesList){
            if(actual.equals(x)){
                exist = false;
            }
        }
        return exist;
    }
}
