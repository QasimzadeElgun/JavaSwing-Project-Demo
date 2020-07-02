/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.groupDao;
import dao.studentDao;
import dao.teacherDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Group;
import model.Item;
import model.Student;
import model.Teacher;

public class UpdateGroupFrame extends javax.swing.JFrame {

    Group group = new Group();
    int selectedId;
    groupDao gd = null;
    studentDao sd = null;
    teacherDao td = null;

    public UpdateGroupFrame() {
        initComponents();
    }

    UpdateGroupFrame(groupDao gd, teacherDao td, studentDao sd, int selectedId) {
        initComponents();
        this.gd = gd;
        this.sd = sd;
        this.td = td;
        this.selectedId = selectedId;
        studentCombo();
        teacherCombo();
        showGroupInfo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearId = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Idtxt = new javax.swing.JTextField();
        nametxt = new javax.swing.JTextField();
        activetxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        studentCombo = new javax.swing.JComboBox<>();
        saveId = new javax.swing.JButton();
        teacherCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clearId.setText("Clear");
        clearId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearIdActionPerformed(evt);
            }
        });

        jLabel1.setText("id");

        jLabel3.setText("name");

        jLabel6.setText("active");

        Idtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdtxtActionPerformed(evt);
            }
        });

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        jLabel2.setText("Student");

        jLabel4.setText("Teacher");

        jTextField5.setEditable(false);
        jTextField5.setText("           Add Group");

        studentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        saveId.setText("Save");
        saveId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveIdActionPerformed(evt);
            }
        });

        teacherCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(teacherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(activetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(studentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(teacherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(activetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearId)
                    .addComponent(saveId))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdtxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void saveIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveIdActionPerformed
        try {
            Item stdCombo = (Item) studentCombo.getSelectedItem();
            Item tchCombo = (Item) teacherCombo.getSelectedItem();
            Student student = new Student();
            Teacher teacher = new Teacher();
            student.setId(stdCombo.getId());
            teacher.setId(tchCombo.getId());
            group.setStudent(student);
            group.setTeacher(teacher);
            group.setId(Integer.valueOf(Idtxt.getText()));
            group.setName(nametxt.getText());
            group.setActive(Integer.valueOf(activetxt.getText()));
            boolean isUpdate = gd.updateGroup(group);
            if(isUpdate){
                JOptionPane.showMessageDialog(null, "Group has been updated","Update Group" , HEIGHT);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,  "Error!","Update Group", HEIGHT);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_saveIdActionPerformed

    private void clearIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIdActionPerformed
       Idtxt.setText("");
       nametxt.setText("");
       activetxt.setText("");
       studentCombo.setSelectedIndex(0);
       teacherCombo.setSelectedIndex(0);
    }//GEN-LAST:event_clearIdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Idtxt;
    private javax.swing.JTextField activetxt;
    private javax.swing.JButton clearId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField nametxt;
    private javax.swing.JButton saveId;
    private javax.swing.JComboBox<String> studentCombo;
    private javax.swing.JComboBox<String> teacherCombo;
    // End of variables declaration//GEN-END:variables

    private void showGroupInfo() {
        try {
            group = gd.getGroupById(selectedId);
            Idtxt.setText(String.valueOf(group.getId()));
            nametxt.setText(group.getName());
            activetxt.setText(String.valueOf(group.getActive()));
        } catch (Exception ex) {
            Logger.getLogger(UpdateGroupFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void teacherCombo() {
        try {
            group = gd.getGroupById(selectedId);
            DefaultComboBoxModel model = (DefaultComboBoxModel) teacherCombo.getModel();
            List<Teacher> listTeacher = td.getTeacherList();
            for (Teacher teacher : listTeacher) {
                model.addElement(new Item(teacher.getId(), teacher.getName() + " " + teacher.getSurname()));
            }
            model.setSelectedItem(new Item(group.getId(), group.getTeacher().getName() + " " + group.getTeacher().getSurname()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void studentCombo() {
        try {
            group = gd.getGroupById(selectedId);
            DefaultComboBoxModel model2 = (DefaultComboBoxModel) studentCombo.getModel();
            List<Student> listStudent = sd.getStudentList();
            for (Student student : listStudent) {
                model2.addElement(new Item(student.getId(), student.getName() + " " + student.getSurname()));
            }
            model2.setSelectedItem(new Item(group.getId(), group.getStudent().getName() + " " + group.getTeacher().getSurname()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
