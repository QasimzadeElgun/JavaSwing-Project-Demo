/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Teacher;

/**
 *
 * @author SCC
 */
public interface teacherDao {

    public List<Teacher> getTeacherList() throws Exception;

    boolean addteacher(Teacher teacher) throws Exception;

    boolean updateTeacher(Teacher teacher) throws Exception;

    public Teacher getTeacherById(int id) throws Exception;
    
    boolean deleteTeacher(int id) throws Exception;
    
    public List<Teacher> searchTeacher(String keyword) throws Exception;
}
