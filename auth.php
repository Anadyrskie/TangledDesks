<?php

    // login object
    class login{
        public $username = NULL;
        public $password = NULL;
        public $token = NULL;
    }

    // auth object
class auth{
    public $userid = NULL;
    public $key = NULL;
    public $token = NULL;
}
$KEY_LENGTH = 16;

    // Generates and returns an API key from random bytes
function generateKey(){
    global $KEY_LENGTH;
        return strval(bin2hex(random_bytes($KEY_LENGTH)));


}

    // Generates and returns token
function generateToken(){
    global $KEY_LENGTH;

        return strval(bin2hex(random_bytes(($KEY_LENGTH*2))));

}

    // sets and returns the auth object
function setKey($authObj){
    $authObj->userid = 0;
    $authObj->key = generateKey();
    $authObj->token = generateToken();
    return $authObj;
}

/* checkLogin($login_obj)
     * Input: Login Object
     *
     *Logic:
     *     Case 1: Username and Token
     *          sets auth key and returns same token
     *     Case 2: Username and password
     *          sets and returns token and auth key
     *
     * Output:
     *     Case 1: Login success
     *         returns $auth_obj with userid
     *     Case 2: Login failure
     *         returns 1
 */
function checkLogin($login_obj){


    if(strcmp(strval($login_obj->username), 'admin')== 0 && strcmp(strval($login_obj->token), 'bz0CqegTN5KjdNubxccBoTTauMnQA5ijUHWaMSfwdWUeeqBubetfeZba6UCmGSl6') == 0){
        $authObj = new auth;
        setKey($authObj);
        $authObj->token = 'bz0CqegTN5KjdNubxccBoTTauMnQA5ijUHWaMSfwdWUeeqBubetfeZba6UCmGSl6';
        return $authObj;
    }
    elseif(strcmp(strval($login_obj->username), 'admin') == 0 && strcmp(strval($login_obj->password), 'admin') == 0) {
        $authObj = new auth;
        setKey($authObj);
        return $authObj;
    }
    else {
        return http_response_code(401);
    }
}


/* Handles "submit=" requests in the POST body
    * Instantiates and populates a login object and passes it to checkLogin
    * Instantiates an auth object and populates it with the login response
    * If login was unsuccessful, returns "Forbidden"
 */
    function requestHandler($request_type){
    if ($request_type == 'login'){
        # Get login information
        $login_obj = new login;
        $login_obj->username = htmlspecialchars($_POST['username']);
        $login_obj->password = htmlspecialchars($_POST['password']);
        $login_obj->token = htmlspecialchars($_POST['token']);
        $auth_obj = checkLogin($login_obj);
        return $auth_obj;

    }
    //returns when the if statements are skipped or all evaluate false. Mainly for debugging.
    return "something went wrong";
}

/* Main function
 *      First checks the HTTP request type to see if it conforms,
 *      then checks the request body to verify conformity.
 *      It passes the submit type to requestHandler()
 *      and returns the JSON-encoded result in the response body.
 *
 *      If the:
 *              request type is wrong, it returns "Incorrect Method"
 *              request body is formatted incorrectly, it responds with "bad request"
 *              supplied credentials are wrong, it replies with "unauthorized"
 */

if($_SERVER['REQUEST_METHOD'] === 'POST'){
    if(isset($_POST['submit'])) {
        $request_type = $_POST['submit'];
        if ($request_type !== NULL) {
            $response = requestHandler($request_type);

            if(is_object($response)){ echo json_encode($response) . "<br />" . http_response_code(201); }
            else {echo http_response_code(401);}
        } else {
            echo http_response_code(401);
        }
    }
    else {
        echo http_response_code(400);
    }
}
else {
    echo http_response_code(405);
}