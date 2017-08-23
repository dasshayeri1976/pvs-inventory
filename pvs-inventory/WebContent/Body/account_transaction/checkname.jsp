<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	String a=request.getParameter("count");
	a=a.replace("*","&");
	String x="";
	
	//System.out.println("value got is:- "+a);//checking wheather value got or not
	
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	
	//getting subgroupcode accordingly subgroup name
	ResultSet rs=smt.executeQuery("select subgroupcode from subgroupmaster where subgroupname = '"+a+"' ");
	while(rs.next())
	{
		//System.out.println("main group code got is: "+rs.getString(1).substring(0,2));
		//making 2 character group code
		x=rs.getString(1).substring(0,2); 
	}
	
	//selecting groupname accordingly 2 character code
	ResultSet rs1=smt.executeQuery("select groupname from groupmaster where groupcode like '"+x+"' ");
	while(rs1.next())
	{
		//System.out.println("maingroup got is:- "+rs1.getString(1));
		out.print(rs1.getString(1));
	}
}
catch(Exception d) 
{
	//d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
