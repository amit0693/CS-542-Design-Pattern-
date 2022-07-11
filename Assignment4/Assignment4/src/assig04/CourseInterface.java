package assig04;

import java.util.List;

public interface CourseInterface {
	String getNameAndNumber(); // accessible to everyone
        
	int getCredits(); // accessible to everyone
        
	Instructor getInstructor(); // accessible to everyone
        
	boolean enrollStudent(Student st); // accessible to student only
        
	String getGrade(Student student); // accessible to student only
        
	void setInstructor(Instructor instructor); // accessible only to Driver, NOT to Student or Instructor
        
	List<Student> getStudents(Instructor instructor) throws IllegalAccessException; // accessible to instructor only
        
	void assignGrade(Instructor instructor, Student st, String gradeLetter) throws IllegalAccessException; // accessible to instructor only
}
