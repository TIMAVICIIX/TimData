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

var User_Account;

function getParameterByName(name) {
      var url = window.location.href;
      name = name.replace(/[\[\]]/g, '\\$&');
      var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
          results = regex.exec(url);
      if (!results) return null;
      if (!results[2]) return '';
      return decodeURIComponent(results[2].replace(/\+/g, ' '));
   }

   // 在页面加载时获取URL参数，并显示在页面中
   window.onload = function() {
      User_Account = getParameterByName('User_Account');
      

      document.getElementById("reFresh").submit();

   };


</script>

<body>
	
	<div id="Borader_Explore" style="height:100%;width: 100%">
		
		<div style="width: 100%">
		
			<h2>
				Tim_Forum
			</h2>
			
			<p id="Forum_Type">
				----综合帖子浏览----
			</p>
		
		</div>

		<input id="reFresh" type="submit" style="visibility: hidden;">



		<%
		set adocon=Server.Createobject("ADODB.connection")

		adocon.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

		if adocon.state = 1 then
			set rs = Server.Createobject("ADODB.Recordset")
			rs.open " select * from [Forums] WHERE [State]='发布' ",adocon,3,2
			rs.movefirst
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
