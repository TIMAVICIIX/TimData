<%@LANGUAGE="VBSCRIPT" CODEPAGE="65001"%>

<%

	Dim forum_id,user_id,intent_view

	intent_view=Request.Form("intent_view")
	forum_id=Request.Form("Forum_id")
	user_id=Left(forum_id,9)

	'Debug'
	response.write("<br>Change_Forum:"&forum_id)
	response.write("<br>User_id:"&user_id)
	response.write("<br>Change_ASP:"&intent_view)

	Dim conn,CekForum,UpdForum,HindSql,rs
	Dim publish,unpublish

	publish="发布"
	unpublish="未发布"

	Set conn=Server.Createobject("ADODB.connection")

	conn.open "Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

	UpdForum="UPDATE [Forums] SET [State] ="
	HindSql="WHERE [ID]='"&forum_id&"'"

	'执行状态查询操作'
 	CekForum="SELECT * FROM [Forums] WHERE [ID] = '"&forum_id&"' "


	rs=conn.Execute(CekForum)


	'修改相应状态'

	If rs("State")="未发布" then

	UpdForum=UpdForum&publish&HindSql

	'update_sql="UPDATE [User] SET [Forumed] = [Forumed] + 1 WHERE User_Account='"&user_id&"'"'

	conn.Execute(UpdForum)
	
	Else

	UpdForm=UpdForum&unpublish&HindSql

	conn.Execute(UpdForum)

	End If



	'再次查询用户信息，执行返回操作'

	Dim re_check
			re_check= " SELECT * FROM [User] WHERE [User_Account]='"&user_id&"'"

			'Debug'
			response.write("<br>"&re_check)

			Set rs =conn.Execute(re_check) 

			if not rs.eof then
				Dim user_name,user_forumed,upload_state
				update_state="success"
				user_name=rs("User_Name")
				user_forumed=rs("Forumed")
				response.Redirect("../Inside/"&intent_view&"?update_state="&update_state)

			end if

	rs.close
	Set rs=nothing

	conn.close
	Set conn=nothing

%>