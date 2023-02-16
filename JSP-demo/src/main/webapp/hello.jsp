<%--
  Created by IntelliJ IDEA.
  User: cloud
  Date: 2023/2/14
  Time: 上午 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello jsp</title>
</head>
<body>
<h1>hello jsp</h1>

<%
    System.out.println("Hello JSP");
    int i = 3;
%>

<%="hello"%>
<%=i%>

<%!
    void show() {
    }

    String name = "Xiu";
%>

</body>
</html>
