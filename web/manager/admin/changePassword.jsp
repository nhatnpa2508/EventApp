<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/5/2019
  Time: 5:32 AM
  Email: nhatnpa2508@gmail.com
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="js/checkInput.js"></script>
    <script>
        function check(input) {
            if (input.value != document.getElementById("password").value){
                input.setCustomValidity("Password must be Matching");
            }else {
                input.setCustomValidity('');
            }
        }
        function checkLong(input) {
            if (input.value.length < 6){
                input.setCustomValidity("Input must be more than 6 character");
            }else {
                input.setCustomValidity('');
            }
        }
    </script>
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
                <td>Username: </td>
                <td><a name = "username" id = "username">${requestScope["admin"].getUsername()}</a></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password" id="password" placeholder="enter user password"></td>
            </tr>
            <tr>
                <td>New Password: </td>
                <td><input type="password" name="newPassword" id="newPassword" placeholder="enter new password" required oninput="checkLong(this),checkNewPassword(this)"></td>
            </tr>
            <tr>
                <td>Re Enter New Password: </td>
                <td><input type="password" name="reNewPassword" id="reNewPassword" placeholder="re enter new password" oninput="check(this)"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update User"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
