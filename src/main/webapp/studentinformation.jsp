<%--
  Created by IntelliJ IDEA.
  User: howiema
  Date: 2022/11/6
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/heart.css">
<link rel="stylesheet" type="text/css" href="css/option.css">
<link rel="stylesheet" type="text/css" href="css/concise.css">

<html>
<head>
    <title>学生考试信息</title>
    <style>

        .red {
            color: brown;
        }

        .wrapper {
            height: 30vh;
            /*This part is important for centering*/
            display: grid;
            place-items: center;
        }

        .typing-demo {
            width: 22ch;
            animation: typing 2s steps(22), blink .5s step-end infinite alternate;
            white-space: nowrap;
            overflow: hidden;
            border-right: 3px solid;
            font-family: monospace;
            font-size: 2em;
        }

        @keyframes typing {
            from {
                width: 0
            }
        }

        @keyframes blink {
            50% {
                border-color: transparent
            }
        }

        /*  成绩榜  */

        h3::before {
            transform: scaleX(0);
            transform-origin: bottom right;
        }

        h3:hover::before {
            transform: scaleX(1);
            transform-origin: bottom left;
        }

        h3::before {
            content: " ";
            display: block;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            inset: 0 0 0 0;
            background: hsl(200 100% 80%);
            z-index: -1;
            transition: transform .3s ease;
        }

        h3 {
            position: relative;
            font-size: 3rem;
        }

        button {
            position: relative;
            padding: 1em 1.8em;
            outline: none;
            border: 1px solid #444;
            background: #282c34;
            color: #ae00ff;
            text-transform: uppercase;
            letter-spacing: 2px;
            font-size: 15px;
            overflow: hidden;
            transition: 0.2s;
            border-radius: 20px;
            cursor: pointer;
            font-weight: bold;
        }

        button:hover {
            box-shadow: 0 0 10px #ae00ff, 0 0 25px #001eff, 0 0 50px #ae00ff;
            transition-delay: 0.6s;
        }

        button span {
            position: absolute;
        }

        button span:nth-child(1) {
            top: 0;
            left: -100%;
            width: 100%;
            height: 2px;
            background: linear-gradient(90deg, transparent, #ae00ff);
        }

        button:hover span:nth-child(1) {
            left: 100%;
            transition: 0.7s;
        }

        button span:nth-child(3) {
            bottom: 0;
            right: -100%;
            width: 100%;
            height: 2px;
            background: linear-gradient(90deg, transparent, #001eff);
        }

        button:hover span:nth-child(3) {
            right: 100%;
            transition: 0.7s;
            transition-delay: 0.35s;
        }

        button span:nth-child(2) {
            top: -100%;
            right: 0;
            width: 2px;
            height: 100%;
            background: linear-gradient(180deg, transparent, #ae00ff);
        }

        button:hover span:nth-child(2) {
            top: 100%;
            transition: 0.7s;
            transition-delay: 0.17s;
        }

        button span:nth-child(4) {
            bottom: -100%;
            left: 0;
            width: 2px;
            height: 100%;
            background: linear-gradient(360deg, transparent, #001eff);
        }

        button:hover span:nth-child(4) {
            bottom: 100%;
            transition: 0.7s;
            transition-delay: 0.52s;
        }

        button:active {
            background: #ae00af;
            background: linear-gradient(to top right, #ae00af, #001eff);
            color: #bfbfbf;
            box-shadow: 0 0 8px #ae00ff, 0 0 8px #001eff, 0 0 8px #ae00ff;
            transition: 0.1s;
        }

        button:active
        span:nth-child(1)
        span:nth-child(2)
        span:nth-child(2)
        span:nth-child(2) {
            transition: none;
            transition-delay: none;
        }

    </style>
</head>
<body>
<center>
    <div class="wrapper">
        <div class="typing-demo">
            冷静思考，认真答题......
        </div>
    </div>


    <h3><a href="stuDisplayScore">成绩榜</a></h3>

    <div id="main-content">
        <div>
            <input type="checkbox" id="checkbox"/>
            <label for="checkbox">
                <svg
                        id="heart-svg"
                        viewBox="467 392 58 57"
                        xmlns="http://www.w3.org/2000/svg"
                >
                    <g
                            id="Group"
                            fill="none"
                            fill-rule="evenodd"
                            transform="translate(467 392)"
                    >
                        <path
                                d="M29.144 20.773c-.063-.13-4.227-8.67-11.44-2.59C7.63 28.795 28.94 43.256 29.143 43.394c.204-.138 21.513-14.6 11.44-25.213-7.214-6.08-11.377 2.46-11.44 2.59z"
                                id="heart"
                                fill="#AAB8C2"
                        />
                        <circle
                                id="main-circ"
                                fill="#E2264D"
                                opacity="0"
                                cx="29.5"
                                cy="29.5"
                                r="1.5"
                        />

                        <g id="grp7" opacity="0" transform="translate(7 6)">
                            <circle id="oval1" fill="#9CD8C3" cx="2" cy="6" r="2"/>
                            <circle id="oval2" fill="#8CE8C3" cx="5" cy="2" r="2"/>
                        </g>

                        <g id="grp6" opacity="0" transform="translate(0 28)">
                            <circle id="oval1" fill="#CC8EF5" cx="2" cy="7" r="2"/>
                            <circle id="oval2" fill="#91D2FA" cx="3" cy="2" r="2"/>
                        </g>

                        <g id="grp3" opacity="0" transform="translate(52 28)">
                            <circle id="oval2" fill="#9CD8C3" cx="2" cy="7" r="2"/>
                            <circle id="oval1" fill="#8CE8C3" cx="4" cy="2" r="2"/>
                        </g>

                        <g id="grp2" opacity="0" transform="translate(44 6)">
                            <circle id="oval2" fill="#CC8EF5" cx="5" cy="6" r="2"/>
                            <circle id="oval1" fill="#CC8EF5" cx="2" cy="2" r="2"/>
                        </g>

                        <g id="grp5" opacity="0" transform="translate(14 50)">
                            <circle id="oval1" fill="#91D2FA" cx="6" cy="5" r="2"/>
                            <circle id="oval2" fill="#91D2FA" cx="2" cy="2" r="2"/>
                        </g>

                        <g id="grp4" opacity="0" transform="translate(35 50)">
                            <circle id="oval1" fill="#F48EA7" cx="6" cy="5" r="2"/>
                            <circle id="oval2" fill="#F48EA7" cx="2" cy="2" r="2"/>
                        </g>

                        <g id="grp1" opacity="0" transform="translate(24)">
                            <circle id="oval1" fill="#9FC7FA" cx="2.5" cy="3" r="2"/>
                            <circle id="oval2" fill="#9FC7FA" cx="7.5" cy="2" r="2"/>
                        </g>
                    </g>
                </svg>
            </label>
        </div>
    </div>

    <form action="TestServlet" id="app-cover" method="post">

        <div class="formgroup" id="name-form">
            <label for="name">你的名字*</label>
            <input type="text" id="name" name="name" />
        </div>
<%--        <table>--%>
<%--            姓名：<input type="text" name="name"/>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        </table>--%>
        <div id="mainselection">
            <select id="test-select" name="subject">
                <option value="">--请选择考试科目--</option>
                <option value="chinese">语文</option>
                <option value="math">数学</option>
                <option value="english">英语</option>
            </select>
        </div>

        <button type="submit">
            <span></span>
            <span></span>
            <span></span>
            <span></span> 开始考试
        </button>
<%--        <input type="submit" value="开始考试"/>--%>
        <br/>
        <div class="red">${name_null}</div>
        <div class="red">${subject_null}</div>
    </form>

</center>
</body>
</html>
