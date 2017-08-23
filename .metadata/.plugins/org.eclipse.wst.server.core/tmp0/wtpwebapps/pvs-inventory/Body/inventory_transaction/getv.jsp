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
	sql="select count(voucherno) from itransaction";
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		count=rs.getInt(1);
	}	
	if(count == 0)
	{
		out.print("1");
	}
	else 
	{
		out.print(""+(count+1));
	}
}
catch(Exception error)
{
	System.out.println("error on getdate jsp "+error);
}
%>