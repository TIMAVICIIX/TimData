<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加学生记录</title>
<!--#include file="Conn_SQL2005.asp"-->
<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-size: 12pt;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<%
dim username,truename,userpassword,userclass,logindate,loginip
username=request("usernametext")
truename=request("truenametext2")
userpassword=request("passwordtext")
userclass=request("userclass_select")
logindate=date
loginip=request.ServerVariables("REMOTE_ADDR")



sql="select * from user_tb"
OpenDB

rs.open sql,conn,1,3

 rs.addnew
    rs("username")=username
    rs("truename")=truename
    rs("userpassword")=userpassword
    rs("userclass")=userclass
    rs("logindate")=logindate
    rs("loginip")=loginip
  rs.update
CloseDB
response.Redirect("login.asp")
%>
<table width="400" height="100" border="1" align="center">
  <tr>
    <td align="center"><p class="style1">当前记录已经插入数据库</p>
    <p>是否继续添加记录 <a href="stu_form.html" target="_self">是</a>/<a href="javascript:windows.close();">否</a> </p></td>
  </tr>
</table>
</body>
</html>
