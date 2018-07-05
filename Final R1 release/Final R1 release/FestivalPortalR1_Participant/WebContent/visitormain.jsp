<%@ include file="/include.jsp"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Welcome to Festival Event Registration System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
<script language="JavaScript">
<!--
var nHist = window.history.length;
if(window.history[nHist] != window.location)
  window.history.forward();
//-->
</script>
<style type="text/css">
<!--
.style1 {
	font-size: 12px;
	font-weight: bold;
}
-->
</style>
<style>
.error {
	color: red;
	font-weight: bold;
	font-size: 20px;
}
</style>
</head>

<body>
	
	<table width="80%" align="center" border="2">
		<tr>
			<td>
			<div id="header">&nbsp;
			<div align="center">
			Festival Registration System</div>
			</div>

			<table>
				<tr>
					<td width="100%">
					<table class="mt" align="right" cellpadding="2">
						<tr>
							<td width="90">
						<div id="menu" align="center"><a href="<jstlcore:url value="/index.jsp"/>">
							Logout </a></div>
							</td>
							<td width="160">
							<div id="menu" align="center"><a
								href="<jstlcore:url value="/changePWD.jsp"/>"> Change Password </a></div>
							</td>
							<td width="160">
							<div id="menu" align="center"><a
								href="<jstlcore:url value="/catalog.htm"/>"> Event Catalog </a></div>
							</td>
							<td width="90">
							<div id="menu" align="center"><a href="<jstlcore:url value="/about.jsp"/>">
							About</a><br />
							</div>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td width="1000">
					<table cellpadding="5" width="100%">
						<tr>
							<td>
							<div align="center" id="content">
							<h3>Festival Portal Page: Welcome, <span style="background-color: yellow;"><jstlcore:out value="${visitor.firstName} ${visitor.lastName}"></jstlcore:out></span> to your portal page.....</h3>
							</div>							
							<table cellpadding="4" border="1">
								<tr>
									<td width="1000">
									<div id="coursesbody" align="left">
									<p><strong>Your personal
									information</strong> is below. To change your information, 
									<a href="<jstlcore:url value="/updatevisitor.jsp?vname=${visitor.userName}&fname=${visitor.firstName}&lname=${visitor.lastName}&email=${visitor.email}&phoneno=${visitor.phoneNumber}&address=${visitor.address}"/>">click here </a></p>
									<p class="style1">Username :<jstlcore:out value="${visitor.userName}"></jstlcore:out></p>
								 	<p class="style1">Visitor ID: <jstlcore:out value="${visitor.visitorId}"></jstlcore:out></p>
									<p class="style1">Email: <jstlcore:out  value="${visitor.email}"></jstlcore:out></p>
									<p class="style1">Phone Number: <jstlcore:out value="${visitor.phoneNumber}"></jstlcore:out></p>
									<p class="style1">Address: <jstlcore:out value="${visitor.address}"></jstlcore:out></p>
									</div>
									</td>
								</tr>
							</table>
							<br />
						<div align="center"><img src="images/greenhorizontalline.jpg"
				height="5" width="100%" /></div>
							<div id="content" align="center">
							<p class="content"><strong>To release a ticket you have for an up-coming attraction, please find the attraction below, and click the Release link.</strong></p>
							<table  width="96%" border="1" align="center">
								<tr bgcolor="#66CC99">
									<th scope="col">Confirmation #</th>
									<th scope="col">Event id</th>
									<th scope="col">Event name</th>
									<th scope="col">description</th>
									<th scope="col">Places</th>
									<th scope="col">Duration</th>
									<th scope="col">Event type</th>
									<th scope="col">Action</th>
								</tr>
                                
                               	<jstlcore:forEach items="${regEvents}" var="regEvent">
									<tr align="center">
										<td><jstlcore:out value="${fn:substring(visitor.lastName,0,4)}${fn:substring(visitor.firstName,0,3)}-${regEvent.signupid}"></jstlcore:out></td>
										<td align="center"><jstlcore:out value="${regEvent.eventid}"></jstlcore:out></td>
										<td align="center"><jstlcore:out value="${regEvent.name}"></jstlcore:out></td>
										<td align="center"><jstlcore:out value="${regEvent.description}"></jstlcore:out></td>
										<td align="center"><jstlcore:out value="${regEvent.place}"></jstlcore:out></td>
										<td align="center"><jstlcore:out value="${regEvent.duration}"/></td>
										<td align="center"><jstlcore:out value="${regEvent.eventtype}"/></td>
										
										<td width="100px" bgcolor="#CCCC99">
										<a href="<jstlcore:url value="/eventunreg.htm?eventId=${regEvent.eventid}"/>">Release</a>
										</td>
									</tr>									
								</jstlcore:forEach>
								<tr>
									<td colspan="9" align="center" style="font-weight: bold; color: red;" >${RegError}</td>
								</tr>
							</table>

							</div>
							</td>
						</tr>
					</table>
					</td>

				</tr>

			</table>




			<div align="center"><img src="images/greenhorizontalline.jpg"
				height="5" width="100%" /></div>
			<br />
			<div id="content" align="center">
			<p class="content"><strong>To get a ticket for an up-coming attraction, please find the attraction below, and click the Register link.</strong></p>
			<table class="content" width="96%" border="1" align="center">
				<tr bgcolor="#66CC99">
					<th scope="col">Event id</th>
					<th scope="col">Event name<br/>
					<!--  a href="<jstlcore:url value="/displayasc.htm"/>"><img src="images/upointer.jpg" width="20" height="20"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<jstlcore:url value="/displaydesc.htm"/>"><img id="rt" src="images/upointer.jpg"  width="20" height="20"/></a-->
					</th>
					<th scope="col">description</th>
					<th scope="col">Places</th>
					<th scope="col">Duration</th>
					<th scope="col">Event type</th>
					<th scope="col">Available Tickets</th>
				</tr>
				<jstlcore:forEach items="${allEvents}" var="event" >
					<tr>
					<td align="center"><jstlcore:out value="${event.eventid}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${event.name}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${event.description}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${event.place}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${event.duration}"></jstlcore:out></td>
					<td><jstlcore:out value="${event.eventtype}"></jstlcore:out></td>
				<jstlcore:choose>
					  <jstlcore:when test="${event.seatsavailable != 0}">
							<td width="100px" bgcolor="#CCCC99" align="center">
							<jstlcore:out value="${event.seatsavailable}"></jstlcore:out>
							<strong> seats left.</strong>
						 	    <a href="<jstlcore:url value="/eventreg.htm?eventId=${event.eventid}"/>">Register</a>						 	 
							</td>
						</jstlcore:when>		
						<jstlcore:otherwise>
							<td width="100px" bgcolor="#CCCC99" align="center"><strong>No
							seats left</strong></td>
						</jstlcore:otherwise>						
						</jstlcore:choose>
					</tr>
				</jstlcore:forEach>
			
				
			</table>
	
			</div>
			</td>
			</tr>
	</table>



</body>

</html>
