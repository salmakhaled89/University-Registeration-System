 package datafinal;
 public class Course {
    int course_id;
    Node enrolled_students;
    Course next_course;
    
    public Course(int course_id){
        this.course_id=course_id;
        this.enrolled_students=null;
        this.next_course=null;
    }
}