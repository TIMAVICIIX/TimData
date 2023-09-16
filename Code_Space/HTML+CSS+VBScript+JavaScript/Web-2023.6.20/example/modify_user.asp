<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<!--#include file="Conn_SQL2005.asp"-->
<%
dim id,passwordold,truename
id=request.QueryString("id")
sql="select * from user_tb where userID="&id
OpenDB
rs.open sql,conn,1,1
if not rs.eof then
   rs.movefirst
   password=trim(rs("userpassword"))
   truename=trim(rs("truename"))
end if
CloseDB
%>
<script type="text/javascript">
function formcheck(theForm)
{
	  if (theForm.passwordtext.value != theForm.passwordconfirm.value)
	  {
		alert("两次输入的重置密码不同，请重新输入");
		theForm.passwordtext.focus();
		return (false);
	  }
	
	  if (theForm.password_old.value != theForm.pass_hidden.value)
	  {
		alert("您输入的原始密码不正确，请确定是否是用户本人！");
		theForm.password_old.focus();
		return (false);
	  }
	  return (true);
}
</script>
</head>

<body>
<form id="userreg" name="userreg" method="post" action="modifysave.asp?id=<%=id%>" onsubmit="javasript:return formcheck(this);">
  <table width="400" border="1" align="center"  bgcolor="#FFFFCC">
    <tr>
      <td colspan="2" align="center">用户注册</td>
    </tr>
    <tr>
      <td>设置密码：</td>
      <td><input name="passwordtext" type="password" id="passwordtext" /></td>
    </tr>
    <tr>
      <td>密码确认：</td>
      <td><input name="passwordconfirm" type="password" id="passwordconfirm" /></td>
    </tr>
    <tr>
      <td>原始密码：</td>
      <td><input name="password_old" type="password" id="password_old" /></td>
    </tr>
    <tr>
      <td>真实姓名</td>
      <td><input name="truenametext" type="text" id="truenametext"  value="<%=truename%>"/></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
      <input type="hidden" name="pass_hidden" id="pass_hidden"  value="<%=password%>"/>
      <label>
        <input type="submit" name="button" id="button" value="提交" />
        </label>        <label>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input type="reset" name="button2" id="button2" value="重填" />
          
      </label></td>
    </tr>
  </table>
</form>
</body>
</html>
