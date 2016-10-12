<%-- 
    Document   : signup
    Created on : 12 Oct, 2016, 9:40:33 PM
    Author     : vishal
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up Page</title>
    </head>
    <body>
        <c:if test="${requestScope.error ne null}">
            <strong style="color:red">
                <c:out value="${requestScope.error}"></c:out>
                </strong>
        </c:if>
        <c:if test="${requestScope.success ne null}">
            <strong style="color:green">
                <c:out value="${requestScope.success}"></c:out>
                </strong>
        </c:if>

        <c:url value="/addUser" var="addUser"></c:url>
        <c:url value="/login" var="Login"></c:url>
        <%-- Sing up user --%>

        <form action='<c:out value="${addUser}"></c:out>' method="post">
            <table>
                <tr>
                    <td> Username:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>Firstname:</td>
                    <td><input type="text" name="firstname"></td>
                </tr>
                <tr>
                    <td>Lastname:</td>
                    <td><input type="text" name="lastname"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Sign up"></td>
                </tr>
            </table>

        </form>

    </body>
</html>
