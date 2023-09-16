<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/9/7
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<%

    String number1=request.getParameter("num1");
    String number2=request.getParameter("num2");

    try{

        out.write("<p>"+number1+"+"+number2+"="+(Integer.parseInt(number1)+Integer.parseInt(number2))+"</p>");

    }catch (Exception e){
        out.write("<p>"+number1+"+"+number2+"="+"Error</p>");
    }

%>

</body>
</html>
