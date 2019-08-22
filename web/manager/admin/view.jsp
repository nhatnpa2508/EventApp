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
    <p>
        <a href="/admins"  class="btn btn-success">Back to Admin List</a>
    </p>
    <fieldset>
        <legend>Admin info</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td>${requestScope["admin"].getId()}</td>
            </tr>
            <tr>
                <td>Username:</td>
                <td>${requestScope["admin"].getUsername()}</td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td>${requestScope["admin"].getDayOfBirth()}</td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td>${requestScope["admin"].getPhone()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope["admin"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${requestScope["admin"].getAddress()}</td>
            </tr>
            <tr>
                <td>Create Date</td>
                <td>${requestScope["admin"].getCreate_date()}</td>
            </tr>
            <tr>
                <td>Last edited date</td>
                <td>${requestScope["admin"].getLast_edited_date()}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
