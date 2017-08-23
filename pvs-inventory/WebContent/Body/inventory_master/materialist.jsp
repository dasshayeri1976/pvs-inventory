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


<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/>
<script src="//code.jquery.com/jquery-1.12.4.js"></script> 
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
		var $easy1 = $.noConflict(true);
	</script>
<script>
/*$( function() 
{
	$( "#popup" ).draggable();
});*/
 $(document).ready(function() {
	   
	 $("#ram").css({ 'display': "block" });
	    $easy1('#table12').DataTable( {
	       
	    	 "scrollX": true,
	        paging:  false,
	        ordering: false,       
	    } );
	} );
 </script>


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
	width:1165px;
	height:340px;
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
function showDiv()
	{
		$("#popup").fadeIn();
	 	$("#popup").css({"visibility":"visible","display":"block"});
	}
function closepopup()
{
	var batchno=document.getElementsByName("formbean.batchno");
	var expdate=document.getElementsByName("formbean.expdate");
	var aqty=document.getElementsByName("formbean.aqty");
	var fqty=document.getElementsByName("formbean.fqty");
	var purate=document.getElementsByName("formbean.purate");
	var strate=document.getElementsByName("formbean.strate");
	var rtrate=document.getElementsByName("formbean.rtrate");
	var mrp=document.getElementsByName("formbean.mrp");
	var amount=document.getElementsByName("formbean.amounta");
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
		amount[i].value="";
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
    document.getElementById("sta").value="";
    document.getElementById("stf").value="";
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
function calaqtya()
{
	var p=document.getElementsByClassName("aqty");
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
function calfqtya()
{
	var p1=document.getElementsByClassName("fqty");
	var t1=0;
	for(var x1=0; x1<p1.length; x1++)
	{
		t1=t1+Number(p1[x1].value);
	}
	document.getElementById("stf").value=t1;
}
function caltotal()
{
	var a=document.getElementsByName("formbean.amounta");
	var count=0;
	for(var i=0;i<a.length;i++)
	{
		//alert(xx[i].value);
		count=count+Number(a[i].value);
	}
	document.getElementById("total").value=count.toFixed(2);
}
function caltotal123()
{
	//alert();
	var a=document.getElementsByClassName("amounta");
	var count=0;
	for(var i=0;i<a.length;i++)
	{
		//alert(xx[i].value);
		count=count+Number(a[i].value);
	}
	document.getElementById("total").value=count.toFixed(2);
}
function copy()
{
	var batch=document.getElementsByClassName("batchno");
	var expdate=document.getElementsByClassName("expdate");
	var aqty=document.getElementsByClassName("aqty");
	var fqty=document.getElementsByClassName("fqty");
	var purate=document.getElementsByClassName("purate");
	var strate=document.getElementsByClassName("strate");
	var rtrate=document.getElementsByClassName("rtrate");
	var mrp=document.getElementsByClassName("mrp");
	var amounta=document.getElementsByClassName("amounta");
	
	var x1=document.getElementsByClassName("batchnohidden");
	var x2=document.getElementsByClassName("expdatehidden");
	var x3=document.getElementsByClassName("aqtyhidden");
	var x4=document.getElementsByClassName("fqtyhidden");
	var x5=document.getElementsByClassName("puratehidden");
	var x6=document.getElementsByClassName("stratehidden");
	var x7=document.getElementsByClassName("rtratehidden");
	var x8=document.getElementsByClassName("mrphidden");
	var x9=document.getElementsByClassName("amountahidden");

	for(var i1=0; i1<batch.length; i1++)
	{
		x1[i1].value=batch[i1].value;
		x2[i1].value=expdate[i1].value;
		x3[i1].value=aqty[i1].value;
		x4[i1].value=fqty[i1].value;
		x5[i1].value=purate[i1].value;
		x6[i1].value=strate[i1].value;
		x7[i1].value=rtrate[i1].value;
		x8[i1].value=mrp[i1].value;
		x9[i1].value=amounta[i1].value;
	}
}
function calamount()
{
	//alert();
	var p=document.getElementsByName("formbean.aqty");
	var q=document.getElementsByName("formbean.purate");
	var cal=0;
	for(var i=0;i<p.length;i++)
	{
		cal=Number(p[i].value)*Number(q[i].value);
		//alert(cal);
		document.getElementsByName("formbean.amounta")[i].value=cal.toFixed(2);
	}
	//document.getElementsByName("formbean.amounta")
}
function calamount123()
{
	var p=document.getElementsByClassName("aqty");
	var q=document.getElementsByClassName("purate");
	var cal=0;
	for(var i=0;i<p.length;i++)
	{
		cal=Number(p[i].value)*Number(q[i].value);
		document.getElementsByClassName("amounta")[i].value=cal.toFixed(2);
	}
}
function format()
{
	var pp=document.getElementsByName("formbean.expdate");
	for(var i=0;i<pp.length;i++)
	{
		var r=pp[i].value.replace("/","");
		var x=r.substring(2,r.length);
		var y=r.substring(0,2);
		pp[i].value=y+"/"+x;
	}
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
<li><a href="#">System Settings</a></li>
<li>Material Master</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>

  <s:form action="materialcreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>  
	 <input type="text" name="formbean.matcode" value="<s:property value="formbean.matcode"/>"/> 
    <div id="popup" style="display:none;">
  <div align="right">
  	<img id="image" src="Image/popupclose.png" height="2%" width="2%" onclick="closepopup();"></img>
  </div>
  <table border="0">
  	<tr>
  		<td colspan="">Please Fill-Up Batch No Wise Quantity And Rate</td>
  	</tr>
  </table>
  <hr width="100%"/>
  <div style="top:350px;bottom:155px;overflow-y:auto;width:1140px;padding:10px;height:250px;" align="center">
  <table id="table1" border="0" width="100%">
  		<tr>
  			<th></th>
	  		<th>Batch No.</th>
	  		<th>Exp.Dt.</th>
	  		<th>A. Qty.</th>
	  		<th>F. Qty</th>
	  		<th>Pu.Rate</th>
	  		<th>St.Rate</th>
	  		<th>Rt.Rate</th>
	  		<th>MRPrice</th>
	  		<th>Amount</th>
  		</tr>
  		<s:if test="%{formbean==null}">
  		<tr>
  			<td><input type="checkbox"></input></td>
	  		<td><div align="center"><s:textfield name="formbean.batchno"  id="batchno" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.expdate"  id="expdate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onblur="format();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.aqty"  id="aqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="calaqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.fqty"  id="fqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="calfqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.purate"  id="purate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="calamount();caltotal();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.strate"  id="strate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rtrate"  id="rtrate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.mrp"  id="mrp" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" ></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.amounta"  id="amount" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup=""></s:textfield></div></td>
  		</tr>
  		</s:if>
  		<s:else>
  		<%int i=0; %>
  		<s:iterator value="formbean.batchno" status="status" >
  		<tr>
  			<td><input type="checkbox"></input></td>
	  		<td><div align="center"><s:textfield name="formbean.batchno[%{#status.count-1}]"  cssClass="batchno" id="batchno" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield><input type="hidden" name="formbean.batchnohidden" class="batchnohidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.expdate[%{#status.count-1}]"  cssClass="expdate" id="expdate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield><input type="hidden" name="formbean.expdatehidden" class="expdatehidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.aqty[%{#status.count-1}]"   cssClass="aqty" id="aqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="calaqtya();"></s:textfield><input type="hidden" name="formbean.aqtyhidden" class="aqtyhidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.fqty[%{#status.count-1}]"  cssClass="fqty" id="fqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="calfqtya();"></s:textfield><input type="hidden" name="formbean.fqtyhidden" class="fqtyhidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.purate[%{#status.count-1}]"  cssClass="purate" id="purate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="calamount123();caltotal123();"></s:textfield><input type="hidden" name="formbean.puratehidden" class="puratehidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.strate[%{#status.count-1}]"  cssClass="strate" id="strate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield><input type="hidden" name="formbean.stratehidden" class="stratehidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rtrate[%{#status.count-1}]"  cssClass="rtrate" id="rtrate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield><input type="hidden" name="formbean.rtratehidden" class="rtratehidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.mrp[%{#status.count-1}]"  cssClass="mrp" id="mrp" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" ></s:textfield><input type="hidden" name="formbean.mrphidden" class="mrphidden"/></div></td>
	  		<td><div align="center"><s:textfield name="formbean.amounta[%{#status.count-1}]"  cssClass="amounta" id="amounta" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup=""></s:textfield><input type="hidden" name="formbean.amountahidden" class="amountahidden"/></div></td>
	  	</tr>
	  	<%i++; %>
	  	</s:iterator>
	  	</s:else>
  </table> 
  
  	<div align="right" style="width:95%;position:relative;padding:7px;">
        Total: <input type="text" name="formbean.total" id="total"/><br>
      	<input type="button" name="add" class="butStnd" value="Add Row"  onclick="addRow('table1');"></input>
      	<input type="button" name="delete" class="butStnd" value="Delete Row"  onclick="deleteRow('table1');"></input>
      	<input type="button" name="save" class="butStnd" value="Save"  onclick="copy();savepopup();"></input>
      </div>
  </div>
  </div>
    
  <fieldset style="width:59%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Material Master</h3></legend>

  <table cellpadding="5" width="70%" style="padding:20px">  
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Material&nbsp;Group</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.materialg" id="materialg" list="usList1"  listValue="materialg" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>On&nbsp;A/C&nbsp;Of</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.onac" id="onac" list="usList2"  listValue="onac" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>
        </tr>
   </table>

  <table id="table" border="0px" width="100%" cell-padding="0">  
	<tr bgcolor="#4292b2" style="color:white">
		<th  ><label>Material Description</label></th>
		<th  ><label>Packing</label></th>
		<th  ><label>Unit</label></th>
		<th  ><label>OP.ST(A)</label></th>	
		<th  ><label>OP.ST(F)</label></th>
		<th ><label>Details</label></th>
	</tr>
	
	<tr>
		<td width="6.5%" ><s:textfield name="formbean.materiald"  id="materiald" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:350px"></s:textfield></td>
		<td width="6.5%" ><s:textfield name="formbean.packing"  id="packing" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:125px"></s:textfield></td>
		<td width="6.5%" ><sj:autocompleter name="formbean.unit" id="unit" list="usList3"  listValue="unit"  size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:125px"></sj:autocompleter></td>
		<td width="6.5%" ><s:textfield name="formbean.sta"  id="sta" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:125px" readonly="true"></s:textfield></td>
		<td width="6.5%" ><s:textfield name="formbean.stf"  id="stf" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:125px" readonly="true"></s:textfield></td>
		<td width="9%" align="center"><input type="button" value="B. Detail" onclick="showDiv();" class="butStnd"/></td>
	</tr>
	</table>
  <table cellpadding="5" width="70%" style="padding:20px">  
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Rep.&nbsp;Rate</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.reprate"  id="reprate" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
     	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Discount&nbsp;@&nbsp;%</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.disc"  id="disc" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Mfg&nbsp;Code</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mfgcode"  id="mfgcode" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>
   </table>

  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="return Validate();" ></s:submit>
        
      </div>
 </s:form>  
 </fieldset> 
	
	<p>&nbsp;</p>
	<s:if test="usList">
	<div id="ram">
	<display:table id="table12"  name="usList" pagesize="25"  class="datatable" requestURI=""     export="true" style="width:100%;color:#000">
	    
	 <s:if test="%{#attr.table12.id == formbean.id}">
	
	<display:column property="materiald"   title="Description"  style="background-color:#ecf2f6;text-align:center"   sortable="false" headerClass="sortable"/>
	
	<display:column property="materialg"   title="Under Group" style="background-color:#ecf2f6;text-align:center"   sortable="false" headerClass="sortable" />

	<display:column property="onac"   title="On A/c" style="background-color:#ecf2f6;text-align:center"   sortable="false" headerClass="sortable" />
	
	<display:column property="sta"   title="Actual STock" style="background-color:#ecf2f6;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column property="stf"   title="Free STock" style="background-color:#ecf2f6;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column property="reprate"   title="Rep. Rate" style="background-color:#ecf2f6;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column property="disc"   title="Discount @ %" style="background-color:#ecf2f6;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="materialupdate" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="materialdelete" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	<s:else>
	<display:column property="materiald"   title="Description"  style="background-color:#fff;text-align:center"   sortable="false" headerClass="sortable"/>
	
	<display:column property="materialg"   title="Under Group" style="background-color:#fff;text-align:center"   sortable="false" headerClass="sortable" />

	<display:column property="onac"   title="On A/c" style="background-color:#fff;text-align:center"   sortable="false" headerClass="sortable" />
	
	<display:column property="sta"   title="Actual STock" style="background-color:#fff;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column property="stf"   title="Free STock" style="background-color:#fff;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column property="reprate"   title="Rep. Rate" style="background-color:#fff;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column property="disc"   title="Discount @ %" style="background-color:#fff;text-align:right"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="materialupdate" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="materialdelete" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
	</s:else> 
	   
    </display:table>
    </div>
	</s:if>
	
  <br/>
     
</center></body>
</html>
