<?php

require_once '../includes/DbOperation.php';

function isTheseParameterAvailable($params) {

    $available = true;
    $missingparams = "";

    foreach($params as $param) {
        if(!isset($_POST[$param]) || strlen($_POST[$param])<=0) {
            $available = false;
            $missingparams = $missingparams . "," . $param;
        }
    }

    if(!$available) {
        $response = array();
        $response['error'] = true;
        $response['message'] = 'Parametry ' . substr($missingparams, 1, strlen($missingparams)) . ' missing';

        echo json_encode($response);
        die();
    }
}

$response = array();

if(isset($_GET['apicall'])) {
    switch($_GET['apicall']) {
        
        //create a record in database in table Posilki
        case 'addfood':
            
            isTheseParameterAvailable(array('kindOfFood','quantity','time'));
            
            //create a new dboperation object
            $db = new DbOperation();

            //creating a new record in the database
            $result = $db->addFood(
                $_POST['kindOfFood'],
                $_POST['quantity'],
                $_POST['time'],

            );
            //if the record is created adding success to response
            if($result) {
                $response['error'] = false; 
                $response['message'] = 'Posiłek został dodany';
            }

            break;

        // case 'getfood':
        //     break;

        case 'addtoilet' :
            
            isTheseParameterAvailable(array('spinner','timeFrom','timeTo','poop','piss'));
            
            //create a new dboperation object
            $db = new DbOperation();

            //creating a new record in the database
            $result = $db->addToilet(
                $_POST['spinner'],
                $_POST['timeFrom'],
                $_POST['timeTo'],
                $_POST['poop'],
                $_POST['piss']

            );
            //if the record is created adding success to response
            if($result) {
                $response['error'] = false; 
                $response['message'] = 'Wyjście zostało dodane';
            }

            break;

        // case 'gettoilet':
        //     break;

        // case 'addother':
        //     break;
        
        // case 'getother':
        //     break;
    }
    
}else{
    //if it is not api call 
    //pushing appropriate values to response array 
    $response['error'] = true; 
    $response['message'] = 'Invalid API Call';
    }
    
    //displaying the response in json structure 
    echo json_encode($response);
