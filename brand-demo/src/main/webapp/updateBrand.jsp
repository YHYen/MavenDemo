<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cloud
  Date: 2023/2/14
  Time: 下午 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改品牌</title>
</head>
<body>
  <h3>修改品牌</h3>
  <form action="/brand-demo/updateServlet" method="post">
    <%--  隱藏域 用來傳送id  --%>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名稱: <input name="brandName" value="${brand.brandName}"><br>
    企業名稱: <input name="companyName" value="${brand.companyName}"><br>
    排序: <input name="ordered" value="${brand.ordered}"><br>
    描述信息: <textarea rows="5" cols="20" name="description"> ${brand.description} </textarea><br>
    狀態:
    <c:if test="${brand.status == 0}">
      <input type="radio" name="status" value="0" checked="checked">禁用
      <input type="radio" name="status" value="1">啟用<br>
    </c:if>
    <c:if test="${brand.status == 1}">
      <input type="radio" name="status" value="0">禁用
      <input type="radio" name="status" value="1" checked="checked">啟用<br>
    </c:if>


    <input type="submit" value="提交">
  </form>
</body>
</html>
