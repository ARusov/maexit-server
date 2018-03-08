package net.maexit.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by arusov on 08.03.2018.
 */
public class User {


    @Id
    private String id;
    private String email;
    private String pwd;
    private int type;

    public User() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
