<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	background-color: #FFC;
}
body,td,th {
	font-family: 宋体;
	font-size: 10pt;
}
-->
</style>
<script type="text/javascript">
function modifyconfirm(id)
{
   if(confirm("您确定要修改该信息吗"))
   {
	  top.mainFrame.location.href="modify_password.asp?id="+id;
   }
}

</script>
</head>

<body>
<p>
<%

  if session("username")="" then
     response.Redirect("login.asp?init=2")
     'response.end
  end if
  
   dim usertype
   usertype=session("usertype")
   response.write session("truename")&"您好！<br>"&"登录时间："&session("logindate")
%>
</p>
<p>&nbsp;</p>
<%
  if usertype="学生" then
%>
<table width="100" border="1">
  <tr>
    <td bgcolor="#FF9900">学生管理</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">查看成绩</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">个人信息</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">同学查询</td>
  </tr>
</table>
<%
  end if
  if usertype="教师" then
%>
<table width="100" border="1">
  <tr>
    <td bgcolor="#FF9900">教师管理</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">个人信息</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">成绩录入</td>
  </tr>
</table>
<%
   end if
  if usertype="管理员" then
%>

<table width="100" border="1">
  <tr>
    <td bgcolor="#FF9900">管理员</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">数据库备份</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="javascript:modifyconfirm(<%response.write session("userID")%>)">密码修改</a></td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="stu_admin.asp" target="mainFrame">学生管理</a></td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="teacher_admin.asp" target="mainFrame">教师管理</a></td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="stu_check.asp" target="mainFrame">学生查询</a></td>
  </tr>
</table>
<%
   end if
%>

<p><a href="logout.asp" target="_top">安全退出</a></p>
<p>&nbsp;</p>
</body>
</html>
