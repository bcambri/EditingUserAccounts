/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.UserDAO;
import Service.UserDAOImpl;
import Model.newUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author syntel
 */
public class SignupController extends SimpleFormController {

    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public SignupController() {
        setCommandClass(newUser.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        newUser user = (newUser) command;
        // userManager.add(user);
        if (userDAO.findRecord(user.getUsername()) > 0) {
            return new ModelAndView("newUserFailure", "user", user);
        } else {
            userDAO.insertRecord(user);
            return new ModelAndView("newUserSuccess", "user", user);
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
