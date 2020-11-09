package com.vi.mongodbDemo.Controller;

import com.vi.mongodbDemo.Model.student;
import com.vi.mongodbDemo.Repositry.studentrepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class homeController {
    public final studentrepo studentrepo;

    public homeController(studentrepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    @GetMapping("/all")
    public List<student> getAll(){
        return this.studentrepo.findAll();
    }
    @PostMapping
    public void update(@RequestBody student student){
        this.studentrepo.save(student);
    }
    @GetMapping("/{id}")
    public Optional<student> getById(@PathVariable("id") String id){
        Optional<student> student = this.studentrepo.findById(id);

        return student;
    }

}
