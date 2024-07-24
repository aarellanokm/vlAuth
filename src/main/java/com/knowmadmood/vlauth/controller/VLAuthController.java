package com.knowmadmood.vlauth.controller;

import com.knowmadmood.vlauth.service.VLAuthService;
import com.knowmadmood.vlauth.model.VLAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class VLAuthController {

    @Autowired
    private VLAuthService tokenService;

    @GetMapping("/get-token")
    public VLAuthResponse getToken() {

        return tokenService.getToken();

    }

}
