/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CapBac;
import Model.BaiKhaoSat;
import Model.CauHoi;
import Model.DonVi;
import Model.PhanHoi;
import Model.QuanNhan;
import Utils.DBUtils;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author DELL
 */
public class KhaoSatDAO {
    
    public List<CapBac> selectCapBac(){
        List<CapBac> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "SELECT * FROM CapBac";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                CapBac capBac = new CapBac(rs.getInt(1), rs.getString(2));
                list.add(capBac);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public boolean Them(BaiKhaoSat bks){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String insertExam  = "INSERT INTO BaiKhaoSat VALUES (?,?,?,?,?)";
            conn = DBUtils.getConnection();
            pps = conn.prepareStatement(insertExam, Statement.RETURN_GENERATED_KEYS);
            pps.setString(1, bks.getTieuDe());
            pps.setString(2, bks.getDoiTuong());
            pps.setDate(3, Date.valueOf(bks.getThoiGianBatDau()));
            pps.setDate(4, Date.valueOf(bks.getThoiGianKetThuc()));
            pps.setString(5,bks.getTrangThai());
            return pps.execute();
//            if(!pps.execute()){
//                ResultSet rs = pps.getGeneratedKeys();
//                while(rs.next()){
//                    int idBKS = rs.getInt(1);
//                    String select = "SELECT * FROM QuanNhan QN JOIN CapBac CB ON QN.IdCapBac = CB.MaCapBac WHERE TenCapBac = ? AND IdVaiTro = 1";
//                    pps = conn.prepareStatement(select);
//                    pps.setString(1, bks.getDoiTuong());
//                    ResultSet rss = pps.executeQuery();
//                    while(rss.next()){
//                        String insertQN_BKS = "INSERT INTO QN_BKS VALUES (?,?)";
//                        pps = conn.prepareStatement(insertQN_BKS);
//                        pps.setInt(1, rss.getInt("ID"));
//                        pps.setInt(2, idBKS);
//                        pps.execute();
//                    }
//                }
//                
//            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public List<BaiKhaoSat> selectBaiKhaoSat(){
        List<BaiKhaoSat> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String select = "SELECT * FROM BaiKhaoSat";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {    
                Date dateStart = rs.getDate("ThoiGianBatDau");
                Date dateEnd   = rs.getDate("ThoiGianKetThuc");
                String dS = dateFormat.format(dateStart);
                String dE = dateFormat.format(dateEnd);
                BaiKhaoSat baiKhaoSat = new BaiKhaoSat(rs.getInt("ID"), rs.getString("TieuDe"), rs.getString("DoiTuong"),
                LocalDate.parse(dS), LocalDate.parse(dE),rs.getString("TrangThai"));
                
                list.add(baiKhaoSat);
            }
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public int update(BaiKhaoSat bks){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String update = "UPDATE BaiKhaoSat SET TieuDe = ?, DoiTuong = ?, ThoiGianBatDau = ?, ThoiGianKetThuc = ?, TrangThai = ? WHERE ID = ?";
            conn = DBUtils.getConnection();
            pps = conn.prepareStatement(update);
            pps.setString(1, bks.getTieuDe());
            pps.setString(2, bks.getDoiTuong());
            pps.setDate(3, Date.valueOf(bks.getThoiGianBatDau()));
            pps.setDate(4, Date.valueOf(bks.getThoiGianKetThuc()));
            pps.setString(5,bks.getTrangThai());
            pps.setInt(6,bks.getId());
            return pps.executeUpdate();
            
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return -1;
    }
    
    public int delete(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String delete = "DELETE FROM BaiKhaoSat WHERE ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(delete);
            pps.setInt(1, id);
            return pps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return -1;
    }

    public List<CauHoi> selectCauHoiOfBKS(int id){
        List<CauHoi> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "SELECT * FROM CauHoi CH JOIN KhaoSat_CauHoi KS_CH on CH.ID = KS_CH.MaCauHoi "
                          + "JOIN BaiKhaoSat BKS on BKS.ID = KS_CH.MaBaiKhaoSat WHERE BKS.ID = ?";
            
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                CauHoi cauHoi = new CauHoi(rs.getInt("ID"),rs.getString("NoiDung"),rs.getString("LuaChon1"), rs.getString("LuaChon2"),
                        rs.getString("LuaChon3"), rs.getString("LuaChon4"), rs.getString("HinhThucTraLoi"));
                list.add(cauHoi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public List<BaiKhaoSat> selectBKSByCapBac(int idQN, String name){
        List<BaiKhaoSat> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            String select = "SELECT * FROM BaiKhaoSat WHERE ID NOT IN (\n" +
                            "	SELECT BKS.ID FROM BaiKhaoSat BKS\n" +
                            "	JOIN QN_BKS ON QN_BKS.MaBKS = BKS.ID\n" +
                            "	JOIN QuanNhan QN ON QN.ID = QN_BKS.MaQN\n" +
                            "	WHERE QN.ID = ? \n" +
                            ")\n" +
                            "AND DoiTuong = ?\n" +
                            "AND TrangThai = N'Đang mở'"+ 
                            "AND ThoiGianKetThuc >= GETDATE()";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, idQN);
            pps.setString(2, name);
            
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {    
                Date dateStart = rs.getDate("ThoiGianBatDau");
                Date dateEnd   = rs.getDate("ThoiGianKetThuc");
                String dS = dateFormat.format(dateStart);
                String dE = dateFormat.format(dateEnd);
                BaiKhaoSat baiKhaoSat = new BaiKhaoSat(rs.getInt("ID"), rs.getString("TieuDe"), rs.getString("DoiTuong"),
                LocalDate.parse(dS), LocalDate.parse(dE),rs.getString("TrangThai"));
                
                list.add(baiKhaoSat);
            }
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public List<BaiKhaoSat> thongkeTongQuat(){
        Connection conn = null;
        PreparedStatement pps = null;
        
        List<BaiKhaoSat> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            String select = "EXEC sp_ThongKe";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID");
                String tieude = rs.getString("TieuDe");
                
                Date dateStart = rs.getDate("ThoiGianBatDau");
                Date dateEnd   = rs.getDate("ThoiGianKetThuc");
                String dS = dateFormat.format(dateStart);
                String dE = dateFormat.format(dateEnd);
                
                int slQN = rs.getInt("Số lượng quân nhân");
                int slCH = rs.getInt("Số lượng câu hỏi");
                int slPH = rs.getInt("Số lượng phản hồi");
                BaiKhaoSat baiKhaoSat = new BaiKhaoSat(id, tieude, LocalDate.parse(dS), LocalDate.parse(dE),slQN, slCH, slPH);
                list.add(baiKhaoSat);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public List<PhanHoi> ThongKePhanHoi(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        
        List<PhanHoi> list = new ArrayList<>();
        
        try{
            String select = "SELECT * FROM BaiKhaoSat BKS JOIN PhanHoi PH ON BKS.ID = PH.IDBaiKhaoSat JOIN QuanNhan QN ON QN.ID = PH.IdQuanNhan WHERE BKS.ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                int idBKS = rs.getInt("IDBaiKhaoSat");
                String tieude = rs.getString("TieuDe");
                int idQN = rs.getInt("IdQuanNhan");
                String hoten = rs.getString("HoTen");
                String cmnd = rs.getString("Cmnd");
                String noidung = rs.getString("NoiDung");
                Timestamp timestamp = rs.getTimestamp("ThoiGian"); 
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                
                PhanHoi phanHoi = new PhanHoi(noidung, idBKS, idQN, tieude, hoten, cmnd, localDateTime);
                list.add(phanHoi);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public List<QuanNhan> ThongKeNguoiThamGia(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        
        List<QuanNhan> list = new ArrayList<>();
        
        try{
            String select = "SELECT * FROM BaiKhaoSat BKS JOIN QN_BKS ON BKS.ID = QN_BKS.MaBKS JOIN QuanNhan QN ON QN.ID = QN_BKS.MaQN JOIN DonVi DV ON DV.MaDonVi = QN.IdDonVi JOIN CapBac CB ON CB.MaCapBac = QN.IdCapBac WHERE BKS.ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, id);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                DonVi donVi = new DonVi(rs.getInt("MaDonVi"), rs.getString("TenDonVi"));
                CapBac capBac = new CapBac(rs.getInt("MaCapBac"), rs.getString("TenCapBac"));
                
                QuanNhan quanNhan = new QuanNhan(rs.getInt(9),rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), 
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
    
    public List<CauHoi> ThongKeChiTietTraLoi(int idBKS, int idQN){
        Connection conn = null;
        PreparedStatement pps = null;
        System.out.println("id BKS "+idBKS + " id QN "+ idQN);
        List<CauHoi> list = new ArrayList<>();
        
        try{
            String select = "SELECT * FROM BaiKhaoSat BKS JOIN KhaoSat_CauHoi KS_CH ON BKS.ID = KS_CH.MaBaiKhaoSat JOIN CauHoi CH ON CH.ID = KS_CH.MaCauHoi JOIN QN_BKS ON BKS.ID = QN_BKS.MaBKS JOIN QuanNhan QN ON QN.ID = QN_BKS.MaQN JOIN TraLoi TL ON TL.IdCauHoi = CH.ID AND TL.Id_QuanNhan = QN.ID WHERE BKS.ID = ? AND QN.ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, idBKS);
            pps.setInt(2, idQN);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                CauHoi cauHoi = new CauHoi( rs.getString("NoiDung"), rs.getString("LuaChon1")
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
    
    public List<CauHoi> ThongKeSoLuongTraLoi(int idBKS){
        Connection conn = null;
        PreparedStatement pps = null;
        List<CauHoi> list = new ArrayList<>();
        
        try{
            String select = "SELECT * FROM dbo.ThongKeChiTietTraLoi(?)";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            pps.setInt(1, idBKS);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                CauHoi cauHoi = new CauHoi(rs.getInt("ID"), rs.getString("NoiDung"), rs.getInt("SoLuongLuaChon1"), rs.getInt("SoLuongLuaChon2"), rs.getInt("SoLuongLuaChon3"), rs.getInt("SoLuongLuaChon4"));
                list.add(cauHoi);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }

    public Map<String,Integer> soLuongQuanNhanOfBKS(){
        Connection conn = null;
        PreparedStatement pps = null;
        Map<String,Integer> hashMap = new TreeMap<>();
        try{
            String select = "SELECT BKS.ID, BKS.TieuDe,COUNT(QN.ID) N'Số lượng quân nhân' FROM BaiKhaoSat BKS LEFT JOIN QN_BKS ON QN_BKS.MaBKS = BKS.ID LEFT JOIN QuanNhan QN ON QN_BKS.MaQN = QN.ID GROUP BY BKS.ID, BKS.TieuDe";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
               hashMap.put("Bài khảo sát "+rs.getInt("ID"), rs.getInt("Số lượng quân nhân"));
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());   
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return hashMap;
    }
    
    public Map<String,Integer> soLuongPhanHoiOfBKS(){
        Connection conn = null;
        PreparedStatement pps = null;
        Map<String,Integer> hashMap = new TreeMap<>();
        try{
            String select = "SELECT BKS.ID, BKS.TieuDe, COUNT(PH.ID) AS N'Số lượng phản hồi' FROM BaiKhaoSat BKS LEFT JOIN PhanHoi PH ON PH.IDBaiKhaoSat = BKS.ID GROUP BY BKS.ID, BKS.TieuDe";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
               hashMap.put("Bài khảo sát "+rs.getInt("ID"), rs.getInt("Số lượng phản hồi"));
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());   
        }finally{
            DBUtils.closeConnection(conn, pps);
        }
        return hashMap;
    }
}
