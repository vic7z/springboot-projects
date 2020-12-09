package com.vi.mongodbDemo.Controller;

import com.vi.mongodbDemo.Model.student;
import com.vi.mongodbDemo.Repositry.studentrepo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
@RequestMapping("/student")
public class homeController {
    public final studentrepo studentrepo;

    public homeController(studentrepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    @GetMapping("/all")
    @ApiOperation(
            value = "get all student details"
    )
    public List<student> getAll(){
        return this.studentrepo.findAll();
    }


    @PostMapping("/std")
    @ApiOperation(
            value = "update a student details in the db"
    )
    public void update(@RequestBody student student){
        this.studentrepo.save(student);
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "get a student useing its id"
    )
    public Optional<student> getById(@ApiParam(value = "id of the student",required = true)
                                         @PathVariable("id") String id){
        Optional<student> student = this.studentrepo.findById(id);

        return student;
    }


}
