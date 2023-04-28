<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/10/28
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生成绩排行</title>
    <script>
        var i = 1;
    </script>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
</head>
<body>

<center>
<div class="table-title">
    <h3>学生成绩排行</h3>
</div>

    <a href="./index.jsp">
        <button class="custom-btn btn-10">返回</button>
    </a>
    <a href="StuDisplayNum">
        <button class="custom-btn btn-10">按学号排序</button>
    </a>
</center>
<br/>
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
    <c:forEach items="${list2}" var="student">
        <tr>
            <td class="text-left">${student.number}</td>
            <td class="text-left">${student.name}</td>
            <td class="text-left">${student.chinese}</td>
            <td class="text-left">${student.math}</td>
            <td class="text-left">${student.english}</td>
            <td class="text-left">${student.chinese+student.math+student.english}</td>
            <td class="text-left">
                <script type="text/javascript">
                    document.write(i++);
                </script>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>


