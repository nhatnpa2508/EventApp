<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/2/2019
  Time: 5:17 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registrations List</title>
    <meta charset="utf-8">
</head>
<body>
<div>
    <h3>Registrations List</h3>
    <p>
        <a href="#">Back to admin page</a>
    </p>
</div>
<table border="1">
    <tr>
        <th>Event name</th>
        <th>Place</th>
        <th>Day Organize</th>
        <th>Register</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Content Registration</th>
        <th>Send invite</th>
    </tr>
    <c:forEach items="${requestScope['registrationsList']}" var="registrationsList">
        <tr>
            <td>${registrationsList.getName_event()}</td>
            <td>${registrationsList.getPlace()}</td>
            <td>${registrationsList.getDayOrganize()}</td>
            <td>${registrationsList.getName_subscriber()}</td>
            <td>${registrationsList.getEmail()}</td>
            <td>${registrationsList.getPhone()}</td>
            <td>${registrationsList.getContentRegistration()}</td>
            <td><a href="/EmailSendingServlet?action=&email=${registrationsList.getEmail()}">Send mail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
