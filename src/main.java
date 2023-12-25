import java.util.*;

class Student{
	private String studentId;
	private String name;
	private Map<String, Integer> grades;
	private Map<String, Boolean> attendance;
	
	public Student(String studentId, String name) {
		this.studentId = studentId;
		this.name = name;
		this.grades = new HashMap<>();
		this.attendance = new HashMap<>();
	}

	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void addGrade(String course, int grade) {
		grades.put(course,  grade);
	}
	
	public int getGrade(String course) {
		 return grades.getOrDefault(course, -1);
	}
	
	public void markAttendance(String date, boolean present) {
		attendance.put(date, present);
	}
	
	public boolean getAttendance(String date) {
		return attendance.getOrDefault(date,  false);
	}
	
}

class StudentManagementSystem{
	private Map<String, Student> students;
	
	public StudentManagementSystem() {
		students = new HashMap<>();
	}
	
	public void addStudent(String studentId, String name) {
		students.put(studentId, new Student(studentId, name));
	}
	
	public Student getStudent(String studentId) {
		return students.get(studentId);
	}
	
	public void updateGrade(String studentId, String course, int grade) {
		Student student = students.get(studentId);
		if(student != null) {
			student.addGrade(course, grade);
		}
		else {
			System.out.println("Student not found!");
		}
		
	}
	
	public void markAttendance(String studentId, String date, boolean present) {
		Student student = students.get(studentId);
		if(student != null) {
			student.markAttendance(date, present);
		}else {
			System.out.println("Student not found!");
		}
		
	}
}


public class main {

	public static void main(String[] args) {
		StudentManagementSystem system = new StudentManagementSystem();
		
		
		system.addStudent("S001","Alice");
		system.addStudent("S002", "Bob");
		
		
		system.updateGrade("S001", "Math", 85);
		system.updateGrade("S002", "Science", 78);
		
		
		system.markAttendance("S001", "2023-12-25", true);
		system.markAttendance("S002", "2023-12-25", false);
		
		Student alice = system.getStudent("S001");
		if(alice != null) {
			System.out.println("Student: "+alice.getName());
			System.out.println("Grade in Math: "+alice.getGrade("Math"));
			System.out.println("Attendance on 2023-12-25: "+alice.getAttendance("2023-12-25"));
		}
		
	}

}
