package com.vi.demo.Controller;

import com.vi.demo.Repository.StudentRepo;
import com.vi.demo.model.student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class HomeController {
    public final StudentRepo studentrepo;

    public HomeController(StudentRepo studentrepo) {
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