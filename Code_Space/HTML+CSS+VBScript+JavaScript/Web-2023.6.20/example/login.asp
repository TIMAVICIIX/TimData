<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��post</title>
<style type="text/css">
<!--
.style1 {
	font-family: "����";
	font-size: 12pt;
	color: #FF0000;
}
-->
</style>
</head>

<body>
<form name="userform" method="post" action="checklogin.asp">
  <table width="300" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td>
	    <span class="style1">
	    <%
	  dim init
	  init=0
	  init=request.QueryString("init")
	  
	  if init=1 then
	     response.Write("����û��ע�ᣬ���������û��������")
	  end if
	  
	  if init=2 then
	     response.Write("������Ϣ��δ����������ϵ����Ա��")
	  end if
	  
	  if session("username")<>"" then
	     response.Redirect("manager.asp")
	  end if
	  %>
	    </span></td>
    </tr>
  </table>
  <table width="300" border="1" align="center" bgcolor="#FFFFCC">
    <tr>
      <td colspan="2" align="center">�û���¼</td>
    </tr>
    <tr>
      <td colspan="2" align="center">
&nbsp;      </td>
    </tr>
    <tr>
      <td>�û��ʺţ�</td>
      <td><input name="usernametext" type="text" id="usernametext"></td>
    </tr>
    <tr>
      <td>��¼���룺</td>
      <td><input name="passwordtext" type="text" id="passwordtext"></td>
    </tr>
    <tr>
      <td align="right"><input type="submit" name="Submit" value="��¼"></td>
      <td align="left"><label>
        <input type="reset" name="button" id="button" value="����">
        <a href="userresgist.html" target="_self">��ע��</a></label></td>
    </tr>
  </table>
</form>
</body>
</html>
