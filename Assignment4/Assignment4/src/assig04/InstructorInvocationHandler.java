package assig04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InstructorInvocationHandler implements InvocationHandler { 
	private ProtectedCourse course;

	public InstructorInvocationHandler(ProtectedCourse courseIn) {
		course = courseIn;
	}

	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable { 
		try {
			if (method.getName().equals("getStudents")) {
				return method.invoke(course, args);
			} else if (method.getName().startsWith("getGrade")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("get")) {
				return method.invoke(course, args);
			} else if (method.getName().startsWith("enroll")) {
				throw new IllegalAccessException("Only the student can enroll in a course");
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException("Only course building can assign the instructor");
			} else if (method.getName().startsWith("assign")) {
				return method.invoke(course, args);
			}
		} catch (InvocationTargetException e) {
			throw e.getCause(); // Just learned this!
		} 
		return null;
	}
	
	public static CourseInterface getInstructorProxy (ProtectedCourse course) {
		return (CourseInterface)Proxy.newProxyInstance(
				CourseInterface.class.getClassLoader(), 
				new Class<?>[] {CourseInterface.class}, 
				new InstructorInvocationHandler(course));			
	}
}
