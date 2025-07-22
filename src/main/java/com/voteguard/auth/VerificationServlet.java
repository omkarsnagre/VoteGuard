package com.voteguard.auth;

import com.voteguard.model.*;
import com.voteguard.dao.DBUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class VerificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String aadharNumber = request.getParameter("aadharNumber");
        String voterId = request.getParameter("voterId");

        try {
            boolean isValid = DBUtil.isVoterValid(aadharNumber, voterId);

            if (isValid) {
                Aadhar aadhar = DBUtil.getAadharDetails(aadharNumber);
                Voter voter = DBUtil.getVoterDetails(voterId);

                request.getSession().setAttribute("aadhar", aadhar);
                request.getSession().setAttribute("voter", voter);

                response.sendRedirect("verifyThumb.jsp");
            } else {
                response.sendRedirect("index.jsp?error=Invalid Aadhar or Voter ID");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
