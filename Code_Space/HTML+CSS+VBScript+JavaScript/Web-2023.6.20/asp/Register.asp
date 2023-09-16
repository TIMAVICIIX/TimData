<%@LANGUAGE="VBSCRIPT" CODEPAGE="65001"%>
<%

	dim user_name,user_password,forum

	forum=0
	user_name=Request.Form("UserName")
	user_password=Request.Form("UserPW2")

	'response.write("User_Name:"&user_name&" ")
	'response.write("user_password:"&user_password&" ")

	Dim conn,rs
	Set conn=Server.Createobject("ADODB.Connection")
	conn.open"Provider = Microsoft.Jet.OLEDB.4.0; Data Source = "&Server.MapPath("../MDB/TimForum.mdb")

	Dim user_account

	Do
		user_account=GenerateRandomUserAccount()
	Loop Until Not IsUserAccountExists(user_account)

	Dim sql
	sql="INSERT INTO [User] (User_Account,User_Password,User_Name,Forumed) VALUES('"&user_account&"','"&user_password&"','"&user_name&"',"&forum&")"

	'response.write("<br>"&"user_SQL:"&sql&"<br>")

	conn.Execute sql
	conn.close
	Set conn=nothing

	'response.write("您的账号注册成功！")
	'response.write("用户账号："&user_account&"（请记住随记生成的用户账号）")
	'response.write("用户昵称："&user_name)
	'response.write("用户密码："&user_password)

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>注册成功</title>
    
</head>
<body>
    <h1>注册成功！</h1>
    <p>您的账号是：<span id="username"><%=user_account%></span></p>
    <p>您的昵称是：<span id="username"><%=user_name%></span></p>
    <p>您的密码是：<span id="username"><%=user_password%></span></p>
    <button onclick="redirectToSuccessPage()">点击跳转到登录界面</button>

    <script>
        function redirectToSuccessPage() {
            // 在这里执行跳转操作
            window.location.href = "../Login_Main.html";
        }
    </script>
</body>
</html>

<%

	Function GenerateRandomUserAccount()
		Dim randomString
		Randomize
		randomString=CStr(Int((999999999-100000000+1)*Rnd+100000000))
		response.write("Random_Account:"&randomString)
		GenerateRandomUserAccount=randomString
	End Function

	Function IsUserAccountExists(user_account)
		Dim sql,rs
		sql="SELECT COUNT(*) FROM [User] WHERE User_Account='"&Replace(user_account,"'","''")&"'"

		'response.write("Is_Exists:"&sql&"<br>")

		Set rs=conn.Execute(sql)
		If rs(0)>0 then
			IsUserAccountExists = True
		Else
			IsUserAccountExists = FALSE
		END If
		rs.close
		Set rs=nothing
	End Function
%>