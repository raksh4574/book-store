<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ENTER BOOK DETAILS</h1>
	<form action="insert">
		BOOK ID<input type="number" name="id">
		 BOOK NAME:<input type="text" name="name">
		  AUTHOR NAME:<input type="text" name="author">
		  NO OF PAGES:<input type="number" name="pages">
		PRICE:<input type="number" name="price">
		 <input type="submit" value="save">

	</form>

</body>
</html>