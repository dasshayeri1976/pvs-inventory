<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
String a=request.getParameter("count");
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="",r="";
try
{
	sql="select unit from materialmaster where matname='"+a+"'";
	//System.out.println(sql);
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		//buffer1=buffer1+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
		r=rs.getString(1);
	}
	/* buffer1=buffer1+"</select>";
	out.print(buffer1); */
	out.print(r);
}
catch(Exception error)
{
	System.out.println("error on getmat "+error);
}
%>