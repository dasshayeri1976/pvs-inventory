<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.connection.account.ConnectionDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="./css/draftbutton.css" />
<link rel="stylesheet" href="./css/printbutton.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<style type="text/css">
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
	font-size:13px;
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
	font-size:13px;
}
#popup /*div id*/
{
	width:1120px;
	height:360px;
	margin:150px auto 0;
	font-weight:bold;
	background-color:#ebedef;
	border-radius:3px;
	box-shadow:0px 0px 10px 0px #424242;
	padding:0px;
	box-sizing:border-box;
	font-family:helvetica;
	visibility:hidden;
	display:inline;
	position:absolute;
	left:0;
	right:0;
	z-index: 9;
}
.bu
{
	background-color: #4CAF50;
    border: none;
    color: white;
    padding: 1px 1px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    cursor: pointer;
}
.bu:hover
{
	background-color: darkred;
	color:white
}
</style>

<script type="text/javascript">
/* $( function() 
		{
			$( "#popup" ).draggable();
		}); */
function confirmation()
{
	var r = confirm("Are You sure to delete this client record");
	var x='';
	if (r == true) 
	{
	    x = true;
	} 
	else 
	{
	    x = false;
	} 
	return x;
}
</script>

<script>
function savepopup()
{
	//alert();
	$("#popup").fadeOut();
	$("#popup").css({"visibility":"hidden","display":"none"});
}
</script>
<sj:head/>
<script>
function showdiv()
	{
		//alert();
		var p=rowIndex;
		$("#popup").fadeIn();
	 	$("#popup").css({"visibility":"visible","display":"block"});
	 	document.getElementById("for1").value="For "+document.getElementsByName("formbean.pname")[p-1].value;
	}
function closepopup()
{
	var batchno=document.getElementsByName("formbean.batchno");
	var expdate=document.getElementsByName("formbean.expdate");
	var aqty=document.getElementsByName("formbean.bqty");
	var fqty=document.getElementsByName("formbean.mrp");
	var purate=document.getElementsByName("formbean.rate");
	var strate=document.getElementsByName("formbean.qsold");
	var rtrate=document.getElementsByName("formbean.qfree");
	var mrp=document.getElementsByName("formbean.pamount");
	for(var i=0; i<batchno.length; i++)
	{
		batchno[i].value="";
		expdate[i].value="";
		aqty[i].value="";
		fqty[i].value="";
		purate[i].value="";
		strate[i].value="";
		rtrate[i].value="";
		mrp[i].value="";
		/* erate[i].value="";
		pamount[i].value=""; */
	}
	var table = document.getElementById("table1");
    var rowCount = table.rows.length;
    for(var i=rowCount-1; i>1; i--) 
    {
    	if(rowCount <= 2) 
    	{
    		break;
    	}
    	table.deleteRow(i);
    }
    //document.getElementById("sta").value="";
    //document.getElementById("stf").value="";
    $("#popup").fadeOut();
	$("#popup").css({"visibility":"hidden","display":"none"});
}
function calaqty()
{
	var p=document.getElementsByName("formbean.aqty");
	var t=0;
	for(var x=0; x<p.length; x++)
	{
		t=t+Number(p[x].value);
	}
	document.getElementById("sta").value=t;
}
function calfqty()
{
	var p1=document.getElementsByName("formbean.fqty");
	var t1=0;
	for(var x1=0; x1<p1.length; x1++)
	{
		t1=t1+Number(p1[x1].value);
	}
	document.getElementById("stf").value=t1;
}
function PersonViewModel(x)
{
	rowIndex=$(x).closest('tr').index();
}
function caltotal()
{
	var s=document.getElementsByName("formbean.amount");
	var total=0;
	for(var i=0;i<s.length;i++)
	{
		total=total+Number(s[i].value);
	}
	document.getElementById("totalamount").value=total.toFixed(2);
}
</script>
<link rel="stylesheet" type="text/css" href="./css/easyui.css"/>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<style>
#ui-datepicker-div {background:#dce6ee;}

#ui-datepicker-div .ui-state-highlight {color: #dce6ee;}

#ui-datepicker-div.ui-datepicker-control {background: blue;}

.ui-dialog-titlebar{ 
    background: #FFCC66 repeat-x;
    color:#fff;      
}
</style>
<script src="./js/dynamictable.js"></script>
</head>
<body onload="disp();">
<center>

<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >General Sales Invoice</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
  
  <s:form action="" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
    
    <div id="popup" style="display:none;">
  <div align="right">
  	<img id="image" src="Image/popupclose.png" height="2%" width="2%" onclick="closepopup();"></img>
  </div>
  <table border="0">
  	<tr>
  		<td colspan="11" align="center">Please Fill-Up Batch No Wise Quantity And Rate</td>
  	</tr>
  	<tr>
  		<td colspan="11"><input type="text" id="for1" name="for1" style="border:none;background:transparent;width:350px;text-align:center" readonly/></td>
  	</tr>
  </table>
  <hr width="100%"/>
  <div style="top:200px;bottom:155px;overflow-y:auto;width:1100px;padding:10px;height:250px;" align="center">
  <table id="table1" border="0" width="90%">
  		<tr>
  			<th></th>
	  		<th>Batch No.</th>
	  		<th>Exp.Dt.</th>
	  		<th>Bal. Qty.</th>
	  		<th>MRP</th>
	  		<th>Rate</th>
	  		<th>Q. Sold</th>
	  		<th>Q. Free</th>
	  		<th>Amount</th>
  		</tr>
  		<tr>
  			<td><input type="checkbox"></input></td>
	  		<td><div align="center"><s:textfield name="formbean.batchno"  id="batchno" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.expdate"  id="expdate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.bqty"  id="bqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calaqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.mrp"  id="mrp" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calfqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rate"  id="rate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.qsold"  id="qsold" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.qfree"  id="qfree" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.pamount"  id="pamount" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
  		</tr>
  </table> 
 
  	<div align="right" style="width:95%;position:relative;  padding:7px;">
      	<input type="button" name="add" class="butStnd" value="Add Row"  onclick="addRow('table1');"></input>
      	<input type="button" name="delete" class="butStnd" value="Delete Row"  onclick="deleteRow('table1');"></input>
      	<input type="button" name="save" class="butStnd" value="Save"  onclick="savepopup();"></input>
      </div>
  </div>
  </div>
  <fieldset style="width:59%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>General Sales Invoice</h3></legend>
  <div align="left">
  Voucher No:- <s:textfield style="border:none"/><br/>
  VAT Cal M.R.P:- <s:radio name="formbean.vatmrp" id="vatmrp" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="showpopup(this.value)"></s:radio>
  </div>
  <table cellpadding="5" width="70%" style="padding:20px">  
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>On&nbsp;A/c</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.company" id="company" list="usList1"  listValue="company" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Party&nbsp;Name:</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.debitac" id="debitac" list="usList2"  listValue="debitac" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>
        </tr>
   </table>

<table border="0">
   		<tr bgcolor="#4292b2" style="color:white">
   			<th colspan="8">Other Details</th>
   		</tr>
   		<tr>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">Freight</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.freight" id="freight" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">L.R.&nbsp;No.</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.lrno" id="lrno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   			
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">Order&nbsp;No.</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.orderno" id="orderno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">OdInt@</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.odint" id="odint" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		</tr>
   		<tr>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">Dispatch&nbsp;THR</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.dispatch" id="dispatch" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">Destination</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.destination" id="destination" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   			
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">No.&nbsp;Of&nbsp;Cases</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.caseno" id="caseno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">L.R.&nbsp;Date</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.lrdate" id="lrdate" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		</tr>
   		<tr>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">Order&nbsp;Date</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.orderdate" id="orderdate" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;">Due&nbsp;Date</td>
   			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.duedate" id="duedate" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
   		</tr>
   </table>
   <br>
    <table width="100%" border="0">
  	<tr bgcolor="#4292b2" style="color:white">
  		<td colspan="6" align="center"><b>Product Details</b></td>
  	</tr>
  </table>
  <table id="table12" border="0px" width="60%" cellpadding="0">  
	<tr bgcolor="#4292b2" style="color:white">
	<th></th>
	<th width="6.5%" ><label>Product Name</label></th>
	<th width="6.5%" ><label>A. Quantity</label></th>
	<th width="6.5%" ><label>F. Quantity</label></th>	
	<th width="6.5%" ><label>Amount</label></th>
	<th width="6.5%" ><label>D@</label></th>
	<th width="6.5%" ><label>DS Rs.</label></th>	
	<th width="6.5%" ><label>Amount</label></th>
	<th width="6.5%" ></th>
	</tr>
	
	<tr>
	<td><input type="checkbox" name="chk"></input></td>
	<td width="6.5%" ><s:textfield name="formbean.pname"  id="pname" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:350px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.aqty"  id="aqty" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.fqty"  id="fqty" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.amount"  id="amount" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px" onkeyup="caltotal();"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.d"  id="d" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.ds"  id="ds" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.amount12"  id="amount12" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px" onkeyup="caltotal();"></s:textfield></td>
	<td width="6.5%"><input type="button" value="B.D." class="butStnd" onclick="PersonViewModel(this);showdiv();"/></td>
	</tr>
  </table>
	<div align="right">
		 <input type="button" value="Add More Field" class="butStnd" onclick="addRow('table12');"></input>
        <input type="button" value="Delete Fields" class="butStnd" onclick="deleteRow('table12');"></input>
	</div>
	<br/>
  <table width="80%" border="0" style="border:0px solid">  
 
  		<tr style="border:0px solid">	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:200px"><label>Bill/Invoice/Memos&nbsp;Details</label></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billno" id="billno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
      		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Date</label></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.date" id="date" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Gross&nbsp;Amount</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.totalmamount" id="totalamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
        </tr>
        
        <tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;">Sold&nbsp;By</td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sold" id="sold" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px"></s:textfield></td>
      		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:110px"><label>E.D&nbsp;@%&nbsp;</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.ed"  id="ed" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
        </tr>
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" >Narration:-</td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
      		
        	
			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:110px"><label>C.D&nbsp;@%</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.cd"  id="cd" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>        
        </tr>
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"colspan="4" rowspan="3"><div style="width:100px"><s:textarea name="formbean.narration" id="narration" cols="50" rows="4" maxlength="200" cssStyle="background:#FFFF99;resize:none;border:0px solid"></s:textarea></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>   
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12%" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>CST.PP&nbsp;@%</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.cstpp"  id="cstpp" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
       
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>   
        	   
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>I.C&nbsp;@%</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.ic"  id="ic" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
		 <tr>
		 	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
     
        	   
        	<td width="" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>V.A.T&nbsp;@%</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.vat"  id="vat" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
         <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td> 
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>   
        	   
        	<td width="" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>T.O.T&nbsp;@%</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.tot"  id="tot" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
         
       <tr>
			<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td> 
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>        
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Round&nbsp;Off</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:radio name="formbean.roundoff" id="roundoff" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="showpopup(this.value)"></s:radio></td>
        </tr>
         <tr>
         	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td> 
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>   
        	   
        	<td width="" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>Add&nbsp;(If&nbsp;Any)</label><s:textfield style="width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.vat"  id="vat" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
     
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td> 
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>        
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Net&nbsp;Amount</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.netamount" id="netamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
        </tr>
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td> 
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>   
        	   
        	<td width="" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>Less&nbsp;Amount</label></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.less"  id="less" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td> 
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>   
        	   
        	<td width="" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>Bill&nbsp;Amount</label></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billamount"  id="billamount" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
   </table>
   <br></br>
  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
      	<s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="return Validate();" ></s:submit>
        
      </div>
 </s:form>  
 </fieldset> 
	
	<p>&nbsp;</p>
	<s:if test="usList3">
	
	<display:table id="table12"  name="usList3" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:85%;color:#000">
	    
	 <s:if test="%{#attr.table12.id == formbean.id}">
	
	<display:column property="gname"   title="Main Group" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="cat"   title="Category"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="classy"   title="Classification" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />

	<display:column property="ptext"   title="Printing Text" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="acgroupupdate" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="acgroupdelete" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	
	<s:else>
	<display:column property="gname"   title="Main Group"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
	
	<display:column property="cat"   title="Category"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="classy"   title="Classification" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="ptext"   title="Printing Text" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="acgroupupdate" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="acgroupdelete" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:else> 
    </display:table>
	</s:if>
  <br/>

</center></body>
</html>
