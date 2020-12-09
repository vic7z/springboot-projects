package com.vi.demo.Repository;

import com.vi.demo.model.student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<student,String> {
}
