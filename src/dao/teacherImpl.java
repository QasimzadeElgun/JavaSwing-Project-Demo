/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JdbcUtility;

/**
 *
 * @author SCC
 */
public class teacherImpl implements teacherDao {

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> listTeacher = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER() OVER(ORDER BY t.id) as r , t.id , t.name , t.surname , t.active FROM test.teacher as t where active = 1;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setR(rs.getInt("r"));
                    teacher.setId(rs.getInt("id"));
                    teacher.setName(rs.getString("name"));
                    teacher.setSurname(rs.getString("surname"));
                    teacher.setActive(rs.getInt("active"));
                    listTeacher.add(teacher);

                }

            } else {
                System.err.println("Error!(no connection)");
            }
        } catch (Exception e) {
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return listTeacher;
    }

    @Override
    public boolean addteacher(Teacher teacher) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "INSERT INTO `test`.`teacher` (`id`, `name`, `surname`, `active`) VALUES (?, ?, ?, ?);";
        try {

            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, teacher.getId());
                ps.setString(2, teacher.getName());
                ps.setString(3, teacher.getSurname());
                ps.setInt(4, teacher.getActive());
                ps.execute();

            } else {
                System.err.print("Error!(no Connection");
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
    public boolean updateTeacher(Teacher teacher) throws Exception {
        boolean isUpdate = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "UPDATE `test`.`teacher` SET `name` = ?, `surname` = ?, `active` = ? WHERE (`id` = ?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, teacher.getName());
                ps.setString(2, teacher.getSurname());
                ps.setInt(3, teacher.getActive());
                ps.setInt(4, teacher.getId());
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
    public Teacher getTeacherById(int id) throws Exception {
        Teacher teacher = new Teacher();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM test.teacher where id = ? ;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    teacher.setId(rs.getInt("id"));
                    teacher.setName(rs.getString("name"));
                    teacher.setSurname(rs.getString("surname"));
                    teacher.setActive(rs.getInt("active"));
                }
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return teacher;

    }

    @Override
    public boolean deleteTeacher(int id) throws Exception {
        boolean isDelete = true;
        Connection c = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "UPDATE `test`.`teacher` SET `active` = '0' WHERE (`id` = ?);";
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

    public List<Teacher> searchTeacher(String keyword) throws Exception {
        List<Teacher> listTeacher = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER() OVER(ORDER BY t.id) as r,  t.id , t.name , t.surname , t.active FROM test.teacher as t\n"
                + "WHERE lower(t.id) LIKE LOWER(?) \n"
                + "OR lower(t.name) LIKE LOWER(?) \n"
                + "OR lOWER(t.surname) LIKE LOWER(?) \n"
                + "OR lOWER(t.active) LIKE LOWER(?) \n"
                + "AND t.active=1;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                for(int i = 1; i<= 4; i++){
                ps.setString(i, "%" + keyword + "%");
                }
                //ps.setString(5, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {

                    Teacher teacher = new Teacher();
                    teacher.setR(rs.getInt("r"));
                    teacher.setId(rs.getInt("id"));
                    teacher.setName(rs.getString("NAME"));
                    teacher.setSurname(rs.getString("SURNAME"));
                    teacher.setActive(rs.getInt("ACTIVE"));
                    listTeacher.add(teacher);

                }
            } else {
                System.err.println("ERROR!(No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }

        return listTeacher;
    }

}
