<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Journal Register</title>
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
	
	
}
table.imagetable td {
	text-decoration:none;
	border-width: 1px;
	padding:4px 6px 6px;
	border-top:0 solid #c6d5e1;
	border-bottom:0 solid #c6d5e1;
	border-right:1px solid #c6d5e1;
	border-left:1px solid #c6d5e1;
	border-style: solid;
	background-color: #ffffff;
	
	
}
table tbody tr td:nth-child(n+4) {text-align: right;}

</style>
<script type="text/javascript">
	function displayAuto()
	{
		var comboValue = document.getElementById("type").value;
		
		if(comboValue=="Party")
			{
				document.getElementById("hello").style.display="block";
				document.getElementById("hello1").style.display="block";
			}
		else
			{
				document.getElementById("hello").style.display="none";
				document.getElementById("hello1").style.display="none";
			}
	}
</script>
</head>
<body onload="displayAuto();">
<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Journal Register</li>
</ul>
</div>
	<input type="hidden" id="value1" name="formbean.value1" />

<center>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:90%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Journal Register</h3></legend>
  
  <s:form action="journalregisterlistdetails" namespace="/" method="post">
  
  
  <table style="width:100%" style="padding:10px;" align="center">
	
	<tr>
	<td width="12.5%" align="center" style="padding-left:15px; padding-right:15px;">From Date</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:datepicker name="frmdate" id="frmdate" timepicker="false" timepickerFormat="hh:mm"  displayFormat="yy-mm-dd" buttonImageOnly="true"  showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
        
        <td width="12.5%" align="center" style="padding-left:15px; padding-right:15px;">To Date</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:datepicker name="todate" id="todate" timepicker="false" timepickerFormat="hh:mm" buttonImageOnly="true"  displayFormat="yy-mm-dd" showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>     
	
	 	<td width="12.5%" style="padding-left:15px; padding-right:0px;">Select&nbsp;Type</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><s:select name="type" id="type" list="#{ 'All':'All Together','Party':'Partywise'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" onchange="displayAuto();" /></td>
	         	
      	<td width="12.5%" style="padding-left:15px; padding-right:0px;"><div id="hello1" style="display:none">Choose&nbsp;Account&nbsp;Name</div></td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><div id="hello" style="display:none">
	    
			<s:select name="acname" list="usList" id="acname" listKey="acname" value="formbean.acname" listValue="acname" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;border:0px solid" onchange="showdrawn();" tabindex="0"> </s:select> </div> </td>
	 
</tr>
     
    </table>
    <br/>
   	  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;">
      </div>
      <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.search" value="Search" cssClass="butStnd" onclick="return Validate();"></s:submit>
        
      </div>
      
    </s:form>
  </fieldset>
  
  
  <s:if test="usList1">
<display:table id="table"  name="usList1" pagesize="10000"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:70%">
	
	<display:caption  style="color:red; font-weight:bold; padding-bottom:10px;">
	Journal Register As On <br/>
	<s:property value="%{formbean.asondate}"/>
	</display:caption>

		
	
	<display:column title="Date"  style="background-color:#fff;"  sortable="false" headerClass="sortable">
    <a href="<s:url action="journalreport" namespace="/" ><s:param  name="date" value="%{#attr.table.date}"></s:param><s:param  name="v" value="%{#attr.table.v}"></s:param></s:url>" style="color:red;text-decoration:none;"><s:property value="%{#attr.table.date}"/></a>
    </display:column>

	<display:column property="particulars"   title="Particulars"     sortable="false" headerClass="sortable"/>
	
	<display:column property="vtyp"   title="Voucher Type"     sortable="false" headerClass="sortable"/>
		
	<display:column property="vno"   title="Voucher No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="debitamt"   title="Debit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	
	</display:table>
</s:if>
</center>
</div>
</body>
</html>
