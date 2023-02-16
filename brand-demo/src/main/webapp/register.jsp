<%--
  Created by IntelliJ IDEA.
  User: cloud
  Date: 2023/2/14
  Time: 下午 05:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>

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
        <form action="/brand-demo/registerServlet" method="post">
            <h3> Join us ! </h3>

            <input type="text" required name="username" maxlength="16" placeholder="enter your account" class="input">
            <div id="username_error">${registerMsg}</div>
            <input type="email" required name="email" maxlength="50" placeholder="enter your email" class="input">
            <input type="password" required name="password" maxlength="30" placeholder="enter your password" class="input">
            <input type="password" required name="confirm_password" maxlength="30" placeholder="confirm your password" class="input">
            <input type="text" required name="checkCode" id="checkCode" class="input">
            <img src="/brand-demo/checkCodeServlet" id="checkCodeImage">
            <a href="#" id="changelog">看不清?</a>
            <p>already have an account? <a href="login.jsp">login now</a></p>
            <input type="submit" value="Register" name="submit" class="btn">

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

    document.getElementById("changelog").onclick = function () {
        document.getElementById("checkCodeImage").src = "/brand-demo/checkCodeServlet?" + new Date().getMilliseconds();
    }

    document.getElementById("checkCodeImage").onclick = function () {
        document.getElementById("checkCodeImage").src = "/brand-demo/checkCodeServlet?" + new Date().getMilliseconds();
    }
</script>
</body>
</html>
