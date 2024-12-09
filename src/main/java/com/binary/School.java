package com.binary;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        boolean exit = false;
        boolean foundTeacher = false;
        boolean foundStudent = false;
        boolean foundS = false;
        boolean foundCourse = false;
        int teacherIndex =-1;
        int sIndex =-1;
            while (!exit) {
                try {
                    System.out.println("1. Register Student:");
                    System.out.println("2. Register Teacher:");
                    System.out.println("3. Add Courses:");
                    System.out.println("4. Assign a Teacher to Student:");
                    System.out.println("5. Assign Course to Student:");
                    System.out.println("6. Show all the Students:");
                    System.out.println("7. Show all the Teachers:");
                    System.out.println("8. Show all the courses:");
                    System.out.println("9. Exit?");
                    System.out.print("Please choose from the options: ");
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        System.out.println("Please enter Student ID: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Please enter Student name: ");
                        String name = scan.nextLine();
                        Student s = new Student(id, name);
                        students.add(s);
                    } else if (choice == 2) {
                        System.out.print("Please enter Teacher ID: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Please enter Teacher name: ");
                        String name = scan.nextLine();
                        Teacher t = new Teacher(id, name);
                        teachers.add(t);
                    } else if (choice == 3) {
                        System.out.println("Please enter Course ID: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Please enter Course name: ");
                        String name = scan.nextLine();
                        Course c = new Course(id, name);
                        courses.add(c);
                    } else if (choice == 4) {
                        System.out.print("What is the teacher ID: ");
                        int idT = scan.nextInt();
                        System.out.print("What is student ID: ");
                        int idS = scan.nextInt();
                        for (int i = 0; i < teachers.size(); i++) {
                            if (teachers.get(i).getId() == idT) {
                                teacherIndex = i;
                                foundTeacher = true;
                                break;
                            }
                        }
                        System.out.println("Found the teacher!");
                        for (Student student : students) {
                            if (student.getId() == idS) {
                                foundStudent = true;
                                break;
                            }
                        }
                        System.out.println("Found the student!");
                        if (foundTeacher && foundStudent) {
                            teachers.get(teacherIndex).addStudent(idS);
                            System.out.println("Successfully assigned the teacher to the student!");
                        } else {
                            System.out.println("Could not find the teacher or the student.");
                        }
                    } else if (choice == 5) {
                        System.out.print("What is the Student ID: ");
                        int idS = scan.nextInt();
                        System.out.print("What is Course ID: ");
                        int idC = scan.nextInt();
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getId() == idS) {
                                sIndex = i;
                                foundS = true;
                                break;
                            }
                        }
                        System.out.println("Student exist!");
                        for (Course cours : courses) {
                            if (cours.getId() == idC) {
                                foundCourse = true;
                                break;
                            }
                        }
                        if (foundS && foundCourse) {
                            students.get(sIndex).addCourse(idC);
                            System.out.println("Successfully assigned the student to the course!");
                        } else {
                            System.out.println("Could not find the student or the course.");
                        }

                    } else if (choice == 6) {
                        for (Student s : students) {
                            System.out.println(s.toString());
                        }
                    } else if (choice == 7) {
                        for (Teacher teacher : teachers) {
                            System.out.println(teacher.toString());
                        }
                    } else if (choice == 8) {
                        for (Course c : courses) {
                            System.out.println(c.toString());
                        }
                    } else if (choice == 9) {
                        System.out.println("You decided to exit!");
                        exit = true;
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }//while loop
        System.out.println("--------------------assigned teachers with students--------------------");
        for (Teacher teacher : teachers) {
            System.out.println("Teacher Name: "+ teacher.getName());
            teacher.showStudents();
        }
        System.out.println("--------------------assigned students with courses--------------------");
        for (Student student : students) {
            System.out.println("Student Name: "+ student.getName());
            student.showCourses();
        }
    }
}
