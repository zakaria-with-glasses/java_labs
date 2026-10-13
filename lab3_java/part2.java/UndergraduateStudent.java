class UndergraduateStudent extends Student implements OnlineCourseable{
	public UndergraduateStudent(int studentId, String name, int age) {
		super(studentId, name, age);
	}

	@Override
	public void displayStudentInfo() {
		System.out.println("Undergraduate Student");
		System.out.println("ID: " + studentId);    System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

	@Override
	public void enrollOnlineCourse(String courseName) {
		System.out.println(name + " enrolled in online course: " + courseName);
	}	
}
