class GraduateStudent extends Student implements Researchable {
    public GraduateStudent(int studentId, String name, int age) {
        super(studentId, name, age);
    }

    @Override
    public void displayStudentInfo() {
        System.out.println("Graduate Student");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    @Override
    public void participateInResearch(String projectName) {
        System.out.println(name + " is participating in research project: " + projectName);
    }
}
