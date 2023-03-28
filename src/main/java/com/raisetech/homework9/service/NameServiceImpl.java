package com.raisetech.homework9.service;

import com.raisetech.homework9.entity.CreateForm;
import com.raisetech.homework9.entity.Name;
import com.raisetech.homework9.entity.UpdateForm;
import com.raisetech.homework9.exception.ResourceNotFoundException;
import com.raisetech.homework9.mapper.NameMapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NameServiceImpl implements NameService {

  private final NameMapper nameMapper;

  @Override
  public List<Name> findAll() {
    return nameMapper.findAll();
  }

  @Override
  public Name findById(int id) {
    return nameMapper.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("ID:" + id + " Not Found"));
  }

  @Override
  public Name createUser(CreateForm form) {
    Name name = new Name(form.getId(), form.getName());
    nameMapper.insertName(name);

    return name;
  }

  @Override
  public void updateName(int id, UpdateForm form) {

    //指定されたidが存在しない場合ResourceNotFoundExceptionを投げる
    Optional<Name> user = nameMapper.findById(id);
    user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));

    //formの各要素がnullでない場合は更新処理を行う
    if (Objects.nonNull(form.getName())) {
      nameMapper.updateName(id, form.getName());
    }
  }

  @Override
  public void deleteUser(int id) {

    //指定されたidが存在しない場合ResourceNotFoundExceptionを投げる
    Optional<Name> user = nameMapper.findById(id);
    user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));

    nameMapper.deleteName(id);
  }
}
