<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>You Are Successfully Executed the SQL Query</h1> &nbsp;<c:out value="${executeQuery}"/>
<form method="GET">
<input type="button"  onclick="location.href='./AgriQuizAdmin'" value="Home">
</form>