<?php 
$con=mysqli_connect("localhost","id12160635_examalthelper","examalthelper","id12160635_examalthelper");
$oname=$_POST["oldname"];
$date=$_POST["date"];
$time=$_POST["time"];
$nname=$_POST["newname"];
$mysql_qry = "select * from credentials where NAME='$nname' ";
$mysql_qry2 = "select * from EXAMSCHEDULE where NAME='$nname' and DATE='$date' and TIME='$time' ";
$mysql_qry3 = "update  EXAMSCHEDULE set NAME='$nname' where DATE='$date' and TIME='$time' and NAME='$oname'";
$result = mysqli_query($con ,$mysql_qry);
$result2 = mysqli_query($con ,$mysql_qry2);
if(mysqli_num_rows($result) > 0){
	if(mysqli_num_rows($result2) > 0){
		echo "Time Table Clash!!"
	}
	else{
		if($con->query($mysql_qry3)=== TRUE){
			echo "Records Updated";
		}
		else{
			echo "Error: " . $mysql_qry3 . "<br>" . $con->error ;
		}
	}
}
else{
	echo "Invalid faculty name entered"
}
$con->close();
?>


$mysql_qry = "select * from credentials where NAME='$name' ";
$mysql_qry2 = "select * from EXAMSCHEDULE where NAME='$name' and DATE='$date' and TIME='$time' ";
$result = mysqli_query($con ,$mysql_qry);
$result2 = mysqli_query($con ,$mysql_qry2);
   if(mysqli_num_rows($result) > 0){
       if(mysqli_num_rows($result2) > 0){
           echo "no";
       }
       else{
           echo "yes";
       }
   }
   else{
       echo "no2";
   }


   if($con->query($mysql_qry3)=== TRUE)  {
echo "Records Updated";
}
else {
echo "Error: " . $mysql_qry3 . "<br>" . $con->error ;
}