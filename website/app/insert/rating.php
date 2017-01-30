<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Drink_ID=@$data['Drink_ID'];
	$Rating=@$data['Rating'];
//SQL Queary
	$sql="INSERT INTO Rating (Rating, Drink_ID) VALUES ('$Rating', $Drink_ID)";
	$query = mysql_query($sql);
//Encode them All in json
	$reultrs = array("success" => true);
	echo json_encode($reultrs);

?>
