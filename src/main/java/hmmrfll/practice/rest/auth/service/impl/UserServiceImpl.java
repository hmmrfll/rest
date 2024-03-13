package hmmrfll.practice.rest.auth.service.impl;

import hmmrfll.practice.rest.auth.entity.User;
import hmmrfll.practice.rest.auth.repository.UserRepository;
import hmmrfll.practice.rest.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    @Override
    public void deleteUser(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        repository.delete(user);
    }
}
