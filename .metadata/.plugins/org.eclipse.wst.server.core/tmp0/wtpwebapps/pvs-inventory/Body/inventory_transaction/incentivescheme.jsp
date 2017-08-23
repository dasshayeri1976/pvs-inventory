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
                target:"from",
                dateFormat:"%Y-%m-%d"
            });
            
            new JsDatePick
            ({
                useMode:2,
                target:"to",
                dateFormat:"%Y-%m-%d"
            });
            
            new JsDatePick
            ({
                useMode:2,
                target:"refdate",
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
function calminqty()
{
	var minqty=document.getElementsByClassName("minqty");
	var extra=document.getElementsByClassName("extra");
	var offered=document.getElementsByClassName("offeredmin");
	for(var i=0;i<minqty.length;i++)
	{
		if(minqty[i].value != "")
		{
			offered[i].value=Math.round((Number(minqty[i].value)*Number(extra[i].value))/100);
		}
	}
}
function validate()
{
	//alert();
	var x=document.getElementsByClassName("extra");
	for(var i=0;i<x.length;i++)
	{
		var val=x[i].value;
		//alert(val.length);
		if(val.length > 3)
		{
			x[i].value=x[i].value.substring(0,3);
		}
		var dotpos=x[i].value.split(".");
		x[i].value=dotpos[0];
	}
	calminqty();
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
/*$(document).keydown(function(evt)
     {
        if((evt.keyCode==190) || (evt.keyCode==110))
            {
               
            }
    });
*/
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
function getmat1()
{
	if (typeof XMLHttpRequest != "undefined")
    {
        getmat = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
    	getmat = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (getmat == null)
    {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    var s1 = document.getElementById("company").value;
    var url = "./Body/inventory_transaction/getmaterial.jsp";
    url += "?count=" +s1;
    //alert(url);
    getmat.onreadystatechange = codegetmat;
    getmat.open("GET", url, true);
    getmat.send(null);
}
function codegetmat()
{
    if (getmat.readyState == 4 || getmat.readyState == "complete")
    {
    	var x=getmat.responseText;
    	x=x.trim();
    	document.getElementById("table12").style.display="block";
    	document.getElementById("table12").innerHTML=x;
    }
};
function PersonViewModel(x)
{
    rowIndex=$(x).closest('tr').index();
}
function copydate()
{
	document.getElementById("to").value=document.getElementById("from").value;
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
  <s:form action="incentiveschemecreation" namespace="/" method="post" autocomplete="off">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
   
    
  <fieldset style="width:65%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;"><h3>Trade Incentive Scheme</h3></legend>
 
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
        </tr>
        <tr>
              <td width="12.5%" style=""><label>From</label></td>
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.from" id="from" cssClass="from" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;" onblur="copydate();"></s:textfield></td>
              
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>To</label></td>
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.to" id="to" cssClass="to" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;" onfocus=""></s:textfield></td>
        </tr>
   </table>
  <div >
  <table id="table12" border="0" width="100%" cellpadding="0" style="display:none">  
    <tr bgcolor="#4292b2" style="color:white">
    
   <th width="6.5%" ><label>Product Name</label></th>
    <th width="6.5%" ><label>Packing</label></th>
    <th width="6.5%" ><label>Valid Min. Qty</label></th>   
    <th width="6.5%" ><label>Extra Gain %</label></th>
    <th width="6.5%" ><label>Offered Min Qty</label></th>
    </tr>
    <tr>   
        <td width="6.5%" ><s:textfield name="formbean.pname" id="pname" cssClass="pname" cssStyle=" border:1px solid #ccc;height:20px;background:#FFFF99;width:280px;height:25px" onchange="PersonViewModel(this);getunit()"></s:textfield></td>
        <td width="6.5%" ><s:textfield name="formbean.packingar" readonly="false" id="packing" cssClass="packing" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;"></s:textfield></td>
        <td width="6.5%" ><s:textfield name="formbean.minqty" readonly="false" id="minqty" cssClass="minqty" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;"></s:textfield></td>
        <td width="6.5%" ><s:textfield name="formbean.extra" readonly="false" id="extra" cssClass="extra" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;"></s:textfield></td>
        <td width="10.5%" ><s:textfield name="formbean.offeredmin" readonly="false" id="offeredmin" cssClass="offeredmin" size="27" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;width:100px;" onkeyup="caltotal();"></s:textfield></td>
    </tr>

  </table>
  </div>
    <br/>
    
  <table width="80%" border="0" style="border:0px solid"> 
 
          <tr style="border:1px solid">   
              <td width="12.5%" style="">Ref.&nbsp;No.</td>
               <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.refno" id="refno" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
             
              <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><label>Ref.&nbsp;Date</label></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.refdate" id="refdate" size="25" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99;"></s:textfield></td>
        </tr>
        
        <tr>
            <td width="12.5%" style="" colspan="2" rowspan="3"><s:textarea name="formbean.singlenarration" cols="53" rows="4" maxlength="275" cssStyle="border:1px solid #ccc;background:#FFFF99;resize:none;"/></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            
           
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
            <td width="12.5%" style="padding-left:15px; padding-right:15px;"></td>
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
    <display:table id="table123"  name="usList3"  class="imagetable" requestURI=""     export="true" style="width:98%;color:#000">
       
     <s:if test="%{#attr.table123.id == formbean.id}">
   
    <display:column property="company"   title="Principal" style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable" />
   
    <display:column property="material"   title="Materials"  style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable"/>
   
    <display:column property="period"   title="Period" style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable" />
    
    </s:if>
   
    <s:else>
    
    <display:column property="company"   title="Principal" style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable" />
   
    <display:column property="material"   title="Materials"  style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable"/>
   
    <display:column property="period"   title="Period" style="background-color:#fff;text-align:center;"   sortable="false" headerClass="sortable" />
    
    </s:else>
    </display:table>
    </div>
    </s:if>
  </div>

</center></body>
</html>