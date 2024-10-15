package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {
  User saveUser(User user);

  Optional<User> getUserbyId(String id);

  Optional<User> updateUser(User user);

  void deleteUser(String id);

  Boolean isUserExist(String userId);

  Boolean isUserExistByEmail(String email);

  List<User> getAllUsers();

}
