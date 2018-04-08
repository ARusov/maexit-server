package net.maexit.controller;

import net.maexit.entity.Answer;
import net.maexit.entity.Industry;
import net.maexit.entity.Question;
import net.maexit.entity.User;
import net.maexit.service.AnswerService;
import net.maexit.service.IndustryService;
import net.maexit.service.QuestionService;
import net.maexit.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by arusov on 12.03.2018.
 */

@CrossOrigin
@RestController
@RequestMapping("/publicapi")
public class PublicController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;


    @Autowired
    private QuestionService questionService;

    @Autowired
    private IndustryService industryService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;


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

        if (answer != null) {
            List<Question> questions = questionService.findAll();
            List<Question> aQuestions = answer.getQuestions();

            Set<Question> sq=new HashSet<>(questions);

            for(Question q:questions){
                for(Question aq:aQuestions){
                    if(aq.getId().equals(q.getId())){
                        sq.remove(q);
                    }
                }
            }


            answer.getQuestions().addAll(sq);
            answerService.insert(answer);

            User user = userService.findByEmail(answer.getEmail());
            if (user == null) {
                User newUser = new User();
                newUser.setType(1);
                newUser.setEmail(answer.getEmail());
                String pwd = generatePwd();
                newUser.setPwd(pwd);
                userService.insert(newUser);

                sendEmail(newUser);
            }
        }
    }


    @RequestMapping(value = "/user/check", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkUser(@RequestBody User user) {

        Answer answer = answerService.findByEmail(user.getEmail());
        if (answer != null && !answer.getId().isEmpty()) {
            return true;
        }
        return false;
    }


    private String buildEmail(User user) {
        Context context = new Context();
        context.setVariable("login", user.getEmail());
        context.setVariable("pwd", user.getPwd());
        return templateEngine.process("email_template", context);
    }

    public boolean sendEmail(User user) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("no-reply@maexit.de");
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("MAEXIT.NET | Ihre Zugangsdaten");
            String content = buildEmail(user);
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private String generatePwd() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random(15, characters);
    }
}
