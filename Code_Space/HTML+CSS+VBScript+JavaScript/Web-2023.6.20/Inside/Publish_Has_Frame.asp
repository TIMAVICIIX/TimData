<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="../SignDir/Standard_Explore.css">
</head>
	
<script src="../Js/Jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>	
<script src="../Js/Change_Frame.js" type="text/javascript" charset="utf-8"></script>	
<script type="text/javascript">
   
 window.onload=function(){  
	var parentDocument=parent.document;
	var User_Account=parentDocument.getElementById("User_ID").innerHTML;

	document.getElementById("User_Account").value=User_Account.split(":")[1];

	alert(document.getElementById("User_Account").value)

	document.getElementByName("form1").submit();
}

</script>

<body>
	
	<div id="Borader_Explore" style="height:100%;width: 100%">
		
		<div style="width: 100%">
		
			<h2>
				Tim_Forum
			</h2>
			
			<p id="Forum_Type">
				----我的已发布帖子----
			</p>
		
		</div>

		<form name="form1" method="post" action="<%= Request.ServerVariables("SCRIPT_NAME")%>" >
		<input name="User_Account" type="text" style="display: none;">
		</form>
		


		<%

			dim User_Account
			User_Account=Request.QueryString("User_Account")

			'response.write("User_Account:"&User_Account)

		set adocon=Server.Createobject("ADODB.connection")

		adocon.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")


		if adocon.state = 1 then
			set rs = Server.Createobject("ADODB.Recordset")
			rs.open " select * from [Forums] Where [ID] like '"&User_Account&"%' AND [State]='发布' ",adocon,3,2
			if rs.eof then

				response.write "<p>---您未发布文章---</p>"

			else

				rs.movefirst
			end if
		end if
				
				do while not rs.eof

		%>


		
		<div id="Forum_Space">
		
		<div class="Forum_item">
		
			<table width="1100" height="130" border="0" align="center">
  <tbody>
    <tr>
      <td rowspan="2">
		
		  <img class="Forum_Icon" src="../src/Robo.png" alt="用户头像">
		
		</td>
      <td colspan="3" class="Forum_Title">
		
		  <h5>
			 标题：<span id="Forum_Title"> <%response.write rs("Title")%> </span> 
		  </h5>
		
		</td>
      <td>
		
		  <h5>
		  	ID:<span class="Forum_Other"><%response.write rs("ID")%></span>
		  </h5>
		
		</td>
    </tr>
    <tr>
      
      <td class="Forum_Content" colspan="3" rowspan="2" height="30px" width="400px">
		
		  <p id="Forum_Content">
		  <%response.write left(rs("Content"),15)%>
		  ...
		  </p>
		
		</td>
      <td>
		
		<h5 class="Forum_Other">
		  类型:<span id="Forum_type"> <%response.write rs("Type")%> </span>
		  </h5>
		
		</td>
    </tr>
    <tr>
		<td>
			
			<h5>
			作者：<span id="Forum_Author"> <%response.write rs("Author")%> </span>
			</h5>
		
		</td>
      <td>
		
		  <%
		dim content_id
		content_id=rs("ID")

		response.write "<input type='button' class='Check_Content' alt='查看全文' value='查看全文' onClick='Change_Frame("""&content_id&""")'>"
		
		%>
		
		</td>
    </tr>
    </tbody>
</table>
		</div>
	
		
	</div>

	<%

	rs.movenext
	loop
	
	rs.close()
	adocon.close()
	%>
		
</div>

</body>
</html>
