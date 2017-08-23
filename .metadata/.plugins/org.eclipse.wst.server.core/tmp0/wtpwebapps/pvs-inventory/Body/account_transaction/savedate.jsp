<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>

<%
String got=request.getParameter("count");
String ar[]=got.split("con");
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);

ResultSet rs;
boolean result;
String sql="";
try
{
	if(!got.substring(got.length()-3, got.length()).equals("con"))
	{
		sql="update accounttransaction set clearedon='"+ar[1]+"' where voucherno='"+ar[0]+"'";
		result=ConnectionDAO.executeUpdate(smt, sql);
		if(result==true)
		{
			out.print(ar[1]);
		}
	}
	else
	{
		sql="update accounttransaction set clearedon='' where voucherno='"+ar[0]+"'";
		System.out.println(sql);
		result=ConnectionDAO.executeUpdate(smt, sql);
		if(result==true)
		{
			out.print("");
		}
	}
}
catch(Exception ab)
{
	System.out.println("Save date error on "+ab);
}
%>