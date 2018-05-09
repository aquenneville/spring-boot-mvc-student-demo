package github.aq.mvcstudentdemo.controller;

import github.aq.mvcstudentdemo.model.Student;
import github.aq.mvcstudentdemo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class StudentWebController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllStudents(Model model) {		
		model.addAttribute("students", studentService.getAllStudents());
		model.addAttribute("student",new Student());
		return "index";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Student getStudentById(@PathVariable("id")int id, Model model) {
		return studentService.getStudentById(id);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public String deleteStudentById(@PathVariable("id") int id, Model model) {
		studentService.deleteStudentById(id);
		model.addAllAttributes(studentService.getAllStudents());
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student, Model model) {
		studentService.updateStudent(student);
		model.addAllAttributes(studentService.getAllStudents());
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String insertStudent(@ModelAttribute @RequestBody Student student, Model model) {
		studentService.insertStudent(student);
		model.addAllAttributes(studentService.getAllStudents());
		return "redirect:/";
	}
}
