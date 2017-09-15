package jspproj;

import java.io.IOException;

import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class HtmlCodeFilter implements Filter {
    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, 
                         FilterChain chain) throws IOException, 
                                                   ServletException {

        //chain.doFilter(request, response);

        //*
                         CharResponseWrapper wrapper = new CharResponseWrapper ((HttpServletResponse)response) ;

                         chain.doFilter( request , wrapper );
                         
                         //ServletOutputStream out = response.getOutputStream() ;
                         PrintWriter out = response.getWriter() ;
                         //PrintWriter out = wrapper.getWriter() ;
                         //response.

                         String scrambledHtmlCode = null ;

                         String htmlCode = wrapper.toString() ;

                         htmlCode = htmlCode.replace( '\r' , ' ') ;
                         htmlCode = htmlCode.replace( '\n' , ' ' ) ;

                         System.out.println ( htmlCode ) ;

                         String pre = "<script language=\"javascript\">\n" +
                         "\n" +
                         "document.write( unescape( \'" ;

                         scrambledHtmlCode = pre ;

                         for ( int index = 0 ; index < htmlCode.length() ; index++ ) {
                             char thisChar = htmlCode.charAt( index ) ;
                             String thisCharInHex = Integer.toHexString ( ( int ) thisChar ) ;

                             scrambledHtmlCode += ( "%" + thisCharInHex ) ;
                         }

                         String post = "\' ) );\n" +
                         "</script>" ;

                         scrambledHtmlCode += post ;

                         //out.write( scrambledHtmlCode);
                         out.print( scrambledHtmlCode );
                         out.close();
                         //*/
    }
}