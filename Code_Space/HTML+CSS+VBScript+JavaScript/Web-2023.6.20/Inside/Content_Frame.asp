<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="../SignDir/Standard_Content.css">
</head>

<body>
	
	<input type="button" value="返回" id="Back_Page" onClick="back()">
		<img src="../src/Robo.png" class="Content_Icon" width="100px" height="100px" alt="Head_Icon">
	

<%

		dim content_id
		content_id=Request.QueryString("Content_ID")

		'response.write("Content_ID:"&content_id)

		set adocon=Server.Createobject("ADODB.connection")

		adocon.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

		if adocon.state = 1 then
			set rs = Server.Createobject("ADODB.Recordset")
			rs.open " select * from [Forums] WHERE [ID]= '"&content_id&"' ",adocon,3,2
			rs.movefirst
			end if
%>


	<div id="Content_Title">
			<h2>
				<%response.write rs("Title")%>
				</h2>
	</div>
		
	<div id="Content_Author">
		
		<h3>
			作者：<span><%response.write rs("Author")%></span>
		</h3>
		
	</div>
	
	<div class="Content_Header">
	
		<p>
		 类型：<%response.write rs("Type")%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 发布日期：<%response.write rs("UpLoad_Time")%>
		</p>
		
	</div>
	
	<div id="Content_content">
	
		<p>
			<%response.write rs("Content")%>
		</p>
	
	</div>

<%
	
	rs.close()
	adocon.close()
%>

<script type="text/javascript" src="../Js/Content_Scrpit.js"></script>
</body>
</html>
