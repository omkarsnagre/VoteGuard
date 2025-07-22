package com.voteguard.model;

public class Aadhar {
    private String aadharNumber;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String state;
    private String pincode;
    private String phoneNumber;
    private String email;
    private String rightThumb;
    private String leftThumb;

    // Getters and Setters

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        System.out.println("Setting Aadhar Number: " + aadharNumber);
        this.aadharNumber = aadharNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRightThumb() {
        return rightThumb;
    }

    public void setRightThumb(String rightThumb) {
        this.rightThumb = rightThumb;
    }

    public String getLeftThumb() {
        return leftThumb;
    }

    public void setLeftThumb(String leftThumb) {
        this.leftThumb = leftThumb;
    }
}
