<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
//SQL Queary
mysql_set_charset('utf8');
	$sql="SELECT Drink.Drink_ID, Drink.Drink_Name, Drink.Drink_IMG, Drink.Drink_Description, Drink.Drink_Recipe, AVG(Rating) AS Rating_Mean FROM Drink Left JOIN Rating ON Drink.Drink_ID = Rating.Drink_ID WHERE Approved = 1 GROUP BY Drink.Drink_ID ORDER BY Rating_Mean DESC";
	$query = mysql_query($sql);
	
//Get all results in a PHP array	
	$results['drink'] = array();
	while($line = mysql_fetch_array($query, MYSQL_ASSOC)){
		
	
	
		
	
    	array_push($results ["drink"], $line);
	}
//Encode them All in json
	echo json_encode($results);

?>