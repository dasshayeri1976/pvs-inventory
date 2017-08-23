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
 
 <script language="javascript" type="text/javascript">	
	function change2()
{
	//alert("hello");
	
	
	var y=document.getElementsByClassName("nameofitems");
	var x=document.getElementsByClassName("nameofitems1");
	
	 var n=document.getElementsByClassName("case4");
	var m=document.getElementsByClassName("case5"); 
	
	var p=document.getElementsByClassName("pcs4");
	var o=document.getElementsByClassName("pcs5"); 
	
	var r=document.getElementsByClassName("fp");
	var q=document.getElementsByClassName("fp1"); 
	
	var t=document.getElementsByClassName("mrp4");
	var s=document.getElementsByClassName("mrp5");
	
	 var v=document.getElementsByClassName("rate");
	var u=document.getElementsByClassName("rate4"); 
	
	var b=document.getElementsByClassName("discs");
	var a=document.getElementsByClassName("discs4"); 
	
	var d=document.getElementsByClassName("dis");
	var c=document.getElementsByClassName("dis4"); 
	
	var f=document.getElementsByClassName("amount4");
	var e=document.getElementsByClassName("amount5");
	
	
     var vv=document.getElementsByClassName("total11");
	var uu=document.getElementsByClassName("total111"); 
		
	var bb=document.getElementsByClassName("todiscount");
	var aa=document.getElementsByClassName("todiscount1"); 
		
	var dd=document.getElementsByClassName("tytax");
	var cc=document.getElementsByClassName("tytax1"); 
		
	var ff=document.getElementsByClassName("gstper");
	var ee=document.getElementsByClassName("gstper1");

	 
	
	//alert(y.length);
	

	for(var i=0;i<=y.length;i++)
		{
		
		//alert("start:"+vv[i].value+","+bb[i].value+","+dd[i].value+","+ff[i].value);
		//alert("end:"+vv[i].value+","+bb[i].value+","+dd[i].value+","+ff[i].value);
		x[i].value=y[i].value;
		
		
		
		
		m[i].value=n[i].value;
		
		o[i].value=p[i].value;
		
		q[i].value=r[i].value;
		
		s[i].value=t[i].value;
		
		u[i].value=v[i].value;
		
		a[i].value=b[i].value;
		
		c[i].value=d[i].value;
		
		e[i].value=f[i].value; 
		
		 uu[i].value=vv[i].value;
		aa[i].value=bb[i].value;
		cc[i].value=dd[i].value;
		ee[i].value=ff[i].value; 
		//alert(y[i].value);
		
		
		
		
		}
	
	
	
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

#inspect_btn_dialog
{
	display: none;
}
#inspect_btn_dialog1
{
	display: none;
}

.ui-dialog {top: 90% !important;
left: 50% !important;
transform: translateX(-50%) translateY(-90%) !important;
-o-transform: translateX(-50%) translateY(-90%) !important;
-ms-transform: translateX(-50%) translateY(-90%) !important;
-moz-transform: translateX(-50%) translateY(-90%) !important;
-webkit-transform: translateX(-50%) translateY(-90%) !important;
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
	function salecode() {
		//alert(a);
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp011 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp011 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp011 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("salesmanname1").value;
		
		var url = "./Body/inventory_transaction/salecode.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		//alert(url);
		xmlHttp011.onreadystatechange = codeAdd041;
		xmlHttp011.open("GET", url, true);
		xmlHttp011.send(null);
		
	};

	function codeAdd041() {
		if (xmlHttp011.readyState == 4 || xmlHttp011.readyState == "complete") 
		{

			
			var x1=xmlHttp011.responseText;
			document.getElementById("salesmanname").value=x1;
			//alert(x1);
			
		}
	};
</script>
<script language="javascript" type="text/javascript">
	function areacode() {
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
		var s1 =document.getElementById("nameofarea1").value;
		
		var url = "./Body/inventory_transaction/areacode.jsp";
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
			document.getElementById("nameofarea").value=x1;
			//alert(x1);
			
		}
	};
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
	
	
	function getcity1()
	{
	        //alert();
	        if (typeof XMLHttpRequest != "undefined")
	        {
	                cname1 = new XMLHttpRequest();
	        } else if (window.ActiveXObject)
	        {
	                cname1 = new ActiveXObject("Microsoft.XMLHTTP");
	        }
	        if (cname1 == null)
	        {
	                alert("Browser does not support XMLHTTP Request");
	                return;
	        }
	        var s1 =document.getElementById("nameofarea1").value;

	        var url = "./Body/inventory_transaction/getcity.jsp";
	        url += "?count=" + s1; // + "&sec=" + s;
	     //  alert(url);
	     // alert("hello");
	        //url +="?count=" +str+"&date1="+s;
	        cname1.onreadystatechange = codecname1;
	        cname1.open("GET", url, true);
	        cname1.send(null);
	}
	function codecname1()
	{
	        if (cname1.readyState == 4 || cname1.readyState == "complete")
	        {
	        	
	        	//alert("hello");
	                var x1=cname1.responseText;
	             // alert(x1);
	                document.getElementById("retailername1").innerHTML=x1.trim();
	        }
	};
	
	
	
	function padress()
	{
		
		//alert();
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp0021 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp0021 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp0021 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("retailername1").value;
		//alert('S1: '+s1);
		
		var url = "./Body/inventory_transaction/paddress.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		//alert(url);
		xmlHttp0021.onreadystatechange = codeAdd23;
		xmlHttp0021.open("GET", url, true);
		xmlHttp0021.send(null);
		
	};

	function codeAdd23() {
		if (xmlHttp0021.readyState == 4 || xmlHttp0021.readyState == "complete") 
		{

			//alert(x1);
			var x1=xmlHttp0021.responseText;
		//	alert(x1);
			var x=x1.split(",");
			document.getElementById("retailername").value=x[0];
			document.getElementById("address").value=x[1];

		}
	};
	
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
        var s1 =document.getElementById("nameofarea").value;

        var url = "./Body/inventory_transaction/getname.jsp";
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
 	 	//alert("Row Id: "+lc1);
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
     var s1 =document.getElementById("nameofarea").value;
     var s2=document.getElementById("type1").value;
     //alert("value: "+s1);
   //  var repl=document.getElementsByClassName("replacement");
    
     var url = "./Body/inventory_transaction/meteriallistvalue3.jsp";
     url += "?count=" + matname[lc-1].value+"bubun"+s1+"bubun"+s2;
     //alert(url);
     
     abatch.onreadystatechange = codeabatch;
     abatch.open("GET", url, true);
     abatch.send(null);
 	//$("#popup1").fadeIn();
     //$("#popup1").css({"visibility":"visible","display":"block"});
 }
 function codeabatch()
 {
 	if (abatch.readyState == 4 || abatch.readyState == "complete")
     {
 		var x2=abatch.responseText;
 		 var lc1=rowIndex1;
 		var lc=rowIndex;
 		// alert("row: "+lc);
 		
 		var x1=x2.split("bubun");
 		
 		//alert(x1[6]+","+x1[7]);
 		var mrpp=document.getElementsByClassName("mrp4");
 		 var rate1=document.getElementsByClassName("rate");
 		document.getElementById("table1").innerHTML=x1[0];
 		if(x1[6] > 1)
 		{
 			
 			$( "#inspect_btn_dialog" ).dialog("open");
 		}
 		else if(x1[6] == 1)
 			{
 			// alert("hi");
 			 
 			mrpp[lc1-1].value=x1[7];
 			 rate1[lc1-1].value=x1[8];
 			//alert("Got value: "+mrpp[lc1-1].value+","+ rate1[lc1-1].value);
 			}
 	
 		 
 		
 		
 	    
 		document.getElementById("packing").value=x1[1];
 		document.getElementById("casee").value=x1[2];
 		document.getElementById("pcss").value=x1[3];
 		document.getElementById("total").value=x1[4];
 		//alert(x1[5]);
 		var tax=document.getElementsByClassName("tytax");
 		tax[lc-1].value=x1[5];
 		
 		
 		 
     }
 }
 
 
 function copyvalue()
 { 
	 var lc=rowIndex;
	 var lc1=rowIndex1;
	//alert("Row Id for copying value: "+lc+" for dynamic row id:  "+(lc1));
 var mrp=document.getElementsByClassName("mrp1");
// var scase=document.getElementsByClassName("scase");
// var spcs=document.getElementsByClassName("spcs");
// var total=document.getElementsByClassName("stotal");
// var rtcase=document.getElementsByClassName("rtcase");
// var rtpcss=document.getElementsByClassName("rtpcs");
 var ratee=document.getElementsByClassName("rate1");
 //alert("Rate value"+ratee[lc-1].value)
// alert(mrp[lc-1].value+","+scase[lc-1].value+","+spcs[lc-1].value+","+total[lc-1].value+","+rtcase[lc-1].value+","+rtpcss[lc-1].value);

 //for setting dynamic row value
// var scasee=document.getElementsByClassName("case4");
// var spcss=document.getElementsByClassName("pcs4");
 var mrpp=document.getElementsByClassName("mrp4");
 var rate1=document.getElementsByClassName("rate");
 //for static row value
 var total1=document.getElementById("total");
 var rtcase1=document.getElementById("casee");
 var rtpcss1=document.getElementById("pcss");
 
 
 //scasee[(lc1-1)].value=rtcase[lc-1].value;
 //alert("check: "+scasee[lc1-1].value);
 //spcss[lc1-1].value=rtpcss[lc-1].value;
 
 mrpp[lc1-1].value=mrp[lc-1].value;
 rate1[lc1-1].value=ratee[lc-1].value;
 
 //alert("hi: "+scase[lc-1]+","+spcs1[lc-1].value+","+mrp1[lc-1].value+","+total1.value+","+rtcase1.value+","+rtpcss1.value);
 
// total1.value=total[lc-1].value;
 //rtcase1.value=scase[lc-1].value;
 //rtpcss1.value=spcs[lc-1].value;
 
 
 
 
 
 }
  function totaldis()
 {
	 //var lc=rowIndex;
	 //alert();
	
	var grossamt=document.getElementById("gamount");
	var discount=document.getElementById("discount1");
	var total1=document.getElementById("subtotal");
	total1.value=Number(grossamt.value)-Number(discount.value);
	
	var sgst1=document.getElementById("sgst").value;

	 var cgst1=document.getElementById("cgst").value;
	 var igst1=document.getElementById("igst").value;
	 var add1=document.getElementById("add").value;
	 var netamt1=document.getElementById("netamount").value;
 } 
 

 function discou()
 {
	 var lc=rowIndex;
	// alert("row: "+lc);
	// var amountresult1=0;
	 var case1=document.getElementsByClassName("case4");
	 var dis1=document.getElementsByClassName("discs");
	 var amount1=document.getElementsByClassName("total11");
	 var pdis=document.getElementsByClassName("dis");
	 var netamount=document.getElementsByClassName("amount4");
	 var discase=Number(case1[lc-1].value)*Number(dis1[lc-1].value);
	 amount1[lc-1].value=discase;
	 //calculation for percentage:
	 var mulper=Number(netamount[lc-1].value) * Number(pdis[lc-1].value);
     var percentage=mulper / 100;
    // alert(percentage.toFixed(2)+",dis/cs "+amount1[lc-1].value);
     amount1[lc-1].value=Number(amount1[lc-1].value) + Number(percentage.toFixed(2));
	 
 }
 
 function pdiscou()
 {
	 var lc=rowIndex;
	// alert("row: "+lc);
	 var percentage=0;
	 var case1=document.getElementsByClassName("case4");
	 var dis1=document.getElementsByClassName("discs");
	 var pdis=document.getElementsByClassName("dis");
	 var netamount=document.getElementsByClassName("amount4");
	 var amount1=document.getElementsByClassName("total11");
	 
	 
	 var tamount=document.getElementsByClassName("amount4");
     var todiscount=document.getElementsByClassName("total11");
     var totaldis=document.getElementsByClassName("todiscount");
	 var total=0;
	 
	 var discase=Number(case1[lc-1].value)*Number(dis1[lc-1].value);
	 
	 
	 amount1[lc-1].value=discase;
	 
	 //calculation for percentage:
		 var mulper=Number(netamount[lc-1].value) * Number(pdis[lc-1].value);
	     var percentage=mulper / 100;
	    // alert(percentage.toFixed(2)+",dis/cs "+amount1[lc-1].value);
	     amount1[lc-1].value=Number(amount1[lc-1].value) + Number(percentage.toFixed(2));
	     
	    // alert("hello: tamount: "+tamount[lc-1].value+", tdiscount: "+todiscount[lc-1].value);
	     total=Number(tamount[lc-1].value) - Number(todiscount[lc-1].value);
	     
	     totaldis[lc-1].value=total.toFixed(2);
 }
 
 
 function casetotal(){
	 var lc=rowIndex;
	 //alert("row id: "+lc);
	var scasee=document.getElementsByClassName("case4");
	 var mrpp=document.getElementsByClassName("rate");
	 var result=document.getElementsByClassName("amount4");
	 var pcss=document.getElementsByClassName("pcs4");
	 var packing=document.getElementById("packing");
	 var amount1=document.getElementsByClassName("total11");
	 var pdis=document.getElementsByClassName("dis");
	 var dis1=document.getElementsByClassName("discs");
	 
	 
	
	 
	// alert("alert: "+scasee[lc-1].value+","+mrpp[lc-1].value);
	 var total=0;
	 var casevalue=Number(pcss[lc-1].value) / Number(packing.value);
	// alert("case value: "+casevalue.toFixed(2)+"rate value: "+mrpp[lc-1].value+"amount"+result[lc-1].value);
	 result[lc-1].value=(Number(scasee[lc-1].value) * Number(mrpp[lc-1].value));
	total=Number(result[lc-1].value)+(casevalue.toFixed(2) * Number(mrpp[lc-1].value));
	 result[lc-1].value=total;
	 
	 //for discount case/cs
	 var discase=Number(scasee[lc-1].value)*Number(dis1[lc-1].value);
	 amount1[lc-1].value=discase;
	 
	 //calculation for total amount percentage:
		 var mulper=Number(result[lc-1].value) * Number(pdis[lc-1].value);
	     var percentage=mulper / 100;
	    // alert(percentage.toFixed(2)+",dis/cs "+amount1[lc-1].value);
	     amount1[lc-1].value=Number(amount1[lc-1].value) + Number(percentage.toFixed(2));
	 
	 
	 
 }
 
 function pcstotal(){
	
	 var lc=rowIndex; 
	 
	 var scasee=document.getElementsByClassName("case4");
	 var mrpp=document.getElementsByClassName("rate");
	 var pcss=document.getElementsByClassName("pcs4");
	 var packing=document.getElementById("packing");
	 var result=document.getElementsByClassName("amount4");
	 var amount1=document.getElementsByClassName("total11");
	 var pdis=document.getElementsByClassName("dis");
	 var dis1=document.getElementsByClassName("discs");
	 result[lc-1].value="";
	// alert("row id: "+lc);
	var total=0;
	 var casevalue=Number(pcss[lc-1].value) / Number(packing.value);
	// alert("case value: "+casevalue.toFixed(2)+"rate value: "+mrpp[lc-1].value+"amount"+result[lc-1].value);
	 result[lc-1].value=(Number(scasee[lc-1].value) * Number(mrpp[lc-1].value));
	 total=Number(result[lc-1].value)+(casevalue.toFixed(2) * Number(mrpp[lc-1].value));
	 result[lc-1].value=total;
	 
	 
	 //for discount case/cs
	 var discase=Number(scasee[lc-1].value)*Number(dis1[lc-1].value);
	 amount1[lc-1].value=discase;
	 
	 //calculation for total amount percentage:
		 var mulper=Number(result[lc-1].value) * Number(pdis[lc-1].value);
	     var percentage=mulper / 100;
	    // alert(percentage.toFixed(2)+",dis/cs "+amount1[lc-1].value);
	     amount1[lc-1].value=Number(amount1[lc-1].value) + Number(percentage.toFixed(2));
	 
 }
 
 function tototal()
 {
 	
     var s=document.getElementsByClassName("amount4");
     var total=0;
     for(var i=0;i<s.length;i++)
     {
         total=total+Number(s[i].value);
     }
     document.getElementById("totalamt").value=total.toFixed(2);
     document.getElementById("gamount").value=total.toFixed(2);
     
 }
 

 
 
 function distotal()
 {
 	//alert("helo");
 	 var lc=rowIndex; 
     var s=document.getElementsByClassName("total11");
     var tamount=document.getElementsByClassName("totalamt");
     var todiscount=document.getElementsByClassName("discount");
     var totaldiscount=document.getElementsByClassName("todiscount");
     var total=0;
     
     var total=0;
     for(var i=0;i<s.length;i++)
     {
         total=total+Number(s[i].value);
     }
     document.getElementById("discount").value=total.toFixed(2);
     document.getElementById("discount1").value=total.toFixed(2);
   
     
     
     
 }
 function avi(s)
 {
 	var lc=rowIndex;
 	var location = confirm("Do you want to add another row?");
 	 if (location == true)
 	        {
 		 		addRow('table111');
 	        }
 	        else
 	        {
 	        	var a=document.getElementsByClassName("disc");
 	        	popup1();
 	        	innvalue1();
 	        	a[lc-1].focus();
 	        	
 	      		//return false;
 	        }
  }
 
 function innvalue1()
	{
		
		//alert();
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp0 = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp0 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp0 == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}
		var s1 =document.getElementById("retailername").value;
		//alert('S1: '+s1);
		
		var url = "./Body/inventory_transaction/popup.jsp";
		url += "?count=" + s1; // + "&sec=" + s;
		//url +="?count=" +str+"&date1="+s;
		//alert(url);
		xmlHttp0.onreadystatechange = codeAdd2;
		xmlHttp0.open("GET", url, true);
		xmlHttp0.send(null);
		
	};

	function codeAdd2() {
		if (xmlHttp0.readyState == 4 || xmlHttp0.readyState == "complete") 
		{
			
			
			// alert("hello");
			var x1=xmlHttp0.responseText;
			//alert(x1);
			
			 var totaldiscount=document.getElementsByClassName("todiscount");
			 
			 var tax=document.getElementsByClassName("tytax");
			 var gstp=document.getElementsByClassName("gstper");
			
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
			   for(var i=0;i<totaldiscount.length;i++)
				   {
				   	if(tax[i].value=="18")
				   	 {
				   		
				   		count1=count1+1;
				   		//alert("18");
				   		stotalam1=stotalam1+Number(totaldiscount[i].value);
				   		stogstam1=stogstam1+Number(gstp[i].value);
				   		tax1=tax[i].value;
				   	  totala=totala+Number(totaldiscount[i].value);
				      totaltax=totaltax+Number(gstp[i].value);
				   		//alert("18: "+count1+","+stotalam1+","+stogstam1+","+tax1);
				   		
				     }
				   	else if(tax[i].value=="5")
				   	 {
				   		//alert("5");
				   		count2=count2+1;
				   		stotalam2=stotalam2+Number(totaldiscount[i].value);
				   		stogstam2=stogstam2+Number(gstp[i].value);
				   		tax2=tax[i].value;
				   	  totala=totala+Number(totaldiscount[i].value);
				      totaltax=totaltax+Number(gstp[i].value);
				     }
				   	else if(tax[i].value=="12")
				   	 {
				   		//alert("12");
				   		count3=count3+1;
				   		stotalam3=stotalam3+Number(totaldiscount[i].value);
				   		stogstam3=stogstam3+Number(gstp[i].value);
				   		tax3=tax[i].value;
				   	  totala=totala+Number(totaldiscount[i].value);
				      totaltax=totaltax+Number(gstp[i].value);
				     }
				   	else if(tax[i].value=="28")
				   		{
				   		//alert("28");
				   		count4=count4+1;
				   		stotalam4=stotalam4+Number(totaldiscount[i].value);
				   		stogstam4=stogstam4+Number(gstp[i].value);;
				   		tax4=tax[i].value;
				   	  totala=totala+Number(totaldiscount[i].value);
				      totaltax=totaltax+Number(gstp[i].value);
				   		}
				   //	alert("hello");
				     else
				   {
				   //alert("0");
			   		count5=count5+1;
			   		stotalam5=stotalam5+Number(totaldiscount[i].value);
			   		//stogstam5=stogstam5+Number(gstp[i].value);;
			   		tax5=tax[i].value;
			   	  totala=totala+Number(totaldiscount[i].value);
			      //totaltax=totaltax+Number(gstp[i].value);
				   }
				   	
				   }
			 
			   
			  
			  if(tax1=="18")
					   {
					   
					 //  alert("outloop length: "+count1);
					   
					   if(x1.trim()=="IntraState")
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
					   	else if(x1.trim()=="InterState")
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
				   
				  // alert("outloop length: "+count2);
				  if(x1.trim()=="IntraState")
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
						else if(x1.trim()=="InterState")
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
				   if(x1.trim()=="IntraState")
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
						else if(x1.trim()=="InterState")
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
				   
				 //  alert("outloop length: "+count4);
				   if(x1.trim()=="IntraState")
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
						else if(x1.trim()=="InterState")
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
				   if(x1.trim()=="IntraState")
				   {
				   
				    stogstam55=Number(stogstam5) / 2;
				    tax55=Number(tax5) / 2;
				 	  buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+stotalam5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
		    		  +"<td><input type='text' name='formbean.sgst' class='sgst' value="+tax5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
			    	  +" <td><input type='text' name='formbean.asgst' class='asgst' value="+"0"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
			    	  +"<td><input type='text' name='formbean.cgst' class='cgst' value="+tax5+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
			    	  +" <td><input type='text' name='formbean.acgst' class='acgst' value="+"0"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td>"
			    	  +"<td><input type='text' name='formbean.igst' class='igst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>"
			    	  +"<td><input type='text' name='formbean.aigst' class='aigst' value="+"NA"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>" 
			    	  +"<td><input type='text' name='formbean.gamount' class='gamount' value="+"0"+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
		 		 
				  	 }
				   else if(x1.trim()=="InterState")
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
			
			 document.getElementById("table3").innerHTML=buffer;
			 if(x1.trim()=="IntraState")
				 {
				 var totaltaxx=totaltax / 2;
				 document.getElementById("sgst").value=totaltaxx.toFixed(2);
				 document.getElementById("cgst").value=totaltaxx.toFixed(2);
				 document.getElementById("igst").value=0;
				 }
			 
			 else if(x1.trim()=="InterState")
			 {
				 document.getElementById("igst").value=totaltax.toFixed(2);
				 document.getElementById("sgst").value=0;
				 document.getElementById("cgst").value=0;
			 }
			 
			var amount=document.getElementById("gamount").value;
			var dis=document.getElementById("discount1").value;
			 var stotal=amount - dis;
			 document.getElementById("subtotal").value=stotal.toFixed(2);
		
		}
	};
	
	function ram(x)
	{
		
	    var a=document.getElementById("subtotal").value;
	    var b=document.getElementById("igst").value;
	    var c=document.getElementById("cgst").value;
	    var d=document.getElementById("sgst").value;
	   // alert(x);
	    if(x=="1")
	    {
	    	//alert(x);
	    	var e=Number(a) + Number(b) + Number(c) + Number(d); 
	    	//alert("sum: "+e.toFixed(2));
	        var rr=Math.round(Number(e.toFixed(2)));
	        var z=Number(rr)-Number(e.toFixed(2));
	       // z= Math.abs(z);
	       // alert(z);
	        var m=Number(e.toFixed(2))+Number(z.toFixed(2));
	        //alert(rr+","+z.toFixed(2)+","+m);
	        
	        document.getElementById("add").value=z.toFixed(2);
	        
	        document.getElementById("netamount").value=m.toFixed(2);
	        
	    }
	    else if(x=="0")
	    {
	    	//alert(x);
	    	var e=Number(a) + Number(b) + Number(c) + Number(d); 
	    	document.getElementById("add").value=0;
	        document.getElementById("netamount").value=e.toFixed(2);
	    }
	}

 
  function innvalue11(){                                                                                                                                                                                                                                                        
		// alert("hi");
   	  var lc=rowIndex; 
	  var totaldiscount=document.getElementsByClassName("todiscount");
	 
	  var tax=document.getElementsByClassName("tytax");
	  var gstp=document.getElementsByClassName("gstper");
	 
	// alert("length: "+totaldiscount.length+","+totaldiscount[lc-1].value+","+tax[lc-1].value);
	  var buffer="<table>";
	  buffer=buffer+"<tr>  <th>ON AMOUNT</th><th>GST E@</th><th>GST AMT</th></tr>"
	  var totala=0;
	  var totaltax=0;
	  //alert("length: "+buffer+","+totaldiscount.length+","+totaldiscount[lc-1].value+","+tax[lc-1].value);
	    for(var i=0;i<totaldiscount.length;i++)
     {
	    	//alert("length: "+totaldiscount.length+","+totaldiscount[lc-1].value+","+tax[lc-1].value);	
      buffer=buffer+"<tr> <td><input type='text' name='formbean.onamount' class='onamount' value="+totaldiscount[i].value+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td>  <td><input type='text' name='formbean.gst' class='gst' value="+tax[i].value+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' onblur='exdt();'/></td>  <td><input type='text' name='formbean.gamount' class='gamount' value="+gstp[i].value+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;' /></td></tr>";
      totala=totala+Number(totaldiscount[i].value);
      totaltax=totaltax+Number(gstp[i].value);
      
     }
	    buffer=buffer+"<tr><td><label><b>Total Amount</b></label></td><td></td><td><label><b>Total GST@%</b></label></td></tr><tr><td><input type='text' name='formbean.tooamount' class='tooamount' value="+totala.toFixed(2)+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td><td></td><td><input type='text' name='formbean.toogst' class='toogst' value="+totaltax.toFixed(2)+" style='height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;'/></td></tr>"
	    
	 buffer=buffer+"</table>";
	// alert(buffer);
	 document.getElementById("table3").innerHTML=buffer;
	 
	 
	// alert(buffer); 
	
	
 }
 
 
  
  function gstp()
  {
	  var lc=rowIndex;
	  var totaldiscount=document.getElementsByClassName("todiscount");
	  var tax=document.getElementsByClassName("tytax");
	  var gst=document.getElementsByClassName("gstper");
	  
	  var mul=Number(totaldiscount[lc-1].value) * Number(tax[lc-1].value);
	  
	  var result=mul.toFixed(2) / 100;
	  gst[lc-1].value=result.toFixed(2);
	  
	  
  }
 function fadeout(){
		//alert();
		var lc=rowIndex;
		//alert("Row Id for fade out: "+lc);
		$( "#inspect_btn_dialog" ).dialog("close");
		return false;	
		
 }
 </script>
<script language="javascript" type="text/javascript">
function qtypop(){
	$( "#inspect_btn_dialog" ).dialog("open");
	return true;
	
}
	
	


function popup1()
{

	$( "#inspect_btn_dialog1" ).dialog("open");
	return true;
}

function fadeout1()
{
	$( "#inspect_btn_dialog1" ).dialog("close");
	return true;
}

function popup2()
{

	$( "#inspect_btn_dialog2" ).dialog("open");
	return true;
}


	</script>
	<script>
	 var lc=rowIndex;
	 function PersonViewModel(x) {
		 
		    rowIndex = $(x).closest('tr').index();
		  
		}

	function actual(x)
	{
		//alert(x);
		document.getElementById("type1").value=x;
		$( "#inspect_btn_dialog2" ).dialog("close");
		return true;
	}
	</script>
	<script>
	
	function popitup(url) {
		newwindow=window.open(url,'view','height=800,width=1150,resizable=no,menubar=yes,scrollbars=yes');
		x = (screen.availWidth - '1250') / 2;
		y = (screen.avaiHeight - '800') / 2;

		// move to the center of the page
		newwindow.moveTo(x, y);
		if (window.focus) {newwindow.focus();}
		return false;
	}
	
	
	function print1(){
		 confirm("Do You Want to Print?");
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
<body onload="popup2();getname1();"><center>
</s:if>
<s:else>
<body onload="areacode();"><center>
</s:else>

<sj:dialog
        id="inspect_btn_dialog2"
        autoOpen="false"
        modal="true"
        title="Which product do you want to sell?"
        width="300"
        height="200"
        draggable="false"
        resizable="false"
        onCloseTopics="inspect_btn_dialog2"
  
    >
    
   
    <fieldset style="width:100%; border:solid thin #c6d5e1;margin-top:2px">
    <!-- <legend style="color:red;">Material Details</legend>  
     --><div class="welcome" id="comprin4" align="center"></div>  
  <!--  <div style="top:200px;bottom:155px;overflow-y:auto;width:1146px;padding:3px;height:250px;" align="center"> -->
  <table id="table5" border="0" width="52%">
  		<tr>	
	  		<td width="12.5%" align="right" style="padding-left:25px; padding-right:10px;"><label><b>Select&nbsp;Product&nbsp;Type:</b></label></td>    
        </tr>
        <tr>
        	<td width="12.5%"  style=" padding-top:12px; padding-left:15px; padding-right:15px;"><s:radio theme="simple" name="formbean.msize" id="msize" list="#{'1':'Actual','0':'Damaged'}" cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="actual(this.value)"></s:radio></td>
  		</tr>
	  
  </table>
</fieldset>
    
    </sj:dialog>


<sj:dialog
        id="inspect_btn_dialog"
        autoOpen="false"
        modal="true"
        title="M.R.P. AND STOCK DETAILS OF :"
        width="900"
        height="340"
        draggable="false"
        resizable="false"
        onCloseTopics="inspect_btn_dialog"
  
    >
    
   
    <fieldset style="width:100%; border:solid thin #c6d5e1;margin-top:2px">
    <legend style="color:red;">Material Details</legend>  
    <div class="welcome" id="comprin4" align="center"></div>  
  <!--  <div style="top:200px;bottom:155px;overflow-y:auto;width:1146px;padding:3px;height:250px;" align="center"> -->
  <table id="table1" border="0" width="52%">
  		<tr>
  			
	  		<th>M.R.P</th>
	  		<th>ST. CASE</th>
	  		<th>ST. PCS</th>
	  		<th>TOTAL</th>
	  		<th>SL. CASE</th>
	  		<th>SL. PCS</th>
	  		<th>RATE</th>
	  		
  		</tr>
  		<tr>
  			
	  		<td><div align="center"><s:textfield name="formbean.mrp1" cssClass="mrp1" id="mrp1" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.scase" cssClass="scase" id="scase" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.spcs" cssClass="spcs" id="spcs" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calaqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.stotal" cssClass="stotal" id="stotal" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calfqty();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rtcase" cssClass="rtcase" id="rtcase" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rtpcs" cssClass="rtpcs" id="rtpcs" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calamount();calpopupamount();"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.rate" cssClass="rate" id="rate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calamount();calpopupamount();"></s:textfield></div></td>
	  	
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
        height="230"
        draggable="false"
        resizable="false"
        onCloseTopics="inspect_btn_dialog1"
  
    >
    
   
    <fieldset style="width:100%; border:solid thin #c6d5e1;margin-top:2px;">
    <legend style="color:red;">Display Board</legend>  
    <div class="welcome" id="comprin4" align="center"></div>  
  <!--  <div style="top:200px;bottom:155px;overflow-y:auto;width:1146px;padding:3px;height:250px;" align="center"> -->
  <table id="table3" border="0" width="52%" style="margin-left:50px;">
  		 <tr> <th>ON AMOUNT</th>
  			 <th>SGST @</th>
  			 <th>SGST AMOUNT</th>
  			 <th>CGST @</th>
  			 <th>CGST AMOUNT</th>
  			 <th>IGST @</th>
  		 	<th>IGST AMOUNT</th>
  		    <th>GST TOTAL AMT</th>
  		 </tr>
  		<tr>
  			<div>
	  		<td><div align="center"><s:textfield name="formbean.onamount" cssClass="onamount" id="onamount" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.gst" cssClass="gst" id="gst" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></div></td>
	  		<td><div align="center"><s:textfield name="formbean.gamount" cssClass="gamount" id="gamount" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeyup="calaqty();"></s:textfield></div></td>
	  		</div>
	  </tr> 
  </table>
   
   <div align="middle" style="width:95%; position:relative;  padding:10px;">
		
 		<input type="button" id="saveButton"  value="Close Popup" Class="myButton"  onclick="fadeout1();costvalue();sync();" />
 		
 		
      </div> 
     </fieldset>
    
    </sj:dialog>

<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >Sales Memo Entry</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
    
  <fieldset style="width:40%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;">ENTRY OF CASH/CREDIT MEMO FOR SALES(OUTER)</legend>
  
  <s:form action="salesmemeocreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
  
  <table cellpadding="5" width="50%" style="padding:5px">  
 
  		<s:textfield name="formbean.type1" id="type1" cssClass="type1"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;display:none"></s:textfield>
        
       	
       	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Name&nbsp;Of&nbsp;Area</label></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	 <sj:autocompleter name="formbean.nameofarea1" id="nameofarea1" cssClass="nameofarea1" list="usList2"  listValue="nameofarea1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onfocusout="areacode();getcity1();"  ></sj:autocompleter>
        	<s:textfield name="formbean.nameofarea" id="nameofarea" cssClass="nameofarea"  size="30" cssStyle="display:none;height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield>
        	</td>
        
          <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
   
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Date</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top"><sj:datepicker name="formbean.date" id="date" size="20" buttonImageOnly="true" displayFormat="yy-mm-dd" showButton="false"  changeYear="true" changeMonth="true" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onclick="view();"/></td></tr>
        
        
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Salesman&nbsp;Name</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	<sj:autocompleter name="formbean.salesmanname1" id="salesmanname1" cssClass="salesmanname1" list="usList3"  listValue="salesmanname1" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" onfocusout="salecode();"></sj:autocompleter>
        	
        	<s:textfield name="formbean.salesmanname" id="salesmanname"  size="30" cssStyle="display:none;height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield>
        	</td>
            
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
      </tr>
       
         	<tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Retailer&nbsp;Name</label></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;">
        	<s:if test="%{formbean==null}" >
        	<s:select name="formbean.retailername1"   id="retailername1" list="#{'':''}"  cssClass="retailername1"  cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;height:27px;width:200px;" onchange="padress();"></s:select>
        	</s:if>
        	<s:else>
        	 <s:select name="formbean.retailername1" list="usList5" id="retailername1" cssClass="retailername1" listKey="part1" value="formbean.retailername1" listValue="part1" cssStyle="height:27px;border:1px solid #ccc;width:200px;background:#FFFF99" tabindex="2" onchange="padress();" />
	         </s:else>
        	
        	<s:textfield name="formbean.retailername" id="retailername" cssClass="retailername" size="30" cssStyle="display:none;height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield>
        	</td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Memo.&nbsp;no</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.memo" id="memo"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
       
        </tr>
      
         <tr>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Address</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.address" id="address" cssClass="address"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
             <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        
       </tr>
         
         
       
       </table>
   
  
   
   
 
        
   
   
   
 
   
   
   <fieldset style="width:30%; border:solid thin #c6d5e1;Padding:5px;">
    <legend style="color:red;"><h3>press alt-A for Account creation</h3></legend>
	<table cellspacing="0" border="0" width="50%" id="table111">
	
	<!--  <tr  style="background-color:#4292b2;color:white;" align="center">        
    
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
       -->  
    
	 <tr style="background-color:#4292b2;color:white;" align="center">        
    
        <th  width="2%"></th>
        <th width="9%" style="font-size:11.2px">Name Of Items</th>
        <th width="9%" style="font-size:11.2px">  CASE</th>     
        <th width="9%" style="font-size:11.2px">PCS</th>
        <th width="9%" style="font-size:11.2px">F/P</th>
        <th width="9%" style="font-size:11.2px">M.R.P</th>     
        <th width="9%" style="font-size:11.2px">RATE</th>
        <th width="9%" style="font-size:11.2px">DIS/CS</th>
        <th width="9%" style="font-size:11.2px">DIS.%</th>
        <th width="9%" style="font-size:11.2px">AMOUNT</th>
        
    </tr>
      <s:if test="%{formbean==null}">
    <tr>
    
        <td  width="2%"><input type="checkbox" name="chk"/></td>
        
            	
        <td width="9%" style="font-size:14px">
        <s:select name="formbean.nameofitems"   id="nameofitems" list="#{'':''}"  cssClass="nameofitems"  cssStyle="border:1px solid #ccc;height:20px;background:#FFFF99;height:20px;width:200px;" onchange="PersonViewModel(this);PersonViewModel1(this);showdiv1();"></s:select>
    
       <%--  <s:textfield name="formbean.nameofitems" id="nameofitems"  cssClass="nameofitems" size="50" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99;" ></s:textfield>
        --%>
        
         </td>
		
		
        <td width="9%" style="font-size:14px">
        <s:textfield name="formbean.case4" id="case4" cssClass="case4" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);casetotal();pdiscou();gstp();" onfocusout="PersonViewModel(this);tototal();distotal();" ></s:textfield>
        
        </td>	    

		
        <td width="9%" style="font-size:14px">
        <s:textfield name="formbean.pcs4" id="pcs4" cssClass="pcs4"  size="8" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);pcstotal();pdiscou();gstp();" onfocusout="PersonViewModel(this);tototal();distotal();"></s:textfield>
       
        </td>
        
        
        <td width="9%" style="font-size:14px">
        <s:textfield name="formbean.fp" id="fp" cssClass="fp"  size="14" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield>
      
        </td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp4" id="mrp4" cssClass="mrp4" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);"></s:textfield></td>
        
         <td width="9%" style="font-size:14px">
         <s:textfield name="formbean.rate" id="rate" cssClass="rate"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);"></s:textfield>
         </td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.discs" id="discs" cssClass="discs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);discou();pdiscou();gstp();" onfocusout="PersonViewModel(this);tototal();distotal();"></s:textfield></td>
        	 
   	   <td width="9%" style="font-size:14px">
   	   <s:textfield name="formbean.dis" id="dis" cssClass="dis"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="pdiscou();" onfocusout="PersonViewModel(this);tototal();distotal();gstp();avi(this.value)"></s:textfield>
   	   
   	   </td>
        	 
        
        <td width="9%" style="font-size:14px">
        <s:textfield name="formbean.amount4" id="amount4" cssClass="amount4" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield>
         <s:textfield name="formbean.total11" id="total11" cssClass="total11"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield>
        <s:textfield name="formbean.todiscount" id="todiscount" cssClass="todiscount"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield>
        <s:textfield  name="formbean.tytax" id="tytax" cssClass="tytax"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield>
         <s:textfield  name="formbean.gstper" id="gstper" cssClass="gstper"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield>
        
          </td>
       	 
       
       </tr>
    </s:if>
    <s:else>
     <s:iterator value="formbean.nameofitems" status="status">
     	 <tr>
    
    
    
        <td  width="2%"><input type="checkbox" name="chk"/></td>
        
        
      <td width="9%" style="font-size:14px">  <s:select name="formbean.nameofitems" list="usList9" id="nameofitems" cssClass="nameofitems" listKey="part" value="formbean.nameofitems[#status.index]" listValue="part" cssStyle="height:20px;border:1px solid #ccc;width:225px;background:#FFFF99" tabindex="2" onchange="PersonViewModel(this);PersonViewModel1(this);showdiv1();" /><input type="hidden" name="formbean.nameofitems1" class="nameofitems1"></input>	</td>
	<%--  <td width="9%" style="font-size:14px"> <s:select name="formbean.nameofitems[%{#status.count-1}]"   id="nameofitems" list="#{'':''}"  cssClass="nameofitems"  cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;height:20px;width:200px;" onchange="PersonViewModel(this);PersonViewModel1(this);showdiv1();"></s:select><input type="hidden" name="formbean.nameofitems1" id="nameofitems1" class="nameofitems1"></input></td>
     --%>
		
        <td width="9%" style="font-size:14px">
        <s:textfield name="formbean.case4[%{#status.count-1}]" id="case4" cssClass="case4" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);casetotal();pdiscou();gstp();" onfocusout="PersonViewModel(this);tototal();distotal();"></s:textfield><input type="hidden" name="formbean.case5" id="case5" class="case5"></input>
        
        </td>	    

		
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.pcs4[%{#status.count-1}]" id="pcs4" cssClass="pcs4"  size="8" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);pcstotal();pdiscou();gstp();" onfocusout="PersonViewModel(this);tototal();distotal();" ></s:textfield><input type="hidden" name="formbean.pcs5" id="pcs5" class="pcs5"></input></td>
        
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.fp[%{#status.count-1}]" id="fp" cssClass="fp"  size="14" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield><input type="hidden" name="formbean.fp1" id="fp1" class="fp1"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.mrp4[%{#status.count-1}]" id="mrp4" cssClass="mrp4" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="PersonViewModel(this);"></s:textfield><input type="hidden" name="formbean.mrp5" id="mrp5" class="mrp5"></input></td>
        
         <td width="9%" style="font-size:14px"><s:textfield name="formbean.rate[%{#status.count-1}]" id="rate" cssClass="rate"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="unitratte();"></s:textfield><input type="hidden" name="formbean.rate4" id="rate4" class="rate4"></input></td>
        	 
        
        <td width="9%" style="font-size:14px"><s:textfield name="formbean.discs[%{#status.count-1}]" id="discs" cssClass="discs" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="PersonViewModel(this);discou();pdiscou();gstp();" onfocusout="PersonViewModel(this);tototal();distotal();"></s:textfield><input type="hidden" name="formbean.discs4" id="discs4" class="discs4"></input></td>
        	 
   	   <td width="9%" style="font-size:14px"><s:textfield name="formbean.dis[%{#status.count-1}]" id="dis" cssClass="dis"  size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onkeyup="pdiscou();" onfocusout="PersonViewModel(this);tototal();distotal();gstp();"></s:textfield><input type="hidden" name="formbean.dis4" id="dis4" class="dis4"></input></td>
        	 
        
        <td width="9%" style="font-size:14px">
        <s:textfield name="formbean.amount4[%{#status.count-1}]" id="amount4" cssClass="amount4" size="10" cssStyle="height:20px;border:1px solid #ccc;background:#FFFF99" onfocusout="addRow('table111');"></s:textfield><input type="hidden" name="formbean.amount5" id="amount5" class="amount5"></input>
         <s:textfield name="formbean.total11[%{#status.count-1}]" id="total11" cssClass="total11"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.total111" id="total111" class="total111"></input>
        <s:textfield name="formbean.todiscount[%{#status.count-1}]" id="todiscount" cssClass="todiscount"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.todiscount1" id="todiscount1" class="todiscount1"></input>
        <s:textfield  name="formbean.tytax[%{#status.count-1}]" id="tytax" cssClass="tytax"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.tytax1" id="tytax1" class="tytax1"></input>
         <s:textfield  name="formbean.gstper[%{#status.count-1}]" id="gstper" cssClass="gstper"  size="10" cssStyle="display:none;height:20px;border:1px solid #ccc;background:#FFFF99" ></s:textfield><input type="hidden" name="formbean.gstper1" id="gstper1" class="gstper1"></input>
        
        </td> 	 	        
       </tr>
     </s:iterator>
    </s:else>   
       
      
	</table> 
	
	     <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
   	  
       <div align="right" style="width:99%;position:relative;  padding:6px;">
      <!--  <input type="button" value="See Details" Class="butStnd" onclick=""/> -->
       <input type="button" value="add" Class="butStnd" onclick="addRow('table111');"/>
       <input type="button" value="delete" Class="butStnd" onclick="deleteRow('table111');PersonViewModel(this);tototal();distotal();"/>
	
	
       </div>
      
       <table cellpadding="5" width="50%" style="padding:5px"> 
      <tr>
       <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           <td width="12.5%" style="padding-left:15px; padding-right:15px;" ></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
      <td width="12.5%" style="padding-left:15px; padding-right:15px;">  <input type="button" value="See Details" Class="butStnd" onclick="popup1();innvalue1();"/></td>
       </tr>
        <tr>
           <td width="12.5%" style="padding-left:15px; padding-right:15px;" ></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           <td width="12.5%" style="padding-left:15px; padding-right:15px;" ></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           <td width="12.5%" style="padding-left:15px; padding-right:15px;" ></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
          	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	   	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"> </td>
       
        
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"  colspan="7">
        	<label>Total&nbsp;Amount</label>
        	</td>
        	<%-- <td width="12.5%" style="padding-left:15px; padding-right:15px;"  colspan="7"><sj:autocompleter name="formbean.totalamt" id="totalamt" cssClass="totalamt"  size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></sj:autocompleter></td>
 --%>      <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.totalamt" id="totalamt" cssClass="totalamt"  size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
          
      
        </tr>
        
   <tr>
   
   <td width="12.5%" style="padding-left:15px; padding-right:15px;" align="right"><label>Packing</label></td>
        	<%-- <td width="12.5%" style="padding-left:15px; padding-right:15px;" align="right"><sj:autocompleter name="formbean.packing" id="packing" cssClass="packing"  size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></sj:autocompleter></td>
    --%>   <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.packing" id="packing" cssClass="packing"  size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
          	
        
           <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Case</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.casee" id="casee" cssClass="casee"  size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
          	
          	
          	 <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Pcs</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.pcss" id="pcss" cssClass="pcss" size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Total Pieces</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.total" id="total" cssClass="total"   size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
          
        	   	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"  colspan="7"><label>Total&nbsp;Discount</label></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;" colspan="7"><s:textfield name="formbean.discount" id="discount" cssClass="discount"  size="10" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
        </tr>
	
        </table>
  </fieldset>
   <fieldset style="width:15%; border:solid thin #c6d5e1;Padding:5px;">
  	<table cellspacing="0" border="0" width="20%">
  	
  	
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
        	 
        		
        		 
        	
        	
        
   <td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Gross&nbsp;Amount</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.gamount" id="gamount"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" ></s:textfield></td>
            
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
        	
        	
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Discount</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"onkeyup="totaldis()"><s:textfield name="formbean.discount1" id="discount1"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false" ></s:textfield></td>
            
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
        	
        	
        		 
        	
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Sub&nbsp;Total</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.subtotal" id="subtotal" cssClass="subtotal"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
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
        	
        	 
        	 
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>SGST@</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.sgst" id="sgst"  cssClass="sgst"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
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
        	 
        	 
        
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>IGST@</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.igst" id="igst" csslass="igst"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
            
     </tr>
  <tr>
   
        	 
        	  <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Total&nbsp;on&nbsp;Rs.</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.totalamtrs" id="totalamtrs"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
     	 
        	 
     	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Gst&nbsp;Amount</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.gstamount" id="gstamount"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
          <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
        	<td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
  <td width="12.5%" style="padding-left:100px;" align="right" ><label>Rounded&nbsp;Off</label></td>  
  	<td width="12.5%" style="padding-left:100px; " valign="top"><div style="width:100px"><s:radio theme="simple" name="formbean.roundoff" id="roundoff"  cssClass="roundoff" list="#{'1':'yes','0':'No'}"  cssStyle="height:12px;border:1px solid #ccc;background:#FFFF99; width:15px"  tabindex="5" onclick="ram(this.value);"></s:radio></div></td>
    
<td width="12.5%" style="padding-left:150px;" ><label>Add</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.add" id="add"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
    
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
        		
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;" ><label>Net&nbsp;Amount</label></td>
  	<td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.netamount" id="netamount"  size="15" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" forceValidOption="false"></s:textfield></td>
    
    </tr>
  	
  	</table>
  </fieldset>
  
  
   <div align="right" style="width:99%;position:relative;  padding:7px;">
    <s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="change2();" ></s:submit>
  </div>
   	 
   	  
     
      
      
      

      
    </s:form>
  </fieldset>
  
 
  
	
	 <p>&nbsp;</p>
	<s:if test="usList1">
	<div id="ram">
	<display:table id="table111"  name="usList1" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:75%;color:#000">
	    
	 <s:if test="%{#attr.table111.id == formbean.id}">
	
	<display:column property="nameofarea"   title="Name of Area" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="salesmanname"   title="Salesman Name"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="retailername"   title="Retailer Name" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="memo"   title="Memo no" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="salesmemeoupdate" namespace="/" ><s:param  name="id" value="%{#attr.table111.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="salesmemeodelete" namespace="/" ><s:param  name="id" value="%{#attr.table111.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	<s:else>
	
	<display:column property="nameofarea"   title="Name of Area" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="salesmanname"   title="Salesman Name"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="retailername"   title="Retailer Name" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	<display:column property="memo"   title="Memo No" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="msalesmemeoupdate" namespace="/" ><s:param  name="id" value="%{#attr.table111.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="msalesmemeodelete" namespace="/" ><s:param  name="id" value="%{#attr.table111.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
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
