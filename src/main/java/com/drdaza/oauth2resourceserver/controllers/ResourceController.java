package com.drdaza.oauth2resourceserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.oauth2resourceserver.payloads.MessagePayload;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/resource")
public class ResourceController {

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")        
    public ResponseEntity<MessagePayload> user(Authentication authentication) {
        return ResponseEntity.ok( new MessagePayload("Hello" + authentication.getName()));
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")    
    public ResponseEntity<MessagePayload> admin(Authentication authentication) {
        return ResponseEntity.ok( new MessagePayload("Hello Mr" + authentication.getName()));
    }

}
