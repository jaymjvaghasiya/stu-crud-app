<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>Username: </td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type='password' name='pass'></td>
			</tr>
			<tr>
				<td></td>
				<td><input type='submit' value='Submit'></td>
			</tr>
		</table>
	</form>
</body>
</html>