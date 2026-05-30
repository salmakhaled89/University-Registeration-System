package datafinal;
 public class Student {
    int student_id;
    Node enrolled_courses;
    Student next_student;
    public Student (int student_id){
        this.student_id=student_id;
        this.enrolled_courses=null;
        this.next_student=null;
    }
}