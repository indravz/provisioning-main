<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Details</title>
<link rel="stylesheet" type="text/css" href="styles.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
		function getDevices(zips){
			
			/* alert("Fetching states"); */
			var xmlHttp;
			if(zips=="")
			{
				document.getElementById("res").innerHTML="";
				return;
			}
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			/* 	alert("Created RequestObject"); */
			}
			else{
				
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlHttp.onreadystatechange=function(){
				
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					/* alert("Changing Response"); */
					document.getElementById("res").innerHTML=xmlHttp.responseText;
				}
			}
			
			xmlHttp.open("GET", "GetPortsServlet?zips="+zips, true);
			/* alert("Opened RequestObject"); */
			xmlHttp.send();
			/* alert("Sent RequestObject"); */
				
		}
		function alertfunction(){
			var xmlHttp;
			
			
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			/* 	alert("Created RequestObject"); */
			}
			else{
				
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlHttp.onreadystatechange=function(){
				
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					/* alert("Changing Response"); */
					console.log(xmlHttp.responseText);
					alert("Change request Proccessed Succesfully");
				}
			}
			
			xmlHttp.open("GET", "ModifyConnectionServlet", true);
			/* alert("Opened RequestObject"); */
			xmlHttp.send();
			/* alert("Sent RequestObject"); */
			
			
		}

</script>

</head>
<div class="layout" style="padding-top:185px;">
<body>

<%-- <h3>The selected circuit details are</h3>
<c:forEach var="e" items="circuit">
<c:out value="${e.sourcePort}"></c:out>
<c:out value="${e.destinationPort }"></c:out>
<c:out value="${e.orderId}"></c:out>
<c:out value="${e.bandwidthMbps}"></c:out>
<c:out value="${e.status}"></c:out>
</c:forEach> --%>
<h3>Select a new Location to modify the connection</h3>
<select name="zips" onchange="getDevices(this.value)">
<c:forEach var="e" items="${requestScope.zips}">
<option>
${e}
</option>

</c:forEach>

</select>

 
 
<div id="res">
		</div>
		<input class="vzbtn" type="button" value="submit" onclick="alertfunction()">
	<jsp:include page="Header2.jsp"></jsp:include>	
</body>
</div>
</html>