package assig04;

public class Driver {

	public static void main(String[] args) {
		Student std1 = new Student("Jane Smith");
		Student std2 = new Student("John Jones");
		ProtectedCourse crs1 = new ProtectedCourse("CS 542 Design Patterns", 3);
		ProtectedCourse crs2 = new ProtectedCourse("CS 540 Object Oriented Programming", 3);
		Instructor instr1 = new Instructor("George Cooke");
		Instructor instr2 = new Instructor("Jennifer Williams");
		crs1.setInstructor(instr1);
		crs2.setInstructor(instr2);

		
		
		CourseInterface instrProxy1 = InstructorInvocationHandler.getInstructorProxy(crs1);
		
		// you have to write the StudentInvocationHandler
		CourseInterface studentProxy1 = StudentInvocationHandler.getStudentProxy(crs1);
		CourseInterface studentProxy2 = StudentInvocationHandler.getStudentProxy(crs2);
		
		try {
			studentProxy1.enrollStudent(std1); 
			studentProxy1.enrollStudent(std2);
			studentProxy2.enrollStudent(std1);
			studentProxy2.enrollStudent(std2);
			System.out.println(instrProxy1.getStudents(instr1));
			System.out.println(instrProxy1.getStudents(instr2)); // will throw an exception since wrong instructor
		} catch(Exception e) {
			System.out.println(e.getMessage()); // exception printed here
		}
	}
}
