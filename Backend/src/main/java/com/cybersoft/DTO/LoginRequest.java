package com.cybersoft.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Data
@Getter
public class LoginRequest {

    private String username;
    private String password;

    public void setUsername(String a) {
        this.username = a;
    }
    public void setPassword(String a) {
        this.password = a;
    }

}
