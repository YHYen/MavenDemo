<%--
  Created by IntelliJ IDEA.
  User: cloud
  Date: 2023/2/14
  Time: 上午 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL-if</title>
</head>
<body>
<%--
     c:if : 替代 java if else
 --%>

<%--    <c:if test="true">--%>
<%--      <h1>True</h1>--%>
<%--    </c:if>--%>
<%--    <c:if test="false">--%>
<%--      <h1>False</h1>--%>
<%--    </c:if>--%>

<c:if test="${status == 1}">
    <h1>啟用</h1>
</c:if>
<c:if test="${status == 0}">
    <h1>禁用</h1>
</c:if>
</body>
</html>
