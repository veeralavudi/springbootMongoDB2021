package com.fitstory.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitstory.mongodb.entity.Offers;

public interface OffersRepository extends MongoRepository<Offers, String> {

}


