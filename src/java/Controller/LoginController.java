/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Service.UserDAO;
import Service.UserDAOImpl;
import java.util.NoSuchElementException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author LS5002117
 */
@Controller
public class LoginController extends SimpleFormController {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public LoginController() {
        setCommandClass(User.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
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
