<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%@ page import="java.util.*"%>

<%
try
{
	String sql="",x="",xx="",led="";
	String t="";
	String buffer="<table>";
	int count1=0;
	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
	
	String a=request.getParameter("count");
	//System.out.println(a);
	String a1[]=a.split(",");
	buffer=buffer+"<tr align='center' bgcolor='#4292b2' style='color:white'><td></td><td>Document Ref. No.</td><td>Date</td><td>Bill Amount</td><td>Adjusted</td><td>Dues Amount</td><td>Amount</td></tr>"; 
	
		sql="select ledgerid from ledgermaster where ledgername='"+a1[0]+"' and billbybill='Y' ";
		//System.out.println(sql);
		ResultSet rs1=smt.executeQuery(sql);
		while(rs1.next())
		{
			led=rs1.getString(1);
			x=rs1.getString(1).substring(0,2);
		}

		sql="select count(ledgerid) from outstandingledger where ledgerid='"+led+"' and voucherno not like 'RC%' and voucherno not like 'RB%'";
		//System.out.println(sql);
		rs1=smt.executeQuery(sql);
		while(rs1.next())
		{
			count1=rs1.getInt(1);
		}
		//System.out.println("count value "+count1);
		//String[] arcount=new String[count1];
		String aa="",bb="",cc="",dd="",ee="",ff="";
		Vector<String> four=new Vector<String>();
		Vector<String> five=new Vector<String>();
		Vector<String> six=new Vector<String>();
		Vector<String> seven=new Vector<String>();
		Vector<String> eight=new Vector<String>();
		Vector<String> nine=new Vector<String>();
		if(count1>0)
		{
			//System.out.println("hello");
			for(int j=0;j<count1;j++)
			{	
				sql="select * from outstandingledger where ledgerid='"+led+"' and duesamount <> 0 and voucherno not like 'RC%' and voucherno not like 'RB%'";
				System.out.println(sql);
				rs1=smt.executeQuery(sql);
				while(rs1.next())
				{
					aa=rs1.getString(4);
					bb=rs1.getString(5);
					cc=rs1.getString(6);
					dd=rs1.getString(7);
					ee=rs1.getString(8);
					if(!rs1.getString(9).equals(""))
					{
						ff=rs1.getString(9);
					}
					else
					{
						ff="0";
					}
					//System.out.println("outstanding value "+aa+"-"+bb+"-"+cc+"-"+dd+"-"+ee);
					four.add(aa);//vector 'four' value set
					five.add(bb);//vector 'five' value set
					six.add(cc);//vector 'six' value set
					seven.add(dd);//vector 'seven' value set
					eight.add(ee);//vector 'eight' value set
					nine.add(ff);
				} 
				if(four.size()>0)
				{
					//getting vector value
					t="<tr><td><input type='checkbox' name='chk'/></td><td><input type='hidden' name='parthidden' id='"+j+"' value='"+a1[0]+"'/><input type='text' name='formbean.doref' value='"+four.get(j)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:155px'/></td> <td><input type='text' name='formbean.dat' value='"+five.get(j)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:155px'/></td> <td><input type='text' name='formbean.billamount' value='"+six.get(j)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.adjusted' value='"+seven.get(j)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.dues' value='"+eight.get(j)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.amount1' value='"+nine.get(j)+"' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td></tr>";
					buffer=buffer+t;
				}
				else
				{
					t="<tr><td><input type='checkbox' name='chk'/></td><td><input type='hidden' name='parthidden' value='"+a1[0]+"'/><input type='text' name='formbean.doref' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:155px'/></td> <td><input type='text' name='formbean.dat' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:155px'/></td> <td><input type='text' name='formbean.billamount' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.adjusted' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.dues' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.amount1' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td></tr>"; 
					buffer=buffer+t;
				}
			}
		}
		else if(count1==0)
		{
			t="<tr><td><input type='checkbox' name='chk'/></td><td><input type='hidden' name='parthidden' value='"+a1[0]+"'/><input type='text' name='formbean.doref' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:155px'/></td> <td><input type='text' name='formbean.dat' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;width:155px'/></td> <td><input type='text' name='formbean.billamount' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.adjusted' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.dues' value='' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td> <td><input type='text' name='formbean.amount1' style='height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:155px'/></td></tr>"; 
			buffer=buffer+t;
		}
		//System.out.println(buffer);
		buffer=buffer+"</table>"; 
	out.print(x+"||"+a1[1]+"||"+buffer);
	//System.out.println(x+"||"+a1[1]+"||"+buffer);

}
catch(Exception h)
{
	System.out.println("error in finding sundry "+h);
}
%>