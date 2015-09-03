package com.springapp.mvc.controller;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.IHilfeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    IHilfeService hilfeService;


    @RequestMapping(method = {RequestMethod.GET,RequestMethod.HEAD})
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        User user = hilfeService.getdetails();
        return "hello";
	}
}