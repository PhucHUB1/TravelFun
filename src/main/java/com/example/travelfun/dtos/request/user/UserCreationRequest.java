package com.example.travelfun.dtos.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreationRequest {
    @Size(min = 3,message = "INVALID_USERNAME")
    private String username;
    @Size(min = 8,message = "INVALID_PASSWORD")
    private String password;
    @Email
    private String email;
    private String image_url;


}


