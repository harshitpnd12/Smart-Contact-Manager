package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceimpl implements UserService {

  @Autowired
  private UserRepo userrepo;

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public User saveUser(User user) {
    String userId = UUID.randomUUID().toString();
    user.setUserId(userId);
    return userrepo.save(user);
  }

  @Override
  public Optional<User> getUserbyId(String id) {
    return userrepo.findById(id);
  }

  @Override
  public Optional<User> updateUser(User user) {
    User user2 = userrepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    user2.setName(user.getName());
    user2.setEmail(user.getEmail());
    user2.setPassword(user.getPassword());
    user2.setAbout(user.getAbout());
    user2.setPhoneNumber(user.getPhoneNumber());
    user2.setProfilePic(user.getProfilePic());
    user2.setEnabled(user.isEnabled());
    user2.setEmailVerified(user.isEmailVerified());
    user2.setPhoneVerified(user.isPhoneVerified());
    user2.setProvider(user.getProvider());
    user2.setProviderUserId(user.getProviderUserId());
    User save = userrepo.save(user2);
    return Optional.ofNullable(save);
  }

  @Override
  public void deleteUser(String id) {
    User user2 = userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    userrepo.delete(user2);
  }

  @Override
  public Boolean isUserExist(String userId) {
    User user2 = userrepo.findById(userId).orElse(null);
    return user2 != null ? true : false;
  }

  @Override
  public Boolean isUserExistByEmail(String email) {
    User user = userrepo.findByEmail(email).orElse(null);
    return user != null ? true : false;
  }

  @Override
  public List<User> getAllUsers() {
    return userrepo.findAll();
  }

}
