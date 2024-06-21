package com.cts.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {
	
	@Email(message = "Not A Valid Email")
    private String email;
	
	@NotBlank(message = "Can Not Be Blank")
    private String password;
}
