package com.nandini.splitwiseclone.service;

import com.nandini.splitwiseclone.dto.UserRequestDTO;
import com.nandini.splitwiseclone.dto.UserResponseDTO;
import com.nandini.splitwiseclone.exception.UserNotFoundException;
import com.nandini.splitwiseclone.model.User;
import com.nandini.splitwiseclone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        User savedUser =  userRepository.save(user);

        return mapToResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers(){

//        List<User> currentUsersList = userRepository.findAll();
//        List<UserResponseDTO> responseList = new ArrayList<>();
//
//        for(User currentUser : currentUsersList){
//                    responseList.add(mapToResponseDTO(currentUser));
//            }
//
//        return responseList;

        return userRepository.findAll().stream().map(this::mapToResponseDTO).toList();
    }

    public UserResponseDTO getUserById(Long id){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return mapToResponseDTO(existingUser);
    }

    public void deleteUserById(Long id){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(existingUser);
    }

    public UserResponseDTO updateUser(Long id, User updatedUser){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        User savedUser = userRepository.save(existingUser);

        return mapToResponseDTO(savedUser);
    }

    private UserResponseDTO mapToResponseDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

}
