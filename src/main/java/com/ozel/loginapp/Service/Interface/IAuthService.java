package com.ozel.loginapp.Service.Interface;

import com.ozel.loginapp.Dto.BaseResponseDto;
import com.ozel.loginapp.Dto.LoginRequestDto;
import com.ozel.loginapp.Dto.LoginResponseDto;
import com.ozel.loginapp.Dto.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

  LoginResponseDto login(LoginRequestDto loginRequestDto);

  ResponseEntity<BaseResponseDto> register(RegisterDto registerDto);
}
