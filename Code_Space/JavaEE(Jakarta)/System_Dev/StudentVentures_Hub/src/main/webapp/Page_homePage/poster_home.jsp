<%@ page import="java.io.File" %><%--
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
    <link href="${pageContext.request.contextPath}/static/css/for_home.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/for_main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/thridPartFont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/layui-v2.9.2/layui/css/layui.css" rel="stylesheet">
</head>
<body>

<%

    String userName = "";
    String userID = "";
    String userBelong = "";
    String userBelongID = "";
    String userType = "";

//    out.print(session.getId());

    if (session.getAttribute("userID") != null) {

        userID = session.getAttribute("userID").toString();
        userName = session.getAttribute("userName").toString();
        userBelong = session.getAttribute("userBelong").toString();
        userType = session.getAttribute("userType").toString();
        userBelongID = session.getAttribute("userBelongID").toString();

        if (userType.equals("学生")) {
            response.sendRedirect(request.getContextPath() + "/index-controller");
        }

    } else {

        response.sendRedirect(request.getContextPath() + "/index-controller");

    }
%>

<div class="home_side_bar">

    <div class="logo_display">
        <img src="${pageContext.request.contextPath}/static/resources/index/LXXT_Logo.png" alt="Logo">
        <p>乐行学途</p>
    </div>

    <div class="navigation_tips">
        <p><span>管理界面</span>&nbsp;>&nbsp;<span id="navigation-tip">个人中心</span></p>
    </div>

    <div class="icon_changes">
        <button id="icon_change_Btn">
            <p>更改头像</p>
            <img src="${pageContext.request.contextPath}/static/resources/home/上传头像.png" alt="change_icon"
                 style="width: 20px;height: 20px;margin: 3px">
        </button>
    </div>

    <div class="Icon_container">

        <img class="Icon" src="data:image/png;base64,${sessionScope.userIconFile}" alt="Icon">

    </div>

    <div class="side_navigation_area">

        <div class="order_space">
            <button id="first_order_home_center" class="first_order">
                <img src="${pageContext.request.contextPath}/static/resources/home/个人中心.png" alt="个人中心">
                个人中心
                <div id="task_tips_home_center" class="task_tips">
                    3
                </div>
            </button>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order1',1)"
             onmouseout="collapseSubMenu('sub_order1',1)">
            <button id="first_order_student_manager" class="first_order">
                <img src="${pageContext.request.contextPath}/static/resources/home/学生管理.png" alt="学生管理">
                学生管理
                <div id="task_tips_student_manager" class="task_tips">
                    3
                </div>
            </button>
            <div id="sub_order1" class="second_order_space">
                <button id="second_order_student_manager" class="second_order">学生一览与管理</button>
                <button id="second_order_student_add" class="second_order">学生,班级,专业新增</button>
                <button id="second_order_student_audit" class="second_order">学生审核</button>
            </div>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order2',2)"
             onmouseout="collapseSubMenu('sub_order2',2)">
            <button id="first_order_ventures_manager" class="first_order">
                <img src="${pageContext.request.contextPath}/static/resources/home/场景管理.png" alt="假期表管理">
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

        <div class="order_space" onmouseover="expandSubMenu('sub_order3',3)"
             onmouseout="collapseSubMenu('sub_order3',3)">
            <button id="first_order_collect_manager" class="first_order">
                <img src="${pageContext.request.contextPath}/static/resources/home/操作-收发登记.png"
                     alt="假期收发管理">
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

        <p>乐行学途-<span id="bottom_area_login_type"><%=userType%>界面</span></p>
        <p>姓名:<span id="bottom_area_name"><%=userName%></span></p>
        <p>ID:<span id="bottom_area_account_code"><%=userID%></span></p>

        <div class="side_bar_footer">
            &copy;&nbsp;2023&nbsp;乐行学途&nbsp;Version&nbsp;0.5&nbsp;R&D
            <br>阅读<a class="bottom_href" href="#" target="_blank">服务条款</a>与<a class="bottom_href" href="#"
                                                                                     target="_blank">用户隐私政策</a>
        </div>
    </div>

    <button class="replace_account_Btn">
        切换账号
        <img src="${pageContext.request.contextPath}/static/resources/home/切换账号.png" alt="changeAccount">
    </button>

</div>

<div class="home_center">
    <p class="manager_college"><%=userBelong%>
    </p>

    <div class="home_center_container">

        <div id="home_personal_center" class="mainPage">

            <div style="width: 100%;height: 100%;display: flex;flex-direction: column">

                <div class="home_personal_part" style="display: flex;flex-direction: row">

                    <div style="width: 200px;height: 200px;margin-top: 50px;margin-left: 50px">
                        <img style="width: 200px;height: 180px;" class="Icon"
                             src="data:image/png;base64,${sessionScope.userIconFile}" alt="Icon">
                        <input style="width: 200px;margin-top: 5px;margin-bottom: 5px" type="file" name="file"
                               id="Icon_Input" accept=".jpg, .jpeg, .png">
                        <button class="loadingIconBtn" onclick="uploadIcon()">上传头像</button>
                    </div>
                    <div style="color: #545454;font-size: 30px;margin-top: 52px;margin-left: 20px">
                        <p style="line-height: 1.5em">姓名:<%=userName%><br>
                            学籍号/账号:<%=userID%><br>
                            身份:<%=userType%><br>
                            所属学院:<%=userBelong%>
                        </p>
                    </div>

                </div>
                <div class="home_personal_part">

                    <p style="margin-top: 10px;margin-left: 50px;margin-bottom:0;font-size: 30px;border-bottom: #545454 solid 1px">
                        更改密码&nbsp;
                    </p>

                    <div style="width: 100%;height:300px;display: flex;flex-direction: row;align-items: center">

                        <div style="width: 70%;margin-left: 50px">

                            <div style="margin-top: 0">当前密码: <input id="currentPassword" class="changePasswordInput"
                                                                        placeholder="请输入当前密码" type="password">
                            </div>
                            <div style="margin-top: 10px">更新密码: <input id="changedPassword"
                                                                           class="changePasswordInput"
                                                                           placeholder="请输入更改后密码"
                                                                           type="password"></div>
                            <div style="margin-top: 10px">再次输入: <input id="twiceChangedPassword"
                                                                           class="changePasswordInput"
                                                                           placeholder="请再次输入更改后密码"
                                                                           type="password"></div>


                        </div>

                        <button id="changePasswordBtn" onclick="riskOperation('userResetPassword',this)">提交更改
                        </button>

                    </div>

                </div>

            </div>

        </div>

        <div id="home_studentManage_manage" class="mainPage">
            <div class="page_container">
                <p class="pages_title">学生管理->学生一览与管理</p>
                <div class="filter_top">
                    <div class="filter_area">
                        筛选条件:
                        <input id="filter_input_homeStudentQuery" class="filter_input" type="text"
                               placeholder="班级/姓名/电话号码/学籍号">
                        <button class="filter_submit" id="filter_submit_homeStudentQuery">
                            <img src="${pageContext.request.contextPath}/static/resources/index/filterChose.png"
                                 style="width: 25px;height: 25px" alt="submit">
                        </button>
                        <button class="filter_refresh" id="filter_refresh_homeStudentQuery">
                            刷新
                            <img src="${pageContext.request.contextPath}/static/resources/index/refresh.png"
                                 style="width: 15px; height: 15px" alt="refresh">
                        </button>
                    </div>
                    <div class="time_recorder">
                        上次刷新时间:<p class="refresh_time" id="refresh_time_homeStudentQuery"></p>
                    </div>
                </div>

                <div class="home_student_query_table_double_container">

                    <div class="home_student_query_table_container">

                        <table class="home_student_query_table" style="margin: 0;padding: 0">

                            <thead>
                            <tr>
                                <th>学籍号</th>
                                <th>学院</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>年级/入学时间</th>
                                <th>专业/所属班级</th>
                                <th>联系方式</th>
                                <th colspan="4" style="color: #d20000;">操作</th>
                            </tr>
                            </thead>

                            <tbody id="home_student_query_table_body">


                            </tbody>

                        </table>

                    </div>

                </div>
            </div>
        </div>

        <div id="home_studentManage_add" class="mainPage">
            <div id="home_studentManage_add_topChoose">
                <button class="studentManage_top_Btn" style="color: #015100" id="SM_top_addBtn"
                        onclick="changeStuAddPage('SM_Add')">新增信息
                </button>
                <button class="studentManage_top_Btn" style="color: #005261" id="SM_top_classBtn"
                        onclick="changeStuAddPage('SM_Class')">班级一览
                </button>
                <button class="studentManage_top_Btn" style="color: #3E005E" id="SM_top_specBtn"
                        onclick="changeStuAddPage('SM_Spec')">专业一览
                </button>
                <button class="studentManage_top_Btn" style="color: #5e0000" id="SM_top_collegeBtn"
                        onclick="changeStuAddPage('SM_College')">学院一览
                </button>
            </div>

            <div class="home_studentManage_add" id="SM_College" style="display: none">

                <table class="home_student_query_table" style="margin: 0;padding: 0">

                    <thead>
                    <tr>
                        <th>学院代号</th>
                        <th style="width: 300px">学院名称</th>
                        <th>学院专业数</th>
                        <th>学院人数</th>
                    </tr>
                    </thead>

                    <tbody id="home_college_query_table_body">


                    </tbody>

                </table>

            </div>

            <div class="home_studentManage_add" id="SM_Spec" style="display:none">

                <table class="home_student_query_table" style="margin: 0;padding: 0">

                    <thead>
                    <tr>
                        <th>专业代号</th>
                        <th>专业名称</th>
                        <th>所属学院代号</th>
                        <th>专业班级数</th>
                        <th>专业人数</th>
                        <th style="color: #ff0013">操作</th>
                    </tr>
                    </thead>

                    <tbody id="home_speciality_query_table_body">


                    </tbody>

                </table>

            </div>

            <div class="home_studentManage_add" id="SM_Class" style="display:none">

                <table class="home_student_query_table" style="margin: 0;padding: 0">

                    <thead>
                    <tr>
                        <th>班级代号</th>
                        <th>班级名称</th>
                        <th>班级所属学院</th>
                        <th>班级所属专业</th>
                        <th>班级开课时间</th>
                        <th>班级人数</th>
                        <th style="color: #ff0013">操作</th>
                    </tr>
                    </thead>

                    <tbody id="home_class_query_table_body">


                    </tbody>

                </table>

            </div>

            <div class="home_studentManage_add" id="SM_Add">

                <div class="home_addNewMessage_Part">

                    <p style="color: #2f2f2f;font-size: 27px">选择新增信息类型:</p>

                    <button class="addNewMessage_ChooseType_Btn" onclick="changeNewAddPage('stuAddForm')"
                            id="addMessageStudentBtn">新增学生
                    </button>
                    <button class="addNewMessage_ChooseType_Btn" onclick="changeNewAddPage('classAddForm')">新增班级
                    </button>
                    <button class="addNewMessage_ChooseType_Btn" onclick="changeNewAddPage('specAddForm')">新增专业
                    </button>

                    <p style="color: #2f2f2f;font-size: 13px;width: 70%">
                        注：<span style="color: #ff0500">新增学生</span>提交后系统会自动生成学生学籍号及密码，请管理员牢记并及时通知学生！
                    </p>

                </div>
                <div class="home_addNewMessage_Part">

                    <p style="color: #2f2f2f;font-size: 27px;margin-bottom: 0;margin-top: 10px">填写新增信息</p>

                    <div class="addForm" id="stuAddForm">

                        <div class="addForm_div">学生姓名:<input id="stuAddName" class="addForm_input" type="text">
                        </div>
                        <div class="addForm_div">学生性别:
                            <select id="stuAddSex" class="addForm_select">
                                <option selected="selected" value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>

                        <div class="addForm_div">所属学院:
                            <select id="stuAddCollege" class="addForm_select"
                                    onchange="addInfoSpecRequest(this,'stuAddSpec')">

                            </select>
                        </div>

                        <div class="addForm_div">所属专业:
                            <select id="stuAddSpec" class="addForm_select"
                                    onchange="addInfoClassRequest(this,'stuAddClass')">

                            </select>
                        </div>

                        <div class="addForm_div">所属班级:
                            <select id="stuAddClass" class="addForm_select">

                            </select>
                        </div>

                        <div class="addForm_div">联系方式:<input id="stuAddTelephone" type="number"
                                                                 class="addForm_input"></div>

                        <div class="addForm_div">入学时间:
                            <select id="stuAddTime" class="addForm_select">

                            </select>
                        </div>

                        <div class="addForm_div">
                            <button id="newStudentAddBtn" class="NewConfirmBtn" onclick="saveNewInfo('Student')">
                                提&nbsp;交
                            </button>
                        </div>


                    </div>

                    <div class="addForm" id="classAddForm" style="display:none">

                        <div class="addForm_div">所属学院:
                            <select id="classAddCollege" class="addForm_select"
                                    onchange="addInfoSpecRequest(this,'classAddSpec')">

                            </select>
                        </div>

                        <div class="addForm_div">所属专业:
                            <select id="classAddSpec" class="addForm_select">

                            </select>
                        </div>

                        <div class="addForm_div">开班年份:
                            <select id="classAddYear" class="addForm_select">

                            </select>
                        </div>
                        <div class="addForm_div">班级名称:<input id="classAddName" class="addForm_input" type="text">
                        </div>

                        <div class="addForm_div">
                            <button id="newClassAddBtn" class="NewConfirmBtn" onclick="saveNewInfo('Class')">
                                提&nbsp;交
                            </button>
                        </div>

                    </div>

                    <div class="addForm" id="specAddForm" style="display:none;">

                        <div class="addForm_div">所属学院:
                            <select id="specAddCollege" class="addForm_select">

                            </select>
                        </div>

                        <div class="addForm_div">专业名称:<input id="specAddName" class="addForm_input" type="text">
                        </div>

                        <div class="addForm_div">
                            <button id="newSpecAddBtn" class="NewConfirmBtn" onclick="saveNewInfo('Spec')">
                                提&nbsp;交
                            </button>
                        </div>

                    </div>


                </div>

            </div>
        </div>

        <div id="home_studentManage_audit" class="mainPage">
            学生界面-学生审核
        </div>

        <div id="home_ventureManage_manage" class="mainPage">
            <div id="home_ventureManage_list">
                <div class="filter_top" style="margin-top: 10px">
                    <div class="filter_area">
                        筛选条件:
                        <input id="filter_input_homeVentureQuery" class="filter_input" type="text"
                               placeholder="班级/姓名/电话号码/学籍号">
                        <button id="filter_submit_homeVentureQuery" class="filter_submit">
                            <img src="${pageContext.request.contextPath}/static/resources/index/filterChose.png"
                                 style="width: 25px;height: 25px" alt="submit">
                        </button>
                        <button id="filter_refresh_homeVentureQuery" class="filter_refresh">
                            刷新
                            <img src="${pageContext.request.contextPath}/static/resources/index/refresh.png"
                                 style="width: 15px; height: 15px" alt="refresh">
                        </button>
                    </div>
                    <div class="time_recorder">
                        上次刷新时间:<p class="refresh_time" id="refresh_time_homeVentureQuery"></p>
                    </div>
                </div>
                <div class="home_student_query_table_double_container">

                    <div class="home_student_query_table_container">

                        <table class="home_student_query_table" style="margin: 0;padding: 0">

                            <thead>
                            <tr>
                                <th>假期号</th>
                                <th>假期名称</th>
                                <th>假期所属</th>
                                <th colspan="3">假期时间</th>
                                <th colspan="2" style="color: #d20000;">操作</th>
                            </tr>
                            </thead>

                            <tbody id="home_venture_query_table_body" class="VentureQueryBody" style="font-size: 13px;">

                            </tbody>

                        </table>

                    </div>

                </div>
            </div>
            <div id="home_ventureManage_content" style="display: none">
                <div style="width: 100%;height: 100%;display:flex;flex-direction: column;margin-top: 30px">

                    <p style="margin-left: 22px;font-size: 20px;font-style: italic;">假期号:<span
                            id="changedVentureCode"></span></p>

                    <label class="Venture_label">
                        假期名称:<input id="changedVentureName" class="Venture_input" type="text">
                    </label>
                    <label class="Venture_label">
                        假期类型:
                        <select id="changedVentureType" class="Venture_select_large">
                            <option value="国家标准假期">国家标准假期</option>
                            <option value="一级学院指定假期">一级学院指定假期</option>
                            <option value="二级学院指定假期">二级学院指定假期</option>
                            <option value="班级指定假期">班级指定假期</option>
                            <option value="其他假期">其他假期</option>
                        </select>
                    </label>
                    <label class="Venture_label">
                        假期所属:
                        <span style="font-size: 18px;margin-left: 25px">学院:</span>
                        <select id="changedVentureAddCollege" class="Venture_select_short"
                                onchange="addInfoSpecRequest(this,'changedVentureAddSpec')">

                        </select>
                        <span style="font-size: 18px;margin-left: 12px">专业:</span>
                        <select id="changedVentureAddSpec" class="Venture_select_short"
                                onchange="addInfoClassRequest(this,'changedVentureAddClass')">

                        </select>
                        <span style="font-size: 18px;margin-left: 12px">班级:</span>
                        <select id="changedVentureAddClass" class="Venture_select_short">

                        </select>
                    </label>


                    <div class="layui-inline Venture_label" id="ID-laydate-rangeLinked-changed">
                        假期开始日期:
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" id="ID-laydate-start-date-1-changed"
                                   class="layui-input"
                                   placeholder="开始日期"
                                   style="width: 370px;height: 35px;border-radius: 5px;border:#545454 solid 1px;margin-left: 10px;margin-right: 15px;">
                        </div>
                        假期结束日期:
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" id="ID-laydate-end-date-1-changed" class="layui-input"
                                   placeholder="结束日期"
                                   style="width: 370px;height: 35px;border-radius: 5px;border:#545454 solid 1px;margin-left: 10px;margin-right: 15px;">
                        </div>
                    </div>

                    <div class="Venture_label">
                        假期详细描述信息(1-20字):
                    </div>
                    <label class="Venture_label" style="justify-content: center">
                        <textarea id="changedVentureDes" class="Des_textArea"
                                  placeholder="请输入假期描述......"></textarea>
                    </label>

                    <label class="Venture_label" style="justify-content: center;display: flex;flex-direction: row">
                        <button class="NewConfirmBtn" onclick="updateEdit(this,'venture')">保存</button>
                        <button class="NewConfirmBtn" style="margin-left: 20px" onclick="backToList()">返回
                        </button>
                    </label>

                </div>
            </div>
        </div>

        <div id="home_ventureDispatch_manage" class="mainPage">
            <div id="collectList_container">


            </div>
            <div id="collectItem_container" style="display: none">
                <div class="VentureItemPage_ventureInfo"
                     style="border-bottom: #252525 solid 1px;margin-bottom: 5px;padding: 10px">
                    <p>假期号:<span id="fill-out_ventureCode"></span></p><br>
                    <p>假期名称:<span id="fill-out_ventureName"></span></p><br>
                    <p>假期类型:<span id="fill-out_ventureType"></span></p><br>
                    <p>假期所属:<span id="fill-out_ventureBelong"></span></p><br>
                    <p>假期持续时间:<span id="fill-out_ventureDate"></span></p><br>
                    <p>假期描述:<span id="fill-out_ventureDes"></span></p><br>
                    <button style="width: 120px;height: auto;" onclick="downloadSheet()">下载假期记录表单
                    </button>
                    <div id="pieContainer">

                    </div>
                </div>
                <div id="studentFillOutList_container">

                </div>
                <div style="width: 100%;display: flex;justify-content: center">
                    <button id="collect_formDenied" class="NewConfirmBtn" style="margin-top: 10px"
                            onclick="collectToList()">
                        返回
                    </button>
                </div>
            </div>
        </div>

        <div id="home_ventureDispatch_remind" class="mainPage">
            收发管理-收发提醒
        </div>

        <div id="home_ventureManage_add" class="mainPage">

            <div style="width: 100%;height: 100%;display: flex;flex-direction: column">

                <div style="width: 100%;height: 10%;display: flex;flex-direction: row;align-items: center;
                border-bottom: #545454 solid 1px">
                    <p style="font-size: 28px;color: #545454;margin-left: 10px;margin-right: 10px">新增假期</p>
                    <img src="${pageContext.request.contextPath}/static/resources/home/假期列表.png"
                         style="width: 30px;height: 30px" alt="Add Venture">
                </div>
                <div style="width: 100%;height: 90%;display:flex;flex-direction: column;">

                    <label class="Venture_label">
                        假期名称:<input id="ventureName" class="Venture_input" type="text">
                    </label>
                    <label class="Venture_label">
                        假期类型:
                        <select id="ventureType" class="Venture_select_large">
                            <option value="国家标准假期">国家标准假期</option>
                            <option value="一级学院指定假期">一级学院指定假期</option>
                            <option value="二级学院指定假期">二级学院指定假期</option>
                            <option value="班级指定假期">班级指定假期</option>
                            <option value="其他假期">其他假期</option>
                        </select>
                    </label>
                    <label class="Venture_label">
                        假期所属:
                        <span style="font-size: 18px;margin-left: 25px">学院:</span>
                        <select id="ventureAddCollege" class="Venture_select_short"
                                onchange="addInfoSpecRequest(this,'ventureAddSpec')">

                        </select>
                        <span style="font-size: 18px;margin-left: 12px">专业:</span>
                        <select id="ventureAddSpec" class="Venture_select_short"
                                onchange="addInfoClassRequest(this,'ventureAddClass')">

                        </select>
                        <span style="font-size: 18px;margin-left: 12px">班级:</span>
                        <select id="ventureAddClass" class="Venture_select_short">

                        </select>
                    </label>


                    <div class="layui-inline Venture_label" id="ID-laydate-rangeLinked">
                        假期开始日期:
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" id="ID-laydate-start-date-1" class="layui-input"
                                   placeholder="开始日期"
                                   style="width: 370px;height: 35px;border-radius: 5px;border:#545454 solid 1px;margin-left: 10px;margin-right: 15px;">
                        </div>
                        假期结束日期:
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" id="ID-laydate-end-date-1" class="layui-input"
                                   placeholder="结束日期"
                                   style="width: 370px;height: 35px;border-radius: 5px;border:#545454 solid 1px;margin-left: 10px;margin-right: 15px;">
                        </div>
                    </div>

                    <div class="Venture_label">
                        假期详细描述信息(1-20字):
                    </div>
                    <label class="Venture_label" style="justify-content: center">
                        <textarea id="ventureDes" class="Des_textArea" placeholder="请输入假期描述......"></textarea>
                    </label>

                    <label class="Venture_label" style="justify-content: center">
                        <button class="NewConfirmBtn" onclick="saveNewInfo('Venture')">发布假期</button>
                    </label>

                </div>

            </div>

        </div>

    </div>

    <div id="prompt_area" style="display: none">

        <div id="action_dialog">

            <div id="normal_remind" class="action_layout" style="display: none">

                <p>常规操作</p>

                <p>确定进行操作"<span id="normal_remind_title" class="action_text"></span>"吗?<br>
                    操作信息:<span id="normal_remind_context" class="action_text"></span>
                </p>

                <button id="normal_operation_confirm" class="prompt_action_success">
                    确定
                </button>

                <button class="prompt_action_defeated" onclick="cancelPrompt('normal_remind')">
                    取消
                </button>

            </div>

            <div id="operate_success" class="action_layout" style="display: none">

                <img src="${pageContext.request.contextPath}/static/resources/home/操作成功.png" alt="success">

                <p>操作项:"<span id="operate_success_title" class="action_text"></span>"操作成功!<br>
                    详细信息:<span id="operate_success_context" class="action_text"></span>
                </p>

                <button class="prompt_action_success" onclick="cancelPrompt('operate_success')">
                    确定
                </button>

            </div>

            <div id="operate_error" class="action_layout" style="display: none">
                <img src="${pageContext.request.contextPath}/static/resources/home/操作失败.png" alt="error">

                <p>操作项:"<span id="operate_error_title" class="action_text"></span>"操作失败!<br>
                    详细信息:<span id="operate_error_context" class="action_text"></span>
                </p>

                <button class="prompt_action_success" onclick="cancelPrompt('operate_error')">
                    确定
                </button>
            </div>


            <div id="risk_remind" class="action_layout" style="display: none">

                <p>!风险性操作!</p>

                <p>确定进行风险性操作"<span id="normal_risk_title" class="action_text"></span>"吗?<br>
                    操作信息:<span id="normal_risk_context" class="action_text"></span>
                </p>

                <p>坚持进行该操作,请输入管理员密码:</p>

                <input id="risk_action_token" type="password">

                <div style="margin-top: 10px;width: 100%;text-align: center">

                    <button id="risk_operation_confirm" class="prompt_action_success">
                        确定
                    </button>

                    <button class="prompt_action_defeated" onclick="cancelPrompt('risk_remind')">
                        取消
                    </button>
                </div>
            </div>
        </div>

    </div>

    <script src="${pageContext.request.contextPath}/static/Jquery/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/Js/home/HomeSideBarAnimation.js"></script>
    <%--<script src="${pageContext.request.contextPath}/static/Js/home/HomeStudentManager.js"></script>--%>
    <script src="${pageContext.request.contextPath}/static/Js/index/IndexQueryAnimation.js"></script>
    <script src="${pageContext.request.contextPath}/static/layui-v2.9.2/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/Js/thirdPart/echarts.js"></script>
    <script>

        const ventureListItem_HTML = "<div class=\"VentureForm_ListItem\">" +
            "<div class=\"ItemHead\">" +
            "<p style=\"font-style: italic\">列表假期信息</p>" +
            "<p class=\"ItemTitle\">" +
            "假期名称:<span>{{VentureName}}</span>" +
            " </p>" +
            "</div>" +
            "<div class=\"ItemBody\" style=\"flex-direction: column;align-items: flex-start\">" +
            "<p style=\"margin-right: 10px\">假期所属:<span>{{VentureBelong}}</span></p>" +
            "<p>假期持续日期:<span>{{VentureStartDate}} </span>到<span> {{VentureEndDate}}</span></p>" +
            " </div>" +
            "<div class=\"ItemBtnContainer\">" +
            "<button data-item-code=\"{{VentureCode}}\" class=\"ItemBtn\" onclick=\"editInfo(this,'ventureCollectItem')\">查看填写情况</button>" +
            "</div>" +
            "</div>"

        const ventureCollectItem_HTML = "<div class=\"VentureForm_ListItem\" style=\"height: auto;\">" +
            "<div class=\"ItemHead\">" +
            " <p style=\"font-style: italic\">{{StudentCode}}</p>" +
            "<p class=\"ItemTitle\" style=\"margin-top: 5px\">{{StudentName}}</p>" +
            "</div>" +
            "<div class=\"ItemBody\" style=\"flex-direction: column;align-items: flex-start\">" +
            "<p>目的地:<span>{{CollectTarget}}</span></p>" +
            " <p>其他描述:<span>{{CollectDes}}</span></p>" +
            "</div>" +
            "<div class=\"ItemBtnContainer\">" +
            "{{CollectState}}" +
            "</div>" +
            "</div>"

        const remind_HTML = "<button data-item-code=\"{{StudentCode}}\" class=\"ItemBtn\" onclick=\"saveNewInfo()\">提醒填写</button>"


        function queryInfos(type) {
            // alert("Query!")

            const sessionID = "<%=request.getSession().getId()%>";
            let filterString = ""
            if (type === "student") {
                filterString = $('#filter_input_homeStudentQuery').val();
            }
            if (type === "venture") {
                filterString = $('#filter_input_homeVentureQuery').val();
            }


            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "query",
                    queryType: type,
                    filter: filterString,
                    posterBelongID:<%=userBelongID%>
                },
                success: function (response) {

                    if (response === "401") {
                        alert('会话过期或不存在，请返回登陆界面重新登陆')
                    } else if (type === "student") {
                        $('#home_student_query_table_body').html(response);
                    } else if (type === "class") {
                        $('#home_class_query_table_body').html(response);
                    } else if (type === "spec") {
                        $('#home_speciality_query_table_body').html(response);
                    } else if (type === "college") {
                        $('#home_college_query_table_body').html(response);
                    } else if (type === "venture") {
                        $('#home_venture_query_table_body').html(response);
                    } else if (type === "ventureCollectList") {

                        let ventureTempHTML = "";
                        let ventureListHTML = "";
                        const ventureList = response.split("-item-");

                        for (const venture of ventureList) {

                            const ventureCell = venture.split("-cell-");
                            ventureTempHTML = ventureListItem_HTML;

                            ventureTempHTML = ventureTempHTML.replace('{{VentureName}}', ventureCell[0])
                                .replace('{{VentureBelong}}', ventureCell[1])
                                .replace('{{VentureStartDate}}', ventureCell[2])
                                .replace('{{VentureEndDate}}', ventureCell[3])
                                .replace('{{VentureCode}}', ventureCell[4]);

                            // console.log(ventureTempHTML);

                            ventureListHTML += ventureTempHTML;

                        }

                        $('#collectList_container').html(ventureListHTML);

                    }

                }, error: function () {

                    awakePrompt("ERROR", "请求列表", "网络错误或服务器关闭", null);

                }
            });

        }

        function editInfo(infoItem, type) {

            let infoCell;
            let infoKey;
            const sessionID = "<%=request.getSession().getId()%>";

            if (type === "ventureCollectItem") {
                infoKey = infoItem.dataset.itemCode;
            } else {
                infoCell = infoItem.parentNode.parentNode;
                infoKey = infoCell.getElementsByTagName("td")[0].innerText;
            }


            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "edit",
                    infoKey: infoKey,
                    editType: type
                }, success: async function (response) {
                    if (response === "401") {

                        awakePrompt("ERROR", "假期详情", "没有查看权限,请登陆后重试", null, null);
                    } else if (response === "404") {
                        if (type === "ventureCollectItem") {
                            awakePrompt("ERROR", "信息项为空", "该假期没有包含任何一个学生", null, null);
                            return;
                        }
                    } else {
                        if (type === "studentInfo") {
                            infoCell.innerHTML = response;
                        } else if (type === "ventureInfo") {

                            const responseList = response.split("&&");

                            $('#home_ventureManage_content').toggle();
                            $('#home_ventureManage_list').toggle();

                            await addInfoCollegeRequest('VentureEditForm');

                            $('#changedVentureCode').text(responseList[0]);
                            $('#changedVentureName').val(responseList[1]);
                            $("#changedVentureType option:contains('" + responseList[2] + "')").prop("selected", true);

                            setTimeout(function () {
                                $("#changedVentureAddCollege option:contains('" + responseList[3] + "')").prop("selected", true);
                                $("#changedVentureAddCollege").change();
                            }, 500);

                            setTimeout(function () {
                                $("#changedVentureAddSpec option:contains('" + responseList[4] + "')").prop("selected", true);
                                $("#changedVentureAddSpec").change();
                            }, 700);

                            setTimeout(function () {
                                $("#changedVentureAddClass option:contains('" + responseList[5] + "')").prop("selected", true);
                                $("#changedVentureAddClass").change();
                            }, 1000);

                            $("#ID-laydate-start-date-1-changed").val(responseList[6]);
                            $("#ID-laydate-end-date-1-changed").val(responseList[7]);

                            $('#changedVentureDes').val(responseList[8]);


                        } else if (type === "ventureCollectItem") {

                            const ventureItemParts = response.split("-ventureInfo-");

                            const ventureInfo = ventureItemParts[0].split("-cell-");
                            const ventureCollectList = ventureItemParts[1].split("-item-");
                            let collectListHTML = "";
                            let collectTempListHTML = "";

                            let fillNum = 0;
                            let outNum = 0;

                            $('#fill-out_ventureCode').text(ventureInfo[0]);
                            $('#fill-out_ventureName').text(ventureInfo[1]);
                            $('#fill-out_ventureType').text(ventureInfo[2]);
                            $('#fill-out_ventureBelong').text(ventureInfo[3]);
                            $('#fill-out_ventureDate').text(ventureInfo[4]);
                            $('#fill-out_ventureDes').text(ventureInfo[5]);

                            for (const listItem of ventureCollectList) {

                                const listCell = listItem.split("-cell-");
                                collectTempListHTML = ventureCollectItem_HTML;

                                collectTempListHTML = collectTempListHTML.replace("{{StudentCode}}", listCell[0])
                                    .replace("{{StudentName}}", listCell[1])
                                    .replace("{{CollectTarget}}", listCell[2])
                                    .replace("{{CollectDes}}", listCell[3]);

                                if (listCell[4] === "未提交") {
                                    outNum++;

                                    collectTempListHTML = collectTempListHTML.replace("{{CollectState}}", remind_HTML)
                                        .replace("{{StudentCode}}", listCell[0]);
                                } else if (listCell[4] === "已提交") {
                                    fillNum++;
                                    collectTempListHTML = collectTempListHTML.replace("{{CollectState}}", "<p>已提交</p>");
                                } else if (listCell[4] === "已过期") {
                                    collectTempListHTML = collectTempListHTML.replace("{{CollectState}}", "<p>已过期</p>");
                                }

                                collectListHTML += collectTempListHTML;

                            }

                            $('#studentFillOutList_container').html(collectListHTML);
                            collectToList();
                            createPie(fillNum, outNum);
                        }
                    }
                }, error: function () {
                    awakePrompt("ERROR", "请求编辑操作", "网络错误或服务器关闭!", null, null);
                }

            })


        }

        /**添加唤醒AJAX操作的组件**/
        function awakePrompt(type, title, context, targetOperation, targetOperationParma) {

            /**
             * 1.通过入参:提醒类型，提醒操作，提醒操作内容,执行AJAX方法,唤醒AJAX操作的组件
             * 2.框架唤醒后通过点击确定进行下一步定位,点击取消不进行操作 TODO。。。
             */

            const cover = document.getElementById("prompt_area");

            const normal_remind = document.getElementById("normal_remind");
            const risk_remind = document.getElementById("risk_remind");

            const normal_remind_title = document.getElementById("normal_remind_title");
            const normal_remind_context = document.getElementById("normal_remind_context");

            const risk_remind_title = document.getElementById("normal_risk_title");
            const risk_remind_context = document.getElementById("normal_risk_context");
            const risk_remind_token = document.getElementById("risk_action_token");


            const operation_success = document.getElementById("operate_success");
            const operation_error = document.getElementById("operate_error");

            const operation_success_title = document.getElementById("operate_success_title");
            const operation_success_context = document.getElementById("operate_success_context");

            const operation_error_title = document.getElementById("operate_error_title");
            const operation_error_context = document.getElementById("operate_error_context");

            cover.style.display = "block";

            if (type === "RISK_REMIND") {
                risk_remind_title.innerText = title;
                risk_remind_context.innerText = context;
                risk_remind_token.value = "";

                risk_remind.style.display = 'block';

                continuePrompt(type, targetOperation, targetOperationParma);
            } else if (type === "NORMAL_REMIND") {
                normal_remind_title.innerText = title;
                normal_remind_context.innerText = context;

                normal_remind.style.display = 'block';

                continuePrompt(type, targetOperation, targetOperationParma);
            } else if (type === "SUCCESS") {
                operation_success_title.innerText = title;
                operation_success_context.innerText = context;

                operation_success.style.display = 'block';
            } else if (type === "ERROR") {
                operation_error_title.innerText = title;
                operation_error_context.innerText = context;

                operation_error.style.display = 'block';
            }

        }

        function continuePrompt(type, targetOperation, targetOperationParma) {

            const normal_confirm = document.getElementById("normal_operation_confirm");
            const risk_confirm = document.getElementById("risk_operation_confirm");

            if (type === "NORMAL_REMIND") {
                normal_confirm.onclick = function () {
                    window[targetOperation](targetOperationParma);
                };
            } else if (type === "RISK_REMIND") {
                risk_confirm.onclick = function () {
                    window[targetOperation](targetOperationParma);
                };
            }

        }

        function cancelPrompt(cancelTarget) {

            const cancelElement = document.getElementById(cancelTarget);
            const prompt_cover = document.getElementById("prompt_area");

            cancelElement.style.display = 'none';
            prompt_cover.style.display = 'none';
        }


        function updateEdit(editBtn, type) {
            if (type === "student") {
                const saveCell = editBtn.parentNode.parentNode;
                const saveCode = saveCell.getElementsByTagName('td')[0].innerText;
                const saveName = saveCell.getElementsByTagName('td')[2].firstElementChild.value;

                awakePrompt("NORMAL_REMIND", "保存修改", "对学籍号为 " + saveCode + " 的 " + saveName + " 同学进行保存修改操作!", "doStuUpdateAjax", editBtn);
            } else if (type === "venture") {
                awakePrompt("NORMAL_REMIND", "保存修改", "对该假期进行保存修改操作吗?", "doVentureAJAX", null);
            }
        }

        function doStuUpdateAjax(saveBtn) {
            /**
             * 1.获取操作项入参，包括学籍号，姓名，性别，专业/所属班级的班级号，班级名称，联系方式
             */

            const sessionID = "<%=request.getSession().getId()%>";

            const updateCell = saveBtn.parentNode.parentNode;

            const updateTds = updateCell.getElementsByTagName('td');

            const updateCode = updateTds[0].innerText;
            const updateName = updateTds[2].firstElementChild.value;
            const updateSex = updateTds[3].firstElementChild.value;

            const updateSelect = updateTds[5].firstElementChild;
            const classCode = updateSelect.value;
            const className = updateSelect.options[updateSelect.selectedIndex].text;

            const telephone = updateTds[6].firstElementChild.value;


            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "update",
                    updateType: "studentInfo",
                    updateCode: updateCode,
                    updateName: updateName,
                    updateSex: updateSex,
                    classCode: classCode,
                    className: className,
                    telephone: telephone
                }, success: function (response) {

                    if (response === "SUCCESS") {

                        awakePrompt("SUCCESS", "操作完成", "学生信息修改操作", null, null);
                        queryInfos('student');
                    } else if (response === "ERROR") {

                        awakePrompt("ERROR", "信息修改失败", "未被允许的修改方式", null, null);
                        queryInfos('student');

                    }
                }, error: function () {
                    awakePrompt("ERROR", "网络错误", "请检查网络连接!", null, null);
                }
            });


        }

        function doVentureAJAX() {
            const sessionID = "<%=request.getSession().getId()%>";

            const updateVentureCode = $('#changedVentureCode').text();
            const updateVentureName = $('#changedVentureName').val();
            const updateVentureType = $('#changedVentureType option:selected').text();

            const updateVentureCollege = $('#changedVentureAddCollege option:selected').text();
            const updateVentureSpec = $('#changedVentureAddSpec option:selected').text();
            const updateVentureClass = $('#changedVentureAddClass option:selected').text();

            const updateVentureStartDate = $('#ID-laydate-start-date-1-changed').val();
            const updateVentureEndDate = $('#ID-laydate-end-date-1-changed').val();
            const updateVentureDes = $('#changedVentureDes').val();


            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "update",
                    updateType: "ventureInfo",
                    ventureCode: updateVentureCode,
                    ventureName: updateVentureName,
                    ventureType: updateVentureType,
                    ventureBelongCollege: updateVentureCollege,
                    ventureBelongSpec: updateVentureSpec,
                    ventureBelongClass: updateVentureClass,
                    ventureStartDate: updateVentureStartDate,
                    ventureEndDate: updateVentureEndDate,
                    ventureDes: updateVentureDes
                }, success: function (response) {

                    if (response === "SUCCESS") {

                        awakePrompt("SUCCESS", "操作完成", "假期信息修改操作", null, null);
                        backToList();
                    } else if (response === "ERROR") {
                        awakePrompt("ERROR", "信息修改失败", "未被允许的修改方式", null, null);
                    }
                }, error: function () {
                    awakePrompt("ERROR", "网络错误", "请检查网络连接!", null, null);
                }
            });
        }

        function changeNewAddPage(targetPage) {

            document.getElementById("stuAddForm").style.display = 'none';
            document.getElementById("classAddForm").style.display = 'none';
            document.getElementById("specAddForm").style.display = 'none';

            document.getElementById(targetPage).style.display = 'block';

            addInfoCollegeRequest(targetPage);

            if (targetPage === "stuAddForm") {
                addInfoTimeRequest();
            }

        }

        function addInfoCollegeRequest(AddPage) {
            const sessionID = "<%=request.getSession().getId()%>";

            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "saveRequest",
                    saveRequestType: "college",
                    requestArea: AddPage,
                    posterBelongID:<%=userBelongID%>
                }, success: function (response) {

                    if (response === "401") {
                        awakePrompt("ERROR", "新增信息项请求", "非法的新增请求", null, null);
                        return;
                    }

                    if (AddPage === "stuAddForm") {
                        $('#stuAddCollege').html(response);
                        document.getElementById("stuAddCollege").onchange();
                    } else if (AddPage === "classAddForm") {
                        $('#classAddCollege').html(response);
                        document.getElementById("classAddCollege").onchange();
                    } else if (AddPage === "specAddForm") {
                        $('#specAddCollege').html(response);
                        document.getElementById("specAddCollege").onchange();
                    } else if (AddPage === "VentureAddForm") {
                        if ("<%=userBelongID%>" === "52200") {
                            response = "<option value='全体学院'>全体学院</option>" + response;
                        }
                        $('#ventureAddCollege').html(response);
                        document.getElementById("ventureAddCollege").onchange();
                    } else if (AddPage === "VentureEditForm") {
                        if ("<%=userBelongID%>" === "52200") {
                            response = "<option value='全体学院'>全体学院</option>" + response;
                        }
                        $('#changedVentureAddCollege').html(response);
                        document.getElementById("changedVentureAddCollege").onchange();
                    }


                }, error: function () {
                    awakePrompt("ERROR", "学院选择请求", "请检查网络连接!", null, null);
                }

            });
        }

        function addInfoSpecRequest(onChangeSelect, responseSpecSelect) {
            const sessionID = "<%=request.getSession().getId()%>";

            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "saveRequest",
                    saveRequestType: "spec",
                    posterBelongID:<%=userBelongID%>,
                    saveRequestFilter: onChangeSelect.value
                }, success: function (response) {
                    if (responseSpecSelect === "ventureAddSpec" || responseSpecSelect === "changedVentureAddSpec") {
                        response = "<option value='全体专业'>全体专业</option>" + response;
                    }
                    document.getElementById(responseSpecSelect).innerHTML = response;
                    document.getElementById(responseSpecSelect).onchange();
                }, error: function () {
                    awakePrompt("ERROR", "班级选择请求", "请检查网络连接!", null, null);
                }
            });

        }

        function addInfoClassRequest(onChangeSelect, responseClassSelect) {
            const sessionID = "<%=request.getSession().getId()%>";

            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "saveRequest",
                    saveRequestType: "class",
                    posterBelongID:<%=userBelongID%>,
                    saveRequestFilter: onChangeSelect.value
                }, success: function (response) {
                    if (responseClassSelect === "ventureAddClass" || responseClassSelect === "changedVentureAddClass") {
                        response = "<option value='全体班级'>全体班级</option>" + response;
                    }
                    document.getElementById(responseClassSelect).innerHTML = response;
                }, error: function () {
                    awakePrompt("ERROR", "班级选择请求", "请检查网络连接!", null, null);
                }
            });

        }

        function addInfoTimeRequest() {
            const sessionID = "<%=request.getSession().getId()%>";

            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "saveRequest",
                    saveRequestType: "time",
                    posterBelongID:<%=userBelongID%>
                }, success: function (response) {
                    $('#stuAddTime').html(response);
                    $('#classAddYear').html(response);
                }, error: function () {
                    awakePrompt("ERROR", "时间选择请求", "请检查网络连接!", null, null);
                }
            });
        }

        function saveNewInfo(saveType) {

            if (saveType === "Student") {
                const newStudentName = $('#stuAddName').val();
                const newStudentCollege = $('#stuAddCollege').val();
                const newStudentClass = $('#stuAddClass').val();

                awakePrompt("NORMAL_REMIND", "新增操作", "确定新增 " + newStudentName
                    + " 同学到 " + newStudentCollege + " 学院 " + newStudentClass + " 班吗", "doSaveAJAX", saveType);
            } else if (saveType === "Class") {
                const newClassName = $('#classAddName').val();
                const newClassSpec = $('#classAddSpec option:selected').text();

                awakePrompt("NORMAL_REMIND", "新增班级", "确定新增 " + newClassName + " 到 " + newClassSpec + " 专业吗?", "doSaveAJAX", saveType);

            } else if (saveType === "Spec") {
                const newSpecName = $('#specAddName').val();
                const newSpecCollegeName = $('#specAddCollege option:selected').text();

                awakePrompt("NORMAL_REMIND", "新增专业", "确定新增 " + newSpecName + " 专业     到 " + newSpecCollegeName + " 吗", "doSaveAJAX", saveType);
            } else if (saveType === "Venture") {
                const ventureName = $('#ventureName').val();
                const ventureBelongCollege = $('#ventureAddCollege option:selected').text();
                const ventureBelongSpec = $('#ventureAddSpec option:selected').text();
                const ventureBelongClass = $('#ventureAddClass option:selected').text();

                const venBelongString = ventureBelongCollege + ":" + ventureBelongSpec + ":" + ventureBelongClass;

                awakePrompt("NORMAL_REMIND", "新增假期", "确定新增假期 " + ventureName + " 到 " + venBelongString + " 吗?", "doSaveAJAX", saveType);

            }
        }

        function doSaveAJAX(saveType) {
            const sessionID = "<%=request.getSession().getId()%>";

            let saveDataList

            if (saveType === "Student") {
                const newStudentName = $('#stuAddName').val();
                const newStudentSex = $("#stuAddSex").val();
                const newStudentCollege = $('#stuAddCollege option:selected').text();
                const newStudentSpec = $('#stuAddSpec').val();
                const newStudentClassCode = $('#stuAddClass').val();
                const newStudentClassName = $('#stuAddClass option:selected').text();
                const newStudentTelephone = $('#stuAddTelephone').val();
                const newStudentTime = $('#stuAddTime').val();

                if (newStudentName === "" || newStudentTelephone === "") {
                    awakePrompt("ERROR", "新增操作", "操作失败，请检查学生信息填写完整性!", null, null);
                    return;
                }

                saveDataList = {
                    saveType: "student",
                    saveName: newStudentName,
                    saveSex: newStudentSex,
                    saveCollege: newStudentCollege,
                    saveSpec: newStudentSpec,
                    saveClassCode: newStudentClassCode,
                    saveClassName: newStudentClassName,
                    saveTelephone: newStudentTelephone,
                    saveTime: newStudentTime
                }
            } else if (saveType === "Class") {
                const newClassName = $('#classAddName').val();
                const newClassSpecCode = $('#classAddSpec').val();
                const newClassSpecName = $('#classAddSpec option:selected').text();
                const newClassStartTime = $('#classAddYear').val();

                saveDataList = {
                    saveType: "class",
                    saveName: newClassName,
                    saveSpecCode: newClassSpecCode,
                    saveSpecName: newClassSpecName,
                    saveTime: newClassStartTime
                }
            } else if (saveType === "Spec") {
                const newSpecName = $('#specAddName').val();
                const specCollegeCode = $('#specAddCollege').val();

                saveDataList = {
                    saveType: "spec",
                    saveName: newSpecName,
                    saveCollegeCode: specCollegeCode,
                }
            } else if (saveType === "Venture") {
                const ventureName = $('#ventureName').val();
                const ventureType = $('#ventureType').val();
                const ventureStartDate = $('#ID-laydate-start-date-1').val();
                const ventureEndDate = $('#ID-laydate-end-date-1').val();
                const ventureBelongCollege = $('#ventureAddCollege option:selected').text();
                const ventureBelongSpec = $('#ventureAddSpec option:selected').text();
                const ventureBelongClass = $('#ventureAddClass option:selected').text();
                const ventureBelongCollegeCode = $('#ventureAddCollege').val();
                const ventureBelongSpecCode = $('#ventureAddSpec').val();
                const ventureBelongClassCode = $('#ventureAddClass').val();
                const ventureDes = $('#ventureDes').val();

                saveDataList = {
                    saveType: "venture",
                    ventureName: ventureName,
                    ventureType: ventureType,
                    ventureStartDate: ventureStartDate,
                    ventureEndDate: ventureEndDate,
                    ventureBelongCollege: ventureBelongCollege,
                    ventureBelongSpec: ventureBelongSpec,
                    ventureBelongClass: ventureBelongClass,
                    ventureBelongCollegeCode: ventureBelongCollegeCode,
                    ventureBelongSpecCode: ventureBelongSpecCode,
                    ventureBelongClassCode: ventureBelongClassCode,
                    ventureDes: ventureDes
                }
            }

            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "save",
                    saveDataList
                }, success: function (response) {

                    if (response === "417") {
                        awakePrompt("ERROR", "新增操作", "新增操作失败!非法手段及不正确的信息插入!", null, null);
                    } else {
                        if (saveType === "Student") {
                            awakePrompt("SUCCESS", "新增操作", "学生新增操作成功\n请记录(复制)下学生学号与密码,并及时通知学生!\n" + response, null, null);
                        } else if (saveType === "Class") {
                            awakePrompt("SUCCESS", "新增操作", "新增班级成功,请记录下班级名称及代号\n" + response, null, null);
                        } else if (saveType === "Spec") {
                            awakePrompt("SUCCESS", "新增操作", "新增专业成功,请记录下专业名称及代号\n" + response, null, null);
                        } else if (saveType === "Venture") {
                            awakePrompt("SUCCESS", "新增操作", "新增假期成功!\n假期号,假期名称,时间及所属:\n" + response, null, null);
                        }
                        cleanAllNewInput();
                    }


                }, error: function () {
                    awakePrompt("ERROR", "新增操作", "操作失败,请检查网络连接!", null, null)
                }
            });

        }

        function riskOperation(riskType, riskInfo) {

            let riskDataList;

            if (riskType === "resetPassword") {
                const opCell = riskInfo.parentNode.parentNode;
                const opCode = opCell.getElementsByTagName("td")[0].innerText;

                riskDataList = {
                    riskType: "resetStudentPassword",
                    riskTarget: "student",
                    riskCode: opCode
                };

                awakePrompt("RISK_REMIND", "重设密码操作", "确定对学号为 " + opCode + " 的同学进行重设密码操作吗?", "doRiskAJAX", riskDataList);
            } else if (riskType === "student_delete") {
                const opCell = riskInfo.parentNode.parentNode;
                const opCode = opCell.getElementsByTagName("td")[0].innerText;

                riskDataList = {
                    riskType: "delete",
                    riskTarget: "student",
                    riskCode: opCode
                }

                awakePrompt("RISK_REMIND", "删除操作", "确定对学号为 " + opCode + " 的同学进行不可逆的删除操作吗?", "doRiskAJAX", riskDataList);
            } else if (riskType === "userResetPassword") {
                const originPassword = $('#currentPassword').val();
                const changedPassword = $('#changedPassword').val();
                const twiceChangedPassword = $('#twiceChangedPassword').val();

                if (originPassword !== "" && changedPassword !== "" && twiceChangedPassword === changedPassword) {
                    riskDataList = {
                        riskType: "resetUserPassword",
                        userID:<%=userID%>,
                        originPassword: originPassword,
                        changedPassword: changedPassword
                    }

                    awakePrompt("NORMAL_REMIND", "修改密码", "确定修改自己的密码吗?", "doRiskAJAX", riskDataList);
                } else if (changedPassword !== twiceChangedPassword) {

                    awakePrompt("ERROR", "修改密码", "修改失败，前后输入新密码不一致,请重试", null, null);
                } else {
                    awakePrompt("ERROR", "修改密码", "修改密码失败，请检查是否输入密码", null, null);
                }

            } else if (riskType === "venture_delete") {
                const opCell = riskInfo.parentNode.parentNode;
                const opCode = opCell.getElementsByTagName("td")[0].innerText;

                riskDataList = {
                    riskType: "delete",
                    riskTarget: "venture",
                    riskCode: opCode
                };

                awakePrompt("RISK_REMIND", "删除操作", "确定对假期号为为 " + opCode + " 的假期进行不可逆的删除操作吗?\n假期删除后,假期收发记录仍然会留在档案中!请根据假期号进行批量删除!", "doRiskAJAX", riskDataList);
            } else if (riskType === "class_delete") {
                const opCell = riskInfo.parentNode.parentNode;
                const opCode = opCell.getElementsByTagName("td")[0].innerText;

                riskDataList = {
                    riskType: "delete",
                    riskTarget: "class",
                    riskCode: opCode
                };

                awakePrompt("RISK_REMIND", "删除操作", "确定对班级号为为 " + opCode + " 的班级进行不可逆的删除操作吗?\n班级删除后,班级学生记录会被一起删除!!!!\n!!!请再三确定!!!", "doRiskAJAX", riskDataList);
            } else if (riskType === "spec_delete") {
                const opCell = riskInfo.parentNode.parentNode;
                const opCode = opCell.getElementsByTagName("td")[0].innerText;

                riskDataList = {
                    riskType: "delete",
                    riskTarget: "spec",
                    riskCode: opCode
                };

                awakePrompt("RISK_REMIND", "删除操作", "确定对专业号为为 " + opCode + " 的专业进行不可逆的删除操作吗?\n专业删除后,班级,学生记录会被一起删除!!!!\n!!!请再三确定!!!", "doRiskAJAX", riskDataList);
            }

        }


        function doRiskAJAX(riskDataList) {
            const sessionID = "<%=request.getSession().getId()%>";
            const posterToken = $('#risk_action_token').val();


            $.ajax({
                url: '/StudentVentures_Hub/poster_home-controller',
                dataType: 'text',
                type: 'POST',
                data: {
                    Authorization: sessionID,
                    action: "risk",
                    riskDataList,
                    posterID:<%=userID%>,
                    riskToken: posterToken
                }, success: function (response) {

                    if (response === "401") {
                        awakePrompt("ERROR", "操作失败", "认证密码错误,请确定密码后进行操作", null, null);
                    } else if (response === "404") {
                        awakePrompt("ERROR", "操作失败", "404找不到对象", null, null);
                    } else {
                        if (riskDataList['riskTarget'] === "student" && riskDataList['riskType'] === "resetStudentPassword") {
                            awakePrompt("SUCCESS", "重设密码操作", "重设密码操作成功,请记住密码并转达给该学生\n学生学籍号:" + riskDataList['riskCode'] + "\n学生密码:" + response, null, null);
                            queryInfos("student");
                        } else if (riskDataList['riskTarget'] === "student" && riskDataList['riskType'] === "delete") {
                            awakePrompt("SUCCESS", "删除操作", "删除学生成功!\n被学生学籍号:" + response, null, null);
                            queryInfos("student");
                        } else if (riskDataList['riskType'] === "resetUserPassword" && response !== "401") {
                            alert("密码修改成功,回到主页重新登录!");
                            goIndex();
                        } else if (riskDataList['riskType'] === "delete" && riskDataList['riskTarget'] === "venture") {
                            awakePrompt("SUCCESS", "删除操作", "删除假期成功!\n被删除假期号:" + response, null, null);
                            queryInfos("venture");
                        } else if (riskDataList['riskType'] === "delete" && riskDataList['riskTarget'] === "class") {
                            awakePrompt("SUCCESS", "删除操作", "删除班级成功!\n被删除班级号:" + response, null, null);
                            queryInfos("class");
                        } else if (riskDataList['riskType'] === "delete" && riskDataList['riskTarget'] === "spec") {
                            awakePrompt("SUCCESS", "删除操作", "删除专业成功!\n被删除专业号:" + response, null, null);
                            queryInfos("spec");
                        }
                    }

                }, error: function () {
                    awakePrompt("ERROR", "操作失败", "请检查网络连接!", null, null);
                }
            });

        }

        function uploadIcon() {
            const fileInput = $("#Icon_Input")[0];
            const formData = new FormData();

            if (fileInput.files.length !== 1) {
                awakePrompt("ERROR", "上传失败", "只能上传一个头像文件", null, null);
                return;
            }

            const allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
            if (!allowedExtensions.exec(fileInput.value)) {
                awakePrompt("ERROR", "上传失败", "上传文件格式错误", null, null);
                return;
            }

            formData.append("iconFile", fileInput.files[0]);

            $.ajax({
                type: "POST",
                url: "/StudentVentures_Hub/user-controller",
                data: formData,
                contentType: false,
                processData: false,
                success: function (response) {

                    if (response === "500") {
                        awakePrompt("ERROR", "上传失败!", "上传失败,请等待一段时间后上传", null, null);
                    } else if (response === "200") {
                        awakePrompt("SUCCESS", "上传成功!", "头像上传成功,刷新界面即可查看更改头像", null, null);
                    } else if (response === "401") {
                        awakePrompt("ERROR", "上传失败!", "上传失败,请登录后重试", null, null);
                    }

                },
                error: function (error) {
                    awakePrompt("ERROR", "上传失败!", "网络错误,请等待一段时间后上传", null, null);
                }
            });
        }

        function downloadSheet() {
            const ventureCode = $('#fill-out_ventureCode').text();

            $.get({
                url: '/StudentVentures_Hub/poster_home-controller',
                data: {
                    action: "downloadVentureCollect",
                    ventureCode: ventureCode
                },
                xhrFields: {
                    responseType: 'blob'
                },
                success: function (data) {
                    const blob = new Blob([data]);

                    const link = document.createElement('a');
                    link.href = window.URL.createObjectURL(blob);

                    link.download = ventureCode + '.xlsx';

                    document.body.appendChild(link);
                    link.click();

                    document.body.removeChild(link);
                },
                error: function (error) {
                    console.error('Error:', error);
                }
            });
        }

        function createPie(fillNum, outNum) {

            if (fillNum === 0 && outNum === 0) {
                document.getElementById('pieContainer').style.display = 'none';
                return
            }

            document.getElementById('pieContainer').style.display = 'block';

            const pie = echarts.init(document.getElementById('pieContainer'));

            const pieOption = {

                    title: {
                        text: '填写状况',
                        left: 'center'
                    },

                    tooltip: {
                        show: true,
                        trigger: "item",
                        backgroundColor: "#ffffff",
                        formatter: "{a}：{b}<br/>{c}个({d}%)"
                    },
                    color: ['#bd4432', '#40a4a9'],
                    series: [
                        {
                            name: '填写人数',
                            type: 'pie',
                            radius: '50%',
                            label: {
                                fontSize: 16
                            },
                            data: [
                                {value: fillNum, name: '填写人数'},
                                {value: outNum, name: '未填人数'}
                            ],
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            },
                            z: 2
                        }
                    ]
                }
            ;
            pie.setOption(pieOption);

        }

        function cleanAllNewInput() {

            $('#stuAddName').val("");
            $('#stuAddTelephone').val("");

            $('#classAddName').val("");
            $('#specAddName').val("");

            $('#ventureName').val("");
            $('#ventureDes').val("");

        }

        function changeStuAddPage(targetDOM) {
            $('.home_studentManage_add').hide();
            $("#" + targetDOM).show();

            if (targetDOM === "SM_Class") {
                queryInfos("class");
            } else if (targetDOM === "SM_Spec") {
                queryInfos("spec");
            } else if (targetDOM === "SM_College") {
                queryInfos("college");
            }
        }

        function backToList() {
            $('#home_ventureManage_list').toggle();
            $('#home_ventureManage_content').toggle();
            queryInfos('venture');
        }


        function goIndex() {
            window.location.href = "${pageContext.request.contextPath}/index.jsp";
        }

        function collectToList() {
            $('#collectList_container').toggle();
            $('#collectItem_container').toggle();
        }

        document.addEventListener("DOMContentLoaded", function () {
            $('.replace_account_Btn').on('click', function () {
                window.location.href = "${pageContext.request.contextPath}/index.jsp";
            });

            $('#second_order_student_manager').on("click", () => queryInfos('student'));
            $('#filter_submit_homeStudentQuery').on("click", () => queryInfos('student'));
            $('#filter_refresh_homeStudentQuery').on("click", () => queryInfos('student'));
            $("#filter_input_homeStudentQuery").on("keypress", function (event) {
                if (event.keyCode === 13 && $('#home_studentManage_manage').css("display") !== 'none') {
                    queryInfos('student');
                }
            });

            $('#second_order_ventures_manager').on("click", () => queryInfos('venture'));
            $('#filter_submit_homeVentureQuery').on("click", () => queryInfos('venture'));
            $('#filter_refresh_homeVentureQuery').on("click", () => queryInfos('venture'));
            $("#filter_input_homeVentureQuery").on("keypress", function (event) {
                if (event.keyCode === 13 && $('#home_ventureManage_manage').css("display") !== 'none') {
                    queryInfos('venture');
                }
            });


            document.getElementById("second_order_ventures_add").addEventListener('click', function () {
                addInfoCollegeRequest("VentureAddForm");
            });

            document.getElementById("normal_operation_confirm").addEventListener("click", function () {
                document.getElementById("normal_remind").style.display = 'none';
                document.getElementById("prompt_area").style.display = 'none';
            });

            document.getElementById("risk_operation_confirm").addEventListener("click", function () {
                document.getElementById("risk_remind").style.display = 'none';
                document.getElementById("prompt_area").style.display = 'none';
            });

            $('#task_tips_home_center').toggle();
            $('#task_tips_student_manager').toggle();
            $('#task_tips_collect_manager').toggle();
            $('#task_tips_ventures_manager').toggle();

            $('#second_order_collect_manager').on("click", function () {
                queryInfos("ventureCollectList");
            })
        });

        layui.use(function () {
            const laydate = layui.laydate;

            laydate.render({
                elem: '#ID-laydate-rangeLinked',
                range: ['#ID-laydate-start-date-1', '#ID-laydate-end-date-1'],
                keyboard: false
            });

            laydate.render({
                elem: '#ID-laydate-rangeLinked-changed',
                range: ['#ID-laydate-start-date-1-changed', '#ID-laydate-end-date-1-changed'],
                keyboard: false
            })

        });


    </script>
</body>
</html>

