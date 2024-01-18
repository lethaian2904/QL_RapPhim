package com.cybersoft.Controller;

import com.cybersoft.Entity.User;
import com.cybersoft.Payload.ResponseData;
import com.cybersoft.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<ResponseData> signin(@RequestParam String username, @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        if (userService.checkLogin(username, password)) {
            responseData.setData(true);
        } else {
            responseData.setData(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseData> signup(@RequestBody User user) {
        ResponseData responseData = new ResponseData();

        responseData.setData(userService.addUser(user));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<ResponseData> getAllUser() {
        ResponseData responseData = new ResponseData();
        responseData.setData(userService.getAllUser());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
