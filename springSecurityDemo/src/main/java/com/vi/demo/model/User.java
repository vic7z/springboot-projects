package com.vi.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private  Role role;
    private List<Course> courseList;

    public User() {
        courseList=new ArrayList<>();
    }


}
