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

#inspect_btn_dialog
{
	display: none;
}

#inspect_btn_dialog1
{
	display: none;
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


<script language="javascript" type="text/javascript">	
	function change2()
{
	//alert("hello");
	
	
	var y=document.getElementsByClassName("nameofitems");
	var x=document.getElementsByClassName("nameofitems1");
	
	 var n=document.getElementsByClassName("pack");
	var m=document.getElementsByClassName("pack5"); 
	
	var p=document.getElementsByClassName("case3");
	var o=document.getElementsByClassName("case5"); 
	
	var r=document.getElementsByClassName("pcs");
	var q=document.getElementsByClassName("pcs5"); 
	
	var t=document.getElementsByClassName("free");
	var s=document.getElementsByClassName("free5");
	
	 var v=document.getElementsByClassName("mrp");
	var u=document.getElementsByClassName("mrp5"); 
	
	var b=document.getElementsByClassName("ratec");
	var a=document.getElementsByClassName("ratec5"); 
	
	var d=document.getElementsByClassName("ratep");
	var c=document.getElementsByClassName("ratep5"); 
	
	var f=document.getElementsByClassName("ammount");
	var e=document.getElementsByClassName("ammount5");
	
	var x=document.getElementsByClassName("tax");
	var y=document.getElementsByClassName("tax11");
	
	var z=document.getElementsByClassName("gstp");
	var w=document.getElementsByClassName("gstp1");
	
	//(y.length);
	

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
		
		
		
		
		}
	
	
	
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
img.ui-datepicker-trigger {position:absolute; margin-top:6px; margin-left:-22px;}

#ui-datepicker-div .ui-state-highlight {color: #dce6ee;}

#ui-datepicker-div.ui-datepicker-control {background: blue;}


.ui-dialog-titlebar{ 
    background: #FFCC66 repeat-x;
    color:#fff;      
}
</style>





</head>
<script>

function suncre()
{
	//alert();
	 if (typeof XMLHttpRequest != "undefined") {
		xmlHttp002 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp002 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp002 == null) {
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1 =document.getElementById("creditors").value;
	//alert('S1: '+s1);
	//var s = document.getElementById("section").value;
	//var s = document.getElementById("source").value;
	//document.getElementById("newspaperadd").value = s;
	var url = "./Body/inventory_transaction/suncre.jsp";
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
		//alert(x1);
		
		
		document.getElementById("cre").value=x1;
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
<script>
function code()
{
	//alert();
	 if (typeof XMLHttpRequest != "undefined") {
		xmlHttp003 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp003 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp003 == null) {
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1 =document.getElementById("company").value;
	//alert('S1: '+s1);
	//var s = document.getElementById("section").value;
	//var s = document.getElementById("source").value;
	//document.getElementById("newspaperadd").value = s;
	var url = "./Body/inventory_transaction/comp.jsp";
	url += "?count=" + s1; // + "&sec=" + s;
	//url +="?count=" +str+"&date1="+s;
	xmlHttp003.onreadystatechange = codeAdd35;
	xmlHttp003.open("GET", url, true);
	xmlHttp003.send(null);
	
};

function codeAdd35() {
	if (xmlHttp003.readyState == 4 || xmlHttp003.readyState == "complete") 
	{

		
		var x1=xmlHttp003.responseText;
	//	alert(x1);
		
		
		document.getElementById("cp").value=x1;
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
<script language="javascript" type="text/javascript"> 
 var lc=rowIndex;
 var lc1=rowIndex1;
// var s;
//alert(lc);
 function PersonViewModel(x) {
	 
	    rowIndex = $(x).closest('tr').index();
	   // s = s11;
	    //alert("part_code"+s);
	    
	  // alert("Row index is: " + rowIndex);
	  
	}
 
 function PersonViewModel1(x) {
	 
	    rowIndex1 = $(x).closest('tr').index();
	   // s = s11;
	    //alert("part_code"+s);
	    
	   //alert("dynamic Row index is: " + rowIndex1);
	  
	}
 
 
 

 
 
 
 
 
 
 
 
 function showdiv1()
 {
	var lc=rowIndex;
	// var lc1=rowIndex1;
 	 	//("Row Id: "+lc);
 	if (typeof XMLHttpRequest != "undefined")
     {
         abatch = new XMLHttpRequest();
     }
     else if (window.ActiveXObject)
     {
     	abatch = new ActiveXObject("Microsoft.XMLHTTP");
     }
     if (abatch == null)
     {
         alert("Browser does not support XMLHTTP Request");
         return;
     }
   
     var matname=document.getElementsByClassName("nameofitems");
    var arcode=document.getElementById("nameofarea");
     
   //  var repl=document.getElementsByClassName("replacement");
    
     var url = "./Body/inventory_transaction/meteriallistvalue1.jsp";
     url += "?count=" + matname[lc-1].value;
    // alert(url);
     
     abatch.onreadystatechange = codeabatch;
     abatch.open("GET", url, true);
     abatch.send(null);
 	//$("#popup1").fadeIn();
     //$("#popup1").css({"visibility":"visible","display":"block"});
     
     document.getElementById("noi9").value= matname[lc-1].value;
     
     
     
     
 }
 function codeabatch()
 {
 	if (abatch.readyState == 4 || abatch.readyState == "complete")
     {
 		var lc=rowIndex;
 		var x2=abatch.responseText;
 		
 		
 		var x1=x2.split("bubun");
 		
 		var pk= document.getElementById("pack9");
 		pk.value=x1[1];
 		
 		var pk1=document.getElementsByClassName("pack");
 		pk1[lc-1].value=x1[1];
 		
 		var en=document.getElementById("ins");
 		en.value=x1[4];
 		
 		//(x2);
 		//alert(x1[1]);
 		document.getElementById("table2").innerHTML=x1[0].trim();
 		$( "#inspect_btn_dialog" ).dialog("open");
 	    
 		//document.getElementById("packing").value=x1[1];
 		//(x1[2]);
 		//document.getElementById("tax").value=x1[2];
 		
 		
 		var tx=document.getElementsByClassName("tax");
 		
 		tx[lc-1].value=x1[2];
 		
 		var pur=document.getElementById("purcode");
 		
 		pur.value=x1[3];
     }
 }
 
 
 function copyvalue()
 { 
	 var lc=rowIndex;
	 var lc1=rowIndex1;
	//("Row Id for copying value: "+lc+" for dynamic row id:  "+(lc1));
 var mrp=document.getElementsByClassName("mrp1");
/*  var scase=document.getElementsByClassName("scase");
 var spcs=document.getElementsByClassName("spcs");
 var total=document.getElementsByClassName("stotal"); */
 var rtcase=document.getElementsByClassName("rtcase");
 var rtpcss=document.getElementsByClassName("rtpcs");
 
// alert(mrp[lc-1].value+","+scase[lc-1].value+","+spcs[lc-1].value+","+total[lc-1].value+","+rtcase[lc-1].value+","+rtpcss[lc-1].value);
//for setting dynamic row value
 var scasee=document.getElementsByClassName("ratec");
 var spcss=document.getElementsByClassName("ratep");
 var mrpp=document.getElementsByClassName("mrp");
 //for static row value
 /* var total1=document.getElementById("total");
 var rtcase1=document.getElementById("casee");
 var rtpcss1=document.getElementById("pcss");
  */
 scasee[(lc1-1)].value=rtcase[lc-1].value;
 //alert("check: "+scasee[lc1-1].value);
 spcss[lc1-1].value=rtpcss[lc-1].value;
 
 mrpp[lc1-1].value=mrp[lc-1].value;
 
 //alert("hi: "+scase[lc-1]+","+spcs1[lc-1].value+","+mrp1[lc-1].value+","+total1.value+","+rtcase1.value+","+rtpcss1.value);
 
 /* total1.value=total[lc-1].value;
 rtcase1.value=scase[lc-1].value;
 rtpcss1.value=spcs[lc-1].value;
  */
 
 
 
 
 }
 
 function fadeout(){
		//alert();
		var lc=rowIndex;
		//alert("Row Id for fade out: "+lc);
		$( "#inspect_btn_dialog" ).dialog("close");
		return false;	
		
 }
 
 function itemcpy()
 {
 	
 	var lc=rowIndex;
 	//(lc);
 	
 	var mrp=document.getElementById("mrp19").value;
 	
 	var mrp1=document.getElementsByClassName("mrp");
 	
 	mrp1[lc-1].value=mrp;
 	
 	
 	var lpc1=document.getElementById("pcase9").value;
 	
 	var rtc=document.getElementsByClassName("ratec");
 	rtc[lc-1].value=lpc1;
 	
 	var pcs=document.getElementById("pcs9").value;
 	
 	var rtp=document.getElementsByClassName("ratep");
 	rtp[lc-1].value=pcs;
 	
 	
 }
 </script>
<script language="javascript" type="text/javascript">
function qtypop(){
	$( "#inspect_btn_dialog" ).dialog("open");
	return true;
	
}
	
	


function popup1()
{
//();
	$( "#inspect_btn_dialog1" ).dialog("open");
	return true;
}

function fadeout1()
{
	$( "#inspect_btn_dialog1" ).dialog("close");
	return true;
}
	</script>
	
	
	<script>
function getname1()
{
        //alert();
        if (typeof XMLHttpRequest != "undefined")
        {
                cname = new XMLHttpRequest();
        } else if (window.ActiveXObject)
        {
                cname = new ActiveXObject("Microsoft.XMLHTTP");
        }
        if (cname == null)
        {
                alert("Browser does not support XMLHTTP Request");
                return;
        }
        var s1 =document.getElementById("cp").value;

        var url = "./Body/inventory_transaction/getname1.jsp";
        url += "?count=" + s1; // + "&sec=" + s;
      //  alert(url);
        //url +="?count=" +str+"&date1="+s;
        cname.onreadystatechange = codecname;
        cname.open("GET", url, true);
        cname.send(null);
}
function codecname()
{
        if (cname.readyState == 4 || cname.readyState == "complete")
        {
                var x1=cname.responseText;
             // alert(x1);
                document.getElementById("nameofitems").innerHTML=x1.trim();
                document.getElementById("noi4").innerHTML=x1.trim();
        }
};

</script>

<script>
function fncal()
{
	
	
	 var lc=rowIndex;
	 //var lc1=rowIndex1;
	 
	 var scasee=document.getElementsByClassName("ratec");
	 var spcss=document.getElementsByClassName("ratep");
	 var mrpp=document.getElementsByClassName("mrp").value;
	
	 var cs=document.getElementsByClassName("case3");
	 
	 var pc=document.getElementsByClassName("pcs");
	
	 var am=document.getElementsByClassName("ammount");
	/*  var am= ; */
	 
	
	var a= scasee[lc-1].value * cs[lc-1].value;
	 
	var b= spcss[lc-1].value * pc[lc-1].value;
	
	var sum1= Number(a) + Number(b);
	
	
	
	am[lc-1].value= sum1.toFixed(2); 
	 
	 //document.getElementByClassName("ammount").value[lc-1]= sum1;
	 
var tt= document.getElementsByClassName("ammount");


var su=0;

	 for(var i=0;i < tt.length;i++)
		 {
		
		 	su=Number(su) + Number(tt[i].value);
		 	
		 	
		 	
		 }
	 
	
	 
	 document.getElementById("grossamt").value=su.toFixed(2);
	 
	 
}



function taxcal()
{
	//alert();
	 var lc=rowIndex;
	 
	 var a = document.getElementsByClassName("ammount");
	 var b = document.getElementsByClassName("tax");
	 var c = document.getElementsByClassName("gstp");
	 
      var r=Number(b[lc-1].value)/100*Number(a[lc-1].value);
      
      c[lc-1].value=r.toFixed(2);
      
	
}



function famt()
{
	var m=document.getElementById("grossamt").value;
	var n=document.getElementById("lessamt").value;
	var o=document.getElementById("addamount").value;
	var p=document.getElementById("sgst").value;
	var q=document.getElementById("cgst").value;
	var r=document.getElementById("igst").value;
	
	//(m);
	
	var min=0;
	
	var sum2=Number(m)+Number(o)+Number(p)+Number(q)+Number(r);	
	//(sum2);
	min= sum2 - Number(n);
		
	document.getElementById("billamt").value = min.toFixed(2);
	
	
	
}









</script>

<script>
function createcode()

{
	var id=document.getElementById("id").value;
	
	var nul="";
	
	if(id==nul)
		{
				var a=document.getElementById("vou").value;
				var b=document.getElementById("date").value;
				
				var c= b.split("-");
				var d= c[0].substring(2,4);
				var f= d;
				var e= Number(f)+1;
				
				var g=d+e;
				var pre= "PU";
				var str=""+d;
				var fin2= c[2]+c[1]+str;
				/* alert(fin2); */
				var fin= pre+g;
				var kk="";
				var fina= fin+fin2;+""+a;
				
				
				
				if(Number(a) < 10)
					{
						 kk=fin2+"00"+a;
					}
				else if((a > 10) && (a<100))
					{
						kk=fin2+"0"+a;	
					}
				else
					{
						kk=fin2+""+a;
					}
				
				document.getElementById("vouno").value=kk;
	
		}
	
	else
		{
				
		}
	
	//();
	//alert(b);
	
}


</script>


<script>
function vouchercreate()
{
	//();
	 if (typeof XMLHttpRequest != "undefined") {
		xmlHttp004 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp004 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp004 == null) {
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	//var s1 =document.getElementById("company").value;
	//alert('S1: '+s1);
	//var s = document.getElementById("section").value;
	//var s = document.getElementById("source").value;
	//document.getElementById("newspaperadd").value = s;
	var url = "./Body/inventory_transaction/vouch.jsp";
	url += "?count="; // + "&sec=" + s;
	//url +="?count=" +str+"&date1="+s;
	xmlHttp004.onreadystatechange = codeAdd36;
	xmlHttp004.open("GET", url, true);
	xmlHttp004.send(null);
	
};

function codeAdd36() {
	if (xmlHttp004.readyState == 4 || xmlHttp004.readyState == "complete") 
	{

		
		var x1=xmlHttp004.responseText;
		//alert(x1);
		
		
		document.getElementById("vou").value=x1;
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

 <script language="javascript" type="text/javascript">
	function sttype1()
	{
		if (typeof XMLHttpRequest != "undefined") 
		{
			xmlHttp006 = new XMLHttpRequest();
		}
		else if (window.ActiveXObject) 
		{
			xmlHttp006 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp006 == null) 
		{
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("cp").value;//get subgroupname
	
		var url = "./Body/inventory_transaction/sttype.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;

		xmlHttp006.onreadystatechange = codeAdd64;
		xmlHttp006.open("GET", url, true);
		xmlHttp006.send(null);
	}
	function codeAdd64() 
	{
		if (xmlHttp006.readyState == 4 || xmlHttp005.readyState == "complete") 
		{			
			var x1=xmlHttp006.responseText;
			document.getElementById("sttype").value=x1;		
		}
	};
</script>

<script>

function gst2(){
	
	var a = "InterState";
	var b = "IntraState";
	var check = document.getElementById("sttype").value;
	var c = document.getElementById("sgst").value;
	var d = document.getElementById("cgst").value;
	var e = document.getElementById("igst").value;
	var f = document.getElementById("sttype").value;
	var x = 0;
	if(check==a)
	{
		
		x=Number(f)/2;
		
		 document.getElementById("sgst").value=x;
		 document.getElementById("cgst").value=x;
		
		
	}
	else
	{
		x=Number(f);
		
		document.getElementById("igst").value=x;
		
	}
	
	
	
	
	
	
	
	
}


</script>

<script>


function innvalue1()
	
	{
	 
		
		  var amount=document.getElementsByClassName("ammount");
		 
		 var gstp=document.getElementsByClassName("gstp");
		 var tax=document.getElementsByClassName("tax");
		 var sttype=document.getElementById("sttype").value; 
	
	

		  var buffer="<table>";
		  buffer=buffer+"<tr> <th>ON AMOUNT</th><th>SGST @</th><th>SGST AMOUNT</th><th>CGST @</th><th>CGST AMOUNT</th><th>IGST @</th><th>IGST AMOUNT</th><th>GST TOTAL AMT</th></tr>"
		  var totala=0;
		  var totaltax=0;
			
		  var stotalam1=0,stotalam11=0,stotalam2=0,stotalam22=0;stotalam3=0,stotalam33=0;stotalam4=0,stotalam44=0;stotalam5=0,stotalam55=0;
		  var stogstam1=0,stogstam11=0,stogstam2=0,stogstam22=0,stogstam3=0,stogstam33=0,stogstam4=0,stogstam44=0,stogstam5=0,stogstam55=0;
		  var count1=0,count2=0,count3=0,count4=0,count4=0,count5=0;
		  var tax1="";tax2="",tax3="",tax4="",tax5="";
		  var tax11=0;tax22=0,tax33=0,tax44=0,tax55=0;
		  //alert("length: "+buffer+","+totaldiscount.length+","+totaldiscount[lc-1].value+","+tax[lc-1].value);
		 // alert("length: "+totaldiscount.length);
		 
		  
		   for(var i=0;i<amount.length;i++)
			   {
			   //alert(gstp[i].value+tax[i].value+sttype[i].value);
			   	if(tax[i].value=="18")
			   	 {
			   		alert("18");
			   		count1=count1+1;
			   		
			   		stotalam1=stotalam1+Number(amount[i].value);
			   		stogstam1=stogstam1+Number(gstp[i].value);
			   		tax1=tax[i].value;
			   	  totala=totala+Number(amount[i].value);
			      totaltax=totaltax+Number(gstp[i].value);
			   		//alert("18: "+count1+","+stotalam1+","+stogstam1+","+tax1);
			   		
			     }
			   	else if(tax[i].value=="5")
			   	 {
			   		alert("5");
			   		count2=count2+1;
			   		stotalam2=stotalam2+Number(amount[i].value);
			   		stogstam2=stogstam2+Number(gstp[i].value);
			   		tax2=tax[i].value;
			   	  totala=totala+Number(amount[i].value);
			      totaltax=totaltax+Number(gstp[i].value);
			     }
			   	else if(tax[i].value=="12")
			   	 {
			   		alert("12");
			   		count3=count3+1;
			   		stotalam3=stotalam3+Number(amount[i].value);
			   		stogstam3=stogstam3+Number(gstp[i].value);
			   		tax3=tax[i].value;
			   	  totala=totala+Number(amount[i].value);
			      totaltax=totaltax+Number(gstp[i].value);
			     }
			   	else if(tax[i].value=="28")
			   		{
			   		alert("28");
			   		count4=count4+1;
			   		stotalam4=stotalam4+Number(amount[i].value);
			   		stogstam4=stogstam4+Number(gstp[i].value);;
			   		tax4=tax[i].value;
			   	  totala=totala+Number(amount[i].value);
			      totaltax=totaltax+Number(gstp[i].value);
			   		}
			   //	alert("hello");
			     else
			   {
			  // alert("0");
		   		count5=count5+1;
		   		stotalam5=stotalam5+Number(amount[i].value);
		   		//stogstam5=stogstam5+Number(gstp[i].value);;
		   		tax5=tax[i].value;
		   	 // totala=totala+Number(totaldiscount[i].value);
		      //totaltax=totaltax+Number(gstp[i].value);
			   }
			   	
			   }
		 
		   
		  
		  if(tax1=="18")
				   {
				   
				  //alert("outloop length: "+count1);
				   
				   if(sttype.trim()=="IntraState")
					   {
					   
					    stogstam11=Number(stogstam1) / 2;
					    tax11=Number(tax1) / 2;
					   buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam1+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
			    		  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+tax11+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
				    	  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+stogstam11+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
				    	  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+tax11+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
				    	  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+stogstam11+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
				    	  +"<td><input type='text' name='formbean.igst' class='igst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
				    	  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
				    	  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam1+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
			 		  
					   }
				   	else if(sttype.trim()=="InterState")
					   {
							buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam1+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    					  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    				  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    				  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    				  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    				  +"<td><input type='text' name='formbean.igst' class='igst' value="+tax1+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    				  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+stogstam1+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
		    				  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam1+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
	 		  
				  
					   }
				   }
		  
			  if(tax2=="5")
			   {
			   
			  //alert("outloop length: "+count2);
			  if(sttype.trim()=="IntraState")
			   {
			   
			    stogstam22=Number(stogstam2) / 2;
			    tax22=Number(tax2) / 2;
			 	  buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam2+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    		  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+tax22+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+stogstam22+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+tax22+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+stogstam22+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +"<td><input type='text' name='formbean.igst' class='igst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
		    	  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam2+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
	 		  
			  	 }
			  
					else if(sttype.trim()=="InterState")
				   {
		   
					buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam2+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
   		 		    +"<td><input type='text' name='formbean.sgst' class='sgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	 	   	    +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.cgst' class='cgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+" <td><input type='text' name='formbean.acgst' class='acgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+"<td><input type='text' name='formbean.igst' class='igst' value="+tax2+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.aigst' class='aigst' value="+stogstam2+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
	    	  			+"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam2+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
		  
				   }
			   }
			  
			  if(tax3=="12")
			   {
			   
			   //alert("outloop length: "+count3);
			   if(sttype.trim()=="IntraState")
			   {
			   
			    stogstam33=Number(stogstam3) / 2;
			    tax33=Number(tax3) / 2;
			 	  buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam3+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    		  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+tax33+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+stogstam33+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+tax33+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+stogstam33+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +"<td><input type='text' name='formbean.igst' class='igst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
		    	  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam3+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
	 		  
			  	 }
					else if(sttype.trim()=="InterState")
				   {
		   
					buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam3+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
   		 		    +"<td><input type='text' name='formbean.sgst' class='sgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	 	   	    +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.cgst' class='cgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+" <td><input type='text' name='formbean.acgst' class='acgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+"<td><input type='text' name='formbean.igst' class='igst' value="+tax3+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.aigst' class='aigst' value="+stogstam3+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
	    	  			+"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam3+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
		  
			  	 }
			   }
			  
			  if(tax4=="28")
			   {
			   
			   alert("outloop length: "+count4);
			   if(sttype.trim() =="IntraState")
			   {
			   
			    stogstam44=Number(stogstam4) / 2;
			    tax44=Number(tax4) / 2;
			 	  buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam4+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    		  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+tax44+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+stogstam44+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+tax44+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+stogstam44+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +"<td><input type='text' name='formbean.igst' class='igst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
		    	  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam4+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
	 		  
			  	 }
					else if(sttype.trim()=="InterState")
				   {
		   
					buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam4+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
   		 		    +"<td><input type='text' name='formbean.sgst' class='sgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	 	   	    +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.cgst' class='cgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+" <td><input type='text' name='formbean.acgst' class='acgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+"<td><input type='text' name='formbean.igst' class='igst' value="+tax4+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.aigst' class='aigst' value="+stogstam4+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
	    	  			+"<td><input type='text' name='formbean.gamount' class='gamount' value="+stogstam4+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
		  
			   }
			   }
			  
			  if(tax5=="0")
			   {
			   
			   //alert("outloop length: "+count5);
			   if(sttype.trim()=="IntraState")
			   {
			   
			    stogstam55=Number(stogstam5) / 2;
			    tax55=Number(tax5) / 2;
			 	  buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    		  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+tax5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"NO TAX AMOUNT"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+tax5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+"NO TAX AMOUNT"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
		    	  +"<td><input type='text' name='formbean.igst' class='igst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    	  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
		    	  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+"NO GST AMOUNT"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
	 		 
			  	 }
			   else if(sttype.trim()=="InterState")
			   {
					buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
   		 		    +"<td><input type='text' name='formbean.sgst' class='sgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	 	   	    +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.cgst' class='cgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+" <td><input type='text' name='formbean.acgst' class='acgst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
	    	  			+"<td><input type='text' name='formbean.igst' class='igst' value="+tax5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
	    	  			+"<td><input type='text' name='formbean.aigst' class='aigst' value="+"0"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
	    	  			+"<td><input type='text' name='formbean.gamount' class='gamount' value="+"0"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
		  
			   }
		   }
			
   		
   		buffer=buffer+"<tr><td><label><b>Total Amount</b></label></td><td></td><td></td><td></td><td></td><td></td><td></td><td><label><b>Total GST@%</b></label></td></tr><tr><td><input type='text' name='formbean.tooamount' class='tooamount' value="+totala.toFixed(2)+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td><td></td><td></td><td></td><td></td><td></td><td></td><td><input type='text' name='formbean.toogst' class='toogst' value="+totaltax.toFixed(2)+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td></tr>"
		    
		    
		    
		 buffer=buffer+"</table>";
		//alert(buffer);
		 document.getElementById("table3").innerHTML=buffer;
		 if(sttype.trim()=="IntraState")
			 {
			 var totaltaxx=totaltax / 2;
			 document.getElementById("sgst").value=totaltaxx.toFixed(2);
			 document.getElementById("cgst").value=totaltaxx.toFixed(2);
			 document.getElementById("igst").value="";
			 }
		 
		 else if(sttype.trim()=="InterState")
		 {
			 document.getElementById("igst").value=totaltax.toFixed(2);
			 document.getElementById("sgst").value="";
			 document.getElementById("cgst").value="";
		 }

	}

	
 
 





</script>
<script>
	
	function op()
	{
		$( "#inspect_btn_dialog1" ).dialog("open");
	}


</script>

<script>
/* function purcode1()
{
	alert("ramuuuuuuu");
	
	 if (typeof XMLHttpRequest != "undefined") 
	{
		xmlHttp07 = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) 
	{
		xmlHttp07 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlHttp07 == null) 
	{
		alert("Browser does not support XMLHTTP Request");
		return;
	}
	var s1 =document.getElementById("nameofitems").value;//get subgroupname
alert(s1);
	var url = "./Body/inventory_transaction/purcode.jsp";
	url += "?count=" + s1;
	alert(url);// + "&sec=" + s;
	//url +="?count=" +str+"&date1="+s;

	xmlHttp07.onreadystatechange = codeAdd065;
	xmlHttp07.open("GET", url, true);
	xmlHttp07.send(null); 
	
	
}

function codeAdd065() 
{
	if (xmlHttp07.readyState == 4 || xmlHttp07.readyState == "complete") 
	{	
		alert("hello");
		var m=xmlHttp07.responseText;
		alert("ki: "+m);
		
		document.getElementById("purcode").value=x1;		
	}
};
 */




</script>

<script>
function opp()
{
	
	//alert();
	var x = document.getElementById('rupu');
	
	  if (x.style.display === 'none') {
	        x.style.display = 'block';
	    } else {
	        x.style.display = 'none';
	    }
}


</script>

<script>
function cal1()
{
	var a=document.getElementById("pcs9");
	var b=document.getElementById("pcase9").value;
	var c=document.getElementById("pack9").value;
	var d= Number(b)/Number(c);
	a.value=d;

	
	
	
	}


function cal2()
{
	var a=document.getElementById("stotal9");
	var b=document.getElementById("pack9").value;
	var c=document.getElementById("scase9").value;
	var e=document.getElementById("spcs9").value;
	var d= Number(b)*Number(c)+Number(e);
	a.value=d;

	
	
	
	}


function cal3()
{
	var a=document.getElementById("rtpcs9");
	var b=document.getElementById("pack9").value;
	var c=document.getElementById("rtcase9").value;
	//var e=document.getElementById("spcs9").value;
	
	
	
	var d = Number(c) / Number(b);
	a.value=d;

	
	
	
	}

function cal4()
{
	var a=document.getElementById("vrtcase9").value;
	var b=document.getElementById("pack9").value;
	var c=document.getElementById("vrtpcs9");
		var d =Number(a)/Number(b) ;
	c.value=d;

	
	
	
	}








</script>
<script>
/* function PersonViewModel2(x) {
	 
    rowIndex1 = $(x).closest('tr').index();
   // s = s11;
    //alert("part_code"+s);
    
   alert("dynamic Row index is: " + rowIndex1);
  
} */

/* function itemcpy()
{
	
	var lc=rowIndex;
	
	var mrp=document.getElementById("mrp19").value;
	
	var mrp1=document.getElementsByClassName("mrp");
	
	mrp1[lc-1].value=mrp;
	
	
	var lpc=document.getElementById("pcase9").value;
	alert(lpc);
	var rtc=document.getElementByClassName("ratec");
	rtc[lc-1].value=lpc;
	
	var pcs=document.getElementById("pcs").value;
	var rtp=document.getElementByClassName("ratep");
	rtp[lc-1].value=pcs;
	
	
} */




</script>





 
 




<body><center>

<sj:dialog
        id="inspect_btn_dialog"
        autoOpen="false"
        modal="true"
        title="M.R.P. AND STOCK DETAILS OF :"
        width="810"
        height="340"
        draggable="true"
        resizable="false"
        onCloseTopics="inspect_btn_dialog"
  
    >
    
   
    <fieldset style="width:100%; border:solid thin #c6d5e1;margin-top:2px">
    <legend style="color:red;">Material Details</legend>  
    <div class="welcome" id="comprin4" align="center"></div>  
  <!--  <div style="top:200px;bottom:155px;overflow-y:auto;width:1146px;padding:3px;height:250px;" align="center"> -->
  <table id="table2" border="0" width="52%">
  		<tr>
  			
	  		<th>M.R.P</th>
	  		<th>ST. CASE</th>
	  		<th>ST. PCS</th>
	  		<th>TOTAL</th>
	  		<th>SL. CASE</th>
	  		<th>SL. PCS</th>
	  		
  		</tr>
  		<tr>
  			
	  		<td><div align="center"><s:textfield name="formbean.mrp1" cssClass="mrp1" id="mrp1" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.scase" cssClass="scase" id="scase" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.spcs" cssClass="spcs" id="spcs" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calaqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.stotal" cssClass="stotal" id="stotal" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calfqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rtcase" cssClass="rtcase" id="rtcase" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rtpcs" cssClass="rtpcs" id="rtpcs" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calamount();calpopupamount();"></s:textfield></div></td>
	  		
	  	</tr>
  </table>
   
    <!-- <div align="right" style="width:95%; position:relative;  padding:10px;">
		
 		<input type="button" id="saveButton"  value="Save" Class="myButton" onclick="fadeout();costvalue();sync();" />
 		
 		
      </div> -->
     </fieldset>
    
    </sj:dialog>
    
    <sj:dialog
        id="inspect_btn_dialog1"
        autoOpen="false"
        modal="true"
        title="Display Board :"
        width="1010"
        height="280"
        draggable="true"
        resizable="false"
        onCloseTopics="inspect_btn_dialog1"
  
    >
    
   
    <fieldset style="width:100%; border:solid thin #c6d5e1;margin-top:2px">
    <legend style="color:red;">Display Board</legend>  
    <div class="welcome" id="comprin4" align="center"></div>  
  <!--  <div style="top:200px;bottom:155px;overflow-y:auto;width:1146px;padding:3px;height:250px;" align="center"> -->
  <table id="table3" border="0" width="52%">
  		
  </table>
   
   <div align="middle" style="width:95%; position:relative;  padding:10px;">
		
 		<input type="button" id="saveButton"  value="Close Popup" Class="myButton"  onclick="fadeout1();costvalue();sync();" />
 		
 		
      </div> 
     </fieldset>
    
    </sj:dialog>

<div>





<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Purchase Entry</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
    
  <fieldset style="width:40%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>ENTRY OF CREDIT PURCHASE INVOICE</h3></legend>
  
  <s:form action="purchasecreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" id="id" value="<s:property value="formbean.id"/>"/>
  <input type="hidden" name="formbean.cre" id="cre" value="<s:property value="formbean.cre"/>"/>
  <input type="text" name="formbean.vou" id="vou" value="<s:property value="formbean.vou"/>"/>
  <input type="hidden" name="formbean.sttype" id="sttype" value="<s:property value="formbean.sttype"/>"/>
  <input type="hidden" name="formbean.purcode" id="purcode" value="<s:property value="formbean.purcode"/>"/>
   <input type="hidden" name="formbean.ins" id="ins" value="<s:property value="formbean.ins"/>"/>
  
  <table cellpadding="5" width="50%" style="padding:5px">  
 
  		
       	
       	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Company&nbsp;</label></td>
			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.company" id="company" cssClass="company" list="usList"  listValue="company" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onblur="code();"></sj:autocompleter></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><input type="text" name="formbean.cp" id="cp" value="<s:property value="formbean.cp"/>"/></td>
        
         
          <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        
       </tr>
        
        
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Creditors&nbsp;</label></td>
			<td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.creditors" id="creditors" list="usList2"  listValue="creditors" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onblur="suncre();vouchercreate();sttype1();" onfocus="getname1();"></sj:autocompleter></td>
            

            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="10.5%" style="padding-left:15px; padding-right:15px;"></td>
       <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Date</label></td>
        	<td width="13.5%" style="padding-left:15px; padding-right:15px;" valign="top"><sj:datepicker name="formbean.date" id="date" size="20" buttonImageOnly="true" displayFormat="yy-mm-dd" value="today" showButton="false"  changeYear="true" changeMonth="true" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onclick="view();"/></td></tr>
         </tr>
       
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Invoice&nbsp;No</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.invoiceno" id="invoiceno" cssClass="invoiceno"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="10.5%" style="padding-left:15px; padding-right:15px;"></td>
       <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Invoice&nbsp;Dated</label></td>
        	<td width="13.5%" style="padding-left:15px; padding-right:15px;" valign="top"><sj:datepicker name="formbean.dated" id="dated" cssClass="dated" size="20" buttonImageOnly="true" displayFormat="yy-mm-dd" showButton="false"  changeYear="true" changeMonth="true"  cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99"   onclick="view();"/></td></tr>
         
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Vou.&nbsp;No.</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.vouno" id="vouno" cssClass="sunit" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onfocus="createcode();"></s:textfield></td>     	
        </tr>
      
         <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Invoice&nbsp;Value&nbsp;Rs.</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.invoicevaluers" id="invoicevaluers" cssClass="companyname"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
             <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        
       </tr>
         
         
       
       </table>
   
  
   
   
 
        
   
   
   
 
   
   
   <fieldset style="width:30%; border:solid thin #c6d5e1;Padding:5px;">
    <legend style="color:red;">press alt-A for Account creation</legend>
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
        <th width="9%" style="font-size:11.2px">Name Of Items</th>
        <th width="9%" style="font-size:11.2px">PACK</th>     
        <th width="9%" style="font-size:11.2px">CASE</th>
        <th width="9%" style="font-size:11.2px">PCS</th>
        <th width="9%" style="font-size:11.2px">FREE</th>     
        <th width="9%" style="font-size:11.2px">M.R.P</th>
        <th width="9%" style="font-size:11.2px">RATE(C)</th>
        <th width="9%" style="font-size:11.2px">RATE(P)</th>
        <th width="9%" style="font-size:11.2px">AMMOUNT</th>
        <th width="9%" style="font-size:11.2px">GST@</th>
        <th width="9%" style="font-size:11.2px">GST AMOUNT</th>
        
    </tr>
      <s:if test="%{formbean==null}">
    <tr>
    
        <td  width="2%"><input type="checkbox" name="chk"/></td>
        
        
        <td width="9%" style="font-size:14px"> <s:select name="formbean.nameofitems"   id="nameofitems" list="#{'':''}"  cssClass="nameofitems"  cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;height:20px;width:200px;" onchange="PersonViewModel(this);PersonViewModel1(this);showdiv1();"></s:select></td>
		
		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pack" id="pack" cssClass="pack" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);setcpartcode();setcdesccode();setcmakecode();"></s:textfield></td>	    

		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.case3" id="case3" cssClass="case3"  size="8" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcs" id="pcs" cssClass="pcs"  size="14" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.free" id="free" cssClass="free" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield></td>
        
         <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp" id="mrp" cssClass="mrp"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);unitratte();"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.ratec" id="ratec" cssClass="ratec" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield></td>
        	 
   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.ratep" id="ratep" cssClass="ratep"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.ammount" id="ammount" cssClass="ammount" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99"    onfocus="fncal(); taxcal();" onfocusout="PersonViewModel(this);amountt(); "></s:textfield></td>
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.tax1" id="tax" cssClass="tax" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.gstp" id="gstp" cssClass="gstp" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onblur="addRow('table1');genSerial();incr();"></s:textfield></td>
       	 
       
       </tr>
    </s:if>
    <s:else>
     <s:iterator value="formbean.nameofitems" status="status">
     	 <tr>
    
        <td  width="2%"><input type="checkbox" name="chk"/></td>
        
                      
        <td width="9%" style="font-size:14px">  <s:select name="formbean.nameofitems" list="usList3" id="nameofitems" cssClass="nameofitems" listKey="part" value="formbean.nameofitems[#status.index]" listValue="part" cssStyle="height:20px;border:1px solid #ccc;width:225px;background:#FFFF99" tabindex="2" onchange="PersonViewModel(this);PersonViewModel1(this);showdiv1(); " /><input type="hidden" name="formbean.formbean.nameofitems1" class="formbean.nameofitems1"></input>	</td>
        
        <%-- <td width="9%" style="font-size:14px"><s:textfield name="formbean.noi[%{#status.count-1}]" id="noi" cssClass="noi" size="6" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;" ></s:textfield><input type="hidden" name="formbean.nameofitems" id="noi5" class="noi5"></input></td> --%>
		
		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pack[%{#status.count-1}]" id="pack" cssClass="pack" size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);setcpartcode();setcdesccode();setcmakecode();"></s:textfield><input type="hidden" name="formbean.pack5" id="pack5" class="pack5"></input></td>	    

		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.case3[%{#status.count-1}]" id="case3" cssClass="case3"  size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.case5" id="case5" class="case5"></input></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcs[%{#status.count-1}]" id="pcs" cssClass="pcs"  size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield><input type="hidden" name="formbean.pcs5" id="pcs5" class="pcs5"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.free[%{#status.count-1}]" id="free" cssClass="free" size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield><input type="hidden" name="formbean.free5" id="free5" class="free5"></input></td>
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp[%{#status.count-1}]" id="mrp" cssClass="mrp"  size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.mrp5" id="mrp5" class="mrp5"></input></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.ratec[%{#status.count-1}]" id="ratec" cssClass="ratec"  size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield><input type="hidden" name="formbean.ratec5" id="ratec5" class="ratec5"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.ratep[%{#status.count-1}]" id="ratep" cssClass="ratep" size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield><input type="hidden" name="formbean.ratep5" id="ratep5" class="ratep5"></input></td>
        
         <td width="9%" style="font-size:14px"><s:textfield name="formbean.ammount[%{#status.count-1}]" id="ammount" cssClass="ammount" size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99"  onfocus="fncal(); taxcal();" onfocusout="PersonViewModel(this);amountt(); "></s:textfield><input type="hidden" name="formbean.ammount5" id="ammount5" class="ammount5"></input></td>
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.tax1[%{#status.count-1}]" id="tax" cssClass="tax" size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.tax11" id="tax11" class="tax11"></input></td> 
       	  <td width="9%" style="font-size:14px"><s:textfield name="formbean.gstp[%{#status.count-1}]" id="gstp" cssClass="gstp"  onblur="addRow('table1');genSerial();incr();" size="12" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.gstp1" id="gstp1" class="gstp1"></input></td>	 	        
       </tr>
     </s:iterator>
    </s:else>   
       
      
	</table> 
	
	    <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:6px;">
      <!--  <input type="button" value="add" Class="butStnd" onclick="addRow('table1');genSerial();incr();"/> -->
       <input type="button" value="delete" Class="butStnd" onclick="deleteRow('table1');"/>
	
	
       
      
      </div>
      
      <div align="center"> 
      
      	 <input type="button" value="details" Class="butStnd" onclick="innvalue1();op(); "/>
      	  <input type="button" value="AddNew" Class="butStnd" onclick="opp(); "/>
      	 
       </div>
      </fieldset>
      
      <div id="rupu" style="display:none;">
     <!--  <div> -->
       <fieldset style="width:30%; border:solid thin #c6d5e1;Padding:5px;">
      
			      <table cellspacing="0" border="0" width="50%" id='table9'>
			      		<tr style="background-color:#4292b2;color:white;" align="center">
			      		 <th  width="2%"></th>
			      		 <th width="9%" style="font-size:11.2px">NAME&nbsp;OF&nbsp;ITEMS</th>
			      		 <th width="9%" style="font-size:11.2px">PACK</th>
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
					    <!--  <th width="9%" style="font-size:11.2px">TAX.</th> -->
					     <th width="9%" style="font-size:11.2px">DIST.</th>
					     <th width="9%" style="font-size:11.2px">PRICE</th> 
								      
			      
			</tr>      
			      
			      			<tr>
			    
			        <td  width="2%"><input type="checkbox" name="chk"/></td>
			
				<td width="9%" style="font-size:14px"><s:textfield name="formbean.noi9" id="noi9"  cssClass="noi99" size="13" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;" ></s:textfield></td> 
			        
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pack9" id="pack9"  cssClass="pack9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;"  ></s:textfield></td>
			       
				 <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcase9" id="pcase9"  cssClass="pcase9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;"  onfocusout="cal1();" ></s:textfield></td>
					
					
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcs9" id="pcs9" cssClass="pcs9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="setcpartcode();setcdesccode();setcmakecode();"></s:textfield></td>	    
			
					
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp19" id="mrp19" cssClass="mrp19"  size="8" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
			        
			        
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.scase9" id="scase9" cssClass="scase9"  size="14" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="cal2();"></s:textfield></td>
			        	 
			        
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.spcs9" id="spcs9" cssClass="spcs9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="cal2();"></s:textfield></td>
			        
			         <td width="9%" style="font-size:14px"><s:textfield name="formbean.stotal9" id="stotal9" cssClass="stotal9"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
			        	 
			        
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.rtcase9" id="rtcase9" cssClass="rtcase9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup=""></s:textfield></td>
			        	 
			   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.vrtcase9" id="vrtcase9" cssClass="vrtcase9"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="div2();"></s:textfield></td>
			        	 
			        
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.rtpcs9" id="rtpcs9" cssClass="rtpcs9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="cal3();"></s:textfield></td>
			       	 
			       	 <td width="9%" style="font-size:14px"><s:textfield name="formbean.vrtpcs9" id="vrtpcs9" cssClass="vrtpcs9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="cal4();"></s:textfield></td>
			        
			        
			         <%-- <td width="9%" style="font-size:14px"><s:textfield name="formbean.tax9" id="tax9" cssClass="tax" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);amountt();"></s:textfield></td> --%> 	 
			        
			        	 
			   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.dist9" id="dist9" cssClass="dist9"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield></td>
			       
			        
			        <td width="9%" style="font-size:14px"><s:textfield name="formbean.price9" id="price9" cssClass="price9" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="amountt();"></s:textfield></td>
			       		        
			</tr> 
			      
			      
			      
			      
			      </table>
      
      
      	 <input type="button" value="add" Class="butStnd" onclick="addRow('table9');genSerial();incr();"/>
       		<input type="button" value="delete" Class="butStnd" onclick="deleteRow('table9');"/>
       		<input type="button" value="save" Class="butStnd" onclick="itemcpy();"/>
       		
      
      </fieldset>
      
      </div>
      
      
      
      
      
      
      
      
<!--    <fieldset style="width:100%; border:solid thin #c6d5e1;Padding:5px;"> -->
  	<table cellspacing="0" border="0" width="80%">
  	<tr>
  	
  	  	    <td width="12.5%" style="padding-left:15px; padding-right:15px;"> </td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 		 
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 		 
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 		 
        
   <td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Gross&nbsp;Amt</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.grossamt" id="grossamt" size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
     </tr>
     
     
     	<tr>
  		    <td width="12.5%" style="padding-left:15px; padding-right:15px;"> </td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 		 
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        			 
            		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
                	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        			 
             		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
                 	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Less&nbsp;Amt</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.lessamt" id="lessamt"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
     </tr>
     
     
     	     	<tr>
  	 
        	  
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"> </td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
      	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 
        	
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Add&nbsp;Amount</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.addamount" id="addamount"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
     </tr>
          	<tr>
  	 	 
        	    <td width="12.5%" style="padding-left:15px; padding-right:15px;"> </td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	   <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        
  		<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>SGST@</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sgst" id="sgst"  cssClass="sgst"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
     </tr>
          	<tr>
  	 	 
        	   
        	   <td width="12.5%" style="padding-left:15px; padding-right:15px;"> </td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>CGST@</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.cgst" id="cgst" cssclass="cgst"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
     </tr>
     
     
     
     <tr>
  	 	  
        	 	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>                                                                                      
        	
  <td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>IGST@</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.igst" id="igst" csslass="igst"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
           
     </tr>
  
     
          	<tr>
  	 	  
        	 	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        		 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>                                                                                      
        	
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Bill&nbsp;Amt</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billamt" id="billamt" size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onfocus="famt();" forceValidOption="false"></s:textfield></td>
            
     </tr>
     
  
  	</table>
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
 <!--  </fieldset> -->
  
  
   <div align="right" style="width:99%;position:relative;  padding:7px;">
    <s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="change2();" ></s:submit>
  </div>
   	 
   	  
     
      
      
      

      
    </s:form>
  </fieldset>
  
 
  
	
	 <p>&nbsp;</p>
	<s:if test="usList1">
	<div id="ram">
	<display:table id="table"  name="usList1" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:75%;color:#000">
	    
	 <s:if test="%{#attr.table.id == formbean.id}">
	
	<display:column property="invoicevaluers"   title="Invoice Value rs." style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="vouno"   title="Vou.No"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="dated"   title="Dated" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="purchaseupdate1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="purchasedelete1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	<s:else>
	
	<display:column property="invoicevaluers"   title="Invoice Value rs." style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="vouno"   title="Vou.No"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="dated"   title="Dated" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="purchaseupdate1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="purchasedelete1" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
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
