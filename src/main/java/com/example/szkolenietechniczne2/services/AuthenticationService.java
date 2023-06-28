package com.example.szkolenietechniczne2.services;

import com.example.szkolenietechniczne2.dao.JwtAuthenticationResponse;
import com.example.szkolenietechniczne2.dao.request.SignUpRequest;
import com.example.szkolenietechniczne2.dao.request.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
