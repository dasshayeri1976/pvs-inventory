<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<% 
try
{
	String a=request.getParameter("count");
	//System.out.println(a);
	//String a1[]=a.split(",");
	
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	String x="";
	/* 
	if(a1.length>1)
	{
		
		for(int i=0;i<a1.length;i++)
		{
			ResultSet rs=smt.executeQuery("select currentbalance from ledgermaster where ledgername = '"+a1[i]+"' ");
			while(rs.next())
			{
		
		
				x=x+", "+rs.getString(1); 
				x=x.substring(1);
	
		
			}
		}
	} */
	
		
		ResultSet rs=smt.executeQuery("select currentbalance from ledgermaster where ledgername = '"+a+"' ");
		while(rs.next())
		{
			
			
			x=rs.getString(1); 
			
		}
	
	
	out.print(x);
	
}
catch(Exception d) 
{
	//d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
