<?php
include('include.php');

$email=strip($_POST['email']);
$date=time();

$sql="INSERT INTO interest (Email, Date) VALUES ('$email','$date');";

mysql_query($sql)or die (mysql_error());
print "S";



?>