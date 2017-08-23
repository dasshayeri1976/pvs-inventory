<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Jobwork Entry</title>
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

*{ margin:0; padding:0;}
body{ font-family:Verdana, Geneva, sans-serif; font-size:14px;}
.container{ width:1100px; margin:auto;}
p { padding:2px 3px;}
.padding_left { padding-left:100px !important;}
.one h1 { font-size:18px;}
.one_middle p:nth-child(n+3) { margin-top:20px;}
.one_middle p:last-child { margin-top:30px; padding-bottom:10px; font-size:15px; font-weight:600;}
.one_left p:last-child { padding-bottom:20px; }
.one .one_right p:nth-child(1) { margin-top:30px;}
.one .one_right p:nth-child(1) span{ padding-left:30px;}
.one .one_right p:nth-child(2) span{ padding-left:78px;}
.one .one_right p:nth-child(3) span{ padding-left:49px;}
.one .one_right p:nth-child(4) span{ padding-left:78px;}
.one .one_right p:nth-child(5) span{ padding-left:4px;}
.one tr td, .two tr td, .three tr td {border-bottom: 1px dashed #000;}
.two_left p:nth-child(2) { margin-top:70px;}
.two_right p { border-left:1px solid #000; margin:5px 0px; padding-left:5px;}
.two {padding: 4px 0px;}
.two .two_right p:nth-child(1) span{ padding-left:20px;}
.two .two_right p:nth-child(2) span{ padding-left:38px;}
.two .two_right p:nth-child(3) span{ padding-left:48px;}
.two .two_right p:nth-child(4) span{ padding-left:61px;}
.two .two_right p:nth-child(5) span{ padding-left:50px;}
.three tr td { padding-bottom:2px;}
.three tr:nth-child(n+2) td { border-bottom:none;}
.three p { font-size:12px; padding-top:2px; padding-bottom:2px;  border-left:1px solid #000;}
.three tr:nth-child(n+2) p {border:none;}
.three tr td{ margin:3px 0px;}
.three h3 { font-size:14px; padding:3px 2px;}
.three tr:last-child td {border-top:1px dashed #000000; border-bottom:1px dashed #000000;}
.four p { font-size:12px;}
.four { padding:5px 0px;}
.four_paragraph { text-align:justify; padding-right:25px;}
.border_left{ border-left:1px solid #000000; margin:2px 0px; padding-left:5px;}
.border_top { border-top:1px dashed #000000;  padding-left:5px; }

.five tr td { border-bottom:1px dashed #000000; border-top:1px dashed #000000;}
.five tr td { padding:5px 0px;}
.six tr:last-child td { border-bottom:1px dashed #000000;}
.six .six_right td{ padding:30px 0px 5px 0px;}
.six .six_left td { padding-top:10px;}


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
<!--       
		java.util.Date dt = new java.util.Date();
		//final String td = (dt.getYear() + 1900) + "-" + (dt.getMonth() + 1)+ "-" + dt.getDate();
		final String td = dt.getDate()+"/"+(dt.getMonth() + 1)+"/"+(dt.getYear() + 1900);
 -->
	<%		String packing2="",casep2="",pcs2="",freepcs2="",mrp2="",rate2="",amount2="",disc2="",discp2="",discamt2="",grossamt2="",gst2="", gstamt2="";
   			String area = "", salesmanname = "",retailername="",memono="",address="",date="",placename="",partyname="",pgstinno="", voucher_no="";
			String packing = "", case1 = "", pcs1 = "", free = "",mrp = "", rate1 = "", amt = "",gst1 = "",gstamt = "",totalamt ="",total="",grossamt="",sgst="",cgst="",igst="",add1="", netamt="";
			String nameofitem="";
			String user = request.getParameter("value");
			int cou=0;
			double tot1=0;
			System.out.println("user :"+user);
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs=null;
			String sql = "select * from itransaction where id='"+user+"' order by id desc";

			try {

				 rs = stm.executeQuery(sql);

					while (rs.next()) {
					voucher_no = rs.getString(2);
					area = rs.getString(4);
					salesmanname = rs.getString(6);
					retailername = rs.getString(7);
					date = rs.getString(5);
					memono = rs.getString(8); 
					address = rs.getString(13);
					total = rs.getString(14);
					grossamt= rs.getString(16);
					cgst = rs.getString(20);
					sgst = rs.getString(19);
					igst = rs.getString(21);
					add1 = rs.getString(25);
					netamt = rs.getString(26);
				}
					
					sql= "Select placename from placemaster where placecode ='"+area+"'";
					 rs = stm.executeQuery(sql);
					 System.out.println(sql+","+voucher_no);

					while (rs.next()) {
						placename = rs.getString(1);
					}
					sql= "Select party_name, gstinno from partymaster1 where party_code ='"+retailername+"'";
					//System.out.println(sql);
					rs = stm.executeQuery(sql);
				

					while (rs.next()) {
						partyname = rs.getString(1);
						pgstinno = rs.getString(2);
					}
					sql= "Select * from idetails where voucherno ='"+voucher_no+"'";
					rs = stm.executeQuery(sql);
					

					while (rs.next()) {
						packing = rs.getString(20);
						case1 = rs.getString(4);
						pcs1 = rs.getString(5);
						free = rs.getString(6);
						mrp = rs.getString(7);
						rate1 = rs.getString(8);
						amt = rs.getString(11);
						gst1 = rs.getString(24);
						gstamt = rs.getString(19);
						totalamt = rs.getString(15);
					}

			} catch (Exception e) {

			}
			
		%>
					<div id="printableArea">

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="container">
  <tr>
    <td>
    
    
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="one">
            <tr>
                <td align="left" valign="bottom" class="one_left">
                    <p>D.L.No. : 30 (20A) & 30A(20B) </p>
                    <p>Edible Oil Lic.No. 16/HzB </p>
                </td>
                <td align="center" valign="top" class="one_middle">
                    <h1>PODDAR VARIETY STORES</h1>
                    <p>GOLA ROAD, RAMGARH CANTT - 829122,DIST- HAZARIBAGH.</p>
                    <p>( O R I G I N A L ) </p>
                    <p>TAX INVOICE</p>
                </td>
                <td align="left" valign="middle" class="one_right">
                    <p>Phone <span>:</span></p>
                    <p> GSTIN No.<span><%=pgstinno%></span></p>
                </td>
            </tr>
        </table>
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="two">
            <tr>
                <td width="50%" align="left" valign="top" class="two_left">
                <p>To,<br>S.D.SINGH </p>
                <p>GSTIN No :<span><%=pgstinno%></span></p>
                </td>
                
                <td width="50%" align="left" valign="top" class="two_right">
                    <p>Memo Number: <span><%=memono%></span> </p>
                    <p>Invoice date: <span><%=date%></span></p>
                    <p>Area Name: <span><%=placename%></span></p>
                    <p>Category: <span>: CASH </span><span class="padding_left">AMMENDED</span></p>
                    <p>Booked By: <span><%=partyname%></span> </p>
                </td>
            </tr>
        </table>
        
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="three">
        <tr>
            <td width="20%" align="left" valign="middle"><h3>PARTICULARS </h3></td>
            <td width="7%" align="center" valign="middle"><p>HSN CODE</p></td>
            <td width="4%" align="center" valign="middle"><p>PACK</p></td>
            <td width="4%" align="center" valign="middle"><p>CASE</p></td>
            <td width="4%" align="center" valign="middle"><p>PCS.</p></td>
            <td width="4%" align="center" valign="middle"><p>FREE</p></td>
            <td width="4%" align="center" valign="middle"><p>M.R.P.</p></td>
            <td width="4%" align="center" valign="middle"><p>RATE</p></td>
            <td width="6%" align="center" valign="middle"><p>AMOUNT</p></td>
            <td width="4%" align="center" valign="middle"><p>CSH/CS</p></td>
            <td width="4%" align="center" valign="middle"><p>SCH.%</p></td>
            <td width="6%" align="center" valign="middle"><p>SCH.AMT</p></td>
            <td width="8%" align="center" valign="middle"><p>GR AMOUNT</p></td>
            <td width="5%" align="center" valign="middle"><p>GST @</p></td>
            <td width="6%" align="center" valign="middle"><p>GST AMT</p></td>
            <td width="11%" align="right" valign="middle"><p>TOTAL AMOUNT</p></td>

        </tr>
        <tr>
	   <% sql= "SELECT COUNT(voucherno) from idetails where voucherno ='"+voucher_no+"'" ;

	   	try{
	   
	 	   rs= stm.executeQuery(sql);
	 		 System.out.println(sql);
	 	 while (rs.next()) {
			 		 System.out.println("hi");
					cou = rs.getInt(1);
					System.out.println("hi:"+cou);
	 						 }
	  			 
	  			 	sql="(select nameitem from itransaction where voucherno='"+voucher_no+"') ";
				   	sql= "Select * from idetails where voucherno ='"+voucher_no+"'";
        			 System.out.println(sql);
					 rs = stm.executeQuery(sql);
					 while(rs.next())
					 {
					    nameofitem=rs.getString(3);
					    packing2=rs.getString(20);
					    casep2=rs.getString(4);
						pcs2=rs.getString(5);
						freepcs2=rs.getString(6);
						mrp2=rs.getString(7);
						rate2=rs.getString(8);
						amount2=rs.getString(11);
						disc2=rs.getString(9);
						discp2=rs.getString(10);
						discamt2=rs.getString(16);
						grossamt2=rs.getString(17);
						gst2=rs.getString(18);
						gstamt2=rs.getString(19);
						tot1=Double.parseDouble(grossamt2)+Double.parseDouble(gstamt2);
						
					 %>
						 
						 <tr>
				            <td width="20%" align="left" valign="middle"><p><%=nameofitem%></p></td>
				            <td width="7%" align="center" valign="middle"><p></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=packing2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=casep2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=pcs2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=freepcs2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=mrp2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=rate2%></p></td>
				            <td width="6%" align="center" valign="middle"><p><%=amount2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=disc2%></p></td>
				            <td width="4%" align="center" valign="middle"><p><%=discp2%></p></td>
				            <td width="6%" align="center" valign="middle"><p><%=discamt2%></p></td>
				            <td width="8%" align="center" valign="middle"><p><%=grossamt2%></p></td>
				            <td width="5%" align="center" valign="middle"><p><%=gst2%></p></td>
				            <td width="6%" align="center" valign="middle"><p><%=gstamt2%></p></td>
				            <td width="11%" align="right" valign="middle"><p><%=tot1%></p></td>

				        </tr>
					<% }
					
	   			
	   	  
         
       } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	   	ConnectionDAO.closeConnection(conn);
       %>
       	
       	        </tr>
 </table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" class="four">
  <tr>
    <td width="43%" rowspan="5" align="left" valign="top"><p class="four_paragraph">We hereby certify that goods mentioned in this memo are warranted to be the same in nature substance and quality as demanded by the vender. Above rates are inclusive of delivery charges. </p></td>
    <td width="6%" align="center" valign="top" ><p class="border_left">GST @</p></td>
    <td width="9%" align="center" valign="top"><p>ON AMOUNT:</p></td>
    <td width="7%" align="center" valign="top"><p>SGST AMT:<span><%=sgst%></span></p></td>
    <td width="7%" align="center" valign="top"><p>CGST AMT:<span><%=cgst%></span></p></td>
    <td width="7%" align="center" valign="top"><p>IGST AMT:<span><%=igst%></span></p></td>
    <td width="10%" align="left" valign="top"><p class="border_left">Total&nbsp;Gross&nbsp;Amount:</p></td>
     <td width="1%" align="center" valign="top"><p></p></td>
    <td width="9%" align="right" valign="top"><p><span><%=grossamt%></span></p></td>
  
  </tr>
  <tr>
    <td width="10%" align="right" valign="top"><p>3367.35</p></td>
    <td width="6%" align="center" valign="top" ><p class="border_left"> 05.00</p></td>
    <td width="9%" align="center" valign="top"><p>448.67</p></td>
    <td width="7%" align="center" valign="top"><p>65.06</p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="10%" align="left" valign="top"><p class="border_left">&nbsp;</p></td>
    <td width="1%" align="center" valign="top"></td>
    <td width="10%" align="right" valign="top"><p></p></td>
  </tr>
  <tr>
  <td width="6%" align="center" valign="top"><p class="border_left"> 12.00</p></td>
    <td width="9%" align="center" valign="top"><p>2704.86</p></td>
    <td width="7%" align="center" valign="top"><p>148.76</p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="13%" align="left" valign="top"><p class="border_left">Rounding Off (Less):</p></td>
    <td width="1%" align="center" valign="top"><p></p></td>
    <td width="9%" align="right" valign="top"><p><span><%=add1%></span></p></td>
  </tr>
  <tr>
    <td width="6%" align="center" valign="top"><p class="border_left"> 18.00</p></td>
    <td width="9%" align="center" valign="top"><p></p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="7%" align="center" valign="top"><p></p></td>
    <td width="10%" rowspan="2" align="left" valign="bottom"><p class="border_top">Net Amount:</p></td>
    <td width="1%" align="center" valign="top"><p >&nbsp; </p></td>
    <td width="10%" rowspan="2" align="right" valign="bottom"><p class="border_top"><span><%=netamt%></span></p></td>
  </tr>
  <tr>
    <td width="6%" align="center" valign="top"><p class="border_left">28.00</p></td>
    <td width="9%" align="center" valign="top"><p>ON AMOUNT</p></td>
    <td width="7%" align="center" valign="top"><p>SGST AMT</p></td>
    <td width="7%" align="center" valign="top"><p>CGST AMT</p></td>
    <td width="7%" align="center" valign="top"><p>IGST AMT</p></td>
    <td width="1%" align="center" valign="top"><p>&nbsp;</p></td>
    </tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" class="five">
  <tr>
    <td><p>Rupees In Words : THREE THOUSAND THREE HUNDRED SIXTY SEVEN ONLY.</p></td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="six">
  <tr class="six_left">
    <td><p>Received the Stock mentioned above in good condition.</p></td>
  </tr>
  <tr class="six_right">
    <td ><p>Purchaser's Signature</p></td>
    <td align="right" valign="top"><p>Authorised Signatory</p></td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="seven">
  <tr>
    <td align="right" valign="top"><p>E.& O.E.</p></td>
  </tr>
</table>

    
    
    
    
    
    
    
    
    
    
    
    
    </td>
  </tr>
</table> <!-- containerend -->
    

	
 <br/>
</div>
<input type="button" onclick="printDiv('printableArea')" value="print a div!" /> 	         
</center></body>
</html>
