package assig04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtectedCourse implements CourseInterface {
	private String nameAndNumber; 
	private int credits;
	private List<Student> students = new ArrayList<>();
	private Map<Student, String> grades = new HashMap<>(); 
	private Instructor instructor;
	public ProtectedCourse(String nameAndNumberIn, int creditsIn) {
		nameAndNumber = nameAndNumberIn; 
		credits = creditsIn;
	}

	// TODO implement the other methods of CourseInterface
	
	// accessible to course instructor of the course
	public List<Student> getStudents(Instructor instructor) throws IllegalAccessException {
		// TODO throw new IllegalAccessException("This instructor is not teaching this course")
		// if the instructor parameter is not in the instructor field above
		return students;
	}
	
	// accessible to course instructor of the course
	public void assignGrade(Instructor instructor, Student st, String gradeLetter) throws IllegalAccessException {
		// TODO throw new IllegalAccessException("This instructor is not teaching this course")
		// if the instructor parameter is not in the instructor field above
		grades.put(st, gradeLetter);
	}
}
