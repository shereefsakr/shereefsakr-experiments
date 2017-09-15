package jspproj;

import java.io.CharArrayWriter;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharResponseWrapper extends HttpServletResponseWrapper {
    private Writer output ;
    private PrintWriter otherOutput ;
    
    public CharResponseWrapper( HttpServletResponse response ) throws IOException {
        super ( response ) ;
        //this.output = response.getWriter() ;
        this.output = new CharArrayWriter () ;
    }
    
    public PrintWriter getWriter () {
    
        return ( this.otherOutput == null? new PrintWriter ( this.output ) : this.otherOutput ) ;
    }
    
    public String toString() {
        return ( this.output.toString()) ;
    }
}