<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/12/17
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乐行学途-学生界面</title>
    <link rel="icon" href="../static/resources/index/LXXT_Logo.png">
    <link href="${pageContext.request.contextPath}/static/css/for_home.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/for_main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/thridPartFont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/layui-v2.9.2/layui/css/layui.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/Js/thirdPart/province.js" type="text/javascript"
            charset="utf-8"></script>
</head>
<body onload="getProvince()">

<%

    String userName = "";
    String userID = "";
    String userBelong = "";
    String userBelongID = "";
    String userType = "";
    String formTaskCount = "";

//    out.print(session.getId());

    if (session.getAttribute("userID") != null) {

        userID = session.getAttribute("userID").toString();
        userName = session.getAttribute("userName").toString();
        userBelong = session.getAttribute("userBelong").toString();
        userType = session.getAttribute("userType").toString();
        userBelongID = session.getAttribute("userBelongID").toString();

        if (userType.equals("管理员")) {
            response.sendRedirect(request.getContextPath() + "/index-controller");
        } else {
            formTaskCount = session.getAttribute("formTask").toString();
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
                <div id="task_tips_home_center" class="task_tips" style="display: none">
                    3
                </div>
            </button>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order1',1)"
             onmouseout="collapseSubMenu('sub_order1',1)">
            <button id="first_order_form_manager" class="first_order">
                <img src="${pageContext.request.contextPath}/static/resources/home/学生管理.png" alt="学生管理">
                表单管理
                <div id="task_tips_form_manager" class="task_tips" style="display: none">
                    <%=formTaskCount%>
                </div>
            </button>
            <div id="sub_order1" class="second_order_space">
                <button id="second_order_form_add" class="second_order">填写假期表单</button>
                <button id="second_order_history_form" class="second_order">查看历史填写表单</button>
            </div>
        </div>

        <div class="order_space" onmouseover="expandSubMenu('sub_order2',2)"
             onmouseout="collapseSubMenu('sub_order2',2)">
            <button id="first_order_other_manager" class="first_order">
                <img src="${pageContext.request.contextPath}/static/resources/home/场景管理.png" alt="假期表管理">
                其他
                <div id="task_tips_other_manager" class="task_tips" style="display: none">
                    3
                </div>
            </button>
            <div id="sub_order2" class="second_order_space">
                <button id="second_order_message" class="second_order">讯息</button>
                <button id="second_order_transform" class="second_order">我要转学</button>
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

    <button class="replace_account_Btn" onclick="goIndex()">
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

        <div id="home_add_form" class="mainPage">
            <div id="ventureList_container">

            </div>
            <div id="VentureItem_fill-out" class="VentureItemPage_fill-out" style="display: none">
                <div class="VentureItemPage_ventureInfo">
                    <p>假期号:<span id="fill-out_ventureCode"></span></p><br>
                    <p>假期名称:<span id="fill-out_ventureName"></span></p><br>
                    <p>假期类型:<span id="fill-out_ventureType"></span></p><br>
                    <p>假期所属:<span id="fill-out_ventureBelong"></span></p><br>
                    <p>假期持续时间:<span id="fill-out_ventureDate"></span></p><br>
                    <p>假期描述:<span id="fill-out_ventureDes"></span></p><br>
                </div>
                <div class="VentureItem_fill-out-selector">
                    <h1>假期去向填写</h1>
                    <p style="font-size: 18px;font-weight: bolder;margin-top: 7px">目的地:</p>
                    <div style="margin-top: 10px">
                        <label style="margin-left: 10px" for="province"></label><select class="Venture_select_short"
                                                                                        id="province"
                                                                                        onchange="chooseProvince(this)">
                        <option value="1">请选择省</option>
                    </select>
                        <label style="margin-left: 10px" for="city"></label><select class="Venture_select_short"
                                                                                    id="city"
                                                                                    onchange="chooseCity(this)">
                        <option value="2">请选择市</option>
                    </select>
                        <label style="margin-left: 10px" for="area"></label><select class="Venture_select_short"
                                                                                    id="area">
                        <option value="3">请选择区</option>
                    </select>
                    </div>
                </div>
                <div style="width: 100%;height: auto">
                    <h3>详细地址:</h3>
                    <textarea id="TargetArea" class="Des_textArea" style="height: 60px"
                              placeholder="请输入详细地址......"></textarea>
                </div>
                <div style="width: 100%;height: auto">
                    <h3>其他描述(乘坐载具,到达方式等):</h3>
                    <textarea id="OtherDes" class="Des_textArea" placeholder="请输入其他描述......"></textarea>
                </div>
                <div class="Venture_label" style="justify-content: center">
                    <button id="formConfirm" class="NewConfirmBtn" onclick="saveInfos('ventureForm','END_AWAKE')"
                            style="margin-right: 10px">提交去向
                    </button>
                    <button id="formDenied" class="NewConfirmBtn" onclick="formToListNewForm()"
                            style="margin-left: 10px">返回
                    </button>
                </div>
            </div>
        </div>

        <div id="home_history_form" class="mainPage">
            <div id="historyVentureList_container" style="overflow-x: hidden">

            </div>

            <div id="HistoryVentureItem_fill-out" class="VentureItemPage_fill-out" style="display: none">
                <div class="VentureItemPage_ventureInfo">
                    <p>假期号:<span id="history_fill-out_ventureCode"></span></p><br>
                    <p>假期名称:<span id="history_fill-out_ventureName"></span></p><br>
                    <p>假期类型:<span id="history_fill-out_ventureType"></span></p><br>
                    <p>假期所属:<span id="history_fill-out_ventureBelong"></span></p><br>
                    <p>假期持续时间:<span id="history_fill-out_ventureDate"></span></p><br>
                    <p>假期描述:<span id="history_fill-out_ventureDes"></span></p><br>
                </div>
                <div class="VentureItem_fill-out-selector">
                    <h1>假期去向填写</h1>
                    <p style="font-size: 18px;font-weight: bolder;margin-top: 7px">目的地:</p>
                    <div style="margin-top: 10px">
                        <label style="margin-left: 10px" for="province"></label><select class="Venture_select_short"
                                                                                        id="history_province"
                                                                                        onchange="chooseProvince(this)">
                        <option value="1">请选择省</option>
                    </select>
                        <label style="margin-left: 10px" for="city"></label><select class="Venture_select_short"
                                                                                    id="history_city"
                                                                                    onchange="chooseCity(this)">
                        <option value="2">请选择市</option>
                    </select>
                        <label style="margin-left: 10px" for="area"></label><select class="Venture_select_short"
                                                                                    id="history_area">
                        <option value="3">请选择区</option>
                    </select>
                    </div>
                </div>
                <div style="width: 100%;height: auto">
                    <h3>详细地址:</h3>
                    <textarea id="history_TargetArea" class="Des_textArea" style="height: 60px"
                              placeholder="请输入详细地址......"></textarea>
                </div>
                <div style="width: 100%;height: auto">
                    <h3>其他描述(乘坐载具,到达方式等):</h3>
                    <textarea id="history_OtherDes" class="Des_textArea" placeholder="请输入其他描述......"></textarea>
                </div>
                <div class="Venture_label" style="justify-content: center">
                    <button id="history_formConfirm" class="NewConfirmBtn"
                            onclick="updateInfos('ventureForm','END_AWAKE')"
                            style="margin-right: 10px">提交去向
                    </button>
                    <button id="history_formDenied" class="NewConfirmBtn" onclick="formToListHistory()"
                            style="margin-left: 10px">返回
                    </button>
                </div>
            </div>

        </div>

        <div id="home_other_message" class="mainPage">
            其他->讯息
        </div>

        <div id="home_other_transform" class="mainPage">
            其他->我要转学
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
<script src="${pageContext.request.contextPath}/static/Js/home/HomeStuSideBarAnimation.js"></script>
<script>

    const ventureListItem_HTML = "<div class=\"VentureForm_ListItem\">" +
        "<div class=\"ItemHead\">" +
        "<p style=\"font-style: italic\">假期去向表单填写提醒</p>" +
        "<p class=\"ItemTitle\">" +
        "假期名称:<span>{{VentureName}}</span>" +
        " </p>" +
        "</div>" +
        "<div class=\"ItemBody\">" +
        "<p style=\"margin-right: 10px\">假期所属:<span>{{VentureBelong}}</span></p>" +
        "<p>假期持续日期:<span>{{VentureStartDate}} </span>到<span> {{VentureEndDate}}</span></p>" +
        " </div>" +
        "<div class=\"ItemBtnContainer\">" +
        "<button data-item-code=\"{{VentureCode}}\" class=\"ItemBtn\" onclick=\"queryInfos('ventureItem',this)\">进入填写</button>" +
        "</div>" +
        "</div>"

    const historyVentureListItem_HTML = "<div class=\"VentureForm_ListItem\">" +
        "<div class=\"ItemHead\">" +
        "<p style=\"font-style: italic\">历史假期去向表单</p>" +
        "<p class=\"ItemTitle\">" +
        "假期名称:<span>{{VentureName}}</span>" +
        " </p>" +
        "</div>" +
        "<div class=\"ItemBody\">" +
        "<p style=\"margin-right: 10px\">假期所属:<span>{{VentureBelong}}</span></p>" +
        "<p>假期持续日期:<span>{{VentureStartDate}} </span>到<span> {{VentureEndDate}}</span></p>" +
        " </div>" +
        "<div class=\"ItemBtnContainer\">" +
        "{{VentureState}}" +
        "</div>" +
        "</div>"

    const historyVentureList_fillOutBtn = "<button data-item-code=\"{{VentureCode}}\" class=\"ItemBtn\" onclick=\"queryInfos('historyVentureItem',this)\">修改表单</button>";

    const sessionID = "<%=request.getSession().getId()%>";

    function queryInfos(type, btn) {

        let queryAttendInfo;

        if (type === "ventureItem" || type === "historyVentureItem") {
            queryAttendInfo = {
                ventureCode: btn.dataset.itemCode
            }
        }

        $.ajax({
            url: '/StudentVentures_Hub/student_home-controller',
            dataType: 'text',
            type: 'POST',
            data: {
                Authorization: sessionID,
                action: "query",
                queryType: type,
                classCode: "<%=userBelongID%>",
                studentCode: "<%=userID%>",
                queryAttendInfo
            },
            success: function (response) {

                if (response === "404") {
                    awakePrompt("ERROR", "查看假期列表", "找不到列表,请重试", null, null);
                    return;
                } else if (response === "401") {
                    awakePrompt("ERROR", "查看假期列表", "没有访问权限,请登录后重新操作", null, null);
                    return;
                }

                if (type === "ventureList") {
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

                    $('#ventureList_container').html(ventureListHTML);
                } else if (type === "ventureItem") {

                    const responseList = response.split('&&');

                    $('#fill-out_ventureCode').text(responseList[0]);
                    $('#fill-out_ventureName').text(responseList[1]);
                    $('#fill-out_ventureType').text(responseList[2]);
                    $('#fill-out_ventureBelong').text(responseList[3]);
                    $('#fill-out_ventureDate').text(responseList[4]);
                    $('#fill-out_ventureDes').text(responseList[5]);

                    formToListNewForm();
                } else if (type === "historyVentureList") {

                    let ventureTempHTML = "";
                    let ventureListHTML = "";
                    const ventureList = response.split("-item-");

                    for (const venture of ventureList) {

                        const ventureCell = venture.split("-cell-");
                        ventureTempHTML = historyVentureListItem_HTML;

                        ventureTempHTML = ventureTempHTML.replace('{{VentureName}}', ventureCell[0])
                            .replace('{{VentureBelong}}', ventureCell[1])
                            .replace('{{VentureStartDate}}', ventureCell[2])
                            .replace('{{VentureEndDate}}', ventureCell[3]);

                        if (ventureCell[5] === "未过期") {
                            ventureTempHTML = ventureTempHTML.replace('{{VentureState}}', historyVentureList_fillOutBtn);
                            ventureTempHTML = ventureTempHTML.replace('{{VentureCode}}', ventureCell[4]);
                        } else {
                            ventureTempHTML = ventureTempHTML.replace('{{VentureState}}', "已过期");
                        }
                        ventureListHTML += ventureTempHTML;

                    }
                    $('#historyVentureList_container').html(ventureListHTML);
                } else if (type === "historyVentureItem") {

                    const responseList = response.split('&&');

                    $('#history_fill-out_ventureCode').text(responseList[0]);
                    $('#history_fill-out_ventureName').text(responseList[1]);
                    $('#history_fill-out_ventureType').text(responseList[2]);
                    $('#history_fill-out_ventureBelong').text(responseList[3]);
                    $('#history_fill-out_ventureDate').text(responseList[4]);
                    $('#history_fill-out_ventureDes').text(responseList[5]);

                    const targetList = responseList[6].split('##');
                    const selectorList = targetList[0].split(" ");

                    $("#history_province option:contains('" + selectorList[0] + "')").prop("selected", true);
                    $("#history_province").change();
                    $("#history_city option:contains('" + selectorList[1] + "')").prop("selected", true);
                    $("#history_city").change();
                    $("#history_area option:contains('" + selectorList[2] + "')").prop("selected", true);


                    $('#history_TargetArea').text(targetList[1]);

                    $('#history_OtherDes').text(responseList[7]);

                    formToListHistory();
                }

            }, error: function () {

                awakePrompt("ERROR", "请求列表", "网络错误或服务器关闭", null, null);

            }
        });
    }

    function saveInfos(itemType, operationType) {

        let saveDataList;

        if (operationType === "END_AWAKE") {

            if (itemType === "ventureForm") {

                const otherDes = $('#OtherDes').val();
                const targetArea = $('#TargetArea').val();

                const province_text = $('#province option:selected').text();
                const city_text = $('#city option:selected').text();
                const area_text = $('#area option:selected').text();

                if (otherDes === "" || targetArea === "" || province_text === "请选择省" || city_text === "请选择市" || area_text === "请选择区") {
                    awakePrompt("ERROR", "信息不完整", "请填写完整信息", null, null);
                    return;
                }

                saveDataList = {
                    saveType: itemType,
                    studentCode: "<%=userID%>",
                    ventureCode: $('#fill-out_ventureCode').text(),
                    ventureName: $('#fill-out_ventureName').text(),
                    studentName: "<%=userName%>",
                    ventureTarget: province_text + " " + city_text + " " + area_text + " " + "##" + targetArea,
                    ventureOtherDes: otherDes
                }

                awakePrompt("NORMAL_REMIND", "提交假期表单", "确定填写了正确信息并且进行提交吗?", "doSaveAJAX", saveDataList);

            }
        } else if (operationType === "RISK_AWAKE") {

        }

    }

    function doSaveAJAX(saveDataList) {

        $.ajax({
            url: '/StudentVentures_Hub/student_home-controller',
            dataType: 'text',
            type: 'POST',
            data: {
                Authorization: sessionID,
                action: "save",
                saveDataList
            },
            success: function (response) {

                if (response === "401") {
                    awakePrompt("ERROR", "提交去向表", "没有该项操作权限,请登录后重试!", null, null);
                    return;
                }

                if (saveDataList['saveType'] === "ventureForm") {
                    awakePrompt("SUCCESS", "提交成功", "需要改动请查看历史假期表单", null, null);
                    formToListNewForm();
                    queryInfos("ventureList", null);
                }

            }, error: function () {

                awakePrompt("ERROR", "请求列表", "网络错误或服务器关闭", null, null);

            }
        });
    }

    function updateInfos(itemType) {

        let updateDataList;

        if (itemType === "ventureForm") {

            const otherDes = $('#history_OtherDes').val();
            const targetArea = $('#history_TargetArea').val();

            const province_text = $('#history_province option:selected').text();
            const city_text = $('#history_city option:selected').text();
            const area_text = $('#history_area option:selected').text();

            if (otherDes === "" || targetArea === "" || province_text === "请选择省" || city_text === "请选择市" || area_text === "请选择区") {
                awakePrompt("ERROR", "信息不完整", "请填写完整信息", null, null);
                return;
            }

            updateDataList = {
                updateType: itemType,
                studentCode: "<%=userID%>",
                ventureCode: $('#history_fill-out_ventureCode').text(),
                ventureTarget: province_text + " " + city_text + " " + area_text + " " + "##" + targetArea,
                ventureOtherDes: otherDes
            }

            awakePrompt("NORMAL_REMIND", "修改假期表单", "确定修改了正确信息并且进行提交吗?", "doUpdateAJAX", updateDataList);

        }
    }

    function doUpdateAJAX(updateDataList) {

        $.ajax({
            url: '/StudentVentures_Hub/student_home-controller',
            dataType: 'text',
            type: 'POST',
            data: {
                Authorization: sessionID,
                action: "update",
                updateDataList
            },
            success: function (response) {

                if (response === "401") {
                    awakePrompt("ERROR", "提交去向表", "没有该项操作权限,请登录后重试!", null, null);
                    return;
                }

                if (updateDataList['updateType'] === "ventureForm") {
                    awakePrompt("SUCCESS", "提交成功", "历史假期表单更改成功", null, null);
                    formToListHistory();
                    queryInfos("historyVentureList", null);
                }

            }, error: function () {
                awakePrompt("ERROR", "请求列表", "网络错误或服务器关闭", null, null);
            }
        });
    }

    function riskOperation(riskType, riskInfo) {

        let riskDataList;

        if (riskType === "userResetPassword") {
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
                    if (riskDataList['riskType'] === "resetUserPassword" && response !== "401") {
                        alert("密码修改成功,回到主页重新登录!");
                        goIndex();
                    }
                }

            }, error: function () {
                awakePrompt("ERROR", "操作失败", "请检查网络连接!", null, null);
            }
        });

    }


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

            normal_remind.style.display = 'none';
            operation_success.style.display = 'none';
            operation_error.style.display = 'none';

            risk_remind.style.display = 'block';

            continuePrompt(type, targetOperation, targetOperationParma);
        } else if (type === "NORMAL_REMIND") {
            normal_remind_title.innerText = title;
            normal_remind_context.innerText = context;

            risk_remind.style.display = 'none';
            operation_success.style.display = 'none';
            operation_error.style.display = 'none';

            normal_remind.style.display = 'block';

            continuePrompt(type, targetOperation, targetOperationParma);
        } else if (type === "SUCCESS") {
            operation_success_title.innerText = title;
            operation_success_context.innerText = context;

            normal_remind.style.display = 'none';
            risk_remind.style.display = 'none';
            operation_error.style.display = 'none';

            operation_success.style.display = 'block';
        } else if (type === "ERROR") {
            operation_error_title.innerText = title;
            operation_error_context.innerText = context;

            normal_remind.style.display = 'none';
            risk_remind.style.display = 'none';
            operation_success.style.display = 'none';

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

    function uploadIcon() {
        const fileInput = $("#Icon_Input")[0];
        const formData = new FormData();

        if (fileInput.files.length !== 1) {
            awakePrompt("ERROR","上传失败","只能上传一个头像文件",null,null);
            return;
        }

        const allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
        if (!allowedExtensions.exec(fileInput.value)) {
            awakePrompt("ERROR","上传失败","上传文件格式错误",null,null);
            return;
        }

        formData.append("iconFile", fileInput.files[0]);

        $.ajax({
            type: "POST",
            url: "/StudentVentures_Hub/user-controller",
            data: formData,
            contentType: false,
            processData: false,
            success: function(response) {

                if (response === "500"){
                    awakePrompt("ERROR","上传失败!","上传失败,请等待一段时间后上传",null,null);
                }else if(response === "200"){
                    awakePrompt("SUCCESS","上传成功!","头像上传成功,刷新界面即可查看更改头像",null,null);
                }else if (response === "401"){
                    awakePrompt("ERROR","上传失败!","上传失败,请登录后重试",null,null);
                }

            },
            error: function(error) {
                awakePrompt("ERROR","上传失败!","网络错误,请等待一段时间后上传",null,null);
            }
        });
    }


    function taskLoading() {
        const formTaskCount = "<%=formTaskCount%>";

        if (formTaskCount !== "0") {
            $('#task_tips_form_manager').toggle();
        }
    }

    function formToListNewForm() {
        $('#ventureList_container').toggle();
        $('#VentureItem_fill-out').toggle();
    }

    function formToListHistory() {
        $('#historyVentureList_container').toggle();
        $('#HistoryVentureItem_fill-out').toggle();
    }

    function cleanFormInfos() {
        $('#TargetArea').text("");
        $('#OtherDes').text("");
    }

    function goIndex() {
        window.location.href = "${pageContext.request.contextPath}/index.jsp";
    }

    taskLoading();

    $('#second_order_form_add').on("click", function () {
        queryInfos('ventureList', null);
    });
    $('#second_order_history_form').on("click", () => queryInfos('historyVentureList', null));
</script>
</body>
</html>
