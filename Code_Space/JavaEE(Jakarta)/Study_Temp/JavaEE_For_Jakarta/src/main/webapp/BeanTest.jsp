<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/19
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaBeanTest</title>
</head>
<body>

    <jsp:useBean id="student" class="com.forjakarta.javaee_for_jakarta.Student">
        <jsp:setProperty name="student" property="no" value="2106504987"/>
        <jsp:setProperty name="student" property="name" value="艾诺"/>
        <jsp:setProperty name="student" property="address" value="诸王峡谷"/>
        <jsp:setProperty name="student" property="age" value="200"/>
    </jsp:useBean>

    学号：<jsp:getProperty name="student" property="no"/><br>
    年龄：<jsp:getProperty name="student" property="age"/><br>
    姓名：<jsp:getProperty name="student" property="name"/><br>
    地址：<jsp:getProperty name="student" property="address"/><br>

</body>
</html>
