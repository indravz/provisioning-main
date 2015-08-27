


var source_arr = new Array("Delhi", "Kolkata", "Mumbai", "Chennai"); 

var device_arr = new Array();
device_arr[0]="";
device_arr[1]="Del101|Del102|Del103|Del104";
device_arr[2]="Kol101|Kol102|Kol103|Kol104";
device_arr[3]="Mum101|Mum102|Mum103|Mum104";
device_arr[4]="Che101|Che102|Che103|Che104";

function print_source(source_id){
	// given the id of the <select> tag as function argument, it inserts <option> tags
	var option_str = document.getElementById(source_id);
	option_str.length=0;
	option_str.options[0] = new Option('Select Source','');
	option_str.selectedIndex = 0;
	for (var i=0; i<source_arr.length; i++) {
		option_str.options[option_str.length] = new Option(source_arr[i],source_arr[i]);
	}
}

function print_device(device_id, device_index){
	var option_str = document.getElementById(device_id);
	option_str.length=0;	
	option_str.options[0] = new Option('Select Device','');
	option_str.selectedIndex = 0;
	var device_a = device_arr[device_index].split("|");
	for (var i=0; i<device_arr.length; i++) {
		option_str.options[option_str.length] = new Option(device_a[i],device_a[i]);
	}
}