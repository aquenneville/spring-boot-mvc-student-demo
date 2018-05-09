package github.aq.mvcstudentdemo.model;

public class Student {
	
	public Student() {
		
	}
	
	public Student(int studentId, String studentName, String studentCourse) {
		id = studentId;
		name = studentName;
		course = studentCourse;
	}
	
	private int id;
	private String name;
	private String course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
}
