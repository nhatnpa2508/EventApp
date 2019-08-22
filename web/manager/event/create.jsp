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
<div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <h3 class="navbar-brand" href="#">Edit Post</h3>
    </nav><br>
</div>

<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<ul class="nav nav-pills flex-column">
    <li class="nav-item">
        <a href="/events" class="nav-link bg-secondary"  style="color: aliceblue;">Back to Event list</a><br>
    </li>
</ul>

<form method="post">
    <fieldset>
        <legend>EDIT A EVENT</legend>
        <table>
            <tr>
                <th>Name Event</th>
                <td><input type="text" name="name_event" id="name_event"></td>
            </tr>
            <tr>
                <th>Image</th>
                <td>
                    <input type="text" name="image" id="image">
                </td>
            </tr>
            <tr>
                <th>Image Note</th>
                <td>
                    <input type="text" name="image_note" id="image_note" >
                </td>
            </tr>
            <tr>
                <th>Place</th>
                <td><input type="text" name="place" id="place"></td>
            </tr>
            <tr>
                <th>Day Organize</th>
                <td><input type="text" name="day_organize" id="day_organize"></td>
            </tr>
            <tr>
                <th>Organizer</th>
                <td><input type="text" name="organizer" id="organizer" ></td>
            </tr>
            <tr>
                <th>Introduce</th>
                <td><input type="text" name="introduce" id="introduce" ></td>
            </tr>
            <tr>
                <th>Detailed Program</th>
                <td><input type="text" name="detailed_program" id="detailed_program" ></td>
            </tr>
            <tr>
                <th>Category</th>
                <td><input type="text" name="category" id="category" ></td>
            </tr>
        </table>
        <input type="submit" value="Update Event" class="btn btn-success">
    </fieldset>
</form>
</body>
</html>
