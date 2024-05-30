package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DisplayAllStudentsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		StudentDao sdao = new StudentDao();
		StudentBean sbean = null;
		ArrayList<StudentBean> s = sdao.displayAllStudents();
		
		HttpSession session = req.getSession();
		session.setAttribute("isActive", true);
		session.setAttribute("list", s);
		
		req.getRequestDispatcher("listStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
