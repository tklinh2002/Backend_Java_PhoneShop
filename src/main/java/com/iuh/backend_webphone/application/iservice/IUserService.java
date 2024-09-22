package com.iuh.backend_webphone.application.iservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iuh.backend_webphone.application.services.UserService;
import com.iuh.backend_webphone.domain.entity.User;
import com.iuh.backend_webphone.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username is exist");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email is exist");
        }
        user.setRole("USER");
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.delete(user);
        return user;
    }

    @Override
    public User getUserByUserNameAndPassWord(String userName, String password) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Password is incorrect");
        }
        return user;
    }

}
