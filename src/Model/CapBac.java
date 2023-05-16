/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class CapBac {
    private int Id;
    private String tenCapBac;

    public CapBac() {
    }

    public CapBac(int Id, String tenCapBac) {
        this.Id = Id;
        this.tenCapBac = tenCapBac;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenCapBac() {
        return tenCapBac;
    }

    public void setTenCapBac(String tenCapBac) {
        this.tenCapBac = tenCapBac;
    }
}
