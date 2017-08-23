<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.connection.account.ConnectionDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page session="true"%>
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

<script>

function arcode()
{
	alert();
	 if (typeof XMLHttpRequest != "undefined") {
		xmlHttp002 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp002 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp002 == null) {
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1 =document.getElementById("areaname").value;
	//alert('S1: '+s1);
	//var s = document.getElementById("section").value;
	//var s = document.getElementById("source").value;
	//document.getElementById("newspaperadd").value = s;
	var url = "./Body/inventory_transaction/arcode.jsp";
	url += "?count=" + s1; // + "&sec=" + s;
	//url +="?count=" +str+"&date1="+s;
	xmlHttp002.onreadystatechange = codeAdd34;
	xmlHttp002.open("GET", url, true);
	xmlHttp002.send(null);
	
};

function codeAdd34() {
	if (xmlHttp002.readyState == 4 || xmlHttp002.readyState == "complete") 
	{

		
		var x1=xmlHttp002.responseText;
		alert(x1);
		
		
		document.getElementById("arcode1").value=x1;
		/* if(x1==1)
		{
		xm=0;
		alert("Please Register Your Name First");
		document.getElementById("name").value='';
		document.getElementById("name").focus();
		} */

	} 
};


</script>





</head>


<body onload="showmail();ccode();copy();gets();"><center>


<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li>Party Master</li>
</ul>


 <s:form action="partymastercreation" namespace="/" method="post" autocomplete="off">
<fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Party Master</h3></legend>
  
 
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
  
  <input type="text" name="formbean.arcode1" id="arcode1" value="<s:property value="formbean.arcode1"/>"/>
  
  
  <table cellpadding="5" width="70%" style="padding:20px">  
 
  		<tr>	
  		
  			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Party&nbsp;code</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.partycode"  id="partycode" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
  		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Party&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.partyname"  id="partyname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	  </tr>
        
        <tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Main&nbsp;Ledger</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mainledger"  id="mainledger" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Short&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sname"  id="sname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        </tr>
        
        <tr>	
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Opening&nbsp;Balance</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.openingbalance"  id="openingbalance" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
      		
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Dr&nbsp;/Cr</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.drcr1"  id="drcr1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
      
      	
        </tr>


 

        <tr>	
      		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Prev yr&nbsp;Balance</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.prevyrbalance"  id="prevyrbalance" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
      		
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Dr&nbsp;/Cr</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.drcr"  id="drcr" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
      		
        </tr>



	
      		
        	 <tr>	
        	 
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>D/C&nbsp;Limit</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.dclimit"  id="dclimit" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Gress&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.gress"  id="gress" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	
        </tr>
      
      
       <tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Any&nbsp;Other</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.anyother"  id="anyother" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Int&nbsp;Rate</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.intrate"  id="intrate" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      	
      		
        	
        </tr>
        
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Disc&nbsp;Rate</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.discreate"  id="discreate" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>TDR&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.tdr"  id="tdr" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        	
        </tr>
       <tr>
      
      
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>GSTIN&nbsp;NO</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.gstinno"  id="gstinno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
  		
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>PAN&nbsp;NO</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.panno"  id="panno" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
     
      
      
        </tr>
        <tr>
        
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>State&nbsp;Type</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.sttype" id="sttype"  list="#{'InterState':'InterState', 'IntraState':'IngtraState'}"	cssStyle="width:80px; border:1px solid #ccc" /></td>
        
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>State&nbsp;Code</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.statecode"  id="statecode" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
      
        
        </tr>
    
   </table>
   </fieldset>
  <br>
  
  <fieldset style="width:60%; position:static;border-top:1;border-left:none;border-right:none;border-bottom:none;">
  <legend style="color:red;"><h3>MAILING & OTHER DETAIL</h3></legend>
 
  
  <table cellpadding="5" width="70%" style="padding:20px">  
 <tr>
 
		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Mail&nbsp;To</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mailto"  id="mailto" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		      
		
 
 			 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Location&nbsp;</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.location"  id="location" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		      
		
 
 
</tr> 
 
  
 <tr>
 
		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Address&nbsp;</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.address1"  id="address1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		      
		
 			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Contact&nbsp;Person</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.contactperson"  id="contactperson" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		      
		
 
</tr> 
 
 
 

 
  <tr>
 
		 
 
 
				<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Call&nbsp;</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.call"  id="call" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		      
		
  				<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Income&nbsp;Tax&nbsp;P/A</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.incometaxpa"  id="incometaxpa" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		      
	
</tr> 
 <tr>
  				<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Area&nbsp;Name</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.areaname"  id="areaname" list="usList1"  listValue="areaname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onblur="arcode();"></sj:autocompleter></td>
		
		
		
				<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Category&nbsp;</label></td>
		       	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.category"  id="category" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
		            
</tr>	
 
 
 <tr>
 				 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Class&nbsp;</label></td>
		         <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.clas" id="clas"  list="#{'Retailer':'Retailer', 'WholeSeller':'WholeSeller'}"	cssStyle="width:80px; border:1px solid #ccc" /></td>
		
		
				 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Type&nbsp;Of&nbsp;Party</label></td>
		       	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.typeofparty" id="typeofparty"  list="#{'CashParty':'CashParty', 'CreditParty':'CreditParty'}"	cssStyle="width:80px; border:1px solid #ccc" /></td>
		            
	</tr>	
 
   </table>
</fieldset>
      
      <div align="center" style="width:100%; position:static;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.save" value="Save Ledger" cssClass="butStnd" style="position:static" onclick="return Validate();" ></s:submit>
        
      </div> 
      

    </s:form>






</body>
</html>
 