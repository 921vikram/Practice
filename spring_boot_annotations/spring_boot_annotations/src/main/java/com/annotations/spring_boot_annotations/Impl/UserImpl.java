package com.annotations.spring_boot_annotations.Impl;

import com.annotations.spring_boot_annotations.dao.UserRepository;
import com.annotations.spring_boot_annotations.model.User;
import com.annotations.spring_boot_annotations.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

  @Autowired(required = true)
  UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User addUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(String name) {
    List<User> res = userRepository.findByName(name);
    for(User user : res) {
      userRepository.delete(user);
    }
  }

}
