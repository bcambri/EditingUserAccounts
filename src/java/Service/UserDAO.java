/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.newUser;
import Model.User;
import java.util.List;

/**
 *
 * @author syntel
 */
public interface UserDAO {

    public void insertRecord(newUser usr);

    public int findRecord(String usrId);

    public long getTotalNoOfCustomers();

    public List getAllCustomers();

    public User getCustomerByName(String first, String last);

    public void findValidUser(String usrId, String pwd);
    
    public void banOrEnableCustomer(int id);
    
    public void deleteCustomer(int id);
}
