/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.JdbcUtility;

/**
 *
 * @author SCC
 */
public class studentImpl implements studentDao {

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> listStudent = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER() OVER(ORDER BY s.id) as r, s.id, s.name, s.surname, s.active FROM test.student as s where active = 1;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getInt("r"));
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setActive(rs.getInt("active"));
                    listStudent.add(student);
                }
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return listStudent;

    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "INSERT INTO `test`.`student` (`id`, `name`, `surname`, `active`) VALUES (?, ?, ?, ?);";
        try {

            c = DBHelper.getConnection();

            if (c != null) {

                ps = c.prepareStatement(sql);
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getSurname());
                ps.setInt(4, student.getActive());
                ps.execute();

            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            isAdded = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }

        return isAdded;
    }

    @Override
    public Student getStudentById(int id) throws Exception {
        Student student = new Student();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM test.student where id = ?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setActive(rs.getInt("active"));

                }
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }

        return student;
    }

    @Override
    public boolean updateStudent(Student student) throws Exception {
        boolean isUpdate = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "UPDATE `test`.`student` SET `name` = ?, `surname` = ?, `active` = ? WHERE (`id` = ?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setInt(3, student.getActive());
                ps.setInt(4, student.getId());
                ps.execute();
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            isUpdate = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }

        return isUpdate;
    }

    @Override
    public boolean deleteStudent(int id) throws Exception {
        boolean isDelete = true;
        Connection c = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "UPDATE `test`.`student` SET `active` = '0' WHERE (`id` = ?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }
        return isDelete;
    }

    @Override
    public List<Student> searchStudent(String keyword) throws Exception {
        List<Student> listStudent = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER() OVER(ORDER BY s.id) as r, s.id as id , s.name as name , s.surname as surname , s.active as active FROM test.student as s\n"
                + "WHERE lower(s.id) LIKE LOWER(?) \n"
                + "OR lower(s.name) LIKE LOWER(?) \n"
                + "OR lOWER(s.surname) LIKE LOWER(?) \n"
                + "OR lOWER(s.active) LIKE LOWER(?) \n"
                + "AND s.active=1;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps=c.prepareStatement(sql);
                for(int i=1; i<=4 ; i++){
                    ps.setString(i, "%" + keyword + "%");
                }
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getInt("r"));
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setActive(rs.getInt("active"));
                    listStudent.add(student);
                }
            }else{
                System.err.print("Error!(No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return listStudent;
    }

}
