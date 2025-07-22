<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>VoteGuard - Voter Verification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white text-center">
            <h2>VoteGuard - Voter Verification</h2>
        </div>
        <div class="card-body">
            <form action="verify" method="post">
                <div class="mb-3">
                    <label for="aadharNumber" class="form-label">Aadhar Number</label>
                    <input type="text" class="form-control" id="aadharNumber" name="aadharNumber" maxlength="12" required>
                </div>
                <div class="mb-3">
                    <label for="voterId" class="form-label">Voter ID</label>
                    <input type="text" class="form-control" id="voterId" name="voterId" maxlength="20" required>
                </div>
                <% if (request.getParameter("error") != null) { %>
                    <div class="alert alert-danger">
                        <%= request.getParameter("error") %>
                    </div>
                <% } %>
                <div class="text-center">
                    <button type="submit" class="btn btn-success">Verify</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
