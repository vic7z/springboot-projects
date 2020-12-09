package com.vi.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "student")
public class student {
    @Id
    public String id;
    public String name;
    public List<Course> courses;

    public student() {
        courses=new ArrayList<>();
    }

    public student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }


    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
