package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String nameErr = (String)req.getAttribute("nameErr");
		String marksErr = (String)req.getAttribute("marksErr");
		String stdErr = (String)req.getAttribute("stdErr");
		
		String name = (String)req.getAttribute("name");
		String marks = (String)req.getAttribute("marks");
		String std = (String)req.getAttribute("std");
		
		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter out = resp.getWriter();
		
		StudentDao sdao = new StudentDao();
		StudentBean sbean = sdao.displayOneStudent(id);
		
		out.print("<form method='post' action='UpdateDataServlet'>   ");
		out.print("<table>                                              ");
		out.print("	<tr>                                                ");
		out.print("		<td><label>ID : </label></td>            ");
		out.print("		<td><input type='text' name='id' value='"+sbean.getId()+"' readonly></td>        ");
		out.print("	</tr>                                               ");
		out.print("	<tr>                                                ");
		out.print("		<td><label>Enter name: </label></td>            ");
		out.print("		<td><input type='text' name='name' value='"+(name == null ? sbean.getName() : name)+"'></td>        ");
		out.print("		<td>"+(nameErr == null ? " " : nameErr)+"</td>        ");
		out.print("	</tr>                                               ");
		out.print("	<tr>                                                ");
		out.print("		<td><label>Enter marks: </label></td>           ");
		out.print("		<td><input type='text' name='marks' value='"+(marks == null ? sbean.getMarks() : marks)+"'></td>       ");
		out.print("		<td>"+(marksErr == null ? " " : marksErr)+"</td>        ");
		out.print("	</tr>                                               ");
		out.print("	<tr>                                                ");
		out.print("		<td><label>Enter Standard: </label></td>        ");
		out.print("		<td><input type='text' name='std' value='"+(std == null ? sbean.getStd() : std)+"'></td>         ");
		out.print("		<td>"+(stdErr == null ? " " : stdErr)+"</td>        ");
		out.print("	</tr>                                               ");
		out.print("	<tr>                                                ");
		out.print("		<td></td>                                       ");
		out.print("		<td><input type='submit'></td>                  ");
		out.print("	</tr>                                               ");
		out.print("</table>                                             ");
		out.print("</form>                                              ");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
