package com.ozel.loginapp.Service.Implementation;

import com.ozel.loginapp.Dto.BaseResponseDto;
import com.ozel.loginapp.Dto.LoginRequestDto;
import com.ozel.loginapp.Dto.LoginResponseDto;
import com.ozel.loginapp.Dto.RegisterDto;
import com.ozel.loginapp.Entity.UserEntity;
import com.ozel.loginapp.Repository.UserRepository;
import com.ozel.loginapp.Security.JWTGenerator;
import com.ozel.loginapp.Service.Interface.IAuthService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JWTGenerator jwtGenerator;

  @Override
  public LoginResponseDto login(LoginRequestDto loginRequestDto) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequestDto.getUsername(),
            loginRequestDto.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    Optional<UserEntity> user =  userRepository.findByUsername(loginRequestDto.getUsername());
    String token = jwtGenerator.generateToken(authentication);
    return new LoginResponseDto(user.get(), token, true, "Login Successful");
  }

  @Override
  public ResponseEntity<BaseResponseDto> register(RegisterDto registerDto) {
    if (userRepository.existsByUsername(registerDto.getUsername())) {
      return new ResponseEntity<>(new BaseResponseDto(false, "Username already taken"), HttpStatus.OK);
    }
    UserEntity user = new UserEntity();
    user.setUsername(registerDto.getUsername());
    user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
    user.setEmail(registerDto.getEmail());
    UserEntity userEntity = userRepository.save(user);
    return new ResponseEntity<>(new BaseResponseDto(true, "User created successfully"), HttpStatus.OK);
  }
}
