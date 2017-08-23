<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.connection.account.ConnectionDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script language="javascript" type="text/javascript" src="js/tablefilter.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="./css/draftbutton.css" />
<link rel="stylesheet" href="./css/printbutton.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>

<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/>
<script src="//code.jquery.com/jquery-1.12.4.js"></script> 
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
		var $easy1 = $.noConflict(true);
	</script>
<script>
 $(document).ready(function() {
	   
	 $("#ram").css({ 'display': "block" });
	    $easy1('#table1').DataTable( {
	       
	    	 "scrollX": true,
	        paging:  false,
	        ordering: false,       
	    } );
	} );
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

<script language="Javascript">
	
	var xm=10;
	
	function Validate() {
		var a = document.getElementById('name');
		var b = document.getElementById('classy');
		var c = document.getElementById('p_text');
		var d = document.getElementById('sc_name');
		//var e = document.getElementById('status');

		if ((a.value == null) || (a.value == "")) 
		{
			alert("Please Enter Name");
			a.focus();
			return false;
		}
		else
		{
			if(xm==0)
			{
				alert('Avi');
				a.focus();
				return false;
			}
		}	
		if ((b.value == null) || (b.value == "")) {
			
			alert("Please Enter UserName");
			
			b.focus();
			return false;
		}
		
		
		if ((c.value == null) || (c.value == ""))
		{
			alert("Please Enter Password");
			c.focus();
			return false;
		}
		
		if ((d.value == null) || (d.value == "")) {
			alert("Please Enter the Roll");
			d.focus();
			return false;
		}

		if ((e.value == null) || (e.value == "")) {
			alert("Please Enter Status");
			e.focus();
			return false;
		}
		return true;
	}
</script>

<script type="text/javascript">


function confirmation()
{
	var r = confirm("Are You sure to delete this client record");
	var x='';
	if (r == true) 
	{
	    x = true;
	} 
	else 
	{
	    x = false;
	} 
	return x;
}
</script>

<script language="javascript" type="text/javascript">
	function checkname() 
	{
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp001 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp001 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp001 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("serial").value;
		var url = "./Body/inventory_master/checksr.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		xmlHttp001.onreadystatechange = codeAdd03;
		xmlHttp001.open("GET", url, true);
		xmlHttp001.send(null);
	};
	function codeAdd03() 
	{
		if (xmlHttp001.readyState == 4 || xmlHttp001.readyState == "complete") 
		{
			var x1=xmlHttp001.responseText;
			var ar=x1.trim().split("con");
			if(ar[1]=="1")
			{
				document.getElementById("error").innerHTML=ar[0]+" already exist";
				document.getElementById("serial").value="";
				document.getElementById("serial").focus();
			}
			else
			{
				document.getElementById("error").innerHTML="";
			}
		}
	};
</script>
<script>

</script>
<sj:head/>


<link rel="stylesheet" type="text/css" href="./css/easyui.css"/>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>

<style>
#ui-datepicker-div {background:#dce6ee;}

#ui-datepicker-div .ui-state-highlight {color: #dce6ee;}

#ui-datepicker-div.ui-datepicker-control {background: blue;}


.ui-dialog-titlebar{ 
    background: #FFCC66 repeat-x;
    color:#fff;      
}
</style>

</head>

<body onload="disp();"><center>

<div>
<ul id="breadcrumbs">
<li><a href="#">System Settings</a></li>
<li>Medical Representative</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
    
  <fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Medical Representative</h3></legend>
  
  <s:form action="mrcreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
  
  <table cellpadding="5" width="70%" style="padding:20px" border="0">  
 
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Description</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.desc1"  id="desc1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Short&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sname"  id="sname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	
       		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Print&nbsp;Serial</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.serial"  id="serial" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onblur="checkname();"></s:textfield></td>
       	</tr>
       	<tr>
       		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Area&nbsp;Sales&nbsp;Man</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.salesman" id="salesman" list="usList1"  listValue="salesman" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:200px" forceValidOption="false"></sj:autocompleter></td>
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Company</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.company" id="company" list="usList2"  listValue="company" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:200px" forceValidOption="false"></sj:autocompleter></td>
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><span id="error" style="color:red"></span></td>
        </tr>
   </table>
  
   	  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="return Validate();" ></s:submit>
        
      </div>

    </s:form>
  </fieldset>
	
	<p>&nbsp;</p>
	<s:if test="usList">
	<div id="ram">
	<display:table id="table1"  name="usList" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:85%;color:#000">
	    
	<s:if test="%{#attr.table1.id == formbean.id}">
	
	<display:column property="desc1"   title="Description" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="shortname"   title="Short Name"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="smcode"   title="Sales manager" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />

	<display:column property="company"   title="Company" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="mrupdate" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="mrdelete" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	
	<s:else>
	<display:column property="desc1"   title="Description" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="shortname"   title="Short Name"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="smcode"   title="Sales manager" style="background-color:#fff;"   sortable="false" headerClass="sortable" />

	<display:column property="company"   title="Company" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="mrupdate" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="mrdelete" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
	</s:else> 
	   
    </display:table>
    </div>
	</s:if>
	
  <br/>

    <!--<script language="javascript" type="text/javascript">
//<![CDATA[
	setFilterGrid("table");
//]]>
</script>-->

</center></body>
</html>
