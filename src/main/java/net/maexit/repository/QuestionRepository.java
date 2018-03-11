package net.maexit.repository;

import net.maexit.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by arusov on 11.03.2018.
 */

public interface QuestionRepository extends MongoRepository<Question, String> {

    public Optional<Question> findById(String id);
    public List<Question> findAll();
    public Question insert(Question question);


}
