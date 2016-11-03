<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./resources/styles/quiz.css" media="all"/>
</head>
<body>
<div id="header"><tiles:insertAttribute name="header" /></div>
<div id="nav"><tiles:insertAttribute name="navQuiz" /></div>
<div id="reg" style="margin-left: 212px;"><h1>Welcome to Registration !!!</h1>
<form:form action="SuccessReg" method="post">
<b>User Id:</b>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="uID"></input>
</br></br>
<b>Password:</b>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pawd"></input>
</br></br>
<b>Confirm Password:</b>  <input type="password" name="pawd"></input>
</br></br>
<b>User Type:</b> <select id="UserType" name="UserType">
  <option value="None">--- Select ---</option>
  <option value="Admin">admin</option>
  <option value="Student">student</option>
</select>
</br></br></br>
<input type="submit"  value="Register">
<input type="button"  onclick="location.href='./AgriQuizAdmin'" value="Home">
</form:form>
</div>
<div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>
    