<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Party Ledger</title>
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
<center>

  
  
  <s:if test="usList1">
<display:table id="table"  name="usList1" pagesize="20"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Party Ledger For the Month of <s:property value="%{formbean.month}"/> and ledger <s:property value="%{formbean.accid}"/>
	</display:caption>
	
	<display:column property="date"   title="Date"     sortable="false" headerClass="sortable"/>
	
	<display:column property="type"   title="Type "     sortable="false" headerClass="sortable"/>
	
	<display:column property="vno"   title="Voucher No"     sortable="false" headerClass="sortable"/>
		
	<display:column property="refno"   title="Reference No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="refdate"   title="Reference Date"    sortable="false" headerClass="sortable" />
	
	<display:column property="debitamt"   title="Debit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	
	
	</display:table>
	
	 
</s:if>

<s:if test="usList2">
<display:table id="table"  name="usList2" pagesize="20"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Party Ledger For the Month of <s:property value="%{formbean.month}"/> and ledger <s:property value="%{formbean.accid}"/>
	</display:caption>
	
	<display:column property="date"   title="Date"     sortable="false" headerClass="sortable"/>
	
	<display:column property="type"   title="Type "     sortable="false" headerClass="sortable"/>
	
	<display:column property="vno"   title="Voucher No"     sortable="false" headerClass="sortable"/>
		
	<display:column property="refno"   title="Reference No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="refdate"   title="Reference Date"    sortable="false" headerClass="sortable" />
	
	<display:column property="debitamt"   title="Debit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="shortn"   title="Short Narration"    sortable="false" headerClass="sortable" />
	
	
	</display:table>
	
	 
</s:if>

<s:if test="usList3">
<display:table id="table"  name="usList3" pagesize="20"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Party Ledger For the Month of <s:property value="%{formbean.month}"/> and ledger <s:property value="%{formbean.accid}"/>
	</display:caption>
	
	<display:column property="date"   title="Date"     sortable="false" headerClass="sortable"/>
	
	<display:column property="type"   title="Type "     sortable="false" headerClass="sortable"/>
	
	<display:column property="vno"   title="Voucher No"     sortable="false" headerClass="sortable"/>
		
	<display:column property="refno"   title="Reference No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="refdate"   title="Reference Date"    sortable="false" headerClass="sortable" />
	
	<display:column property="debitamt"   title="Debit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="longn"   title="Long Narration"    sortable="false" headerClass="sortable" />
	
	
	</display:table>
	
	 
</s:if>

<s:if test="usList4">
<display:table id="table"  name="usList4" pagesize="20"  class="imagetable" requestURI=""  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:caption media="html" style="color:red; font-weight:bold; padding-bottom:10px;">
	Party Ledger For the Month of <s:property value="%{formbean.month}"/> and ledger <s:property value="%{formbean.accid}"/>
	</display:caption>
	
	<display:column property="date"   title="Date"     sortable="false" headerClass="sortable"/>
	
	<display:column property="type"   title="Type "     sortable="false" headerClass="sortable"/>
	
	<display:column property="vno"   title="Voucher No"     sortable="false" headerClass="sortable"/>
		
	<display:column property="refno"   title="Reference No"     sortable="false" headerClass="sortable"/>
	
	<display:column property="refdate"   title="Reference Date"    sortable="false" headerClass="sortable" />
	
	<display:column property="debitamt"   title="Debit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="creditamt"   title="Credit Amount"    sortable="false" headerClass="sortable" />
	
	<display:column property="shortn"   title="Short Narration"    sortable="false" headerClass="sortable" />
	
	<display:column property="longn"   title="Long Narration"    sortable="false" headerClass="sortable" />
	
	
	</display:table>	 
</s:if>
</center>
</body>
</html>