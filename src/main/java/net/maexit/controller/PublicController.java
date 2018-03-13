package net.maexit.controller;

import net.maexit.entity.Answer;
import net.maexit.entity.Industry;
import net.maexit.entity.Question;
import net.maexit.service.AnswerService;
import net.maexit.service.IndustryService;
import net.maexit.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arusov on 12.03.2018.
 */

@CrossOrigin
@RestController
@RequestMapping("/publicapi")
public class PublicController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private IndustryService industryService;

    @Autowired
    private AnswerService answerService;


    @RequestMapping("/questions")
    @ResponseBody
    public List<Question> getQuestions() {
        return questionService.findAllShuffle();
    }

    @RequestMapping("/industry")
    @ResponseBody
    public List<Industry> getIndustry() {
        return industryService.findAll();

    }

    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public void saveAnswer(@RequestBody Answer answer) {
        answerService.insert(answer);
    }
}
