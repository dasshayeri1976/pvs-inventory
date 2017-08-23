<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
try
{
	String a=request.getParameter("count");
	//System.out.println("value: "+a);
	//System.out.println("value got is:- "+a);//checking wheather value got or not
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	String x="";
	String value="";
	//getting cr balance from ledger master table
	
	ResultSet rs=smt.executeQuery("select company_code from companymaster1 where company_name = '"+a+"' ");
	while(rs.next()){
	
		value=rs.getString(1);
		//System.out.println(value);
	
	}
	
	out.print(value);
	
}
catch(Exception d) 
{
	d.printStackTrace();
	System.out.println("error found on:- "+d);
}
%>
