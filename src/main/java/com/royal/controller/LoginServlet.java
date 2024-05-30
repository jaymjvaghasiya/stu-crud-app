package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		boolean flag = false;
		
		if((username.trim().length() > 0 && username != null) && (pass.trim().length() > 0 && pass != null)) {
			
			if(username.equals("admin") && pass.equals("admin")) {
				
				HttpSession session = req.getSession();
				session.setAttribute("isActive", true);
				session.setAttribute("username", username);
				System.out.println("Attribute set.");
				System.out.println(session);
			} else {
				flag = true;
			}
			
		} else {
			flag = true;
		}
		
		if(flag) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
