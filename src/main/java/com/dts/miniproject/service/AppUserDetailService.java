package com.dts.miniproject.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dts.miniproject.model.AppUserDetail;
import com.dts.miniproject.model.User;
import com.dts.miniproject.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password is incorrect"));
        return new AppUserDetail(user);
    }

}
