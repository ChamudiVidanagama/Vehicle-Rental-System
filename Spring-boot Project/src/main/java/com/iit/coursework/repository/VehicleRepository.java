package com.iit.coursework.repository;

import com.iit.coursework.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    // extends the mongo repository by creating the collection Vehicle where id is String
}
