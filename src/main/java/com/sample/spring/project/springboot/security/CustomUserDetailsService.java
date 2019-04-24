package com.sample.spring.project.springboot.security;

import com.sample.spring.project.springboot.domain.User;
import com.sample.spring.project.springboot.repoitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + email + " not found"));
        return new JpaUserDetails(user.getEmail(), user.getPassword(), new String[]{"ADMIN"});
    }
}
