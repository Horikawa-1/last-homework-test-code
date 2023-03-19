package com.raisetech.homework9.entity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


public class UpdateForm {

  public UpdateForm(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @NotBlank
  @Length(max = 20)
  private final String name;

}
