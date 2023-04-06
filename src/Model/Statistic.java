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
public class Statistic {
    private float score;
    private LocalTime timeTaken;
    private int numTaken;
    private int numWrong;
    private Users userId;

    public Statistic() {
    }

    public Statistic(float score, LocalTime timeTaken, int numTaken, int numWrong, Users userId) {
        this.score = score;
        this.timeTaken = timeTaken;
        this.numTaken = numTaken;
        this.numWrong = numWrong;
        this.userId = userId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }
}
