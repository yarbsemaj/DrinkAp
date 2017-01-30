<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Drink_ID=@$data['Drink_ID'];
	$Ingridient=@$data['Ingridient_ID'];
	$Mesure=@$data['Mesure'];
//SQL Queary
	$sql="INSERT INTO Recipy (Drink_ID, Ingredient_ID, Quantity) VALUES ('$Drink_ID','$Ingridient','$Mesure')";
	$query = mysql_query($sql)or die(mysql_error());
//Encode them All in json
	$reultrs = array("sucsess" => "true");
	echo json_encode($reultrs);

?>
