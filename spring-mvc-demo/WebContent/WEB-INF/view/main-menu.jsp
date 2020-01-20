<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p id="demo"></p>

<script>
function myFunction() {
	var a=5;b=6;
	c=a+b;
	document.getElementById("demo").innerHTML=c;
}
</script>
<h2>Spring MVC-demo HOme Page</h2>
<hr>

<button type="button" onclick="myFunction()">Click</button>
<a href ="hello/showForm"> Hello World Form</a>
<br><br>
<a href ="student/showForm"> Student Form</a>
<br><br>
<a href ="customer/showForm"> Customer Form</a>
</body>
</html>