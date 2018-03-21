package net.maexit.entity;

/**
 * Created by arusov on 17.03.2018.
 */
public class UploadAnswer {

    private String type;
    private String name;
    private String path;

    public UploadAnswer(String type, String name, String path) {
        this.type = type;
        this.name = name;
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
