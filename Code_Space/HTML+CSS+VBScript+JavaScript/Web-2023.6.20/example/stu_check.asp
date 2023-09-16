<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>显示学生数据</title>
<!--#include file="Conn_Access.asp"-->
<style type="text/css">
<!--
hr {
	color: #FF0000;
	background-color: #FF0000;
	border: #FF0000;
}
body,td,th {
	font-family: 宋体;
	font-size: 10pt;
}
-->
</style>
</head>

<body>
<form name="form1" method="post" action="">
<table width="600" border="1" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td width="75">学号：</td>
    <td width="525">
      <input name="sno_text" type="text" id="sno_text">
    </td>
  </tr>
  <tr>
    <td>姓名：</td>
    <td><input name="sname_text" type="text" id="sname_text"></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td><input type="radio" name="sex_radio" value="男">
      男      <input type="radio" name="sex_radio" value="女">
      女      <input type="radio" name="sex_radio" value="保密">
      保密</td>
  </tr>
  <tr>
    <td>系别：</td>
    <td><select name="dept_select" id="dept_select">
      <option value="全部" selected>---所有系---</option>
      <option value="中文系">中文系</option>
      <option value="数学系">数学系</option>
      <option value="计科系">计科系</option>
      <option value="外语系">外语系</option>
    </select></td>
  </tr>
  <tr>
    <td>爱好：</td>
    <td><input name="hobby_text" type="text" id="hobby_text"></td>
  </tr>
  <tr align="center">
    <td colspan="2"><input name="qurey_hidden" type="hidden" id="qurey_hidden" value="1">
      <input type="submit" name="Submit" value="查询"></td>
    </tr>
</table>
</form>
<%
dim sname,ssex,sno,sdept,shobby
dim snamesql,ssexsql,snosql,sdeptsql,shobbysql

sql="select * from student where true"

sname=trim(request.Form("sname_text"))
sno=trim(request.Form("sno_text"))
ssex=trim(request.Form("sex_radio"))
sdept=trim(request.Form("dept_select"))
shobby=trim(request.Form("hobby_text"))

if sno<>"" then
   snosql=" and stu_no='"&sno&"'"
end if

if sname<>"" then
   snamesql=" and stu_name like '%"&sname&"%'"
end if

if ssex<>"" then
   ssexsql=" and stu_sex='"&ssex&"'"
end if

if request.Form("qurey_hidden")=1 then
sql=sql&snosql&snamesql&ssexsql
response.Write sql
%>
<hr size="2">

<table width="700" border="1" align="center">
  <tr>
    <td align="center" bgcolor="#FFFF99">序号</td>
    <td align="center" bgcolor="#FFFF99">姓名</td>
    <td align="center" bgcolor="#FFFF99">学号</td>
    <td align="center" bgcolor="#FFFF99">性别</td>
    <td align="center" bgcolor="#FFFF99">系别</td>
    <td align="center" bgcolor="#FFFF99">爱好</td>
    <td align="center" bgcolor="#FFFF99">简历</td>
  </tr>
<%

	OpenDB
	rs.open sql,conn,1,1
	if not rs.eof then
	   rs.movefirst
	end if
	do while not rs.eof
%>
  <tr>
    <td width="58"><%response.write rs("stu_id")%></td>
    <td width="62"><%response.write rs("stu_name")%></td>
    <td width="63"><%response.write rs("stu_no")%></td>
    <td width="69"><%response.write rs("stu_sex")%></td>
    <td width="88"><%response.write rs("stu_dep")%></td>
    <td width="170"><%response.write rs("stu_aihao")%></td>
    <td width="144"><%response.write rs("stu_jianli")%></td>
  </tr>
<%
	rs.movenext
	loop
	CloseDB
%>
</table>
<%
end if
%>
</body>
</html>
