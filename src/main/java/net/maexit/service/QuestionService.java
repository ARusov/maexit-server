package net.maexit.service;

import net.maexit.entity.Question;
import net.maexit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arusov on 11.03.2018.
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public Question findById(String id){
        return repository.findById(id).get();
    }
    public List<Question> findAll(){
        return repository.findAll();
    }
    public Question insert(Question question){
        return repository.insert(question);
    }

}
