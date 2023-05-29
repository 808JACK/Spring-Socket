package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String schoolName;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Department> departments;

    public School(int id, String schoolName) {
        this.id = id;
        this.schoolName = schoolName;
    }

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
