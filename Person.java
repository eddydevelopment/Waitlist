import java.util.ArrayList;
import java. util. Iterator;
abstract class Person {
	private String name;
	private ArrayList<SDSUCourse> courses;
	public Person(String name_) {
		name = name_;
	}
	public void setName(String name_) {
		name = name_;
	}
	public String getName() {
		return name;
	}
	public void addCourse(SDSUCourse course_) {
		courses.add(course_);
	}
	public void removeCourse(SDSUCourse course_) {
		courses.remove(course_);
	}
	
}
