package com.ozel.loginapp.Dto;

import com.ozel.loginapp.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponseDto {

  private Boolean success;
  private String message;

  public BaseResponseDto(Boolean success, String message){
    this.success = success;
    this.message = message;
  }
}
