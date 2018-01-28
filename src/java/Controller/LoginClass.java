/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import domain.User;
import domain.UserDAO;
import domain.UserDAOImpl;
import java.util.NoSuchElementException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author LS5002117
 */
public class LoginClass extends SimpleFormController {

   /*(private UserDAOImpl customerDAO;
    
    public void setCustomerDAO(UserDAOImpl customerDAO) {
        this.customerDAO = customerDAO;
    }*/
    
    public LoginClass() {
        setCommandClass(User.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("customerContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
        User user = (User) command;
        // userManager.add(user);
        try {
            userDAO.findValidUser(user.getUsername(), user.getPassword());
            return new ModelAndView("userSuccess", "user", user);
        } catch (NoSuchElementException e) {
            return new ModelAndView("userFailure", "user", user);
        }
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     * @Override protected ModelAndView onSubmit( HttpServletRequest request,
     * HttpServletResponse response, Object command, BindException errors)
     * throws Exception { ModelAndView mv = new ModelAndView(getSuccessView());
     * //Do something... return mv; }
     */
}
