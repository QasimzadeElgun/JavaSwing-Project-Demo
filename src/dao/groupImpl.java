package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Group;
import model.Student;
import model.Teacher;
import util.JdbcUtility;

public class groupImpl implements groupDao {

    public List<Group> getCourseGroup() throws Exception {
        List<Group> listGroup = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select  ROW_NUMBER() OVER(ORDER BY G.id) as r, G.id as id , G.NAME as GROUP_NAME ,S.name as STUDENT_NAME, S.surname as STUDENT_SURNAME, T.NAME as TEACHER_NAME , T.SURNAME as TEACHER_SURNAME , G.active as active\n"
                + "FROM test.group as G\n"
                + "INNER JOIN test.teacher as T ON G.TEACHER_ID = T.ID \n"
                + "INNER JOIN test.student as S on G.student_id = S.id where G.active=1;";

        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Group g = new Group();
                    g.setR(rs.getInt("r"));
                    g.setId(rs.getInt("ID"));
                    g.setName(rs.getString("GROUP_NAME"));
                    g.setActive(rs.getInt("active"));
                    Teacher t = new Teacher();
                    Student s = new Student();
                    s.setName(rs.getString("STUDENT_NAME"));
                    s.setSurname(rs.getString("TEACHER_SURNAME"));
                    // t.setId(rs.getInt("TEACHER_ID"));
                    t.setName(rs.getString("TEACHER_NAME"));
                    t.setSurname(rs.getString("TEACHER_SURNAME"));
                    g.setStudent(s);
                    g.setTeacher(t);
                    listGroup.add(g);
                }
            } else {
                System.err.println("ERROR!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return listGroup;
    }

    @Override
    public boolean addGroup(Group group) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "INSERT INTO `test`.`group` (`id`, `name`, `student_id`, `teacher_id`, `active`) VALUES (? , ? , ? , ? , ? );";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, group.getId());
                ps.setString(2, group.getName());
                ps.setInt(3, group.getStudent().getId());
                ps.setInt(4, group.getTeacher().getId());
                ps.setInt(5, group.getActive());
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
    public Group getGroupById(int id) throws Exception {
        Group group = new Group();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select  G.id as id , G.NAME as GROUP_NAME ,S.name as STUDENT_NAME, S.surname as STUDENT_SURNAME, T.NAME as TEACHER_NAME , T.SURNAME as TEACHER_SURNAME , G.active as active\n"
                + "FROM test.group as G\n"
                + "INNER JOIN test.teacher as T ON G.TEACHER_ID = T.ID \n"
                + "INNER JOIN test.student as S on G.student_id = S.id where G.id = ?;";
        try {

            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    group.setId(rs.getInt("id"));
                    group.setName(rs.getString("group_name"));
                    Student student = new Student();
                    student.setName(rs.getString("student_name"));
                    student.setSurname(rs.getString("student_surname"));
                    Teacher teacher = new Teacher();
                    teacher.setName(rs.getString("teacher_name"));
                    teacher.setSurname(rs.getString("teacher_surname"));
                    group.setActive(rs.getInt("active"));
                    group.setStudent(student);
                    group.setTeacher(teacher);

                }
            } else {
                System.err.print("Error!No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return group;
    }

    @Override
    public boolean updateGroup(Group group) throws Exception {
        boolean isUpdate = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "UPDATE `test`.`group` SET `name` = ?, `student_id` = ?, `teacher_id` = ?, `active` = ? WHERE (`id` = ?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);

                ps.setString(1, group.getName());
                ps.setInt(2, group.getStudent().getId());
                ps.setInt(3, group.getTeacher().getId());
                ps.setInt(4, group.getActive());
                ps.setInt(5, group.getId());
                ps.execute();
            } else {
                System.err.print("Error!No Connection");
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
    public boolean deleteGroup(int id) throws Exception {
        boolean isDelete = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "UPDATE `test`.`group` SET `active` = '0' WHERE (`id` = ?);";
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
            isDelete = false;
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }
        return isDelete;
    }

    @Override
    public List<Group> searchGroup(String keyword) throws Exception {
        List<Group> listGroup = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql ="select ROW_NUMBER() OVER(ORDER BY G.id) as r, G.id as id ,"
                + " G.NAME as GROUP_NAME ,S.name as STUDENT_NAME, S.surname as STUDENT_SURNAME,"
                + " T.NAME as TEACHER_NAME , T.SURNAME as TEACHER_SURNAME , G.active as active\n"
                + "FROM test.group as G \n"
                + "INNER JOIN test.teacher as T ON G.TEACHER_ID = T.ID \n"
                + "INNER JOIN test.student as S on G.student_id = S.id \n"
                + "WHERE lower(G.id) LIKE LOWER(?) \n"
                + "OR lOWER(G.name) LIKE LOWER(?) \n"
                + "OR lower(S.name) LIKE LOWER(?) \n"
                + "OR lOWER(S.surname) LIKE LOWER(?) \n"
                + "OR lOWER(T.name) LIKE LOWER(?) \n"
                + "OR lOWER(T.surname) LIKE LOWER(?) \n"
                + "OR lOWER(G.active) LIKE LOWER(?) \n"
                + "AND G.active=1;";
                
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                for (int i = 1; i <= 7; i++) {
                    ps.setString(i, "%" + keyword + "%");
                }
                rs = ps.executeQuery();
                while (rs.next()) {
                    Group group = new Group();
                    group.setR(rs.getInt("r"));
                    group.setId(rs.getInt("id"));
                    group.setName(rs.getString("group_name"));
                    Student student = new Student();
                    student.setName(rs.getString("student_name"));
                    student.setSurname(rs.getString("student_surname"));
                    Teacher teacher = new Teacher();
                    teacher.setName(rs.getString("teacher_name"));
                    teacher.setSurname(rs.getString("teacher_surname"));
                    group.setActive(rs.getInt("active"));
                    group.setStudent(student);
                    group.setTeacher(teacher);
                    listGroup.add(group);
                }
            } else {
                System.err.print("Error!(No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }
        return listGroup;
    }
}
