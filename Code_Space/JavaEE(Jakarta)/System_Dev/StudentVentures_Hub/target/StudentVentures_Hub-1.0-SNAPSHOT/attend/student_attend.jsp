<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>乐行学途-申请入学</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/resources/index/LXXT_Logo.png">
    <link href="${pageContext.request.contextPath}/static/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/static/css/for_main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/for_home.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/thridPartFont.css" rel="stylesheet">
</head>

<body>
<div class="home_addNewMessage_Part" style="width: 100%;margin-top: 100px">
    <p style="color: #0b4862;font-size: 40px;margin-bottom: 0;margin-top: 10px;font-family: Auto_Pen, 黑体, Arial, sans-serif">
        !填写入学信息!</p>

    <form name="addForm" class="addForm" id="stuAddForm" action="${pageContext.request.contextPath}/attend-controller" method="post">

        <div class="addForm_div">学生姓名:<input name="stuAddName" id="stuAddName" class="addForm_input" type="text">
        </div>
        <div class="addForm_div">学生性别:
            <select name="stuAddSex" id="stuAddSex" class="addForm_select">
                <option selected="selected" value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>

        <div class="addForm_div">所属学院:
            <select name="stuAddCollege" id="stuAddCollege" class="addForm_select"
                    onchange="addInfoSpecRequest(this,'stuAddSpec')">

            </select>
        </div>

        <div class="addForm_div">所属专业:
            <select name="stuAddSpec" id="stuAddSpec" class="addForm_select"
                    onchange="addInfoClassRequest(this,'stuAddClass')">

            </select>
        </div>

        <div class="addForm_div">所属班级:
            <select name="stuAddClass" id="stuAddClass" class="addForm_select">

            </select>
        </div>

        <div class="addForm_div" style="margin-bottom: 10px">联系方式:<input name="stuAddTelephone"  id="stuAddTelephone" type="number"
                                                 class="addForm_input"></div>

        <div class="g-recaptcha" data-sitekey="6Lc5gj4pAAAAAKsjOj-BcxRcGO-iqlueMSgAwKir">

        </div>

        <div class="addForm_div">
            <button id="newStudentAddBtn" class="NewConfirmBtn" type="submit">
                提&nbsp;交
            </button>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/static/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/Jquery/jquery-3.7.1.js"></script>
<script src='https://www.recaptcha.net/recaptcha/api.js'></script>
<script>
    function addInfoCollegeRequest() {

        $.ajax({
            url: '/StudentVentures_Hub/attend_request-controller',
            dataType: 'text',
            type: 'POST',
            data: {
                action: "saveRequest",
                saveRequestType: "college",
            }, success: function (response) {
                $('#stuAddCollege').html(response);
                document.getElementById("stuAddCollege").onchange();
            }, error: function () {
                awakePrompt("ERROR", "学院选择请求", "请检查网络连接!", null, null);
            }

        });
    }

    function addInfoSpecRequest(onChangeSelect, responseSpecSelect) {

        $.ajax({
            url: '/StudentVentures_Hub/attend_request-controller',
            dataType: 'text',
            type: 'POST',
            data: {
                action: "saveRequest",
                saveRequestType: "spec",
                saveRequestFilter: onChangeSelect.value
            }, success: function (response) {
                $('#' + responseSpecSelect).html(response);
                document.getElementById(responseSpecSelect).onchange();
            }, error: function () {
                awakePrompt("ERROR", "班级选择请求", "请检查网络连接!", null, null);
            }
        });

    }

    function addInfoClassRequest(onChangeSelect, responseClassSelect) {
        $.ajax({
            url: '/StudentVentures_Hub/attend_request-controller',
            dataType: 'text',
            type: 'POST',
            data: {
                action: "saveRequest",
                saveRequestType: "class",
                saveRequestFilter: onChangeSelect.value
            }, success: function (response) {
                $('#' + responseClassSelect).html(response);
            }, error: function () {
                awakePrompt("ERROR", "班级选择请求", "请检查网络连接!", null, null);
            }
        });
    }

    const urlParams = new URLSearchParams(window.location.search);
    const alertMessage = urlParams.get('alertMessage');
    if (alertMessage) {
        alert(decodeURIComponent(alertMessage));
    }

    addInfoCollegeRequest();
</script>
</body>
</html>