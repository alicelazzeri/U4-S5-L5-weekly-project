package it.epicode.U4S5L5weeklyproject.services;

import it.epicode.U4S5L5weeklyproject.entities.User;
import it.epicode.U4S5L5weeklyproject.exceptions.UserNotFoundException;
import it.epicode.U4S5L5weeklyproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByUsername(String username) {
        return userRepository.findById(username).orElseThrow(()-> new UserNotFoundException(username));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser (String username) {
        userRepository.deleteById(username);
    }
}
