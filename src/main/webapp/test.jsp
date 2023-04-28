<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/11/6
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #hidden {
            overflow: hidden;
            height: 0;
            width: 0;
        }

        .card {
            padding: 10px;
            background: lightyellow;
            border: 4px solid lightyellow;
            /*设置左上角*/
            /*设置右上角*/
            /*设置左下角*/
            /*设置右下角*/
            border-radius: 10px;
            box-shadow: 3px 3px 20px #000;
            margin-left: 30px;
            margin-right: 30px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div>考生: ${name}&nbsp;&nbsp;&nbsp;&nbsp; 科目:${subject}</div>
<center>
    <h1>在线测试题</h1>
    <form action="ScoreResultServlet" method="post">

        <table>
            <% int i = 0, n = 0; %>
            <c:forEach items="${list}" var="list">

                <tr>

                    <!-- 获取题目和选项  -->
                    <td>
                        <div class="card">
                            <% out.print(++i + ".  "); %>${list.question} &nbsp;&nbsp;&nbsp;&nbsp;
                            <% out.print("（"); %>${list.score} <% out.print("分）"); %><br/>
                                <%-- 第一个默认选中隐藏 --%>
                            <div><input type="radio" id="hidden" checked value="0" name="<%= n %>"></div>
                            <input type="radio" value="1" name="<%= n %>">&nbsp;&nbsp;A. ${list.xx1}<br/>
                            <input type="radio" value="2" name="<%= n %>">&nbsp;&nbsp;B. ${list.xx2}<br/>
                            <input type="radio" value="3" name="<%= n %>">&nbsp;&nbsp;C. ${list.xx3}<br/>
                            <input type="radio" value="4" name="<%= n++ %>">&nbsp;&nbsp;D. ${list.xx4}<br/><br/>
                            <input type="hidden" name="score" value="${list.score}">
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <input type="hidden" name="sum" value="${number}">
            <input type="hidden" name="name" value="${name}">
            <input type="hidden" name="subject" value="${subject}">
        </table>

        <button type="submit">提交</button>

    </form>
</center>
</body>
</html>
