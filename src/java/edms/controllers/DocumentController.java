/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.controllers;

import edms.entity.Document;
import edms.helper.ControllerHelper;
import edms.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dzmitry
 */
public class DocumentController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

//        if (!ControllerHelper.userIsLogged(request, response)) {
//            return;
//        }
        
        String action = request.getParameter("action");

        switch (action == null ? "default" : action) {
            case "new":
                request.getRequestDispatcher("/WEB-INF/layouts/document/new_document.jsp").forward(request, response);
                break;
            case "default":
            default:
                request.getRequestDispatcher("/WEB-INF/layouts/document/index.jsp").forward(request, response);
                break;
        }

        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        String action = request.getParameter("action");

        switch (action == null ? "default" : action) {
            case "new":
                String title = request.getParameter("title");
                String content = request.getParameter("content");
                String userId = request.getParameter("user_id");
        
                Document doc = new Document(title, content, user.id);
                
                if (doc.create()) {
                    request.setAttribute("addSuccess", "Документ создан");
                } else {
                    request.setAttribute("addError", "Документ не создан");
                }
                
                this.doGet(request, response);
                break;
            case "default":
            default:
                response.sendRedirect(request.getContextPath() + "/document");
                break;
        }
        
        
    }
}
