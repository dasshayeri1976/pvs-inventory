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
	
	//getting cr balance from ledger master table
	ResultSet rs=smt.executeQuery("select narrationdetail from narrationmaster where narrationname= '"+a+"' ");
	while(rs.next())
	{
		x=rs.getString(1); 
		out.print(rs.getString(1));
	}
	//System.out.println("narration got "+x);
}
catch(Exception d) 
{
	d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
