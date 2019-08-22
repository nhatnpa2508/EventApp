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
<form method="post">
    <fieldset>
        <legend>Event info</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td><a name="id" id="id">${requestScope["event"].getId()}</a></td>
            </tr>
            <tr>
                <th>Name Event</th>
                <td>${requestScope["event"].getName_event()}</td>
            </tr>
            <tr>
                <th>Place</th>
                <td>${requestScope["event"].getPlace()}</td>
            </tr>
            <tr>
                <th>Day Organize</th>
                <td>${requestScope["event"].getDay_organize()}</td>
            </tr>
            <tr>
                <th>Organizer</th>
                <td>${requestScope["event"].getOrganizer()}</td>
            </tr>
            <tr>
                <th>Introduce</th>
                <td>${requestScope["event"].getIntroduce()}</td>
            </tr>
            <tr>
                <th>Detailed Program</th>
                <td>${requestScope["event"].getDetailed_program()}</td>
            </tr>
            <tr>
                <th>Category</th>
                <td>${requestScope["event"].getName_Category()}</td>
            </tr>
            <tr>
                <th>Is Soft Delete</th>
                <td>${requestScope["event"].getIs_delete()}</td>
            </tr>
            <tr>
                <th>Post Date</th>
                <td>${requestScope["event"].getPost_date()}</td>
            </tr>
            <tr>
                <th>Last Edited Date</th>
                <td>${requestScope["event"].getLast_edited_date()}</td>
            </tr>
            <tr>
                <th>Admin</th>
                <td>${requestScope["event"].getName_Admin()}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
