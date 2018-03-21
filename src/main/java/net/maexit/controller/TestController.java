package net.maexit.controller;

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

        Industry i1 = new Industry(1, "Automobil & ZubehÃ¶r");
        Industry i2 = new Industry(2, "Handel & e-commerce");
        Industry i3 = new Industry(3, "Baugewerbe & Handwerk");
        Industry i4 = new Industry(4, "Beratungsdienstleistungen");
        Industry i5 = new Industry(5, "Chemie");
        Industry i6 = new Industry(6, "Elektrik- & Elektronik");
        Industry i7 = new Industry(7, "Umwelttechnologie & Erneuerbare Energien");
        Industry i8 = new Industry(8, "Finanzen &Versicherungen");
        Industry i9 = new Industry(9, "Lebensmittel & GetrÃ¤nke");
        Industry i10 = new Industry(10, "Gas, ElektrizitÃ¤t, Wasser");
        Industry i11 = new Industry(11, "Gesundheit und Kosmetik");
        Industry i12 = new Industry(12, "Maschinen- und Anlagenbau");
        Industry i13 = new Industry(13, "Medien & Verlage");
        Industry i14 = new Industry(14, "Pharmaindustrie");
        Industry i15 = new Industry(15, "Software");
        Industry i16 = new Industry(16, "Telekommunikation");
        Industry i17 = new Industry(17, "Textil- & Bekleidungsindustrie");
        Industry i18 = new Industry(18, "Transport, Logistik & Tourismus");
        industryService.insert(i1);
        industryService.insert(i2);
        industryService.insert(i3);
        industryService.insert(i4);
        industryService.insert(i5);
        industryService.insert(i6);
        industryService.insert(i7);
        industryService.insert(i8);
        industryService.insert(i9);
        industryService.insert(i10);
        industryService.insert(i11);
        industryService.insert(i12);
        industryService.insert(i13);
        industryService.insert(i14);
        industryService.insert(i15);
        industryService.insert(i16);
        industryService.insert(i17);
        industryService.insert(i18);


        return industryService.findAll();
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
