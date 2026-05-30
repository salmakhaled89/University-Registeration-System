 package datafinal;
import java.util.Stack;
 public class University_Registeration_System {
 private Student students;   //linked list add to head
 private Course courses; //linked list add to head
 private Course lastAddedCourse;
 private Student lastAddedStudent;
 private Stack<String> undoStack;
 private Stack<String> redoStack;
 
 public University_Registeration_System(){
  this.students=null;
  this.courses=null;
  this.undoStack = new Stack<>();
  this.redoStack = new Stack<>();
  this.lastAddedStudent = null;
  this.lastAddedCourse = null;
 }
    private Student FindStudent (int student_id){
        Student flag = students ;
        while(flag != null){
            if(student_id == flag.student_id){
                return flag ;         // If we found the id break and return flag
            }
            flag = flag.next_student ;        //iterates on students list
        }
        return null ; //If we don't find any students
    }
 
    private Course FindCourse (int course_id){
        Course flag = courses ;
        while(flag != null){
            if(course_id == flag.course_id){
                return flag ;        // If we found the id break and return flag
            }
            flag = flag.next_course ; //iterates on courses list
        }
        return null ; 
    }
    private boolean IsEnrolled(Node enrolled , int id){     //mra mmkn ydyny enrolled courses , course id 
                                                         // w mra enrolled stuendts w student id
    Node current = enrolled;
    while(current !=null){
        if(current.id==id){
        return true;
        }
        current=current.next; 
    }  
    return false;
    }
    public Student getStudentList() {
    return students;
    }
    public Course getCourseList() {
    return courses;
    }
    
    public void addstudent(int student_id)
 {    if(student_id<=0){
      System.out.println("invalid id");
      return ;
  }  
     if(FindStudent(student_id)!=null)//check if student is exist or not
    {
        System.out.println("student with id :" + student_id +"is already exist");
    }
    else{
     Student newstudent=new Student(student_id);
     newstudent.next_student=students ; //point to old head
     students=newstudent ; //new head is new student
     System.out.println("new student with id: "+students.student_id+" has been added ");
     }
     }
 public void removestudent(int student_id){
    if(students==null) //chick if its empty
{
    System.out.println("the linkedlist of students is empty");
    return ; 
}
    if(students.student_id==student_id){ //check if its first node
    System.out.println("the student by id:"+student_id+ "is removed successfully");

    students=students.next_student ;
    return ;
    }
Student prev=students ;
Student tmp=students.next_student ;
while(tmp!=null)
{
    if(tmp.student_id==student_id)
    {
    System.out.println("the  student by id:"+student_id+ "is removed successfully");
     
    prev.next_student=tmp.next_student ;
    return ;
    }
    prev=tmp;
    tmp=tmp.next_student ;
    }
   System.out.println("student doesn't exist");
}
public Student getlastStudentAdded()
{
if(students==null) //chick if its empty
{

System.out.println("the linkedlist of students is empty");
return null ;
}
else{
lastAddedStudent=students ;
System.out.println("last student added is:"+lastAddedStudent.student_id);  
return  lastAddedStudent;
}
}
public Course getLastCourseAdded(){
     if(courses==null){
         System.out.println("courses list is empty");
         return null;
     }else{
         lastAddedCourse=courses;
         System.out.println("Last course added: "+lastAddedCourse.course_id);
           return  lastAddedCourse;
     }
 }
 public void addCourse(int course_id){
    if(course_id<=0){
      System.out.println("INVALID ID NUMBER!");
  }else if( FindCourse(course_id) !=null ){
      System.out.println("Course Id Already Exists!");
  }else{
    Course new_course = new Course (course_id);
     new_course.next_course=courses;
     courses=new_course;
      lastAddedCourse=new_course;
      System.out.println("new course with id: "+ courses.course_id+" has been added ");
         }
 }
public void removeCourse(int course_id) {
    if (courses == null) {
        System.out.println("empty");
        }else if (courses.course_id == course_id) {
       System.out.println("course "+courses.course_id+" is removed successfully");
        courses = courses.next_course;
    }else{
    Course current = courses;
    while (current.next_course != null) {
        if (current.next_course.course_id == course_id) {
            System.out.println("course "+current.next_course.course_id+" is removed successfully");
            current.next_course = current.next_course.next_course;
            return;
        }
        current = current.next_course;
    }
    System.out.println("course doesn't exist");
  }
}
public void enrollStudent(int studentID, int courseID){
  Student student = FindStudent(studentID);
    Course course = FindCourse(courseID);
    if (studentID <= 0 || courseID <= 0) { 
        System.out.println("Invalid student ID or course ID!"); 
    return;}
    if (course == null) {
     System.out.println("Course not found!");
    return; }
    if (student == null) {
        System.out.println("Student not found!");
        return; }
    if (IsEnrolled(student.enrolled_courses, courseID)){
        System.out.println("Student is already enrolled in this course!");
        return ;}
   if (isfullCourse(courseID)) {
    System.out.println("Course is full or not found");
    return;}
   int count=0;
    Node current = student.enrolled_courses;
    while (current != null) {
        count++;
        current= current.next; }
    if (count >= 7) {
        System.out.println("student cannot enroll: reached maximum 7 courses.");
        return; }
    
    
    //add course to student's list  
    Node Newcourse = new Node(courseID);
    Newcourse.next=student.enrolled_courses;
    student.enrolled_courses=Newcourse;
    //add student to course's list
    Node Newstudent=new Node(studentID);
    Newstudent.next=course.enrolled_students;
    course.enrolled_students=Newstudent;
    undoStack.push("enroll " + studentID + " " + courseID);
    redoStack.clear();
    System.out.println("Enrolled student " + studentID + " in course " + courseID);
    count++;
    if (count<2){
        System.out.println("Warning: Student is enrolled in less than 2 courses");}
 }
public void removeEnrollment(int student_id, int course_id) {
   Student student = FindStudent(student_id);
    Course course = FindCourse(course_id);
    if (student == null) {
        System.out.println("Student not found!");
        return; }
    if (course == null) {
        System.out.println("Course not found!");
        return; }
    student.enrolled_courses = removeNode(student.enrolled_courses, course_id);
    course.enrolled_students = removeNode(course.enrolled_students, student_id);
    undoStack.push("remove " + student_id + " " + course_id);
    redoStack.clear();
    System.out.println("Removed student " + student_id + " from course " + course_id);
    }
    //Hellper function in removeenrollment
    private Node removeNode(Node head, int id) {
    if (head == null){ return null;} 
    if (head.id == id){ return head.next;} 
    Node current = head;
    while (current.next != null) {
        if (current.next.id == id) {
            current.next = current.next.next; 
            return head; }
        current = current.next; 
    }
    return head;
}
    public void listCourseByStudent(int studentID) {
        //check student existence
        Student student = FindStudent(studentID);
        if(student == null){
            System.out.println("Student not found.");
            return;
        }
        //check enrollment
        Node currentCourse = student.enrolled_courses;
        if(currentCourse == null){
            System.out.println("Student "+ studentID + "is not enrolled in any course.");
            return;
        }
        //print courses
           System.out.println("Courses for Student " + studentID + ":");
           int courseCount = 0;
           while(currentCourse != null){
               courseCount++;
               System.out.println(courseCount + "Course ID:" + currentCourse.id);
               currentCourse = currentCourse.next; 
           }
           System.out.println("Total Courses: " + courseCount);
    }
    public void listStudentByCourse(int courseID){
            // to find the course in system
            Course course = FindCourse(courseID);
            // if course doesn't exist, show error
            if(course == null){
                System.out.println("[Error]: Course " + courseID + "not found.");
                return;
                   }
            // Check enrollments
            Node currentStudent = course.enrolled_students;
            // if no students are enrolled
            if(currentStudent == null){
                System.out.println("No Students enrolled in Course " + courseID);
                return;
            }
            //print students
            System.out.println("Students enrolled in Course "+ courseID + ":");
            // run through all enrolled students 
            int studentCount = 0;
            while(currentStudent != null){
                studentCount++;
                System.out.println(studentCount + ".Student ID: " + currentStudent.id);
                currentStudent = currentStudent.next;
            }
            System.out.println("Total students: " + studentCount);
        }
    // Sort the student linked list by student_id using Bubble Sort (by swapping IDs only)
    public void sortStudentByID(Student headStudent) {
    if (headStudent == null){ return;}
    boolean swapped;
    do {
        swapped = false;
        Student current = headStudent;
        while (current.next_student != null) {
            if (current.student_id > current.next_student.student_id) {
                // Swap only the IDs (not the nodes)
                int tempID = current.student_id;
                current.student_id = current.next_student.student_id;
                current.next_student.student_id = tempID;
                swapped = true;
            }
            current = current.next_student;
        }
    } while (swapped);
    // Display students after sorting
    displayStudents(headStudent); }
// Display the student list
public void displayStudents(Student headStudent) {
    Student current = headStudent;
    System.out.println("List of students by ID:");
    while (current != null) {
        System.out.println("Student ID: " + current.student_id);
        current = current.next_student; }
}
// Sort the course linked list by course_id using Bubble Sort (by swapping IDs only)
public void sortCourseByID(Course headCourse) {
    if (headCourse == null) {return;}
    boolean swapped;
    do {
        swapped = false;
        Course current = headCourse;
        while (current.next_course != null) {
            if (current.course_id > current.next_course.course_id) {
                // Swap only the IDs (not the nodes)
                int tempID = current.course_id;
                current.course_id = current.next_course.course_id;
                current.next_course.course_id = tempID;
                swapped = true;
            }
            current = current.next_course;
        }
    } while (swapped);
    // Display courses after sorting
    displayCourses(headCourse);}
// Display the course list
public void displayCourses(Course headCourse) {
    Course current = headCourse;
    System.out.println("List of courses by ID:");
    while (current != null) {
        System.out.println("Course ID: " + current.course_id);
        current = current.next_course;}
}
public boolean isfullCourse(int course_id) {
    Course course = FindCourse(course_id);  //  Find the course by its ID.
    if (course == null) {
        System.out.println("Course not found."); // If course doesn't exist, return false.
        return false;
    }

    int count = 0;
    Node curr = course.enrolled_students;  // Start from the head of the student list.
    while (curr != null) {
        count++;                            //  Count how many students are enrolled.
        curr = curr.next;                  // Move to the next student node.
    }

      if(count <20){
   System.out.println("This course should have at least 20 students.");
    return false;
    }
    
      return count >= 30 ; // Return true only if the course has more than 30 students.
}

public boolean isnormalstudent(int student_id) {
    Student student = FindStudent(student_id);  //  Find the student by ID.
    if (student == null) {
        System.out.println("Student not found.");  //  If student doesn't exist, return false.
        return false;}
    int count = 0;
    Node curr = student.enrolled_courses;  //  Start from the head of their enrolled course list.
    while (curr != null) {
        count++;                            // Count how many courses they’re enrolled in.
        curr = curr.next;
    }
    return count >= 2 && count <= 7;  //  Only return true if they’re enrolled in 2 to 7 courses.
}
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        
        String action = undoStack.pop();
        String[] parts = action.split(" ");
        String operation = parts[0];
        int studentID = Integer.parseInt(parts[1]);
        int courseID = Integer.parseInt(parts[2]);
        
        if (operation.equals("enroll")) {
            removeEnrollment(studentID, courseID);
            redoStack.push("remove " + studentID + " " + courseID);
        } else if (operation.equals("remove")) {
            enrollStudent(studentID, courseID);
            redoStack.push("enroll " + studentID + " " + courseID);
        }
    }
    
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        
        String action = redoStack.pop();
        String[] parts = action.split(" ");
        String operation = parts[0];
        int studentID = Integer.parseInt(parts[1]);
        int courseID = Integer.parseInt(parts[2]);
        
        if (operation.equals("enroll")) {
            enrollStudent(studentID, courseID);
            undoStack.push("enroll " + studentID + " " + courseID);
        } else if (operation.equals("remove")) {
            removeEnrollment(studentID, courseID);
            undoStack.push("remove " + studentID + " " + courseID);
        }
    }

}


// public void displaycourses(){
//     if(courses==null){
//         System.out.println("empty");
//     }else{
//         Course current=courses;
//         while(current!=null){
//             System.out.println("course: "+current.course_id);
//             current=current.next_course;
//         }
//     }
//     
// }