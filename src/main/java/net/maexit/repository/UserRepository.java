package net.maexit.repository;

import net.maexit.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by arusov on 08.03.2018.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmail(String email);

    public User insert(User user);

}
