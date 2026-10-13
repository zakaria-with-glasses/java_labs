abstract class Student {
    protected int studentId;
    protected String name;
    protected int age;

    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public abstract void displayStudentInfo();

    public void attendClass() {
        System.out.println(name + " is attending class.");
    }
}
