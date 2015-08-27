<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="styles.css">
   <meta charset="utf-8"> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<div class="container" style="padding-top:200px;">
<body>
<form action="DecisionServlet" method="post">
<table class="vztable">
<tr><td>Provision Options</td></tr>



<tr align="center"><td> <input type="radio" id="rb2" name="selectoption" value="provision">
<label for="rb2" >Provision Circuit</label></td></tr>

<tr align="center"><td ><input type="radio" id="rb1" name="selectoption" value="modify">
<label for="rb1" style="padding-right:45px;">Inventory</label></td></tr>



<tr align="center"><td><input type="radio" id="rb3" name="selectoption" value="viewnetwork">
<label for="rb3" style="padding-right:25px;">View network</label></td></tr>
<tr><td><input type="submit" value="Submit" class="vzbtn"/></td></tr>
</table>
</form>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</div>
</html>