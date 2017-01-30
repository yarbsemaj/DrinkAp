<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Search=@$data['Search'];
//SQL Queary
	$sql="SELECT Drink.Drink_ID, Drink.Drink_Name, Drink.Drink_IMG, AVG(Rating) AS Rating_Mean FROM Drink Left JOIN Rating ON Drink.Drink_ID = Rating.Drink_ID  WHERE Drink_Name LIKE '%$Search%' GROUP BY Drink.Drink_ID ORDER BY Rating_Mean DESC";
	$query = mysql_query($sql);
//Get all results in a PHP array	
	$results = array();
	while($line = mysql_fetch_array($query, MYSQL_ASSOC)){
    	$results[] = $line;
	}
//Encode them All in json
	echo json_encode($results);

?>