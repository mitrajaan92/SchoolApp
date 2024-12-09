package com.binary;

import java.util.LinkedList;

public class Teacher {
    private int id;
    private String name;
    private LinkedList<Integer> studentIds; // List of student IDs

    public LinkedList<Integer> getStudentIds() {
        return studentIds;
    }

    public Teacher(int id, String name){
        this.id = id;
        this.name = name;
        this.studentIds = new LinkedList<>();

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
        return "Teacher: " + "ID = " + id +", Name = " + name;
    }
    public void addStudent(int studentId) {
        this.studentIds.add(studentId);
    }
    public void showStudents(){
        for(Integer s: studentIds){
            System.out.println("Student ID: "+ s);
        }
    }

}
