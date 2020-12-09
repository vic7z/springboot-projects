package com.iv.healthManager.Repository;

import com.iv.healthManager.Model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface driverRepo extends MongoRepository<Driver,String> {
}
