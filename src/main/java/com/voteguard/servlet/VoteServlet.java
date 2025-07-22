package com.voteguard.servlet;

import com.voteguard.dao.DBUtil;
import com.voteguard.model.Aadhar;
import com.voteguard.model.Voter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("VoteServlet called");
        HttpSession session = request.getSession(false);

        // ✅ Validate session and thumb verification
        System.out.println(session + " session");
        System.out.println(session.getAttribute("voter") + " voter");
        System.out.println(session.getAttribute("aadhar") + " aadhar");
        System.out.println(session.getAttribute("thumbVerified") + " thumbVerified");
        System.out.println(session == null || session.getAttribute("voter") == null
                || session.getAttribute("aadhar") == null
                || session.getAttribute("thumbVerified") == null);
        if (session == null || session.getAttribute("voter") == null
                || session.getAttribute("aadhar") == null
                || (boolean) session.getAttribute("thumbVerified") == false) {
            response.sendRedirect("index.jsp?error=Session expired or not verified");
            return;
        }
        System.out.println("outside");
        Voter voterId = (Voter) session.getAttribute("voter");
        Aadhar aadharNumber = (Aadhar) session.getAttribute("aadhar");
        String candidate = request.getParameter("candidate");

        try {
            System.out.println("calling the method");
            // ✅ Check if already voted using VoterID
            if (DBUtil.hasVoted(aadharNumber.getAadharNumber())) {
                request.setAttribute("error", "You have already voted.");
                request.getRequestDispatcher("vote.jsp").forward(request, response);
                return;
            }

            // ✅ Record vote using AadharNumber as per your VoteLog schema
            boolean success = DBUtil.recordVote(aadharNumber.getAadharNumber(), candidate);
            System.out.println(success + "recorded vote");
            if (success) {
                session.invalidate(); // Invalidate session after successful vote
                Map<String, Integer> results = DBUtil.getVoteResults(); // Fetch results from DB
                request.setAttribute("results", results); // Set it to request
                request.setAttribute("message", "Your vote has been recorded successfully!");
                request.getRequestDispatcher("results.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Failed to record your vote.");
                request.getRequestDispatcher("vote.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Internal server error.");
            request.getRequestDispatcher("vote.jsp").forward(request, response);
        }
    }
}
