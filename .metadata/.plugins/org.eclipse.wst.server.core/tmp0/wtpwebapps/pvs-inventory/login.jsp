<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<link href="css/style1.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> 
			addEventListener("load", function() 
					{ 
					setTimeout(hideURLbar, 0); 
					}, 
					false); 
			function hideURLbar()
			{ 
				window.scrollTo(0,1); 
			} 
		</script>
		
<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>
<title>Login</title>
</head>
 
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="" style="background: url(account-5.jpg) center center no-repeat fixed; background-size: cover; -o-background-size: cover; -ms-background-size: cover; -moz-background-size: cover; -webkit-background-size: cover;">
	<div style="position: absolute; top: 0; bottom: 0; left: 0; right: 0; background: #ffffff; opacity: 0.5;"></div>
	<div class="main">
		<c:if test="${not empty error}">
				<div
					style="color: #CC0099; padding-top: 10px; padding-right: 10px; padding-left: 10px;">
					Login error : Please try again.<br />It May be cause of
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
		</c:if>
		<form name="f" action="<c:url value='j_spring_security_check' />"	method="post">
    		<div>
    		<h1><lable>Log-In</lable> </h1>
  			<div class="inset">
	  			<p>
	    		 	<label for="email">USER NAME</label>
   	 				<input type="text" name='j_username' placeholder="" required/>
				</p>
  				<p>
				    <label for="password">PASSWORD</label>
				    <input type="password" name='j_password' placeholder="" required/>
  				</p>
 			 </div>
			  <p class="p-container">
			   
			    <input type="submit" value="Login">
			  </p>
			  </div>
		</form>
	</div>  
			
</body>
</html>