import java.util.ArrayList;
import java.util.Iterator;

public interface CourseInterface {
	public String getCourseName();
	public int getCurrentStudents();
	public int getMaxStudents();
	public boolean isFull();
	public void addStudent(Student student);
	public Student getStudent(String redID);
	public void removeStudent(String redID);
}


