/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackages;

import dao.groupImpl;
import dao.studentImpl;
import dao.teacherImpl;
import gui.MainFrame;
import java.util.List;
import java.util.Scanner;
import model.Group;
import dao.groupDao;
import dao.teacherDao;
import dao.studentDao;

/**
 *
 * @author SCC
 */
public class mainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        groupDao gd = new groupImpl();
        studentDao sd = new studentImpl();
        teacherDao td = new teacherImpl();
        MainFrame mainFrame = new MainFrame(gd, sd, td);
        mainFrame.setVisible(true);
        

    }

}
