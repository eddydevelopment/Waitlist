public class UnitTests {
	
	public static void main(String[] args) {
		waitListTest();
		studentTest();
		SDSUCoursesTest();
	}
	
	private static void waitListTest() {
		boolean pass = true;
		WaitList<String> wL = new WaitList<String>();
		if (!wL.isEmpty())
			pass = false;
		wL.addToWaitList("one");
		if (wL.getNext().compareTo("one") != 0)
			pass = false;
		wL.addToWaitList("two");
		wL.addToWaitList("three");
		if (wL.getNext().compareTo("two") != 0)
			pass = false;
		if (wL.getNext().compareTo("three") != 0)
			pass = false;
		if (pass)
			System.out.println("Passed: WaitList");
		else
			System.out.println("Failed: WaitList");
	}
	
	private static void studentTest() {
		boolean pass = true;
		Student s = new Student("eddy", "8212", "CS");
		if (s.getMajor().compareTo("CS") != 0)
			pass = false;
		if (s.getRedID().compareTo("8212") != 0)
			pass = false;
		if (s.getName().compareTo("eddy") != 0)
			pass = false;
		if (pass)
			System.out.println("Passed: Student");
		else
			System.out.println("Failed: Student");
	}
	
	private static void SDSUCoursesTest() {
		boolean pass = true;
		SDSUCourse course = new SDSUCourse("cs-108", 2);
		Student a = new Student("a", "8a", "CS1");
		Student b = new Student("b", "8b", "CS2");
		Student c = new Student("c", "8c", "CS3");
		course.addStudent(a);
		course.addStudent(b);
		course.addStudent(c);
		if (course.getStudent("8a") == null)
			pass = false;
		if (course.getStudent("8b") == null)
			pass = false;
		if (course.getStudent("8c") != null)
			pass = false;
		course.removeStudent("8a");
		if (course.getStudent("8a") != null)
			pass = false;
		if (course.getStudent("8c") == null)
			pass = false;
		if (!course.isFull())
			pass = false;
		if (pass)
			System.out.println("Passed: SDSUCourses");
		else
			System.out.println("Failed: SDSUCourses");
	}
}
