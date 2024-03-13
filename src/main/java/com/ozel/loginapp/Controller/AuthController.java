package com.ozel.loginapp.Controller;
import com.ozel.loginapp.Dto.BaseResponseDto;
import com.ozel.loginapp.Dto.LoginRequestDto;
import com.ozel.loginapp.Dto.LoginResponseDto;
import com.ozel.loginapp.Dto.RegisterDto;
import com.ozel.loginapp.Service.Interface.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class AuthController {
  private final IAuthService authService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
    return new ResponseEntity<>(authService.login(loginRequestDto), HttpStatus.OK);
  }
  @PostMapping("/register")
  public ResponseEntity<BaseResponseDto> register(@RequestBody RegisterDto registerDto) {
    return authService.register(registerDto);
  }
}