/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Student;

/**
 *
 * @author SCC
 */
public interface studentDao {

    public List<Student> getStudentList() throws Exception;

    boolean addStudent(Student student) throws Exception;

    public Student getStudentById(int id) throws Exception;

    boolean updateStudent(Student student) throws Exception;

    boolean deleteStudent(int id) throws Exception;
    
    public List<Student> searchStudent (String keyword) throws Exception;
}
