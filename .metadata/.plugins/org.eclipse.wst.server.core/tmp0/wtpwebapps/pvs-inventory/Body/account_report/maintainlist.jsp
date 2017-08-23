<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maintain Voucher Transaction</title>
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

<script type="text/javascript">
	function displayAuto()
	{
		var comboValue = document.getElementById("choice").value;
		
		if(comboValue=="Ac")
			{
				document.getElementById("bollo").style.display="block";
				document.getElementById("hello").style.display="block";
			}
		else
			{
				document.getElementById("bollo").style.display="none";
				document.getElementById("hello").style.display="none";
			}
	}
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
table tbody tr td:nth-child(n+5) {text-align: right;}



</style>

</head>
<body>
<center>

			<div>
<ul id="breadcrumbs">
<li><a href="#">System Settings</a></li>
<li>Maintain Voucher Transaction</li>
</ul>
</div>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:80%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Maintain Voucher Transaction</h3></legend>
  
  
  <s:form action="maintainlistdetails" namespace="/" method="post">
  
  <table style="width:100%" style="padding:10px;" align="center" border="0">
	
	 <tr>
      	
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;">From Date</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:datepicker name="formbean.frmdate" id="frmdate" timepicker="false" timepickerFormat="hh:mm"  displayFormat="yy-mm-dd" buttonImageOnly="true"  showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
        
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">To Date</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:datepicker name="formbean.todate" id="todate" timepicker="false" timepickerFormat="hh:mm" buttonImageOnly="true"  displayFormat="yy-mm-dd" showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
       
	     </tr>  
	     <tr>
      	
      	 <td width="12.5%" style="padding-left:15px; padding-right:0px;">Choose&nbsp;Voucher&nbsp;Type</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.vtyp" id="vtyp" label="" headerKey="-1" headerValue="" list="#{'RC':'Cash Receipt', 'RB':'Bank Receipt', 'CO':'Contra', 'JU':'Journal', 'PB':'Bank Payment', 'PC':'Cash Payment', 'DN':'Debit Note', 'CN':'Credit Note', 'SD':'Credit Sales', 'SC':'Cash Sales','All':'All'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" /></td>
	          
        <td width="12.5%" style="padding-left:15px; padding-right:0px;">Your&nbsp;Choice</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.choice" id="choice" label="" headerKey="-1" headerValue="" list="#{'All':'All Together Voucher', 'Ac':'Account Wise Voucher'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" onchange="displayAuto();" /></td>
	    
	    <td width="12.5%" style="padding-left:15px; padding-right:0px;"><div id="bollo" style="display:none">Choose&nbsp;Account&nbsp;Name</div></td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><div id="hello" style="display:none"><sj:autocompleter name="formbean.acname" id="acname" list="usList"  listValue="acname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;" forceValidOption="false"></sj:autocompleter></div></td>
	   
	    
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
  
  <s:if test="usList1">
<display:table id="table"  name="usList1" pagesize="50"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:65%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	 Maintain Voucher Transaction<br/>
	 on <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>
	
	<display:caption media="excel pdf rtf csv" style="color:red; font-weight:bold; padding-bottom:10px;">
	 Maintain Voucher Transaction
	 on <s:property value="%{formbean.frmdate}"/> to <s:property value="%{formbean.todate}"/> 
	</display:caption>

	<display:column property="date" title="Entry Date" sortable="false" headerClass="sortable">
	<a href="<s:url action="" namespace="/" ><s:param  name="date" value="%{#attr.table.date}"></s:param><s:param  name="ledger" value="%{#attr.table.ledger}"></s:param></s:url>" style="color:  red;text-decoration:none;"><s:property value="%{#attr.table.date}"/></a>
	</display:column>
	
	<display:column property="type"   title="Type"     sortable="false" headerClass="sortable"/>
		
	<display:column property="vno"   title="V.No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="achead"   title="First Account Head"    sortable="false" headerClass="sortable" />
	
	<display:column property="amount"   title="Transaction Amount"    sortable="false" headerClass="sortable" />
	
	</display:table>
	
</s:if>
   
</center>
</div>
</body>
</html>