package com.bohan.manalive.config.securityUser;

import com.bohan.manalive.domain.user.User;
import com.bohan.manalive.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomSecurityUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    public UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optional = userRepo.findByEmail(email);

        if(!optional.isPresent()) {
            throw new UsernameNotFoundException(email + " 사용자 없음");
        }else {
            User user = optional.get();
            return new SecurityUser(user);
        }
    }





}
