/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Validation {
    
    public static  boolean isEmpty(String str){
        return str.length() == 0;
    }
    
    public static boolean validDate(Date dateStart, Date dateEnd){
        return dateStart.after(dateEnd);
    }
}


