<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	String a=request.getParameter("count");
	
	String x="",y="",z="";
	
	//System.out.println("value got is:- "+a);//checking wheather value got or not
	
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	
	//getting subgroupcode accordingly subgroup name
	ResultSet rs=smt.executeQuery("select party_code,address from partymaster1 where party_name = '"+a+"' ");
	while(rs.next())
	{
		x=rs.getString(1);
		y=rs.getString(2);
		//System.out.println("hello: - "+x+","+y);
	}
	z=x+","+y;
	out.print(z);
	
}
catch(Exception d) 
{
	//d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
