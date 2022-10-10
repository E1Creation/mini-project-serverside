package com.dts.miniproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.dts.miniproject.model.User;
import com.dts.miniproject.model.dto.request.LoginRequest;
import com.dts.miniproject.model.dto.response.LoginResponse;
import com.dts.miniproject.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

    private AuthenticationManager authenticationManager;
    private AppUserDetailService appUserDetailService;
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword());

        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContextHolder.getContext().setAuthentication(auth);

        UserDetails userDetail = appUserDetailService.loadUserByUsername(loginRequest.getUsername());
        User user = userRepository.findByUsername(loginRequest.getUsername()).get();

        List<String> authorities = userDetail.getAuthorities()
                .stream().map(authority -> authority.getAuthority())
                .collect(Collectors.toList());
        return new LoginResponse(user.getUsername(), user.getEntitas().getEmail(), authorities);
    }

}
