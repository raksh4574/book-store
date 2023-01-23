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
<h1>ENTER DETAILS TO UPDATE</h1>
	<form action="update2">
	<%Book b=(Book)request.getAttribute("book"); %>
		BOOK ID<input type="number" name="id" value="<%=b.getId()%>" readonly="readonly"><br>
		 BOOK NAME:<input type="text" name="name" value="<%=b.getName()%>"><br>
		  AUTHOR NAME:<input type="text" name="author" value="<%=b.getAuther()%>"><br>
		  NO OF PAGES:<input type="number" name="pages" value="<%=b.getPage()%>"><br>
		PRICE:<input type="number" name="price" value="<%=b.getPrice()%>"><br>
		 <input type="submit" value="update">
		 

	</form>



</body>
</html>