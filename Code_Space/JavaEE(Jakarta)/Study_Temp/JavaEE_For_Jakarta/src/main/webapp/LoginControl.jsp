<%@ page import="java.util.Objects" %>
<%@ page import="javax.swing.*" %>
<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/12
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    String login_name = request.getParameter("login_name");
    String login_pwd = request.getParameter("login_pwd");

    if (Objects.equals(login_name, "admin") && Objects.equals(login_pwd, "123")) {
        out.println("登陆成功！！！");
        out.write("<script>" +
                "alert('登录成功!!!');" +
                "window.location.href='welcome.jsp'" +
                "</script>");

        session.setAttribute("user", login_name);
        session.setMaxInactiveInterval(60);

    } else {
        out.println("登陆失败！！！");
        out.write("<script>" +
                "alert('登录失败!!!');" +
                "window.location.href='OnLogin.jsp'" +
                "</script>");
    }

%>

</body>
</html>
