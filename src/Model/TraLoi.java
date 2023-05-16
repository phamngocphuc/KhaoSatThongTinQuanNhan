/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class TraLoi {
    private int id;
    private String noiDung;
    private QuanNhan quanNhan;
    private CauHoi cauHoi;

    public TraLoi() {
    }

    public TraLoi(String noiDung, QuanNhan quanNhan, CauHoi cauHoi) {
        this.noiDung = noiDung;
        this.quanNhan = quanNhan;
        this.cauHoi = cauHoi;
    }

    public TraLoi(int id, String noiDung, QuanNhan quanNhan, CauHoi cauHoi) {
        this.id = id;
        this.noiDung = noiDung;
        this.quanNhan = quanNhan;
        this.cauHoi = cauHoi;
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

    public QuanNhan getQuanNhan() {
        return quanNhan;
    }

    public void setQuanNhan(QuanNhan quanNhan) {
        this.quanNhan = quanNhan;
    }

    public CauHoi getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }
}
