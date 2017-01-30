<?php
//Links the include file, setups the site to work the DB etc.
include ("../../include.php");

//Injection protection, do this with every field 
	$data=newstrip();
	$Name=@$data['Ingredient_Name'];
	$Description=@$data['Ingredient_Description'];
	$Measure=@$data['Ingredient_Measure'];
//SQL Queary
	$sql="INSERT INTO Ingredient ( Ingredient_Name, Ingredient_Description, Ingredient_Measure ) VALUES ($Name,$Description,$Measure)";
	$query = mysql_query($sql);
//Encode them All in json
	$reultrs = array("sucsess" => "true");
	echo json_encode($reultrs);

?>