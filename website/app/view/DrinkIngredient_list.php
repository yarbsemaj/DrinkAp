<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Drink_ID=@$data['Drink_ID'];
//SQL Queary
mysql_set_charset('utf8');
	$sql="SELECT Ingredient_ID, Quantity FROM Recipy WHERE Drink_ID='$Drink_ID'";
	$query = mysql_query($sql);
//Get all results in a PHP array	
	$results['ingredient'] = array();
	while($line = mysql_fetch_array($query, MYSQL_ASSOC)){
    	array_push($results ["ingredient"], $line);
	}
//Encode them All in json
	echo json_encode($results);

?>