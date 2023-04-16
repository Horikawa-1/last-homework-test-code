package com.raisetech.homework9.entity;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class CreateForm {

  public CreateForm() {
  }

  @Positive     //数値が正でないとエラー
  private int id;

  @NotBlank
  @Length(max = 20)
  private String name;
}