<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<!--#include file="Conn_SQL2005.asp"-->
</head>

<body>
<%
dim id,userclass
id=request.QueryString("id")
sql="select * from user_tb where userID="&id
OpenDB

rs.open sql,conn,1,3
if rs.RecordCount<>0 then
    userclass=trim(rs("userclass"))
	rs("adminpass")=1
    rs.update
end if
CloseDB
if userclass="学生" then
   response.Redirect("stu_admin.asp")
end if
if userclass="教师" then
   response.Redirect("teacher_admin.asp")
end if
%>
</body>
</html>
