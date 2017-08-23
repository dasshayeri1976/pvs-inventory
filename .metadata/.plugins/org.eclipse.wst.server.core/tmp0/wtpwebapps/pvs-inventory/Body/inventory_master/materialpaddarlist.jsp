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
<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>

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

<script language="javascript" type="text/javascript">
	function companycode() {
		//alert("rupsa");
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp0002 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp0002 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp0002 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("companyname").value;
		
		var url = "./Body/inventory_master/companycode.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
	//alert(url);
		xmlHttp0002.onreadystatechange = codeAdd0004;
		xmlHttp0002.open("GET", url, true);
		xmlHttp0002.send(null);
		
	};

	function codeAdd0004() {
		if (xmlHttp0002.readyState == 4 || xmlHttp0002.readyState == "complete") 
		{

			//alert("hello");
			var x=xmlHttp0002.responseText;
			
			//alert(x);
			document.getElementById("company_code1").value=x;

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

<script>
var rowIndex;
//var s;
function PersonViewModel(x) {
	 
	    rowIndex = $(x).closest('tr').index();
	   // s = s11;
	    //alert("part_code"+s);
	    
	  // alert("Row index is: " + rowIndex);
	  
	}
	
	
	function div1(){
		var lc=rowIndex;
		//alert(lc);
		var packing=document.getElementById("packing");
		var pcase=document.getElementsByClassName("pcase");
		//alert(packing.value);
		//alert(pcase[lc-1].value);
		var pcs=document.getElementsByClassName("pcs");
		
		pcs[lc-1].value=(pcase[lc-1].value / packing.value);
		
		
		
		
	}
	
	function total(){
		//alert("hi");
		var lc=rowIndex;
		//alert("hi"+lc)
		var total=document.getElementsByClassName("stotal");
	    //alert(total[lc-1].value)
		var packing=document.getElementById("packing");
	  //  alert(packing.value);
		var stockofpcs=document.getElementsByClassName("scase");
		var pcs1=document.getElementsByClassName("spcs");
		
		//alert("hello: "+stockofpcs[lc-1].value+","+pcs1[lc-1].value);
		var total1=((packing.value)*stockofpcs[lc-1].value);
		//alert(total1);
		 total[lc-1].value=total1+Number(pcs1[lc-1].value);
		
		
		
	}
	
	
function multi1(){
	//alert("hii");
var lc=rowIndex;
var packing=document.getElementById("packing").value;
var rtcase1=document.getElementsByClassName("rtcase");

var rtpcs1=document.getElementsByClassName("rtpcs");
//alert()
rtpcs1[lc-1].value=(rtcase1[lc-1].value / packing);
	
	
	
	
	
	
}
function div2(){
	//alert("hii");
	var lc=rowIndex;
	var packing=document.getElementById("packing").value;
	var rtcase1=document.getElementsByClassName("vrtcase");

	var rtpcs3=document.getElementsByClassName("vrtpcs");

	
	rtpcs3[lc-1].value=(rtcase1[lc-1].value/packing);
	
	
	
}

function totalcase()
{
	
    var s=document.getElementsByClassName("scase");
    var total=0;
    for(var i=0;i<s.length;i++)
    {
        total=total+Number(s[i].value);
    }
    document.getElementById("tcase").value=total.toFixed(2);
}

function totalstck()
{
	
    var s=document.getElementsByClassName("pcs");
    var t=document.getElementsByClassName("stotal");
    var total=0;
    for(var i=0;i<s.length;i++)
    {
    	var a=Number(s[i].value)*Number(t[i].value);
        total=total+Number(a);
    }
    document.getElementById("valueofstock").value=total.toFixed(2);
}



function topcs()
{
	
    var s=document.getElementsByClassName("spcs");
    var total=0;
    for(var i=0;i<s.length;i++)
    {
        total=total+Number(s[i].value);
    }
    document.getElementById("tpcs").value=total.toFixed(2);
}



function tototal()
{
	
    var s=document.getElementsByClassName("stotal");
    var total=0;
    for(var i=0;i<s.length;i++)
    {
        total=total+Number(s[i].value);
    }
    document.getElementById("tamount").value=total.toFixed(2);
}

	</script>
	
	<script language="javascript" type="text/javascript">
	function groupcode() {
		//alert(a);
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp01 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp01 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp01 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("materialgroup").value;
		
		var url = "./Body/inventory_master/groupcode.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		//alert(url);
		xmlHttp01.onreadystatechange = codeAdd04;
		xmlHttp01.open("GET", url, true);
		xmlHttp01.send(null);
		
	};

	function codeAdd04() {
		if (xmlHttp01.readyState == 4 || xmlHttp01.readyState == "complete") 
		{

			
			var x1=xmlHttp01.responseText;
			document.getElementById("materialgroup1").value=x1;
			alert(x1);
			
		}
	};
</script>
	
	<script language="javascript" type="text/javascript">
	function code1() {
		//alert(a);
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp02 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp02 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp02 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("purchase1").value;
		
		var url = "./Body/inventory_master/purcode.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		//alert(url);
		xmlHttp02.onreadystatechange = codeAdd05;
		xmlHttp02.open("GET", url, true);
		xmlHttp02.send(null);
		
	};

	function codeAdd05() {
		if (xmlHttp02.readyState == 4 || xmlHttp02.readyState == "complete") 
		{

			
			var x1=xmlHttp02.responseText;
			document.getElementById("purcode").value=x1;
			//alert(x1);
			
		}
	};
</script>

<script language="javascript" type="text/javascript">
	function code2() {
		//alert("amit");
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp03 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp03 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp03 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("saleac").value;
		
		var url = "./Body/inventory_master/purcode.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		//alert(url);
		xmlHttp03.onreadystatechange = codeAdd06;
		xmlHttp03.open("GET", url, true);
		xmlHttp03.send(null);
		
	};

	function codeAdd06() {
		if (xmlHttp03.readyState == 4 || xmlHttp03.readyState == "complete") 
		{

			
			var x1=xmlHttp03.responseText;
			document.getElementById("salecode").value=x1;
			//alert(x1);
			
		}
	};
</script>

<script language="javascript" type="text/javascript">
	function companycode() {
		//alert("rupsa");
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp005 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp005 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp005 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("companyname").value;
		
		var url = "./Body/inventory_master/companycode.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
	//alert(url);
		xmlHttp005.onreadystatechange = codeAdd09;
		xmlHttp005.open("GET", url, true);
		xmlHttp005.send(null);
		
	};

	function codeAdd09() {
		if (xmlHttp005.readyState == 4 || xmlHttp005.readyState == "complete") 
		{

			
			var x=xmlHttp005.responseText;
			
			//alert(x);
			document.getElementById("cmpcode").value=x;

		}
	};
</script>
	
	
	
	
	
	<script language="javascript" type="text/javascript">	
	function change()
{
	//alert("hello");
	
	
	var y=document.getElementsByClassName("pcase");
	var x=document.getElementsByClassName("pcase1");
	
	 var n=document.getElementsByClassName("pcs");
	var m=document.getElementsByClassName("pcs1"); 
	
	var p=document.getElementsByClassName("mrp1");
	var o=document.getElementsByClassName("mrp11"); 
	
	var r=document.getElementsByClassName("scase");
	var q=document.getElementsByClassName("scase1"); 
	
	var t=document.getElementsByClassName("spcs");
	var s=document.getElementsByClassName("spcs1");
	
	 var v=document.getElementsByClassName("stotal");
	var u=document.getElementsByClassName("stotal1"); 
	
	var b=document.getElementsByClassName("rtcase");
	var a=document.getElementsByClassName("rtcase1"); 
	
	var d=document.getElementsByClassName("vrtcase");
	var c=document.getElementsByClassName("vrtcase1"); 
	
	var f=document.getElementsByClassName("rtpcs");
	var e=document.getElementsByClassName("rtpcs1");
	
	 var h=document.getElementsByClassName("vrtpcs");
	var g=document.getElementsByClassName("vrtpcs1"); 
	
	var ram=document.getElementsByClassName("dist");
	var bubun=document.getElementsByClassName("dist1"); 
	
	var l=document.getElementsByClassName("price");
	var k=document.getElementsByClassName("price1"); 
	
	
//	alert(ram.length+","+l.length);
	for(var i=0;i<=y.length;i++)
		{
		x[i].value=y[i].value;
		m[i].value=n[i].value;
		o[i].value=p[i].value;
		q[i].value=r[i].value;
		s[i].value=t[i].value;
		u[i].value=v[i].value;
		a[i].value=b[i].value;
		c[i].value=d[i].value;
		e[i].value=f[i].value;
		g[i].value=h[i].value;
		bubun[i].value=ram[i].value;
		k[i].value=l[i].value;
		
		
		
		
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
<s:if test="%{formbean==null}" >
<body onload="disp();"><center>
</s:if>
<s:else>
<body onload="disp();"><center>
</s:else>

<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Material Group</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
    
  <fieldset style="width:40%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Material Master Creation</h3></legend>
  
  <s:form action="paddarlistcreation1" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
  <input type="hidden" name="formbean.mmcode" value="<s:property value="formbean.mmcode"/>"/>
   <input type="hidden" name="formbean.purcode" id="purcode" value="<s:property value="formbean.purcode"/>"/>
   <input type="hidden" name="formbean.salecode" id="salecode" value="<s:property value="formbean.salecode"/>"/>
    <input type="hidden" name="formbean.cmpcode" id="cmpcode" value="<s:property value="formbean.cmpcode"/>"/>
  
  <table cellpadding="5" width="50%" style="padding:5px">  
 
  		<tr>	
      		<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Material's&nbsp;Name&nbsp;</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.materialname"  id="materialname" cssClass="materialname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
     <td></td>
     </tr>
     
     <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Short&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sname"  id="sname" cssClass="sname" size="20" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
    <td></td>
       	</tr>
       	
       	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Material's&nbsp;Group</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	 <sj:autocompleter name="formbean.materialgroup" id="materialgroup" cssClass="materialgroup" list="usList2"  listValue="materialgroup" size="20" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onfocusout="groupcode();"></sj:autocompleter>
        	<s:textfield name="formbean.materialgroup1"  id="materialgroup1" cssClass="materialgroup1" size="20" cssStyle="display:none;height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield>
        	</td>
        
          <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
   
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Material&nbsp;Type</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mtype" id="mtype" cssClass="mtype" list="usList"  listValue="company" size="20" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        </tr>
        
        
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Purchase&nbsp;A/c&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	 <sj:autocompleter name="formbean.purchase1" id="purchase1" cssClass="purchase1" list="usList5"  listValue="pur" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onblur="code1();"></sj:autocompleter> 
        	<%-- <s:textfield name="formbean.purchase1"  id="purchase1" cssClass="purchase1" size="20" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield>
        	 --%>
        	 </td>
            
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
       <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Size</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.size" id="size" cssClass="size" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" ></s:textfield></td>
        </tr>
       
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Sales&nbsp;A/c&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	 <sj:autocompleter name="formbean.salesac1" id="saleac" cssClass="salesac"  onblur="code2();" list="usList6"  listValue="sl" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></sj:autocompleter> 
        	<%-- <s:textfield name="formbean.salesac1"  id="salesac1" cssClass="salesac1" size="20" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield>
        	 --%></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
       <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Sales&nbsp;Unit</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sunit" id="sunit" cssClass="sunit" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" ></s:textfield></td>
        </tr>
      
         <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Company&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	<sj:autocompleter name="formbean.companyname" id="companyname" list="usList4"  listValue="companyname" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onfocusout="companycode();"></sj:autocompleter>
        	<s:textfield name="formbean.company_code1"  id="company_code1" cssClass="company_code1" size="20" cssStyle="display:none;height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield>
        	</td>
             <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Scheme</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.scheme" id="scheme" cssClass="scheme" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        </tr>
         
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>mfg.&nbsp;Code</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mfgcode" id="mfgcode" cssClass="mfgcode" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
             <td width="12.5%" style="padding-left:15px; padding-right:15px;">Hsn&nbsp;Code</td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.hsn"  id="hsn" cssClass="hsn" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Period</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.period" id="period" cssClass="period" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        </tr>
        
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Unit&nbsp;of&nbsp;Item</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.unitofitem" id="unitofitem" cssClass="unitofitem" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Packing</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.packing" id="packing" cssClass="packing" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Min&nbsp;inv&nbsp;level</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.mininvlevel" id="mininvlevel" cssClass="mininvlevel" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        </tr>
        
         	<tr>
         	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>GST@ </label></td>
         <td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top"><s:select name="formbean.typeoftax"   id="typeoftax" list="#{'0':'0%','5':'5%','12':'12%','18':'18%','28':'28%'}"  cssClass="typeoftax"  cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;width:200px;"></s:select></td>
		
        	<%-- <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>GST&nbsp;@&</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.valueaddedtax" id="valueaddedtax" cssClass="valueaddedtax" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td> --%>
         <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	         <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	
       
           
        </tr>
        
        <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Agriculture&nbsp;Tax</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.agriculturetax" id="agriculturetax" cssClass="agriculturetax" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Surcharge</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.surchar" id="surchar" cssClass="surchar" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Value&nbsp;Of&nbsp;Stock</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.valueofstock" id="valueofstock"  cssClass="valueofstock" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        </tr>
       
       
       </table>
   
  
   
   
 
        
   
   
   
 
  
   
   <fieldset style="width:30%; border:solid thin #c6d5e1;Padding:5px;">
    <legend style="color:red;"><h3>OTHER DETAILS OF MATERIAL</h3></legend>
	<table cellspacing="0" border="0" width="50%" id='table1'>
	
	<!-- <tr  style="background-color:#4292b2;color:white;" align="center">        
    
        <th  width="2%"></th>
        <th width="9%" style="font-size:11.2px" align="center" colspan="2">LIST PRICE</th>
        <th width="9%" style="font-size:11.2px">M.R.P.</th>     
       <th width="9%" style="font-size:11.2px" colspan="3">OPENING STOCK</th>
        <th width="9%" style="font-size:11.2px">SALE (L)</th>
         <th width="9%" style="font-size:11.2px">SALE VAN</th>
         <th width="9%" style="font-size:11.2px">SALE (L)</th>
        <th width="9%" style="font-size:11.2px">SALE VAN</th>
       <th width="9%" style="font-size:11.2px">DIST.</th>
        <th width="9%" style="font-size:11.2px">PRICE</th> 
        
    </tr> -->
	 <tr  style="background-color:#4292b2;color:white;" align="center">        
    
        <th  width="2%"></th>
        <th width="9%" style="font-size:11.2px">LIST&nbsp;PRICE CASE</th>
        <th width="9%" style="font-size:11.2px">  PCS</th>     
        <th width="9%" style="font-size:11.2px">M.R.P. PCS</th>
        <th width="9%" style="font-size:11.2px">OPENING&nbsp;STOCK CASE</th>
        <th width="9%" style="font-size:11.2px">PCS</th>     
        <th width="9%" style="font-size:11.2px">TOTAL</th>
        <th width="9%" style="font-size:11.2px">SALE (L)&nbsp;RT. CASE</th>
        <th width="9%" style="font-size:11.2px">SALE VAN RT. CASE</th>
        <th width="9%" style="font-size:11.2px">SALE (L)&nbsp;RT. PCS</th>
        <th width="9%" style="font-size:11.2px">SALE VAN RT. PCS</th>
        <th width="9%" style="font-size:11.2px">DIST.</th>
        <th width="9%" style="font-size:11.2px">PRICE</th> 
    </tr>
       <s:if test="%{formbean.pcase==null}"> 
    <tr>
    
        <td  width="2%"><input type="checkbox" name="chk"/></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcase" id="pcase"  cssClass="pcase" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;" onkeyup="PersonViewModel(this);div1();" ></s:textfield></td>
		
		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcs" id="pcs" cssClass="pcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="setcpartcode();setcdesccode();setcmakecode();"></s:textfield></td>	    

		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp1" id="mrp1" cssClass="mrp1"  size="8" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.scase" id="scase" cssClass="scase"  size="14" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);totalcase();"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.spcs" id="spcs" cssClass="spcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);total();topcs();"></s:textfield></td>
        
         <td width="9%" style="font-size:14px"><s:textfield name="formbean.stotal" id="stotal" cssClass="stotal"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.rtcase" id="rtcase" cssClass="rtcase" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="totalstck();PersonViewModel(this);multi1();tototal();"></s:textfield></td>
        	 
   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.vrtcase" id="vrtcase" cssClass="vrtcase"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);div2();"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.rtpcs" id="rtpcs" cssClass="rtpcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield></td>
       	 
       	 <td width="9%" style="font-size:14px"><s:textfield name="formbean.vrtpcs" id="vrtpcs" cssClass="vrtpcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);"></s:textfield></td>
        	 
   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.dist" id="dist" cssClass="dist"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.price" id="price" cssClass="price" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield></td>
       		        
       </tr> 
   </s:if> 
  <s:else>
     <s:iterator value="formbean.pcase" status="status">
     	 <tr>
    
        <td  width="2%"><input type="checkbox" name="chk"/></td>
        
          
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcase[%{#status.count-1}]" id="pcase"  cssClass="pcase" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;" onkeyup="PersonViewModel(this);div1();" ></s:textfield><input type="hidden" name="formbean.pcase1" id="pcase1" class="pcase1"></input> </td>
		
		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcs[%{#status.count-1}]" id="pcs" cssClass="pcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="setcpartcode();setcdesccode();setcmakecode();"></s:textfield><input type="hidden" name="formbean.pcs1" id="pcs1" class="pcs1"></input></td>	    

		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp1[%{#status.count-1}]" id="mrp1" cssClass="mrp1"  size="8" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.mrp11" id="mrp11" class="mrp11"></input></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.scase[%{#status.count-1}]" id="scase" cssClass="scase"  size="14" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);totalcase();"></s:textfield><input type="hidden" name="formbean.scase1" id="scase1" class="scase1"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.spcs[%{#status.count-1}]" id="spcs" cssClass="spcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);total();topcs();"></s:textfield><input type="hidden" name="formbean.spcs1" id="spcs1" class="spcs1"></input></td>
        
         <td width="9%" style="font-size:14px"><s:textfield name="formbean.stotal[%{#status.count-1}]" id="stotal" cssClass="stotal"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99"></s:textfield><input type="hidden" name="formbean.stotal1" id="stotal1" class="stotal1"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.rtcase[%{#status.count-1}]" id="rtcase" cssClass="rtcase" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="totalstck();PersonViewModel(this);multi1();tototal();"></s:textfield><input type="hidden" name="formbean.rtcase1" id="rtcase1" class="rtcase1"></input></td>
        	 
   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.vrtcase[%{#status.count-1}]" id="vrtcase" cssClass="vrtcase"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);div2();"></s:textfield><input type="hidden" name="formbean.vrtcase1" id="vrtcase1" class="vrtcase1"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.rtpcs[%{#status.count-1}]" id="rtpcs" cssClass="rtpcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield><input type="hidden" name="formbean.rtpcs1" id="rtpcs1" class="rtpcs1"></input></td>
       	 
       	 <td width="9%" style="font-size:14px"><s:textfield name="formbean.vrtpcs[%{#status.count-1}]" id="vrtpcs" cssClass="vrtpcs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);"></s:textfield><input type="hidden" name="formbean.vrtpcs1" id="vrtpcs1" class="vrtpcs1"></input></td>
        	 
   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.dist[%{#status.count-1}]" id="dist" cssClass="dist"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield><input type="hidden" name="formbean.dist1" id="dist1" class="dist1"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.price[%{#status.count-1}]" id="price" cssClass="price" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield><input type="hidden" name="formbean.price1" id="price1" class="price1"></input></td>
     	 
       	 	 	 	        
       </tr> 
     </s:iterator>
    </s:else> 
       
      
	</table>
	
	    <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
       <input type="button" value="add" Class="butStnd" onclick="addRow('table1');genSerial();incr();"/>
       <input type="button" value="delete" Class="butStnd" onclick="deleteRow('table1');"/>
	
	
       
      
      </div>
      
	 
  </fieldset> 
  
  <table cellspacing="0" border="0" width="50%" >
  <tr>
   <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Total&nbsp;Case</label></td>
   <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.tcase" id="tcase"  cssClass="tcase" size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
 
  <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Total&nbsp;Pcs</label></td>
   <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.tpcs" id="tpcs"  cssClass="tpcs"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
 
  <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Total&nbsp;Amount</label></td>
   <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.tamount" id="tamount"  cssClass="tamount"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
 
  </tr>
  
 </table>
    
  
   <div align="right" style="width:99%;position:relative;  padding:7px;">
    <s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="change();" ></s:submit>
  </div>
   	 
   	  
     
      
      
      

      
    </s:form>
  </fieldset>
  
 
  
	
	 <p>&nbsp;</p>
	<s:if test="usList1">
	<div id="ram">
	<display:table id="table"  name="usList1" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:75%;color:#000">
	    
	 <s:if test="%{#attr.table.id == formbean.id}">
	
	<display:column property="materialname"   title="Material name" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="materialgroup"   title="M GroupName" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="sunit"   title="Unit"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="typeoftax"   title="GST@" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="packing"   title="Pack" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="tcase"   title="Case" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="tpcs"   title="Pcs" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="tamount"   title="TotalQty" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<%-- <display:column property="mfgcode"   title="Mrp Value" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" /> --%>
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="paddarlistupdate1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="paddarlistdelete1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	<s:else>
	
	<display:column property="materialname"   title="Material Description" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="materialgroup"   title="M GroupName"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="sunit"   title="Unit" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="typeoftax"   title="Gst@" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="packing"   title="Pack" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="tcase"   title="Case" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="tpcs"   title="PCS" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="tamount"   title="TotalQTY" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="paddarlistupdate1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="paddarlistdelete1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
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
