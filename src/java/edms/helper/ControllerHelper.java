/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.helper;

import edms.entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dzmitry
 */
public class ControllerHelper {
    
    public static boolean userIsLogged(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        
        return true;
    }
}
