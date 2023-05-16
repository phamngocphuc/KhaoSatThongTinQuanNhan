/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;

/**
 *
 * @author DELL
 */
public class ThongKe {
    private QuanNhan users;
    private BaiKhaoSat exams;
    private LocalTime timeTaken;
    private int numTaken;
    private int numWrong;
    private String score;
    private String result;
    

    public ThongKe() {
    }

    public ThongKe(QuanNhan users, LocalTime timeTaken, int numTaken, int numWrong, String score, String result) {
        this.users = users;
        this.timeTaken = timeTaken;
        this.numTaken = numTaken;
        this.numWrong = numWrong;
        this.score = score;
        this.result = result;
    }
    
    public ThongKe(QuanNhan users,BaiKhaoSat exams, int numTaken, int numWrong, String score, String result) {
        this.users = users;
        this.exams = exams;
        this.numTaken = numTaken;
        this.numWrong = numWrong;
        this.score = score;
        this.result = result;
    }

    public QuanNhan getUserId() {
        return users;
    }

    public void setUserId(QuanNhan userId) {
        this.users = userId;
    }

    public BaiKhaoSat getExams() {
        return exams;
    }

    public void setExams(BaiKhaoSat exams) {
        this.exams = exams;
    }

    public LocalTime getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(LocalTime timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getNumTaken() {
        return numTaken;
    }

    public void setNumTaken(int numTaken) {
        this.numTaken = numTaken;
    }

    public int getNumWrong() {
        return numWrong;
    }

    public void setNumWrong(int numWrong) {
        this.numWrong = numWrong;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
