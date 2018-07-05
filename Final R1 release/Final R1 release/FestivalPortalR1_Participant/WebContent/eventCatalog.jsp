<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/include.jsp"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Welcome to Festival Event Registration System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />

<script type="text/javascript">
function previousPage()
{
	history.go(-1);
}
</script>

</head>
<body>
<br/><br/><br/>
	<table width="80%" align="center" border="2">
		<tr>
			<td>
			<div id="header">&nbsp;
			<div align="center">Festival
			Registration System</div>
			</div>

			<table>
				<tr>
					<td width="100%">
					<table align="right" cellpadding="2">
						<tr>
							<td width="90">
							<div id="menu" align="center"><a href="<jstlcore:url value="/index.jsp"/>">
							Logout </a></div>
							</td>
							<td width="160">
							<div id="menu" align="center"><a href="<jstlcore:url value="/searchVisitor.htm"/>">
							My Portal </a></div>
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
					<td width="900">
					<div align="center"><img src="images/greenhorizontalline.jpg"
						height="5" width="100%" /></div>
					<br />
					<div id="content" align="center">
					<h3>Up-coming Events</h3>
					<table width="96%" border="1" align="center">
						<tr bgcolor="#669966">
							<th scope="col">Event ID</th>
							<th scope="col">Event Name</th>
							<th scope="col">Description</th>
							<th scope="col">Places</th>
							<th scope="col">Duration</th>
							<th scope="col">Event Type</th>
							<th scope="col">Maximum Seats</th>
							<th scope="col">Available Seats</th>
						</tr>
						<jstlcore:forEach items="${allEvents}" var="event" >
							<tr>
							<td><jstlcore:out value="${event.eventid}"></jstlcore:out></td>
							<td><jstlcore:out value="${event.name}"></jstlcore:out></td>
							<td><jstlcore:out value="${event.description}"></jstlcore:out></td>
							<td><jstlcore:out value="${event.place}"></jstlcore:out></td>
							<td align="center"><jstlcore:out value="${event.duration}"></jstlcore:out></td>
							<td><jstlcore:out value="${event.eventtype}"></jstlcore:out></td>
							<td align="center"><jstlcore:out value="5000"></jstlcore:out></td>	
							<td align="center"><jstlcore:out value="${event.seatsavailable}"></jstlcore:out></td>
							</tr>
						</jstlcore:forEach>
						<tr align="center"><td colspan="8">
			<jstlcore:choose>
				<jstlcore:when test="${empty allEvents}"><h5 class="RED">There are currently no events upcoming. Please check back later. Thanks for visiting the event portal!</h5></jstlcore:when>
			</jstlcore:choose>
			</td></tr>	
					</table>

					</div>
					</td>
				</tr>
				<tr></tr>
				<tr><td><br/></td></tr>
				<tr><td><br/></td></tr>
				<tr><td><br/></td></tr>
			</table>
			</td>

		</tr>
		
	</table>

</body>

</html>
