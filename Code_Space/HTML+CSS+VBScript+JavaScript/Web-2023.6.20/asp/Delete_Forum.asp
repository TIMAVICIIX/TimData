<%@LANGUAGE="VBSCRIPT" CODEPAGE="65001"%>

<%

	Dim forum_id,user_id,intent_view
	intent_view=Request.Form("intent_view")
	forum_id=Request.Form("Forum_id")
	user_id=Left(forum_id,9)

	'Debug'
	response.write("<br>Delete_Forum:"&forum_id)
	response.write("<br>User_id:"&user_id)
	response.write("<br>Change_ASP:"&intent_view)

	Dim conn,DelForum,UpdForum

	Set conn=Server.Createobject("ADODB.connection")

	conn.open "Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

	'执行删除文章操作'

	DelForum="DELETE FROM [Forums] WHERE [ID]='"&forum_id&"'"

	conn.Execute DelForum


	'执行减少该用户文章数量操作'

	UpdForum="UPDATE [User] SET [Forumed] = [Forumed] - 1 WHERE User_Account='"&user_id&"'"

	conn.Execute UpdForum


	'再次查询用户信息，执行返回操作'

	Dim re_check
			re_check= " SELECT * FROM [User] WHERE [User_Account]='"&user_id&"'"

			'Debug'
			response.write("<br>"&re_check)

			Set rs =conn.Execute(re_check) 

			if not rs.eof then
				Dim user_name,user_forumed,upload_state
				delete_state="success"
				user_name=rs("User_Name")
				user_forumed=rs("Forumed")
				response.Redirect("../Inside/"&intent_view&"?User_Account="&user_id)

			end if

	rs.close
	Set rs=nothing

	conn.close
	Set conn=nothing

%>