package net.maexit.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by arusov on 14.03.2018.
 */
public class Lecture {

    @Id
    private String id;
    private String title;
    private String description;
    private String fileName;
    private String filePath;
    private String videoName;
    private String videoPath;
    private Date createdDate;
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Lecture() {
    }

    public Lecture(String title, String description, String fileName, String filePath, String videoName, String videoPath, int order) {
        this.title = title;
        this.description = description;
        this.fileName = fileName;
        this.filePath = filePath;
        this.videoName = videoName;
        this.videoPath = videoPath;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
