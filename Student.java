public class Student extends Person {
	private String redID;
	private String major;
	public Student(String name_, String redID_, String major_) {
		super(name_);
		redID = redID_;
		major = major_;
	}
	public String getRedID() {
		return redID;
	}
	public String getMajor() {
		return major;
	}
}

