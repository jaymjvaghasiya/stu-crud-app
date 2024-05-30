<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//	System.out.println(session.getAttribute("username"));
	if(session.getAttribute("isActive") != null) {
		if(session.getAttribute("username").equals("admin")) {
 %>
	<form method="post" action="InsertStudentServlet">
		<table>
			<tr>
				<td><label>Enter name: </label></td>
				<td><input type="text" name="name" value='${name}'></td>
				<td>${nameErr}</td>
			</tr>
			<tr>
				<td><label>Enter marks: </label></td>
				<td><input type="text" name="marks" value='${marks}'></td>
				<td>${marksErr}</td>
			</tr>
			<tr>
				<td><label>Enter Standard: </label></td>
				<td><input type="text" name="std" value='${std}'></td>
				<td>${stdErr}</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
<%
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
 	} else {
 		request.getRequestDispatcher("login.jsp").forward(request, response);
 	}
%>
</body>
</html>