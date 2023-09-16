<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <style type="text/css">

        p,h1,h2,h3,h4,h5,h6{
            display: inline-block;
        }

    </style>

</head>
<body>
<h1><%= "你好，世界!" %>
</h1>

<%

    int x = 2, y = 8;

%>

<h1>Answer is :<%=y / x%>
</h1>

<%@include file="Fragment.jsp" %>

<%

    for (int i = 0; i < 10; i++) {

        for (int j = 1; j <= i; j++) {

            if (i < 7)
                out.write("<h" + i + ">" + i + "x" + j + "=" + i * j + " " + "</h" + i + ">");

            if (i > 6 && i < 9) {
                out.write("<p>" + i + "x" + j + "=" + i * j + " " + "</p>");
            }

            if (i == 9)
                out.write(i + "x" + j + "=" + i * j + " ");

        }

        out.write("<br>");

    }

%>

<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="Result.jsp" method="get" id="result_form">

    Number1:<input type="number" name="num1">
    <br>
    Number2:<input type="number" name="num2">
    <br>
    <input type="submit" value="Submit">

</form>

</body>
</html>