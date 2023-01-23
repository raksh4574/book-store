<%@page import="java.util.ArrayList"%>
<%@page import="com.pj.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="background: /black;">LIST OF ALL BOOKS</h1>
	<table border="2px solid black">
		<tr>
			<th>Book_ID</th>
			<th>Book_Name</th>
			<th>Author</th>
			<th>No.of_pages</th>
			<th>Price</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<% ArrayList<Book> books= (ArrayList)request.getAttribute("data");
	for(Book b:books){
%>
		<tr>
			<td><%= b.getId() %></td>
			<td><%=b.getName() %></td>
			<td><%=b.getAuther() %></td>
			<td><%=b.getPage() %></td>
			<td><%=b.getPrice() %></td>
			<td><a href="delete?id=<%=b.getId()%>">DELETE</a></td>
			<td><a href="update1?id=<%=b.getId()%>">Edit</a></td>
			
		</tr>
		<%} %>

	</table>
	<h1><a href="welcome.html">HOME</a></h1>

</body>
</html>