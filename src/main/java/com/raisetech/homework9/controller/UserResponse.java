package com.raisetech.homework9.controller;

import com.raisetech.homework9.entity.User;


public class UserResponse {

  private int id;
  private String name;

  // NameからNameResponseに変換できるコンストラクタを⽤意
  public UserResponse(User name) {
    this.id = name.getId();
    this.name = name.getName();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}