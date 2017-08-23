<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<%
try
{
	String a=request.getParameter("count");
	String x="";
	
	System.out.println("value got is:-(getpart) "+a);//checking wheather value got or not
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts","root","");
	Statement smt=con.createStatement();
	
	//getting cr balance from ledger master table
	
}
catch(Exception d) 
{
	d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
