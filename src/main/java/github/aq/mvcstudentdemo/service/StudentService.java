package github.aq.mvcstudentdemo.service;

import github.aq.mvcstudentdemo.dao.StudentDao;
import github.aq.mvcstudentdemo.model.Student;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents() {
		return this.studentDao.getAllStudents();
	}
	
	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}

	public void deleteStudentById(int id) {
		this.studentDao.deleteStudentById(id);
	}
	
	public void updateStudent(Student student) {				
		this.studentDao.updateStudent(student);
	}

	public void insertStudent(Student student) {
		this.studentDao.insertStudent(student);		
	}
}
