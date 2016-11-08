<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./resources/styles/quiz.css" media="all"/>
</head>
<body id="backgroundImg" class="backgroundImg">
<h1>Welcome to SQL Query Creation Page !!!</h1>
<div id="reg">
<form:form action="executeQueryView" method="post">
<b>Provide the SQL Execution String Here:</b>&nbsp;&nbsp;&nbsp;<input type="text" name="tabCreate"></input>
</br></br>
<input type="submit"  value="Submit">
<input type="button"  onclick="location.href='./AgriQuizAdmin'" value="Home">
</form:form>
</div>
</body>
</html>
    