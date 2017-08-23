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

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script language="javascript" type="text/javascript" src="js/dynamictable.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" media="all" href="./Body/fordatepick/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="./Body/fordatepick/jsDatePick.min.1.3.js"></script>
<script>
$(document).ready(function()
        {
            new JsDatePick
            ({
                useMode:2,
                target:"date1",
                dateFormat:"%Y-%m-%d"
            });
            
            new JsDatePick
            ({
                useMode:2,
                target:"billdate",
                dateFormat:"%Y-%m-%d"
            });
        });
</script>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/>
<script src="//code.jquery.com/jquery-1.12.4.js"></script> 
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
		var $easy1 = $.noConflict(true);
	</script>
<script>
 $(document).ready(function() {
	   
	 $("#ram").css({ 'display': "block" });
	    $easy1('#table123').DataTable( {
	       
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
#popup /*div id*/
{
    width:1083px;
    height:333px;
    margin:150px auto 0;
    font-weight:bold;
    background-color:#ebedef;
    border-radius:3px;
    box-shadow:0px 0px 10px 0px #424242;
    padding:0px;
    box-sizing:border-box;
    font-family:helvetica;
    visibility:hidden;
    display:none;
    position:absolute;
    left:0;
    right:0;
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

<script type="text/javascript">
/* $(document).keydown(function(evt)
     {
        if((evt.keyCode==65) && (evt.altKey))//alt+a to add new row
            {
                addRow('table12');
            }
    });
$(document).keydown(function(evt)
         {
            if((evt.keyCode==87) && (evt.altKey))//alt+r to delete row
            {
                //alert();
                deleteRow('table12');
            }
}); */
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

<script>
function savepopup1()
{
    if (typeof XMLHttpRequest != "undefined")
    {
        xmlHttp11 = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlHttp11 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp11 == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var for1=document.getElementById("for1").value;
    var date1=document.getElementById("date1").value;
    var batch = document.getElementsByName("formbean.batchno");
    var expdate = document.getElementsByName("formbean.expdate");
    var aqty = document.getElementsByName("formbean.aqty");
    var fqty = document.getElementsByName("formbean.fqty");
    var purate = document.getElementsByName("formbean.purate");
    var strate = document.getElementsByName("formbean.strate");
    var rtrate = document.getElementsByName("formbean.rtrate");
    var mrp = document.getElementsByName("formbean.mrp");
    var pamount = document.getElementsByName("formbean.pamount");
    var ar=new Array(batch.length);
    for(var i=0; i<batch.length; i++)
    {
        ar[i]=batch[i].value+"con"+expdate[i].value+"con"+aqty[i].value+"con"+fqty[i].value+"con"+purate[i].value+"con"+strate[i].value+"con"+rtrate[i].value+"con"+mrp[i].value+"con"+pamount[i].value;
    }
    ar.join(",");
    var url = "./Body/inventory_transaction/todummyonupdate.jsp";
    url += "?count=" +ar.join(",")+"add"+for1.substring(4,for1.length)+"ddd"+date1;
    xmlHttp11.onreadystatechange = codeAdd22;
    xmlHttp11.open("GET", url, true);
    xmlHttp11.send(null);
}
function savepopup()
{
    if (typeof XMLHttpRequest != "undefined")
    {
        xmlHttp11 = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlHttp11 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp11 == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var for1=document.getElementById("for1").value;
    var date1=document.getElementById("date1").value;
    var batch = document.getElementsByName("formbean.batchno");
    var expdate = document.getElementsByName("formbean.expdate");
    var aqty = document.getElementsByName("formbean.aqty");
    var fqty = document.getElementsByName("formbean.fqty");
    var purate = document.getElementsByName("formbean.purate");
    var strate = document.getElementsByName("formbean.strate");
    var rtrate = document.getElementsByName("formbean.rtrate");
    var mrp = document.getElementsByName("formbean.mrp");
    var pamount = document.getElementsByName("formbean.pamount");
    var ar=new Array(batch.length);
    for(var i=0; i<batch.length; i++)
    {
        ar[i]=batch[i].value+"con"+expdate[i].value+"con"+aqty[i].value+"con"+fqty[i].value+"con"+purate[i].value+"con"+strate[i].value+"con"+rtrate[i].value+"con"+mrp[i].value+"con"+pamount[i].value;
    }
    ar.join(",");
    var url = "./Body/inventory_transaction/todummy.jsp";
    url += "?count=" +ar.join(",")+"add"+for1.substring(4,for1.length)+"ddd"+date1;
    xmlHttp11.onreadystatechange = codeAdd22;
    xmlHttp11.open("GET", url, true);
    xmlHttp11.send(null);
}
function codeAdd22()
{
    if(xmlHttp11.readyState == 4 || xmlHttp11.readyState == "complete")
    {
        var xx=xmlHttp11.responseText;
        xx=xx.trim();
        if(xx=="1")
        {
            closepopup();
            document.getElementById("tamount").value="";
            document.getElementById("taqty").value="";
            document.getElementById("tfqty").value="";
            //$("#popup").fadeOut();
            //$("#popup").css({"visibility":"hidden","display":"none"});
        }
    }
}
</script>
<sj:head/>
<script>
$(document).keydown(function(e) 	
{
			var x;
			var url = "ledgerlist1";
			url += "?count=" + "purchaseentry"; 
			 if(e.keyCode==67 && (e.altKey))//alt+c to ledger
				{
			        window.location.href=url;
			    }
});
function showdiv1()
{
	alert('Sou');
}
function showdiv()
{
	if (typeof XMLHttpRequest != "undefined")
    {
        vardiv = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
    	vardiv = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (vardiv == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var s1 = document.getElementsByClassName("pname");
    var url = "./Body/inventory_transaction/getbatchdetails.jsp";
    url += "?count=" + s1[rowIndex-1].value;
    vardiv.onreadystatechange = codeAddd;
    vardiv.open("GET", url, true);
    vardiv.send(null);
}
function codeAddd()
{
    if (vardiv.readyState == 4 || vardiv.readyState == "complete")
    {
        var x1=vardiv.responseText;
		x1=x1.trim();
		var s1 = document.getElementsByClassName("pname");
		var x2=x1.split("con");
		document.getElementById("table1").innerHTML=x2[0];
		document.getElementById("for1").value="For "+s1[rowIndex-1].value;
		document.getElementById("tamount").value=x2[1];
		document.getElementById("taqty").value=x2[2];
		document.getElementById("tfqty").value=x2[3];
		document.getElementsByClassName("aqtyd")[rowIndex-1].value=x2[2];
		document.getElementsByClassName("fqtyd")[rowIndex-1].value=x2[3];
		document.getElementsByClassName("amountd")[rowIndex-1].value=x2[1];
		/*
		document.getElementsByName("formbean.aqtyd")[rowIndex-1].value=x2[2];
		document.getElementsByName("formbean.fqtyd")[rowIndex-1].value=x2[3];
		document.getElementsByName("formbean.amountd")[rowIndex-1].value=x2[1];
		
		document.getElementsByClassName("aqtyd")[rowIndex-1].value=x2[2];
		document.getElementsByClassName("fqtyd")[rowIndex-1].value=x2[3];
		document.getElementsByClassName("amountd")[rowIndex-1].value=x2[1];*/
        $("#popup").fadeIn();
        $("#popup").css({"visibility":"visible","display":"block"});
    }
};
function closepopup()
{
    var batchno=document.getElementsByName("formbean.batchno");
    var expdate=document.getElementsByName("formbean.expdate");
    var aqty=document.getElementsByName("formbean.aqty");
    var fqty=document.getElementsByName("formbean.fqty");
    var purate=document.getElementsByName("formbean.purate");
    var strate=document.getElementsByName("formbean.strate");
    var rtrate=document.getElementsByName("formbean.rtrate");
    var mrp=document.getElementsByName("formbean.mrp");
   
    var pamount=document.getElementsByName("formbean.pamount");
    for(var i=0; i<batchno.length; i++)
    {
        batchno[i].value="";
        expdate[i].value="";
        aqty[i].value="";
        fqty[i].value="";
        purate[i].value="";
        strate[i].value="";
        rtrate[i].value="";
        mrp[i].value="";
       
        pamount[i].value="";
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
    }
    //document.getElementById("sta").value="";
    //document.getElementById("stf").value="";
    $("#popup").fadeOut();
    $("#popup").css({"visibility":"hidden","display":"none"});
}
function calaqty()
{
    var p=document.getElementsByName("formbean.aqty");
    var t=0;
    var lc=rowIndex;
    for(var x=0; x<p.length; x++)
    {
        t=t+Number(p[x].value);
    }
    document.getElementById("taqty").value=t;
    document.getElementsByName("formbean.aqtyd")[lc-1].value=t;
}
function calfqty()
{
    var p1=document.getElementsByName("formbean.fqty");
    var t1=0;
    var lc=rowIndex;
    for(var x1=0; x1<p1.length; x1++)
    {
        t1=t1+Number(p1[x1].value);
    }
    document.getElementById("tfqty").value=t1;
    document.getElementsByClassName("fqtyd")[lc-1].value=t1;
}
function PersonViewModel(x)
{
    rowIndex=$(x).closest('tr').index();
}
function caltotal()
{
    var s=document.getElementsByName("formbean.amount");
    var total=0;
    for(var i=0;i<s.length;i++)
    {
        total=total+Number(s[i].value);
    }
    document.getElementById("totalamount").value=total.toFixed(2);
}
function getmat1()//getting contra part
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
    var s1 = document.getElementById("company").value;
    var url = "./Body/inventory_transaction/getmat.jsp";
    url += "?count=" + s1;
    //alert(url);
    xmlHttp1.onreadystatechange = codeAdd2;
    xmlHttp1.open("GET", url, true);
    xmlHttp1.send(null);
}
function codeAdd2()
{
    if (xmlHttp1.readyState == 4 || xmlHttp1.readyState == "complete")
    {
        var x1=xmlHttp1.responseText;
        x1=x1.trim();
        var x2=x1.split("con");
        document.getElementById("pname").innerHTML=x2[0];
        //document.getElementById("unitd").innerHTML=x2[1];
    }
};
function disp()
{
    if (typeof XMLHttpRequest != "undefined")
    {
        xmlHttp110 = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlHttp110 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp110 == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var url = "./Body/inventory_transaction/getdate.jsp";
    xmlHttp110.onreadystatechange = codeAdd220;
    xmlHttp110.open("GET", url, true);
    xmlHttp110.send(null);
}
function codeAdd220()
{
    if (xmlHttp110.readyState == 4 || xmlHttp110.readyState == "complete")
    {
        var x1=xmlHttp110.responseText;
        x1=x1.trim();
        if(x1=="nil")
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
            document.getElementById("date1").value=year+"-"+month+"-"+date;
        }
        else
        {
            document.getElementById("date1").value=x1;
        }
    }
};
function getunit1()
{
    var lc=rowIndex;
    if (typeof XMLHttpRequest != "undefined")
    {
        a111 = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        a111 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (a111 == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var x=document.getElementsByClassName("pname");
    var url = "./Body/inventory_transaction/getunit.jsp";
    url += "?count=" + x[lc-1].value;

    a111.onreadystatechange = codeAdd111;
    a111.open("GET", url, true);
    a111.send(null);
}
function codeAdd111()
{
    if (a111.readyState == 4 || a111.readyState == "complete")
    {
        var x1=a111.responseText;
        x1=x1.trim();
        document.getElementsByClassName("unitd")[rowIndex-1].value=x1;
    }
}
function getunit()
{
    var lc=rowIndex;
    if (typeof XMLHttpRequest != "undefined")
    {
        a11 = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        a11 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (a11 == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var x=document.getElementsByName("formbean.pname");
    var url = "./Body/inventory_transaction/getunit.jsp";
    url += "?count=" + x[lc-1].value;

    a11.onreadystatechange = codeAdd11;
    a11.open("GET", url, true);
    a11.send(null);
}
function codeAdd11()
{
    if (a11.readyState == 4 || a11.readyState == "complete")
    {
        var x1=a11.responseText;
        x1=x1.trim();
        document.getElementsByName("formbean.unitd")[rowIndex-1].value=x1;
    }
}

function getv()
{
    if (typeof XMLHttpRequest != "undefined")
    {
        a2 = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        a2 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (a2 == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var url = "./Body/inventory_transaction/getv.jsp";
    a2.onreadystatechange = codeAdd1;
    a2.open("GET", url, true);
    a2.send(null);
}
function codeAdd1()
{
    if (a2.readyState == 4 || a2.readyState == "complete")
    {
        var x1=a2.responseText;
        x1=x1.trim();
        document.getElementById("vno").value=x1;
    }
}
function exdt1()
{
	alert();
}
function exdt()
{
    var pp=document.getElementsByName("formbean.expdate");
    for(var i=0;i<pp.length;i++)
    {
        var r=pp[i].value.replace("/","");
        var x=r.substring(2,r.length);
        var y=r.substring(0,2);
        pp[i].value=y+"/"+x;
    }
}
function calamount()
{
    var qq=document.getElementsByName("formbean.aqty");
    var yy=document.getElementsByName("formbean.purate");
    var ee=document.getElementsByName("formbean.pamount");
    var total=0;
    for(var i=0;i<qq.length;i++)
    {
        total=total+(Number(qq[i].value)*Number(yy[i].value));
        ee[i].value=total.toFixed(2);
        total=0;
    }
}
function calto()
{
	//alert(rowIndex);
    var ee=document.getElementsByName("formbean.pamount");
    var x=0;
    for(var i=0;i<ee.length;i++)
    {
        x=x+Number(ee[i].value);
    }
    document.getElementById("tamount").value=x;
    document.getElementsByClassName("amountd")[rowIndex-1].value=x;
}
function calsimpletotal()
{
    var ss=document.getElementsByClassName("amountd");
    var e=0;
    for(var i=0;i<ss.length;i++)
    {
        e=e+Number(ss[i].value);
    }
    document.getElementById("totalamount").value=e;
}
function disc1()
{
    var a1=document.getElementById("totalamount").value;
    var a2=document.getElementById("discp").value;
    var op=(Number(a1)*Number(a2))/100;
    document.getElementById("disc").value=op.toFixed(2);
    document.getElementById("subtotal").value=Number(a1)-op;
}
function caltax()
{
    var ll=document.getElementById("subtotal").value;
    var kk=document.getElementById("taxc").value;
    var z=(Number(ll)*Number(kk))/100;
    document.getElementById("tax").value=z.toFixed(2);
}
function plusminus()
{
    var xx=document.getElementById("subtotal").value;
    var oamount=document.getElementById("oamount").value;
    var add=document.getElementById("addamount").value;
    var less=document.getElementById("lessamount").value;
    var ta=document.getElementById("tax").value;
    var yu=(Number(xx)+Number(ta)+Number(oamount)+Number(add))-Number(less);
    document.getElementById("subtotal1").value=yu.toFixed(2);
}
function ro(d)
{
    var a=document.getElementById("subtotal1").value;
   
    if(d=="1")
    {
        var rr=Math.round(Number(a));
        var z=Number(rr)-Number(a);
        document.getElementById("roundofft").value=z.toFixed(2);
        document.getElementById("netamount").value=rr;
    }
    else if(d=="2")
    {
        document.getElementById("roundofft").value=a;
        document.getElementById("netamount").value=a;
    }
}
function getu()
{
	var a1=document.getElementsByClassName("pname");

}
function copyh()
{
	var pname=document.getElementsByClassName("pname");
	var aqty=document.getElementsByClassName("aqtyd");
	var fqty=document.getElementsByClassName("fqtyd");
	var unit=document.getElementsByClassName("unitd");
	var amount=document.getElementsByClassName("amountd");
	
	var hpname=document.getElementsByClassName("hpname");
	var haqty=document.getElementsByClassName("haqtyd");
	var hfqty=document.getElementsByClassName("hfqtyd");
	var hunit=document.getElementsByClassName("hunitd");
	var hamount=document.getElementsByClassName("hamountd");
	for(var i=0;i<pname.length;i++)
	{
		hpname[i].value=pname[i].value;
		haqty[i].value=aqty[i].value;
		hfqty[i].value=fqty[i].value;
		hunit[i].value=unit[i].value;
		hamount[i].value=amount[i].value;
	}
}
function setdefault()
{
	document.getElementById("netamount").value="0";
	document.getElementById("roundofft").value="0";
	document.getElementById("subtotal1").value="0";
	document.getElementById("subtotal").value="0";
	document.getElementById("addamount").value="0";
	document.getElementById("oamount").value="0";
	document.getElementById("lessamount").value="0";
	document.getElementById("totalamount").value="0";
	document.getElementById("disc").value="0";
	document.getElementById("discp").value="0";
	document.getElementById("tax").value="0";
	document.getElementById("taxc").value="0";
}
</script>
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
<script src="./js/dynamictable.js"></script>
</head>
<s:if test="%{formbean==null}">
<body onload="setdefault();disp();getv();"><center>
</s:if>
<s:else>
<body onload=""><center>
</s:else>
<div>
<ul id="breadcrumbs">
<li ><a href="#">Garge Agency</a></li>
<li>Inventory Transaction</li>
<li> -> Purchase Entry</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>

 <div style="position:fixed;top:160px;bottom: 45px;overflow-y:auto;width:100%" align="center">
  <s:form action="purchaseentrycreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
   
    <div id="popup" style="display:none;">
  <div align="right">
      <img id="image" src="Image/popupclose.png" height="2%" width="2%" onclick="closepopup();" style="cursor:pointer;"></img>
  </div>
  <table border="0">
      <tr>
          <td colspan="11" align="center">Please Fill-Up Batch No Wise Quantity And Rate</td>
      </tr>
      <tr>
          <td colspan="11"><input type="text" id="for1" name="for1" style="border:none;background:transparent;width:350px;text-align:center" readonly/></td>
      </tr>
  </table>
  <hr width="100%"/>
  <div style="top:200px;bottom:155px;overflow-y:auto;width:1049px;padding:10px;height:233px;" align="center">
  <table id="table1" border="0" width="100%">
          <tr>
              <th></th>
              <th>Batch No.</th>
              <th>Exp.Dt.</th>
              <th>A. Qty.</th>
              <th>F. Qty</th>
              <th>Pu.Rate</th>
              <th>Td.Rate</th>
              <th>Rt.Rate</th>
              <th>MRPrice</th>
              <th>Amount</th>
          </tr>
          <tr>
              <td><input type="checkbox"></input></td>
              <td ><s:textfield name="formbean.batchno"  id="batchno" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px;z-index:9"></s:textfield></td>
              <td ><s:textfield name="formbean.expdate"  id="expdate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px" onblur="exdt()"></s:textfield></td>
              <td ><s:textfield name="formbean.aqty"  id="aqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px" onkeyup="calaqty();"></s:textfield></td>
              <td ><s:textfield name="formbean.fqty"  id="fqty" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px" onkeyup="calfqty();"></s:textfield></td>
              <td ><s:textfield name="formbean.purate"  id="purate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px" onkeyup="calamount();calto();calsimpletotal();"></s:textfield></td>
              <td ><s:textfield name="formbean.strate"  id="strate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px"></s:textfield></td>
              <td ><s:textfield name="formbean.rtrate"  id="rtrate" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px"></s:textfield></td>
              <td ><s:textfield name="formbean.mrp"  id="mrp" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px"></s:textfield></td>
              <td ><s:textfield name="formbean.pamount"  id="pamount" size="13" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:110px"></s:textfield></td>
          </tr>
  </table>
  <div align="right">
          Total&nbsp;Amount:<s:textfield name="formbean.tamount"  id="tamount" size="13" cssStyle="height:25px;border:0px solid #ccc;background:#FFFF99"></s:textfield>&nbsp;
          Total&nbsp;A.Qty:<s:textfield name="formbean.taqty"  id="taqty" size="13" cssStyle="height:25px;border:0px solid #ccc;background:#FFFF99"></s:textfield>&nbsp;
          Total&nbsp;F.Qty:<s:textfield name="formbean.tfqty"  id="tfqty" size="13" cssStyle="height:25px;border:0px solid #ccc;background:#FFFF99"></s:textfield>
  </div>
  <s:if test="%{formbean==null}">
      <div align="right" style="width:95%;position:relative;  padding:7px;">
          <input type="button" name="add" class="butStnd" value="Add Row"  onclick="addRow('table1');"></input>
          <input type="button" name="delete" class="butStnd" value="Delete Row"  onclick="deleteRow('table1');"></input>
          <input type="button" name="save" class="butStnd" value="Save" onclick="PersonViewModel(this);savepopup();"></input>
      </div>
   </s:if>
   <s:else>
   	  <div align="right" style="width:95%;position:relative;  padding:7px;">
          <input type="button" name="add" class="butStnd" value="Add Row"  onclick="addRow('table1');"></input>
          <input type="button" name="delete" class="butStnd" value="Delete Row"  onclick="deleteRow('table1');"></input>
          <input type="button" name="save" class="butStnd" value="Save" onclick="PersonViewModel(this);savepopup1();"></input>
      </div>
   </s:else>
  </div>
  </div>
  <fieldset style="width:65%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Purchase Entry</h3></legend>
 
      <div align="left" style="float:left">
          Serial&nbsp;No.&nbsp;&nbsp;<s:textfield name="formbean.vno" id="vno" style="border:none"/>
      </div>
      <div align="right">
          Date:<s:textfield name="formbean.date1" id="date1" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:70px"/>
      </div>

  <table cellpadding="0" width="100%" style="padding:0px" border="0"> 
          <tr>   
              <td width="12.5%" style="padding-left:0px; padding-right:15px;"><label>Principal:</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.company" id="company" list="usList1"  listValue="company" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:300px" forceValidOption="false" onfocusout="getmat1();"></sj:autocompleter></td>   
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Debit&nbsp;A/c:</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.debitac" id="debitac" list="usList2"  listValue="debitac" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:300px" forceValidOption="false"></sj:autocompleter></td>
        </tr>
   </table>
  <div>
  <div style="height:165px;top:200px;bottom:155px;overflow-y:auto;width:93%;float:left">
  <table id="table12" border="0" width="90%" cellpadding="0" style="">  
    <tr bgcolor="#4292b2" style="color:white">
    <th width="5%"></th>
    <th width="6.5%" ><label>Product Name</label></th>
    <th width="6.5%" ><label>A. Quantity</label></th>
    <th width="6.5%" ><label>F. Quantity</label></th>   
    <th width="6.5%" ><label>Unit</label></th>
    <th width="6.5%" ><label>Amount</label></th>
    <th width="6.5%" ></th>
    </tr>
    <s:if test="%{formbean==null}">
    <tr>
        <td width="5%"><input type="checkbox" name="chk"></input></td>
        <td width="6.5%" ><s:select name="formbean.pname" id="pname" cssClass="pname" list="#{'':''}" listKey="pname" value="formbean.pname" listValue="pname" cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;width:280px;height:25px" onchange="PersonViewModel(this);getunit()"></s:select></td>
        <td width="6.5%" ><s:textfield name="formbean.aqtyd" readonly="false" id="aqtyd" cssClass="aqtyd" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed"></s:textfield></td>
        <td width="6.5%" ><s:textfield name="formbean.fqtyd" readonly="false" id="fqtyd" cssClass="fqtyd" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed"></s:textfield></td>
        <td width="6.5%" ><s:textfield name="formbean.unitd" readonly="true" id="unitd" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed"></s:textfield></td>
        <td width="6.5%" ><s:textfield name="formbean.amountd" readonly="false" id="amountd" cssClass="amountd" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed" onkeyup="caltotal();"></s:textfield></td>
        <td width="6.5%"><input type="button" value="B.D." class="butStnd" onclick="PersonViewModel(this);showdiv();"/></td>
    </tr>
    </s:if>
    <s:else>
    	<%int i=0; %>
    	<s:iterator value="formbean.aqtyd" status="status" >
        <tr>
            <td><input type="checkbox" name="chk"></input></td>
            <td width="6.5%" ><s:select name="formbean.pname" id="pname" list="usList8" listKey="part"  value="formbean.board[#status.index]" listValue="part" cssClass="pname"  cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;width:280px;height:25px" onchange="PersonViewModel(this);getunit1()"></s:select><input type="hidden" name="formbean.hpname" class="hpname"/></td>
            <td width="6.5%" ><s:textfield name="formbean.aqtyd[%{#status.count-1}]" cssClass="aqtyd" id="aqtyd" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed"></s:textfield><input type="hidden" name="formbean.haqtyd" class="haqtyd"/></td>
            <td width="6.5%" ><s:textfield name="formbean.fqtyd[%{#status.count-1}]" cssClass="fqtyd" id="fqtyd" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed"></s:textfield><input type="hidden" name="formbean.hfqtyd" class="hfqtyd"/></td>
            <td width="6.5%" ><s:textfield name="formbean.unitd[%{#status.count-1}]" cssClass="unitd" id="unitd" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed"></s:textfield><input type="hidden" name="formbean.hunitd" class="hunitd"/></td>
            <td width="6.5%" ><s:textfield name="formbean.amountd[%{#status.count-1}]" cssClass="amountd" id="amountd" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;cursor:not-allowed" onkeyup="caltotal();"></s:textfield><input type="hidden" name="formbean.hamountd" class="hamountd"/></td>
            <td width="6.5%"><input type="button" value="B.D." class="butStnd" onclick="PersonViewModel(this);showdiv();"/></td>
        </tr>
        <%i++; %>
        </s:iterator>
    </s:else>
  </table>
  </div>
  <div style="float:right">
   <input type="button" value="Add" class="butStnd" onclick="addRow('table12');" style="cursor:default"></input></br>
    <input type="button" value="Delete" class="butStnd" onclick="deleteRow('table12');" style="cursor:default"></input>
  </div>
  </div>
    <br/>
    
  <table width="80%" border="0" style="border:0px solid"> 
 
          <tr style="border:1px solid">   
              <td width="12.5%" style="padding-left:15px; padding-right:15px;">Challan&nbsp;No.</td>
               <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.challanno" id="challanno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
             
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Total&nbsp;Amount</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.totalamount" id="totalamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
        <tr style="border:1px solid">   
            <td width="12.5%" style="padding-left:15px; padding-right:15px;">Dated</td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.dated" id="dated" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
             
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:110px"><label>Disc&nbsp;@&nbsp;%</label><s:textfield name="formbean.discp" id="discp" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:50px" onkeyup="disc1();"></s:textfield></div></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.disc"  id="disc" onblur="" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;">Truck/R.R.&nbsp;No.</td>
               <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.truckrr" id="truckrr" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Sub&nbsp;Total</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.subtotal" id="subtotal" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
        <tr>   
              <td width="12.5%" style="padding-left:15px; padding-right:15px;">Transporter</td>
               <td width="12.5%" style="padding-left:15px; padding-right:15px;"><sj:autocompleter name="formbean.transporter" id="transporter" list="usList7"  listValue="transporter" size="50" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:190px" forceValidOption="false"></sj:autocompleter></td>
             
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:110px"><s:select name="formbean.taxselect" id="taxselect" list="#{'CST':'CST','LST':'LST'}" cssStyle=" border:1px solid #ccc;height:25px;background:#FFFF99;width:51px;"></s:select><s:textfield name="formbean.taxc" id="taxc" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:50px" onkeyup="caltax();"></s:textfield></div></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.tax"  id="tax" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;">Bill No.</td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billno" id="billno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Others&nbsp;Amount</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.oamount" id="oamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>       
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;">Bill Date</td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.billdate" id="billdate" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right;z-index:0"></s:textfield></td>
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>       
       
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Add&nbsp;Amount</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.addamount" id="addamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Less&nbsp;Amount</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.lessamount" id="lessamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right" onblur="plusminus();"></s:textfield></td>
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;" colspan="2" rowspan="3"><s:textarea name="formbean.singlenarration" cols="53" rows="4" maxlength="275" cssStyle="border:1px solid #ccc;background:#FFFF99;resize:none;"/></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Sub&nbsp;Total</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.subtotal1" id="subtotal1" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
          <s:if test="%{formbean==null}">
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:120px"><label>R.&nbsp;Off</label>&nbsp;<s:radio name="formbean.roundoff" id="roundoff" list="#{'1':'Yes','2':'No'}" value='2' cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="ro(this.value)"></s:radio></div></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.roundofft" id="roundofft" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
          </s:if>
          <s:else>
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"><div style="width:120px"><label>R.&nbsp;Off</label>&nbsp;<s:radio name="formbean.roundoff" id="roundoff" list="#{'1':'Yes','2':'No'}" cssStyle=" border:1px solid #ccc;height:12px;background:#FFFF99;width:15px;" onclick="ro(this.value)"></s:radio></div></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.roundofft" id="roundofft" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
          </s:else>
        </tr>
        <tr>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Net&nbsp;Amount</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.netamount" id="netamount" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;text-align:right"></s:textfield></td>
        </tr>
   </table>
   <br></br>
  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;"></div>
        
       <div align="right" style="width:99%;position:relative;  padding:7px;">
          <s:submit name="formbean.save" value="Save" cssClass="butStnd" onclick="copyh();return Validate();" ></s:submit>
       
      </div>
 </s:form> 
 </fieldset>
   
    <p>&nbsp;</p>
    <s:if test="usList3">
   <div id="ram">
    <display:table id="table123"  name="usList3"  class="datatable" requestURI=""     export="true" style="width:98%;color:#000">
       
     <s:if test="%{#attr.table123.id == formbean.id}">
   
    <display:column property="company"   title="Principal" style="background-color:#E6E6FA;padding-inherit;"   sortable="false" headerClass="sortable" />
    
    <display:column property="debitac"   title="Debit A/c"  style="background-color:#E6E6FA;width:167px;text-align:center;"   sortable="false" headerClass="sortable"/>
   
    <display:column property="material"   title="Materials"  style="background-color:#E6E6FA;width:200px;text-align:center;"   sortable="false" headerClass="sortable"/>
   
    <display:column property="totalamount"   title="Total Amount" style="background-color:#E6E6FA;width:90px;text-align:center;"   sortable="false" headerClass="sortable" />

    <display:column property="netamount"   title="Net Amount" style="background-color:#E6E6FA;width:90px;text-align:center;"   sortable="false" headerClass="sortable" />
   
    <display:column property="transporter"   title="Transporter" style="background-color:#E6E6FA;text-align:center;"   sortable="false" headerClass="sortable" />
   
    <display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#E6E6FA" >
    <a href="<s:url action="purchaseentryupdate" namespace="/" ><s:param  name="id" value="%{#attr.table123.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
   
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#E6E6FA" >
    <a href="<s:url action="purchaseentrydelete" namespace="/" ><s:param  name="id" value="%{#attr.table123.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    </s:if>
   
    <s:else>
    <display:column property="company"   title="Principal" style="background-color:#fff;padding-inherit;"   sortable="false" headerClass="sortable" />
   
    <display:column property="debitac"   title="Debit A/c"  style="background-color:#fff;width:167px;text-align:center;"   sortable="false" headerClass="sortable"/>
   
    <display:column property="material"   title="Materials"  style="background-color:#fff;width:200px;text-align:center;"   sortable="false" headerClass="sortable"/>
   
    <display:column property="totalamount"   title="Total Amount" style="background-color:#fff;width:90px;text-align:center;"   sortable="false" headerClass="sortable" />

    <display:column property="netamount"   title="Net Amount" style="background-color:#fff;width:90px;text-align:center;"   sortable="false" headerClass="sortable" />
   
    <display:column property="transporter"   title="Transporter" style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable" />
   
    <display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="purchaseentryupdate" namespace="/" ><s:param  name="id" value="%{#attr.table123.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
   
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="purchaseentrydelete" namespace="/" ><s:param  name="id" value="%{#attr.table123.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    </s:else>
    </display:table>
    </div>
    </s:if>
  </div>

</center></body>
</html>