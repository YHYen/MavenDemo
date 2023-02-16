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
    <title>JSTL-forEach</title>
</head>
<body>

<h1>${user.username}, 歡迎您</h1>

<input type="button" value="新增" id="add"><br>

<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序號</th>
        <th>品牌名稱</th>
        <th>企業名稱</th>
        <th>排序</th>
        <th>狀態</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
<%--            <td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>啟用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>
            <td><a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a><a href="/brand-demo/deleteByIdServlet?id=${brand.id}">刪除</a></td>
        </tr>
    </c:forEach>

</table>

<script>
    document.getElementById("add").onclick = function () {
        location.href = "/brand-demo/addBrand.jsp";
    }
</script>
</body>
</html>
