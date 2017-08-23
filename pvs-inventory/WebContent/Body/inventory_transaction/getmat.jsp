<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
String a=request.getParameter("count");
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="",buffer="<select name='formbean.company'><option value=''></option>",buffer1="<select name='formbean.unit'><option value=''>Select</option>";
try
{
	sql="select * from materialmaster where ledgerid=(select ledgerid from ledgermaster where ledgername='"+a+"')";
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		buffer=buffer+"<option value='"+rs.getString(3)+"'>"+rs.getString(3)+"</option>";
		buffer1=buffer1+"<option value='"+rs.getString(10)+"'>"+rs.getString(10)+"</option>";
	}
	buffer=buffer+"</select>";
	buffer1=buffer1+"</select>";
	out.print(buffer+"con"+buffer1);
}
catch(Exception error)
{
	System.out.println("error on getmat "+error);
}
%>