<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monthly Breakup Of Party Ledger</title>
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
	border-top:1px solid #c6d5e1;
	border-bottom:1px solid #c6d5e1;
	border-right:1px solid #c6d5e1;
	border-left:1px solid #c6d5e1;
	border-style: solid;
	background-color: #ffffff;
	
	
}


</style>
</head>
<body>
<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Party Ledger</li>
</ul>
</div>
	<input type="hidden" id="value1" name="formbean.value1" />

<center>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:85%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Monthly Breakup Of Party Ledger</h3></legend>
  
  <s:form action="partyledgerlistdetails" namespace="/" method="post" autocomplete="off">
  
  
  <table style="width:100%" style="padding:10px;" align="center" border="0">
	
	 <tr>
      	
      	<td width="12.5%" align="center" style="padding-left:15px; padding-right:15px;">From Date</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:datepicker name="formbean.frmdate" id="frmdate" timepicker="false" timepickerFormat="hh:mm"  displayFormat="yy-mm-dd" buttonImageOnly="true"  showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
        
        <td width="12.5%" align="center" style="padding-left:15px; padding-right:15px;">To Date</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:datepicker name="formbean.todate" id="todate" timepicker="false" timepickerFormat="hh:mm" buttonImageOnly="true"  displayFormat="yy-mm-dd" showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
              
        <td width="12.5%" style="padding-left:15px; padding-right:0px;">Choose&nbsp;Account&nbsp;Name</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:autocompleter name="formbean.acname" id="acname" list="usList"  listValue="acname" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></sj:autocompleter></td>
	  </tr>
     <tr>
      	
      	 <td width="12.5%" style="padding-left:50px; padding-right:0px;">Long&nbsp;Narration</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><s:select name="formbean.longn" id="longn" label="" headerKey="-1" headerValue="" list="#{'With_Narration':'With Narration', 'Without_Narration':'Without Narration'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" /></td>
	          
        <td width="12.5%" style="padding-left:50px; padding-right:0px;">Short&nbsp;Narration</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><s:select name="formbean.shortn" id="shortn" label="" headerKey="-1" headerValue="" list="#{'With_Narration':'With Narration', 'Without_Narration':'Without Narration'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" /></td>
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
  
  
<s:if test="usList1">
<display:table id="table"  name="usList1" pagesize="10000"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Monthly Breakup Of Party Ledger<br/>
	 <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>
	
	<display:caption media="excel pdf rtf csv" style="color:red; font-weight:bold; padding-bottom:10px;">
	  Monthly Breakup Of Party Ledger
	 <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>

	<display:column title="Month"  style="background-color:#fff;"  sortable="false" headerClass="sortable">
	
    <a href=" <s:url action="monthreport" namespace="/" ><s:param  name="month" value="%{#attr.table.month}"></s:param><s:param  name="accid" value="%{#attr.table.accid}"></s:param><s:param  name="shortn" value="%{#attr.table.shortn}"></s:param><s:param  name="longn" value="%{#attr.table.longn}"></s:param></s:url>" style="color:red;text-decoration:none;"><s:property value="%{#attr.table.month}"/></a>

</display:column>

	<display:column property="nv"   title="No. of Voucher"     sortable="false" headerClass="sortable"/>
	
	<display:column property="opening_bal"   title="Opening Balance"     sortable="false" headerClass="sortable"/>
		
	<display:column property="debitamt"   title="Debit Amount"     sortable="false" headerClass="sortable"/>
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="closing_balance"   title="Closing Balance"    sortable="false" headerClass="sortable" />
	</display:table> 
</s:if>
<s:else>
<display:table id="table"  name="usList2" pagesize="10000"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Daily Breakup Of Party Ledger<br/>
	 <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>
	
	<display:caption media="excel pdf rtf csv" style="color:red; font-weight:bold; padding-bottom:10px;">
	  Daily Breakup Of Party Ledger
	<s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>
	<display:column property="date"   title="Date"     sortable="false" headerClass="sortable"/>
	
	<display:column property="type"   title="Type "     sortable="false" headerClass="sortable"/>
	
	<display:column property="vno"   title="Voucher No"     sortable="false" headerClass="sortable"/>
		
	<display:column property="refno"   title="Reference No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="refdate"   title="Reference Date"    sortable="false" headerClass="sortable" />
	
	<display:column property="debitamt"   title="Debit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	</display:table>
</s:else>
</center>
</div>
</body>
</html>