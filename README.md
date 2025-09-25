# **Campus Course & Records Manager (CCRM)**

---

## **Project Overview**

**Campus Course & Records Manager (CCRM)** is a console-based **Java SE application** designed to manage:

- **Students**: create, update, deactivate, enroll/unenroll in courses  
- **Courses**: create, update, deactivate, search/filter, assign instructors  
- **Grades & Transcripts**: record marks, compute GPA, print transcripts  
- **File Utilities**: import/export CSV-like plain files, archive/backup course data  

The project demonstrates **Object-Oriented Programming principles** including **Encapsulation, Inheritance, Abstraction, Polymorphism**, **exception handling**, **Streams API**, **NIO.2 file operations**, **Date/Time API**, and design patterns such as **Singleton** and **Builder**.

---

## **Project Structure**

```text
ccrm/
├── .vscode/
├── backups/
├── exports/
├── out/
├── screenshots/
├── src/
│   └── edu/ccrm/
│       ├── cli/
│       │   └── Main.java
│       ├── config/
│       │   └── AppConfig.java
│       ├── domain/
│       │   ├── Course.java
│       │   ├── Enrollment.java
│       │   ├── Grade.java
│       │   ├── Person.java
│       │   ├── Semester.java
│       │   └── Student.java
│       ├── exception/
│       │   ├── DuplicateEnrollmentException.java
│       │   └── MaxCreditLimitExceededException.java
│       ├── io/
│       │   ├── BackupService.java
│       │   └── FileIO.java
│       ├── service/
│       │   ├── CourseService.java
│       │   ├── CourseServiceImpl.java
│       │   ├── EnrollmentService.java
│       │   ├── EnrollmentServiceImpl.java
│       │   ├── StudentService.java
│       │   ├── StudentServiceImpl.java
│       │   ├── TranscriptService.java
│       │   └── TranscriptServiceImpl.java
│       └── README.md
├── test-data/
│   ├── courses.csv
│   └── students.csv
└── README.md
```

---

## **How to Run**

### **Prerequisites**
- **JDK version 17 or later**  
- Command-line terminal or IDE (Eclipse recommended)

### **Compile**
From the project root:
```bash
javac -d out -sourcepath src src/edu/ccrm/cli/Main.java
```
### **Run**
```bash
java -cp out edu.ccrm.cli.Main
```

---

## **Evolution of Java**

- 1995 – Java 1.0 released by Sun Microsystems

- 1997–2004 – Versions 1.1–1.4: core library updates and JVM improvements

- 2004 – Java SE and Java EE formally defined

- 2006–2014 – Java 5–7: generics, enums, concurrency utilities, enhanced for-loop

- 2014 – Java 8: Streams, Lambdas, Date/Time API

- 2017+ – Modular system (Java 9), LTS releases (Java 11, 17), faster release cadence

---

## **Java ME vs Java SE vs Java EE**

| **Edition** | **Purpose**                                           | **Use Cases**                         |
| ----------- | ----------------------------------------------------- | ------------------------------------- |
| **Java ME** | Micro Edition for embedded devices                    | Mobile/IoT applications               |
| **Java SE** | Standard Edition for desktop and console applications | Command-line tools, standalone apps   |
| **Java EE** | Enterprise Edition for server-side applications       | Web applications, APIs, microservices |

---

## **JDK / JRE / JVM Explanation**

- JVM (Java Virtual Machine): Executes Java bytecode

- JRE (Java Runtime Environment): JVM + runtime libraries required to run applications

- JDK (Java Development Kit): JRE + development tools (javac, jar, javadoc)

**Flow:** Java source code → compiled by javac → bytecode → executed by JVM

---

## **Windows Installation and Eclipse Setup**

**Windows JDK Installation**

1. Download and install **JDK 17 or later.**

2. Set **JAVA_HOME** environment variable to the installation path (e.g., C:\Program Files\Java\jdk-17).

3. Add %JAVA_HOME%\bin to the system PATH.

4. Verify installation:

```bash
java -version

javac -version
```


**Eclipse IDE Setup**

1. File → New → Java Project → Name: ccrm

2. Create packages:
    - edu.ccrm.cli

    - edu.ccrm.domain

    - edu.ccrm.service

    - edu.ccrm.io
    
    - edu.ccrm.exception
    
    - edu.ccrm.config

3. Add source files into respective packages

4. Right-click edu.ccrm.cli.Main → Run As → Java Application


## **Mapping Table: Syllabus Topic → File/Class/Method**

| **Topic**                 | **File/Class/Method**                                             |
| ------------------------- | ----------------------------------------------------------------- |
| **Encapsulation**         | `edu.ccrm.domain.Student` (private fields + getters/setters)      |
| **Inheritance**           | `edu.ccrm.domain.Person` (abstract) → `Student`, `Instructor`     |
| **Abstraction**           | Abstract methods in `Person`                                      |
| **Polymorphism**          | `TranscriptService` handles base `Person` references              |
| **Singleton Pattern**     | `edu.ccrm.config.AppConfig`                                       |
| **Builder Pattern**       | `edu.ccrm.domain.Course.Builder`                                  |
| **Enum**                  | `edu.ccrm.domain.Semester`, `edu.ccrm.domain.Grade`               |
| **Streams & Filters**     | `CourseService.searchCourses()`                                   |
| **NIO.2 File Operations** | `BackupService.java`                                              |
| **Recursive Utility**     | `RecursionUtils.dirSizeRecursive()`                               |
| **Custom Exceptions**     | `DuplicateEnrollmentException`, `MaxCreditLimitExceededException` |
| **Date/Time API**         | `Enrollment.java` (LocalDateTime fields)                          |

---

## **Enabling Assertions**
To enable assertions during execution:

```bash
java -ea -cp out edu.ccrm.cli.Main
```

Assertions are used to validate invariants such as non-null IDs and valid credit ranges.

---

## **USAGE**

This section provides a quick guide to running the CCRM application and using its main features with sample commands and data files.

### **1. Compile and Run**

From the project root directory:

```bash
# Compile the project
javac -d out -sourcepath src src/edu/ccrm/cli/Main.java

# Run the application
java -cp out edu.ccrm.cli.Main
```

### **2. Sample CSV Data Files**

**students.csv :**
| Registration No. |     Name      |             Email              |
|------------------|---------------|--------------------------------|
| 24BCE10001       | Deepti Singh  | deepti.110001@vitbhopal.ac.in  |
| 24BCE10002       | Ram Kumar     | ram.110002@vitbhopal.ac.in     |
| 24BCE10003       | Meera Pandey  | meera.110003@vitbhopal.ac.in   |
| 24BCE10004       | Prateek Singh | prateek.110004@vitbhopal.ac.in |
| 24BCE10005       | Tripti Singh  | tripti.110005@vitbhopal.ac.in  |
| 24BCE10006       | Krish         | krish.110006@vitbhopal.ac.in   |


**courses.csv :**
| Course Code | Course Name                      | Credits | Instructor    | Semester | Department       |
|------------|---------------------------------|--------|---------------|---------|-----------------|
| CSE1001    | Introduction to Problem Solving  | 4      | Dr. Mehta     | SPRING  | Computer Science |
| MAT1001    | Applied Linear Algebra           | 3      | Dr. Sharma    | FALL    | Mathematics      |
| PHY1001    | Computational Physics            | 4      | Dr. Singh     | INTERIM | Physics          |
| CSE1002    | Data Structures and Algorithms   | 4      | Dr. Rao       | SUMMER  | Computer Science |
| CSE1003    | Java Programming                 | 3      | Dr. Arora     | SPRING  | Computer Science |
| CSE1004    | Database Management Systems      | 4      | Dr. Pandey    | SPRING  | Computer Science |
| CSE1005    | Operating Systems                | 4      | Dr. Prakash   | SPRING  | Computer Science |

### **3. Typical Workflow**

1. **Add a Student**  
   - CLI Menu Choice: `1. Add Student`  
   - Enter details: `RegistrationNo`, `Full Name`, `Email`  

2. **List Students**  
   - CLI Menu Choice: `2. List Students`  
   - View all registered students  

3. **Add a Course**  
   - CLI Menu Choice: `3. Add Course`  
   - Enter details: `CourseCode`, `Title`, `Credits`, `Instructor`, `Semester`, `Department`  

4. **List Courses**  
   - CLI Menu Choice: `4. List Courses`  
   - View all available courses  

5. **Enroll a Student**  
   - CLI Menu Choice: `5. Enroll Student`  
   - Provide `RegistrationNo` and `CourseCode`  
   - Business rules (max credits per semester) are applied  

6. **Record Grades**  
   - CLI Menu Choice: `6. Record Grade`  
   - Provide `RegistrationNo`, `CourseCode`, and marks  
   - GPA and letter grade are computed automatically  

7. **Print Transcript**  
   - CLI Menu Choice: `7. Print Transcript`  
   - Enter `RegistrationNo` to display the student’s transcript  

8. **Update Student**  
   - CLI Menu Choice: `8. Update Student`  
   - Modify student details as needed  

9. **Deactivate Student**  
   - CLI Menu Choice: `9. Deactivate Student`  
   - Marks the student as inactive  

10. **Update Course**  
    - CLI Menu Choice: `10. Update Course`  
    - Modify course details  

11. **Deactivate Course**  
    - CLI Menu Choice: `11. Deactivate Course`  
    - Marks the course as inactive  

12. **Import Students from CSV**  
    - CLI Menu Choice: `12. Import Students from CSV`  
    - Use the `test-data/students.csv` file  

13. **Import Courses from CSV**  
    - CLI Menu Choice: `13. Import Courses from CSV`  
    - Use the `test-data/courses.csv` file  

14. **Backup Data & Show Size**  
    - CLI Menu Choice: `14. Backup Data & Show Size`  
    - Exports are copied to a timestamped folder in `backups/`  
    - Recursive size calculation is displayed  

15. **Exit**  
    - CLI Menu Choice: `0. Exit`  
    - Exit the application


### **4. Notes**
- Ensure CSV files are correctly formatted before importing.

- Invalid input will trigger exception messages, demonstrating the application’s error handling.

- Assertions can be enabled with the -ea flag to validate invariants (e.g., non-null IDs, valid credits).


### **5. Screenshots**
| **Screenshot**          | **Description**                                                                 |
| ----------------------- | ------------------------------------------------------------------------------- |
| `jdkInstall.png`        | JDK installation verification (`java -version`, `javac -version`)               |
| `eclipseSetup.png`      | Eclipse project structure showing packages, Main.java, and project organization |
| `howToRun.png`          | CLI showing program running with main menu                                      |
| `addStudent.png`        | Adding a student from CLI menu                                                  |
| `listCourses.png`       | Listing courses in CLI                                                          |
| `listStudents.png`      | Listing students in CLI                                                         |
| `addCourse.png`         | Adding a course from CLI menu                                                   |
| `enroll.png`            | Enrolling a student in a course                                                 |
| `grade.png`             | Recording grades for a student                                                  |
| `transcript.png`        | Printing a student transcript                                                   |
| `updateStudent.png`     | Updating student details                                                        |
| `updateCourse.png`      | Updating course details                                                         |
| `deactivateStudent.png` | Deactivating a student                                                          |
| `deactivateCourse.png`  | Deactivating a course                                                           |
| `importStudent.png`     | Importing students from CSV                                                     |
| `importCourse.png`      | Importing courses from CSV                                                      |
| `exportsFolder.png`     | Exported CSV files in `exports/` folder                                         |
| `backup.png`            | Running backup from CLI                                                         |
| `backupsFolder.png`     | Backup folder structure showing timestamped folders                             |
| `exit.png`              | Exiting the program from CLI                                                    |
| `invalid.png`           | Invalid input handling in CLI                                                   |


---

## **Acknowledgements**

I would like to acknowledge the following resources and guidance that helped in the completion of this project:

- **Oracle Java Documentation** – official reference for Java SE, APIs, and best practices.  
- **Java SE Tutorials** – for understanding Streams, NIO.2, Date/Time API, and functional programming concepts.  
- **Eclipse IDE Documentation** – for project setup, package management, and debugging guidance.  
- **Academic Mentors and Peers** – for advice and feedback during design and implementation.  

This project has been developed independently while referring to these resources for guidance. All external references are properly acknowledged, and the code submitted is original work.

---

## **Demo Video**

A walkthrough demo of the project is available here:  
[Click to View Demo](https://drive.google.com/file/d/1mwpB7xY-QR1qX8TSVqR2DnyEva4PJP8R/view?usp=drivesdk)

