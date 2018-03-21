package net.maexit.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arusov on 14.03.2018.
 */
public class CourseSection {

    @Id
    private String id;

    private String title;

    private Date createdDate;

    List<Lecture> lectures= new ArrayList<>();

    private int order;

    public CourseSection() {
        this.id= new ObjectId().toHexString();
    }

    public CourseSection(String title, Date createdDate, List<Lecture> lectures) {
        this.id= new ObjectId().toHexString();
        this.title = title;
        this.createdDate = createdDate;
        this.lectures = lectures;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
