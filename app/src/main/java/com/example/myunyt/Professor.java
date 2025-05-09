package com.example.myunyt;

public class Professor {
    private String id;
    private String name;
    private String course;
    private int imageResId;

    public Professor(String id, String name, String course, int imageResId) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.imageResId = imageResId;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getImageResId() { return imageResId; }
}
