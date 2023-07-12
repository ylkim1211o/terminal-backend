package mou.terminal.web.controller.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class LoginController {


    @RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(){

        return "login" ;
    }

    @RequestMapping(value="/login/success",method = {RequestMethod.GET,RequestMethod.POST})
    public String loginSuccess(){

        return "success";
    }

    @RequestMapping(value="/login/fail",method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity loginFail(){

        return new ResponseEntity(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @RequestMapping(value="/login/test")
    public String loginTest(){


        return "oo";
    }
}


