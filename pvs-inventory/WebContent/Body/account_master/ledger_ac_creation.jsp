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
<title>Ledger Account Creation</title>
<script language="javascript" type="text/javascript" src="./js/tablefilter.js"></script>   
<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>
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
	   
	 $("#abc").css({ 'display': "block" });
	    $easy1('#table1').DataTable( {
	       
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
$(document).keypress(function(e) {
	var x;
	var test;
	if(e.which)
	{
		x=e.which;
	}
	  if(e.altKey)
		{
		  if(String.fromCharCode(x)=="c")
			{
			  	//alert();
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
				else if(ui=="purchaseentry")
				{
					window.location.href="purchaseentrylist";
				}
			}
		}
	});	
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script language="javascript" type="text/javascript">
	function ccode()
	{
		if (typeof XMLHttpRequest != "undefined") 
		{
			xmlHttp001 = new XMLHttpRequest();
		}
		else if (window.ActiveXObject) 
		{
			xmlHttp001 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp001 == null) 
		{
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("sname").value;//get subgroupname
		s1=s1.replace('&','*');
		var url = "./Body/account_master/checkname.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;

		xmlHttp001.onreadystatechange = codeAdd04;
		xmlHttp001.open("GET", url, true);
		xmlHttp001.send(null);
	}
	function codeAdd04() 
	{
		if (xmlHttp001.readyState == 4 || xmlHttp001.readyState == "complete") 
		{			
			var x1=xmlHttp001.responseText;
			document.getElementById("maingroup").value=x1;		
		}
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
	function copy()
	{
		var x=document.getElementById("opedc").value;
		if(x=="D")
			document.getElementById("predc").value="Dr";
		else if(x=="C")
			document.getElementById("predc").value="Cr";
		else
			document.getElementById("predc").value="";
		
	}
	$(document).ready(function()
	{
		$("#opebal").keyup(function()
		{
			$("#prebal").val($("#opebal").val());
		});
		$("#opebal").mouseenter(function()
		{
			$("#prebal").val($("#opebal").val());
		});
	});
</script>
<sj:head/>





<style>
#ui-datepicker-div {background:#dce6ee;}

#ui-datepicker-div .ui-state-highlight {color: #dce6ee;}

#ui-datepicker-div.ui-datepicker-control {background: blue;}


.ui-dialog-titlebar{ 
    background: #FFCC66 repeat-x;
    color:#fff;      
}
</style>




<script>
function showmail()
{
	var x=document.getElementById("sname").value;
	if(x=="SUNDRY DEBTORS" || x=="SUNDRY CREDITOR FOR EXPENSES" || x=="INTER OFFICE ACCOUNT")
	{
		document.getElementById("mail").style.display="block";
	}
	else
	{
		document.getElementById("mail").style.display="none";
		
	}
}
</script>
<script>
$(document).ready(function()
{
	$("#close").click(function()
	{
		hidepopup();
	});
	
	/*$("#abc").css({'display:"block"'});
	$easy1('#table').DataTable({
		scrollY:'55vh',
		"scrollX":true,
		paging:false,
		ordering:true,
	});*/
});

function hidepopup()
{
	var obala=document.getElementById("obalance").value;
	var tam=document.getElementById("tamount").value;
	//alert(obala+" "+tam);
	if(obala==tam)
	{	
		$("#popup").fadeOut();
		$("#popup").css({"visibility":"hidden","display":"none"});
	}
	else
	{
		alert("Amount Mismatch..");
	}
}

</script>
<script>
function showpopup(gendervalue)
{
	//alert(gendervalue);
	var gg=$("input[name='formbean.maintainbal']:checked").val();
	var ee=document.getElementById("sname").value;
	var ff=document.getElementById("opebal").value;
	var ii=document.getElementById("opedc").value;
	ee=ee.substring(0,3);
	//alert(gg);
	if(gg==1 && ee=="SUN" && ff!="" && ii!="")
	{
	 $("#popup").fadeIn();
	 $("#popup").css({"visibility":"visible","display":"block"});
	 document.getElementById("obalance").value=ff;
	 document.getElementById("dc").value=document.getElementById("opedc").value;
	 //document.getElementById("billwise").innerHTML=document.getElementById("name").value;
	}
	else
	{
		alert("For Pending Details Form You Have To Choose:\n"+"1. Bill by Bill-Yes\n"+"2. Sub Group Debtors/Creditors\n"+"3. Opening Balance\n"+"4. Account Type Dr/Cr\n"+"You Might Missed Something");
	}
}
</script>
<script>
function notno()
{
	var x=document.getElementById("opebal").value;
	if(isNaN(x))
	{
		document.getElementById("opebal").value=x.substring(0,x.length-1);
	}
}
function caldue()
{
	var gr=document.getElementsByName("formbean.gross");
	var pr=document.getElementsByName("formbean.pre");
	var due=document.getElementsByName("formbean.due");
	//alert(gr.length);
	var count=0;
	for(var i=0;i<gr.length;i++)
	{
		//alert(gr[i].value);
		due[i].value=gr[i].value-pr[i].value;
		  count=count+Number(due[i].value);
	}
	document.getElementById("tamount").value=count;
}

function calduea()
{
	var gr=document.getElementsByClassName("gross");
	var pr=document.getElementsByClassName("pre");
	var due=document.getElementsByClassName("due");
	//alert(gr.length);
	var count=0;
	for(var i=0;i<gr.length;i++)
	{
		//alert(gr[i].value);
		due[i].value=gr[i].value-pr[i].value;
		  count=count+Number(due[i].value);
	}
	document.getElementById("tamount").value=count;
}

function justcopy()
{
	var v=document.getElementsByClassName("vtype");
	var p=document.getElementsByClassName("parti");
	var d=document.getElementsByClassName("dt");
	var g=document.getElementsByClassName("gross");
	var p1=document.getElementsByClassName("pre");
	var du=document.getElementsByClassName("due");
	for(i=0; i<v.length; i++)
	{
		document.getElementsByClassName("vtypehidden")[i].value=v[i].value;
		
		document.getElementsByClassName("partihidden")[i].value=p[i].value;
		
		document.getElementsByClassName("dthidden")[i].value=d[i].value;
		
		document.getElementsByClassName("grosshidden")[i].value=g[i].value;
		
		document.getElementsByClassName("prehidden")[i].value=p1[i].value;
		
		document.getElementsByClassName("duehidden")[i].value=du[i].value;
	}
}
function closepopup()
{
	document.getElementById("obalance").value="";
	document.getElementById("dc").value="";
	document.getElementById("tamount").value="";
	var v100=document.getElementsByClassName("vtype");
	var p100=document.getElementsByClassName("parti");
	var d100=document.getElementsByClassName("dt");
	var g100=document.getElementsByClassName("gross");
	var pr100=document.getElementsByClassName("pre");
	var du100=document.getElementsByClassName("due");
	//alert(p100.length);
	for(var d=0;d<v100.length;d++)
	{
		v100[d].value="";
		p100[d].value="";
		d100[d].value="";
		g100[d].value="";
		pr100[d].value="";
		du100[d].value="";
	}
	var table = document.getElementById("table");
    var rowCount = table.rows.length;
    for(var i=rowCount-1; i>1; i--) 
    {
    	if(rowCount <= 2) 
    	{
    		break;
    	}
    	table.deleteRow(i);
        //rowCount--;
        //i--;
    }
    $("#popup").fadeOut();
	$("#popup").css({"visibility":"hidden","display":"none"});
}
</script>
<style>
#popup /*div id*/
{
	width:1000px;
	height:360px;
	margin-left:180px;
	margin-top:110px;
	font-weight:bold;
	background-color:#ebedef;
	border-radius:3px;
	box-shadow:0px 0px 10px 0px #424242;
	padding:10px;
	box-sizing:border-box;
	font-family:helvetica;
	visibility:hidden;
	display:inline;
	position:absolute;
	z-index: 9;
}
.bu
{
	background-color: #4CAF50;
    border: none;
    color: white;
    padding: 1px 1px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    cursor: pointer;
}
.bu:hover
{
	background-color: darkred;
	color:white
}
</style>

</head>
<body>
<s:if test="%{formbean==null}">
<body onload="showmail();ccode();copy();gets();"><center>
</s:if>
<s:else>
<body onload="showmail();calduea();copy();ccode();gets();"><center>
</s:else>
<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li>Ledger Master</li>
</ul>
</div>
<!-- //============================================ -->
<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
	<div style="position:fixed;top:160px;bottom: 45px;overflow-y:auto;width:100%" align="center">
	
	<s:form action="ledgercreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
	
    <div id="popup" style="display:none">
    <div align="right">
    	<img src="Image/popupclose.png" height="2%" width="2%" onclick="closepopup();"></img>
    </div>
    <center><u>
    <font color="red" size="3">PLEASE FILL-UP PENDING VOUCHERS (DEBIT/CREDIT) DETAILS</font></u>
    </center>
    <br>
			<table width="100%" border="0" id="table">
				
  	   			<tr align="center" bgcolor="#4292b2" style="color:white;">
  	   				<td height="20"></td>
  	   				<td width="12.5%" style=""><label><b>Voucher Type</b></label></td>
  	   		
  	   				<td style="">Particulars</td>
  	   		
  	   				<td width="12.5%" style=""><label>Date</label></td>
  	   				<td width="12.5%" style=""><label>Gross&nbsp;Amount</label></td>
  	   				<td width="12.5%" style=""><label>Pre&nbsp;Adjusted</label></td>
  	   				<td width="12.5%" style=""><label>Due&nbsp;Amount</label></td>
  	   </tr>
  	   <s:if test="%{formbean==null}">
  	   <tr>
  	   		<td style=""><input type="checkbox" name="chk"></input></td>
  	   		<td style=""><s:select name="formbean.vtype" id="vtype" cssClass="vtype" list="#{'':'-Select-','RC':'Cash Receipt','PC':'Cash Payment','RB':'Bank Receipt','PB':'Bank Payment','JV':'Journal','DN':'Debit Note','CN':'Credit Note','SD':'Credit Sales','UD':'Credit Purchase','SC':'Cash Sales','UC':'Cash Purchase'}" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:select></td>
  	   		<td style=""><div><s:textfield name="formbean.parti" id="parti" cssClass="parti" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:380px"></s:textfield></div></td>  
  	   		<td style=""><s:textfield name="formbean.dt" id="dt" size="25" cssClass="dt" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px"></s:textfield></td>	   	 	
  	  		<td style=""><s:textfield name="formbean.gross" id="gross"  cssClass="gross" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:110px"></s:textfield></td>
  	   		<td style=""><s:textfield name="formbean.pre" id="pre" cssClass="pre" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:110px" onkeyup="caldue()"></s:textfield></td>
  	   		<td style=""><s:textfield name="formbean.due" id="due" cssClass="due" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:110px" readonly="true"></s:textfield></td>
  	   </tr>
  	   </s:if>
  	   <s:else>
  	   <%int i=0; %>
  	   <s:iterator value="formbean.gross" status="status" >
  	   <tr>
  	   	<td style=""><input type="checkbox" name="chk"></input></td>
  	   		<td  style=""><s:select name="formbean.vtype" id="vtype" cssClass="vtype" list="#{'':'-Select-','RC':'Cash Receipt','PC':'Cash Payment','RB':'Bank Receipt','PB':'Bank Payment','JV':'Journal','DN':'Debit Note','CN':'Credit Note','SD':'Credit Sales','UD':'Credit Purchase','SC':'Cash Sales','UC':'Cash Purchase'}" value="formbean.vtype[#status.index]" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:select> <input type="hidden" name="formbean.vtypehidden" class="vtypehidden" id="vtypehidden"></input></td>
  	   		<td style=""><div><s:textfield name="formbean.parti[%{#status.count-1}]" id="parti" cssClass="parti" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:380px"></s:textfield></div> <input type="hidden" name="formbean.partihidden" class="partihidden" id="partihidden"></input></td>  
  	   		
  	   		<td  style=""><s:textfield name="formbean.dt[%{#status.count-1}]" id="dt" size="25" cssClass="dt" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px"></s:textfield> <input type="hidden" name="formbean.dthidden" class="dthidden" id="dthidden"></input></td>	   	 	
  	  		<td  style=""><s:textfield name="formbean.gross[%{#status.count-1}]" id="gross" size="25" cssClass="gross" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:110px"></s:textfield> <input type="hidden" name="formbean.grosshidden" class="grosshidden" id="grosshidden"></input></td>
  	   		<td  style=""><s:textfield name="formbean.pre[%{#status.count-1}]" id="pre" size="25" cssClass="pre" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:110px" onkeyup="calduea()"></s:textfield> <input type="hidden" name="formbean.prehidden" class="prehidden" id="prehidden"></input></td>
  	   		<td  style=""><s:textfield name="formbean.due[%{#status.count-1}]" id="due" size="25" cssClass="due" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;width:110px" readonly="true"></s:textfield> <input type="hidden" name="formbean.duehidden" class="duehidden" id="duehidden"></input></td>
  	   </tr>
  	   <%i++; %>
  	   </s:iterator>
  	   </s:else>
			</table>
			<div style="bottom:0">
				<label>Opening Balance:-</label><s:textfield name="formbean.obalance" id="obalance" readonly="true"></s:textfield>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>A/c Type:-</label><s:textfield name="formbean.dc" id="dc" cssStyle="width:25px" readonly="true"></s:textfield>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>Total Amount:-</label><s:textfield name="formbean.tamount" id="tamount" ></s:textfield>
			</div>
			<br>
			<input type="button" value="Add More Field" Class="butStnd" onclick="addRow('table'); return validate1();"></input>
        	<input type="button" value="Delete Fields" Class="butStnd" onclick="deleteRow('table');"></input>
        	<input type="button" value="Save" id="close" class="butStnd" onclick="justcopy()"></input>
		</div>
		
		
		
  <fieldset style="width:55%; border:solid thin #c6d5e1">
  <legend style="color:red;"><h3>Ledger Details</h3></legend>
  <div>
  <table cellpadding="5" width="70%" border="0">
        <tr> 	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Ledger&nbsp;Title</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.name" id="name" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Alias&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.alias" id="alias" size="30"  cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        </tr>

        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Sub&nbsp;Group</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><div id="for_asset_lia"><s:select name="formbean.sname" list="usList1" id="sname" listKey="sname" value="formbean.sname" listValue="sname" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;" onchange="ccode();showmail()" tabindex="2"/></div></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Main&nbsp;Group</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.maingroup" id="maingroup" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" readonly="true"></s:textfield></td>
        </tr>

	    <tr>
	    	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Opening&nbsp;Balance</label></td>
        	<td width="90%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.opebal" id="opebal" size="18" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="notno();"></s:textfield>
        	    <s:select name="formbean.opedc" id="opedc" list="#{'D':'Debit','C':'Credit' }" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:65px" onchange="copy()" ></s:select></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Previous&nbsp;Balance</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.prebal"  id="prebal" size="20" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" readonly="true"></s:textfield>
        		<s:textfield name="formbean.predc" id="predc" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:53px" readonly="true"></s:textfield></td>
        </tr>
      	
      	<tr>
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Default&nbsp;Credit&nbsp;Period</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.default1"  id="default1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
	    </tr>
	    	    
	    <tr>
	    <s:if test="%{formbean==null}">
	    	<td style="padding-top:5px;padding-left:15px"><label>Maintain&nbsp;Balance&nbsp;Bill&nbsp;By&nbsp;Bill</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:5px" valign="bottom"><s:radio name="formbean.maintainbal" id="maintainbal" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="showpopup(this.value)"></s:radio></td>
	    </s:if>
	    <s:else>
	    	<td style="padding-top:5px;padding-left:15px"><label>Maintain&nbsp;Balance&nbsp;Bill&nbsp;By&nbsp;Bill</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:5px" valign="bottom"><s:radio name="formbean.maintainbal" id="maintainbal" list="#{'1':'Yes','2':'No'}"  cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="showpopup(this.value)"></s:radio></td>
        </s:else>	
        </tr>
        <tr>
        <s:if test="%{formbean==null}">
        	<td style="padding-top:5px;padding-left:15px"><label>Inventory&nbsp;Values&nbsp;Are&nbsp;Affected</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:5px" valign="bottom"><s:radio name="formbean.inventoryval" id="inventoryval" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;"></s:radio></td>
        </s:if>
        <s:else>
        	<td style="padding-top:5px;padding-left:15px"><label>Inventory&nbsp;Values&nbsp;Are&nbsp;Affected</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:5px" valign="bottom"><s:radio name="formbean.inventoryval" id="inventoryval" list="#{'1':'Yes','2':'No'}" cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;"></s:radio></td>
        </s:else>
        </tr>

		
		<tr>
		<s:if test="%{formbean==null}">
        	<td style="padding-top:5px;padding-left:15px"><label>Cost&nbsp;Centres&nbsp;Are&nbsp;Applicable</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:5px" valign="bottom"><s:radio name="formbean.cost" id="cost" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;"></s:radio></td>
        </s:if>
        <s:else>
        	<td style="padding-top:5px;padding-left:15px"><label>Cost&nbsp;Centres&nbsp;Are&nbsp;Applicable</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:5px;" valign="bottom"><s:radio name="formbean.cost" id="cost" list="#{'1':'Yes','2':'No'}" cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;"></s:radio></td>
        </s:else>
        </tr>  
        </table>
        <div id="mail" style="display:none">
        <table cellspacing="8">
  		<tr>
  			<td colspan="4" align="center"><strong><font size="2" color="red">Mailing & Other Details</font></strong></td>
  		</tr>
    	<tr>
    		<td style="padding-top:5px;padding-left:15px"><label>Mail&nbsp;To</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px"><s:textfield name="formbean.mailto" id="mailto" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
    		<td style="padding-top:5px;padding-left:15px"><label>Full&nbsp;Address</label></td>
  	   		<td width="12.5%" style="padding-left:15px; padding-right:15px;" style="padding-top:10px"><s:textarea name="formbean.add" id="add" cols="275" rows="1" maxlength="275" cssStyle="border:1px solid #ccc;background:#FFFF99;resize:none;width:205px;height:25px"></s:textarea></td>
    	</tr>
    	
    	<tr>
    		<td style="padding-top:5px;padding-left:15px"><label>Place</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.place" id="place" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
    		<td style="padding-top:5px;padding-left:15px"><label>Contact&nbsp;Person&nbsp;Name</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.contname" id="contname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
    	</tr>
    	
    	<tr>
    		<td style="padding-top:5px;padding-left:15px"><label>Phone&nbsp;Number</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.phno" id="phno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" placeholder="First number"></s:textfield></td>
    		<td style="padding-top:5px;padding-left:15px"><label>Alternate&nbsp;Number</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.phno1" id="phno1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" placeholder="Second number"></s:textfield></td>
    	
    	</tr>
    	
    	<tr>
    		<td style="padding-top:5px;padding-left:15px"><label>Email</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.email" id="email" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" placeholder="First email"></s:textfield></td>
    		<td style="padding-top:5px;padding-left:15px"><label>Alternate&nbsp;Email</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.email1" id="email1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" placeholder="Second email"></s:textfield></td>
    	</tr>
    	
    	<tr>
    		<td style="padding-top:5px;padding-left:15px"><label>PAN&nbsp;No</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.pan1" id="pan1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
    		<td style="padding-top:5px;padding-left:15px"><label>VAT&nbsp;No</label></td>
    		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.vat" id="vat" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
    	</tr>
    	
    </table>
    </div>
</div>
<input type="text" id="getsession" name="formbean.getsession"></input>
   	  <div align="center" style="width:100%; position:static;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.save" value="Save Ledger" cssClass="butStnd" style="position:static" onclick="return Validate();" ></s:submit>
        
      </div>
      
     
      
    </s:form>
  </fieldset>
	
	<p>&nbsp;</p>
	<s:if test="usList">
	<div id="abc">
	<display:table id="table1"  name="usList" class="datatable" requestURI="" export="true" style="width:100%;color:#000">
	    
	 <s:if test="%{#attr.table1.id == formbean.id}">
	 
    <display:column property="name"   title="Ledger title"  style="background-color:#ecf2f6;"  sortable="false" headerClass="sortable">
	</display:column>
	
	<display:column property="subs"   title="Under SubGroup" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="alias"   title="Alias" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="opebal"   title="Opening_Balance" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="add"   title="Mailing Address" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="ledgerupdate" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="ledgerdelete" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	<s:else>
		 
    <display:column property="name"   title="Ledger Name"  style="background-color:#fff;"  sortable="false" headerClass="sortable" >
	</display:column>
	
	<display:column property="subs"   title="Under SubGroup" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="alias"   title="Alias" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="opebal"   title="Opening_Balance" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="add"   title="Mailing Address" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="ledgerupdate" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="ledgerdelete" namespace="/" ><s:param  name="id" value="%{#attr.table1.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
	</s:else> 
	   
    </display:table>
   </div>
   
  </s:if>

</center>
</div>

</body>
</html>
