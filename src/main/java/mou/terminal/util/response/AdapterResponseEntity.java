package mou.terminal.util.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdapterResponseEntity {

    public static <T> ResponseEntity success(T body){
        return new ResponseEntity(body, HttpStatus.OK);
    }

    public static <T> ResponseEntity accessFail(T body){
        return new ResponseEntity(body,HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity fail(T body){
        return new ResponseEntity(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
