package com.vi.demo;

import com.vi.demo.Repository.StudentRepo;
import com.vi.demo.model.Course;
import com.vi.demo.model.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class dbseeder implements CommandLineRunner {
    private final StudentRepo studentRepo;

    public dbseeder(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        student vic=new student(
                "vic",
                Arrays.asList(
                        new Course("cse","eed"),
                        new Course("eee","smt")
                )
        );
        this.studentRepo.deleteAll();
        this.studentRepo.save(vic);

    }
}
