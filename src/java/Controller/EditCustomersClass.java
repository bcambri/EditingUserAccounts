/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import domain.UserDAO;
import domain.UserDAOImpl;
import domain.newUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author syntel
 */
public class EditCustomersClass extends SimpleFormController {

    /*private UserDAOImpl customerDAO;
    
    public void setCustomerDAO(UserDAOImpl customerDAO){
        this.customerDAO = customerDAO;
    }*/
    
    public EditCustomersClass() {
        setCommandClass(newUser.class);
        setCommandName("editCustomers");
    }

    public void handleChanges(int chngId, int dltId){
        if(chngId > 0)
            banOrEnable(chngId);
        if(dltId > 0)
            delete(dltId);
    }
    
    private void banOrEnable(int id){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("customerContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
        userDAO.banOrEnableCustomer(id);
    }
    
    private void delete(int id){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("customerContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
        userDAO.deleteCustomer(id);
    }
    
    @RequestMapping(value = "web/editCustomers", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("customerContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
        List<newUser> listOfCustomers = userDAO.getAllCustomers();
        return new ModelAndView("editCustomers", "listOfCustomers", listOfCustomers);
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {        
        SignupClass editCustomers = (SignupClass)command;
        return new ModelAndView("newUserSuccess", "editCustomers", editCustomers);
    }
}
