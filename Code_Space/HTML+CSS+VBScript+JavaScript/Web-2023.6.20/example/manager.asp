<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<%
  if session("username")="" then
     response.Redirect("login.asp?init=2")
  end if
%>
</head>
<frameset rows="*" cols="132,*" framespacing="0" frameborder="no" border="0">
  <frame src="left.asp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
  <frame src="main.asp" name="mainFrame" id="mainFrame" title="mainFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>
