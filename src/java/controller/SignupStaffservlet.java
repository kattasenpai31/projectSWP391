/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SignupStaff;

/**
 *
 * @author Dell
 */
public class SignupStaffservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupStaffservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupStaffservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String staffName = request.getParameter("staffName");
        String staffEmail = request.getParameter("staffEmail");
        String staffID = request.getParameter("staffID");
        String department = request.getParameter("department");
        String password = request.getParameter("password");

        // Create an instance of SignupStaff to store the data
        SignupStaff newStaff = new SignupStaff(staffName, staffEmail, staffID, department, password);

        // Validate the password (just a simple check here)
        if (newStaff.validatePassword()) {
            // Password is valid, proceed with registration
            request.setAttribute("message", "Signup successful! Welcome, " + staffName + ".");
            request.setAttribute("staff", newStaff);

            // Forward the request to a success page (JSP or HTML)
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup-success.jsp");
            dispatcher.forward(request, response);
        } else {
            // Password is invalid, return an error message
            request.setAttribute("error", "Password is too weak. Please choose a stronger password.");
            
            // Forward the request back to the signup page (JSP or HTML)
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
            dispatcher.forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
