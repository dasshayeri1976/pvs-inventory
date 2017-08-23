<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%@ page import="java.util.*"%>

<%
String a=request.getParameter("count");
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="",matcode="",buffer="<table>";
int count=0;
double totalamount=0.00,totalaqty=0.00,totalfqty=0.00;
Vector<String> batch=new Vector<String>();
Vector<String> exdt=new Vector<String>();
Vector<String> aqty=new Vector<String>();
Vector<String> fqty=new Vector<String>();
Vector<String> pu=new Vector<String>();
Vector<String> td=new Vector<String>();
Vector<String> rt=new Vector<String>();
Vector<String> mrp=new Vector<String>();
Vector<String> amount=new Vector<String>();
try
{
	buffer=buffer+"<tr><th></th><th>Batch No.</th><th>Exp.Dt.</th><th>A. Qty.</th><th>F. Qty</th><th>Pu.Rate</th><th>Td.Rate</th><th>Rt.Rate</th><th>MRPrice</th><th>Amount</th></tr>";
	sql="select count(matcode) from batchmaster where matcode=(select matcode from materialmaster where matname='"+a+"')";
	rs=smt.executeQuery(sql);
	while(rs.next())
	{
		count=rs.getInt(1);
	}
	if(count > 0)
	{
		sql="select * from batchmaster where matcode=(select matcode from materialmaster where matname='"+a+"')";
    	rs=smt.executeQuery(sql);
    	while(rs.next())
    	{
    		batch.add(rs.getString(3));
    		exdt.add(rs.getString(4));
    		aqty.add(rs.getString(6));
    		fqty.add(rs.getString(8));
    		pu.add(rs.getString(9));
    		td.add(rs.getString(10));
    		rt.add(rs.getString(11));
    		mrp.add(rs.getString(12));
    		amount.add(rs.getString(13));
    	}
    	for(int i=0;i<batch.size();i++)
    	{
    		buffer=buffer+"<tr><td><input type='checkbox'></input></td>  <td><input type='text' name='formbean.batchno' value='"+batch.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.expdate' value='"+exdt.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.aqty' value='"+aqty.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.fqty' value='"+fqty.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td>  <td><input type='text' name='formbean.purate' value='"+pu.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calto();calsimpletotal();'/></td>  <td><input type='text' name='formbean.strate' value='"+td.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.rtrate' value='"+rt.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.mrp' value='"+mrp.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.pamount' value='"+amount.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>   </tr>"; 
    		totalamount=totalamount+Double.parseDouble(amount.get(i));
    		totalaqty=totalaqty+Double.parseDouble(aqty.get(i));
    		totalfqty=totalfqty+Double.parseDouble(fqty.get(i));
    	}
	}
	else if(count == 0) 
	{
		buffer=buffer+"<tr><td><input type='checkbox'></input></td>  <td><input type='text' name='formbean.batchno' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.expdate' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.aqty' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.fqty' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td>  <td><input type='text' name='formbean.purate' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calto();calsimpletotal();'/></td>  <td><input type='text' name='formbean.strate' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.rtrate' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.mrp' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.pamount' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>   </tr>";
	}
	buffer=buffer+"</table>";
	out.print(buffer+"con"+totalamount+"con"+totalaqty+"con"+totalfqty);
}
catch(Exception error)
{
	System.out.println("error found on getbatchdetails jsp "+error);
}
%>