package net.maexit.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by arusov on 11.03.2018.
 */
public class KeyValueDriver {

    @Id
    private int id;
    private String name;

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
}
