<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/12
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>

<a href="OnLogin.jsp">点击跳转回登录页面</a>

<br>

<%

    if (session.getAttribute("user") == null) {
        out.println("<script>" +
                "alert('请先登录');" +
                "window.location.href='OnLogin.jsp';</script>");
        return;
    }

    String user = (String) session.getAttribute("user");
    out.print("Welcome! " + user);

    response.setHeader("refresh","60,OnLogin.jsp");

%>

<br>

<form action="#" method="post">

    <button type="submit" formaction="Logout.jsp">登出</button>

</form>


</body>
</html>
