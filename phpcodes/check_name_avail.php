<?php 
$con=mysqli_connect("localhost","id12160635_examalthelper","examalthelper","id12160635_examalthelper");
$date=$_POST["date"];
$time=$_POST["time"];
$name=$_POST["name"];
$mysql_qry1 = "select * from credentials where name='$name'";
$mysql_qry2 = "select * from EXAMSCHEDULE where NAME='$name' and DATE='$date' and TIME='$time'";
if($con->query($mysql_qry1)=== TRUE)  {	
	if($con->query($mysql_qry2)===TRUE){
		echo '1';
	}
	else{
		echo '2';
	}
}
else {
echo '3' ;
}
$con->close();
?>