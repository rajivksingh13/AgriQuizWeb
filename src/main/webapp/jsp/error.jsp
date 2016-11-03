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
</head>
<body>
<div id="header"><tiles:insertAttribute name="header" /></div>
<div id="nav"><tiles:insertAttribute name="navQuiz" /></div>
<div id ="errorPage" class="backgroundImg">
 <h1>Sorry You are at Agri Quiz Error Page</h1>
 <h4>Please Contact Admin</h4>
</div>
<div id="footer"><tiles:insertAttribute name="footer" /></div> 
</body>
</html>