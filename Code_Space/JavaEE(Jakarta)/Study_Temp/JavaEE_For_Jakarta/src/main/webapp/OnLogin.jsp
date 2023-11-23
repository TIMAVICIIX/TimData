<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/12
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>w
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>

<form action="LoginControl.jsp" method="get">

    <label>
        <input type="text" name="login_name" required>
    </label><br>
    <label>
        <input type="password" name="login_pwd" required>
    </label><br>
    <input type="submit" value="登录">

</form>

<%
    String tempName;

    if (session.getAttribute("user") == null) {
        out.print("<script>alert('用户不存在')</script>");
    } else {

        tempName = (String) session.getAttribute("user");

        out.print("<script>alert('用户名为: "+tempName+"')</script>");

    }

%>

</body>
</html>
