package com.fitstory.mongodb.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fitstory.mongodb.Exceptions.ItemsNotFoundException;
import com.fitstory.mongodb.entity.Items;
import com.fitstory.mongodb.repository.ItemsRepository;

public class Register 
{ 
	@Autowired
	ItemsRepository itemRepository;
   
    private static Register registerObj = null; 
        
    private Register() 
    { 
        
    } 
  
    public static Register getInstance() 
    { 
        if (registerObj == null) 
            registerObj = new Register(); 
  
        return registerObj; 
    }
     
   
	
}