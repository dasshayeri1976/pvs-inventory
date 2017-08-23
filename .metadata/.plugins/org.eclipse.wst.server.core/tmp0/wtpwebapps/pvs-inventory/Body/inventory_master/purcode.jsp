<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*"%>
<%
try
{
	String a=request.getParameter("count");
	String x="";
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement smt = ConnectionDAO.createStatement(conn);
	String sql="select ledgerid from ledgermaster where ledgername='"+a+"'";
	
	//getting cr balance from ledger master table
	ResultSet rs=smt.executeQuery(sql);
	while(rs.next())
	{
		x=rs.getString(1); 
	}
	out.print(x);
}
catch(Exception d) 
{
	System.out.println("error found on:- "+d);
}
%>