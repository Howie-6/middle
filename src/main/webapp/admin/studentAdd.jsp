<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/10/28
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户信息</title>
    <link rel="stylesheet" type="text/css" href="../css/admin.css" />


</head>
<body>
<center>
    <h2>添加用户信息</h2>
    <div class="container">
        <form id="contact" action="../StuAdd" method="post" onsubmit="return validateForm()">
            <%-- 不用输入id，因为是"自动递增的" --%>
            <p><input placeholder="Your name" type="text" name="name"></p>
            <p><input placeholder="Chinese" type="text" name="chinese"></p>
            <p><input placeholder="Math" type="text" name="math"></p>
            <p><input placeholder="English" type="text" name="english"></p>

            <input type="submit" value="提交">
            <input type="reset" value="清空">

        </form>

    </div>
</center>

<script>
    function validateForm() {
        const chineseInput = document.getElementsByName('chinese')[0];
        const mathInput = document.getElementsByName('math')[0];
        const englishInput = document.getElementsByName('english')[0];

        const isNumber = /^\d+$/;

        // Additional validation for values between 0 and 100
        const isValidGrade = (grade) => {
            const numericGrade = parseInt(grade, 10);
            return isNumber.test(grade) && numericGrade >= 0 && numericGrade <= 100;
        };

        if (!isValidGrade(chineseInput.value)) {
            alert('Chinese成绩必须是一个有效的0到100之间的数字！');
            return false; // 阻止表单提交
        }

        if (!isValidGrade(mathInput.value)) {
            alert('Math成绩必须是一个有效的0到100之间的数字！');
            return false; // 阻止表单提交
        }

        if (!isValidGrade(englishInput.value)) {
            alert('English成绩必须是一个有效的0到100之间的数字！');
            return false; // 阻止表单提交
        }

        // 返回true允许表单提交
        return true;
    }
</script>
</body>

</html>
