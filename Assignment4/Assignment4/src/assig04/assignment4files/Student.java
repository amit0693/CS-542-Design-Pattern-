package assig04;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<ProtectedCourse> enrollments = new ArrayList<>();
	
	// constructor to set name

	// get name

	public void enroll(ProtectedCourse crs) {
		if (crs.enrollStudent(this)) {
			enrollments.add(crs);
		}
	}

	// getEnrollments
	
	public String getGrade(CourseInterface crs) {
		// TODO
	}
	
	public String toString () {
		return "Student: " + name;
	}
}
