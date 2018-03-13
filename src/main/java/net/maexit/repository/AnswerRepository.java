package net.maexit.repository;

import net.maexit.entity.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by arusov on 12.03.2018.
 */
public interface AnswerRepository extends MongoRepository<Answer, String> {

    public List<Answer> findAll();

    public Answer findAllById(String email);

    public Answer insert(Answer industry);

}
