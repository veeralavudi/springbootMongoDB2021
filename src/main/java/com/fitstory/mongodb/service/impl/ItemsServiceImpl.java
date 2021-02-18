package com.fitstory.mongodb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitstory.mongodb.Exceptions.CheckoutInProgressException;
import com.fitstory.mongodb.Exceptions.InvalidItemScan;
import com.fitstory.mongodb.Exceptions.ItemsNotFoundException;
import com.fitstory.mongodb.Exceptions.NoCheckoutInProgressException;
import com.fitstory.mongodb.core.Bill;
import com.fitstory.mongodb.entity.Items;
import com.fitstory.mongodb.repository.ItemsRepository;

@Service
public class ItemsServiceImpl implements ItemsService{
	 Logger logger = LoggerFactory.getLogger("ItemsServiceImpl");
	
	@Autowired
	ItemsRepository itemsRepository;
	
	List<Items> itemsList = null;
	List<Items> addItems=null;
	Bill bill=null;
	Map<String,Double> getItems=null;
	
	
	
	/**
	 * Scan Item  pass the item name and get price of the item.
	 */
	
	public double scanItem(String item) throws InvalidItemScan, NoCheckoutInProgressException {
		Items items=null;
		double price=0.0;
		if(null!=item) {
			items=getItem(item);
			if(null!=items) {
				price=items.getPrice();
			}
		}
		return price;
	}



	@Override
	public Map<String,Double> addItem(String item, Double price) {
		Map<String,Double> addItemList=new HashMap<>();
		addItemList.put(item, price);
		return addItemList;
	}
	
	
	public void  addItems(Map<String,Double>  itemPriceMap) throws CheckoutInProgressException {
			double totalBill=0.0;	
		 bill=new Bill();
	
		 
		if(null!=itemPriceMap) {
		
			getItems=itemPriceMap;
			 // Using for-each loop 
	        for (Map.Entry mapElement : itemPriceMap.entrySet()) { 
	            String key = (String)mapElement.getKey(); 
	  
	            // Add some bonus marks 
	            // to all the students and print it 
	             totalBill  = + ((double)mapElement.getValue()); 
	  
	          
	        } 
	        bill.setBillAmount(totalBill);
	
	 }
	}

	/**
	 * Get All Items List 
	 * @return
	 */
	 public List<Items> getAllItems() {
		 logger.info("ItemsServiceImpl :: getAllItems");
	    	List<Items> itemsList=null;
	    	itemsList=itemsRepository.findAll();
	    	logger.info("###Items="+itemsList);
	    	if(null==itemsList) 
	    		throw new ItemsNotFoundException("Items Not there Stock");
	    	return itemsList;
	    	
	    }
	 
	 /**
	  * Get Item Object while passing item name.
	  * @param item
	  * @return
	  */
	public Items getItem(String item) {
		logger.info("ItemsServiceImpl :: getAllItems");
		Items items = null;
		try {
		items = itemsRepository.findById(item).orElse(null);
		logger.info("###Items=" + itemsList);
		if (null == itemsList)
			throw new ItemsNotFoundException("Items Not there Stock");
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return items;

	}



	@Override
	public void startCheckout() throws CheckoutInProgressException {
		// TODO Auto-generated method stub
/**
 * Load all the saled items		
 */
		List<Items> listItems = getAllItems() ; 
		/**
		 * need clarification to write next business logic
		 */
		
		/**
		 * calculate Discount here call Offer table and apply Discount of item.
		 */
		
		
	}

	@Override
	public Bill finishCheckout() throws NoCheckoutInProgressException {
		// TODO Auto-generated method stub
		Bill billAmt=new Bill();
		billAmt=bill;
		/**
		 * apply discount on amount need clarification
		 */
		
		return billAmt;
	}



	@Override
	public void cancelCheckout() throws NoCheckoutInProgressException {
		getItems=null;
		
	}

}
