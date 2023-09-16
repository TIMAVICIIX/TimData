<%@LANGUAGE="VBSCRIPT" CODEPAGE="65001"%>

<%

Dim forum_author,forum_title,forum_type,forum_state,forum_content,forum_id,user_id,upload_time

	forum_title=Request.Form("forum_title")
	forum_type=Request.Form("PassageORTip")
	forum_state=Request.Form("publish_state")
	forum_content=Request.Form("Create_Content")

	user_id=Request.Form("Upload_id")


	'开始连接数据库'
	Dim conn,rs
	Set conn=Server.Createobject("ADODB.Connection")
	conn.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

	'首先查询作者昵称,再查询作者发布ID'

	forum_author=GetAuthorName(user_id)
	forum_id=GetForumId(user_id)

	'再获得当前时间'

	Dim temp_time
	temp_time=Date()

	upload_time=Cstr(FormatDateTime(temp_time,vbShortDate))

	'******DeBug******'

	response.write("<br>user_id:"&user_id)
	response.write("<br>forum_id:"&forum_id)
	response.write("<br>forum_title:"&forum_title)
	response.write("<br>forum_type:"&forum_type)
	response.write("<br>forum_state:"&forum_state)
	response.write("<br>forum_content:"&forum_content)
	response.write("<br>forum_author:"&forum_author)
	response.write("<br>forum_time:"&upload_time)

 	'******Debug******'


	'上传文章全部信息'

	Dim upload_sql

	upload_sql="INSERT INTO [Forums] (ID,Title,Content,Author,State,Type,Upload_Time) VALUES('"&Replace(forum_id,"'","''")&"','"&Replace(forum_title,"'","''")&"','"&Replace(forum_content,"'","''")&"','"&Replace(forum_author,"'","''")&"','"&Replace(forum_state,"'","''")&"','"&Replace(forum_type,"'","''")&"','"&Replace(upload_time,"'","''")&"') "

	conn.Execute upload_sql

	'将该作者的上传数量加1'

	Dim update_sql

	update_sql="UPDATE [User] SET [Forumed] = [Forumed] + 1 WHERE User_Account='"&user_id&"'"


	conn.Execute update_sql

	'再次查询作者信息，并重定向到其主页'

			Dim re_check
			re_check= " SELECT * FROM [User] WHERE [User_Account]='"&user_id&"'"

			response.write("<br>"&re_check)

			Set rs =conn.Execute(re_check) 

			if not rs.eof then
				Dim user_name,user_forumed,upload_state
				upload_state="success"
				user_name=rs("User_Name")
				user_forumed=rs("Forumed")
				response.Redirect("../index.html?user_id="&Server.UrlEncode(user_id)&"&user_name="&Server.UrlEncode(user_name)&"&user_forumed="&Server.UrlEncode(user_forumed)&"&upload="&Server.UrlEncode(upload_state))

			end if

	rs.close
	Set rs=nothing

	conn.close
	Set conn=nothing

	


%>

<%

	Function GetAuthorName(user_id)
		Dim forum_author,rs
		sql="SELECT * FROM [User] WHERE [User_Account]='"&user_id&"'"

		Set rs=conn.Execute(sql)

		If not rs.eof then
			GetAuthorName=rs("User_Name")
		End If

		rs.close
		Set rs=nothing

	End Function

	Function GetForumId(user_id)
		Dim forum_author,rs
		sql="SELECT * FROM [User] WHERE [User_Account]='"&user_id&"'"

		Set rs=conn.Execute(sql)

		If not rs.eof then
			GetForumId=user_id&"-"&CStr(rs("Forumed")+1)
		End If

		rs.close
		Set rs=nothing

	End Function



%>