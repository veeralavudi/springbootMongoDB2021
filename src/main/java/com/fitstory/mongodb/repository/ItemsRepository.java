package com.fitstory.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitstory.mongodb.entity.Items;

@Repository
public interface ItemsRepository  extends MongoRepository<Items, String> {


}
