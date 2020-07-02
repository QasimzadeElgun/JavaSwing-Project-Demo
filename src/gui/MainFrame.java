/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Group;
import model.Student;
import model.Teacher;
import dao.groupDao;
import dao.teacherDao;
import dao.studentDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    groupDao gd = null;
    studentDao sd = null;
    teacherDao td = null;
    String clickedButtonId = null;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        // showGroupList();
    }

    public MainFrame(groupDao gd, studentDao sd, teacherDao td) {
        initComponents();
        this.gd = gd;
        this.sd = sd;
        this.td = td;
        // showGroupList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        addİd = new javax.swing.JButton();
        updateİd = new javax.swing.JButton();
        deleteİd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        getStudentListButtonİd = new javax.swing.JButton();
        getTeacherListButtonİd = new javax.swing.JButton();
        getGroupListButtonİd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableId = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        keywordTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        addİd.setText("Add");
        addİd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addİdActionPerformed(evt);
            }
        });

        updateİd.setText("Update");
        updateİd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateİdActionPerformed(evt);
            }
        });

        deleteİd.setText("Delete");
        deleteİd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteİdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(updateİd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addİd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteİd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(addİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(updateİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(deleteİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        getStudentListButtonİd.setText("StudentList");
        getStudentListButtonİd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getStudentListButtonİdActionPerformed(evt);
            }
        });

        getTeacherListButtonİd.setText("TeacherList");
        getTeacherListButtonİd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTeacherListButtonİdActionPerformed(evt);
            }
        });

        getGroupListButtonİd.setText("GroupList");
        getGroupListButtonİd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getGroupListButtonİdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(getGroupListButtonİd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getTeacherListButtonİd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getStudentListButtonİd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(getStudentListButtonİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(getTeacherListButtonİd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(getGroupListButtonİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtableId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ){public boolean isCellEditable(int row, int column){return false;}}
    );
    jtableId.setShowVerticalLines(false);
    jtableId.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jtableIdMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jtableId);

    keywordTxt.setBorder(null);
    keywordTxt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            keywordTxtActionPerformed(evt);
        }
    });
    keywordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            keywordTxtKeyReleased(evt);
        }
    });

    searchBtn.setText("Search");
    searchBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    searchBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchBtnActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(28, 28, 28))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap(27, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(keywordTxt))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    /*  public boolean isCellEditable(int row, int column) {
     *     return false;
     * }
     */

    private void getGroupListButtonİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getGroupListButtonİdActionPerformed
        try {
            clickedButtonId = "getGroupListButtonid";
            List<Group> listGroup = gd.getCourseGroup();
            showGroupList(listGroup);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_getGroupListButtonİdActionPerformed

    private void getStudentListButtonİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getStudentListButtonİdActionPerformed
        try {
            clickedButtonId = "getStudentListButtonId";
            List<Student> listStudent = sd.getStudentList();
            showStudentlist(listStudent);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_getStudentListButtonİdActionPerformed

    private void addİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addİdActionPerformed
        switch (clickedButtonId) {
            case "getStudentListButtonId":
                AddStudentFrame addStudentFrame = new AddStudentFrame(sd);
                addStudentFrame.setVisible(true);
                break;

            case "getTeacherListButtonId":
                AddTeacherFrame addTeacherFrame = new AddTeacherFrame(td);
                addTeacherFrame.setVisible(true);
                break;

            case "getGroupListButtonid":
                AddGroupFrame addGroupFrame = new AddGroupFrame(td, sd, gd);
                addGroupFrame.setVisible(true);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Please select table", "Add", HEIGHT);
        }

    }//GEN-LAST:event_addİdActionPerformed

    private void getTeacherListButtonİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTeacherListButtonİdActionPerformed
        try {
            clickedButtonId = "getTeacherListButtonId";
            List<Teacher> listTeacher = td.getTeacherList();
            showTeacherList(listTeacher);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_getTeacherListButtonİdActionPerformed

    private void updateİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateİdActionPerformed
        int selectedRow = jtableId.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Please select someone", "Update", HEIGHT);
        }

        int selectedId = (int) jtableId.getValueAt(selectedRow, 0);

        switch (clickedButtonId) {
            case "getTeacherListButtonId":
                UpdateTeacherFrame updateTeacherFrame = new UpdateTeacherFrame(td, selectedId);
                updateTeacherFrame.setVisible(true);
                break;

            case "getStudentListButtonId":
                UpdateStudentFrame updateStudentFrame = new UpdateStudentFrame(sd, selectedId);
                updateStudentFrame.setVisible(true);
                break;

            case "getGroupListButtonid":
                UpdateGroupFrame updateGroupFrame = new UpdateGroupFrame(gd, td, sd, selectedId);
                updateGroupFrame.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please select table", "Update", HEIGHT);

        }


    }//GEN-LAST:event_updateİdActionPerformed

    private void deleteİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteİdActionPerformed
        int selectedRow = jtableId.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Please select someone", "Error", HEIGHT);
        }
        int selectedId = (int) jtableId.getValueAt(selectedRow, 0);

        switch (clickedButtonId) {
            case "getTeacherListButtonId":
                deleteTeacher(selectedId);
                break;
            case "getStudentListButtonId":
                deleteStudent(selectedId);
                break;
            case "getGroupListButtonid":
                deleteGroup(selectedId);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please select table", "Update", HEIGHT);

        }

    }//GEN-LAST:event_deleteİdActionPerformed

    private void jtableIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableIdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtableIdMouseClicked

    private void keywordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordTxtActionPerformed

    }//GEN-LAST:event_keywordTxtActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            String keyword = keywordTxt.getText();
            switch (clickedButtonId) {
                case "getTeacherListButtonId":
                    List<Teacher> listTeacher = td.searchTeacher(keyword);
                    showTeacherList(listTeacher);
                    break;
                case "getStudentListButtonId":
                    List<Student> listStudent = sd.searchStudent(keyword);
                    showStudentlist(listStudent);
                    break;
                case "getGroupListButtonid":
                    List<Group> listGroup = gd.searchGroup(keyword);
                    showGroupList(listGroup);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void keywordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordTxtKeyReleased
        searchBtnActionPerformed(null);
    }//GEN-LAST:event_keywordTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addİd;
    private java.awt.Button button1;
    private javax.swing.JButton deleteİd;
    private javax.swing.JButton getGroupListButtonİd;
    private javax.swing.JButton getStudentListButtonİd;
    private javax.swing.JButton getTeacherListButtonİd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableId;
    private javax.swing.JTextField keywordTxt;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton updateİd;
    // End of variables declaration//GEN-END:variables

    private void showGroupList(List<Group> listGroup) {
        try {

            DefaultTableModel model = new DefaultTableModel();
            jtableId.setModel(model);
            model.addColumn("id");
            model.addColumn("No");
            model.addColumn("group_name");
            model.addColumn("student_name");
            model.addColumn("student_surname");
            model.addColumn("teacher_name");
            model.addColumn("tecaher_surname");
            model.addColumn("active");
            for (Group group : listGroup) {
                Object[] data = new Object[]{
                    group.getId(), group.getR(), group.getName(), group.getStudent().getName(), group.getStudent().getSurname(), group.getTeacher().getName(), group.getTeacher().getSurname(),
                    group.getActive()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    isCellEditable(i, j);
                }
            }*/
            jtableId.getColumnModel().getColumn(0).setMinWidth(0);
            jtableId.getColumnModel().getColumn(0).setMaxWidth(0);
            jtableId.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void showTeacherList(List<Teacher> listTeacher) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtableId.setModel(model);
            model.addColumn("id");
            model.addColumn("No");
            model.addColumn("name");
            model.addColumn("surname");
            model.addColumn("active");
            for (Teacher teacher : listTeacher) {
                Object[] data = new Object[]{
                    teacher.getId(), teacher.getR(), teacher.getName(), teacher.getSurname(), teacher.getActive()
                };

                model.addRow(data);

            }
            /*for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    isCellEditable(i, j);
                }
            }*/
            jtableId.getColumnModel().getColumn(0).setMinWidth(0);
            jtableId.getColumnModel().getColumn(0).setMaxWidth(0);
            jtableId.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }
//{public boolean isCellEditable(int row, int column){return false}}

    private void showStudentlist(List<Student> listStudent) {
        try {

            DefaultTableModel model = new DefaultTableModel();
            jtableId.setModel(model);
            model.addColumn("id");
            model.addColumn("No");
            model.addColumn("name");
            model.addColumn("surname");
            model.addColumn("active");
            for (Student student : listStudent) {
                Object[] data = new Object[]{
                    student.getId(), student.getR(), student.getName(), student.getSurname(), student.getActive()
                };

                model.addRow(data);
            }
            /* for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    isCellEditable(i, j);
                }
            }*/
            jtableId.getColumnModel().getColumn(0).setMinWidth(0);
            jtableId.getColumnModel().getColumn(0).setMaxWidth(0);
            jtableId.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void deleteTeacher(int selectedId) {
        try {
            Teacher teacher = td.getTeacherById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, " Are you sure to delete " + teacher.getName() + " " + teacher.getSurname(), "Delete Teacher", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = td.deleteTeacher(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Teacher has been deleted", "Delete Teacher", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Teacher", HEIGHT);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteStudent(int selectedId) {
        try {
            Student student = sd.getStudentById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + student.getName() + " " + student.getSurname(), "Delete Student", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = sd.deleteStudent(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Student has been deleted", "Delete Student", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Delete Student", HEIGHT);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteGroup(int selectedId) {

        try {
            Group group = gd.getGroupById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + group.getName(), "Delete Group", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = gd.deleteGroup(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Group has been deleted", "Delete Group", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Group", HEIGHT);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
