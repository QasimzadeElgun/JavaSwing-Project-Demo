/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Group;

/**
 *
 * @author SCC
 */
public interface groupDao {

    public List<Group> getCourseGroup() throws Exception;

    boolean addGroup(Group group) throws Exception;

    public Group getGroupById(int id) throws Exception;

    boolean updateGroup(Group group) throws Exception;

    boolean deleteGroup(int id) throws Exception;
    
    public List<Group> searchGroup(String keyword) throws Exception;

}
