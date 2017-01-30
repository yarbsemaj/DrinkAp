<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Ingrident=@$data['Ingredient_ID'];
//SQL Queary
	$sql="SELECT * FROM Recipy JOIN Drink ON Recipy.Drink_ID = Drink.Drink_ID WHERE Recipy.Ingredient_ID = $Ingrident ORDER BY NEWID()";
	$query = mysql_query($sql);
//Encode them All in json
	$reultrs = array(mysql_fetch_array($query));
	echo json_encode($reultrs);

?>