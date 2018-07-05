<%@page import="com.accenture.adf.businesstier.entity.Visitor" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ include file="./include.jsp"%>

<html>
<head>
<title>Welcome to Festival Event Registration System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />


<script type="text/javascript">

	function validateForm(){	
		var pwd=document.forms["changePWD"]["password"].value;	
		var cpwd=document.forms["changePWD"]["cpassword"].value;	
		
		if (pwd==null || pwd==""){
		  alert("Please provide password");
		  return false;
		}
		
		if(pwd!=cpwd){
			alert("Password and confirm password must be same !!");
			return false;
		}	
	}
	
	function cancelUpdate(){
		alert("Password change request has been cancelled");
		//window.location.replace("visitormain.jsp");
		document.forms[0].action = "./searchVisitor.htm";
		document.forms[0].submit();
	}
	
	function displayStatus(){
		var updstatus=document.forms["changePWD"]["status"].value;
		if(updstatus=="success"){
			alert("Visitor password succesfully updated, please login with the new password");
			window.location.replace("index.jsp");		
		}
	}
	
	function mouseoverPass(obj) {
		  var obj = document.getElementById('myPassword');
		  obj.type = "text";
		}
		function mouseoutPass(obj) {
		  var obj = document.getElementById('myPassword');
		  obj.type = "password";
		}

		function cmouseoverPass(obj) {
			  var obj = document.getElementById('cmyPassword');
			  obj.type = "text";
			}
		function cmouseoutPass(obj) {
			  var obj = document.getElementById('cmyPassword');
			  obj.type = "password";
			}		

	</script>

<style>
.error {
	color: red;
}
</style>
</head>

<body onload="displayStatus()">	
	
	<form method="post" name="changePWD" action="changePWD.htm" onsubmit="return validateForm()">
	<input type="hidden" name="status" value="${status}">
	<table width="80%" border="1" align="center">
		<tr>
			<td>
				<div id="header">&nbsp;
				<div align="center">Festival Registration System</div>
				</div>
			</td>
		</tr>
		<tr>
			<td>
			<table align="center" border="0">				
				<tr>
					<td >
					<div id="style1" align="center">
					<h3>Change Password Screen</h3>
					<br />
					</div>
					<table align="center" border="0">

						<tbody>
							<tr><td align="center" colspan="2" style="font-style: italic;">Fields marked (<span style="font-weight: bold;color: red; font-size: 15px;">*</span>) are Mandatory</td></tr>
						<tr><td></td><td></td></tr>
						<tr><td></td><td></td></tr>							
							
							<tr>
								<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>New Password:</td>
								<td><input type="password" id="myPassword" name="password" size="27"/>&nbsp; <img src="http://www.pvhc.net/img65/vrfvqdosmwzrxtstyrdb.png" width="20" height="17" onmouseover="mouseoverPass();" onmouseout="mouseoutPass();" /></td>
							</tr>
							
							<tr>
								<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>Confirm New Password:</td>
								<td><input type="password" id="cmyPassword" name="cpassword" size="27"/>&nbsp; <img src="http://www.pvhc.net/img65/vrfvqdosmwzrxtstyrdb.png" width="20" height="17" onmouseover="cmouseoverPass();" onmouseout="cmouseoutPass();" /></td>
							</tr>					
							
							<tr>
								<td colspan="2" align="right"><input value="Cancel" type="Button" onclick="cancelUpdate()">
								<input value="Update" type="submit" ></td>
							</tr>
							
						</tbody>
						
					</table>
					</td>
					<!-- content end -->
				</tr>
				<tr>
						<td colspan="2" align="center"><span style="font-weight: bold;color: red;font-size: 15px;">${errorMsg}</span></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>

</form>
</body>

</html>
