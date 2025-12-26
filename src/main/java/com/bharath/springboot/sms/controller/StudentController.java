package com.bharath.springboot.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bharath.springboot.sms.entity.Student;
import com.bharath.springboot.sms.serviceimpl.ServiceImpl;

@Controller
public class StudentController {

	private ServiceImpl serimp;

	public StudentController(ServiceImpl serimp) {
		super();
		this.serimp = serimp;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", serimp.findallstudents());
		return "studentview";
	}

	@GetMapping("/students/new")
	public String createStudents(Model model) {
		Student s = new Student();
		model.addAttribute("student", s);
		return "create_student";
	}

	@PostMapping("/crestu")
	public String saveStudent(@ModelAttribute("students") Student student ) {
	  serimp.saveStudent(student);
      return "redirect:/students";
	}
	

	@GetMapping("/students/edit/{id}")
	public String updatestudents(@PathVariable Long id,Model model) {
		Student studentById = serimp.getStudentById(id);
		model.addAttribute("studentById", studentById );
		return "update_student";
	}
	
	@PostMapping("/upstu")
	public String UpdateStudent(@ModelAttribute("studentById") Student student ) {
	  serimp.UpdateStudent(student);
      return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String delete(@ModelAttribute("students") Student student ) {
		serimp.deleteStudent(student.getId());
	      return "redirect:/students";
	}

}
