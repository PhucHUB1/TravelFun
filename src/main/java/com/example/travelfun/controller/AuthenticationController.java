package com.example.travelfun.controller;

import com.example.travelfun.dtos.request.ApiResponse;
import com.example.travelfun.dtos.request.authentication.AuthenticationRequest;
import com.example.travelfun.dtos.request.token.IntrospectRequest;
import com.example.travelfun.dtos.response.AuthenticationResponse;
import com.example.travelfun.dtos.response.IntrospectResponse;
import com.example.travelfun.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/travelFun/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
     @Autowired
     AuthenticationService authenticationService;

     @PostMapping("/log-in")
     ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        var result= authenticationService.authenticate(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder().
                result(result)
                .build();

     }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest authenticationRequest)
            throws ParseException, JOSEException {

        var result= authenticationService.introspect(authenticationRequest);
        return ApiResponse.<IntrospectResponse>builder().
                result(result)
                .build();

    }



}
