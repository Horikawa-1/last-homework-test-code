package com.raisetech.homework9.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@RequiredArgsConstructor

public class UpdateForm {


  @NotBlank
  @Length(max = 20)
  private final String name;

}
