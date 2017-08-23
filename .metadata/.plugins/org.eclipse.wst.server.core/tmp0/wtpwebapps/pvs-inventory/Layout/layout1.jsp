<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<!-- <script type="text/javascript">
window.onbeforeunload = function (e)
{
	e = e || window.event;
	e.returnValue="You want to leave";
};
</script>-->

</head>
<body>
<div style="display: block;height:100%;padding-bottom: 20px;overflow:auto;"><tiles:insertAttribute name="body" /></div>
</body>
</html> 