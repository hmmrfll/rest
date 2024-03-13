package hmmrfll.practice.rest.auth.service;

import hmmrfll.practice.rest.auth.request.LoginRequest;
import hmmrfll.practice.rest.auth.request.RegisterRequest;
import hmmrfll.practice.rest.auth.response.AuthorizationResponse;


public interface AuthService {
    AuthorizationResponse register(RegisterRequest request);
    AuthorizationResponse login(LoginRequest request);
}
