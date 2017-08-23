<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	int x=0;
	String sql="",x1="";
	//getting cr balance from ledger master table
	ResultSet rs=smt.executeQuery("select count(voucherno) from accounttransaction where voucherno like 'CO%' ");
	while(rs.next())
	{
		x=rs.getInt(1)+1; 
		//out.print(x);
	}
	sql="select max(entrydate) from accounttransaction where voucherno like 'CO%'";
	//System.out.println(sql);
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		x1=rs.getString(1);
	}
	if(x1.equals(" "))
	{
		out.print(x+"con"+"0");
	}
	else
	{
		out.print(x+"con"+x1);
	}
}
catch(Exception d) 
{
	d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>