<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/11/5
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加题目</title>
    <link rel="stylesheet" type="text/css" href="./css/add_questions_btn.css">
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <%--    <link rel="stylesheet" type="text/css" href="./css/table.css"/>--%>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <script>
        var textarea = document.querySelector('textarea');

        textarea.addEventListener('keydown', autosize);

        function autosize() {
            var el = this;
            setTimeout(function () {
                el.style.cssText = 'height:auto; padding:0';
                // for box-sizing other than "content-box" use:
                // el.style.cssText = '-moz-box-sizing:content-box';
                el.style.cssText = 'height:' + el.scrollHeight + 'px';
            }, 0);
        }
    </script>
</head>
<body>
<div class="container">
    <div style="text-align: center;">
        <h1>添加题目</h1>
        <br/>
        <a href="./stuDisplay">
            <button class="custom-btn btn-10">返回</button>
        </a>
    </div>
    <div class="row">

        <div class="col-sm-5 col-xs-12">

            <form action="./QuestionServlet" autocomplete="off">
                <input type="radio" hidden checked name="type" value=""/>

                <div class="base-info-item">
                    <%-- 默认选中：btn active --%>
                    <label class="btn">
                        <input type="radio" name='type' value="chinese"> <span> 语文 </span>
                    </label>
                    <label class="btn">
                        <input type="radio" name='type' value="math"><span> 数学 </span>
                    </label>
                    <label class="btn">
                        <input type="radio" name='type' value="english"><span> 英语</span>
                    </label>
                </div>

                <%--                <input type="radio" name="type" value="chinese"/><span>语文</span>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--                <input type="radio" name="type" value="math"/><span>数学</span>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--                <input type="radio" name="type" value="english"/><span>英语</span><br/>--%>


                <div class="form-group">
                    <lable for="subject">题目：</lable>
                    <textarea name="question" rows='2' placeholder='请添加题目'>${question}</textarea>
                </div>
                <div><input type="radio" class="hidden" name="key" checked value="0"/></div>
                <div class="form-group">
                    <lable for="event">选项1：</lable>
                    <input type="radio" name="key" value="1" style="zoom:2;"/>
                    <textarea name="choice1" rows='2' placeholder='请输入选项1'>${xx1}</textarea>
                </div>
                <div class="form-group">
                    <lable for="event2">选项2：</lable>
                    <input type="radio" name="key" value="2" style="zoom:2;"/>
                    <textarea name="choice2" rows='2' placeholder='请输入选项2'>${xx2}</textarea>
                </div>
                <div class="form-group">
                    <lable for="event3">选项3：</lable>
                    <input type="radio" name="key" value="3" style="zoom:2;"/>
                    <textarea name="choice3" rows='2' placeholder='请输入选项3'>${xx3}</textarea>
                </div>
                <div class="form-group">
                    <lable for="event4">选项4：</lable>
                    <input type="radio" name="key" value="4" style="zoom:2;"/>
                    <textarea name="choice4" rows='2' placeholder='请输入选项4'>${xx4}</textarea>
                </div>
                <div style="text-align: center;">
                    <button class="custom-btn btn-10 submit" type="submit" class="btn btn-primary">添加</button>
                    <div class="red">${wrong}</div>
                </div>
            </form>
        </div>

    </div>
</div>
<hr/>
</body>
</html>
