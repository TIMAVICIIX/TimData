<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��ʾѧ������</title>
<!--#include file="Conn_Access.asp"-->
<link type="text/css" rel="stylesheet" href="../SignDir/Standard_Explore.css">
</head>

<body>
<div id="Borader_Explore" style="height:100%;width: 100%">
		
		<div style="width: 100%">
		
			<h2>
				Tim_Forum
			</h2>
			
			<p id="Forum_Type">
				----�ۺ��������----
			</p>
		
		</div>
	
	<form name="form1" method="post" action="">
<table width="600" border="1" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td width="75">ѧ�ţ�</td>
    <td width="525">
      <input name="sno_text" type="text" id="sno_text">
    </td>
  </tr>
  <tr>
    <td>������</td>
    <td><input name="sname_text" type="text" id="sname_text"></td>
  </tr>
  <tr>
    <td>�Ա�</td>
    <td><input type="radio" name="sex_radio" value="��">
      ��      <input type="radio" name="sex_radio" value="Ů">
      Ů      <input type="radio" name="sex_radio" value="����">
      ����</td>
  </tr>
  <tr>
    <td>ϵ��</td>
    <td><select name="dept_select" id="dept_select">
      <option value="ȫ��" selected>---����ϵ---</option>
      <option value="����ϵ">����ϵ</option>
      <option value="��ѧϵ">��ѧϵ</option>
      <option value="�ƿ�ϵ">�ƿ�ϵ</option>
      <option value="����ϵ">����ϵ</option>
    </select></td>
  </tr>
  <tr>
    <td>���ã�</td>
    <td><input name="hobby_text" type="text" id="hobby_text"></td>
  </tr>
  <tr align="center">
    <td colspan="2"><input name="qurey_hidden" type="hidden" id="qurey_hidden" value="1">
      <input type="submit" name="Submit" value="��ѯ"></td>
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

<%
	OpenDB
	rs.open sql,conn,1,1
	if not rs.eof then
	   rs.movefirst
	end if
	do while not rs.eof
%>
  <div class="Forum_item">
		
			<table width="1100" height="130" border="0" align="center">
  <tbody>
    <tr>
      <td rowspan="2">
		
		  <img class="Forum_Icon" src="../src/Robo.png" alt="�û�ͷ��">
		
		</td>
      <td colspan="3" class="Forum_Title">
		
		  <h5>
			 ���⣺<span id="Forum_Title"> û�б��� </span> 
		  </h5>
		
		</td>
      <td>
		
		  <h5>
		  	��<span class="Forum_Other">1</span>¥
		  </h5>
		
		</td>
    </tr>
    <tr>
      
      <td class="Forum_Content" colspan="3" rowspan="2" height="30px">
		
		  <p id="Forum_Content">
		  ����û������,���û�����ݣ�<br>
			  ��˵��û������
		  </p>
		
		</td>
      <td>
		
		<h5 class="Forum_Other">
		  ����:<span id="Forum_type"> ��� </span>
		  </h5>
		
		</td>
    </tr>
    <tr>
		<td>
			
			<h5>
			���ߣ�<span id="Forum_Author"> Robo </span>
			</h5>
		
		</td>
      <td>
		
		  <input type="button" class="Check_Content" alt="�鿴ȫ��" value="�鿴ȫ��" onClick="">
		
		</td>
    </tr>
    </tbody>
</table>
		</div>
<%
	rs.movenext
	loop
	CloseDB
%>

<%
end if
%>
</body>
</html>
