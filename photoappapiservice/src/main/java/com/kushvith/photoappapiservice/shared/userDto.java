package com.kushvith.photoappapiservice.shared;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class userDto implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String encryptedPassword;
}
