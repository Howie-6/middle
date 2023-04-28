<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/11/7
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩结果</title>
    <style>
        body{
            padding: 40px;
        }
        .red{
            color: brown;
        }
    </style>
</head>
<body>

<%--<form action="" method="post">--%>
<center>


<h2 name="${name}">${name}，你好。</h2>
<h2 name="${subject}">你考的是${subject}，</h2>
<h2>你的得分为${result}</h2>
<a href="studentinformation.jsp">
    <button>继续考试</button>
</a>

<div class="red">该成绩不会上传数据（功能暂未开放，敬请期待）</div>
</center>
<%--    <h2>必须要考完剩下${count}场，否则成绩不能上传！</h2>--%>
<%--</form>--%>
</body>
</html>
