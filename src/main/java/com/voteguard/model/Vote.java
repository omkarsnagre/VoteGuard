package com.voteguard.model;

public class Vote {
    private int voteId;
    private String aadharNumber;
    private String candidate;

    public Vote() {}

    public Vote(String aadharNumber, String candidate) {
        this.aadharNumber = aadharNumber;
        this.candidate = candidate;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
}
