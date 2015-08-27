<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<!-- <meta charset="ISO-8859-1"> -->
<title>Provisioning Disconnect</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
   <meta charset="utf-8"> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
function confirmDisconnect() {
	var r = confirm("Do you really want to disconnect?");
	if (r == true) {
		document.disconn.submit();
	} else {
	   /*  x = "You pressed Cancel!"; */
	}
}
</script>
</head>
<div class="layout" style="padding-top:185px";>
<body>
<h1 class="vzh1">Disconnect</h1>
<h2>Order Details</h2>

<form name="disconn" action="Disconnect" method="get">
    OrderId: <input type="text" name="orderid">
</form>


<button type="button" class="vzbtn" onclick="confirmDisconnect()">Disconnect</button>
</div>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>