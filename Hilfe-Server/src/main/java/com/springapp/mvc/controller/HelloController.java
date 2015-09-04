package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Consumer;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.IHilfeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/")
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    IHilfeService hilfeService;


    @RequestMapping(method = {RequestMethod.GET,RequestMethod.HEAD})
	public Consumer printWelcome(ModelMap model) {
    	Consumer consumer = new Consumer();
    	consumer.setId(123L);
    	consumer.setRating(new Float(2.3));
    	consumer.setUserId(1234L);
		model.addAttribute("message", consumer);
        User user = hilfeService.getdetails();
        return consumer;
	}

    //@RequestMapping(method = {RequestMethod.GET,RequestMethod.HEAD})
    @RequestMapping("/printHello")
    public Consumer printHello(@RequestParam (value="name" )String name) {
        Consumer consumer = new Consumer();
        consumer.setId(123L);
        consumer.setRating(new Float(2.3));
        consumer.setUserId(1234L);
        //model.addAttribute("message", consumer);
        User user = hilfeService.getdetails();
        return consumer;
    }

}