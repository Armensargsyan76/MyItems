<%@ page import="model.Item" %>
<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 13.09.2022
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<%
    List<Item> items = (List<Item>) request.getAttribute("items");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<body>
<a href="/user/add">register</a>
<a href="/login">login</a>

<div>
    <ul style="overflow: hidden">
        <li style="display: inline;margin-left: 40px"><a href="/home">ԳԼԽԱՎՈՐ</a></li>
        <% for (Category category : categories) {%>
        <li style="display: inline;margin-left: 40px"><a
                href="/home?categoryId=<%=category.getId()%> "><%=category.getName()%>
        </a>
        </li>
        <%}%>
    </ul>
</div>
<div>
    <%
        for (Item item : items) {%>

    <div style="width: 105px;float: left">
        <div>
            <%if (item != null) {%>
            <img src="/getImage?image=<%=item.getPicUrl()%>" width="100" height="100"/>
            <%} else { %>
            <img src="/image/defaultImage.png" width="100" height="100"/>

            <%}%>
        </div>

        <div>
            <span><%=item.getTitle()%>|<%=item.getPrice()%></span>
        </div>

    </div>

    <%
        }

    %>

</div>

</body>
</html>

