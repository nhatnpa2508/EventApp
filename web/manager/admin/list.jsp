<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/4/2019
  Time: 4:49 PM
  Email: nhatnpa2508@gmail.com
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1px" style="border-collapse: collapse" >
        <tr>
            <th>STT</th>
            <th>Username</th>
            <th>Full Name</th>
            <th>Date of Birth</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Create Date</th>
            <th>Last Edit Date</th>
            <th>EDIT</th>
        </tr>
        <c:forEach items='${requestScope["admins"]}' var="admin">
            <tr>
                <td><a>${admin.getId()}</a></td>
                <td><a href="/admins?action=view&id=${admin.getId()}">${admin.getUsername()}</a></td>
                <th>${admin.getFullName()}</th>
                <td>${admin.getDayOfBirth()}</td>
                <td>${admin.getPhone()}</td>
                <td>${admin.getEmail()}</td>
                <td>${admin.getAddress()}</td>
                <td>${admin.getCreate_date()}</td>
                <td>${admin.getLast_edited_date()}</td>
                <td><a href="/admins?action=edit&id=${admin.getId()}">Info </a>|<a
                        href="/admins?action=changePassword&id=${admin.getId()}"> Password</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
