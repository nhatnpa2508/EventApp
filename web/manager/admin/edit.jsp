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
                <td>Full Name: </td>
                <td><input type="text" name="fullNam" id="fullName" value="${requestScope["admin"].getFullName()}"></td>
            </tr>
            <tr>
                <td>Birthday: </td>
                <td><input type="text" name="dayOfBirth" id="dayOfBirth" value="${requestScope["admin"].getDayOfBirth()}"></td>
            </tr>
            <tr>
                <td>Phone Number: </td>
                <td><input type="text" name="phone" id="phone" value="${requestScope["admin"].getPhone()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope["admin"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${requestScope["admin"].getAddress()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Admin information"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
