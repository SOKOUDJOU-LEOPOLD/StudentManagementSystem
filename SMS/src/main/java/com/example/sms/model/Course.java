package com.example.sms.model;

public class Course {
    private int  course_id;
    private String code;
    private String title;
    private String description;
    private String passing_grade;

    public Course(){}

    public Course(int course_id, String code, String title, String description, String passing_grade) {
        this.course_id = course_id;
        this.code = code;
        this.title = title;
        this.description = description;
        this.passing_grade = passing_grade;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getPassing_grade() {
        return passing_grade;
    }

    public void setPassing_grade(String passing_grade) {
        this.passing_grade = passing_grade;
    }
}
