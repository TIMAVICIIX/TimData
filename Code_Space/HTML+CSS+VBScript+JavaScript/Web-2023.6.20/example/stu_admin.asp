<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
body,td,th {
	font-family: ����;
	font-size: 10pt;
}
.style10 {font-size: 12pt; font-weight: bold; color: #CC0000; }
-->
</style>
<script type="text/javascript">
function deleteconfirm(id)
{
   if(confirm("��ȷ��Ҫɾ������Ϣ��"))
   {
	  window.location.href="delete_user.asp?id="+id;
   }
}

function passconfirm(id)
{
   if(confirm("��ȷ��Ҫ������Ϣ��"))
   {
	  window.location.href="pass_user.asp?id="+id;
   }
}

function modifyconfirm(id)
{
   if(confirm("��ȷ��Ҫ�޸ĸ���Ϣ��"))
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
    <td><span class="style10">�û��˺�</span></td>
    <td><span class="style10">��ʵ����</span></td>
    <td><span class="style10">ע��ʱ��</span></td>
    <td><span class="style10">ע��IP��ַ</span></td>
    <td><span class="style10">������</span></td>
    <td colspan="3"><span class="style10">����</span></td>
  </tr>
<%
sql="select * from user_tb where userclass='ѧ��' order by adminpass desc,logindate desc"
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
    <td><%if rs("adminpass")=0 then response.write "δ����" else response.write "������" end if%></td>
    <td><a href="javascript:passconfirm(<%response.write rs("userID")%>)" target="_self">����</a></td>
    <td><a href="javascript:modifyconfirm(<%response.write rs("userID")%>)" target="_self">�޸�</a></td>
    <td><a href="javascript:deleteconfirm(<%response.write rs("userID")%>)" target="_self">ɾ��</a></td>
  </tr>
<%
rs.movenext
loop
CloseDB
%>

</table>
</body>
</html>
