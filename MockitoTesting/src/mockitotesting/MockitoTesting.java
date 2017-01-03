/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mockitotesting;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

/**
 *
 * @author Shereef Sakr
 */
public class MockitoTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseAbstractClass test = Mockito.mock( BaseAbstractClass.class );
        //BaseAbstractClass test = Mockito.spy( new BaseAbstractClass ()  ) ;
        //BaseAbstractClass test = new BaseAbstractClass() ;
        
        //*
        Mockito.doAnswer( new org.mockito.stubbing.Answer () {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                System.out.println ( "in doVoid mocked method" ) ;
                //invocation.callRealMethod() ;
                return ( null ) ;
            }
        }).when ( test ).doVoid() ;
        //*/
        
        //Mockito.when( test.getVariable2() ).thenReturn( "shereef" ) ;
        Mockito.when( test.getVariable( Mockito.any( Integer.class ) ) ).thenReturn( "mocked return" ) ;
        Mockito.when( test.getVariable2() ).thenCallRealMethod() ;
        
        System.out.println ( test.getVariable( 1 ) ) ;
        System.out.println ( test.getVariable2 () ) ;
        test.doVoid();
    }
    
    private static class BaseAbstractClass {
        public String getVariable ( Integer i ) {
            System.out.println ( this ) ;
            return ( "in base" + i.toString() ) ;
        }
        
        public String getVariable2 () {
            System.out.println ( this ) ;
            return ( "in base variable2" ) ;
        }
        
        public void doVoid () {
            System.out.println ( "in doVoid method" ) ;
        }
    }
    
    private static class DerivedClass {
        public String getVariable () {
            return ( "in derived" ) ;
        }
    }
}
