package assig04;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Instructor {
	private static String[] letters = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "F"};

	private String name;
	private ProtectedCourse courseToTeach;

	public Instructor(String nameIn) {
		name = nameIn;
	}

	public String getName() {
		return name;
	}
	
	public Map<Student, String> getGradeAssignment() throws IllegalAccessException {
		Random ranGen = new Random(15);
		Map<Student, String> map = new HashMap<>();
		for(Student s : courseToTeach.getStudents(this)) {
			int j = ranGen.nextInt(letters.length);
			map.put(s, letters[j]);
		}
		return map;
	}

	public String toString () {
		return "Instructor: " + name;
	}
}
