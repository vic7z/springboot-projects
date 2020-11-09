package com.vi.mongodbDemo.Repositry;

import com.vi.mongodbDemo.Model.student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepo extends MongoRepository<student,String> {
}
