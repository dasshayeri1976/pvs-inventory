<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.connection.account.*" %>

<%
try
{
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
boolean result=false;
String a=request.getParameter("count");
System.out.println("value of a "+a);
String a1[]=a.split(",");

String sql="",led="";
if(a.substring(0,3).equals("con"))
{
	//nothing to do
}
else
{
for(int j=0;j<a1.length;j++)
{
	String a12[]=a1[j].split("con"); 
	sql="select ledgerid from ledgermaster where ledgername='"+a12[5]+"'";
	ResultSet rs=smt.executeQuery(sql);
	while(rs.next())
	{
		led=rs.getString(1);
	}
	//deleting previous records
	sql="delete from outstandingledgerdummy where ledgerid='"+led+"'";
	//System.out.println(sql);
	result=ConnectionDAO.executeUpdate(smt,sql);
}


//System.out.println("hello");
for(int i=0;i<a1.length;i++)
{
	String a2[]=a1[i].split("con"); 
	sql="select ledgerid from ledgermaster where ledgername='"+a2[5]+"'";
	ResultSet rs=smt.executeQuery(sql);
	while(rs.next())
	{
		led=rs.getString(1);
	}
	//inserting new records
	sql="insert into outstandingledgerdummy(ledgerid, referenceno, referencedate, billamount, adjustmentamount, duesamount, amount) values('"+led+"', '"+a2[0]+"', '"+a2[1]+"', '"+a2[2]+"', '"+a2[3]+"', '"+a2[4]+"','"+a2[6]+"')";
	//System.out.println(sql);
	result=ConnectionDAO.executeUpdate(smt,sql);
}//loop ends
}//else ends
}//try ends
catch(Exception g)
{
	System.out.println("error inserttodummy "+g);
}
%>