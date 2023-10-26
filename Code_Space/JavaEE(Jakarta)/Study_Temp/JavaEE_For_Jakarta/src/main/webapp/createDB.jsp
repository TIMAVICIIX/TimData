<%@ page import="com.forjakarta.javaee_for_jakarta.DBUtil" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/10/24
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>创建数据库</title>
</head>
<body>

    <%

        boolean isCreated = false;
        try {
            isCreated = DBUtil.INSTANCE.createBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    %>

    <h1>数据库创建:<%=isCreated%></h1>

</body>
</html>
