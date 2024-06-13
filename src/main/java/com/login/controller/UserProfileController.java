package com.login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @GetMapping
    public Map<String, Object> getUserProfile(Authentication authentication) {
        Map<String, Object> userInfo = new HashMap<>();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            userInfo.put("username", jwt.getClaimAsString("preferred_username"));
            userInfo.put("email", jwt.getClaimAsString("email"));
            userInfo.put("name", jwt.getClaimAsString("name"));
        } else {
            userInfo.put("error", "User is not authenticated");
        }
        return userInfo;
    }
}
