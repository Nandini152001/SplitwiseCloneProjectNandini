package com.nandini.splitwiseclone.service;

import com.nandini.splitwiseclone.exception.UserNotFoundException;
import com.nandini.splitwiseclone.model.User;
import com.nandini.splitwiseclone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUserById(Long id){
        User existingUser = getUserById(id);
        userRepository.delete(existingUser);
    }

    public User updateUser(Long id, User updatedUser){
        User existingUser = getUserById(id);

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }

}
