<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%@ page import="java.util.*"%>

<%
String a=request.getParameter("count");
System.out.println(a);
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="",matcode="",buffer="<table>",packing="",buffer1="",group="",totalcase="",totalpcs="",tamount="",mrpp="",ratee="",typetax="";
String coun="";



try
{
	System.out.println("hello"+a);
	
	sql="select sttype from partymaster1 where party_code='"+a+"' ";
	rs=smt.executeQuery(sql);
	System.out.println(sql);
	//System.out.println(sp[0]);
	while(rs.next())
	{
		coun=rs.getString(1);
		//System.out.println("value of count: "+count);
		
	}
	
	System.out.println("value of count: "+coun);
	
	
		out.print(coun);
	
	
}




catch(Exception error)
{
	System.out.println("error found on merialdetails jsp "+error);
}
%>