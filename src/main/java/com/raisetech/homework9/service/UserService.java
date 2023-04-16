package com.raisetech.homework9.service;

import com.raisetech.homework9.entity.CreateForm;
import com.raisetech.homework9.entity.User;
import com.raisetech.homework9.entity.UpdateForm;
import java.util.List;

public interface UserService {

  List<User> findAll();

  User findById(int id) throws Exception;

  User createUser(CreateForm form);

  void updateUser(int id, UpdateForm updateForm);

  void deleteUser(int id);
}
