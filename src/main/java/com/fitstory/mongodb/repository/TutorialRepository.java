package com.fitstory.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitstory.mongodb.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {

}
