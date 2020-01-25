package com.iit.coursework.repository;

import com.iit.coursework.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, Integer> {
    // extends the mongo repository by creating the collection Schedule where id is Integer
}
