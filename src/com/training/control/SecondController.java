package com.training.control;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.domain.HibernateSpringExample;
import com.training.entity.Student;

@Controller
@RequestMapping("/first.htm")
public class SecondController {

	Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ModelAndView mdl;
	
	@Autowired
	private Student student;
	
	@Autowired
	HibernateSpringExample dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(){

		log.info("=====================init======================");
		mdl.setViewName("AddDetails");
		
		mdl.addObject("command",student);
		
		return mdl;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("student") Student student) {
		
		log.info("---------------------------M&V----------------");
		
		Long key = (Long)dao.add(student);
		
		log.info("=================="+key);
		mdl.setViewName("Success");
		
		return mdl;
		
	}
	
	
}