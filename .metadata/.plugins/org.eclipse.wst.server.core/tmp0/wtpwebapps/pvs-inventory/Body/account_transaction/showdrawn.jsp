<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	String a=request.getParameter("count");
	String x="";
	int xx=0;
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	//getting cr balance from ledger master table
	ResultSet rs=smt.executeQuery("select ledgerid from ledgermaster where ledgername = '"+a+"' ");
	while(rs.next())
	{
		x=rs.getString(1).substring(0,2);
		if(x.equals("BA"))
		{
			xx=1;
			out.print(xx);
		}
	} 
}
catch(Exception d) 
{
	//d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
