<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Drink_ID=@$data['Drink_ID'];
//SQL Queary
	$sql="SELECT Drink.Drink_ID, Drink.Drink_Name, Drink.Drink_IMG, Drink.Drink_Description, Drink.Drink_Recipe, AVG(Rating) AS Rating_Mean FROM Drink LEFT JOIN Rating ON Drink.Drink_ID = Rating.Drink_ID
WHERE Drink.Drink_ID =  '$Drink_ID' GROUP BY Drink.Drink_ID";
$query = mysql_query($sql) or die(mysql_error());;
$drink=mysql_fetch_array($query, MYSQL_ASSOC);

$sql="SELECT Ingredient.Ingredient_ID, Ingredient.Ingredient_Name, Ingredient.Ingredient_IMG, Recipy.Quantity, Ingredient.Ingredient_Measure FROM Recipy LEFT JOIN Ingredient ON Recipy.Ingredient_ID = Ingredient.Ingredient_ID WHERE Recipy.Drink_ID='$Drink_ID'";
	$query = mysql_query($sql) or die(mysql_error());;
//Get all results in a PHP array	
	$results = array();
	while($line = mysql_fetch_array($query, MYSQL_ASSOC)){
    	$results[] = $line;
	}
	$drink['Ingredient']=$results;
//Encode them All in json
	echo json_encode($drink);
	//json_encode($results);
	//print_r($results);
	

?>