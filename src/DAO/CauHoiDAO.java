/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.CauHoi;
import Utils.DBUtils;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.sql.Statement;
/**
 *
 * @author DELL
 */
public class CauHoiDAO {
     public boolean Them(CauHoi cauHoi,int idBKS){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String insert = "INSERT INTO CauHoi VALUES (?,?,?,?,?,?)";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            pps.setString(1, cauHoi.getNoiDung());
            pps.setString(2, cauHoi.getLuaChon1());
            pps.setString(3, cauHoi.getLuaChon2());
            pps.setString(4, cauHoi.getLuaChon3());
            pps.setString(5, cauHoi.getLuaChon4());
            pps.setString(6, cauHoi.getHinhThuc());
            if(!pps.execute()){
                ResultSet rs = pps.getGeneratedKeys();
                while(rs.next()){
                    System.out.println("identity "+rs.getInt(1));
                    String them = "INSERT INTO KhaoSat_CauHoi VALUES (?,?)";
                    pps = conn.prepareStatement(them);
                    pps.setInt(1, idBKS);
                    pps.setInt(2, rs.getInt(1));
                    return pps.execute();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return true;
    }
    
    public boolean ThemListCauHoi(List<CauHoi> list,int idBKS){
        boolean check = false;
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            
            conn = DBUtils.getConnection();
            for (CauHoi cauHoi : list) {
               String insert = "INSERT INTO CauHoi VALUES (?,?,?,?,?,?)";
                pps  = conn.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
                pps.setString(1, cauHoi.getNoiDung());
                pps.setString(2, cauHoi.getLuaChon1());
                pps.setString(3, cauHoi.getLuaChon2());
                pps.setString(4, cauHoi.getLuaChon3());
                pps.setString(5, cauHoi.getLuaChon4());
                pps.setString(6, cauHoi.getHinhThuc());
                if(!pps.execute()){
                    ResultSet rs = pps.getGeneratedKeys();
                    while(rs.next()){
                        System.out.println("identity "+rs.getInt(1));
                        String them = "INSERT INTO KhaoSat_CauHoi VALUES (?,?)";
                        pps = conn.prepareStatement(them);
                        pps.setInt(1, idBKS);
                        pps.setInt(2, rs.getInt(1));
                        pps.execute();
                        check = true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return check;
    }
    
    public List<CauHoi> selectCauHoi(){
        List<CauHoi> list= new ArrayList<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "SELECT * FROM CauHoi";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                CauHoi cauHoi = new CauHoi(rs.getInt("ID"), rs.getString("NoiDung"), rs.getString("LuaChon1")
                                         , rs.getString("LuaChon2"), rs.getString("LuaChon3"), rs.getString("LuaChon4"), rs.getString("HinhThucTraLoi"));
                list.add(cauHoi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return list;
    }
    
    public int update(CauHoi cauHoi){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String update = 
                    "UPDATE CauHoi SET NoiDung = ?, LuaChon1 = ? , LuaChon2 = ? , LuaChon3 = ? ,"
                    + " LuaChon4 = ? , HinhThucTraLoi = ? WHERE ID = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(update);
            pps.setString(1, cauHoi.getNoiDung());
            pps.setString(2, cauHoi.getLuaChon1());
            pps.setString(3, cauHoi.getLuaChon2());
            pps.setString(4, cauHoi.getLuaChon3());
            pps.setString(5, cauHoi.getLuaChon4());
            pps.setString(6, cauHoi.getHinhThuc());
            pps.setInt(7, cauHoi.getId());
            
            return pps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return -1;
    }
    
    public int delete(int id){
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String deteleFK = "DELETE KhaoSat_CauHoi WHERE MaCauHoi = ?";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(deteleFK);
            pps.setInt(1, id);
            if(pps.executeUpdate() >  0){
                String delete = "DELETE FROM CauHoi WHERE ID = ?";
                pps = conn.prepareStatement(delete);
                pps.setInt(1, id);
                return pps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return -1;
    }
    
    public Map<String,String> selectExam(){
        Map<String,String> maps = new TreeMap<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "SELECT * FROM Exams";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                maps.put(rs.getString("Exam_Id"), rs.getString("Exam_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return maps;
    }
    
    public Map<String,String> selectExamByStatus(){
        Map<String,String> maps = new TreeMap<>();
        Connection conn = null;
        PreparedStatement pps = null;
        try {
            String select = "SELECT * FROM Exams WHERE Status = N'Mở đề'";
            conn = DBUtils.getConnection();
            pps  = conn.prepareStatement(select);
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
                maps.put(rs.getString("Exam_Id"), rs.getString("Exam_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, pps);
        }
        return maps;
    }
}

