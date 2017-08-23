<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Day Book</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<script src="js/tableToExcel.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>
<%String x=(String)session.getAttribute("date12"); 
//System.out.println("date got "+x);%>

	<link rel="stylesheet" type="text/css" href="././css/jquery.dataTables.css">
<script>
	$(document).ready(function(){
		//document.getElementById("date1").value="<%=x%>";
		var dated=document.getElementById("date").value;
	});
	function Validate()
	{
		var d=document.getElementById("date").value;
		if(d == null || d == "")
			{
			alert("Date field cant be empty");
			document.getElementById("date").focus();
			return false;
			}
		return true;
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
	border-top:0 solid #c6d5e1;
	border-bottom:0 solid #c6d5e1;
	border-right:1px solid #c6d5e1;
	border-left:1px solid #c6d5e1;
	border-style: solid;
	background-color: #ffffff;
	
	
}
table tbody tr td:nth-child(n+4) {text-align: right;}

</style>


</head>
<body>
<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Day Book</li>
</ul>
</div>
	<input type="hidden" id="value1" name="formbean.value1" />

<center>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:90%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Day Book</h3></legend>
  
  <s:form action="daybooklistdetails" namespace="/" method="post">
  
  
  <table style="width:100%" style="padding:10px;" align="center">
	
	<tr>
	
		<td width="12.5%" align="center" style="padding-left:15px; padding-right:0px;">Date</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><sj:datepicker name="formbean.date" id="date" timepicker="false" timepickerFormat="hh:mm"  displayFormat="yy-mm-dd" buttonImageOnly="true"  showButton="false" changeYear="true" changeMonth="true" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;"/></td>
     	 	 
      	<td width="12.5%" style="padding-left:15px; padding-right:0px;">Long&nbsp;Narration</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><s:select name="formbean.longn" id="longn" label="" headerKey="-1" headerValue="" list="#{'With_Narration':'With Narration', 'Without_Narration':'Without Narration'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" /></td>
	          
        <td width="12.5%" style="padding-left:15px; padding-right:0px;">Short&nbsp;Narration</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;"><s:select name="formbean.shortn" id="shortn" label="" headerKey="-1" headerValue="" list="#{'With_Narration':'With Narration', 'Without_Narration':'Without Narration'}" cssStyle="border:1px solid #ccc;height:25px;background:#FFFF99;width:120px;" /></td>  
	   
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
   <center>
  <b><font color="red">Day Book As On</font> <input type="text" name="formbean.date" id="date1" value="<%=x %>" style="width:72px;border:none;color:red" readonly></input></b><br/>
  </center>
<display:table id="table"  name="usList1" pagesize="10000"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:85%">
	
	<display:caption  style="color:red; font-weight:bold; padding-bottom:10px;">
	
	
	</display:caption>

		
	
	<display:column title="Date" property="date" style="background-color:#fff;"  sortable="false" headerClass="sortable" />
   	
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