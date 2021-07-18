package it.goodgamegroup.product.frontEnd.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.goodgamegroup.product.frontEnd.models.Student;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("/sendTextData")
	public ModelAndView sendTextData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("messaggio", "CiaoMondo");
		return mav;
	}
	
	@RequestMapping("/sendObjectData")
	public ModelAndView sendObjectData() {
		ModelAndView mav = new ModelAndView("student");
		Student s = new Student();
		s.setName("Gianluca");
		s.setScore(10);
		mav.addObject("studente",s);
		return mav;
	}
	
	@RequestMapping("/sendObjectsData")
	public ModelAndView sendObjectsData() {
		ModelAndView mav = new ModelAndView("studentList");
		
		Student s1 = new Student();
		s1.setName("Gianluca");
		s1.setScore(10);
		
		Student s2 = new Student();
		s2.setName("Mario");
		s2.setScore(10);
		
		List<Student> studenti = new LinkedList<>();
		studenti.add(s1);
		studenti.add(s2);

		mav.addObject("studenti",studenti);
		return mav;
	}
	
	@RequestMapping("/form")
	public ModelAndView studentFormInsert() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student s1 = new Student();
		s1.setName("Gianluca Prova");
		s1.setScore(100);
		mav.addObject("studente",s1);
		return mav;
	}
	@RequestMapping("/saveStudent")
	public ModelAndView studentFormInsertSave(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.print(student.getName());
		return mav;
	}
}
