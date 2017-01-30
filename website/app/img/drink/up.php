<?php
include ("../../../include.php");
if(isset($_POST['ImageName'])){
$imgname = $_POST['ImageName'];
$imsrc = base64_decode($_POST['base64']);
$fp = fopen($imgname, 'w');
fwrite($fp, $imsrc);


//Links the include file, setups the site to work the DB etc.


//Injection protection, do this with every field 
	$data=newstrip();
	$Drink_Name=@$data['Drink_Name'];
	$Drink_Description=@$data['Drink_Description'];
	$Drink_Recipe=@$data['Drink_Recipe'];
	$imgname = $data['ImageName'];
//SQL Queary
	$sql="INSERT INTO Drink ( Drink_Name, Drink_Description, Drink_Recipe, Drink_IMG ) VALUES ('$Drink_Name','$Drink_Description','$Drink_Recipe','$imgname' )";
	$query = mysql_query($sql);
//Encode them All in json
	$reultrs = array("Drink_ID"=>mysql_insert_id(), "sucsess" => true);
	echo json_encode($reultrs);
	
	$code=generateRandomString();
	
	$sql="INSERT INTO Notifications ( Drink_ID, Code) VALUES ('".mysql_insert_id()."','$code')";
	$query = mysql_query($sql);
	
	
$to = 'yarbsemaj@gmail.com' ;
$subject = 'New drink to moderate "'.$Drink_Name.'"' ;


$message = '<html>
<head>
  <title>New drink to moderate "'.$Drink_Name.'"</title>
</head>
<body>
  <h1>'.$Drink_Name.' </h1>
  <img src="http://drinkap.yarbsemaj.com/app/img/drink/'.$imgname.'">
  
  
  <h2>Description</h2>
  '.$Drink_Description.'
   <h2>Recipe</h2>
  '.$Drink_Recipe.' <br>
  <a href="http://drinkap.yarbsemaj.com/app/approve.php?code='.$code.'">Approve</a>
</body>
</html>' ;+
$headers  = 'MIME-Version: 1.0' . "\r\n";
$headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";

// Additional headers
$headers .= 'From: Drink\'Ap autoMod <mod@drinkap.yarbsemaj.com>' . "\r\n";


mail ( $to, $subject, $message, $headers ) ;
}
?>
