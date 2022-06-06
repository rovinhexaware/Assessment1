package com.hexaware.RESTAPIAssesment.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/api/testExceptionHandling")
    public ResponseEntity<Object> testAPI(@RequestParam int code){
        Map<String, String> responseMsg = new HashMap<>();
        HttpStatus status;
        if(code == 404) {
            responseMsg.put("errorMessage", "resource not found");
            status = HttpStatus.NOT_FOUND;
        } else {
            responseMsg.put("errorMessage", "Your are not authorized");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<>(responseMsg, status);
    }
}
