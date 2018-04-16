package net.maexit.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.maexit.entity.Industry;
import net.maexit.entity.KeyValueDriver;
import net.maexit.entity.Question;
import net.maexit.service.IndustryService;
import net.maexit.service.KeyValueDriverService;
import net.maexit.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by arusov on 08.03.2018.
 */
@CrossOrigin
@RestController
public class TestController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private KeyValueDriverService keyValueDriverService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private IndustryService industryService;

    @CrossOrigin
    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "Hello World from Maexit!";
    }


    @RequestMapping("/test/kvd")
    @ResponseBody
    public List<KeyValueDriver> getKeyValueDrivers() {
        return keyValueDriverService.findAll();
    }


    @RequestMapping("/test/question")
    @ResponseBody
    public List<Question> getQuestions() {
        return questionService.findAll();
    }

    @RequestMapping("/test/industry")
    @ResponseBody
    public List<Industry> getIndustry() {
        return industryService.findAll();
    }

    @RequestMapping("/test/insert")
    @ResponseBody
    public Object insert() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            TypeReference<List<Question>> typeReference = new TypeReference<List<Question>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/questions.json");
            List<Question> questions = mapper.readValue(inputStream,typeReference);
            for (Question q: questions){
                questionService.save(q);
                System.out.println(q.getId());
            }

            return questions;
        } catch (IOException e){
            System.out.println("Unable to save users: " + e.getMessage());
        }

        return null;
    }

    @RequestMapping("/test/email")
    @ResponseBody
    public boolean sendEmail() {


        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("no-reply@maexit.de");
            messageHelper.setTo("a.s.rusov@gmail.com");
            messageHelper.setSubject("Sample mail subject");
            String content = build("loginaaaaa");
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

    public String build(String login) {
        Context context = new Context();
        context.setVariable(    "login", login);
        return templateEngine.process("email_template", context);
    }

}
