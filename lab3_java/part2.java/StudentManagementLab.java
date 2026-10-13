public class StudentManagementLab {
    public static void main(String[] args) {
        Student s1 = new UndergraduateStudent(1, "Ali", 19);
        Student s2 = new GraduateStudent(2, "Sara", 24);

        Student[] students = {s1, s2};

        for (Student student : students) {
            student.displayStudentInfo();
            student.attendClass();

            if (student instanceof OnlineCourseable) {
                OnlineCourseable onlineStudent = (OnlineCourseable) student;
                onlineStudent.enrollOnlineCourse("Java Programming");
            }

            if (student instanceof Researchable) {
                Researchable researchStudent = (Researchable) student;
                researchStudent.participateInResearch("Artificial Intelligence");
            }

            System.out.println();
        }
    }
}
