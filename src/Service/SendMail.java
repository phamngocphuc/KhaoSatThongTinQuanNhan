/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DELL
 */
public class SendMail {
    // Kiểm tra địa chỉ email hợp lệ
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                       "[a-zA-Z0-9_+&*-]+)*@" +
                       "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                       "A-Z]{2,7}$";
        return email.matches(regex);
    }

    // Tạo mã OTP ngẫu nhiên
    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }
    
    // Gửi email chứa mã OTP
    public static void sendEmail(String to, String subject, String message) {
        String from = "phuc0985531639@gmail.com";
        String password = "hefsricboesmaprq";

            // Cấu hình thuộc tính cho email
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo phiên làm việc để gửi email
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }
        });

        try {
            // Tạo một đối tượng MimeMessage
            MimeMessage mimeMessage = new MimeMessage(session);

            // Thiết lập địa chỉ người nhận
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Thiết lập tiêu đề và nội dung email
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            
            // Gửi email
            Transport.send(mimeMessage);
            System.out.println("Email sent successfully");
      
        } catch (MessagingException ex) {
            System.out.println("Failed to send email");
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String otp =  generateOTP();
        sendEmail("phuc01653090971@gmail.com", "OTP for registration", "Your OTP is: " + otp);        
    }
}
