<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
String a=request.getParameter("count");
//System.out.println("Count: "+a);
Connection conn = ConnectionDAO.getConnectionObject();
Statement stm = ConnectionDAO.createStatement(conn);	
ResultSet rs;
String sql="",buffer="<select id='retailername1' name='formbean.retailername1' class='retailername1'>";
try
{
	buffer=buffer+"<option value=''></option>";
	sql="select party_name from partymaster1 where arcode=(select placecode from placemaster where placename='"+a+"') ";
	System.out.println(sql);
	rs=stm.executeQuery(sql);
	while(rs.next())
	{
		
		buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
	}
	buffer=buffer+"</select>";
	//System.out.println(buffer);
	out.print(buffer);
}
catch(Exception error)
{
	error.printStackTrace();
}
%>