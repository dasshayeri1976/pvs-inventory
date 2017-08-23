<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<%
String a=request.getParameter("count");
System.out.println(a);
Connection con=ConnectionDAO.getConnectionObject();
Statement smt=ConnectionDAO.createStatement(con);
ResultSet rs;
String sql="",matcode="",buffer="<table>",packing="",buffer1="",pur="", ins="";
int count=0;
double totalamount=0.00,totalaqty=0.00,totalfqty=0.00;
Vector<String> mrp=new Vector<String>();
Vector<String> scase=new Vector<String>();
Vector<String> spcs=new Vector<String>();
Vector<String> total=new Vector<String>();
Vector<String> slcase=new Vector<String>();
Vector<String> slpcs=new Vector<String>();
//Vector<String> tax = new Vector<String>();
//String sp[]=a.split("con");

String tax="";
DecimalFormat myFormatter = new DecimalFormat("00.00");
try
{
	//System.out.println("hello"+a);
	buffer=buffer+"<tr>  <th>M.R.P</th><th>ST. CASE</th><th>ST. PCS</th><th>TOTAL</th><th>SL. CASE</th><th>SL. PCS</th></tr>";
	sql="select count(matcode) from materialdetails where matcode=(select matcode from materialmaster where matname='"+a+"')";
	rs=smt.executeQuery(sql);
	System.out.println(sql);
	//System.out.println(sp[0]);
	while(rs.next())
	{
		count=rs.getInt(1);
	}
	if(count > 0)
	{
		sql="select * from materialdetails where matcode=(select matcode from materialmaster where matname='"+a+"')";
		//System.out.println(sql);
    	rs=smt.executeQuery(sql);
    	while(rs.next())
    	{
    		mrp.add(rs.getString(5));
    		scase.add(rs.getString(9));
    		spcs.add(rs.getString(10));
    		total.add(rs.getString(11));
    		slcase.add(rs.getString(3));
    		slpcs.add(rs.getString(4));
    		
    	}
    	for(int i=0;i<mrp.size();i++)
    	{
    		buffer=buffer+"<tr> <td><input type='text' name='formbean.mrp1' class='mrp1' value='"+mrp.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.scase' class='scase' value='"+scase.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.spcs' class='spcs' value='"+spcs.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.stotal' class='stotal' value='"+total.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td> <td><input type='text' name='formbean.rtcase' class='rtcase' value='"+slcase.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup=''/></td> <td><input type='text' name='formbean.rtpcs' class='rtpcs' value='"+myFormatter.format(Double.parseDouble(slpcs.get(i)))+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td>  <td><input type='button' value='SELECT' class='butStnd' onclick='PersonViewModel(this);copyvalue();fadeout();'/></td> </tr>"; 
    	}
    	
    	sql="select packing,type_tax,pur_ac,matcode from materialmaster where matname='"+a+"' ";
    	//System.out.println(buffer1);
    	rs=smt.executeQuery(sql);
    	while(rs.next())
    	{
    		packing=rs.getString(1);
    		tax=rs.getString(2);
    		pur=rs.getString(3);
    		ins=rs.getString(4);
    	}
    	
    	
	}
	else if(count == 0) 
	{
		buffer=buffer+"<tr> <td><input type='text' name='formbean.mrp1' class='mrp1' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.scase' class='scase' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.spcs' class='spcs' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.stotal' class='stotal' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td> <td><input type='text' name='formbean.rtcase' class='rtcase' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup=''/></td> <td><input type='text' name='formbean.rtpcs' class='rtpcs' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td>   <td><input type='button' value='No Rows' class='butStnd' onclick='fadeout();PersonViewModel(this);'/></td> </tr>"; 
    }
	
	
	buffer=buffer+"</table>";
	
	System.out.println("ami jeta chai: "+tax );
	
	buffer1=buffer+"bubun"+packing+"bubun"+tax+"bubun"+pur+"bubun"+ins;
	System.out.println(buffer1);
	out.print(buffer1);
}
catch(Exception error)
{
	System.out.println("error found on merialdetails jsp "+error);
}
%>