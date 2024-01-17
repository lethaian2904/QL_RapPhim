package com.cybersoft.Controller;

import com.cybersoft.Entity.UserDetail;
import com.cybersoft.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/user-details")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> getUserDetail(@PathVariable Long id) {
        UserDetail userDetail = userDetailService.getUserDetailById(id);

        if (userDetail != null) {
            return new ResponseEntity<>(userDetail, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDetail> updateUserDetail(@PathVariable Long id, @RequestBody UserDetail userDetail) {
        // Set the id from the path variable into the UserDetail object
        userDetail.setId(id);

        UserDetail updatedUserDetail = userDetailService.updateUserDetail(userDetail);

        if (updatedUserDetail != null) {
            return new ResponseEntity<>(updatedUserDetail, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

