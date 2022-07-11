package assig04;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<ProtectedCourse> enrollments = new ArrayList<>();
	
	// constructor to set name
        public Student(String name) {
            this.name = name;
        }
        
	// get name
        public String getName(){
            return name;
        }

	public void enroll(ProtectedCourse crs) {
		if (crs.enrollStudent(this)) {
			enrollments.add(crs);
		}
	}

	// getEnrollments
        public List<ProtectedCourse> getEnrollments(){
            return enrollments;
        }
	
	public String getGrade(CourseInterface crs) {
		return crs.getGrade(this);
	}
	
	public String toString () {
		return "Student: " + name;
	}
}
