<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%
    Map<String, Integer> results = (Map<String, Integer>) request.getAttribute("results");
    System.out.println(results+"results");
    if (results == null) {
        response.sendRedirect("index.jsp?error=No voting data available.");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voting Results - VoteGuard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h3>CONGRATS!! YOUR VOTE HAS BEEN RECORDED. </h3>
         <!--<h3>Voting Results</h3>-->   <!--COMMENTED OUT AS IT IS NOT NEEDED-->
        </div>
        <div class="card-body">
            <!--<table class="table table-bordered table-hover text-center">
                <thead class="table-dark">
                    <tr>
                        <th>Candidate</th>
                        <th>Votes</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Map.Entry<String, Integer> entry : results.entrySet()) { %>
                        <tr>
                            <td><%= entry.getKey() %></td>
                            <td><%= entry.getValue() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table> -->

            <div class="text-center mt-4">
                <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
