/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public class PhanHoi {
    private int id;
    private String noiDung;
    private int BKS_Id;
    private int QN_Id;
    private String tieude;
    private String hoten;
    private String cmnd;
    LocalDateTime thoiGian;

    public PhanHoi() {
    }

    public PhanHoi(String noiDung, int BKS_Id, int QN_Id, LocalDateTime thoiGian) {
        this.noiDung = noiDung;
        this.BKS_Id = BKS_Id;
        this.QN_Id = QN_Id;
        this.thoiGian = thoiGian;
    }

    public PhanHoi(String noiDung, int BKS_Id, int QN_Id, String tieude, String hoten, String cmnd, LocalDateTime thoiGian) {
        this.noiDung = noiDung;
        this.BKS_Id = BKS_Id;
        this.QN_Id = QN_Id;
        this.tieude = tieude;
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.thoiGian = thoiGian;
    }

    
    public PhanHoi(int id, String noiDung, int BKS_Id, int QN_Id, String tieude, String hoten, String cmnd, LocalDateTime thoiGian) {
        this.id = id;
        this.noiDung = noiDung;
        this.BKS_Id = BKS_Id;
        this.QN_Id = QN_Id;
        this.tieude = tieude;
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.thoiGian = thoiGian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getBKS_Id() {
        return BKS_Id;
    }

    public void setBKS_Id(int BKS_Id) {
        this.BKS_Id = BKS_Id;
    }

    public int getQN_Id() {
        return QN_Id;
    }

    public void setQN_Id(int QN_Id) {
        this.QN_Id = QN_Id;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
}
