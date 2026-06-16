package com.nandini.splitwiseclone.repository;

import com.nandini.splitwiseclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
