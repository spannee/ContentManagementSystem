package com.igate.isr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter 
{

	public void init(FilterConfig arg0) throws ServletException {
			
	}	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		if (request.getRequestURI().equals(request.getContextPath()+"/web/jsp/Login.jsp")==true) {

			chain.doFilter(req, res);

		} 
		else if(request.getRequestURI().equals(request.getContextPath()+"/web/jsp/Registration.jsp")==true){
			chain.doFilter(req, res);
		}
		else if(request.getRequestURI().equals(request.getContextPath()+"/web/jsp/MainPage.jsp")==true){
			chain.doFilter(req, res);
		}
		else if(request.getRequestURI().equals(request.getContextPath()+"/web/jsp/SearchResult.jsp")==true){
			chain.doFilter(req, res);
		}
		else 
		{
			HttpSession session=request.getSession(false);
			if(session==null||session.getAttribute("EmpId")==null||session.getAttribute("UserName")==null)
			{
			
				response.sendRedirect(request.getContextPath()+"/web/jsp/MainPage.jsp");	
			}
			else
				{
					
					chain.doFilter(req, res);
				}
			
		}
}
		
	
	
	public void destroy() {
		
		
	}

	
}
