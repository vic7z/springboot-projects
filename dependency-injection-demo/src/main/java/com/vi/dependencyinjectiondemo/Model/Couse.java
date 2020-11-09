package com.vi.dependencyinjectiondemo.dao;

public class Couse {

    private String id;
    private System name;
    private String courseDescription;

    public Couse(String id, System name, String courseDescription) {
        this.id = id;
        this.name = name;
        this.courseDescription = courseDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public System getName() {
        return name;
    }

    public void setName(System name) {
        this.name = name;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


}
