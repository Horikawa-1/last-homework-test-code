package com.raisetech.homework9.controller;

import com.raisetech.homework9.entity.Name;


public class NameResponse {

  private int id;
  private String name;

  // NameからNameResponseに変換できるコンストラクタを⽤意
  public NameResponse(Name name) {
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