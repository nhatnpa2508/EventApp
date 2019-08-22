<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/2/2019
  Time: 5:17 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Name Event</th>
        <th>Image</th>
        <th>Image Note</th>
        <th>Place</th>
        <th>Day Organize</th>
        <th>Organizer</th>
        <th>Introduce</th>
        <th>Detailed Program</th>
        <th>Category</th>
        <th>Is Soft Delete</th>
        <th>Post Date</th>
        <th>Last Edited Date</th>
        <th>Admin</th>
        <th>Edit</th>
        <th>Soft Delete/ Restore</th>
    </tr>
    <c:forEach items="${requestScope['events']}" var="event">
        <tr>
            <td>${event.getId()}</td>
            <td><a href="/events?action=view&id=${event.getId()}">${event.getName_event()}</a></td>
            <td>${event.getImage()}</td>
            <td>${event.getImage_note()}</td>
            <td>${event.getPlace()}</td>
            <td>${event.getDay_organize()}</td>
            <td>${event.getOrganizer()}</td>
            <td>${event.getIntroduce()}</td>
            <td>${event.getDetailed_program()}</td>
            <td>${event.getName_Category()}</td>
            <td>${event.getIs_delete()}</td>
            <td>${event.getPost_date()}</td>
            <td>${event.getLast_edited_date()}</td>
            <td>${event.getName_Admin()}</td>
            <td><a href="/events?action=edit&id=${event.getId()}">Edit</a></td>
            <td><a href="/events?action=delete&id=${event.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
