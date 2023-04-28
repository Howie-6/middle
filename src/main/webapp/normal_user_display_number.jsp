<%@ page import="com.example.middle.bean.Student" %>
<%@ page import="com.example.middle.DAO.StudentInfoDAO" %><%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/10/28
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>按学号进行排序</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
</head>
<body>

<center>
    <div class="table-title">
        <h3>按学号排序</h3>
    </div>

    <a href="./stuDisplayScore">
        <button class="custom-btn btn-10">返回上一页</button>
    </a>

    <a href="./index.jsp">
        <button class="custom-btn btn-10">返回到首页</button>
    </a>
</center>
<table border="1" align="center" class="table-fill">
    <thead>
    <tr>
        <th class="text-left">学号</th>
        <th class="text-left">姓名</th>
        <th class="text-left">语文</th>
        <th class="text-left">数学</th>
        <th class="text-left">英语</th>
        <th class="text-left">总分</th>
        <th class="text-left">排名</th>
    </tr>
    </thead>
    <tbody class="table-hover">
    <c:forEach items="${list3}" var="student3">

        <tr>
            <td>${student3.number}</td>
            <td>${student3.name}</td>
            <td>${student3.chinese}</td>
            <td>${student3.math}</td>
            <td>${student3.english}</td>
            <td>${student3.chinese+student3.math+student3.english}</td>
            <td>${student3.ranks}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
