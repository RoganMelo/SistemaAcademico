package br.edu.flf.sistemaAcademico.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value="/*", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class LoginFilter implements Filter {

    public LoginFilter() {   
    }   
  
    public void init(FilterConfig arg0) throws ServletException {   
    }   
  
    public void destroy() {   
    }   
  
    public void doFilter(ServletRequest request, ServletResponse response,   
            FilterChain chain) throws IOException, ServletException {  
    	
        HttpServletRequest hreq = (HttpServletRequest) request;   
        HttpServletResponse hresp = (HttpServletResponse) response;   
        HttpSession session = hreq.getSession();   
  
        String paginaAtual = new String(hreq.getRequestURL());   
  
        if (paginaAtual != null
        		&& (!paginaAtual.endsWith("index.jsp")
    					&& (!paginaAtual.endsWith("ServletLogin"))
    						&& (paginaAtual.endsWith(".jsp")))) {   
  
            if (session.getAttribute("usuariologado") == null) {
            	hresp.sendRedirect("index.jsp");   
            	return;   
            }
        }
        
        // deliver request to next filter   
        chain.doFilter(request, response);
    }   

}