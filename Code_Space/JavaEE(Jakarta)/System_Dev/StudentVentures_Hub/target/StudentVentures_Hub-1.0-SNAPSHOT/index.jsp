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
                <a class="Inquire&Help_content" href="Help&Inquire/20231117_startedannounce.html" target="_blank">
                    <p class="IH_title">关于系统的启动发布公告</p>
                    <p class="IH_date">2023-11-17</p>
                </a>
                <a class="Inquire&Help_content" href="Help&Inquire/20231121_help&inquire.html" target="_blank">
                    <p class="IH_title">0.5版本更新功能介绍与使用帮助</p>
                    <p class="IH_date">2023-11-21</p>
                </a>
            </div>

        </div>
        <div id="Right_page">

            <div id="Login_Area">
                <p id="Login_Title">账号密码登录</p>
                <input class="Login_Input" placeholder="请输入学籍账号" type="number">
                <input class="Login_Input" style="margin-top: 50px" placeholder="请输入密码" type="password">
                <div id="SecurityCheck">
                    <p>点击登录键即同意<a href="#">用户隐私政策</a>与<a href="#">服务条款</a></p>
                </div>
                <button id="LoginBtn">
                    登&nbsp;录
                </button>
            </div>

        </div>

    </div>

    <div id="Index_Query">

        <h5>查询界面</h5>

    </div>

    <div id="Index_Attend">

        <h5>申请界面</h5>

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
<script src="static/Js/MainBackgroundAnimation.js"></script>
<script src="static/Js/IndexBannerAnimation.js"></script>
<script src="static/Js/IndexChangeAnimation.js"></script>
</body>
</html>