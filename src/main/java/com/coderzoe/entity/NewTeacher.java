package com.coderzoe.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhs
 * @date 2020/5/28 21:02
 * @description
 */
public class NewTeacher {
    private int id;
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public NewTeacher() {
    }

    @Override
    public String toString() {
        return "NewTeacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
