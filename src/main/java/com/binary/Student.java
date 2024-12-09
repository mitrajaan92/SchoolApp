package com.binary;

import java.util.LinkedList;

public class Student {
    private int id;
    private String name;
    private LinkedList<Integer> coursesID;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
        this.coursesID = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + "ID = " + id +", Name = " + name;
    }
    public void addCourse(int id){
        this.coursesID.add(id);
    }

    public LinkedList<Integer> getCoursesID() {
        return coursesID;
    }

    public void setCoursesID(LinkedList<Integer> coursesID) {
        this.coursesID = coursesID;
    }
    public void showCourses(){
        for(Integer s: coursesID){
            System.out.println("Course ID: "+ s);
        }
    }
}
