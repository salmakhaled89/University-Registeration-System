# University-Registeration-System
A Java-based university registration system implementing custom Linked List data structures for efficient student and course management.
<img width="973" height="1600" alt="WhatsApp Image 2026-05-30 at 9 06 54 PM" src="https://github.com/user-attachments/assets/43f0178d-d6bd-48ec-b8a0-87e03f19af7e" />
# University Registration System (Linked List Implementation)

A comprehensive **Java console application** that models a university student registration ecosystem. This project avoids using built-in Java collection libraries (like ArrayList or LinkedList) to demonstrate a deep, low-level understanding of dynamic memory allocation, pointer manipulation, and fundamental **Data Structures**.

##  Tech Stack & Concepts
- **Language:** Java (JDK 11+)
- **Core Concepts:** Custom Singly/Doubly Linked Lists, Node manipulation, Object Reference Chains, and Search/Sort Algorithms.

##  Data Structure Architecture
The system utilizes a custom, tailored linked list structure where:
- Each **Department** node points to a linked list of **Courses**.
- Each **Course** node contains a linked list of enrolled **Students**.
- Dynamic insertion and deletion are handled manually through pointer tracking to optimize memory efficiency.

---

##  Key Features

1. **Custom List Implementation:** Developed explicit `Node` and `LinkedList` classes with manual pointer linkages for all core operations.
2. **Dynamic Course Registration:** Supports adding, dropping, and tracking student course enrollments on the fly.
3. **Data Retrieval & Queries:** Implemented efficient traversal algorithms to find students by ID, search courses by department, and display continuous academic registers.
4.
