<%--
  Created by IntelliJ IDEA.
  User: 小吴同志的R7000P
  Date: 2023/10/7
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Your File</title>
</head>
<body>

    <form method="POST" action="UploadServlet" enctype="multipart/form-data">

        Choose A File or Multiple File:<input type="file" name="uploadFiles"/>
        <br>
        <input type="submit" value="Upload">

    </form>

</body>
</html>
