package net.maexit.service;

import net.maexit.entity.Answer;
import net.maexit.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arusov on 11.03.2018.
 */
@Service
public class AnswerService {
    @Autowired
    private AnswerRepository repository;

    public Answer findById(String id) {
        return repository.findById(id).get();
    }

    public List<Answer> findAll() {
        return repository.findAll();
    }

    public Answer insert(Answer answer) {
        return repository.insert(answer);
    }

}
