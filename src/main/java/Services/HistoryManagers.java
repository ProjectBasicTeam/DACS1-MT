package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.BuyItemM;
import Models.History1M;
import Models.History2M;

public class HistoryManagers {
	private static HistoryManagers instance;

	public static HistoryManagers getInstance() {
		if (instance == null) {
			instance = new HistoryManagers();
		}
		return instance;
	}

	public HistoryManagers() {

	}

	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	public ArrayList<History1M> loadHistory1(String brancha) {
	    ArrayList<History1M> list = new ArrayList<>();
	    try {
	        String sql = "SELECT stt, idhd, totalprice, totalqty, phonecustomer, day, hour, brancha FROM History1 WHERE brancha = ?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, brancha); 
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            int stt = rs.getInt(1);
	            String idhd = rs.getString(2);
	            int totalprice = rs.getInt(3);
	            int totalqty = rs.getInt(4);
	            String phonecustomer = rs.getString(5);
	            Date day = rs.getDate(6);
	            String hour = rs.getString(7);
	            String branchA = rs.getString(8);

	            History1M h1 = new History1M(stt, idhd, totalprice, totalqty, phonecustomer, day, hour, branchA);
	            list.add(h1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	public ArrayList<History1M> loadTableHistory1() {
	    ArrayList<History1M> list = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM History1";
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            int stt = rs.getInt(1);
	            String idhd = rs.getString(2);
	            int totalprice = rs.getInt(3);
	            int totalqty = rs.getInt(4);
	            String phonecustomer = rs.getString(5);
	            Date day = rs.getDate(6);
	            String hour = rs.getString(7);
	            String branchA = rs.getString(8);

	            History1M h1 = new History1M(stt, idhd, totalprice, totalqty, phonecustomer, day, hour, branchA);
	            list.add(h1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	public ArrayList<History2M> loadTableHistory2() {
	    ArrayList<History2M> list = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM History2";
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            int stt = rs.getInt(1);
	            String idhd = rs.getString(2);
	            String idproduct = rs.getString(3);
	            String nameproduct = rs.getString(4);
	            int quantityproduct = rs.getInt(5);
	            int priceproduct = rs.getInt(6);
	            int totalprice = rs.getInt(7);
	            Date day = rs.getDate(8);
	            String brancha = rs.getString(9);
	            History2M h2 = new History2M(stt, idhd, idproduct, nameproduct , quantityproduct , priceproduct , totalprice , day, brancha );
	            list.add(h2);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	public void getHistory1(JTable table, String search) {
        String sql = "SELECT * FROM History1 WHERE CONCAT(IFNULL(idhd, ''), IFNULL(phonecustomer, ''), IFNULL(day, ''),IFNULL(brancha, '')) LIKE ? ORDER BY stt DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getInt("stt");
                row[1] = rs.getString("idhd");
                row[2] = rs.getString("totalprice");
                row[3] = rs.getString("totalqty");
                row[4] = rs.getString("phonecustomer");
                row[5] = rs.getString("day");
                row[6] = rs.getString("hour");
                row[7] = rs.getString("brancha");                
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(300);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(180);
            table.getColumnModel().getColumn(5).setPreferredWidth(200);
            table.getColumnModel().getColumn(6).setPreferredWidth(300);
            table.getColumnModel().getColumn(7).setPreferredWidth(400);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
	public void getHistory1inDetail(JTable table, String branch, String search) {
        String sql = "SELECT stt, idhd, totalprice, totalqty, phonecustomer, hour, day FROM History1 WHERE brancha = ? AND CONCAT(IFNULL(idhd, ''), IFNULL(phonecustomer, ''), IFNULL(day, '')) LIKE ? ORDER BY stt DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, branch);
            ps.setString(2, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[7];
                row[0] = rs.getInt("stt");
                row[1] = rs.getString("idhd");
                row[2] = rs.getString("totalprice");
                row[3] = rs.getString("totalqty");
                row[4] = rs.getString("phonecustomer");
                row[5] = rs.getString("hour");
                row[6] = rs.getString("day");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(150);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(200);
    		table.getColumnModel().getColumn(5).setPreferredWidth(240);
    		table.getColumnModel().getColumn(6).setPreferredWidth(180);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
	public void getHistory2(JTable table, String search) {
        String sql = "SELECT * FROM History2 WHERE CONCAT(IFNULL(idhd, ''), IFNULL(idproduct , ''), IFNULL(day  , ''),IFNULL(brancha, '')) LIKE ? ORDER BY stt DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[9];
                row[0] = rs.getInt("stt");
                row[1] = rs.getString("idhd");
                row[2] = rs.getString("idproduct");
                row[3] = rs.getString("nameproduct");
                row[4] = rs.getString("quantityproduct");
                row[5] = rs.getString("priceproduct");
                row[6] = rs.getString("totalprice");
                row[7] = rs.getString("day");  
                row[8] = rs.getString("brancha");  
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(60);
            table.getColumnModel().getColumn(1).setPreferredWidth(120);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setPreferredWidth(400);
            table.getColumnModel().getColumn(4).setPreferredWidth(60);
            table.getColumnModel().getColumn(5).setPreferredWidth(300);
            table.getColumnModel().getColumn(6).setPreferredWidth(300);
            table.getColumnModel().getColumn(7).setPreferredWidth(180);
            table.getColumnModel().getColumn(8).setPreferredWidth(400);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
	public int getMaxrow1() {
		int row = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT MAX(stt) FROM History1  ");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row+1;
	}
	public void insertHistory1(History1M p) {
		String sql = "INSERT INTO History1  (stt  , idhd , totalprice , totalqty ,  phonecustomer,  day, hour, brancha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getStt());
			ps.setString(2, p.getIdhd());
			ps.setInt(3, p.getTotalprice());
			ps.setInt(4, p.getTotalqty());
			ps.setString(5, p.getPhonecustomer());
			ps.setDate(6, p.getDay());
			ps.setString(7, p.getHour());
			ps.setString(8, p.getBrancha());
			

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getMaxrow2() {
		int row = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT MAX(stt) FROM History2  ");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row+1;
	}
	public void insertHistory2(History2M p) {
		String sql = "INSERT INTO History2  (idhd , idproduct , nameproduct ,  quantityproduct,  priceproduct, totalprice, day , brancha) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
//			ps.setInt(1, p.getStt());
			ps.setString(1, p.getIdhd());
			ps.setString(2, p.getIdproduct());
			ps.setString(3, p.getNameproduct());
			ps.setInt(4, p.getQuantityproduct());
			ps.setInt(5, p.getPriceproduct());
			ps.setInt(6, p.getTotalprice());
			ps.setDate(7, p.getDay());
			ps.setString(8, p.getBrancha());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getIdproductBuy(String name) {
        String idproduct = null;
        try {
            ps = con.prepareStatement("SELECT idproduct FROM Purchase  WHERE nameproduct  = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
            	idproduct = rs.getString("idproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idproduct;
    }
}
