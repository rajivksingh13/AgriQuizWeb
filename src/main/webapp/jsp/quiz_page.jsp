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
<script type='text/javascript' src='./resources/js/jquery-1.10.2.js'></script> 
<script type='text/javascript' src='./resources/js/jquery-ui.js'></script>
<script type="text/javascript" src="./resources/js/Agri_Quiz.js"></script>
<script type="text/javascript" src="./resources/js/timer.js"></script>
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
<div id="timer" class="timer"><script type="text/javascript">window.onload = CreateTimer("timer", 600);</script></div>
<div id="instr" class="instr">
<p id="quizID"><c:out value="${course_type}"/></p>Quiz.
<p class="mx-green mx-bold mx-uline">Instruction:</p>
            <ul class="ul-test-instruction">
            <li>Total number of questions : <b>15</b>.</li>
            <li>Time alloted : <b>10</b> minutes.</li>
            <li>Each question carry 1 mark, no negative marks.</li>
            <li>DO NOT refresh the page.</li>
            <li>All the best :-).</li>
            </ul>
            </div>
<div id="startq" class="startq">
<!--<form:form action="startQuiz" method="post">
--><input type="button" value="Start Quiz" id="start_quiz">
<br/><br/><br/><br/><br/><br/>
<!--</form:form>
--></div>
<div id="questionId" class="questionId"> 
</div>
<div id="buttonId" class="buttonId">
<input type="button" value="Prev" id="prev" class="prev">
<input type="button" value="Next" id="next" class="next1">
<input type="button" value="Submit" id="submit" class="submitbtn"> 
</div>
<div id="result" class="result">
</div>
<div id="showAnswer" class="showAnswer">
<input type="button" value="Show Answers" id="showans" class="showansbtn">
</div>
<div id="retakeQuiz" class="retakeQuiz">
<input type="button" value="ReTake-Quiz" id="retakeQ" class="retakeQ" onclick="location.href='./AgriQuiz'">
</div>  
<div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>