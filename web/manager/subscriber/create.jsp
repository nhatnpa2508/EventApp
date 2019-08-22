<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/2/2019
  Time: 5:18 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>CREATE SUBSCRIBER & REGISTRATION DETAIL</legend>
        <table>
            <tr>
                <th>Full Name</th>
                <td><input type="text" name="fullName" id="fullName"></td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" id="email">
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="phone" id="phone" >
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <th>Content Registration</th>
                <td><input type="text" name="content_registration" id="content_registration"></td>
            </tr>
        </table>
        <input type="submit" value="Update Event" class="btn btn-success">
    </fieldset>
</form>
</body>
</html>