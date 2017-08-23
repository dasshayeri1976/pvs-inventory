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
<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="./css/draftbutton.css" />
<link rel="stylesheet" href="./css/printbutton.css" />
<link rel="stylesheet" href="css/breadcumbs.css" ></link>
<link rel="stylesheet" type="text/css" media="all" href="./Body/fordatepick/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="./Body/fordatepick/jsDatePick.min.1.3.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/>
<script src="//code.jquery.com/jquery-1.12.4.js"></script> 
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
		var $easy1 = $.noConflict(true);
	</script>
<script>
 $(document).ready(function() {
	   
	 $("#ram").css({ 'display': "block" });
	    $easy1('#table12').DataTable( {
	       
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
<script>
$(document).ready(function()
		{
			new JsDatePick
			({
				useMode:2,
				target:"showdate",
				dateFormat:"%Y-%m-%d"
			});
			new JsDatePick
			({
				useMode:2,
				target:"contradate",
				dateFormat:"%Y-%m-%d"
			});
		});
</script>
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
				//alert('Avi');
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
		var fer=document.getElementById("credit").value;
		if(fer!="")
		{
			prompt();
		}
	}
	
	
</script>

<script type="text/javascript">
$(document).keypress(function(e) {
	//ledger shortcut
	var x;
	var url = "ledgerlist1";
	url += "?count=" + "debitnote"; 
	if(e.which)
	{
		x=e.which;
	}
	  if(e.altKey)
		{
		  if(String.fromCharCode(x)=="c")
			{
				window.location= url;
			}
		}
	//ledger shortcut end
	//subgroup shortcut
	var x1;
	var url1 = "grpnamelist1";
	url1 += "?count=" + "debitnote";
	if(e.which)
	{
		x1=e.which;
	}
	if(e.altKey)
	{
		if(String.fromCharCode(x1)=="g")
		{
			window.location=url1;
		}
	}
	//subgroup shortcut end
	//group shortcut
	var x2;
	var url2 = "acgrouplist1";
	url2 += "?count=" + "debitnote";
	if(e.which)
	{
		x2=e.which;
	}
	if(e.altKey)
	{
		if(String.fromCharCode(x2)=="m")
		{
			window.location=url2;
		}
	}
	//group shortcut end
	});

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
		var url = "./Body/account_transaction/checkname.jsp";
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
		document.getElementById("det").innerHTML="";
	}
	if(x=="assets")
	{
		document.getElementById("for_asset_lia").style.display="block";
		document.getElementById("bal_sheet").value="Balance Sheet";
		document.getElementById("for_in_ex").style.display="none";
		document.getElementById("det").innerHTML="For_Assets";
	}
	if(x=="liability")
	{
		document.getElementById("for_asset_lia").style.display="block";
		document.getElementById("bal_sheet").value="Balance Sheet";
		document.getElementById("for_in_ex").style.display="none";
		document.getElementById("det").innerHTML="For_Liability";
	}
	if(x=="income")
	{
		document.getElementById("for_in_ex").style.display="block";
		document.getElementById("for_asset_lia").style.display="none";
		document.getElementById("det").innerHTML="For_Income_Account";
	}
	if(x=="expenditure")
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


<script>
function show()
{
	//for serial no
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp00111 = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		xmlHttp00111 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp00111 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	//var s1 =document.getElementById("part").value;//get subgroupname
	//s1=s1.replace('&','*');
	var url = "./Body/account_transaction/getsrnofordebitnote.jsp";
	
	//url += "?count=" + s1; // + "&sec=" + s;
	//url +="?count=" +str+"&date1="+s;

	xmlHttp00111.onreadystatechange = codeAdd044;
	xmlHttp00111.open("GET", url, true);
	xmlHttp00111.send(null);
}
function codeAdd044() 
{
	if (xmlHttp00111.readyState == 4 || xmlHttp00111.readyState == "complete") 
	{			
		var x1=xmlHttp00111.responseText;
		x1=x1.trim();
		var x2=x1.split("con");
		if(x2[1]=="0")
		{
			var d=new Date();
			var date=d.getDate();
			var month=d.getMonth()+1;
			var year=d.getFullYear();
			//alert(date+"-"+month+"-"+year);
			var weekday = new Array(7);
		    weekday[0] = "Sunday";
		    weekday[1] = "Monday";
		    weekday[2] = "Tuesday";
		    weekday[3] = "Wednesday";
		    weekday[4] = "Thursday";
		    weekday[5] = "Friday";
		    weekday[6] = "Saturday";
		    var n = weekday[d.getDay()];
			document.getElementById("showdate").value=year+"-"+month+"-"+date;
			document.getElementById("day1").innerHTML=n;
		}
		else
		{
			document.getElementById("showdate").value=x2[1];
		}
		document.getElementById("srno").value=x2[0];	
	}
}
</script>
<script>
function ccode()//geting current bal 
{
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp0011 = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		xmlHttp0011 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp0011 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1=document.getElementsByName("formbean.partforcontra");
	
	var x=s1.length;
	var val = new Array(x);

	for(i=0;i<s1.length;i++)
	val[i]=s1[i].value;
	
	val.join(',')
	//alert(val.join(','));
	//var s1 =document.getElementById("partforcontra").value;//get subgroupname
	//var capCount = s1.value;
	//var count = parseInt(capCount);
	
	//s1=s1.replace('&','*');
	var url = "./Body/account_transaction/getcrbal.jsp";
	url += "?count=" + val.join(','); // + "&sec=" + s;
	//url +="?count=" +str+"&date1="+s;

	xmlHttp0011.onreadystatechange = codeAdd04;
	xmlHttp0011.open("GET", url, true);
	xmlHttp0011.send(null);
}
function codeAdd04() 
{
	if (xmlHttp0011.readyState == 4 || xmlHttp0011.readyState == "complete") 
	{			
		var x1=xmlHttp0011.responseText;
		var x2=x1.split(", ");
		//alert(x2);
		for(i=0;i<x2.length;i++)
		{
			if(parseInt(x2) < 0)
			{
				document.getElementsByName("partcrbal")[i].value="bal: "+x2[i].replace("-","")+" cr";
			}
			else
			{
				document.getElementsByName("partcrbal")[i].value="bal: "+x2[i]+" dr";
			}
		}
	}
}
</script>
<script>
function showdraft()//getting contra part
{
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp2 = new XMLHttpRequest();
	} 
	else if (window.ActiveXObject) 
	{
		xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp2 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s11 = document.getElementById("part1").value;
	var url = "./Body/account_transaction/showdraft.jsp"; 
	url += "?count=" + s11; 
	xmlHttp2.onreadystatechange = codeAdd3;
	xmlHttp2.open("GET", url, true);
	xmlHttp2.send(null);
	
}
function codeAdd3() {
	if (xmlHttp2.readyState == 4 || xmlHttp2.readyState == "complete") 
	{
		var e=xmlHttp2.responseText;
		
		if(e==1)
		{
			
			document.getElementById("hello").style.display="block";
			document.getElementById("hello1").style.display="block";
		}
		else
		{
			
			document.getElementById("hello").style.display="none";
			document.getElementById("hello1").style.display="none";
		}
	}
};
</script>
<script>
function partlist()//getting contra part
{
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp1 = new XMLHttpRequest();
	} 
	else if (window.ActiveXObject) 
	{
		xmlHttp1 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp1 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1 = document.getElementById("part1").value;
	var url = "./Body/account_transaction/getcrbal2.jsp"; 
	url += "?count=" + s1; 
	xmlHttp1.onreadystatechange = codeAdd2;
	xmlHttp1.open("GET", url, true);
	xmlHttp1.send(null);
	
}
function codeAdd2() {
	if (xmlHttp1.readyState == 4 || xmlHttp1.readyState == "complete") {

		document.getElementById("partforcontra").innerHTML = xmlHttp1.responseText;
		var e=xmlHttp1.responseText;
		//document.getElementById("partforcontra").innerHTML = "<select><option value='hello'>hello</option></select>";
		//document.getElementById("check").innerHTML = xmlHttp1.responseText;
	}
};
</script>
<script>
function showdata()
{
	
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp002 = new XMLHttpRequest();
		
	}
	else if (window.ActiveXObject) 
	{
		xmlHttp002 = new ActiveXObject("Microsoft.XMLHTTP");
		
	}
	
	if (xmlHttp002 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1[]=document.getElementsByName("narration");
	//alert(s1.length);
	for(var i=0;i<s1.length;i++)
	{
		//alert();
	}
}
</script>
<script>
function ccode1()//geting current bal of on a/c
{
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp100 = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		xmlHttp100 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp100 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1 =document.getElementById("part1").value;//get subgroupname

	var url = "./Body/account_transaction/getcrbal1.jsp";
	url += "?count=" + s1; 
	xmlHttp100.onreadystatechange = codeAdd55;
	xmlHttp100.open("GET", url, true);
	xmlHttp100.send(null);
}

function codeAdd55() 
{
	if (xmlHttp100.readyState == 4 || xmlHttp100.readyState == "complete") 
	{			
		var x1=xmlHttp100.responseText;
		//alert(x1);
		var x2=parseInt(x1);
		if(x2 < 0)
		{
			document.getElementById("crbal").innerHTML="bal: "+x1.replace("-","")+" cr";
		}
		else
		{
			document.getElementById("crbal").innerHTML="bal: "+x1+" dr";
		}			
	}
}

function codeAdd06() 
{
	if (xmlHttp002.readyState == 4 || xmlHttp002.readyState == "complete") 
	{			
		var x1=xmlHttp002.responseText;
		document.getElementById("check").innerHTML=x1;
		//document.getElementById("partforcontra").innerHTML=x1;	
		document.getElementById("partforcontra").innerHTML = xmlHttp002.responseText;
	}
}
</script>
<script>
function validate1()
{
	var q=document.getElementById("partforcontra").value;
	var qq=document.getElementById("narration").value;
	var qqq=document.getElementById("debit").value;
	var qqqq=document.getElementById("credit").value;
	if(qq=="" || qq=="" || qqq=="" && qqqq=="")
	{
		alert("Fields cannot be blank..");
		//document.getElementById("narration").focus();
	}
}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style>
#table, td, th 
{
	border-collapse: collapse;
    border: 0px solid lightgray;
}
</style>
<script>
function test12()
{
	var xx=document.getElementsByName("formbean.credit");
	//alert(xx);
	var count=0;
	for(var j=0;j<xx.length;j++)
	{
		if(isNaN(xx[j].value))
		{
			xx[j].value=xx[j].value.substring(0,xx[j].value.length-1);
		}
	}
	for(var i=0;i<xx.length;i++)
	{
		//alert(xx[i].value);
		count=count+Number(xx[i].value);
	}
	document.getElementById("totalam").value=count;
}
</script>
<script>
function todummy()
{
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmltodummy = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		xmltodummy = new ActiveXObject("Microsoft.XMLHTTP");	
	}
	if (xmltodummy == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var doref=document.getElementsByName("formbean.doref");
	var dat=document.getElementsByName("formbean.dat");
	var billamount=document.getElementsByName("formbean.billamount");
	var adjusted=document.getElementsByName("formbean.adjusted");
	var dues=document.getElementsByName("formbean.dues");
	var amount1=document.getElementsByName("formbean.amount1");
	var hidden=document.getElementsByName("parthidden");
	
	var ar=new Array(doref.length);
	for(var i=0; i<doref.length; i++)
	{
		ar[i]=doref[i].value+"con"+dat[i].value+"con"+billamount[i].value+"con"+adjusted[i].value+"con"+dues[i].value+"con"+hidden[i].value;
	}
	//alert(ar);
	ar.join(",");
	var url = "./Body/account_transaction/inserttodummy.jsp";
	url += "?count=" + ar.join(",");
	
	xmltodummy.onreadystatechange = codetodummy;
	xmltodummy.open("GET", url, true);
	xmltodummy.send(null);
}
function codetodummy() 
{
	if (xmltodummy.readyState == 4 || xmltodummy.readyState == "complete") 
	{			
		var x1=xmltodummy.responseText;	
	}
}
var rowIndex;
function PersonViewModel(x)
{
	rowIndex=$(x).closest('tr').index();
	//alert(rowIndex);
}

function showpopup()
{
	var lc=rowIndex;
	if (typeof XMLHttpRequest != "undefined") 
	{
		a1 = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		a1 = new ActiveXObject("Microsoft.XMLHTTP");	
	}
	if (a1 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var particular=document.getElementsByName("formbean.partforcontra");
	var x=particular.length;
	var val12=new Array(x);
	/*for(var l=0; l<particular.length; l++)
	{
		val12[l]=particular[l].value;
	}*/
	//val12.join(',')
	//alert(particular[lc-1].value);
	
	var url = "./Body/account_transaction/checkforsu.jsp";
	url += "?count=" + particular[lc-1].value+","+lc;
	
	a1.onreadystatechange = codefun;
	a1.open("GET", url, true);
	a1.send(null);
}
function codefun() 
{
	if (a1.readyState == 4 || a1.readyState == "complete") 
	{
		var xyzz=a1.responseText;
		xyzz=xyzz.trim();
		var abcc=xyzz.split("||");
			if(abcc[0].trim()=="SC" || abcc[0].trim()=="SD")
			{	
				//alert(abcc[i]);
				$("#popup").fadeIn();
				$("#popup").css({"visibility":"visible","display":"block"});
			}
		document.getElementById("table1").innerHTML=abcc[2];
	}
}

function closepopup()
{
	document.getElementById("tamount").value="";
	
	var v100=document.getElementsByName("formbean.doref");
	var p100=document.getElementsByName("formbean.dat");
	var d100=document.getElementsByName("formbean.billamount");
	var g100=document.getElementsByName("formbean.adjusted");
	var pr100=document.getElementsByName("formbean.dues");
	var du100=document.getElementsByName("formbean.amount1");

	for(var d=0;d<v100.length;d++)
	{
		v100[d].value="";
		p100[d].value="";
		d100[d].value="";
		g100[d].value="";
		pr100[d].value="";
		du100[d].value="";
	}
	
	var table = document.getElementById("table1");
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

$(document).ready(function()
		{
			$("#close").click(function()
			{
				//alert();
				$("#popup").fadeOut();
				$("#popup").css({"visibility":"hidden","display":"none"});
				//hidepopup();
			});
		});

function testonly()
{
	document.getElementById("hello").style.display="block";
}

function test12a()
{
	//alert('Avi');
	//var xx=document.getElementsByName("formbean.credit[0]");
	var x = document.getElementsByClassName("sourav");
	//alert(x.length);
	var count=0;
	for(var j=0;j<x.length;j++)
	{
		if(isNaN(x[j].value))
		{
			x[j].value=x[j].value.substring(0,x[j].value.length-1);
		}
	}
	for(var i=0;i<x.length;i++)
	{
		//alert(xx[i].value);
		count=count+Number(x[i].value);
	}
	document.getElementById("totalam").value=count;
}
</script>
<script>
function copycredit()
{
	//alert("Avi");
	var x = document.getElementsByClassName("part");
	var y = document.getElementsByClassName("sourav");
	var z = document.getElementsByClassName("nar");
	//alert(z.length);
	var count1=0;
	for(var i=0;i<z.length;i++)
	{
		//alert(z[i].value);
		//count=count+Number(x[i].value);
		//document.getElementsByClassName("contra1")=x[i].value;
		//document.getElementsByClassName("credithidden")=y[i].value;
		document.getElementsByClassName("narration1")[i].value=z[i].value;
		document.getElementsByClassName("credithidden")[i].value=y[i].value;
		document.getElementsByClassName("contra1")[i].value=x[i].value;
		//alert(x[i].value);
	}
}

function abc()
{
	var q123=document.getElementsByName("formbean.partforcontra");
	for(var i=0;i<q123.length;i++)
	{
		for(var j=i+1;j<q123.length;j++)
		{
			//alert(q123[i].value);
			if(q123[i].value==q123[j].value)
			{
				alert("Particular account cannot be same");
				return false;
			}
		}
	}
	return true;
}
</script>
<script>
function getnarration()
{
	var efgh=document.getElementById("prenar").value;
	if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp10 = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		xmlHttp10 = new ActiveXObject("Microsoft.XMLHTTP");	
	}
	if (xmlHttp10 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var url = "./Body/account_transaction/getnarration.jsp";
	url += "?count=" + efgh;
	
	xmlHttp10.onreadystatechange = codeAdd10;
	xmlHttp10.open("GET", url, true);
	xmlHttp10.send(null);
}
function codeAdd10() 
{
	if (xmlHttp10.readyState == 4 || xmlHttp10.readyState == "complete") 
	{			
		var x1=xmlHttp10.responseText;
		//alert(x1.trim());
		document.getElementById("desc1").value=x1.trim();	
	}
}
</script>
<style>
#popup
{
	width:1000px;
	height:390px;
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
<s:if test="%{formbean==null}">
<body onload="show();partlist();getnarration();ccode1();ccode();"><center>
</s:if>
<s:else>
<body onload="ccode();ccode1();"><center>
</s:else>
<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Debit Note</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
<div style="position:fixed;top:160px;bottom: 45px;overflow-y:auto;width:100%" align="center">   
    <s:form action="debitnotecreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
    
  
  <div id="popup" style="display:none">
  <div align="right">
  	<img id="image" src="Image/popupclose.png" height="2%" width="2%" onclick="closepopup();"></img>
  </div>
  	<center>
  		Please Select Bill/Invoice/DrNote/CrNote/Journal And Fill-Up Amount
  	</center>
  	<br>
  	<div id="divtable">
  	<table id="table1" border="0" width="100%">
  	<tr align="center" bgcolor="#4292b2" style="color:white;">
  		<td></td>
  		<td>Document Ref. No.</td>
  		<td>Date</td>
  		<td>Bill Amount</td>
  		<td>Adjusted</td>
  		<td>Dues Amount</td>
  		<td>Amount</td>
  	</tr>
  	<s:if test="%{formbean==null}">
  	<tr>
  		<td><input type="checkbox" name="chk"></input></td>
  		<td><s:textfield name="formbean.doref" id="doref" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px"></s:textfield></td>
  		<td><s:textfield name="formbean.dat" id="dat" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.billamount" id="billamount" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.adjusted" id="adjusted" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.dues" id="dues" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.amount1" id="amount" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  	</tr>
  	</s:if>
  	<s:else>
  	<%int i=0; %>
  	<s:iterator value="formbean.doref" status="status" >
  	<tr>
  		<td><input type="checkbox" name="chk"></input></td>
  		<td><s:textfield name="formbean.doref[%{#status.count-1}]" id="doref" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:250px"></s:textfield></td>
  		<td><s:textfield name="formbean.dat[%{#status.count-1}]" id="dat" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.billamount[%{#status.count-1}]" id="billamount" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.adjusted[%{#status.count-1}]" id="adjusted" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.dues[%{#status.count-1}]" id="dues" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  		<td><s:textfield name="formbean.amount1[%{#status.count-1}]" id="amount" style="color:red;background:transparant;border:0;" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:135px"></s:textfield></td>
  	</tr>
  	<%i++; %>
  	</s:iterator>
  	</s:else>
  	</table>
  	</div>
  	<p align="right">
  	<label>Total Amount:- </label><s:textfield name="formbean.tamount" id="tamount" readonly="true"></s:textfield>
  	</p>
  	
  	<input type="button" value="Add More Field" Class="butStnd" onclick="addRow('table1'); return validate1();"></input>
    <input type="button" value="Delete Fields" Class="butStnd" onclick="deleteRow('table1');"></input>
    <input type="button" value="Save" id="close" class="butStnd" onclick="todummy();justcopy()"></input>
  </div>

<fieldset style="width:60%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Account Debit Note</h3></legend>
  <div align="left">
  <s:label>Serial No:</s:label>&nbsp;<s:textfield name="formbean.srno" id="srno" style="border:0px" readonly="true"/>
  </div>
  
  <div align="right">
  <s:label id="day1"></s:label><br>
  <s:textfield type="text" id="showdate" name="formbean.showdate" style="border:none;width:70px;background:#FFFF99"></s:textfield>
  
  </div>
  
  <div align="left">
  <s:label>Debit Account</s:label>
  <s:select name="formbean.part1" list="usList2" id="part1" listKey="part1" value="formbean.part1" listValue="part1" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;border:0px solid" onchange="ccode1();partlist();showdraft();" tabindex="2"/>
  <font color="red"><label id="crbal"></label></font><br>
  
  
  </div>
  
  <br>
  
  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
 <br>
  
  <table width="100%" border="0" id="table">
  	   <tr align="center" bgcolor="#4292b2" style="color:white;">
  	   		<td width="12.5%" height="20"></td>
  	   		<td width="12.5%" style="padding-right:5px"><label><b>Particulars</b></label></td>
  	   		
  	   		<td style="padding-right:5px"></td>
  	   		
  	   		<td width="12.5%" style=""><label><b>Credit&nbsp;Amount</b></label></td>
  	   		<td width="12.5%" style="padding-right:5px"><label><b>Narration</b></label></td>
  	   </tr>
  	   
  	  <s:if test="%{formbean==null}">
  	   <tr style="border:1px">
  	   		<td width="12.5%" style="padding-right:5px"><input type="checkbox" name="chk"></input></td>
  	   		<td width="12.5%" style="padding-right:5px"><s:select name="formbean.partforcontra" list="usList1" id="part" listKey="part" value="formbean.part" listValue="part" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;" onchange="ccode();" tabindex="2"/></td>
  	   		
  	   		<td style="padding-right:5px"><div style="width:110px"><s:textfield name="partcrbal" id="partcrbal" style="color:red;background:transparant;border:0;" readonly="true"></s:textfield></div></td>
  	   		
  	   		<td width="12.5%" style=""><s:textfield name="formbean.credit" id="credit" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onkeyup="test12();PersonViewModel(this);"></s:textfield></td>
  	   		<td width="12.5%" style="padding-right:5px"><s:textfield name="formbean.narration" id="narration" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;" onblur="showpopup()"></s:textfield></td>
  	   </tr>
  	   </s:if>
  	   
  	   <s:else>
  	   <%int i=0; %>
  	   <s:iterator value="formbean.narration" status="status" >
  	   <tr>
  	   		<td width="12.5%" style="padding-right:5px"><input type="checkbox" name="chk"></input></td>
  	   		<td width="12.5%" style="padding-right:5px"><s:select name="formbean.partforcontra" list="usList1" id="part" listKey="part" cssClass="part" value="formbean.quantity[#status.index]" listValue="part" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:205px;" onchange="ccode();" tabindex="2"/> <input type="hidden" name="formbean.contra1" class="contra1" id="contra1"></input></td>
  	   		
  	   		<td style="padding-right:5px"><div style="width:110px"><s:textfield name="partcrbal" id="partcrbal" style="color:red;background:transparant;border:0;" readonly="true"></s:textfield></div></td>
  	   		
  	   		<td width="12.5%" style=""><s:textfield name="formbean.credit[%{#status.count-1}]" id="credit" size="25" cssClass="sourav" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;;text-align:right" onkeyup="test12a();PersonViewModel(this);"></s:textfield> <input type="hidden" name="formbean.credithidden" class="credithidden" id="credithidden"></input></td>
  	   		<td width="12.5%" style="padding-right:5px"><s:textfield name="formbean.narration[%{#status.count-1}]" id="narration" size="25" cssClass="nar" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;" onblur="showpopup()"></s:textfield> <input type="hidden" name="formbean.narration1" class="narration1"/></td>
  	  </tr>
  	   <%i++; %>
  	   </s:iterator>
  	   </s:else>
  </table>

  <div align="right">
  <label>Total Amount:- </label><s:textfield type="text" id="totalam" name="formbean.total" readonly="true" style="border:none;color:red"></s:textfield>
  </div>
  
  <br>
  <table align="right">
  	<tr>
  		<td colspan="2" align="center">Ref. No. And Date</td>
  	</tr>
  	<tr>
  		<td><s:textfield name="formbean.contraref" placeholder="ref no" Style="height:20px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
  		<td><s:textfield name="formbean.contradate" id="contradate" placeholder="yyyy-mm-dd" Style="height:20px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
  	</tr>
  	
  	<tr>
  		<td style="display:none;" id="hello"><u>Draft No:</u></td>
  		<td style="display:none;" id="hello1"><input type="text" name="formbean.draftno" Style="height:20px;border:1px solid #ccc;background:#FFFF99"></input></td>
  		
  	</tr>
  </table>
  
  
  <div align="left">Narration Master:-
  <s:select name="formbean.prenar" id="prenar" list="usList3" listKey="prenar" value="formbean.prenar" listValue="prenar" cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;width:150px;" onchange="getnarration()"></s:select>
  </div>
  
  <div align="left" id="dna">
 <s:textarea name="formbean.desc1" id="desc1" cols="50" rows="4" maxlength="275" cssStyle="border:1px solid #ccc;background:#FFFF99;resize:none;border:0px solid"></s:textarea>
 <a href="ledgerlist" accesskey="c"></a><!-- create ledger hot key-->
  </div>
  
   	  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:7px;">
       
        <input type="button" value="Add More Field" Class="butStnd" onclick="addRow('table'); return validate1();"></input>
        <input type="button" value="Delete Fields" Class="butStnd" onclick="deleteRow('table');"></input>
        
      	<s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="copycredit();return abc();return Validate();" ></s:submit>
        
      </div>
           
    </s:form>
  </fieldset>
	
	<p>&nbsp;</p>
	<s:if test="usList">
	<div id="ram">
	<display:table id="table12"  name="usList" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:100%;color:#000">
	    
	 <s:if test="%{#attr.table12.id == formbean.id}">
	 
	 <display:column property="part1"   title="Particular"  style="background-color:#ecf2f6;"  sortable="false" headerClass="sortable" />
    
    <display:column property="voucher"   title="Voucher No."  style="background-color:#ecf2f6;"  sortable="false" headerClass="sortable" />
	 
    <display:column property="showdate"   title="Entry Date"  style="background-color:#ecf2f6;"  sortable="false" headerClass="sortable" />
	
	<display:column property="contraref"   title="Ref. No." style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="contradate"   title="Ref. Date." style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="total"   title="Total" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="debitnoteupdate" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="debitnotedelete" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
    <display:column title="Print" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="./Body/transaction_print/debitnoteprint.jsp?id=<s:property value="%{#attr.table12.id}" />" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname" onclick="">Print</a>
    </display:column>
	</s:if>
	<s:else>
		 
	<display:column property="part1"   title="Particular"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
    
    <display:column property="voucher"   title="Voucher No."  style="background-color:#fff;"  sortable="false" headerClass="sortable" />	 
		 
    <display:column property="showdate"   title="Entry Date"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
	
	<display:column property="contraref"   title="Ref. No." style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="contradate"   title="Ref. Date." style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="total"   title="Total" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="debitnoteupdate" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="debitnotedelete" namespace="/" ><s:param  name="id" value="%{#attr.table12.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
     <display:column title="Print" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="./Body/transaction_print/debitnoteprint.jsp?id=<s:property value="%{#attr.table12.id}" />" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname" onclick="">Print</a>
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
</center>
</div>
</body>
</html>
