package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentRegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String nameErr = (String)req.getAttribute("nameErr");
		String marksErr = (String)req.getAttribute("marksErr");
		String stdErr = (String)req.getAttribute("stdErr");

		String name = (String)req.getAttribute("name");
		String marks = (req.getAttribute("marks") == null ? null : req.getAttribute("marks").toString().trim());
		String std = (req.getAttribute("std") == null ? null : req.getAttribute("std").toString().trim());
		
		System.out.println(name);
		System.out.println(marks);
		System.out.println(std);
		
		out.print("<html>");
		out.print("<form method='post' action='InsertStudentServlet'> ");
		out.print("<table>                                            ");
		
		out.print("	<tr>                                              ");
		out.print("		<td><label>Enter name: </label></td>          ");
		out.print("		<td><input type='text' name='name' value='"+ (name == null ? " " : name) +"'></td>      ");
		out.print("		<td>"+ (nameErr == null ? " " : nameErr)  +"</td>      ");
		out.print("	</tr>                                             ");
		
		out.print("	<tr>                                              ");
		out.print("		<td><label>Enter marks: </label></td>         ");
		out.print("		<td><input type='text' name='marks' value='"+ (marks == null ? " " : marks) +"'></td>     ");
		out.print("		<td>"+ (marksErr == null ? " " : marksErr) +"</td>     ");
		out.print("	</tr>                                             ");
		
		out.print("	<tr>                                              ");
		out.print("		<td><label>Enter Standard: </label></td>      ");
		out.print("		<td><input type='text' name='std' value='"+ (std == null ? " " : std) +"'></td>       ");
		out.print("		<td>"+ (stdErr == null ? " " : stdErr) +"</td>       ");
		out.print("	</tr>                                             ");
		
		out.print("	<tr>                                              ");
		out.print("		<td></td>                                     ");
		out.print("		<td><input type='submit'></td>                ");
		out.print("		<td></td>                                     ");
		out.print("	</tr>                                             ");
		
		out.print("</table>                                           ");
		out.print("</form>                                            ");

		out.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
