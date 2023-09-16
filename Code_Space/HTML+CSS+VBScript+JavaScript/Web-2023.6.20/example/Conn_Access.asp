<%
dim sql
dim rs
dim conn
sub openDB()
	set conn=Server.Createobject("ADODB.Connection")
	connString="Provider=Microsoft.Jet.OLEDB.4.0;Data Source="_
	& Server.MapPath("stu.mdb")
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
