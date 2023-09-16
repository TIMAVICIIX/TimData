<%@LANGUAGE="VBSCRIPT" CODEPAGE="65001"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>LoginCheck</title>
</head>

<body>

	<%
		User_Account = Request.Form("user_id")
		User_Password = Request.Form("user_pw")

		maintainer="1145141919810"

		response.write("Account:"+User_Account)
		response.write("Password:"+User_Password)

		set adocon=Server.Createobject("ADODB.connection")

		adocon.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

		if adocon.state = 1 then
			set rs = Server.Createobject("ADODB.Recordset")
			rs.open " select * from [User] where [User_Account] = '"&User_Account&"' and [User_Password] = '"&User_Password&"' ",adocon,3,2

			if not rs.eof then

				if User_Account=maintainer then

					Dim maintainer_id
					maintainer_id="success"	
					response.Redirect("../Maintainer.html?maintainer_id="&Server.UrlEncode(maintainer_id))

				end if

					Dim user_id
					user_id=User_Account
					user_name=rs("User_Name")
					user_forumed=rs("Forumed")
					response.Redirect("../index.html?user_id="&Server.UrlEncode(user_id)&"&user_name="&Server.UrlEncode(user_name)&"&user_forumed="&Server.UrlEncode(user_forumed))

				
			
			else

				UnLogin = "UnLogin"
				redirectURL="../Login_Main.html?state=" & Server.UrlEncode(UnLogin)
				response.Redirect(redirectURL)
				

			end if

		rs.close()

		end if

		adocon.close()

	%>

</body>
</html>
