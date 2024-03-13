package com.ozel.loginapp.Dto;

import com.ozel.loginapp.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto extends BaseResponseDto {

  UserResponseDto user;

  public LoginResponseDto(UserEntity userEntity, String token, Boolean success, String message){
    super();
    setUser(new UserResponseDto(userEntity, token));
    setMessage(message);
    setSuccess(success);
  }
}
