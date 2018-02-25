<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.melpholan.Entity.Product" %>
<html>
<body>
<h1>PRODUCT NAME</h1>
<b>id: ${product.id}</b>
<b>name: ${product.name}</b>

<br/> price: <%=((Product)request.getAttribute("product")).getId()%>
<a href="index.jsp">main page</a>
</body>
</html>