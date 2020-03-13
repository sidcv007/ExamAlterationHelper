<?php 
   $con=mysqli_connect("localhost","id12160635_examalthelper","examalthelper","id12160635_examalthelper");
   $username = $_POST["username"];   
   $sql = "select name from credentials where username = '$username'";
   $result = mysqli_query($con ,$sql);
   if(mysqli_num_rows($result) > 0) {
        while($row = $result->fetch_assoc())
        { echo $row["name"];
        }		
   }
   else {
        echo "Invalid";
   }
?>