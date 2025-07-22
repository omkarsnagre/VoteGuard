package com.voteguard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.voteguard.model.Aadhar;

public class ThumbVerificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String enteredThumb = request.getParameter("thumbCode");
        Aadhar aadhar = (Aadhar) session.getAttribute("aadhar");

        if (enteredThumb != null && (enteredThumb.equals(aadhar.getRightThumb())
                || enteredThumb.equals(aadhar.getLeftThumb()))) {
            // ✅ Thumb matched – mark as verified
            session.setAttribute("thumbVerified", true); // ✅ Add this line
            RequestDispatcher dispatcher = request.getRequestDispatcher("vote.jsp");
            dispatcher.forward(request, response);
        } else {
            // ❌ Thumb mismatch – show error and go back
            request.setAttribute("error", "Invalid thumb code. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("verifyThumb.jsp");
            dispatcher.forward(request, response);
        }
    }
}
