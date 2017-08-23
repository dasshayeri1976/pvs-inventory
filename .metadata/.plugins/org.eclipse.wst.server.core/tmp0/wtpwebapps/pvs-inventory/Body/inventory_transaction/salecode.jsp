<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	String a=request.getParameter("count");
	
	String x="";
	
	//System.out.println("value got is:- "+a);//checking wheather value got or not
	
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	
	//getting subgroupcode accordingly subgroup name
	ResultSet rs=smt.executeQuery("select smcode from areasalesmanmaster where smname = '"+a+"' ");
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
