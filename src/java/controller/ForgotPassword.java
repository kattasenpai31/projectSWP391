package controller;

import dal.AccountDBContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import model.Account;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForgotPassword extends HttpServlet {
    
public class CORSFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        
        // Allow the React app to access this backend API
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Pass the request along the filter chain
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve parameters from request
        String email = request.getParameter("email");
        String otp = request.getParameter("otp");
        String newPassword = request.getParameter("newPassword");

        // Hardcoded OTP for demonstration purposes (in reality, generate and verify dynamically)
        String validOTP = "123456";

        // Prepare response
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (otp.equals(validOTP)) {
            // Access DB to find the account     by email
            AccountDBContext accountDB = new AccountDBContext();
            Account account = accountDB.getAccountByEmail(email);

            if (account != null) {
                // Update the password in the database
                boolean updated = accountDB.updatePassword(email, newPassword);
                if (updated) {
                    out.write("{\"status\":\"success\",\"message\":\"Password changed successfully.\"}");
                } else {
                    out.write("{\"status\":\"error\",\"message\":\"Failed to change password.\"}");
                }
            } else {
                out.write("{\"status\":\"error\",\"message\":\"Account not found.\"}");
            }
        } else {
            out.write("{\"status\":\"error\",\"message\":\"Invalid OTP.\"}");
        }

        out.flush();
    }
}
