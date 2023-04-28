<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/10/28
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩信息修改</title>
    <link rel="stylesheet" type="text/css" href="./css/admin.css"/>
</head>
<body>
<center>
    <h2>学生成绩信息修改</h2>
    <div class="container">
        <form id="contact" action="StuUpdate" method="post">
            <%--    id不能修改，主键  藏起来  --%>
            <input type="hidden" name="number" value="${student.number}">
            <%--        不用输入id，因为是"自动递增的"--%>
            <p><input placeholder="修改名字" type="text" name="name" value="${student.name}"></p>
            <p><input placeholder="修改语文成绩" type="text" name="chinese" value="${student.chinese}"></p>
            <p><input placeholder="修改数学成绩" type="text" name="math" value="${student.math}"></p>
            <p><input placeholder="修改英语成绩" type="text" name="english" value="${student.english}"></p>

            <input type="submit" value="提交">
            <input type="reset" value="清空">
    </div>
    </form>
</center>
</body>
</html>
