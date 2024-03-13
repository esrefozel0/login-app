package com.ozel.loginapp.Dto;

import com.ozel.loginapp.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

  private String username;
  private String email;
  private String token;

  public UserResponseDto(UserEntity userEntity, String token){
    setUsername(userEntity.getUsername());
    setEmail(userEntity.getEmail());
    setToken(token);
  }
}
