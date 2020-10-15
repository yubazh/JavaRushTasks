package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        Student result;
        for (Student student : students) {
            if (student.getAverageGrade() == value) {
                return student;
            }

        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = students.get(0);
        for (Student student : students) {
            if (result.getAverageGrade() < student.getAverageGrade())
                result = student;
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        Student result = students.get(0);
        for (Student student : students) {
            if (result.getAverageGrade() > student.getAverageGrade()) {
                result = student;
            }
        }
        return result;
    }

    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }
}