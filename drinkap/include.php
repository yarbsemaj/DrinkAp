<?php
@session_start();
date_default_timezone_set("Europe/London");
function sqlcon(){
	$host="db603204515.db.1and1.com"; // Host name 
	$username="dbo603204515"; // Mysql username 
	$password="Hobnob12!"; // Mysql password 
	$db_name="db603204515"; // Database name 
	mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
	mysql_select_db("$db_name")or die("cannot select DB"); 
}
 
function strip($val){
 	$val = stripslashes($val);
	$val = mysql_real_escape_string($val);
	return $val;
}
function frc ($List,$Form_Data){
	foreach($List as $Item){
	if(null==$Form_Data[$Item]){return false;}	
	}
	return true;
}
function newstrip(){
	foreach($_POST as $key=>$value) {
	$clean[$key]=mysql_real_escape_string($value);}
	return $clean;
}
sqlcon();
?>