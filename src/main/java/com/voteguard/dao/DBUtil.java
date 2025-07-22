package com.voteguard.dao;

import java.sql.*;
import java.util.*;

import com.voteguard.model.Aadhar;
import com.voteguard.model.Voter;
import com.voteguard.model.Vote;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/VoteGuardDB";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ✅ Get Aadhar details by AadharNumber
    public static Aadhar getAadharDetails(String aadharNumber) throws Exception {
        Aadhar aadhar = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM AadharCard WHERE AadharNumber = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aadharNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                aadhar = new Aadhar();
                aadhar.setAadharNumber(rs.getString("AadharNumber"));
                // Commented out because corresponding setters may be missing
                aadhar.setFullName(rs.getString("FullName"));
                aadhar.setDateOfBirth(rs.getString("DateOfBirth"));
                aadhar.setGender(rs.getString("Gender"));
                aadhar.setAddress(rs.getString("Address"));
                aadhar.setState(rs.getString("State"));
                aadhar.setPincode(rs.getString("Pincode"));
                // aadhar.setPhoneNumber(rs.getString("PhoneNumber"));
                aadhar.setEmail(rs.getString("Email"));
                aadhar.setRightThumb(rs.getString("RightThumb"));
                aadhar.setLeftThumb(rs.getString("LeftThumb"));
            }
        }
        System.out.println(aadhar.getRightThumb() + "got it");
        return aadhar;
    }

    // ✅ Check if Voter is valid using VoterCard
    public static boolean isVoterValid(String aadharNumber, String voterId) throws Exception {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM VoterCard WHERE AadharNumber = ? AND VoterID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aadharNumber);
            stmt.setString(2, voterId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    // ✅ Get Voter details by VoterID
    public static Voter getVoterDetails(String voterId) throws Exception {
        Voter voter = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT v.VoterID, v.AadharNumber, v.FullName, v.DateOfBirth, v.Gender, a.Address, a.State, a.Pincode "
                    +
                    "FROM VoterCard v JOIN AadharCard a ON v.AadharNumber = a.AadharNumber " +
                    "WHERE v.VoterID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, voterId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                voter = new Voter();
                voter.setVoterId(rs.getString("VoterID"));
                voter.setAadharNumber(rs.getString("AadharNumber"));
                // Commented out because corresponding setters may be missing
                // voter.setFullName(rs.getString("FullName"));
                // voter.setDateOfBirth(rs.getString("DateOfBirth"));
                // voter.setGender(rs.getString("Gender"));
                voter.setAddress(rs.getString("Address"));
                voter.setState(rs.getString("State"));
                voter.setPincode(rs.getString("Pincode"));
            }
        }
        return voter;
    }

    // ✅ Check if the voter has already voted
    public static boolean hasVoted(String aadharNumber) throws Exception {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM VoteLog WHERE AadharNumber = ? order by VoteID desc limit 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aadharNumber);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.next() + "has voted");
            return rs.next();
        }
    }

    // ✅ Record the vote
    public static boolean recordVote(String aadharNumber, String candidate) {
        System.out.println("Recording vote for Aadhar: " + aadharNumber + ", Candidate: " + candidate);
        boolean success = false;
        try (Connection conn = getConnection()) {
            String query = "INSERT INTO VoteLog (AadharNumber, Candidate) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, aadharNumber);
                stmt.setString(2, candidate);
                int rows = stmt.executeUpdate();
                success = (rows > 0);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println(success + "success");
        return success;
    }

    // ✅ Get vote results: Candidate -> Vote Count
    public static Map<String, Integer> getVoteResults() {
        Map<String, Integer> results = new LinkedHashMap<>();
        try (Connection conn = getConnection()) {
            String query = "SELECT Candidate, COUNT(*) AS VoteCount FROM VoteLog GROUP BY Candidate ORDER BY VoteCount DESC";
            try (PreparedStatement stmt = conn.prepareStatement(query);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    results.put(rs.getString("Candidate"), rs.getInt("VoteCount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}
