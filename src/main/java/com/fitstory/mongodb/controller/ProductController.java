package com.fitstory.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitstory.mongodb.entity.Items;
import com.fitstory.mongodb.repository.ItemsRepository;
import com.fitstory.mongodb.service.impl.ItemsService;

@Controller
public class ProductController {
	@Autowired
	ItemsRepository itemsRepository;
	@Autowired
	private ItemsService service; 
	
	/*
	void addItem(String item,Double price) throws CheckoutInProgressException{
		
	}  */
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Items> listProducts = service.getAllItems();
	    model.addAttribute("listProducts", listProducts);
	     
	    return "index";
	}

	@RequestMapping("/welcome")
	public String welcomePage(Model model) {
	 /*  List<Items> listProducts = service.getAllItems();
	    model.addAttribute("listProducts", listProducts); */
	     
	    return "welcome";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Items product = new Items();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Items product) {
		Items _items = itemsRepository.save(product);
		
		return "redirect:/";
	}

	@PostMapping("/additems")
	public ResponseEntity<Items> addItems(@RequestBody Items items) {
		try {
			Items _items = itemsRepository.save(items);
			return new ResponseEntity<>(_items, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getitems")
	public ResponseEntity<List<Items>> getItems() {
		try {
			List<Items>  listItems=new ArrayList<>();
			//Register register=null;
			//register=Register.getInstance();
			//listItems=register.getAllItems();
			listItems=getAllItems();
			System.out.println("###"+listItems);
			return new ResponseEntity<>(listItems, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		 private List<Items> getAllItems() {
		    	System.out.println("ENtered into Registered class and get AllItems");
		    	List<Items> itemsList=null;
		    	itemsList=itemsRepository.findAll();
		    	System.out.println("###Items="+itemsList);
		    	  	return itemsList;
		    	
		    }
	
}
