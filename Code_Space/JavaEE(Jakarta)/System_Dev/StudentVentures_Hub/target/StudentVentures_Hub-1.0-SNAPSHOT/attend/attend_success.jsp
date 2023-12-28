<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>乐行学途-申请入学:申请成功</title>
    <link href="${pageContext.request.contextPath}/static/css/for_main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/thridPartFont.css" rel="stylesheet">
</head>
<body>
<%

    String ReadyCode = "";
    String ReadyPassword = "";

    if (session.getAttribute("ReadyCode") == null){
        response.sendRedirect(request.getContextPath() + "/index-controller");
    }else{
        ReadyPassword = session.getAttribute("ReadyPassword").toString();
        ReadyCode = session.getAttribute("ReadyCode").toString();
    }

%>

<div style="width: 100%;height: 100%;display: flex;flex-direction: column;justify-content: center;align-items: center;font-family: Auto_Pen, 黑体, Arial, sans-serif">

    <h2 style="color: #1a1d20">!申请发送成功!</h2>
    <h3 style="color: #0b4862;font-family: 黑体, Arial, sans-serif">您的申请进度查询号:<span style="color: #2b3035"><%=ReadyCode%></span></h3>
    <h3 style="color: #0b4862;font-family: 黑体, Arial, sans-serif">您的申请进度密码号:<span style="color: #2b3035"><%=ReadyPassword%></span></h3>

    <button onclick="goToIndex()" style="width: 100px;height: 50px;margin-top: 50px;border: none;border-radius: 5px;background-color: #0b4862;color: #FFFFFF">返回乐行学途</button>
</div>

</body>

<script>

    function goToIndex(){
        window.location.href = "${pageContext.request.contextPath}/index.jsp";
    }

</script>

</html>