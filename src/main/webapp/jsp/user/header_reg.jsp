<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header_Col" class="header_Col">
<div class="h1">
<a href="http://localhost:9080/RestAPIWeb/AgriQuiz">
<span>Welcome to Online Agri Quiz</span>
</a>
</div>
<div id="loginSec">
<input type="submit" onclick="location.href='/RestAPIWeb/AgriQuiz'" value="Login">
&nbsp;&nbsp;
<input type="button"  onclick="location.href='/RestAPIWeb/Register'" value="Register">
</div>
</div>
