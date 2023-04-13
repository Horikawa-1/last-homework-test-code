package com.raisetech.homework9.service;

import com.raisetech.homework9.entity.CreateForm;
import com.raisetech.homework9.entity.User;
import com.raisetech.homework9.entity.UpdateForm;
import com.raisetech.homework9.exception.ResourceNotFoundException;
import com.raisetech.homework9.mapper.UserMapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  @Override
  public List<User> findAll() {
    return userMapper.findAll();
  }

  @Override
  public User findById(int id) {
    return userMapper.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("IDが" + id + "のレコードはありません。"));
  }

  @Override
  public User createUser(CreateForm form) {
    User name = new User(form.getId(), form.getName());
    userMapper.insertUser(name);

    return name;
  }

  @Override
  public void updateName(int id, UpdateForm form) {

    //指定されたidが存在しない場合ResourceNotFoundExceptionを投げる
    Optional<User> user = userMapper.findById(id);
    user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));

    //formの各要素がnullでない場合は更新処理を行う
    if (Objects.nonNull(form.getName())) {
      userMapper.updateName(id, form.getName());
    }
  }

  @Override
  public void deleteUser(int id) {

    //指定されたidが存在しない場合ResourceNotFoundExceptionを投げる
    Optional<User> user = userMapper.findById(id);
    user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));

    userMapper.deleteName(id);
  }
}
