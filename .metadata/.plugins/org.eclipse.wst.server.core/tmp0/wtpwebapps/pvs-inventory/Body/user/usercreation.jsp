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
		
		var b = document.getElementById('username');
		var c = document.getElementById('userpass');
		var d = document.getElementById('roll');
		var e = document.getElementById('status');

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

<%

ArrayList<String> obj = new ArrayList<String>();

Connection conn = ConnectionDAO.getConnectionObject();
Statement stm = ConnectionDAO.createStatement(conn);
try {

	
	ResultSet rs = stm.executeQuery("select * from engineer_master");
	while (rs.next()) {

		obj.add(rs.getString(3));
		
		
	}
	
	
} catch (SQLException e) {
	e.printStackTrace();
}

ConnectionDAO.closeConnection(conn);

%>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
$(function() {
	var availableTutorials = [<% for (int i = 0; i < obj.size(); i++) { %>"<%= obj.get(i)%>"<%= i + 1 < obj.size() ? ",":"" %><% } %>];
   //alert('Avi');
   $( "#name" ).autocomplete({
      source: availableTutorials
   });
});
</script>

</head>

<body><center>

<div>
<ul id="breadcrumbs">
<li ><a href="#">System Settings</a></li>
<li >User creation</li>
</ul>
</div>

<s:if test="hasActionMessages()">
<div class="welcome">
<s:actionmessage/>
</div>
</s:if>
    
  <fieldset style="width:80%; border:solid thin #c6d5e1;Padding:5px;">
  <legend style="color:red;">User Creation</legend>
  
  <s:form action="usercreation" namespace="/" method="post">
  <input type="hidden" name="formbean.id" value="<s:property value="formbean.id"/>"/>
  
  <table width="80%" style="padding:10px;" >
	
	 <tr>
      	
      	<td width="12.5%" style="padding-left:15px; padding-right:15px;">Name</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.name"  id="name" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
        
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">User_Name</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.username" id="username"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" onkeypress="checkName();"></s:textfield></td>
              
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">Roll</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.roll" id="roll" list="#{'':'', 'ROLE_ADMIN':'ROLE_ADMIN', 'ROLE_CORD':'ROLE_CORD', 'ROLE_ENGR':'ROLE_ENGR'}" cssStyle=" border:1px solid #ccc;height:25px;background:#FFFF99;width:110px;"></s:select></td>
	    
	    <td width="12.5%" style="padding-left:15px; padding-right:15px;">Status</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:select name="formbean.userstatus" id="status" list="#{'':'', '1':'Enable','0':'Disable'}" cssStyle=" border:1px solid #ccc;height:25px;background:#FFFF99;width:110px;"></s:select></td>
       
        
	  </tr>
      <tr>
      	
      	
        <td width="12.5%" style="padding-left:15px; padding-right:15px;">P_No</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.pon" id="pon"  size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99" ></s:textfield></td>
      	
	  	<td width="12.5%" style="padding-left:15px; padding-right:15px;">Pass</td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;"><s:textfield name="formbean.userpass"  id="userpass" size="30" cssStyle="height:25px;border:1px solid #ccc;background:#FFFF99"></s:textfield></td>
               
        <td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top"></td>
		<td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top"></td>
         
        <td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top" ></td>
        <td width="12.5%" style="padding-left:15px; padding-right:15px;" valign="top" ></td>
	  </tr> 
	  
    </table>
    <br/>
   	  <div align="center" style="width:100%; position:relative;border-bottom:solid thin #c6d5e1;">
      </div>
      <div align="right" style="width:99%;position:relative;  padding:7px;">
        
      	<s:submit name="formbean.save" value="Save User" cssClass="butStnd" onclick="return Validate();" ></s:submit>
        
      </div>
      
    </s:form>
  </fieldset>
	
	<p>&nbsp;</p>
	<s:if test="usList">
	
	<display:table id="table"  name="usList" pagesize="25"  class="imagetable" requestURI=""     export="true" style="width:85%;color:#000">
	    
	 <s:if test="%{#attr.table.id == formbean.id}">
	 
    <display:column property="name"   title="Name"  style="background-color:#ecf2f6;"  sortable="false" headerClass="sortable" />
	
	<display:column property="username"   title="Username" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="userpass"   title="Password"  style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="userstatus"   title="User-Status" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="pon"   title="Phone" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="roll"   title="RoleType" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column property="ctype"   title="callType" style="background-color:#ecf2f6;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="userupdate" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#ecf2f6;" >
    <a href="<s:url action="userdelete" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:  #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
	</s:if>
	<s:else>
		 
    <display:column property="name"   title="Name"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
	
	<display:column property="username"   title="Username"  style="background-color:#fff;"  sortable="false" headerClass="sortable" />
	
	<display:column property="userpass"   title="Password"  style="background-color:#fff;"   sortable="false" headerClass="sortable"/>
	
	<display:column property="userstatus"   title="User-Status" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="pon"   title="Phone" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="roll"   title="RoleType" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column property="ctype"   title="callType" style="background-color:#fff;"   sortable="false" headerClass="sortable" />
	
	<display:column title="Update" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="userupdate" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color:#fff;text-decoration:none;font-size:12px;" class="classname">Update</a>
    </display:column>
    
    <display:column title="Delete" media="html" style="text-align: center;width:8%;background-color:#fff;" >
    <a href="<s:url action="userdelete" namespace="/" ><s:param  name="id" value="%{#attr.table.id}"></s:param></s:url>" style="color: #fff;text-decoration:none;font-size:12px;" class="print" onclick="return confirmation();">Delete</a>
    </display:column>
    
	</s:else> 
	   
    </display:table>
	</s:if>
	
  <br/>
  
 
    
    <!--<script language="javascript" type="text/javascript">
//<![CDATA[
	setFilterGrid("table");
//]]>
</script>-->
          
   
</center></body>
</html>
