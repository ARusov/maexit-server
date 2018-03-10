package net.maexit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

/**
 * Created by arusov on 08.03.2018.
 */
public class User {


    @Id
    private String id;
    private String fullName;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String newPwd;
    private int type;

    public User() {
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
