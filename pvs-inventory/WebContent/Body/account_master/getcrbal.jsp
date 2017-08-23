<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	String a=request.getParameter("count");
	String a1[]=a.split(",");
	System.out.println("length: "+a);
	//System.out.println("value got is:- "+a);//checking wheather value got or not
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	String x="";
	//getting cr balance from ledger master table
	System.out.println("Length: "+a1.length);
	if(a1.length>1)
	{
		
	for(int i=0;i<a1.length;i++)
	{
	ResultSet rs=smt.executeQuery("select currentbalance from ledgermaster where ledgername = '"+a1[i]+"' ");
	while(rs.next())
	{
		//System.out.println("main group code got is: "+rs.getString(1));
		
		x=x+", "+rs.getString(1); 
		x=x.substring(1);
		System.out.println("See: "+x);
		
	}
	}
	}
	else
	{
		
		ResultSet rs=smt.executeQuery("select currentbalance from ledgermaster where ledgername = '"+a+"' ");
		while(rs.next())
		{
			//System.out.println("main group code got is: "+rs.getString(1));
			
			x=rs.getString(1); 
			
		}
	}
	
	out.print(x);
	
}
catch(Exception d) 
{
	d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
