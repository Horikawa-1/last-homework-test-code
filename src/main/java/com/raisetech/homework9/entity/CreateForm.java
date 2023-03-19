package com.raisetech.homework9.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class CreateForm {


  public CreateForm(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  @NotBlank
  @Length(max = 20)
  private final String name;

  @Positive//数値が正でないとエラー
  private final int id;
}