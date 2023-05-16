/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.TraLoi;
import Model.BaiKhaoSat;
import Model.CapBac;
import Model.CauHoi;
import Model.ThongKe;
import Model.DonVi;
import Model.PhanHoi;
import Model.QuanNhan;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class QuanNhanDAO {
    
    public List<DonVi> selectDonVi(){
        List<DonVi> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try{
            String select = "SELECT * FROM DonVi";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                DonVi units = new DonVi(rs.getInt("MaDonVi"), rs.getString("TenDonVi"));
                list.add(units);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public boolean them(QuanNhan quanNhan){
        boolean check = false;
        int idQN = -1;
        Connection conn = null;
        PreparedStatement pps = null;
        try{
            String insert = "INSERT INTO QuanNhan VALUES (?,?,?,?,?,?,?,?,?,?)";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(insert);
            pps  = conn.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            pps.setString(1,quanNhan.getTenTaiKhoan());
            pps.setString(2,quanNhan.getMatKhau());
            pps.setString(3,quanNhan.getEmail());
            pps.setString(4,quanNhan.getCmnd());   
            pps.setString(5,quanNhan.getHoTen());   
            pps.setDate(6,Date.valueOf(quanNhan.getNgaySinh()));   
            pps.setInt(7, quanNhan.getCapBac().getId());
            pps.setInt(8, quanNhan.getDonVi().getMaDonVi());
            pps.setInt(9, 1);
            pps.setString(10,quanNhan.getTrangThai());
            if(!pps.execute()){
                ResultSet rs = pps.getGeneratedKeys();
                while(rs.next()){
                    idQN = rs.getInt(1);
                    String select = "SELECT * FROM BaiKhaoSat WHERE DoiTuong =  ?";
                    pps = conn.prepareStatement(select);
                    pps.setString(1, quanNhan.getCapBac().getTenCapBac());
                    ResultSet rss = pps.executeQuery();
                    while(rss.next()){
                        String insertQN_BKS = "INSERT INTO QN_BKS VALUES (?,?)";
                        pps = conn.prepareStatement(insertQN_BKS);
                        pps.setInt(1, idQN);
                        pps.setInt(2, rss.getInt("ID"));
                        pps.execute();
                    }
                    check = true;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return check;
    }
    
    public int selectIdExam(String rank,int id){
        Connection conn = null;
        PreparedStatement pps = null;
        int idExam = -1;
        try{
            String select = "SELECT TOP(1) * from Exams E JOIN Exam_categories E_C ON E.Catogory_id = E_C.CategoryId WHERE E_C.Category_name = ? AND Status = N'Mở đề' ORDER BY NEWID()";
            conn = DBUtils.getConnection();
            pps = conn.prepareStatement(select);
            pps.setString(1,rank);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                idExam = rs.getInt(1);
            }
            String update = "UPDATE Users SET Exam_code = ? WHERE UserId = ?";
            pps = conn.prepareStatement(update);
            if(idExam == -1){
                pps.setString(1, null);
            }else{
                pps.setInt(1, idExam);
            }
            pps.setInt(2, id);
            pps.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
           
        }
        return id;
    }
    /*
    public List<QuanNhan> ConfirmQuanNhan(){
        List<QuanNhan> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try{
            String select = "SELECT * FROM QuanNhan";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                if(rs.getString("Email").equals("admin")){
                    QuanNhan quanNhan = new QuanNhan();
                    quanNhan.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                    quanNhan.setMatKhau(rs.getString("MatKhau"));
                    list.add(quanNhan);
                }
                else{
                    
                    CapBac capBac = new CapBac();
                    capBac.setId(rs.getInt("IdCapBac"));
                    
                    DonVi donVi = new DonVi();
                    donVi.setMaDonVi(rs.getInt("IdDonVi"));
                    
                    QuanNhan quanNhan = new QuanNhan(rs.getInt("ID"),rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), 
                        rs.getString("Email"), rs.getString("Cmnd"),rs.getString("HoTen"),
                        LocalDate.parse(rs.getString("NgaySinh")),capBac,donVi,1,null);
                    
                    list.add(quanNhan);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
*/
    
    public QuanNhan dangNhap(String tentk, String matkhau){
        Connection conn = null;
        PreparedStatement pps = null;
        try{
            String select = "SELECT * FROM QuanNhan JOIN DonVi ON QuanNhan.IdDonVi = DonVi.MaDonVi "
                          + "LEFT JOIN CapBac ON QuanNhan.IdCapBac = CapBac.MaCapBac "
                          + "WHERE TenTaiKhoan = ? AND MatKhau = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setString(1, tentk);
            pps.setString(2, matkhau);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                DonVi donVi = new DonVi(rs.getInt("MaDonVi"), rs.getString("TenDonVi"));
                CapBac capBac = new CapBac(rs.getInt("MaCapBac"), rs.getString("TenCapBac"));
                
                QuanNhan quanNhan = new QuanNhan(rs.getInt("ID"),rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), 
                        rs.getString("Email"), rs.getString("Cmnd"),rs.getString("HoTen"),
                        LocalDate.parse(rs.getString("NgaySinh")),capBac,donVi,rs.getInt("IdVaiTro"),rs.getString("TrangThai"));
                        
                return quanNhan;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return null;
    }
    
    public List<QuanNhan> selectQuanNhan(){
        List<QuanNhan> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try{
            String select = "SELECT * FROM QuanNhan JOIN DonVi ON QuanNhan.IdDonVi = DonVi.MaDonVi LEFT JOIN CapBac ON QuanNhan.IdCapBac = CapBac.MaCapBac WHERE IdVaiTro = 1";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                DonVi donVi = new DonVi(rs.getInt("MaDonVi"), rs.getString("TenDonVi"));
                CapBac capBac = new CapBac(rs.getInt("MaCapBac"), rs.getString("TenCapBac"));
                
                QuanNhan quanNhan = new QuanNhan(rs.getInt("ID"),rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), 
                        rs.getString("Email"), rs.getString("Cmnd"),rs.getString("HoTen"),
                        LocalDate.parse(rs.getString("NgaySinh")),capBac,donVi,rs.getInt("IdVaiTro"),rs.getString("TrangThai"));
                        
                list.add(quanNhan);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public boolean deleteQuanNhan(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String delete = "DELETE FROM QuanNhan WHERE ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(delete);
            pps.setInt(1, id);
            return pps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public boolean updateQuanNhan(QuanNhan quanNhan){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String update = "UPDATE QuanNhan SET TenTaiKhoan = ?, MatKhau = ?, Email = ?, Cmnd = ?, HoTen = ?, NgaySinh = ?"
                          + ", IdCapBac = ?, IdDonVi = ? WHERE ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(update);
            pps.setString(1, quanNhan.getTenTaiKhoan());
            pps.setString(2, quanNhan.getMatKhau());
            pps.setString(3, quanNhan.getEmail());
            pps.setString(4, quanNhan.getCmnd());
            pps.setString(5, quanNhan.getHoTen());
            pps.setDate(6, Date.valueOf(quanNhan.getNgaySinh()));
            pps.setInt(7, quanNhan.getCapBac().getId());
            pps.setInt(8, quanNhan.getDonVi().getMaDonVi());
            pps.setInt(9, quanNhan.getId());
            return pps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public boolean capNhatMatKhau(QuanNhan quanNhan){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String update = "UPDATE QuanNhan SET MatKhau = ? WHERE Email = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(update);
            pps.setString(1, quanNhan.getMatKhau());
            pps.setString(2, quanNhan.getEmail());
            return pps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public QuanNhan selectQuanNhanById(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        QuanNhan quanNhan =new QuanNhan();
        try{
            String select = "SELECT * FROM QuanNhan JOIN DonVi ON QuanNhan.IdDonVi = DonVi.MaDonVi LEFT JOIN CapBac ON QuanNhan.IdCapBac = CapBac.MaCapBac WHERE QuanNhan.ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            
            while(rs.next()){
                quanNhan.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                quanNhan.setMatKhau(rs.getString("TenTaiKhoan"));
                quanNhan.setEmail(rs.getString("Email"));
                quanNhan.setCmnd(rs.getString("Cmnd"));
                quanNhan.setHoTen(rs.getString("HoTen"));
                
                quanNhan.setNgaySinh(LocalDate.parse(rs.getString("NgaySinh")));
                CapBac capBac = new CapBac(rs.getInt("MaCapBac"),rs.getString("TenCapBac"));
                DonVi donVi = new DonVi(rs.getInt("MaDonVi"),rs.getString("TenDonVi"));
                
                quanNhan.setCapBac(capBac);
                quanNhan.setDonVi(donVi);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        
        return quanNhan;
    }
    
    public String[] selectInfoUserExam(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        String[] strings = new String[50];
        try{
            String select = "SELECT * FROM Users U JOIN Exams E ON U.Exam_code = E.Exam_Id JOIN Units ON Units.UnitId = U.Unit_id WHERE UserId = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                strings[0] = rs.getString("Fullname");
                System.out.println(strings[0]);
                strings[1] = rs.getString("Date_of_birth");
                System.out.println(strings[1]);
                strings[2] = rs.getString("Unit_name");
                strings[3] = rs.getString("Exam_id");
                strings[4] = rs.getString("Exam_name");
                strings[5] = rs.getString("Army_ranks");
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return strings;
    }
    
    public int selectNumberQuestion(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        int soCau = 0;
        try{
            String select = "SELECT E_Q.Exam_code ,COUNT(E_Q.Exam_code) 'SoCau' FROM Questions Q JOIN Exams_questions E_Q ON Q.Question_id = E_Q.Question_Id WHERE E_Q.Exam_code = ? GROUP BY E_Q.Exam_code";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                soCau = rs.getInt(2);
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return soCau;
    }
    
    public boolean insertTraLoi(List<TraLoi> list){
        boolean check = false;
        Connection conn  = null;
        PreparedStatement pps = null;
        try {
            String insert = "INSERT INTO TraLoi VALUES (?,?,?)";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(insert);
            for (TraLoi traLoi : list) {
                pps.setString(1, traLoi.getNoiDung());
                pps.setInt(2, traLoi.getQuanNhan().getId());
                pps.setInt(3, traLoi.getCauHoi().getId());
                pps.addBatch();
            }
            int[] kq = pps.executeBatch();
            if(kq.length > 0){
                check = true;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return check;
    }
    
    public boolean insertStatistic(ThongKe statistic){
        boolean check = false;
        Connection conn  = null;
        PreparedStatement pps = null;
        try {
            String insert = "INSERT INTO Statistic VALUES (?,?,?,?,?,?)";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(insert);
            pps.setInt(1, statistic.getUserId().getId());
            pps.setInt(2, statistic.getNumTaken());
            pps.setInt(3, statistic.getNumWrong());
            pps.setTime(4, Time.valueOf( statistic.getTimeTaken()));
            pps.setString(5,statistic.getScore());
            pps.setString(6,statistic.getResult());
            
            if(pps.executeUpdate() > 0){
                check = true;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return check;
    }
    
    public String[] selectInfoResultById(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        String[] strings = new String[100];
        try{
            String select = "SELECT *\n" +
                            "FROM Users\n" +
                            "JOIN Exams ON Users.Exam_code = Exams.Exam_Id\n" +
                            "JOIN Exam_categories ON Exams.Catogory_id = Exam_categories.CategoryId\n" +
                            "JOIN Exams_questions ON Exams_questions.Exam_code = Exams.Exam_Id\n" +
                            "JOIN Questions ON Questions.Question_id = Exams_questions.Question_Id\n" +
                            "LEFT JOIN Choices ON Choices.UserId = Users.UserId AND Choices.Question_id = Questions.Question_id\n" +
                            "LEFT JOIN Statistic ON Statistic.User_id = Users.UserId\n" +
                            "WHERE Users.UserId = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                strings[0] = rs.getString("Fullname");
                strings[1] = rs.getString("Date_of_birth");
                strings[2] = rs.getString("Exam_Id");
                strings[3] = rs.getString("Exam_name");
                strings[4] = rs.getString("Category_name");
                strings[5] = rs.getString("Num_taken");
                strings[6] = rs.getString("Num__wrong");
                strings[7] = rs.getString("Time_taken");
                strings[8] = rs.getString("Score");
                strings[9] = rs.getString("Result");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return strings;
    }
    
    public boolean selectStatisticById(int id ){
        boolean check = false;
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "SELECT * FROM Statistic WHERE Statistic.User_id = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return check;
    }
    
    public boolean insertPhanHoi(PhanHoi phanHoi){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "INSERT INTO PhanHoi VALUES (?,?,?,?)";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setString(1, phanHoi.getNoiDung());
            pps.setInt(2, phanHoi.getBKS_Id());
            pps.setInt(3, phanHoi.getQN_Id());
            
            String dateTimeStr = phanHoi.getThoiGian().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pps.setString(4, dateTimeStr);
            return pps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public boolean khoaTaiKhoan(int id, String trangthai, String lydo){
        Connection conn = null;
        PreparedStatement pps = null;
        
        try{
            String update = "UPDATE QuanNhan SET TrangThai = ?, LyDo = ? WHERE ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(update);
            pps.setString(1, trangthai);
            pps.setString(2, lydo);
            pps.setInt(3,id);
            return pps.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public List<CauHoi> chiTietKhaoSat(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        
        List<CauHoi> list = new ArrayList<>();
        
        try{
            String select = "SELECT * FROM BaiKhaoSat BKS JOIN KhaoSat_CauHoi KS_CH ON BKS.ID = KS_CH.MaBaiKhaoSat JOIN CauHoi CH ON CH.ID = KS_CH.MaCauHoi JOIN TraLoi TL ON TL.IdCauHoi = CH.ID JOIN QN_BKS ON BKS.ID = QN_BKS.MaBKS JOIN QuanNhan QN ON QN.ID = QN_BKS.MaQN WHERE QN.ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                CauHoi cauHoi = new CauHoi( rs.getString("TieuDe"),rs.getString("NoiDung"), rs.getString("LuaChon1")
                                         , rs.getString("LuaChon2"), rs.getString("LuaChon3"), rs.getString("LuaChon4"), rs.getString("HinhThucTraLoi"), rs.getString("NoiDungTraLoi"));
                list.add(cauHoi);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    
}

