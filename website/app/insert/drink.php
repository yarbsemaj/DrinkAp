<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Drink_Name=@$data['Drink_Name'];
	$Drink_Description=@$data['Drink_Description'];
	$Drink_Recipe=@$data['Drink_Recipe'];
//SQL Queary
	$sql="INSERT INTO Drink ( Drink_Name, Drink_Description, Drink_Recipe ) VALUES ($Drink_Name,$Drink_Description,$Drink_Recipe)";
	$query = mysql_query($sql);
//Encode them All in json
	$reultrs = array("Drink_ID"=>mysql_insert_id(), "sucsess" => "true");
	echo json_encode($reultrs);
	
	$code=generateRandomString();
	
	$sql="INSERT INTO Notifications ( Drink_ID, Code) VALUES (".mysql_insert_id().",$code)";
	$query = mysql_query($sql);

?>