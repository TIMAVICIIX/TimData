<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/26
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<%

    String loginName = "";
    String loginPwd = "";

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginName")) {
                loginName = cookie.getValue();
            } else if (cookie.getName().equals("password")) {
                loginPwd = cookie.getValue();
            }
        }
    }

%>

<form action="CookieResolve" method="get">

    <label>
        Name:
        <input type="text" name="inputName" value="<%=loginName%>" placeholder="Please input Name">
        <br>
        Pass:
        <input type="password" name="inputPwd" value="<%=loginPwd%>" placeholder="Please input Password">
        <br>
        <input type="checkbox" id="writeInfo" name="isWrite">Remember your account
        <br>
        <input type="submit" value="LOGIN">
    </label>


</form>

<script>

    // function changeValue() {
    //     let remember = document.getElementById("writeInfo");
    //     if (remember.checked() === true) {
    //         remember.value = "1";
    //     } else {
    //         remember.value = "0";
    //     }
    // }

</script>

</body>
</html>
