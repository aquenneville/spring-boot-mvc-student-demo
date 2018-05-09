package github.aq.mvcstudentdemo.dao;

import github.aq.mvcstudentdemo.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository
public class StudentDao {

	private static Map<Integer, Student> students;
	
	static {
		
			students = new HashMap<Integer, Student>() {
			{
				put(1, new Student(1, "Said", "Computer Science"));
				put(2, new Student(2, "Alex U", "Finance"));
				put(3, new Student(3, "Anna", "Maths"));
			}
		
		};
	}
	
	public Collection<Student> getAllStudents() {
		return StudentDao.students.values();
	}
	
	public Student getStudentById(int id) {
		return StudentDao.students.get(id);
	}

	public void deleteStudentById(int id) {
		StudentDao.students.remove(id);		
	}
	
	public void updateStudent(Student student) {
		Student s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(), student);
	}

	public void insertStudent(Student student) {
		students.put(student.getId(), student);		
	}
}
