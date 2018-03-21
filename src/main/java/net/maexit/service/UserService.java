package net.maexit.service;

import net.maexit.entity.User;
import net.maexit.exceptions.UserException;
import net.maexit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by arusov on 08.03.2018.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByEmailAndPwd(User user) {
        return userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());
    }

    public User insert(User user) {
        if (user != null) {
            User userDB = userRepository.findByEmail(user.getEmail());
            if (userDB != null && !userDB.getId().isEmpty()) {
                throw new UserException("User already exists " + user.getEmail());
            }
//            user.setPwd(bCryptPasswordEncoder().encode(user.getPwd()));
            userRepository.insert(user);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        net.maexit.entity.User applicationUser = userRepository.findByEmail(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getEmail(), applicationUser.getPwd(), Collections.emptyList());
    }
}
