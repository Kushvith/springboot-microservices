package com.kushvith.photoappapiservice.ui.modal;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class createUserRequestModal {
    @NotNull(message="firstname should not be empty")
    @Size(min = 2,message = "first name length should be greater than 2")
    private String firstName;
    @NotNull(message="last name should not be empty")
    private String lastName;
    @Email
    private String email;
    @NotNull(message="email should not be empty")
    @Size(min = 4,max = 8,message = "password length should be greater than 2 and less than or equal to  8")
    private String password;
}
