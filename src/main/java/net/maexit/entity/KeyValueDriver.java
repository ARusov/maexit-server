package net.maexit.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by arusov on 11.03.2018.
 */
public class KeyValueDriver {

    @Id
    private int id;
    private String name;
    private String text;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public KeyValueDriver() {
    }

    public KeyValueDriver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
