<?
    $con = mysqli_connect("localhost","hennible0612","ab375656","hennible0612");

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];

    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = (?) AND userPassword = (?)");
    mysqli_stmet_bind_param($statement, "ss", $userID, $userPassword);
    mysqli_stmet_execute($statement);

    mysqli_stmt_store_resule($statement);
    mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, $userAge);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["userID"] = $userID;
        $response["userPassword"] = $userName;
        $response["userName"] = $userName;
        $response["userAge"] = $userAge;
    }

    echo json_encode($response);
?>