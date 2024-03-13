package hmmrfll.practice.rest.auth.controller;

import hmmrfll.practice.rest.auth.request.LoginRequest;
import hmmrfll.practice.rest.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long userId){
        service.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully with id: " + userId);
    }
}
