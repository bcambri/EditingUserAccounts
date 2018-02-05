/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.UserDAO;
import Model.newUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author syntel
 */
public class EditCustomersController extends SimpleFormController {

    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public EditCustomersController() {
        setCommandClass(newUser.class);
        setCommandName("editCustomers");
    }

    public void handleChanges(int chngId, int dltId){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("customerContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
        if(chngId > 0)
            userDAO.banOrEnableCustomer(chngId);
        if(dltId > 0)
            userDAO.deleteCustomer(dltId);
    }
    
    @RequestMapping(value = "editCustomers", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {
        List<newUser> listOfCustomers = userDAO.getAllCustomers();
        return new ModelAndView("editCustomers", "listOfCustomers", listOfCustomers);
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {        
        SignupController editCustomers = (SignupController)command;
        return new ModelAndView("newUserSuccess", "editCustomers", editCustomers);
    }
}
