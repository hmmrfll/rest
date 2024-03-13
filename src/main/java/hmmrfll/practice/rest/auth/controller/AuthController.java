package hmmrfll.practice.rest.auth.controller;

import hmmrfll.practice.rest.auth.request.LoginRequest;
import hmmrfll.practice.rest.auth.request.RegisterRequest;
import hmmrfll.practice.rest.auth.response.AuthorizationResponse;
import hmmrfll.practice.rest.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController{

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthorizationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(service.login(request));
    }


}
