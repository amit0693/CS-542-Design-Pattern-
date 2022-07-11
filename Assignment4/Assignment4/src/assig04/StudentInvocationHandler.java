package assig04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

class StudentInvocationHandler implements InvocationHandler {
    private ProtectedCourse course;

    public StudentInvocationHandler(ProtectedCourse courseIn) {
	course = courseIn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().equals("getStudents")) {
                throw new IllegalAccessException("Only the instructor can get students");
                
            } else if (method.getName().startsWith("getGrade")) {
                return method.invoke(course, args);
                
            } else if (method.getName().startsWith("enroll")) {
                return method.invoke(course, args);
                
            } else if (method.getName().startsWith("set")) {
                throw new IllegalAccessException("Only course building can assign the instructor");
            
            } else if (method.getName().startsWith("assign")) {
                throw new IllegalAccessException("Only the instructor can assign grade");
            }
        } catch (InvocationTargetException e) {
            throw e.getCause(); // Just learned this!
        }
        return null;
    }
    
    public static CourseInterface getStudentProxy(ProtectedCourse course) {
        return (CourseInterface) Proxy.newProxyInstance(
                CourseInterface.class.getClassLoader(),
                new Class<?>[]{CourseInterface.class},
                new StudentInvocationHandler(course));
    }
}
