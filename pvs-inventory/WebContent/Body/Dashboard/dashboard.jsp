<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %> 
<!DOCTYPE html>
<html>
<head>
<script>
function changecolor2()
{
	document.getElementById("abc").style.color="blue";
	document.getElementById("abc").style.fontSize ="large";
	setTimeout(changecolor, 1000);
}
function changecolor1()
{
	document.getElementById("abc").style.color="darkgreen";
	document.getElementById("abc").style.fontSize ="medium";
	setTimeout(changecolor2, 1000);
}
function changecolor()
{
	document.getElementById("abc").style.color="red";
	document.getElementById("abc").style.fontSize ="small";
	setTimeout(changecolor1, 1000);
}
</script>
</head>

<body onload="changecolor();">
<center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<span id="abc">
    <h1><font>Dashboard</font></h1>
</span>
</center>
</body>
</html>
