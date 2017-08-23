<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>

<%
String a=request.getParameter("count");
System.out.println("todummyonupdate");
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="",voucher="",v1st="UD",y="1718",prevno="";
int c=0;
boolean result=false;
try
{
	sql="delete from ibatchdetailsdummy";
	ConnectionDAO.executeUpdate(smt, sql);
	sql="select voucherno from itransaction where id=(select max(id) from itransaction)";
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		prevno=rs.getString(1);
	}
	
	
	String ar[]=a.split("add");//ar[0]=all,ar[1]=name
	String b1[]=ar[1].split("ddd");
	String arr[]=ar[0].split(",");
	for(int i=0;i<arr.length;i++)
	{
		String b[]=arr[i].split("con");
		sql="insert into ibatchdetailsdummy(entrydate, voucherno, batchno, exdt, aqty, fqty, pu, td, rt, mrp, amount, matcode)value('"+b1[1]+"', '"+prevno+"', '"+b[0]+"', '"+b[1]+"', '"+b[2]+"', '"+b[3]+"', '"+b[4]+"', '"+b[5]+"', '"+b[6]+"', '"+b[7]+"', '"+b[8]+"', (select matcode from materialmaster where matname='"+b1[0]+"'))";
		System.out.println(sql);
		result=ConnectionDAO.executeUpdate(smt, sql);
	}
	if(result)
	{
		out.print("1");
	}
	else
	{
		out.println("0");
	}
}
catch(Exception error)
{
	//System.out.println("error on todummy "+error);
	error.printStackTrace();
}
%>