/**
 * 
 */
package com.hilfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.IHilfeService;

/**
 * @author rohit
 *
 */
@Controller
@RequestMapping("/")
public class HilfeServiceController {

    @Autowired
    IHilfeService hilfeService;
    
	//TODO rwali add request and response
	public void push2ServiceProviders(){
		//get service provider ids for filters provided
		//push request to providers 
	}
	
	public void registerUser(User user){
		hilfeService.registerUser(user);
	}
}
