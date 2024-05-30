package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name").trim();
		String marks = req.getParameter("marks").trim();
		String std = req.getParameter("std").trim();
		
		int m = 0, s = 0;
		
		boolean flag = true;
		
		if(name.length() > 0 && name != null) {
			req.setAttribute("name", name);
		} else {
			flag = false;
			req.setAttribute("nameErr", "<font color='red'>Please enter your name</font>");
		}
		
		if(marks.length() > 0 && marks != null) {
			try {
				m = Integer.parseInt(marks);
				req.setAttribute("marks", m);
			} catch(Exception e) {
				flag = false;		
				req.setAttribute("marksErr", "<font color='red'>Please enter valide marks</font>");
			}
		} else {
			flag = false;
			req.setAttribute("marksErr", "<font color='red'>Please enter your marks</font>");
		}
		
		if(std.length() > 0 && std != null) {
			try {
				s = Integer.parseInt(std);
				req.setAttribute("std", s);
			} catch(Exception e) {
				flag = false;
				req.setAttribute("stdErr", "<font color='red'>Please enter valide standard.</font>");
			}
		} else {
			flag = false;
			req.setAttribute("stdErr", "<font color='red'>Please enter you standard.</font>");
		}
		
		if(flag) {
			StudentBean sbean = new StudentBean(m, s, name);
			StudentDao sdao = new StudentDao();
			int rowsAffected = sdao.insertQry(sbean);
			
			if(rowsAffected > 0) {
				req.getRequestDispatcher("DisplayAllStudentsServlet").forward(req, resp);
			} else {
				out.print("<font color='red'>Some error occured.</font>");
			}
		} else {
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
