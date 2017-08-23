<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>

<%
String a=request.getParameter("count");
//System.out.println(a);
Connection conn = ConnectionDAO.getConnectionObject();
Statement stm = ConnectionDAO.createStatement(conn);	
ResultSet rs;
String sql="",pname="",packing="";
String buffer="<table><tr bgcolor='#4292b2' style='color:white'> <th><label>Product Name</label></th> <th><label>Packing</label></th>"; 
buffer=buffer+" <th><label>Valid Min. Qty</label></th> <th><label>Extra Gain %</label></th> ";
buffer=buffer+"<th><label>Offered Min Qty</label></th> </tr>";
try
{
	sql="select * from materialmaster where ledgerid=(select ledgerid from ledgermaster where ledgername='"+a+"')";
	rs=stm.executeQuery(sql);
	while(rs.next())
	{
		//pname=pname+rs.getString(3);
		//packing=packing+rs.getString(9);
		buffer=buffer+"<tr> <td><input type='text' name='formbean.pname' id='pname' class='pname' value='"+rs.getString(3)+"' style='border:1px solid #ccc;height:20px;background:#FFFF99;width:250px;height:25px'/></td> <td><input type='text' name='formbean.packing' id='packing' class='packing' value='"+rs.getString(9)+"' style='border:1px solid #ccc;height:20px;background:#FFFF99;width:70px;height:25px'/></td> <td><input type='text' name='formbean.minqty' id='minqty' class='minqty' value='' style='border:1px solid #ccc;height:20px;background:#FFFF99;width:90px;height:25px'/></td> <td><input type='text' name='formbean.extra' id='extra' class='extra' value='' style='border:1px solid #ccc;height:20px;background:#FFFF99;width:90px;height:25px' onkeyup='calminqty();validate()'/></td> <td><input type='text' name='formbean.offeredmin' id='offeredmin' class='offeredmin' value='' style='border:1px solid #ccc;height:20px;background:#FFFF99;width:100px;height:25px'/></td></tr>";
	}
	buffer=buffer+"</table>";
	out.print(buffer);
}
catch(Exception error)
{
	error.printStackTrace();
}
%>