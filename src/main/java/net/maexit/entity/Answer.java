package net.maexit.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by arusov on 12.03.2018.
 */
public class Answer {

    @Id
    private String id;

    private String email;

    private int industruId;
    List<Question> questions;

    public Answer() {
    }

    public Answer(String email, int industruId, List<Question> questions) {
        this.email = email;
        this.industruId = industruId;
        this.questions = questions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIndustruId() {
        return industruId;
    }

    public void setIndustruId(int industruId) {
        this.industruId = industruId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
