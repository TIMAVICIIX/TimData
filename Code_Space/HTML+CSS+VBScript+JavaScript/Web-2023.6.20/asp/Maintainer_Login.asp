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

		response.write("Account:"+User_Account)
		response.write("Password:"+User_Password)

		set adocon=Server.Createobject("ADODB.connection")

		adocon.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

		if adocon.state = 1 then
			set rs = Server.Createobject("ADODB.Recordset")
			rs.open " select * from [Maintainer] where [Maintain_Account] = '"&User_Account&"' and [Maintain_Password] = '"&User_Password&"' ",adocon,3,2

			if not rs.eof then
				response.Redirect("../Maintainer.html?maintainer_id="&Server.UrlEncode(User_Account))
			
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
