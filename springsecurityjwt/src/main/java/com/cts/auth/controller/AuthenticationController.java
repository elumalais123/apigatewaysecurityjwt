package com.cts.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.auth.dto.JwtAuthenticationResponse;
import com.cts.auth.dto.RefreshTokenRequest;
import com.cts.auth.dto.SignInRequest;
import com.cts.auth.dto.SignUpRequest;
import com.cts.auth.entity.User;
import com.cts.auth.service.AuthenticationServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
    private final AuthenticationServiceImpl authenticationService;


    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody @Validated SignUpRequest signUpRequest){
    	
        return ResponseEntity.ok(authenticationService.registration(signUpRequest));
    }
    

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.login(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}