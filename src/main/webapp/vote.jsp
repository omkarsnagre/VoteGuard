<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.voteguard.model.Voter, com.voteguard.model.Aadhar" %>
<%
    Voter voter = (Voter) session.getAttribute("voter");
    Aadhar aadhar = (Aadhar) session.getAttribute("aadhar");

    if (aadhar == null || voter == null) {
        response.sendRedirect("index.jsp?error=Session expired. Please login again.");
        return;
    }
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Cast Your Vote - VoteGuard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-success text-white text-center">
                <h3>Cast Your Vote</h3>
            </div>
            <div class="card-body">
                <h5 class="mb-4">Welcome, <%= aadhar.getFullName() %>!</h5>
                <p class="text-muted">Select your preferred candidate below:</p>

                <form action="vote" method="post">
                    <div class="form-check mb-2">
                        <input class="form-check-input" type="radio" name="candidate" id="candidate1"
                            value="Party A" required>
                        <label class="form-check-label" for="candidate1">
                            Party A
                        </label>
                    </div>
                    <div class="form-check mb-2">
                        <input class="form-check-input" type="radio" name="candidate" id="candidate2"
                            value="Party B">
                        <label class="form-check-label" for="candidate2">
                            Party B
                        </label>
                    </div>
                    <div class="form-check mb-2">
                        <input class="form-check-input" type="radio" name="candidate" id="candidate3"
                            value="Party C">
                        <label class="form-check-label" for="candidate3">
                            Party C
                        </label>
                    </div>

                    <% if (request.getParameter("error") != null) { %>
                        <div class="alert alert-danger mt-3">
                            <%= request.getParameter("error") %>
                        </div>
                    <% } %>

                    <div class="text-center mt-4">
                        <button type="submit" class="btn btn-primary">Submit Vote</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
