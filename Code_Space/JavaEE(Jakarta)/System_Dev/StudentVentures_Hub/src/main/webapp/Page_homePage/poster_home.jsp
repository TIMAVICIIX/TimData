<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/12/4
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>乐行学途-管理界面</title>
    <link rel="icon" href="../static/resources/index/LXXT_Logo.png">
    <link href="../static/css/for_home.css" rel="stylesheet">
</head>
<body>

<div class="home_side_bar">

    <div class="logo_display">
        <img src="../static/resources/index/LXXT_Logo.png" alt="Logo">
        <p>乐行学途</p>
    </div>

    <div class="navigation_tips">
        <p><span>管理界面</span>&nbsp;>&nbsp;<span id="navigation-tip">个人中心</span></p>
    </div>

    <div class="icon_changes">
        <button id="icon_change_Btn">
            <p>更改头像</p>
            <img src="../static/resources/home/上传头像.png" alt="change_icon" style="width: 20px;height: 20px;margin: 3px">
        </button>
    </div>

    <div class="Icon_container">

        <img class="Icon" src="../static/resources/home/example.jpg" alt="Icon">

    </div>

    <div class="side_navigation_area">

        <div class="order_space">
            <button id="first_order_home_center" class="first_order">
                <img src="../static/resources/home/个人中心.png" alt="个人中心">
                个人中心
                <div id="task_tips_home_center" class="task_tips">
                    3
                </div>
            </button>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order1')" onmouseout="collapseSubMenu('sub_order1')">
            <button id="first_order_student_manager" class="first_order">
                <img src="../static/resources/home/学生管理.png" alt="学生管理">
                学生管理
                <div id="task_tips_student_manager" class="task_tips">
                    3
                </div>
            </button>
            <div id="sub_order1" class="second_order_space">
                <button id="second_order_student_manager" class="second_order">学生一览与管理</button>
                <button id="second_order_student_add" class="second_order">学生添加</button>
            </div>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order2')" onmouseout="collapseSubMenu('sub_order2')">
            <button id="first_order_ventures_manager" class="first_order">
                <img src="../static/resources/home/场景管理.png" alt="假期表管理">
                假期表管理
                <div id="task_tips_ventures_manager" class="task_tips">
                    3
                </div>
            </button>
            <div id="sub_order2" class="second_order_space">
                <button id="second_order_ventures_manager" class="second_order">假期一览与管理</button>
                <button id="second_order_ventures_add" class="second_order">假期添加</button>
            </div>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order3')" onmouseout="collapseSubMenu('sub_order3')">
            <button id="first_order_collect_manager" class="first_order">
                <img src="../static/resources/home/操作-收发登记.png" alt="假期收发管理">
                假期收发管理
                <div id="task_tips_collect_manager" class="task_tips">
                    3
                </div>
            </button>
            <div id="sub_order3" class="second_order_space">
                <button id="second_order_collect_manager" class="second_order">收发信息管理</button>
                <button id="second_order_collect_remind" class="second_order">收发提醒</button>
            </div>
        </div>

    </div>

    <div class="bottom_area">

        <p>乐行学途-<span id="bottom_area_login_type">管理员界面</span></p>
        <p>姓名:<span id="bottom_area_name">TIMAVICIIX</span></p>
        <p>ID:<span id="bottom_area_account_code">5220674</span></p>

        <div class="side_bar_footer">
            &copy;&nbsp;2023&nbsp;乐行学途&nbsp;Version&nbsp;0.5&nbsp;R&D
            <br>阅读<a class="bottom_href" href="#" target="_blank">服务条款</a>与<a class="bottom_href" href="#" target="_blank">用户隐私政策</a>
        </div>
    </div>

    <button class="replace_account_Btn">
        切换账号
        <img src="../static/resources/home/切换账号.png">
    </button>

</div>

<div class="home_center">
    <p class="manager_college">计算机与信息学院</p>

    <div class="home_center_container">



    </div>

</div>

<script src="../static/Js/HomeSideBarAnimation.js"></script>
</body>
</html>
