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
public class Student {

    private int r;
    private int id;
    private String name;
    private String surname;
    private int active;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{" + "r=" + r + ", id=" + id + ", name=" + name + ", surname=" + surname + ", active=" + active + '}';
    }

    
}
