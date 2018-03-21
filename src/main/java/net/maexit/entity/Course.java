package net.maexit.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arusov on 14.03.2018.
 */
public class Course {

    @Id
    private String id;

    private String name;

    private Date createdDate;

    private List<CourseSection> sections= new ArrayList<>();

    private int order;

    private String userId;

    public Course() {
    }

    public Course(String name, Date createdDate, List<CourseSection> sections, int order, String userId) {
        this.name = name;
        this.createdDate = createdDate;
        this.sections = sections;
        this.order = order;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<CourseSection> getSections() {
        return sections;
    }

    public void setSections(List<CourseSection> sections) {
        this.sections = sections;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
