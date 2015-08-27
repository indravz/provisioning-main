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

    <style type="text/css">
        #mynetwork {
            width: 600px;
            height: 400px;
            border: 1px solid lightgray;
        }
    </style>
    <script type="text/javascript">

	function display(){
		console.log(DOTstring);
		var parsedData = vis.network.convertDot(DOTstring);

		var data = {
	  	nodes: parsedData.nodes,
	  	edges: parsedData.edges
		}

	var options = parsedData.options;
	    
	    // create a network
	    var container = document.getElementById('mynetwork');

	    var options = {};

	    // initialize your network!
	    var network = new vis.Network(container, data, options);
	    
	    /* network.on("selectNode", function (params) {
	        params.event = "[original event]";
	       
	        //document.getElementById('nodeId').innerHTML = params.nodes;
	        getDeviceDetails(params.nodes);
	    });
	    
	      network.on("selectEdge", function (params) {
	        params.event = "[original event]";
	       
	        //document.getElementById('EdgeSelected').innerHTML = '<h2>Click event:</h2>' + JSON.stringify(params, null, 4);
	        //console.log(params.edges[0]);
	        //console.log(network.getConnectedNodes(params.edges[0])[0]);
	        //console.log(network.getConnectedNodes(params.edges[0])[1]);
	        var srcNode=network.getConnectedNodes(params.edges[0])[0];
	        var destNode=network.getConnectedNodes(params.edges[0])[1];
	        getCircuitDetails(srcNode, destNode);
	        
	    });   */
	    
	     network.on("select", function (params) {
	        params.event = "[original event]";
	        if(params.nodes==""){
	        	//alert("reached get device");
	        	getCircuitDetails(params.nodes);
	        }
	        else
	        	{
	        	var srcNode=network.getConnectedNodes(params.edges[0])[0];
		        var destNode=network.getConnectedNodes(params.edges[0])[1];
		        console.log("source is :"+ srcNode);
		        console.log("destination  is :"+ destNode);
	        	getAllDetails(params.nodes,srcNode, destNode);
	        	}
	        	
	       
	        	
		        
	        	
		        	       
	    }); 
	    
	   /*  network.on("select", function (params) {
	        params.event = "[original event]";
	       
	        document.getElementById('Info').innerHTML = '<h2>Click event:</h2>' + JSON.stringify(params, null, 4);
	       
	        
	    });  */  
	    
	    
	     
	    /*  network.on("deselectNode", function (params) {
	    	document.getElementById('NodeSelected').innerHTML ="";
	     });
	     network.on("deselectEdge", function (params) {
	    	 document.getElementById('EdgeSelected').innerHTML ="";
	     });
	     */
	    
		
	}
	
function getAllDetails(nodeid, srcNode, destNode){
		
		var XMLHttp;
		console.log("values received");
		 console.log("source is :"+ srcNode);
	        console.log("destination  is :"+ destNode);
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}
		else{			
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlHttp.onreadystatechange=function(){
			
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
				document.getElementById('Output').innerHTML=xmlHttp.responseText;
			}
		}
		
		xmlHttp.open("POST", "GetAllDetailsServlet?nodeid="+nodeid+"&"+"srcNode="+srcNode+"&"+"destNode="+destNode, true);
		/* alert("Opened RequestObject"); */
		xmlHttp.send();
	}
	

	
function getCircuitDetails(srcNode, destNode){
		
		var XMLHttp;
		console.log("values received");
		 console.log("source is :"+ srcNode);
	        console.log("destination  is :"+ destNode);
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}
		else{			
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlHttp.onreadystatechange=function(){
			
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
				document.getElementById('Output').innerHTML=xmlHttp.responseText;
			}
		}
		
		xmlHttp.open("POST", "GetCircuitDetailsServlet?srcNode="+srcNode+"&"+"destNode="+destNode, true);
		/* alert("Opened RequestObject"); */
		xmlHttp.send();
	}
	

	
	function getDeviceDetails(nodeid){
		
		var XMLHttp;
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}
		else{			
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlHttp.onreadystatechange=function(){
			
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
				document.getElementById('NodeSelected').innerHTML=xmlHttp.responseText;
				
			}
		}
		
		xmlHttp.open("POST", "GetDeviceDetailsServlet?nodeid="+nodeid, true);
		/* alert("Opened RequestObject"); */
		xmlHttp.send();
	}
	
	function getData(){
		var XMLHttp;
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}
		else{			
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlHttp.onreadystatechange=function(){
			
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
				DOTstring=xmlHttp.responseText;
				display();
			}
		}
		
		xmlHttp.open("POST", "GetDataServlet", true);
		/* alert("Opened RequestObject"); */
		xmlHttp.send();
		/* alert("Sent RequestObject"); */

		
		//DOTstring = 'dinetwork {1 -> 1 -> 2; 2 -> 3; 2 -- 4; 2 -> 1 }';
		
	}

	
</script>
<div class="layout" style="padding-top:185px;">
</head>
<body>
<input type="button" onClick="getData()" value="View Network Design" />

<div id="mynetwork"></div>

<div id="Info"></div>



<div id="Output"></div>



</body>
<jsp:include page="Header2.jsp"></jsp:include>
		
</html>