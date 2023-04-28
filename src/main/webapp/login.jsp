<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/10/28
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<html>
<head>
    <title>Login</title>
    <script>
        window.onload = function() {

            var oBtn = document.getElementById("btn");

            oBtn.onclick = function() {
                var account = document.getElementById("account").value;
                // console.log(account.value);
                var password = document.getElementById("password").value;
                // console.log(password.value);
                if (account == "howie" && password == "123456") {
                    window.alert("密码输入正确！");
                    window.open("stuDisplay", "_self");
                } else {
                    window.alert("密码输入错误或者账号不存在！")
                }
            };
        }

    </script>
</head>
<body>

<div class="login-box">
    <h2>Login</h2>
    <form method="post">
        <div class="user-box">
            <input id="account" type="text" name="" required="">
            <label>Username</label>
        </div>
        <div class="user-box">
            <input id="password" type="password" name="" required="">
            <label>Password</label>
        </div>
        <a id="btn">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Submit
        </a>
    </form>
</div>

</body>
</html>
