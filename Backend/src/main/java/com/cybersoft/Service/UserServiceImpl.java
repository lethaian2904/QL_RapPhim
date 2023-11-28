package com.cybersoft.Service;// UserServiceImpl.java

import com.cybersoft.DTO.LoginRequest;
import com.cybersoft.Entity.User;
import com.cybersoft.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<LoginRequest> getAllUser() {
        List<User> listUser = userRepository.findAll();

        List<LoginRequest> userDTOList = new ArrayList<>();

        for (User user : listUser) {
            LoginRequest userDTO = new LoginRequest();
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {

        List<User> ListUser = userRepository.findByUsernameAndPassword(username,password);

        return ListUser.size() > 0;
    }

    @Override
    public boolean addUser(User a) {
        try {
            User users = new User();
            users.setUsername(a.getUsername());
            users.setPassword(a.getPassword());
            users.setRole(a.getRole());

            // Lưu người dùng vào cơ sở dữ liệu
            userRepository.save(users);

            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Thông báo lỗi cho mục đích ghi log
            return false;
        }
    }
}
