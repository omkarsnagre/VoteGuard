<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.voteguard.model.Aadhar" %>
<%@ page import="com.voteguard.model.Voter" %>
<%
    Aadhar aadhar = (Aadhar) session.getAttribute("aadhar");
    Voter voter = (Voter) session.getAttribute("voter");

    if (aadhar == null || voter == null) {
        response.sendRedirect("index.jsp?error=Session expired. Please login again.");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thumb Verification - VoteGuard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-info text-white text-center">
            <h3>Thumb Verification</h3>
        </div>
        <div class="card-body">

            <h5 class="mb-3">Voter Details</h5>
            <ul class="list-group mb-4">
                <li class="list-group-item"><strong>Full Name:</strong> <%= aadhar.getFullName() %></li>
                <li class="list-group-item"><strong>Date of Birth:</strong> <%= aadhar.getDateOfBirth() %></li>
                <li class="list-group-item"><strong>Gender:</strong> <%= aadhar.getGender() %></li>
                <li class="list-group-item"><strong>Address:</strong> <%= voter.getAddress() %>, <%= voter.getState() %>, <%= voter.getPincode() %></li>
                <li class="list-group-item"><strong>Aadhar Number:</strong> <%= aadhar.getAadharNumber() %></li>
                <li class="list-group-item"><strong>Voter ID:</strong> <%= voter.getVoterId() %></li>
            </ul>
            <form action="thumb" method="post">
    <div class="mb-3">
        <label for="thumbCode" class="form-label">Enter Thumb Code</label>
        <input type="text" class="form-control" id="thumbCode" name="thumbCode" required>
    </div>
    <button type="submit" class="btn btn-primary">Verify</button>
</form>

<% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger mt-3"><%= request.getAttribute("error") %></div>
<% } %>
                
            </form>

        </div>
    </div>
</div>
</body>
</html>
