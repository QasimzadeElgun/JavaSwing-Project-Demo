/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SCC
 */
public class Group {

    private int r;
    private int id;
    private String name;
    private int active;
    private Student student;
    private Teacher teacher;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Group{" + "r=" + r + ", id=" + id + ", name=" + name + ", active=" + active + ", student=" + student + ", teacher=" + teacher + '}';
    }

    

}
