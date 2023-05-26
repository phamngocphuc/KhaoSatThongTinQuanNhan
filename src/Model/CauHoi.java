/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class CauHoi {
    private int id;
    private String tenBKS;
    private String noiDung;
    private String luaChon1;
    private String luaChon2;
    private String luaChon3;
    private String luaChon4;
    private String hinhThuc;
    private String traloi;
    
    
    private int soLuongLC1;
    private int soLuongLC2;
    private int soLuongLC3;
    private int soLuongLC4;
    
    public CauHoi() {
    }
    
    public CauHoi(String noiDung, String luaChon1, String luaChon2, String luaChon3, String luaChon4, String hinhThuc) {
        this.noiDung = noiDung;
        this.luaChon1 = luaChon1;
        this.luaChon2 = luaChon2;
        this.luaChon3 = luaChon3;
        this.luaChon4 = luaChon4;
        this.hinhThuc = hinhThuc;
    }
    
    public CauHoi(String tenBKS, String noiDung, String luaChon1, String luaChon2, String luaChon3, String luaChon4, String hinhThuc, String traloi) {
        this.noiDung = noiDung;
        this.luaChon1 = luaChon1;
        this.luaChon2 = luaChon2;
        this.luaChon3 = luaChon3;
        this.luaChon4 = luaChon4;
        this.hinhThuc = hinhThuc;
        this.traloi = traloi;
        this.tenBKS = tenBKS;
    }
    
    public CauHoi(String noiDung, String luaChon1, String luaChon2, String luaChon3, String luaChon4, String hinhThuc, String traloi) {
        this.noiDung = noiDung;
        this.luaChon1 = luaChon1;
        this.luaChon2 = luaChon2;
        this.luaChon3 = luaChon3;
        this.luaChon4 = luaChon4;
        this.hinhThuc = hinhThuc;
        this.traloi = traloi;
    }
    
    public CauHoi(int id, String noiDung, String luaChon1, String luaChon2, String luaChon3, String luaChon4, String hinhThuc) {
        this.id = id;
        this.noiDung = noiDung;
        this.luaChon1 = luaChon1;
        this.luaChon2 = luaChon2;
        this.luaChon3 = luaChon3;
        this.luaChon4 = luaChon4;
        this.hinhThuc = hinhThuc;
    }

    public CauHoi(int id, String noiDung, int soLuongLC1, int soLuongLC2, int soLuongLC3, int soLuongLC4) {
        this.id = id;
        this.noiDung = noiDung;
        this.soLuongLC1 = soLuongLC1;
        this.soLuongLC2 = soLuongLC2;
        this.soLuongLC3 = soLuongLC3;
        this.soLuongLC4 = soLuongLC4;
    }

    public String getTenBKS() {
        return tenBKS;
    }

    public void setTenBKS(String tenBKS) {
        this.tenBKS = tenBKS;
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

    public String getLuaChon1() {
        return luaChon1;
    }

    public void setLuaChon1(String luaChon1) {
        this.luaChon1 = luaChon1;
    }

    public String getLuaChon2() {
        return luaChon2;
    }

    public void setLuaChon2(String luaChon2) {
        this.luaChon2 = luaChon2;
    }

    public String getLuaChon3() {
        return luaChon3;
    }

    public void setLuaChon3(String luaChon3) {
        this.luaChon3 = luaChon3;
    }

    public String getLuaChon4() {
        return luaChon4;
    }

    public void setLuaChon4(String luaChon4) {
        this.luaChon4 = luaChon4;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public int getSoLuongLC1() {
        return soLuongLC1;
    }

    public void setSoLuongLC1(int soLuongLC1) {
        this.soLuongLC1 = soLuongLC1;
    }

    public int getSoLuongLC2() {
        return soLuongLC2;
    }

    public void setSoLuongLC2(int soLuongLC2) {
        this.soLuongLC2 = soLuongLC2;
    }

    public int getSoLuongLC3() {
        return soLuongLC3;
    }

    public void setSoLuongLC3(int soLuongLC3) {
        this.soLuongLC3 = soLuongLC3;
    }

    public int getSoLuongLC4() {
        return soLuongLC4;
    }

    public void setSoLuongLC4(int soLuongLC4) {
        this.soLuongLC4 = soLuongLC4;
    }
}
