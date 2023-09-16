<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出</title>
</head>
<body>

<%

    session.removeAttribute("user");
    out.println("<script>" +
            "window.location.href='OnLogin.jsp';</script>");

%>

</body>
</html>
