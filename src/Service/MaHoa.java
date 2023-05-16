/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author DELL
 */
public class MaHoa {
    
    
    public static String toSHA1(String str){
        
        String salt = "ajsiteroiyny;eiynpngdnjy;sf"; // Làm cho mật khẩu phức tạp hơn
        String result = null;
        
        str = str + salt;
        try{
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encodeBase64String(md.digest(dataBytes));
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(toSHA1("admin"));
    }
}
