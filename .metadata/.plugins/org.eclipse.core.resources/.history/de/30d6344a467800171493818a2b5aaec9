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
int count=0;
double totalamount=0.00,totalaqty=0.00,totalfqty=0.00;
Vector<String> mrp=new Vector<String>();
Vector<String> scase=new Vector<String>();
Vector<String> spcs=new Vector<String>();
Vector<String> total=new Vector<String>();
Vector<String> slcase=new Vector<String>();
Vector<String> slpcs=new Vector<String>();
Vector<String> rate=new Vector<String>();
String p[]=a.split("bubun");

try
{
	System.out.println("hello"+a);
	buffer=buffer+"<tr>  <th>M.R.P</th><th>ST. CASE</th><th>ST. PCS</th><th>TOTAL PCS</th><th>SL. CASE</th><th>SL. PCS</th><th>RATE</th></tr>";
	
	
	
	sql="select count(matcode) from materialdetails where matcode=(select matcode from materialmaster where matname='"+p[0]+"')";
	rs=smt.executeQuery(sql);
	//System.out.println(sql);
	//System.out.println(sp[0]);
	while(rs.next())
	{
		count=rs.getInt(1);
		//System.out.println("value of count: "+count);
		
	}
	if(count > 1)
	{
    sql="select rate1 from placemaster where placecode='"+p[1]+"' ";
     System.out.println(sql);
    	rs=smt.executeQuery(sql);
    	while(rs.next())
    	{
    		group=rs.getString(1);
    	}
    	//System.out.println(group);
    	
		
		sql="select * from materialdetails where matcode=(select matcode from materialmaster where matname='"+p[0]+"')";
		//System.out.println(sql);
    	rs=smt.executeQuery(sql);
    	while(rs.next())
    	{
    		mrp.add(rs.getString(5));
    		scase.add(rs.getString(6));
    		spcs.add(rs.getString(7));
    		total.add(rs.getString(8));
    		slcase.add(rs.getString(12));
    		slpcs.add(rs.getString(14));
    		if(group.compareTo("Local")==0)
        	{
        		rate.add(rs.getString(12));
        		//System.out.println(rs.getString(12));
        	}
    		else if(group.compareTo("Van")==0)
        	{
        		rate.add(rs.getString(13));
        		//System.out.println(rs.getString(13));
        	}
    	}
    	for(int i=0;i<mrp.size();i++)
    	{
    		buffer=buffer+"<tr> <td><input type='text' name='formbean.mrp1' class='mrp1' value='"+mrp.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.scase' class='scase' value='"+scase.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.spcs' class='spcs' value='"+spcs.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.stotal' class='stotal' value='"+total.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td> <td><input type='text' name='formbean.rtcase' class='rtcase' value='"+slcase.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup=''/></td> <td><input type='text' name='formbean.rtpcs' class='rtpcs' value='"+slpcs.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td> <td><input type='text' name='formbean.rate1' class='rate1' value='"+rate.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td> <td><input type='button' value='SELECT' class='butStnd' onclick='PersonViewModel(this);copyvalue();fadeout();'/></td> </tr>"; 
    	}
    	
    	sql="select packing,tcase,tpcs,ttotal,type_tax from materialmaster where matname='"+p[0]+"' ";
    	//System.out.println(buffer1);
    	rs=smt.executeQuery(sql);
    	while(rs.next())
    	{
    		packing=rs.getString(1);
    		totalcase=rs.getString(2);
    		totalpcs=rs.getString(3);
    		tamount=rs.getString(4);
    		typetax=rs.getString(5);
    	}
    	
    	
    	
	}
	else if(count == 0) 
	{
		buffer=buffer+"<tr> <td><input type='text' name='formbean.mrp1' class='mrp1' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.scase' class='scase' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.spcs' class='spcs' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.stotal' class='stotal' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td> <td><input type='text' name='formbean.rtcase' class='rtcase' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup=''/></td> <td><input type='text' name='formbean.rtpcs' class='rtpcs' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td>   <td><input type='button' value='No Rows' class='butStnd' onclick='PersonViewModel(this);fadeout();'/></td> </tr>"; 
    	}
	else
	{
		
		
		sql="select rate1 from placemaster where placecode='"+p[1]+"' ";
	   //  System.out.println(sql);
	    	rs=smt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		group=rs.getString(1);
	    	}
	    	System.out.println(group);
	    	
			
			sql="select * from materialdetails where matcode=(select matcode from materialmaster where matname='"+p[0]+"')";
			//System.out.println("0 count"+sql);
	    	rs=smt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		
	    		/* mrp.add(rs.getString(5));
	    		scase.add(rs.getString(6));
	    		spcs.add(rs.getString(7));
	    		total.add(rs.getString(8));
	    		slcase.add(rs.getString(12));
	    		slpcs.add(rs.getString(14)); */
	    		mrpp=rs.getString(5);
	    		System.out.println("mrp: "+mrpp);
	    		if(group.compareTo("Local")==0)
	        	{
	        		//rate.add(rs.getString(12));
	        		ratee=rs.getString(12);
	        		System.out.println(ratee);
	        	}
	    		else if(group.compareTo("Van")==0)
	        	{
	        		//rate.add(rs.getString(13));
	        		ratee=rs.getString(13);
	        		System.out.println(ratee);
	        	}
	    	}
	    	/* for(int i=0;i<mrp.size();i++)
	    	{
	    		//buffer=buffer+"<tr> <td><input type='text' name='formbean.mrp1' class='mrp1' value='"+mrp.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.scase' class='scase' value='"+scase.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.spcs' class='spcs' value='"+spcs.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calaqty();'/></td>  <td><input type='text' name='formbean.stotal' class='stotal' value='"+total.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calfqty();'/></td> <td><input type='text' name='formbean.rtcase' class='rtcase' value='"+slcase.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup=''/></td> <td><input type='text' name='formbean.rtpcs' class='rtpcs' value='"+slpcs.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td> <td><input type='text' name='formbean.rate1' class='rate1' value='"+rate.get(i)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onkeyup='calamount();calpopupamount();' onblur='calforvat();'/></td> <td><input type='button' value='SELECT' class='butStnd' onclick='PersonViewModel(this);copyvalue();fadeout();'/></td> </tr>"; 
	    	} */
	    	
	    	sql="select packing,tcase,tpcs,ttotal,type_tax from materialmaster where matname='"+p[0]+"' ";
	    	//System.out.println("0 count "+sql);
	    	rs=smt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		packing=rs.getString(1);
	    		totalcase=rs.getString(2);
	    		totalpcs=rs.getString(3);
	    		tamount=rs.getString(4);
	    		typetax=rs.getString(5);
	    	}
	    	
	    	
	    	
		
	}
	
	
	buffer=buffer+"</table>";
	
	if(count > 1)
	{
	
	buffer1=buffer+"bubun"+packing+"bubun"+totalcase+"bubun"+totalpcs+"bubun"+tamount+"bubun"+typetax+"bubun"+count;
	//System.out.println(count);
	//System.out.println(buffer1);
	out.print(buffer1);
	}
	else if(count == 1)
	{
		buffer1=buffer+"bubun"+packing+"bubun"+totalcase+"bubun"+totalpcs+"bubun"+tamount+"bubun"+typetax+"bubun"+count+"bubun"+mrpp+"bubun"+ratee;
		out.print(buffer1);
	}
	
}




catch(Exception error)
{
	System.out.println("error found on merialdetails jsp "+error);
}
%>