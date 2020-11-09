package com.vi.mongodbDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collation = "student")
public class student {
    @Id
    private String id;
    private String name;
    private List<course> courses;

    public student() {
        this.courses =new  ArrayList<>();
    }

    public student(String name, List<course> courses) {
        this.name = name;
        this.courses = courses;
    }
}
