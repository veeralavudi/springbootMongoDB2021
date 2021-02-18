package com.fitstory.mongodb.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitstory.mongodb.Exceptions.ItemsNotFoundException;
import com.fitstory.mongodb.entity.Offers;
import com.fitstory.mongodb.repository.OffersRepository;

@Service
public class OffersServiceImpl implements OffersService {
	Logger logger = LoggerFactory.getLogger("OffersServiceImpl");
	
	@Autowired
	OffersRepository offersRepository;

	@Override
	public List<Offers> getAllOffers() {
		 logger.info("OffersServiceImpl :: getAllOffers");
	    	List<Offers> offersList=null;
	    	offersList=offersRepository.findAll();
	    	logger.info("###Offers="+offersList);
	    	if(null==offersList) 
	    		throw new ItemsNotFoundException("Offers Not Available");
	    	return offersList;
	}
	 
}
