<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
   <meta charset="utf-8"> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  

<title>Inventory Modification</title>
<script>
function test(inp1,inp2,inp3,inp4,inp5,inp6,inp7,inp8){
// 	console.log("reached");
// 	console.log(inp1);
if(inp1==""||inp2==""||inp3==""||inp4==""||
				inp6==("SELECT")||inp7==""||inp8=="")
	{alert("Enter values in all the fields");
	return;}
	else {
	alert(inp1+" "+inp2+" "+inp3+" "+inp4+" "+inp5+" "+inp6+" "+inp7+" "+inp8);
	
var url="AddServlet?inp1="+inp1+"&"+"inp2="+inp2+"&"+"inp3="+inp3+"&"+"inp4="+inp4+"&"+"inp5="+inp5+"&"+"inp6="+inp6+"&"+"inp7="+inp7+"&"+"inp8="+inp8;  
    
    if(window.XMLHttpRequest){  
    request=new XMLHttpRequest();  
    }  
    else if(window.ActiveXObject){  
    request=new ActiveXObject("Microsoft.XMLHTTP");  
    }  
      
    try{  
    request.onreadystatechange=getInfo;   
    request.open("POST",url,true);  
    request.send();  
    }catch(e){alert("Unable to connect to server");}  
	}
    function getInfo(){  
        if(request.readyState==4){  
        
        	var val=request.responseText;  
        
       alert(val);
       clearFields();
        }  
        }  
          
	
	
}
function clearFields()
{
    document.getElementById("n1").value="";
    document.getElementById("n2").value="";
    document.getElementById("n3").value="";
    document.getElementById("n4").value="";
    document.getElementById("n5").value="";
    document.getElementById("n6").value="SELECT";
    document.getElementById("n7").value="";
    document.getElementById("n8").value="";
     
}
</script>
</head>
<body>
<div>

<table class="vztable" id="addinvent">
<tr align="center" >
<td colspan="2">Add a new Device</td>
</tr>
<tr>
<td>Deviceid</td><td><input type="text" name="n1" id ="n1" placeholder="Enter device id"/></td></tr>
<tr>
<td>Part number</td><td><input type="text" name="n2" id ="n2" placeholder="Enter part number" /></td></tr>
<tr>
<td>Manufacturer</td><td><input type="text" name="n3" id="n3" placeholder="Enter the manufacturer"/></td></tr>
<tr>
<td>ZipCode</td><td><input type="text" name="n4" id="n4" placeholder="Enter the zipcode "/></td></tr>

<tr><td>PortId</td><td><input type="text" name="n5" id="n5" placeholder="Enter the portid"/></td></tr>
<tr>
<td>Status</td><td><select name="input6" id="n6">
 <option  value="SELECT" selected disabled>SELECT</option>
  <option  value="VACANT">VACANT</option>
  <option value="RESERVED">RESERVED</option>
  <option value="REPAIR">REPAIR</option>
   <option value="OUTOFORDER">OUTOFORDER</option>
  </select></td></tr>
<tr>
<td>BandWidth</td><td><input type="text" name="n7" id="n7" placeholder="Enter the bandwidth"/></td></tr>
<tr>
<td>Device Type</td><td><input type="text" name="n8" id="n8" placeholder="Enter the Device type"/></td></tr>


<tr>
<td colspan="2"><button class="vzbtn"  onclick="test(document.getElementById('n1').value,document.getElementById('n2').value,document.getElementById('n3').value,document.getElementById('n4').value,document.getElementById('n5').value,document.getElementById('n6').value,document.getElementById('n7').value,document.getElementById('n8').value)">Add Device</button></td>
</tr>
<tr>
 <td colspan="2"><input type="reset" value="clear" class="vzbtn" onClick="clearFields()"/></td>
</tr>
</table>

</div>
<span id="amit"> </span> 



</body>
</html>