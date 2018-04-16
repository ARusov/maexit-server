package net.maexit.service;

import net.maexit.entity.KeyValueDriver;
import net.maexit.entity.Question;
import net.maexit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by arusov on 11.03.2018.
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    @Autowired
    private KeyValueDriverService keyValueDriverService;

    public Question findById(String id) {
        return repository.findById(id).get();
    }

    public List<Question> findAll() {
        return repository.findAll();
    }

    public Question insert(Question question) {
        return repository.insert(question);
    }

    public List<Question> findAllShuffle() {
        List<Question> questions = new ArrayList<Question>();

        List<KeyValueDriver> kvds = keyValueDriverService.findAll();
        for (KeyValueDriver k : kvds) {
            List<Question> questionsByKVD = repository.findAllByKvdId(k.getId());
            Collections.shuffle(questions, new Random());
            questions.addAll(questionsByKVD.subList(0, 4));
        }
        Collections.shuffle(questions, new Random());

        return questions;
    }

    public  Question save (Question question){
        return repository.save(question);
    }
}
