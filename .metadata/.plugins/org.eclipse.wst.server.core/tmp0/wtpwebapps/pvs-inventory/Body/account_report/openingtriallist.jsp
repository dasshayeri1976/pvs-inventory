<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<script src="js/tableToExcel.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>


	<link rel="stylesheet" type="text/css" href="././css/jquery.dataTables.css">

	
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
<li >Opening Trial</li>
</ul>
</div>
<div style="position:fixed;top:150px;bottom: 45px;overflow-y:auto;width:100%" align="center">
<center>
<br/>
<h3><p style="color:red;">Opening Trial Display</p></h3>
<br> 
  
  <s:if test="usList">
<display:table id="table" name="usList" pagesize="100" requestURI=""  class="imagetable"  defaultorder="ascending"  export="true" style="width:90%">
	
	<display:column property="particular"   title="Particular"     sortable="false" headerClass="sortable"/>
	
	<display:column property="grouphead"   title="Group Head"    sortable="false" headerClass="sortable" />
	
	<display:column property="openingbal"   title="Prev Yr Bal"   style="text-align:right"  sortable="false" headerClass="sortable" />
		
	<display:column property="debitamt"   title="Debited Amount"  style="text-align:right"   sortable="false" headerClass="sortable"/>
	
	<display:column property="creditamt"   title="Credited Amount"  style="text-align:right"  sortable="false" headerClass="sortable" />
			
	</display:table>
	
</s:if>
   
</center>
</div>
</body>
</html>