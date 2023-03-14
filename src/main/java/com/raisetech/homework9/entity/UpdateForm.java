package com.raisetech.homework9.entity;


import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


public class UpdateForm {

  public String getName() {
    return name;
  }

  @Length(max = 20)
  private final String name;

}
