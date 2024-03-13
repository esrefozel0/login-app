package com.ozel.loginapp.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozel.loginapp.Dto.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
  private final ObjectMapper objectMapper;

  @Override
  public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException {

    HttpStatus error = HttpStatus.UNAUTHORIZED;
    res.setContentType(MediaType.APPLICATION_JSON_VALUE);
    res.setStatus(error.value());

    BaseResponseDto baseResponseDto = new BaseResponseDto(false, "Username or password is incorrect");
    objectMapper.writeValue(res.getOutputStream(), baseResponseDto);
  }
}