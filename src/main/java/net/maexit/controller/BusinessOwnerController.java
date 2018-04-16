package net.maexit.controller;

import com.lowagie.text.DocumentException;
import net.maexit.entity.*;
import net.maexit.repository.AnswerRepository;
import net.maexit.repository.KeyValueDriverRepository;
import net.maexit.service.KeyValueDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arusov on 20.03.2018.
 */
@RequestMapping("/api")
@RestController
public class BusinessOwnerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private KeyValueDriverRepository kvdRepository;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private KeyValueDriverService keyValueDriverService;


    @RequestMapping("/kvd")
    @ResponseBody
    public List<KeyValueDriver> getKeyValueDrivers() {

        return keyValueDriverService.findAllOrOrderByOrder();
    }

    @RequestMapping("/answer/{email}")
    @ResponseBody
    public Answer getBusinessOwnerAnswer(@PathVariable("email") String email) {

        return answerRepository.findByEmail(email);
    }

    @RequestMapping(value = "/getpdfreport/{id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getPDF(@PathVariable("id") String id) {
        Answer answer = answerRepository.findById(id).get();
        if (answer == null) {
            return null;
        }

        List<BusinessOwnerKVD> bokvds = new ArrayList<>();

        BODashboard boDashboard = new BODashboard();
        if (answer != null) {
            for (KeyValueDriver kvd : kvdRepository.findAll()) {
                int i = 0;
                int kvdsum = 0;
                for (Question question : answer.getQuestions()) {
                    if (kvd.getId() == question.getKvdId()) {
                        i++;
                        kvdsum = kvdsum + question.getValue();
                    }
                }

                BusinessOwnerKVD bokvd = new BusinessOwnerKVD(kvd.getId(), kvd.getName(), kvdsum / i);
                bokvds.add(bokvd);
            }
            boDashboard.setKvds(bokvds);
            int index = 0;
            for (BusinessOwnerKVD bokvd : bokvds) {
                index = index + bokvd.getKvdIndex();
            }
            boDashboard.setIndex(index / bokvds.size());
            boDashboard.setId(answer.getId());
        }

        String color = "yellow";
        if (boDashboard.getIndex() < 50) {
            color = "red";
        }
        if (boDashboard.getIndex() > 80) {
            color = "gren";
        }


        Context ctx = new Context();
        ctx.setVariable("punkt1", getValues(color));
        ctx.setVariable("punkt2", getValues(color));
        ctx.setVariable("punkt3", getValues(color));
        ctx.setVariable("punkt4", getValues(color));
        ctx.setVariable("punkt5", getValues(color));
        ctx.setVariable("punkt6", getValues(color));
        ctx.setVariable("punkt7", getValues(color));
        ctx.setVariable("punkt8", getValues(color));
        ctx.setVariable("punkt9", getValues(color));
        ctx.setVariable("punkt10", getValues(color));
        ctx.setVariable("punkt11", getValues(color));


        String processedHtml = templateEngine.process("report", ctx);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(processedHtml);
        renderer.layout();
        try {
            renderer.createPDF(os, false);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        renderer.finishPDF();
        System.out.println("PDF created successfully");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; ");
        header.setContentLength(os.toByteArray().length);

        return new HttpEntity<byte[]>(os.toByteArray(), header);

    }


    private String getValues(String color) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("green", "Ergebnis > Branchendurchschnitt: Ihre Punktzahl in Höhe von XXX von 100 liegt über dem Branchendurchschnitt. Auf diesem Vorteil sollten Sie aufbauen und prüfen, ob Sie die Attraktivität Ihres Unternehmens für den Investor mit gezielten Maßnahmen noch steigern können und so einen Kauf Ihres Unternehmens für den Investor sogar alternativlos machen können.");
        map.put("yellow", "Ergebnis ~ Branchendurchschnitt: Ihre Punktzahl in Höhe von XXX von 100 möglichen Punkten zeigt, dass Sie in diesem Geschäftsbereich zufriedenstellende Leistungen aufweisen. Allerdings gibt es noch Raum für Verbesserungen, die Ihren Unternehmenswert steigern.");
        map.put("red", "Ergebnis < Branchendurchschnitt: Ihre Punktzahl in Höhe von XXX bringt eine Eigenschaft Ihres Unternehmens zum Vorschein, die verbessert werden kann, um den Wert Ihres Unternehmens zu steigern.");

        return map.get(color);

    }


}
