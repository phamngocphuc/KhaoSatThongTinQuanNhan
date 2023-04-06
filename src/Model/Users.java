/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Users {
    private String userCode;
    private String fullName;
    private String userName;
    private String password;
    private LocalDate birth;
    private String rank;
    private String avatar;
    private String address;
    private String phone;
    private String email;
    private Units unitId;
    private Exams examId;

    public Users() {
    }

    public Users(String userCode, String fullName, String userName, String password, LocalDate birth, String rank, String avatar, String address, String phone, String email, Units unitId, Exams examId) {
        this.userCode = userCode;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.birth = birth;
        this.rank = rank;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.unitId = unitId;
        this.examId = examId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Units getUnitId() {
        return unitId;
    }

    public void setUnitId(Units unitId) {
        this.unitId = unitId;
    }

    public Exams getExamId() {
        return examId;
    }

    public void setExamId(Exams examId) {
        this.examId = examId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
