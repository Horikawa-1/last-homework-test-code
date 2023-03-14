package com.raisetech.homework9.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


public class CreateForm {


  public String getName() {
    return name;
  }

  @NotBlank
  @Length(max = 20)
  private final String name;

  @Positive//数値が正でないとエラー
  private final int id;
}