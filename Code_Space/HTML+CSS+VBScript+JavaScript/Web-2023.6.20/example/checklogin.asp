<%@LANGUAGE="VBSCRIPT" CODEPAGE="936"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<!--#include file="Conn_SQL2005.asp"-->
</head>

<body>
<%
dim usernameout,userpasswordout,userclass
usernameout=request.Form("usernametext")
userpasswordout=request.Form("passwordtext")

   response.write(usernameout+" ")
   response.write(userpasswordout )
   
sql="select * from user_tb where username='"&usernameout&"' and userpassword='"&userpasswordout&"'"
OpenDB
rs.open sql,conn,1,1
if rs.RecordCount<>0 then
   
   if rs("adminpass")=1 then
       session("username")=rs("username")
       session("usertype")=trim(rs("userclass"))
       session("truename")=rs("truename")
	   session("userID")=rs("userID")
       session("logindate")=date
       response.Redirect("manager.asp")
   else
      response.Redirect("login.asp?init=2")
   end if
else
   response.Redirect("login.asp?init=1")
end if

CloseDB
%>

</body>
</html>
