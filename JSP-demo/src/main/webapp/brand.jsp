<%@ page import="java.util.List" %>
<%@ page import="com.itYan.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: cloud
  Date: 2023/2/14
  Time: 上午 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //查詢數據庫
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1, "三隻松鼠", "三隻松鼠", 100, "三隻松鼠，好吃不上火", 1));
    brands.add(new Brand(2, "優衣褲", "優衣褲", 10, "優衣褲，服適人生", 0));
    brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "為發燒而生", 1));
%>
<html>
<head>
    <title>Brand</title>
</head>
<body>
<input type="button" value="新增"><br>

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

    <%--        <tr align="center">--%>
    <%--            <td>1</td>--%>
    <%--            <td>三隻松鼠</td>--%>
    <%--            <td>三隻松鼠</td>--%>
    <%--            <td>100</td>--%>
    <%--            <td>三隻松鼠，好吃不上火</td>--%>
    <%--            <td>啟用</td>--%>
    <%--            <td><a href="#">修改</a><a href="#">刪除</a></td>--%>
    <%--        </tr>--%>

    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>
    <tr align="center">
        <td><%=brand.getId()%>
        </td>
        <td><%=brand.getBrandName()%>
        </td>
        <td><%=brand.getCompanyName()%>
        </td>
        <td><%=brand.getOrdered()%>
        </td>
        <td><%=brand.getDescription()%>
        </td>
        <%
            if (brand.getStatus() == 1) {
        %>
        <td><%="啟用"%>
        </td>
        <%
        } else {
        %>
        <td><%="禁用"%>
        </td>
        <%
            }
        %>
        <td><a href="#">修改</a><a href="#">刪除</a></td>
    </tr>
    <%
        }
    %>


</table>
</body>
</html>
