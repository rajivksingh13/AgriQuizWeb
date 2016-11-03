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
<a href="./AgriQuiz">
<span>Welcome to Online Agri Quiz</span>
</a>
</div>
<div id="userID" class="welcomeUser">Welcome &nbsp;<c:out value="${UserID}"/></div>
<div id="logout" class="logout">
<form:form action="userlogout" method="post">
<input type="submit" value="Logout">
</form:form>
</div>
<div id="nav"><tiles:insertAttribute name="navQuiz" /></div>
<div id ="resultPage" class="backgroundImg">
 <h1>You Are On Result Page</h1>
 <h4>Please Click Here to Check the Score::: &nbsp;<c:out value="${resultcount}"/>%</h4>
 <div id="resultDetail" class="resultDetail">
 <c:forEach items="${listdb}" var="quest" varStatus="i">
 <p><c:out value="${quest.questionID}"/>.&nbsp;&nbsp;<c:out value="${quest.question}"/></p>
 <p style="color:green">Correct Answer :<c:out value="${quest.answer_value}"/></p>
 <c:set value="${listOption}" var="listDet"/>
 <!--<c:forEach items="${listOption}" var="listDet" varStatus="listDet1">-->
 <c:if test="${quest.answer_value == listDet[i.index]}">
 <p style="color:red">Your Answer :<c:out value="${listDet[i.index]}"/></p>
</c:if>
<c:if test="${quest.answer_value != listDet[i.index]}">
 <p style="color:red">Your Answer :<c:out value="${listDet[i.index]}"/></p>
</c:if>
<!--</c:forEach>
 --></c:forEach>
 </div>
 <div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>