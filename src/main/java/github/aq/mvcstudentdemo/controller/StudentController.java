package github.aq.mvcstudentdemo.controller;

import github.aq.mvcstudentdemo.model.Student;
import github.aq.mvcstudentdemo.service.StudentService;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Student> getAllStudents() {		
		
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public Student getStudentById(@PathVariable("id")int id) {		 
		return studentService.getStudentById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public void deleteStudentById(@PathVariable("id") int id, HttpServletResponse response) {
		studentService.deleteStudentById(id);		
		//return "redirect:/";
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Student student, HttpServletResponse response) {
		studentService.insertStudent(student);
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
