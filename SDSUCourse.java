import java. util. Iterator;
public class SDSUCourse implements CourseInterface {
	private String courseName;
	private int currentStudents;
	private int maxStudents;
	private WaitList<Student> waitList;
	private Student[] students;  // increasing order of redid
	SDSUCourse(String courseName_, int max) {
		courseName = courseName_;
		currentStudents = 0;
		maxStudents = max;
		waitList = new WaitList<Student>();
		students = new Student[maxStudents];
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCurrentStudents() {
		return currentStudents;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public boolean isFull() {
		return currentStudents >= maxStudents;
	}
	public void addStudent(Student student) {
		if (isFull()) {
			waitList.addToWaitList(student);
			return;
		}
		if (waitList.isEmpty()) {
			students[currentStudents++] = student;
		}
		else {
			students[currentStudents++] = waitList.getNext();
			waitList.addToWaitList(student);
		}
		sortStudents();
	}
	private void sortStudents() {
		for (int i = 0; i < currentStudents - 1; i++) {
			for (int j = 0; j < currentStudents - i - 1; j++) {
				if (students[j].getRedID().compareTo(students[j + 1].getRedID()) > 0) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
	}
	public Student getStudent(String redID) {
		int indexOfStudent = recursiveSearch(0, currentStudents - 1, redID);
		if (indexOfStudent == -1)
			return null;
		return students[indexOfStudent];
	}
	public void removeStudent(String redID) {
		int indexOfStudent = recursiveSearch(0, currentStudents - 1, redID);
		if (indexOfStudent == -1)
			return;
		for (int i = indexOfStudent; i < currentStudents; i++) {
			students[i] = students[i + 1];
		}
		currentStudents--;
	}
	private int recursiveSearch(int l, int r, String redID) {
		if (l > r)
			return -1;
		int mid = (l + (r - 1)) / 2;
		if (students[mid].getRedID().compareTo(redID) == 0)
			return mid;
		if (students[mid].getRedID().compareTo(redID) < 0)
			return recursiveSearch(l, mid - 1, redID);
		return recursiveSearch(mid + 1, r, redID);
	}
	public Iterator<Student> iterator() {
		Iterator<Student> iter = new Iterator<Student>() {
			private int currentIndex = 0;
			public boolean hasNext() {
				return currentIndex < currentStudents;
			}
			public Student next() {
				return students[currentIndex++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return iter;
	}
}
