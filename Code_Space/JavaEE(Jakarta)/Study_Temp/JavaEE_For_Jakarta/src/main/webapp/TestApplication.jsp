<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/14
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web_System_Counter</title>
</head>
<body>

<%

    if (application.getAttribute("counter") == null) {
        application.setAttribute("counter", 1);
    }else{
        int counter=(int)application.getAttribute("counter");
        counter++;
        application.setAttribute("counter",counter);
    }

%>

<h3>You are Visit of Number:<%= application.getAttribute("counter")%></h3>

</body>
</html>
