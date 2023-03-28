package com.raisetech.homework9.service;

import com.raisetech.homework9.entity.CreateForm;
import com.raisetech.homework9.entity.Name;
import com.raisetech.homework9.entity.UpdateForm;
import java.util.List;

public interface NameService {

  List<Name> findAll();

  Name findById(int id) throws Exception;

  Name createUser(CreateForm form);

  void updateName(int id, UpdateForm updateForm);

  void deleteUser(int id);
}
