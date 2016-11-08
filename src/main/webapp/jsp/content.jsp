<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--<div id="loginSec" style="width: 290px;height: 200px;margin-top: -315px;margin-left: 86px;">
<form:form action="LoginQuiz" method="post">
<b>User Id:</b>  &nbsp;&nbsp;&nbsp;<input type="text" name="uID"></input>
</br></br>
<b>Password:</b>  <input type="password" name="pawd"></input>
<c:out value="${errorMsg}"/>
<c:out value="${errorMsg1}"/>
</br></br></br>
<input type="submit" value="Login">
&nbsp;&nbsp;
<input type="button"  onclick="location.href='/AgriQuizWeb/Register'" value="Register">
<input type="button"  onclick="location.href='/AgriQuizWeb/executeQuery'" value="Execute SQL Query">
</form:form>
<a href="#">Forget Password</a>
</div>
    -->
<c:if test="${isLogedIn == false}">   
<div id="backgroundImg" class="backgroundImg">
<div class="col-full">
<div class="col-446">
<h3>Secure Online Quiz Maker</h3>
<p>
The ClassMarker hosted Online Testing software is the best Quiz maker for teachers &amp; businesses. Used for business &amp;
training Tests; recruitment &amp; pre-employment assessments; health and safety quizzes; educational facilities, schools, universities,
distance learning, online courses, E-Learning, self-study groups, practice Tests &amp; more.
</p>
<p>
Optionally charge for your Exams, so you can <a href="https://www.classmarker.com/online-testing/manual/?trk=home#charge-for-exams">Sell Quizzes Online</a> and receive payments instantly from your Computer-Based Assessments.
</p>
<p>Custom web-based Testing services allow you to easily create &amp; give secure online Exams to your
exact requirements with features such as time limits, public &amp; private Test access, randomize Questions, instant feedback, multiple choice, short answer, essay &amp; more Question types.
</p>
<p class="site-features"><a href="https://www.classmarker.com/online-testing/quiz-features/#online-quiz-security">
<img class="security1" src="/img3/home/security1.png" alt="ClassMarker Security">
<img class="security2" src="/img3/home/security2.png" alt="ClassMarker Security"></a>
</p>
</div>
<div class="col-476">
<h3>Business &amp; Education plans</h3>
<p>
We understand every organization is different. That's why we've created affordable <a href="https://www.classmarker.com/online-testing/price">Online Testing Plans</a> to suit your needs. From occasional usage to bulk Testing requirements, we have you covered.
</p>
<h3>Quiz Maker API &amp; Webhooks</h3>
<p>
Need Test results integrated back into your website in real time? <br>
See our <a href="https://www.classmarker.com/online-testing/integrate/">Quiz maker API &amp; Webhooks</a> for an instant solution!
</p>
<h3>View Examples</h3>
<p>View Screenshots in our <a href="https://www.classmarker.com/online-testing/manual/?trk=home">User Manual</a> and <a href="https://www.classmarker.com/online-testing/video/?trk=home">How to Videos</a>.</p>
<p>Try our Sample <a href="https://www.classmarker.com/online-test/start/?quiz=fnx4e11c1f24bc57">Online Test</a>.</p>
</div>
<div class="join-box">
<a href="https://www.classmarker.com/register/?trk=homejoin" class="join-btn">Join</a>
the thousands of top professionals around the world &amp; start creating custom Online Quizzes today.
</div>
</div>
</div>
</c:if>
<c:if test="${isLogedIn == true}">

<img src="./resources/images/Agri_Quiz.jpg" alt="Agri View" id="Agri">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <input type="button" name="course" value="Agri" id="Agri"> -->

<img src="./resources/images/Maths_Quiz.png" alt="Agri View" id="Maths">

<!-- <input type="button" name="course" value="Maths" id="Maths"> -->
</c:if>