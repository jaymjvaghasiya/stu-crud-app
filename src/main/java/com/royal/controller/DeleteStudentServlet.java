package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao sdao = new StudentDao();
		int rowsAffected = sdao.deleteQry(id);
		
		if(rowsAffected > 0) {
			req.getRequestDispatcher("DisplayAllStudentsServlet").forward(req, resp);
		} else {
			out.print("<font color='red'>Some error occured.</font>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
