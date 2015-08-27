<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Add Order</title>
<script>
		function getDevicesInZipcode(zipcode){
			var xmlHttp;
			
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}
			else{
				
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlHttp.onreadystatechange=function(){
				
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					document.getElementById("res").innerHTML=xmlHttp.responseText;
				}
			}
			
			xmlHttp.open("GET", "DeviceServlet?zipcode="+zipcode, true);
			/* alert("Opened RequestObject"); */
			xmlHttp.send();
			
		}

		
		function checkPort()
		
		{
			console.log("reached here");
			var dev= document.getElementById("device");
			var xmlHttp;
			
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}
			else{
				
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlHttp.onreadystatechange=function(){
				
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var x = xmlHttp.responseText;
					console.log(x);
					if(x=='-1'){
						alert("No vacant ports. Choose another device.")
					}
					else{
					document.getElementById("pSrc").innerHTML=xmlHttp.responseText;
					}
				}
			}
			
			xmlHttp.open("POST", "GetVacantPortIdsServlet?device="+dev, true);
			/* alert("Opened RequestObject"); */
			xmlHttp.send();
				
		}
		
		
		function checkDPort()
		{
			var ddev= document.getElementById("ddevice");
			var xmlHttp;
			
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}
			else{
				
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlHttp.onreadystatechange=function(){
				
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var x = xmlHttp.responseText;
					console.log(x);
					if(x=='-1'){
						alert("No vacant ports. Choose another device.")
					}
					else{
					document.getElementById("pDest").innerHTML=xmlHttp.responseText;
					}
				}
			}
			
			xmlHttp.open("POST", "GetVacantDPortIdsServlet?ddevice="+ddev, true);
			/* alert("Opened RequestObject"); */
			xmlHttp.send();
			
			
		
			
		}
		
</script>
</head>
<body>
	
<h1 class="vzh1">Add Ports</h1>
	
	<form name="adddata" action="AddComplete">
	<table style="width:100%" class="vztable">
	<tr>
	<td></td>
	<td class="vzred">Zipcode</td>
	<td class="vzred">Device</td>
	<td class="vzred">Port</td>
	</tr>
	<tr>
	<td class="vzred">Source:</td>
	<td><select name="zipcode" onchange="getDevicesInZipcode(this.value)">
		<option value="">Select zipcode</option>
		<c:forEach var="ld" items="${l}">
			<option><c:out value="${ld}" />
			</option>
		</c:forEach>
	</select></td>
	
	<td><div id="res"  class="vzred">			
	</div></td>
	<td> 
	<div id="pSrc" class="vzred">
	
	</div> </td>
	</tr>
	<tr>
	<td>Destination</td>
	<td>
	<div>
	
	
	 <c:out value="${dzip}" />
	</div></td>
	<td>
	<div>
	<select name="ddevice" onchange="checkDPort()">
		<option value="">Select device</option>
		<c:forEach var="ld" items="${ddevice}">
			<option><c:out value="${ld}" />
			</option>
		</c:forEach>
	</select>
	</div></td>
	<td>
	<div id="pDest" class="vzred">
	 
	</div> </td>
	
	</tr>
	<tr>
	<td></td><td></td>
	<td>
	
	<input class="vzbtn" type="submit" value="Submit" />
	</td>
	<td>
	<input class="vzbtn1" type="reset" value="Cancel"/>
	</td>
	</tr>
	</table>
	</form>
</body>
</html>