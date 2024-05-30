<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
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
	if(session.getAttribute("isActive") != null) {
		System.out.println("List: " + session.getAttribute("list"));
		if(session.getAttribute("list") != null) {
%>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Marks</th>
				<th>Std</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<% 
			ArrayList<StudentBean> s = (ArrayList<StudentBean>)session.getAttribute("list");
			for(int i = 0; i < s.size(); i++) {
				StudentBean stu = s.get(i);
		%>
			<tr>
				<td><%= stu.getId() %></td>
				<td><%= stu.getName() %></td>
				<td><%= stu.getMarks() %></td>
				<td><%= stu.getStd() %></td>
				<td><a href='DeleteStudentServlet?id=<%=stu.getId()%>'>Delete</a> | <a href='UpdateStudentServlet?id=<%=stu.getId()%>'>Update</a></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
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