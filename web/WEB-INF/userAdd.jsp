<%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 13.09.2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User register</title>
</head>
<body>
please input user's data
<form action="/user/add" method="post">
  <input type="text" name="name" placeholder="please input name"><br>
  <input type="text" name="surname" placeholder="please input surname"><br>
  <input type="email" name="email" placeholder="please input email"><br>
  <input type="password" name="password" placeholder="please input password">
  <input type="submit" name="register">
</form>
</body>
</html>
