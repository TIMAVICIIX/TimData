<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>乐行学途</title>
    <link rel="icon" href="static/resources/index/LXXT_Logo.png">
    <link href="static/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="static/css/for_main.css" rel="stylesheet">
    <link href="static/css/thridPartFont.css" rel="stylesheet">
</head>
<body>

<div id="Background_Animation_Container"></div>

<nav class="navbar top-border">

    <div id="TopLogo&Title">

        <img class="d-inline-block" src="static/resources/index/LXXT_Logo.png"
             style="width: 100px;height: 120px;margin-left: 20px" alt="Logo">
        <p class="d-inline-block" style="font-size: 40px;color:#5F5F5F;margin-left: 20px">乐行学途</p>

    </div>

    <div class="mx-auto">
        <button id="LoginNavbarBtn" class="Navbar_Choosers">
            登录
            <img class="Navbar_Choose_Sign" src="static/resources/index/login.png" alt="Login">
        </button>
        <button id="QueryNavbarBtn" class="Navbar_Choosers">
            查看假期
            <img class="Navbar_Choose_Sign" src="static/resources/index/check.png" alt="Check">
        </button>
        <button id="AttendNavbarBtn" class="Navbar_Choosers">
            申请入学
            <img class="Navbar_Choose_Sign" src="static/resources/index/submit.png" alt="Submit">
        </button>
    </div>

    <button id="JoinUs">
        加入我们
        <img src="static/resources/index/JoinUs.png" alt="JoinUs">
    </button>


</nav>

<div id="Index_Container">

    <div id="Index_Login">

        <div id="Left_page">

            <div id="Left_Banner">

                <div id="BannerContainer">
                    <div id="Banner">
                        <div class="Banner_Content" style="background-image: url(static/resources/index/Education.jpg)">
                            <p>无偿提供教育资源</p>
                        </div>
                        <div class="Banner_Content" style="background-image: url(static/resources/index/Attend.jpg)">
                            <p>申请入学</p>
                        </div>
                        <div class="Banner_Content"
                             style="background-image: url(static/resources/index/Help&Inquire.jpg)">
                            <p>咨询与帮助</p>
                        </div>
                    </div>
                    <button id="NextBanner">
                    </button>
                    <button id="PervBanner">
                    </button>
                </div>

            </div>
            <div id="Inquire&Help">

                <div id="Inquire&Help_title">
                    <p><img src="static/resources/index/inquire.png" alt="inquire"
                            style="margin: 0 15px 5px 20px;width: 25px;height: 25px">帮助&公告</p>
                </div>
                <a class="Inquire&Help_content" href="Page_Help&Inquire/20231117_startedannounce.html" target="_blank">
                    <p class="IH_title">关于系统的启动发布公告</p>
                    <p class="IH_date">2023-11-17</p>
                </a>
                <a class="Inquire&Help_content" href="Page_Help&Inquire/20231121_help&inquire.html" target="_blank">
                    <p class="IH_title">0.5版本更新功能介绍与使用帮助</p>
                    <p class="IH_date">2023-11-21</p>
                </a>
            </div>

        </div>
        <div id="Right_page">

            <div id="Login_Area">
                <p id="Login_Title">账号密码登录</p>
                <form id="loginForm" action="<%=request.getContextPath()%>/index-controller" method="post">
                    <input id="login_account" name="login_account" class="Login_Input" placeholder="请输入学籍账号"
                           type="number">
                    <input id="login_password" name="login_password" class="Login_Input" style="margin-top: 50px"
                           placeholder="请输入密码"
                           type="password">
                    <div id="SecurityCheck">
                        <p>点击登录键即同意<a href="#">用户隐私政策</a>与<a href="#">服务条款</a></p>
                        <p id="login_tips" style="color:#ff0000;">密码错误!</p>
                    </div>
                    <input name="action" value="login" style="display: none">
                </form>
                <button id="LoginBtn">
                    登&nbsp;录
                </button>
            </div>

        </div>

    </div>

    <div id="Index_Query">

        <div id="filter_top">
            <div id="filter_area">
                筛选条件:
                <input id="filter_input" type="text" placeholder="假期名称/日期/学院/年份">
                <button id="filter_submit">
                    <img src="static/resources/index/filterChose.png" style="width: 25px;height: 25px" alt="submit">
                </button>
                <button id="filter_refresh">
                    刷新
                    <img src="static/resources/index/refresh.png" style="width: 15px; height: 15px" alt="refresh">
                </button>
            </div>
            <div id="time_recorder">
                上次刷新时间:<p id="refresh_time"></p>
            </div>
        </div>
        <div id="check_container">
            <div id="check_table">

                <table class="query_table">

                    <thead>
                    <tr>
                        <th style="border-left: none">假期名称</th>
                        <th>假期所属</th>
                        <th>假期类型</th>
                        <th>假期起始时间</th>
                        <th>假期结束时间</th>
                        <th>假期年份</th>
                        <th style="border-right: none">状态</th>
                    </tr>
                    </thead>
                    <tbody id="query_body">
                    </tbody>
                </table>

            </div>

        </div>
    </div>

    <div id="Index_Attend">

        <div style="width: 100%;height:160px;display: flex;justify-content: center;margin-bottom: 10px">

            <div style="width: 66%;height: 100%;font-family: Auto_Pen,Serif,sans-serif">
                <p style="font-size: 35px;color: #237F61">加入乐行学途!</p>
                <p style="font-size: 15px;color: #000000">已加入学生:&nbsp;<span id="Attend_queryStudent"></span>&nbsp;人
                </p>
                <p style="font-size: 15px;color: #000000">已加入学院:&nbsp;<span id="Attend_queryCollege"></span>&nbsp;所
                </p>
            </div>

        </div>
        <div style="width: 100%;height: 560px;display: flex">

            <div class="attend_Page" id="left_attend_Page">
                <p>我是学生</p>
                <Button id="attend_student_writeInfo">填写申请信息<img src="static/resources/index/writedown.png"
                                                                       alt="writeDown"></Button>
                <Button id="attend_student_checkState">查看申请情况<img src="static/resources/index/attendcheck.png"
                                                                        alt="Check"></Button>
                <div style="position: relative;width: 100%">
                    <a id="attend_student_transfer" href="#">我想转学<img src="static/resources/index/transfer.png"
                                                                          alt="transfer"></a>
                </div>
            </div>

            <div class="attend_Page" id="right_attend_Page">
                <p>我代表了学院</p>
                <Button id="attend_college_writeInfo">填写申请信息<img src="static/resources/index/writedown.png"
                                                                       alt="writeDown"></Button>
                <Button id="attend_college_adopt">认领学院&nbsp;&nbsp;&nbsp;&nbsp;<img
                        src="static/resources/index/attendadopt.png" alt="Adopt">
                </Button>
                <Button id="attend_college_checkState">查看申请情况<img src="static/resources/index/attendcheck.png"
                                                                        alt="Check"></Button>
                <div style="width: 100%;position: relative">
                    <a id="attend_college_adoptIntent" href="#">什么是认领学院?</a>
                </div>
            </div>

        </div>

    </div>

</div>

<footer>

    <p class="footer_content">
        <span>&copy 2023,Robo Fraternity Club: &lt乐行学途&gt</span><br>
        All trademarks and registered trademarks appearing on this site are the property of Robo Fraternity Club,<br>all
        elements of the site are original.<span>(Version:0.5.0 R&D)</span>
    </p>

</footer>
<script src="static/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim"
        crossorigin="anonymous"></script>
<script src="static/Jquery/jquery-3.7.1.js"></script>
<script src="static/Js/index/MainBackgroundAnimation.js"></script>
<script src="static/Js/index/IndexBannerAnimation.js"></script>
<script src="static/Js/index/IndexChangeAnimation.js"></script>
<script src="static/Js/index/IndexQueryAnimation.js"></script>
<script src="static/Js/index/IndexLoginController.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        function queryCompleteTable() {
            $.ajax({
                url: "<%=request.getContextPath()%>/index-controller",
                type: "POST",
                data: {action: "attend_query"},
                dataType: "text",
                success: function (data) {
                    $('#query_body').html(data);
                }
            });
        }

        function queryFilterTable() {
            const filter_var = $('#filter_input').val();

            $.ajax({
                url: "<%=request.getContextPath()%>/index-controller",
                type: "POST",
                data: {action: "attend_query", filter: filter_var},
                dataType: "text",
                success: function (data) {
                    $('#query_body').html(data);
                }
            });
        }

        document.addEventListener('keydown', function (event) {

            if (event.key === 'Enter') {

                if (document.getElementById('Index_Query').style.display === 'block') {
                    queryFilterTable()
                }

            }

        });

        document.getElementById('QueryNavbarBtn').addEventListener('click', queryCompleteTable)
        document.getElementById('filter_submit').addEventListener('click', queryFilterTable)
        document.getElementById('filter_refresh').addEventListener('click', queryFilterTable)
    });
</script>
</body>
</html>