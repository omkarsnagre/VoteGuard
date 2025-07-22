package com.voteguard.servlet;

import com.voteguard.dao.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Map<String, Integer> results = DBUtil.getVoteResults();
            request.setAttribute("results", results);
            request.getRequestDispatcher("results.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching voting results.");
            request.getRequestDispatcher("results.jsp").forward(request, response);
        }
    }
}
