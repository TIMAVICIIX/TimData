<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
body {
	background-color: #FFC;
}
body,td,th {
	font-family: ����;
	font-size: 10pt;
}
-->
</style>
<script type="text/javascript">
function modifyconfirm(id)
{
   if(confirm("��ȷ��Ҫ�޸ĸ���Ϣ��"))
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
   response.write session("truename")&"���ã�<br>"&"��¼ʱ�䣺"&session("logindate")
%>
</p>
<p>&nbsp;</p>
<%
  if usertype="ѧ��" then
%>
<table width="100" border="1">
  <tr>
    <td bgcolor="#FF9900">ѧ������</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">�鿴�ɼ�</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">������Ϣ</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">ͬѧ��ѯ</td>
  </tr>
</table>
<%
  end if
  if usertype="��ʦ" then
%>
<table width="100" border="1">
  <tr>
    <td bgcolor="#FF9900">��ʦ����</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">������Ϣ</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">�ɼ�¼��</td>
  </tr>
</table>
<%
   end if
  if usertype="����Ա" then
%>

<table width="100" border="1">
  <tr>
    <td bgcolor="#FF9900">����Ա</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">���ݿⱸ��</td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="javascript:modifyconfirm(<%response.write session("userID")%>)">�����޸�</a></td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="stu_admin.asp" target="mainFrame">ѧ������</a></td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="teacher_admin.asp" target="mainFrame">��ʦ����</a></td>
  </tr>
  <tr>
    <td bgcolor="#FFCCCC">&nbsp;&nbsp;<a href="stu_check.asp" target="mainFrame">ѧ����ѯ</a></td>
  </tr>
</table>
<%
   end if
%>

<p><a href="logout.asp" target="_top">��ȫ�˳�</a></p>
<p>&nbsp;</p>
</body>
</html>
