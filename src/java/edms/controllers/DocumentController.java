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
        
        String action = request.getParameter("action");

        switch (action == null ? "default" : action) {
            case "new":
                
                request.setAttribute("users", User.getAllUsers());
                request.getRequestDispatcher("/WEB-INF/layouts/document/new_document.jsp").forward(request, response);
                break;
            case "edit":
                
                String document_id = request.getParameter("document_id");
                Document document = new Document(Integer.parseInt(document_id));
                request.setAttribute("users", User.getAllUsers());
                request.setAttribute("document", document);
                request.setAttribute("user", document.getUser());
                request.getRequestDispatcher("/WEB-INF/layouts/document/edit_document.jsp").forward(request, response);
                break;
            case "default":
            default:
                System.out.println(user.getName());
                request.setAttribute("documents", user.getDocuments());
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
        
        String title, content, userId, documentId;
        Document doc;
        
        String action = request.getParameter("action");

        switch (action == null ? "default" : action) {
            case "new":
                title = request.getParameter("title");
                content = request.getParameter("content");
                userId = request.getParameter("user_id");
        
                doc = new Document(0, title, content, Integer.parseInt(userId), "", "");
                
                if (doc.create()) {
                    request.setAttribute("message", "Документ создан");
                } else {
                    request.setAttribute("message", "Документ не создан");
                }
                
                response.sendRedirect(request.getContextPath() + "/document");
                break;
            case "update":
                documentId = request.getParameter("document_id");
                title = request.getParameter("title");
                content = request.getParameter("content");
                userId = request.getParameter("user_id");
        
                doc = new Document(Integer.parseInt(documentId));
                doc.setTitle(title);
                doc.setContent(content);
                doc.setUserId(userId);
                
                if (doc.update()) {
                    request.setAttribute("message", "Документ создан");
                } else {
                    request.setAttribute("message", "Документ не создан");
                }
                response.sendRedirect(request.getContextPath() + "/document");
                break;
            case "default":
            default:
                response.sendRedirect(request.getContextPath() + "/document");
                break;
        }
        
        
    }
}
