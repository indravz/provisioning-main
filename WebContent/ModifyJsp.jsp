<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify</title>
<link rel="stylesheet" type="text/css" href="styles.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<form name="modify" action="ModifyServlet">
<h1 align="center">Modify Order </h1>
<h2>Circuits Of the Current Customer</h2>
<h3>Select one circuit to modify</h3>
<br><br>
<select name="circuit">
<c:forEach var="e" items="${circuits}">
<option value="${e.orderId}"><c:out value="${e.sourcePort}"></c:out>,<c:out value="${e.destinationPort}"></c:out>,<c:out value="${e.orderId}"></c:out>,<c:out value="${e.bandwidthMbps}"></c:out>,<c:out value="${e.status}"></c:out>
</option>
</c:forEach>
</select>

<br><br>
<input type="submit" name="submit" value="submit" onclick="alertfunction()" class="vzbtn" align="middle"/> 
</form>
<script>
function alertfunction(){
	var c = confirm("Do you want to modify the order?");
	if(c==true){
		document.modify.submit();
	}
	else{
		document.write("You selected Cancel");
	}
		
	}
	</script>
</body>
</html>