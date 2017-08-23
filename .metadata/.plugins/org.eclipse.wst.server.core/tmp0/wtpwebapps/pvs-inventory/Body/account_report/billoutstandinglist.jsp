<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Outstanding</title>
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
<li >Outstanding Bill</li>
</ul>
</div>
<input type="hidden" id="value1" name="formbean.value1" />

<center>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<fieldset style="width:55%; border:solid thin #c6d5e1;Padding:5px;" align="center">
  <legend style="color:red;"><h3>Bill Outstanding</h3></legend>
  
  <s:form action="billoutstandinglistdetails" namespace="/" method="post" autocomplete="off">
  
  
  <table style="width:100%" style="padding:10px;" align="center">
	
	<tr>
      	
      <td width="12.5%" style="padding-left:15px; padding-right:0px;">Choose&nbsp;Account&nbsp;Name</td>
        <td width="12.5%" style="padding-left:0px; padding-right:15px;">
	    <s:select name="formbean.acname" list="usList1" id="acname" listKey="acname" value="formbean.acname" listValue="acname" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;border:0px solid" onchange="" tabindex="2"/>
	    </td>
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
  
  
  <s:if test="usList">
<display:table id="table"  name="usList" pagesize="25"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Bill Outstanding As On <br/>
	<s:property value="%{formbean.asondate}"/>
	</display:caption>

		
	
	<display:column property="date1"   title="Date"     sortable="false" headerClass="sortable"/>
	
	
	<display:column property="particulars"   title="Particulars"     sortable="false" headerClass="sortable"/>
	
	<display:column property="grossamt"   title="Gross Amount"     sortable="false" headerClass="sortable"/>
		
	<display:column property="amtadjusted"   title="Amount Adjusted"     sortable="false" headerClass="sortable"/>
	
	<display:column property="amtbalance"   title="Amount Balance"    sortable="false" headerClass="sortable" />
	
	<display:column property="age"   title="Age"    sortable="false" headerClass="sortable" />
	
	
	
	</display:table>
	
	 
</s:if>

 
</center>
</div>
</body>
</html>