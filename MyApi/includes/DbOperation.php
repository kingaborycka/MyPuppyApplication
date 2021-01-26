<?php

class DbOperation {

    private $con;

    function __construct() {
        require_once dirname(__FILE__) . '/DbConnect.php';
        $db = new DbConnect();
        $this->con = $db->connect();
        $this->con->prepare("INSERT INTO Posilki(Nazwa, Ilosc, Godzina, Data) VALUES('Kosc', 20, 14:00, '2021-01-15')")->execute();
        
    }

    //Create Read Update Delete
    function addFood($kindOfFood,$quantity,$time,$date) {
        $stmt = $this->con->prepare("INSERT INTO Posilki(Nazwa, Ilosc, Godzina, Data) VALUES(?, ?, ?, ?)");
        $stmt->bind_param("sis", $kindOfFood, $quantity, $time, $date);
        if($stmt->execute())
        return true; 
        return false; 
    }

    function addToilet($spinner, $timeFrom, $timeTo, $poop, $piss) {
        $stmt = $this->con->prepare("INSERT INTO Posilki(Nazwa, Ilosc, Godzina, Data) VALUES(?, ?, ?, ?)");
        $stmt->bind_param("sssss", $spinner, $timeFrom, $timeTo, $poop, $piss);
        if($stmt->execute())
        return true; 
        return false; 
    }
}