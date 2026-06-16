package com.nandini.splitwiseclone.service;

import com.nandini.splitwiseclone.exception.UserNotFoundException;
import com.nandini.splitwiseclone.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public User createUser(User user){
        users.add(user);
        return user;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(Long id){
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUserById(Long id){
        users.remove(getUserById(id));
    }

    public User updateUser(Long id, User updatedUser){
        User existingUser = getUserById(id);

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        return existingUser;
    }

}
