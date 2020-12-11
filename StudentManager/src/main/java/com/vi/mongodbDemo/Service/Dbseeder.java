//package com.vi.mongodbDemo.Service;
//
//import com.vi.mongodbDemo.Model.course;
//import com.vi.mongodbDemo.Model.student;
//import com.vi.mongodbDemo.Repositry.studentrepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class Dbseeder implements CommandLineRunner {
//
//
//    private studentrepo studentrepo;
//
//    public Dbseeder(com.vi.mongodbDemo.Repositry.studentrepo studentrepo) {
//        this.studentrepo = studentrepo;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        student vic= new student(
//                "vic",
//                Arrays.asList(
//                        new course("cse","pp"),
//                        new course("mcmp","sr")
//                )
//        );
//        student vin= new student(
//                "vin",
//                Arrays.asList(
//                        new course("cse","pp")
//                )
//        );
//        this.studentrepo.deleteAll();
//        //List<student> students=Arrays.asList(vic,vin);
//      this.studentrepo.save(vic);
//      this.studentrepo.save(vin);
//
//    }
//}
