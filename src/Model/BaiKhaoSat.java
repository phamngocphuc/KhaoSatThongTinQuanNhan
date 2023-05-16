/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author DELL
 */
public class BaiKhaoSat {
    private int id;
    private String tieuDe;
    private String doiTuong;
    private LocalDate thoiGianBatDau;
    private LocalDate thoiGianKetThuc;
    private String trangThai;
    
    private int soLuongQN;
    private int soLuongCH;
    private int soLuongPH;

    public BaiKhaoSat() {
    }

    public BaiKhaoSat(String tieuDe, String doiTuong, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc, String trangThai) {
        this.tieuDe = tieuDe;
        this.doiTuong = doiTuong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.trangThai = trangThai;
    }

    public BaiKhaoSat(int id, String tieuDe, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc, int soLuongQN, int soLuongCH, int soLuongPH) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.soLuongQN = soLuongQN;
        this.soLuongCH = soLuongCH;
        this.soLuongPH = soLuongPH;
    }
    
    public BaiKhaoSat(int id, String tieuDe, String doiTuong, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc, String trangThai) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.doiTuong = doiTuong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public LocalDate getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDate getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuongQN() {
        return soLuongQN;
    }

    public void setSoLuongQN(int soLuongQN) {
        this.soLuongQN = soLuongQN;
    }

    public int getSoLuongCH() {
        return soLuongCH;
    }

    public void setSoLuongCH(int soLuongCH) {
        this.soLuongCH = soLuongCH;
    }

    public int getSoLuongPH() {
        return soLuongPH;
    }

    public void setSoLuongPH(int soLuongPH) {
        this.soLuongPH = soLuongPH;
    }
    
}
