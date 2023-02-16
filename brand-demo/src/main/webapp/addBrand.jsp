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
    <title>添加品牌</title>
</head>
<body>
  <h3>添加品牌</h3>
  <form action="/brand-demo/addServlet" method="post">
    品牌名稱: <input name="brandName"><br>
    企業名稱: <input name="companyName"><br>
    排序: <input name="ordered"><br>
    描述信息: <textarea rows="5" cols="20" name="description"></textarea><br>
    狀態: <input type="radio" name="status" value="0">禁用
          <input type="radio" name="status" value="1">啟用<br>

    <input type="submit" value="提交">
  </form>
</body>
</html>
