<?php
error_reporting(E_ALL);
include ("../../../include.php");
if(isset($_POST['ImageName'])){
$imgname = $_POST['ImageName'];
$imsrc = base64_decode($_POST['base64']);
$fp = fopen($imgname, 'w');
fwrite($fp, $imsrc);


//Injection protection, do this with every field 
	$data=newstrip();
	$Name=@$data['Name'];
	$Description=@$data['Description'];
	$Measure=@$data['Measure'];
	$imgname = @$data['ImageName'];
//SQL Queary
	$sql="INSERT INTO Ingredient ( Ingredient_Name, Ingredient_Description, Ingredient_Measure, Ingredient_IMG ) VALUES ('$Name','$Description','$Measure','$imgname')";
	$query = mysql_query($sql) or die(mysql_error());
//Encode them All in json
if(fclose($fp)){
 echo "Image uploaded";
}else{
 echo "Error uploading image";
}
}
?>
