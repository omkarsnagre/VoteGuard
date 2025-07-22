<%@ page import="com.voteguard.model.Voter" %>
<%@ page session="true" %>
<%
    Voter voter = (Voter) session.getAttribute("voter");
    if (voter == null) {
        response.sendRedirect("index.jsp?error=Session expired");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>VoteGuard - Voter Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3 class="mb-4">Voter Details</h3>
    <div class="card p-3">
        <p><strong>Voter ID:</strong> <%= voter.getVoterID() %></p>
        <p><strong>Aadhar Number:</strong> <%= voter.getAadharNumber() %></p>
        <p><strong>Full Name:</strong> <%= voter.getFullName() %></p>
        <p><strong>Date of Birth:</strong> <%= voter.getDateOfBirth() %></p>
        <p><strong>Gender:</strong> <%= voter.getGender() %></p>
        <p><strong>Address:</strong> <%= voter.getAddress() %></p>
        <p><strong>State:</strong> <%= voter.getState() %></p>
        <p><strong>Pincode:</strong> <%= voter.getPincode() %></p>

        <form action="verifyThumb.jsp" method="post">
            <button class="btn btn-success mt-3">Proceed to Thumb Verification</button>
        </form>
    </div>
</div>
</body>
</html>
