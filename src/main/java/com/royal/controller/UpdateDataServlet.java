package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateDataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		boolean flag = false;
		int m = 0, s = 0;
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name").trim();
		String marks = req.getParameter("marks").trim();
		String std = req.getParameter("std").trim();
		
		if(name.trim().length() > 0 && name != null) {
			req.setAttribute("name", name.trim());
		} else {
			req.setAttribute("nameErr", "<font color='red'>Please enter your name</font>");
			flag = true;
		}
		System.out.println("pass 1");
		if(marks.trim().length() > 0 && marks != null) {
			try {
				m = Integer.parseInt(marks.trim());
				req.setAttribute("marks", marks.trim());
			} catch(Exception e) {
				req.setAttribute("marksErr", "<font color='red'>Please enter valide marks</font>");
				flag = true;
			}
		} else {
			req.setAttribute("marksErr", "<font color='red'>Please enter your marks</font>");
			flag = true;
		}
		System.out.println("pass 2");
		if(std.trim().length() > 0 && std != null) {
			try {
				s = Integer.parseInt(std.trim());
				req.setAttribute("std", std.trim());
			} catch(Exception e) {
				req.setAttribute("stdErr", "<font color='red'>Please enter valide standard.</font>");
				flag = true;
			}
		} else {
			req.setAttribute("stdErr", "<font color='red'>Please enter your standard.</font>");
			flag = true;
		}
		System.out.println("pass 3");
		if(flag) {
			System.out.println("Goes to UpdateStudentServlet");
			req.getRequestDispatcher("UpdateStudentServlet").forward(req, resp);
		} else {
			
			StudentBean sbean = new StudentBean(id, m, s, name);
			StudentDao sdao = new StudentDao();
			int rowsAffected = sdao.updateQry(sbean);
			
			if(rowsAffected > 0) {
				req.getRequestDispatcher("DisplayAllStudentsServlet").forward(req, resp);
			} else {
				out.print("Something went wrong.");
			}
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
