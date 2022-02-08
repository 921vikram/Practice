package com.annotations.spring_boot_annotations.service;

import com.annotations.spring_boot_annotations.model.User;
import java.util.List;

public interface UserService {
  List<User> getUsers();
  User addUser(User user);
  void delete(String name);
}
