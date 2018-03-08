package net.maexit.service;

import net.maexit.entity.User;
import net.maexit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arusov on 08.03.2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){
        if (email !=null){
            return userRepository.findByEmail(email);
        }
        return null;
    }

    public User insert(User user){
        if(user!=null){
            userRepository.insert(user);
        }
        return null;
    }
}
