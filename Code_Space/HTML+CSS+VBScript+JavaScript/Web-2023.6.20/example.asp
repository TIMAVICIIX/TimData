
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Access</title>
    </head>
    <body>
        <table border="1" width="40%">
            <tr bgcolor="gray">
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>地址</th>
                <th>语文</th>
                <th>数学</th>
                <th>英语</th>
            </tr>
        <%
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:JDBC-ODBC";
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            String sql = "select * from Access";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
        %>
            <tr>
                <td><%=rs.getString(1) %></td>
                <td><%=rs.getString(2) %></td>
                <td><%=rs.getInt(3) %></td>
                <td><%=rs.getString(4) %></td>
                <td><%=rs.getInt(5) %></td>
                <td><%=rs.getInt(6) %></td>
                <td><%=rs.getInt(7) %></td>
            </tr>
        <%
            }
            rs.close();
            st.close();
            con.close();
        %>
        </table>
    </body>
</html>