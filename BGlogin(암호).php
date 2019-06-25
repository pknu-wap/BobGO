<?php
    $con = mysqli_connect("localhost","hennible0612","ab375656","hennible0612");

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];

    $statement = mysqli_prepare($con, "SELECT * FROM BGUSER WHERE userID = ?");
    mysqli_stmt_bind_param($statement, "s", $userID);
    mysqli_stmt_execute($statement);
    $checkedPassword = password_hash($userPassword, PASSWORD_DEFAULT);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $checkedPassword, $userName, $userSTUID, $userNID);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        if(password_verify($userPassword, $checkedPassword)){
            $response["success"] = true;
            $response["userID"] = $userID;
           // $response["userPassword"] = $userName;
            $response["userName"] = $userName;
            $response["userSTUID"] = $userSTUID;
            $response["userNID"] = $userNID;
        }
    }
    echo json_encode($response);
?>