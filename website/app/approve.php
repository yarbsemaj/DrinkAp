<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Approve Drink</title>
</head>

<body>
<?php 
include ("../include.php");
$code = strip($_GET['code']);
$sql="SELECT * FROM Notifications WHERE Code = '$code'";
$query = mysql_query($sql) or die(mysql_error());
$line = mysql_fetch_array($query);
$Drink_ID=$line['Drink_ID'];

$sql="UPDATE Drink SET 	Approved = 1 WHERE Drink_ID = $Drink_ID";
$query = mysql_query($sql) or die(mysql_error());

?>
Drink Aproved
</body>
</html>