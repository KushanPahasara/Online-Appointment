<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
     
</head>
<body>
<p>${feebackMessage}</p>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="hidden" name="actiontype" value="login"/>
        <input type="submit" value="Login">
    </form>
</body>
</html>
