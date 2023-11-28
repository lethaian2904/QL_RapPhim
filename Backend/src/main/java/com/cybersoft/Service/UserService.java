package com.cybersoft.Service;

import com.cybersoft.DTO.LoginRequest;
import com.cybersoft.Entity.User;

import java.util.List;

public interface UserService {
    List<LoginRequest> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(User a);

}

