<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.connection.account.ConnectionDAO"%>
<%@ page import="java.sql.*"%> 
<%@ page import="java.util.*"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="./css/draftbutton.css" />
<link rel="stylesheet" href="./css/printbutton.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/>
<script src="//code.jquery.com/jquery-1.12.4.js"></script> 
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Waiting.....</title>
</head>
<script>
function validate()
{
	var a=document.getElementById("company").value;
	var b=document.getElementById("finyear").value;
	if(a=="" || b=="")
	{
		alert("Selection Blank");
		return false;
	}
	else 
	{
		return true;
	}
}
</script>
<style>

</style>
</head>
<body>
<center>
<div style="height:125px;margin-top:230px;background">
<fieldset style="width:40%; border:solid thin #c6d5e1;Padding:5px;background-color:cornsilk">
  <legend style="color:red;"><font face="courier new" size="4"><h4>Company And Financial Year Selection</h4></font></legend>
  
 <s:form action="load" namespace="/" method="post" autocomplete="off">
	<table border="0" width="80%">
	<tr>
		<td width="12.5%" style="padding-right:5px">Select&nbsp;Company:&nbsp;</td>
		<td width="12.5%" style="padding-right:5px"><s:select name="formbean.company" list="usList" id="company" listKey="company" value="formbean.company" listValue="company" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:270px;" tabindex="2"/></td>
	<tr>
	<tr>
		<td width="12.5%" style="padding-right:5px">Select&nbsp;Financial:&nbsp;Year:&nbsp;</td>
		<td width="12.5%" style="padding-right:5px"><s:select name="formbean.finyear" list="usList" id="finyear" listKey="finyear" value="formbean.finyear" listValue="finyear" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:140px;" tabindex="2"/></td>
	</tr>
	</table>
       <div align="right" style="width:99%;position:relative;  padding:2px;">
      	<s:submit name="formbean.save" value="Open" cssClass="butStnd" onclick="return validate();" ></s:submit>
      </div>
 </s:form>
 </fieldset>
 </div>

</center>
</body>
</html>