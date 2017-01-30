<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 

//SQL Queary
	$sql="SELECT * FROM Ingredient";
	mysql_set_charset('utf8');
	$query = mysql_query($sql) or die(mysql_error());
//Get all results in a PHP array	
	$results['ingridient'] = array();
	while($line = mysql_fetch_array($query, MYSQL_ASSOC)){
    	array_push($results["ingridient"], $line);
	}
//Encode them All in json
	echo json_encode($results);

?>