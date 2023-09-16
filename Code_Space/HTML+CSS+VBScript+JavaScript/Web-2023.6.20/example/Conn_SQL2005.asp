<%
dim sql
dim rs
dim conn
sub openDB()
	set conn=Server.Createobject("ADODB.Connection")
	connString="DRIVER={SQL Server Native Client 10.0};SERVER=localhost;DATABASE=UIMS;UID=sa;PWD=123"
	'connString="DRIVER={MySQL ODBC 5.2 ANSI Driver};SERVER=localhost;DATABASE=UIMS;UID=root;PWD=123"
	conn.open connString
	set rs=server.createobject("ADODB.Recordset")
end sub

sub closeDB()
	If IsObject(conn) Then
		if not(conn is nothing) then
		    rs.close
			set rs=nothing
			conn.close
			set conn=nothing
		end if
	End If
end sub
%>
