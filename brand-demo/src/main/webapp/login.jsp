<%--
  Created by IntelliJ IDEA.
  User: cloud
  Date: 2023/2/14
  Time: 下午 04:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>

    <!-- custom css file link -->
    <link rel="stylesheet" href="css/style.css">
    <!-- custom js file link -->
    <script src="js/script.js"></script>

</head>
<body>
<!-- header section starts -->
<div include-html="header_user_unlogin.html"></div>
<!-- header section ends -->

<!-- login section starts -->
<div class="account-form-container">
    <section class="account-form">
        <form action="/brand-demo/loginServlet" method="post">
            <h3> Welcome Back ! </h3>
            <div id="errorMsg">${loginMsg} ${registerMsg}</div>
            <input type="text" required name="username" value="${cookie.username.value}${username}" maxlength="16" placeholder="enter your account" class="input">
            <input type="password" required name="password" value="${cookie.password.value}" maxlength="30" placeholder="enter your password" class="input">
            <p>Remember me:<input id="remember" name="remember" type="checkbox" value="0"></p>
            <p>don't have an account? <a href="register.jsp">register now</a></p>
            <input type="submit" value="Login Now" name="submit" class="btn">

        </form>
    </section>
</div>

<!-- login section ends -->

<!-- footer section starts -->
<div include-html="footer_unlogin.html"></div>
<!-- footer section ends -->



<!-- loading js method -->
<script>
    includeHTML();
</script>
</body>
</html>
