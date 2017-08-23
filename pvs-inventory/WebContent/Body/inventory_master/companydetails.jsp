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
	    $easy1('#table').DataTable( {
	       
	    	 "scrollX": true,
	        paging:  false,
	        ordering: false,       
	    } );
	} );
 </script>
<%
String val=(String)session.getAttribute("count");
%>
<script>
function gets()
{	
	document.getElementById("getsession").value="<%= val%>";
}
</script>
<script>
$(document).keypress(function(e) {
	var x;
	var test;
	if(e.which)
	{
		x=e.which;
	}
	  if(e.altKey)
		{
		  if(String.fromCharCode(x)=="m")
			{
			  	var ui=document.getElementById("getsession").value; 
				if(ui=="cashpurchase")
				{
					window.location.href="cashpurchaselist";
				}
				else if(ui=="cashsales")
				{
					window.location.href="cashsaleslist";
				}
				else if(ui=="purchase")
				{
					window.location.href="purchaselist";
				}
				else if(ui=="creditnote")
				{
					window.location.href="creditnotelist";
				}
				else if(ui=="debitnote")
				{
					window.location.href="debitnotelist";
				}
				else if(ui=="sales")
				{
					window.location.href="saleslist";
				}
				else if(ui=="journal")
				{
					window.location.href="journallist";
				}
				else if(ui=="contra")
				{
					window.location.href="contralist";
				}
				else if(ui=="payment")
				{
					window.location.href="paymentlist";
				}
				else if(ui=="receipt")
				{
					window.location.href="receiptlist";
				}
			}
		}
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
	function checkName() {
		//alert(a);
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp001 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp001 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp001 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("name").value;
		//alert('S1: '+s1);
		//var s = document.getElementById("section").value;
		//var s = document.getElementById("source").value;
		//document.getElementById("newspaperadd").value = s;
		var url = "./Body/master/checkname.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		xmlHttp001.onreadystatechange = codeAdd03;
		xmlHttp001.open("GET", url, true);
		xmlHttp001.send(null);
		
	};

	function codeAdd03() {
		if (xmlHttp001.readyState == 4 || xmlHttp001.readyState == "complete") 
		{

			
			var x1=xmlHttp001.responseText;
			//alert(x);
			if(x1==1)
			{
			xm=0;
			alert("Please Register Your Name First");
			document.getElementById("name").value='';
			document.getElementById("name").focus();
			}

		}
	};
</script>
<script>
function disp()
{
	var x=document.getElementById("classy").value;
	//alert(x);
	if(x=="")
	{
		document.getElementById("for_asset_lia").style.display="none";
		document.getElementById("for_in_ex").style.display="none";
		document.getElementById("det").innerHTML="In_Balance_Sheet";
	}
	if(x=="A")
	{
		document.getElementById("for_asset_lia").style.display="block";
		document.getElementById("cat").value="Balance Sheet";
		document.getElementById("for_in_ex").style.display="none";
		document.getElementById("det").innerHTML="For_Assets";
	}
	if(x=="L")
	{
		document.getElementById("for_asset_lia").style.display="block";
		document.getElementById("cat").value="Balance Sheet";
		document.getElementById("for_in_ex").style.display="none";
		document.getElementById("det").innerHTML="For_Liability";
	}
	if(x=="I")
	{
		document.getElementById("for_in_ex").style.display="block";
		document.getElementById("for_asset_lia").style.display="none";
		document.getElementById("det").innerHTML="For_Income_Account";
	}
	if(x=="E")
	{
		document.getElementById("for_in_ex").style.display="block";
		document.getElementById("for_asset_lia").style.display="none";
		document.getElementById("det").innerHTML="For_Expenditure_Account";
	}
}
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

<body>
<center>

<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li>Company Details</li>
</ul>
<s:if test="usList">
	<div id="ram">
	<display:table id="table1"  name="usList" pagesize="200"  class="imagetable" requestURI=""     export="true" style="width:60%;color:#000">
	    
	 <s:if test="%{#attr.table1.id == formbean.id}">
	 
	
	<display:column property="companycode"   title="Company Code " style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="companyname"   title="Company Name"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	<display:column property="city"   title="Head Office " style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="city1"   title="Depo Office"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	
	<display:column property="city2"   title="Branch Office"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="phno"   title="Contact Person"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="companyupdate" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="companydelete" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	
	
	
	
	<s:else>
	<display:column property="companycode"   title="Company Code" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="companyname"   title="Company Name"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="city"   title="Head Office" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="city1"   title="Depo Ofice"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="city2"   title="Breanch Office" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="phno"   title="Contact Person"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="companyupdate" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="companydelete" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
	</s:else> 
	   
    </display:table>
      </div>
	</s:if>
	
	  <a href="<s:url action="companylist" namespace="/" ></s:url>" style="color: #fff;text-decoration:none;font-size:10px;" class="print" >Company&nbsp;Master</a>
</body>
</html>