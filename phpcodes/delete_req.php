<?php 
$con=mysqli_connect("localhost","id12160635_examalthelper","examalthelper","id12160635_examalthelper");
$un=$_POST["username"];
$mysql_qry = "delete from requests where NAME='$un' ";
if($con->query($mysql_qry)=== TRUE)  {
echo "Records Deleted";
}
else {
echo "Error: " . $mysql_qry . "<br>" . $con->error ;
}
$con->close();
?>