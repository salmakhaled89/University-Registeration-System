 package datafinal;
public class Datafinal {
    public static void main(String[] args) {
        University_Registeration_System system=new  University_Registeration_System();
       // Add 22 students
        system.addstudent(103);
        system.addstudent(101);
        system.addstudent(105);
        system.addstudent(102);
        system.addstudent(106);
        system.addstudent(108);
        system.addstudent(107);
        system.addstudent(110);
        system.addstudent(113);
        system.addstudent(109);
        system.addstudent(111);
        system.addstudent(115);
        system.addstudent(112);
        system.addstudent(116);
        system.addstudent(114);
        system.addstudent(119);
        system.addstudent(117);
        system.addstudent(118);
        system.addstudent(104);
        system.addstudent(120);
        system.addstudent(121);
        system.addstudent(122);
        System.out.println();
        

        // Add 9 courses
        system.addCourse(201);
        system.addCourse(202);
        system.addCourse(203);
        system.addCourse(204);
        system.addCourse(205);
        system.addCourse(206);
        system.addCourse(207);
        system.addCourse(208);
        system.addCourse(209);
        System.out.println();
 
         // Remove a student from the system
        system.removestudent(103);
        System.out.println();
        
         // Remove a course from the system
        system.removeCourse(203);
        System.out.println();
        
         // Display the last student and last course added
        system.getlastStudentAdded();
        system.getLastCourseAdded();
        System.out.println();
        
          // Enroll students in courses
        system.enrollStudent(101, 201);
        system.enrollStudent(102, 201);
        system.enrollStudent(104, 201);
        system.enrollStudent(105, 201);
        system.enrollStudent(106, 201);
        system.enrollStudent(107, 201);
        system.enrollStudent(108, 201);
        system.enrollStudent(109, 201);
        system.enrollStudent(110, 201);
        system.enrollStudent(111, 201);
        system.enrollStudent(112, 201);
        system.enrollStudent(113, 201);
        system.enrollStudent(114, 201);
        system.enrollStudent(115, 201);
        system.enrollStudent(116, 201);
        system.enrollStudent(117, 201);
        system.enrollStudent(118, 201);
        system.enrollStudent(119, 201);
        system.enrollStudent(120, 201);
        system.enrollStudent(121, 201);
        system.enrollStudent(122, 201);
        system.enrollStudent(101, 202);
        system.enrollStudent(102, 202);
        system.enrollStudent(104, 202);
        system.enrollStudent(105, 202);
        system.enrollStudent(101, 208);
        System.out.println();
        
               
                // Test if student is enrolled in a normal number of courses
        System.out.println("Is student 101 normal? " + system.isnormalstudent(101));
        System.out.println();
 
                // Remove a student's enrollment from a course
        system.removeEnrollment(102, 202);
        System.out.println();
        
                // Display courses for a specific student
        system.listCourseByStudent(101);
        System.out.println();

        // Display students enrolled in a specific course
        system.listStudentByCourse(202);
        System.out.println();
           system.listStudentByCourse(208);
        System.out.println();
        
         // Display students and courses before sorting
        System.out.println("Before sorting:");
        system.displayStudents(system.getStudentList());
        system.displayCourses(system.getCourseList());

        // Sort and display students by ID
        System.out.println("\nAfter sorting students:");
        system.sortStudentByID(system.getStudentList());

        // Sort and display courses by ID
        System.out.println("\nAfter sorting courses:");
        system.sortCourseByID(system.getCourseList());
        System.out.println();


        // Test if course is full
        System.out.println("Is course 202 full? " + system.isfullCourse(202));
        System.out.println();
 
        // Undo and redo operations
        system.undo(); // Undo the last enrollment removal
        system.redo(); // Redo the same enrollment removal
 

    }
    
}
