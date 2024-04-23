package com.shippingmicroservice.controller;


import com.shippingmicroservice.auth.AuthenticationRequest;
import com.shippingmicroservice.auth.AuthenticationResponse;
import com.shippingmicroservice.auth.RegisterRequest;
import com.shippingmicroservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class   AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public AuthenticationResponse register(
            @RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest authenticationRequest) {
        return authenticationService.authenticate(authenticationRequest);
    }

}
