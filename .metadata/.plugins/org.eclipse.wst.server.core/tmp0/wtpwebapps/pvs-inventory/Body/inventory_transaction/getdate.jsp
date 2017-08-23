<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>

<%
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="";
int count=0;
try
{
	sql="select count(entrydate) from itransaction";
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		count=rs.getInt(1);
	}
	if(count > 0)
	{
		sql="select entrydate from itransaction where id=(select max(id) from itransaction)";
		rs=smt.executeQuery(sql);
		while(rs.next())
		{
			out.print(rs.getString(1));
		}
	}
	else if(count == 0)
	{
		out.print("nil");
	}
}
catch(Exception error)
{
	System.out.println("error on getdate jsp "+error);
}
%>