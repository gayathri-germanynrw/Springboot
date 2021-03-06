package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sample.demo.dao.AlienRepo;
import com.sample.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alienrepo;
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
		
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienrepo.save(alien);
		return "home.jsp";
		
	}
	
	@RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid) {
    	ModelAndView mv=new ModelAndView();
    	Alien alien=alienrepo.findById(aid).orElse(new Alien());
    	mv.addObject(alien);
    	mv.setViewName("ShowAlien.jsp");
		return mv;
    }

}
