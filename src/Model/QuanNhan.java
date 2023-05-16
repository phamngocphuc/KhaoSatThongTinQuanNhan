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
public class QuanNhan {
    private int id;
    private String tenTaiKhoan;
    private String matKhau;
    private String email;
    private String cmnd;
    private String hoTen;
    private LocalDate ngaySinh;
    private CapBac capBac;
    private DonVi donVi;
    private int vaiTro;
    private String trangThai;

    public QuanNhan() {
    }

    public QuanNhan(String email, String matKhau) {
        this.email = email;
        this.matKhau = matKhau;
    }

    
    public QuanNhan(String tenTaiKhoan, String matKhau, String email, String cmnd, String hoTen, LocalDate ngaySinh, CapBac capBac, DonVi donVi, int vaiTro, String trangThai) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.capBac = capBac;
        this.donVi = donVi;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public QuanNhan(int id, String tenTaiKhoan, String matKhau, String email, String cmnd, String hoTen, LocalDate ngaySinh, CapBac capBac, DonVi donVi, int vaiTro, String trangThai) {
        this.id = id;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.capBac = capBac;
        this.donVi = donVi;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public CapBac getCapBac() {
        return capBac;
    }

    public void setCapBac(CapBac capBac) {
        this.capBac = capBac;
    }

    public DonVi getDonVi() {
        return donVi;
    }

    public void setDonVi(DonVi donVi) {
        this.donVi = donVi;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setHinhAnh(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
