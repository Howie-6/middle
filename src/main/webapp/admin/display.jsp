<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/10/28
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生成绩信息修改界面</title>
    <link rel="stylesheet" type="text/css" href="./css/table.css"/>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>

<center>
    <div class="table-title">
        <h3>学生成绩信息修改界面</h3>
    </div>
</center>
<center>
    <a href="./admin/studentAdd.jsp">
        <button class="custom-btn btn-10" onclick="studentAdd.jsp">添加用户</button>
    </a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="./index.jsp">
        <button class="custom-btn btn-10">返回</button>
    </a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="AddQuestionFirst">
        <button class="custom-btn btn-10">添加题目</button>
    </a>
</center>
<br/>
<table border="1" align="center">
    <thead>
    <tr>
        <th class="text-left">学号</th>
        <th class="text-left">姓名</th>
        <th class="text-left">语文</th>
        <th class="text-left">数学</th>
        <th class="text-left">英语</th>
        <th class="text-left">操作</th>
    </tr>
    </thead>
    <tbody class="table-hover">
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.number}</td>
            <td>${student.name}</td>
            <td>${student.chinese}</td>
            <td>${student.math}</td>
            <td>${student.english}</td>
            <td><a href="StuModify?number=${student.number}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
                    href="stuDelete?number=${student.number}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
