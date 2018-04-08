package net.maexit.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by arusov on 11.03.2018.
 */
public class Question {

    @Id
    private String id;
    private int kvdId;
    private String text;
    private String influencerText;
    private String min;
    private String max;
    private int value;

    public Question() {
    }

    public Question(int kvdId, String text, String min, String max) {
        this.kvdId = kvdId;
        this.text = text;
        this.min = min;
        this.max = max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKvdId() {
        return kvdId;
    }

    public void setKvdId(int kvdId) {
        this.kvdId = kvdId;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getInfluencerText() {
        return influencerText;
    }

    public void setInfluencerText(String influencerText) {
        this.influencerText = influencerText;
    }
}
