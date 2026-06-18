package com.laha.campusevent_backend;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User signup(User user) {

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }

    public User login(
            String username,
            String password) {

        User user =
                userRepository.findByUsername(username);

        if (user != null &&
                user.getPassword().equals(password)) {

            return user;
        }

        return null;
    }
}