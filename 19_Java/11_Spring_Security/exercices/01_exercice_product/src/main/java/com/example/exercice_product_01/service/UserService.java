package com.example.exercice_product_01.service;

import com.example.exercice_product_01.config.jwt.JwtTokenProvider;
import com.example.exercice_product_01.entity.User;
import com.example.exercice_product_01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public boolean verifyUser(String email, String password) {
        return userRepository.findByEmail(email).map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    public boolean checkUserNameExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public String generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    public boolean createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }


}
