
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.OutputStream" %>
<%@page import="com.connection.account.ConnectionDAO" %>
<%@page import="com.helper.account.NumToWord" %> 
<%@ page import="java.sql.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Job Card Printing Page</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/draftbutton.css" />
<link rel="stylesheet" href="css/printbutton.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>

<script language="javascript">
            function printDiv(divName) {
                  var printContents = document.getElementById(divName).innerHTML;
                  var originalContents = document.body.innerHTML;
                 
                  document.body.innerHTML = printContents;
 
                  window.print();
 

                  document.body.innerHTML = originalContents;
            }
 
</script>

<style type="text/css">
hr.style16 { 
	border-top: 1px dashed #8c8b8b;
	border-bottom: none;
	border-left: none;
	border-right: none;
	width: 25%;
	display: inline-block;
} 
hr.style16:before, hr.style16:after { 
	content: '\002702';
	display: inline-block;
	position: relative;
	top: -14px;
	padding: 0 5px;
	background: #ffffff; 
	color: #8c8b8b; 
	font-size: 18px;
}
hr.style16:before { 
  left: -20%;
}
hr.style16:after { 
  left: 20%;
}
@page {
    size: auto;   /* auto is the initial value */
    margin: 0;  /* this affects the margin in the printer settings */
}
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable tr {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffff;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}


table.imagetable {
	text-decoration: none;
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#000;
	border-width: 1px;
	border-top:1px solid #c6d5e1;
	border-bottom:1px solid #c6d5e1;
	border-right:1px solid #c6d5e1;
	border-left:1px solid #c6d5e1;
	border-collapse: collapse;
	
}
table.imagetable th {
	
	background:url(images/header-bg.gif);
	border-width: 1px;
	padding:4px 6px 6px;
	color:#fff;
	border-top:1px solid #c6d5e1;
	border-bottom:1px solid #c6d5e1;
	border-right:1px solid #c6d5e1;
	border-left:1px solid #c6d5e1;
	border-style: solid;
	
}
table.imagetable td {
	text-decoration:none;
	border-width: 1px;
	padding:4px 6px 6px;
	border-top:1px solid #c6d5e1;
	border-bottom:1px solid #c6d5e1;
	border-right:1px solid #c6d5e1;
	border-left:1px solid #c6d5e1;
	border-style: solid;
	background-color: #ffffff;
	
}

</style>
<sj:head/>

<style>
#ui-datepicker-div {background:#dce6ee;}

#ui-datepicker-div .ui-state-highlight {color: #dce6ee;}

#ui-datepicker-div.ui-datepicker-control {background: blue;}


.ui-dialog-titlebar{ 
    background: #FFCC66 repeat-x;
    color:#fff;      
}
</style>


</head>

<body><center>
<% 
 String cmp=(String)session.getAttribute("cmp");
 String val12=(String)session.getAttribute("ad1");
 String val22=(String)session.getAttribute("ad2");
 //System.out.println("got "+val12);
%>
<input type="button" onclick="printDiv('printableArea')" value="print" />
<div id="printableArea">
<table width="100%" border="0">
		  <tr>
		    <td width="18%"><img src="gargelogo.jpg" height="80px" width="80px" style="margin-top:0px;padding-left: 10px;" /></td>
		    <td width="65%" style="text-align:center"><p style="font-family:Arial, Helvetica, sans-serif; font-size:18px;margin-top:-6px;"><%=cmp %></p>
		   
			<p style="margin-top:-12px;"><%=val12 %><br /><%=val22 %></p>
			</td>
		    <td style="padding-top: 0px;" width="17%">
		    
		    </td>
		  </tr>
 
		</table>
<p style="margin-top:-40px;" align="center"><h3 align="center">Cash Receipt Voucher</h3></p>

<table border="1">
<% 
		
		
		String particulars="",qty="",rate="",amount="",sln="",date="",vno="",refno="",refdate="",narration="";
		
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);

		String id =(String)request.getParameter("id");
		String sql="select voucherno,entrydate,referenceno,referencedate from accounttransaction where id='"+id+"' ";
		ResultSet rs= stm.executeQuery(sql);
		
		while(rs.next())	
		{
			vno=rs.getString(1);
			date=rs.getString(2);
			refno=rs.getString(3);
			refdate=rs.getString(4);
			sln=vno.substring(14,15);
		}
		sql="select narration from accountnarration where voucherno='"+vno+"' ";
		rs= stm.executeQuery(sql);
		while(rs.next())
		{
			narration=rs.getString(1);
		}
		
				%>
<table table-border="0" style="width:100%" >
<tr>

<td>Sl.No :<%=sln %></td>
<td align="right">Date :<%=date %></td>
</tr>
</table>	
<table cellpadding="0" cellspacing="0" border="0" id="table" class="imagetable" style="width:80%" align="center" >
		<thead>
				
			<tr>
				
				<th><center>Sl.No.</center></th>
				<th><center>Particulars</center></th>
				<th><center>Amount(Dr)</center></th>
				<th><center>Amount(Cr)</center></th>
				
			</tr>
			
		</thead>
		<tbody>
			
			<%!
			String totaldr="",totalcr="";
			double dr=0.00,cr=0.00,d=0.00,c=0.00;	

						int i=1;
					%>
				
				<%
				try
				{
					
					sql="select ledgermaster.ledgername,if(accountdetails.amount>0,accountdetails.amount,0),abs(if(accountdetails.amount<0,accountdetails.amount,0)) from accountdetails inner join ledgermaster  where accountdetails.voucherno='"+vno+"' and accountdetails.ledgerid=ledgermaster.ledgerid ";
					
					rs= stm.executeQuery(sql);
					
					while(rs.next())
						
					{
						
					dr=rs.getDouble(2);
					cr=rs.getDouble(3);
					
					d=d+dr;
					c=c+cr;
				%>
				<tr>	
							
					<td><%=i %></td>
					
					
					<td><%=rs.getString(1) %></td>
					
					<td><%=rs.getString(2) %></td>
					
					<td><%=rs.getString(3) %></td>
				</tr>	
					<%
						i++;
					%>
					
					
				<%
					}

					while(i>0 && i<10)
					{
						
						%>
						<tr>	
						
						<td style="height:13px"></td>
						<td style="height:13px"></td>
						<td style="height:13px"></td>
						<td style="height:13px"></td>
		
						</tr>
						<%
					i++;	
					}
					
				 %>
					<tr>	
					
					<td><b>Ref.No <%=refno %></b></td>
			
					<td><b>Ref.Date <%=refdate %></b></td>
					
					<td><b><%= d %></b></td>
					
					<td><b><%= c %></b></td>
				</tr>
			
				<table width="100%" table-border="0">
				<tr>
				<td colspan="3" align="left">
				Rupees In Words	: <%=NumToWord.numberConvert((int)d) %><br/>
				Narration		:<%=narration %>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				
				<tr>
				<td align="left">				
					Signature	
				</td>
				<td align="center" style="padding-left:190px">				
					Cashier/Accountant	
				</td>
				<td align="right" >
					Authorized Signatory	
				</td>
				
				</tr>
				</table>
				
				
				
				<%
				d=0;c=0;
				}
				catch(SQLException e)
					{
						e.printStackTrace();
					}
			
				%>
				
			
			
		</tbody>
		</table>
		<hr class="style16" /><hr class="style16" /><hr class="style16" /><hr class="style16" />
		
		<table width="100%">
		  <tr>
		    <td width="18%"><img src="gargelogo.jpg" height="80px" width="80px" style="margin-top:-10px;padding-left: 10px;" /></td>
		    <td width="65%" style="text-align:center"><p style="font-family:Arial, Helvetica, sans-serif; font-size:18px;margin-top:-50px;"><%=cmp %></p>
		   
			<p style="margin-top:-12px;"><%=val12 %><br /><%=val22 %></p>
			</td>
		    <td style="padding-top: 0px;" width="17%">
		   
		    </td>
		  </tr>
</table> 
<p style="margin-top:-50px; align:center;"><h3 align="center">Cash Receipt Voucher</h3></p>
		
<% 
		
		sql="select voucherno,entrydate,referenceno,referencedate from accounttransaction where id='"+id+"' ";
		rs= stm.executeQuery(sql);
		
		while(rs.next())	
		{
			vno=rs.getString(1);
			date=rs.getString(2);
			refno=rs.getString(3);
			refdate=rs.getString(4);
			sln=vno.substring(14,15);
		}
		sql="select narration from accountnarration where voucherno='"+vno+"' ";
		rs= stm.executeQuery(sql);
		while(rs.next())
		{
			narration=rs.getString(1);
		}
		
		%>			
<table table-border="0" style="width:100%" >
<tr>

<td>Sl.No :<%=sln %></td>
<td align="right">Date :<%=date %></td>

</tr>
</table>	

<table cellpadding="0" cellspacing="0" border="0" id="table" class="imagetable" style="width:80%" align="center" >
		<thead>
				
			<tr>
				
				<th><center>Sl.No.</center></th>
				<th><center>Particulars</center></th>
				<th><center>Amount(Dr)</center></th>
				<th><center>Amount(Cr)</center></th>
				
			</tr>
			
		</thead>
		<tbody>
				
					<%-- <%
						i=1;
					%> --%>
				
				<%
				i=1;
				try
				{
					
					sql="select ledgermaster.ledgername,if(accountdetails.amount>0,accountdetails.amount,0),abs(if(accountdetails.amount<0,accountdetails.amount,0)) from accountdetails inner join ledgermaster  where accountdetails.voucherno='"+vno+"' and accountdetails.ledgerid=ledgermaster.ledgerid ";
					
					rs= stm.executeQuery(sql);
					
					while(rs.next())
						
					{
						
					dr=rs.getDouble(2);
					cr=rs.getDouble(3);
					
					d=d+dr;
					c=c+cr;
				%>
				<tr>	
							
					<td><%=i %></td>
					
					
					<td><%=rs.getString(1) %></td>
					
					<td><%=rs.getString(2) %></td>
					
					<td><%=rs.getString(3) %></td>
				</tr>	
					<%
						i++;
					%>
					
				<%
					}
					while(i>0 && i<10)
					{
						
						%>
						<tr>	
						
						<td style="height:13px"></td>
						<td style="height:13px"></td>
						<td style="height:13px"></td>
						<td style="height:13px"></td>
		
						</tr>
						<%
					i++;	
					}
					
					%>
					
					
					<tr>	
					
					<td><b>Ref.No <%=refno %></b></td>
					
					
					<td><b>Ref.Date <%=refdate %></b></td>
					
					<td><b><%= d %></b></td>
					
					<td><b><%= c %></b></td>
				</tr>
				<table width="100%" table-border="0">
				<tr>
				<td colspan="3" align="left">
				Rupees In Words	: <%=NumToWord.numberConvert((int)d) %><br/>
				Narration		:<%=narration %>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				
				<tr>
				<td align="left">				
					Signature	
				</td>
				<td align="center" style="padding-left:190px">				
					Cashier/Accountant	
				</td>
				<td align="right" >
					Authorized Signatory	
				</td>
				
				</tr>
				</table>
				
				
				
				<%
				i=0;d=0;c=0;
				ConnectionDAO.closeConnection(conn);
				}
				catch(SQLException e)
					{
						e.printStackTrace();
					}
			
				%>

			

		</tbody>
		</table>
		
</div>		
<input type="button" onclick="printDiv('printableArea')" value="print" />
</center></body>
</html>