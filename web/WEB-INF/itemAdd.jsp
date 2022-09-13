<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 13.09.2022
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>

<%
    List<Category> categoryList = (List<Category>) request.getAttribute("categories");
%>

<body>
<form action="/item/add" method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="please input title"><br>
    <input type="number" name="price" placeholder="please input price"><br>
    please choose category
    <select name="categoryId">
        <% for (Category category : categoryList) { %>
        <option value="<%=category.getId()%>"><%=category.getName()%>
        </option>
        <% } %>
    </select>
    <input type="file" name="image">
    <input type="submit" name="add">
</form>
</body>
</html>
