package com.cybersoft.Service;

import com.cybersoft.Entity.UserDetail;
import com.cybersoft.Repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetail getUserDetailById(Long id) {
        return userDetailRepository.findById(id).orElse(null);
    }

    public UserDetail updateUserDetail(UserDetail userDetail) {
        // Kiểm tra xem userDetail có tồn tại hay không
        if (userDetailRepository.existsById(userDetail.getId())) {
            return userDetailRepository.save(userDetail);
        }
        return null;
    }
}

