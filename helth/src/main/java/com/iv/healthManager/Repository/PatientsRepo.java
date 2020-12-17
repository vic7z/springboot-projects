package com.iv.healthManager.Repository;

import com.iv.healthManager.Model.patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepo extends MongoRepository<patients,String> {
}
