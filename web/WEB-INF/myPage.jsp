<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page import="model.Item" %><%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 13.09.2022
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Items</title>
</head>
<%
    User user = (User) session.getAttribute("user");
    List<Item> items = (List<Item>) request.getAttribute("items");
%>
<body>
Hello <span><%=user.getName()%></span>

<a href="/item/add">add item</a>

<a href="/logout">logout</a><br>

<a href="/myItems">my items
    <%if (items != null) { %>
    <table border="1">
        <tr>
            <th>title</th>
            <th>price</th>
            <th>category</th>
            <th>image</th>
        </tr>
        <% for (Item item : items) { %>
        <tr>
            <td><%=item.getTitle()%>
            </td>
            <td><%=item.getPrice()%>
            </td>
            <td><%=item.getCategory().getName()%>
            </td>
            <td><% if (item.getPicUrl() == null || item.getPicUrl().length() == 0) { %>
                <img src="/image/defaultImage.png" width="100">
                <% } else { %>
                <img src="${pageContext.request.contextPath}/getImage?image=<%=item.getPicUrl()%>" width="100"><br>
                <% } %>
            </td>
            <td>
                <a href="/item/delete?itemId=<%=item.getId()%>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    <%
        }
    %>
</a>

</body>

</html>
