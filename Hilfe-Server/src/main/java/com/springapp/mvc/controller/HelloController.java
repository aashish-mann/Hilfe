package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.entity.Consumer;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.IHilfeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MultivaluedMap;


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
    //@RequestMapping("/printHello")
    @RequestMapping(value = "/printHello",method = RequestMethod.POST,consumes = "application/json")
    public String printHello(@RequestParam (value="name") String name) {
        Consumer consumer = new Gson().fromJson(name,Consumer.class);

        /*Consumer consumer = new Consumer();
        consumer.setId(123L);
        consumer.setRating(new Float(2.3));
        consumer.setUserId(Long.parseLong(name));*/

        LOG.info("consumer {}",consumer.toString());

        //model.addAttribute("message", consumer);
        //User user = hilfeService.getdetails();
        String result = new Gson().toJson(consumer);
        return result;

        //return consumer;
    }

    @RequestMapping(value = "/printHello1",method = RequestMethod.POST,consumes = "application/json")
    public Consumer printHello1(@RequestBody Consumer name) {
        //Consumer consumer = new Gson().fromJson(user,Consumer.class);

        Consumer consumer = new Consumer();
        consumer.setId(name.getId());
        consumer.setRating(name.getRating());
        consumer.setUserId(name.getUserId());

        LOG.info("consumer {}",consumer.toString());

        //model.addAttribute("message", consumer);
        //User user = hilfeService.getdetails();
        //return new Gson().toJson(consumer);

        return consumer;
    }
}