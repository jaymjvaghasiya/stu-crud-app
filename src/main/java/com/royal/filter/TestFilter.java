package com.royal.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class TestFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		PrintWriter out = response.getWriter();)
		
//		Pre-filter code
		System.out.println("TestFilter --- Pre-filtering code");
		
		chain.doFilter(request, response);
		
//		Post-filter code
		System.out.println("TestFilter --- Post-filtering code");
		
	}
}
