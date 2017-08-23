<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*"%>
<%
try
{
	String a=request.getParameter("count");
	int x=0;
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement smt = ConnectionDAO.createStatement(conn);
	String sql="select count(srno) from mrmaster where srno='"+a+"'";
	
	//getting cr balance from ledger master table
	ResultSet rs=smt.executeQuery(sql);
	while(rs.next())
	{
		x=rs.getInt(1); 
	}
	if(x > 0)
	{
		out.print(a+"con"+"1");
	}
	else if(x == 0)
	{
		out.println(a+"con"+"0");
	}
}
catch(Exception d) 
{
	System.out.println("error found on:- "+d);
}
%>