<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daily Cash Balance Display</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<script src="js/tableToExcel.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>


	<link rel="stylesheet" type="text/css" href="././css/jquery.dataTables.css">
<script>
	$(document).ready(function(){
		var dated=document.getElementById("frmdate").value;
		var dated2=document.getElementById("todate").value;
	
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
</head>
<body>

<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Daily Cash</li>
</ul>
</div>

<center>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:80%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Daily Cash Balance Display</h3></legend>
  
  <s:form action="cashlistdetails" namespace="/" method="post" autocomplete="off">
  
  
  <table style="width:100%" style="padding:10px;" align="center">
	
	 <tr>
      	
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;">From Date</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:datepicker name="formbean.frmdate" id="frmdate" timepicker="false" timepickerFormat="hh:mm"  displayFormat="yy-mm-dd" buttonImageOnly="true"  showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
        
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">To Date</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:datepicker name="formbean.todate" id="todate" timepicker="false" timepickerFormat="hh:mm" buttonImageOnly="true"  displayFormat="yy-mm-dd" showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
              
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">On Account</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.part1" list="usList2" id="part1" listKey="part1" value="formbean.part1" listValue="part1" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;border:0px solid" onchange="ccode1();showdrawn();" tabindex="2"> </s:select> </td>      
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
  
  <s:if test="usList">
<display:table id="table"  name="usList" pagesize="20"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	 Daily Cash balance Report<br/>
	 on <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>
	
	<display:caption media="excel pdf rtf csv" style="color:red; font-weight:bold; padding-bottom:10px;">
	 Daily Cash Balance Report
	 on <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>

	<display:column property="dated"   title="Dated"     sortable="false" headerClass="sortable"/>
	
	<display:column property="opening_bal"   title="Opening Balance"     sortable="false" headerClass="sortable"/>
		
	<display:column property="amount_debited"   title="Amount Debited"     sortable="false" headerClass="sortable"/>
	
	<display:column property="amount_credited"   title="Amount Credited"    sortable="false" headerClass="sortable" />
	
	<display:column property="closing_balance"   title="Closing Balance"    sortable="false" headerClass="sortable" />

	</display:table>
</s:if>
   
</center>
</div>
</body>
</html>