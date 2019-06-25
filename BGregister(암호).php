<?php
    $con = mysqli_connect("localhost","hennible0612", "ab375656", "hennible0612");

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userName = $_POST["userName"];
    $userSTUID = $_POST["userSTUID"];
	$userNID = $_POST["userNID"];

    $checkedPassword = password_hash($userPassword, PASSWORD_DEFAULT);
    $statement = mysqli_prepare($con, "INSERT INTO BGUSER VALUES (?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"sssis", $userID, $checkedPassword, $userName, $userSTUID, $userNID);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);

?>




