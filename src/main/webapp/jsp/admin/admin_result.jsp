<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./resources/styles/quiz.css" media="all"/>
<title>This is Agri Quiz Result Page</title>
</head>
<body>
<div class="quiz">
<a href="./AgriQuizAdmin">
<span>Welcome to Online Agri Quiz</span>
</a>
</div>
<div id="userID" class="welcomeUser">Welcome &nbsp;<c:out value="${UserID}"/></div>
<div id="logout" class="logout">
<form:form action="logout" method="post">
<input type="submit" value="Logout">
</form:form>
</div>
<div id="nav"><tiles:insertAttribute name="navQuiz" /></div>
<div id ="resultPage" class="backgroundImg">
 <h1>You Are On Result Page</h1>
 <h4>Please Click Here to Check the Score::: &nbsp;<c:out value="${option}"/></h4>
 <div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>