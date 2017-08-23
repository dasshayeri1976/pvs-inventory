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

<body><center>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li>CompanyMaster</li>
</ul>


<s:form action="companymastercreation" namespace="/" method="post" autocomplete="off">
<fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Company Master</h3></legend>
  
  
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
   <table cellpadding="5" width="70%" style="padding:20px">  
 
  		<tr>	
  		    <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Company&nbsp;Code</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.companycode"  id="companycode" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Company&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.companyname"  id="companyname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Short&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sname"  id="sname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	           	
        </tr>

        <tr>


            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>GSTIN&nbsp;NO</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.gstinno"  id="gstinno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>PAN&nbsp;NO</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.panno"  id="panno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>State&nbsp;Code</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.statecode"  id="statecode" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	           	
        </tr>
        
        <tr>
        
         <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>State&nbsp;Type</label></td>
         <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.sttype" id="sttype"  list="#{'InterState':'InterState', 'IntraState':'IntraState'}"	cssStyle="width:80px; border:1px solid #ccc" /></td>
        
        
        
        </tr>
        
        
</table>
 
</fieldset>
<br>

</br>

<fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Headoffice Details</h3></legend>
  
  
 
   <table cellpadding="5" width="70%" style="padding:20px">  
 
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Address&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textarea name="formbean.address"  id="address" rows="2" cols="22" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textarea></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Country&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.country"  id="country" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>


<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>City&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.city"  id="city" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Phone&nbsp;Number</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.phonenumber"  id="phonenumber" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>



<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>FAX&nbsp;No</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.faxno"  id="faxno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      </tr>




</table>


</fieldset>
<fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>DEPO OFFICE</h3></legend>
  
  
  
   <table cellpadding="5" width="70%" style="padding:20px">  
 
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Address&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textarea name="formbean.address1"  id="address1" rows="2" cols="22" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textarea></td>
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Country&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.country1"  id="country1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>


<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>City&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.city1"  id="city1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Phone&nbsp;Number</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.phonenumber1"  id="phonenumber1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>



<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>FAX&nbsp;No</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.faxno1"  id="faxno1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      </tr>


      </table>
      </fieldset>
      
      
      <fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>BRANCH OFFICE</h3></legend>
  
  
 
   <table cellpadding="5" width="70%" style="padding:20px">  
 
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Address&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textarea name="formbean.address2"  id="address2" rows="2" cols="22" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textarea></td>
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Country&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.country2"  id="country2" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>


<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>City&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.city2"  id="city2" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Phone&nbsp;Number</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.phonenumber2"  id="phonenumber2" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>



<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>FAX&nbsp;No</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.faxno2"  id="faxno2" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      </tr>


      </table>
      </fieldset>
      
         <fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>CONTACT PERSON</h3></legend>
  
  
 
   <table cellpadding="5" width="70%" style="padding:20px">  
 
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>To&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textarea name="formbean.to1"  id="to1" rows="2" cols="22" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textarea></td>
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Ph&nbsp;No</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.phno"  id="phno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>


<tr>	
      	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Mobile&nbsp;</label></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mobile"  id="mobile" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Email&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.email"  id="email" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>



	
      		


      </table>
      <div align="center" style="width:100%; position:static;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.save" value="Save Ledger" cssClass="butStnd" style="position:static" onclick="return Validate();" ></s:submit>
        
      </div> 
      
      </fieldset>  
      
      
      
      
      
      
      
      
      
      
      
      
</s:form>

</center></body>
</html>