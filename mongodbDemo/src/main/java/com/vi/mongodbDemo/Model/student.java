package com.vi.mongodbDemo.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collation = "student")
@ApiModel(description = "student class")
public class student {
    @Id
    @ApiModelProperty(notes = "UUid of the student/auto generated")
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
