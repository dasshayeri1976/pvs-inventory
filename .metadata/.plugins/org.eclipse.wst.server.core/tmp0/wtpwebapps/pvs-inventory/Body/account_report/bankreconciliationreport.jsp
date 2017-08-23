<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cash Book Display</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<script src="js/tableToExcel.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>
	<link rel="stylesheet" type="text/css" href="././css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" media="all" href="./Body/fordatepick/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="./Body/fordatepick/jsDatePick.min.1.3.js"></script>


<script>
$(document).ready(function()
		{
		var j=document.getElementsByName("date1");
		//alert(j.length);
		for(var i=0;i<j.length;i++)
		{
			new JsDatePick
			({
				useMode:2,
				target:attr('date1'),
				dateFormat:"%Y-%m-%d"
			}); 
		}
		});
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
</style>
<script>
function hi()
{
	
	var amou=document.getElementById("amou").value;
	alert(amou);
	if(amou=="")
	{
		alert();
		document.getElementById("no").style.display="block";
		document.getElementById("yes").style.display="none";
	}
	
}
var rowIndex,rowIndex1;
function PersonViewModel(x)
{
	rowIndex=$(x).closest('tr').index();
	//alert(rowIndex);
}
function PersonViewModel1(x)
{
	rowIndex1=$(x).closest('tr').index();
	//alert(rowIndex);
}
function savedate()
{
	
	var lc=rowIndex;
	var x=document.getElementsByName("vou");
	var y=document.getElementsByName("date1");
	//alert(x[lc].value+" "+y[lc].value);
	
	var xyz=x[lc].value+"con"+y[lc].value;
	
	if (typeof XMLHttpRequest != "undefined") 
	{
		save = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		save = new ActiveXObject("Microsoft.XMLHTTP");	
	}
	if (save == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	
	var url = "./Body/transaction/savedate.jsp";
	url += "?count=" + xyz;
	
	save.onreadystatechange = codesave;
	save.open("GET", url, true);
	save.send(null);
}
function codesave() 
{
	if (save.readyState == 4 || save.readyState == "complete") 
	{
		var xyzz=save.responseText;
		var a=document.getElementsByName("vou");
		var b=document.getElementsByName("date1");
		var c=document.getElementsByName("save");
		var d=document.getElementsByName("modify");
		var e=document.getElementsByName("clea");
		
		a[rowIndex].style.display="none";
		b[rowIndex].style.display="none";
		c[rowIndex].style.display="none";
		d[rowIndex].style.display="block";
		e[rowIndex].style.display="block"
		
		e[rowIndex].value=xyzz;
	}
}
function modify()
{
	var lc1=rowIndex1;
	//alert(lc1);
	var a=document.getElementsByName("vou");
	var b=document.getElementsByName("date1");
	var c=document.getElementsByName("save");
	var d=document.getElementsByName("modify");
	var e=document.getElementsByName("clea");
	
	//a[lc1].style.display="block";
	b[lc1].style.display="block";
	b[lc1].value=e[lc1].value;
	c[lc1].style.display="block";
	d[lc1].style.display="none";
	e[lc1].style.display="none";
}
</script>
</head>
<body onload="">
<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Bank Reconciliation Report</li>
</ul>
</div>
<center>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:85%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Reconciliation Report</h3></legend>
  
  <s:form action="bankreconsearch" namespace="/" method="post" autocomplete="off">
  
  
  <table style="width:100%; padding:0px;" align="center" border="0">
	 <tr>
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;">From Date</td>
        <td width="18%" style="padding-left:15px; padding-right:15px;"><sj:datepicker name="formbean.frmdate" id="frmdate" timepicker="false" timepickerFormat="hh:mm"  displayFormat="yy-mm-dd" buttonImageOnly="true"  showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
        
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">To Date</td>
        <td width="18%" style="padding-left:15px; padding-right:15px;"><sj:datepicker name="formbean.todate" id="todate" timepicker="false" timepickerFormat="hh:mm" buttonImageOnly="true"  displayFormat="yy-mm-dd" showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
              
        <td width="12.5%" style="padding-left:15px; padding-right:0px;">Bank&nbsp;Account</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:autocompleter name="formbean.accname" id="accname" list="usList"  listValue="accname" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px" forceValidOption="false"></sj:autocompleter></td>       
	  </tr>
  	  <tr>
  	    <td width="18%" style="padding-left:15px; padding-right:15px;">Choose Cheque Case</td>
        <td width="18%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.case1" id="case1" list="#{'':'-Select-', 'withopeningcheque':'With Opening Cheque', 'withoutopeningcheque':'Without Opening Cheque', 'openingcheque':'Opening Cheque'}" cssStyle=" border:1px solid #ccc;height:25px;background:#FFFF99;width:140px;"></s:select></td>
        
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">Choose Type</td>
        <td width="18%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.type" id="type" list="#{'':'-Select-', 'dr':'Debited', 'cr':'Credited'}" cssStyle=" border:1px solid #ccc;height:25px;background:#FFFF99;width:140px;"></s:select></td>
  	  </tr>
    </table>
    <br/>
   	  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;">
      </div>
      <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.search" value="Search" cssClass="butStnd" onclick="return Validate();" ></s:submit>
        
      </div>
      
    </s:form>
  </fieldset>
	<br>
	<p>&nbsp;</p>
	<s:if test="usList1">
	<display:table id="table"  name="usList1" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:70%;color:#000">	    
	
	<display:column property="entry" title="Entry Date"  style="background-color:#fff;"  sortable="false" headerClass="sortable"/>
    
    <display:column property="vtype1"   title="Voucher Type"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
	 
    <display:column property="vno"   title="Voucher No"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
	
	<display:column property="chedd"   title="Cheque/DD No" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="chedddate"   title="Date" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="amount"   title="Amount" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="clearedon"   title="Cleared On" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
 
    </display:table>
 </s:if>
</center>
</div>
</body>
</html>