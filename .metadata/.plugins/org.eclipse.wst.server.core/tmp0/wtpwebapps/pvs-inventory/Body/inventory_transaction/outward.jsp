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
<li ><a href="#">Garge Agency</a></li>
<li>Inventory Transaction</li>
<li> -> Outward Challan</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
  <div style="position:fixed;top:160px;bottom: 45px;overflow-y:auto;width:100%" align="center">
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
  <div align="right">
  		Total&nbsp;Amount:<s:textfield name="formbean.tamount"  id="tamount" size="13" cssStyle="height:25px;border:0px solid #ccc;background:#FFFF99"></s:textfield>
  </div>
  	<div align="right" style="width:95%;position:relative;  padding:7px;">
      	<input type="button" name="add" class="butStnd" value="Add Row"  onclick="addRow('table1');"></input>
      	<input type="button" name="delete" class="butStnd" value="Delete Row"  onclick="deleteRow('table1');"></input>
      	<input type="button" name="save" class="butStnd" value="Save"  onclick="savepopup();"></input>
      </div>
  </div>
  </div>
  </br>
  <fieldset style="width:70%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Outward Challan</h3></legend>
  <div align="left" style="float:left">
          Serial&nbsp;No.&nbsp;&nbsp;<s:textfield name="formbean.vno" id="vno" style="border:none"/>
      </div>
      <div align="right">
          Date:<s:textfield name="formbean.date1" id="date1" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:70px"/>
      </div>
  <table cellpadding="" width="100%" style="padding:0px" border="0">  
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Principle:</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.company" id="company" list="usList1"  listValue="company" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Party:</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.debitac" id="debitac" list="usList2"  listValue="debitac" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>
        </tr>
   </table>
  </br>

  <div style="height:165px;top:200px;bottom:155px;overflow-y:auto;width:93%;float:left">
  <table id="table12" border="0" width="60%" cellpadding="0">  
	<tr bgcolor="#4292b2" style="color:white">
	<th></th>
	<th width="6.5%" ><label>Product Name</label></th>
	<th width="6.5%" ><label>A. Quantity</label></th>
	<th width="6.5%" ><label>F. Quantity</label></th>	
	<th width="6.5%" ><label>Unit</label></th>
	<th width="6.5%" ><label>Amount</label></th>
	<th width="6.5%" ></th>
	</tr>
	
	<tr>
	<td><input type="checkbox" name="chk"></input></td>
	<td width="6.5%" ><s:textfield name="formbean.pname"  id="pname" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:350px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.aqty"  id="aqty" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.fqty"  id="fqty" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.unit" id="unit" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
	<td width="6.5%" ><s:textfield name="formbean.amount"  id="amount" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px" onkeyup="caltotal();"></s:textfield></td>
	<td width="6.5%"><input type="button" value="B.D." class="butStnd" onclick="PersonViewModel(this);showdiv();"/></td>
	</tr>
  </table>
  </div>
  
  <div style="float:right">
		 <input type="button" value="Add" class="butStnd" onclick="addRow('table12');"></input></br>
        <input type="button" value="Delete" class="butStnd" onclick="deleteRow('table12');"></input>
  </div>
	</br>
  <table width="100%" border="0" style="">  
       <tr>
       		<td width="12.5%" style=""><label>Challan&nbsp;No.</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.challanno" id="challanno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
       
       		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Challan&nbsp;Date</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.challandate" id="challandate" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
      		
      		<td></td>
      		<td></td>
      		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Total&nbsp;Amount</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.totalmamount" id="totalamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
       </tr>
       <tr>
       		<td width="12.5%" style=""><label>Truck/R.R.&nbsp;No.</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.truckrr" id="truckrr" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
       
       		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Transporter</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.transporter" id="transporter" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:150px"></s:textfield></td>
       		
       		<td></td>
       		<td></td>
       		
       		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:130px"><label>Less</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="formbean.lessp" id="lessp" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:50px"/></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.ldisc"  id="ldisc" onblur="showDiv();" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
       </tr>
  		<tr style="border:0px solid">	
      		<td width="12.5%" style=""><label>Bill&nbsp;No.</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billno" id="billno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
      		
      		
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Bill Date</label></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billdate" id="billdate" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:140px"><label>AddTax&nbsp;@</label><s:textfield name="formbean.addtaxp" id="addtaxp" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:50px"></s:textfield></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.addtax" id="addtax" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>
        </tr>
        
        <tr>	
      		<td width="12.5%" style="">Narration:-</td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
      		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        
        	<s:if test="%{formbean==null}">
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:120px"><label>R.&nbsp;Off</label>&nbsp;<s:radio name="formbean.roundoff" id="roundoff" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="ro(this.value)"></s:radio></div></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.roundofft" id="roundofft" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:100px"></s:textfield></td>
          </s:if>
          <s:else>
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:120px"><label>R.&nbsp;Off</label>&nbsp;<s:radio name="formbean.roundoff" id="roundoff" list="#{'1':'Yes','2':'No'}" cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="ro(this.value)"></s:radio></div></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.roundofft" id="roundofft" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
          </s:else>
        </tr>
        <tr>
        	<td width="12.5%" style="" colspan="4" rowspan="3"><s:textarea name="formbean.narration" id="narration" cols="50" rows="4" maxlength="200" cssStyle="border:1px solid #ccc;background:#FFFF99;resize:none;border:0px solid"></s:textarea></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        
			<td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top"><label>Net&nbsp;Amount</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top"><s:textfield name="formbean.netamount" id="netamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px"></s:textfield></td>    
        </tr>
       <tr>

        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>        
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        </tr>
        <tr>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>        
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
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

</center>
</div>
</body>
</html>
