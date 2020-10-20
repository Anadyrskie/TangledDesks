<?php
    class login{
        public $username = NULL;
        public $password = NULL;
        public $token = NULL;
    }


class auth{
    public $userid = NULL;
    public $key = NULL;
    public $token = NULL;
}
$KEY_LENGTH = 16;

function generateKey(){
    /* generateKey()
     * Input:
     *     None
     * Output:
     *     Generates an API key with random bytes and a timeout timestamp
     * Notes:
     *     This function is used in the checkLogin function
     */
    global $KEY_LENGTH;
        return strval(bin2hex(random_bytes($KEY_LENGTH)));


}

function generateToken(){
    global $KEY_LENGTH;

        return strval(bin2hex(random_bytes(($KEY_LENGTH))));

}

function setKey($authObj){
    $authObj->userid = 0;
    $authObj->key = generateKey();
    $authObj->token = generateToken();
    return $authObj;
}




function checkLogin($login_obj){
    /* checkLogin($login_obj)
     * Input: Login Object
     * Output:
     *     Case 1: Login success
     *         returns $auth_obj with userid
     *     Case 2: Login failure
     *         returns NULL
     */

    if(strcmp(strval($login_obj->username), 'admin')== 0 && strcmp(strval($login_obj->token), 'bz0CqegTN5KjdNubxccBoTTauMnQA5ijUHWaMSfwdWUeeqBubetfeZba6UCmGSl6') == 0){
        $authObj = new auth;
        setKey($authObj);
        $authObj['token'] = 'bz0CqegTN5KjdNubxccBoTTauMnQA5ijUHWaMSfwdWUeeqBubetfeZba6UCmGSl6';
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



    function requestHandler($request_type){
    if ($request_type == 'login'){
        //echo 'login triggered <br>';

        # Get login information
        $login_obj = new login;
        $login_obj->username = htmlspecialchars($_POST['username']);
        $login_obj->password = htmlspecialchars($_POST['password']);
        $login_obj->token = htmlspecialchars($_POST['token']);
        $auth_obj = checkLogin($login_obj);
        /*if ($auth_obj == 1){
            return http_response_code(403);
        }*/
        #else {
            return $auth_obj;
        #}
    }

    return "something went wrong";
}



$request_type = $_POST['submit'];
if($request_type !== NULL){
    $response = requestHandler($request_type);
    echo json_encode($response);
}
else {
    echo http_response_code(418);
}
