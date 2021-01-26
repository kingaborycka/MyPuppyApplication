<?php

class DbConnect {
    //variable with database link
    private $con = "https://databases.000webhost.com/index.php";

    function __construct(){
        $this->connect();
    }

    function connect(){

        include_once dirname(__FILE__) . '/Constants.php';
        $this->con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

        if (mysqli_connect_error()){
            echo "Failed to connect to MySQL: " . mysqli_connect_error();
        }

        return $this->con;
    }

}