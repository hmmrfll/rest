package hmmrfll.practice.rest.auth.service.impl;

import hmmrfll.practice.rest.auth.entity.Role;
import hmmrfll.practice.rest.auth.entity.User;
import hmmrfll.practice.rest.auth.repository.UserRepository;
import hmmrfll.practice.rest.auth.request.LoginRequest;
import hmmrfll.practice.rest.auth.request.RegisterRequest;
import hmmrfll.practice.rest.auth.response.AuthorizationResponse;
import hmmrfll.practice.rest.auth.service.AuthService;
import hmmrfll.practice.rest.auth.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;
    @Override
    public AuthorizationResponse register(RegisterRequest request) {
        var user = User
                .builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthorizationResponse
                .builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthorizationResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwt = jwtService.generateToken(user);
        return AuthorizationResponse
                .builder()
                .token(jwt)
                .build();
    }
}
