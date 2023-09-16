<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<style type="text/css">
<!--
body,td,th {
	font-family: 宋体;
	font-size: 10pt;
}
.style10 {font-size: 12pt; font-weight: bold; color: #CC0000; }
-->
</style>
<script type="text/javascript">
function deleteconfirm(id)
{
   if(confirm("您确定要删除该信息吗"))
   {
	  window.location.href="delete_user.asp?id="+id;
   }
}

function passconfirm(id)
{
   if(confirm("您确定要审批信息吗"))
   {
	  window.location.href="pass_user.asp?id="+id;
   }
}

function modifyconfirm(id)
{
   if(confirm("您确定要修改该信息吗"))
   {
	  window.location.href="modify_user.asp?id="+id;
   }
}
</script>
<!--#include file="Conn_SQL2005.asp"-->
</head>
<body>

<table width="600" border="1" cellpadding="0" cellspacing="0" bordercolor="#00FFFF">
  <tr align="center" bgcolor="#FFFFCC">
    <td><span class="style10">用户账号</span></td>
    <td><span class="style10">真实姓名</span></td>
    <td><span class="style10">注册时间</span></td>
    <td><span class="style10">注册IP地址</span></td>
    <td><span class="style10">审批否</span></td>
    <td colspan="3"><span class="style10">操作</span></td>
  </tr>
<%
sql="select * from user_tb where userclass='学生' order by adminpass desc,logindate desc"
OpenDB
rs.open sql,conn,1,1
if not rs.eof then
   rs.movefirst
end if
do while not rs.eof
%>
  <tr align="center">
    <td><%response.write rs("username")%></td>
    <td><%response.write rs("truename")%></td>
    <td><%response.write rs("logindate")%></td>
    <td><%response.write rs("loginip")%></td>
    <td><%if rs("adminpass")=0 then response.write "未审批" else response.write "已审批" end if%></td>
    <td><a href="javascript:passconfirm(<%response.write rs("userID")%>)" target="_self">审批</a></td>
    <td><a href="javascript:modifyconfirm(<%response.write rs("userID")%>)" target="_self">修改</a></td>
    <td><a href="javascript:deleteconfirm(<%response.write rs("userID")%>)" target="_self">删除</a></td>
  </tr>
<%
rs.movenext
loop
CloseDB
%>

</table>
</body>
</html>
