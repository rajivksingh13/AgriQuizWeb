<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./resources/styles/quiz.css" media="all"/>
<script type='text/javascript' src='./resources/js/jquery-1.10.2.js'></script> 
<script type='text/javascript' src='./resources/js/jquery-ui.js'></script>
<script type="text/javascript" src="./resources/js/Agri_Quiz_Admin.js"></script>
<script type="text/javascript" src="./resources/js/timer.js"></script>
</head>
<body>
<div class="quiz">
<a href="./AgriQuizAdmin">
<span>Welcome to Online Agri Quiz Admin</span>
</a>
</div>
<div id="userID" class="welcomeUser">Welcome &nbsp;<c:out value="${UserID}"/></div>
<div id="logout" class="logout">
<form:form action="logout" method="post">
<input type="submit" value="Logout">
</form:form>
</div>
<div id="nav"><tiles:insertAttribute name="navQuiz" /></div>

<div id="maincontent"><tiles:insertAttribute name="quizContent" /></div>
<div id="footer"><tiles:insertAttribute name="footer" /></div>
<%-- <div id="backgroundImg" class="backgroundImg">
<!--<img src="./resources/images/background.jpg" alt="Agri View">
-->
<h2 id="disabled"></h2>
<h2 id="test_status"></h2> <div id="test"></div> <div id="timer"><script type="text/javascript">window.onload = CreateTimer("timer", 30);</script></div>
<div id="questionId" class="questionId">
<form:form action="adminSubmitQuiz" method="post">
<c:forEach items="${list}" var="quest">     
   <p><c:out value="${quest.questionID}"/>.&nbsp;&nbsp;<c:out value="${quest.question}"/></p><!--
   <c:if test="${quest.question_type == 'Radio'}"> 
   --> <p><input type="radio" name="Option_${quest.questionID}" value="<c:out value="${quest.option_1}"/>"><c:out value="${quest.option_1}"/></input></p>
   <p><input type="radio" name="Option_${quest.questionID}" value="<c:out value="${quest.option_2}"/>"><c:out value="${quest.option_2}"/></input></p>
   <p><input type="radio" name="Option_${quest.questionID}" value="<c:out value="${quest.option_3}"/>"><c:out value="${quest.option_3}"/></input></p>
   <p><input type="radio" name="Option_${quest.questionID}" value="<c:out value="${quest.option_4}"/>"><c:out value="${quest.option_4}"/></input></p>
   <!-- 
   </c:if>
   --><!--<c:if test="${quest.question_type == 'CheckBox'}">
   <p><input type="checkbox" name="Option" value="<c:out value="${quest.option_1}"/>"><c:out value="${quest.option_1}"/></input></p>
   <p><input type="checkbox" name="Option" value="<c:out value="${quest.option_2}"/>"><c:out value="${quest.option_2}"/></input></p>
   <p><input type="checkbox" name="Option" value="<c:out value="${quest.option_3}"/>"><c:out value="${quest.option_3}"/></input></p>
   <p><input type="checkbox" name="Option" value="<c:out value="${quest.option_4}"/>"><c:out value="${quest.option_4}"/></input></p> 
   </c:if>
--></c:forEach>
<input type="submit" value="Submit">
 </form:form>
 </div>
 </div>
 <div id="footer"><tiles:insertAttribute name="footer" /></div> --%>
 </body>
 </html>