<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header_Col" class="header_Col">
<div class="h1">
<a href="./AgriQuizAdmin">
<span>Welcome to Online Agri Quiz Admin Page</span>
</a>
</div>
<div id="loginSec">
<form:form action="LoginAdmin" method="post">
<b>User Id:</b>  &nbsp;&nbsp;&nbsp;<input type="text" name="uID"></input>

<b>Password:</b>  <input type="password" name="pawd"></input>
<c:out value="${errorMsg}"/>
<c:out value="${errorMsg1}"/>
</br></br>
<input type="submit" value="Login">
&nbsp;&nbsp;
<input type="button"  onclick="location.href='./adminRegister'" value="Register">
</form:form>
<a href="#">Forget Password</a>
</div>
</div>
</div>
