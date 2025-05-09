package Services;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.EmployeesM;
import Models.SupplierM;

public class SupplierMangagers {
	private static SupplierMangagers instance;

	public static SupplierMangagers getInstance() {
		if(instance == null) {
			instance = new SupplierMangagers();
		}
		return instance;
	}
	
	
	public SupplierMangagers() {
		
	}
	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public int getMaxrow() {
		int row = 0; 
		try {
			st =con.createStatement();
			rs = st.executeQuery("SELECT MAX(ids) FROM Supplier");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row+1;
	}
    public ArrayList<SupplierM> loadEmployees() {
		ArrayList<SupplierM> list = new ArrayList<>();
		try {
			
			String sql = "SELECT * FROM Supplier ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int ids = rs.getInt(1);
				String names = rs.getString(2);
				String phones = rs.getString(3);
				String addresss = rs.getString(4);
				String nameproduct = rs.getString(5);
				int qtyproduct = rs.getInt(6);
				int priceofoneproduct = rs.getInt(7);
				int totalcapital = rs.getInt(8);
				byte[] image = rs.getBytes(9);
				Date date = rs.getDate(10);
				SupplierM supplier = new SupplierM(ids, names, phones,addresss, nameproduct, qtyproduct,priceofoneproduct, totalcapital, image, date);
				list.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public void insertSupplier(SupplierM em) {
        String sql = "INSERT INTO Supplier (ids, names, phones, address, nameproduct, qtyproduct, priceofoneproduct, totalcapital, image, day) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getIds());
            ps.setString(2, em.getNames());
            ps.setString(3, em.getPhones());
            ps.setString(4, em.getAddresss());
            ps.setString(5, em.getNameproduct());
            ps.setInt(6, em.getQtyproduct());
            ps.setInt(7, em.getPriceoneproduct());
            ps.setInt(8, em.getTotalcapital());
            ps.setBytes(9, em.getImage());
            String formattedDate = em.getFormattedDay();
            Date date = Date.valueOf(formattedDate);
            ps.setDate(10, date);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateSupplier(SupplierM em) {
        String sql = "UPDATE Supplier SET names = ?, phones = ?, address = ?, nameproduct = ?, qtyproduct = ?, priceofoneproduct = ?, totalcapital = ?, image = ?, day = ? WHERE ids = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNames());
            ps.setString(2, em.getPhones());
            ps.setString(3, em.getAddresss());
            ps.setString(4, em.getNameproduct());
            ps.setInt(5, em.getQtyproduct());
            ps.setInt(6, em.getPriceoneproduct());
            ps.setInt(7, em.getTotalcapital());
            ps.setBytes(8, em.getImage());
            ps.setDate(9, em.getDay());
            ps.setInt(10, em.getIds()); // điều kiện WHERE
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteSupplier(int ids) {
    	int a = JOptionPane.showOptionDialog(null, "Bạn có chắc muốn xoá sản phẩm từ nhà cung cấp hay không?", 
                "Xoá nhà cung cấp", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, null, null);
		 if (a == JOptionPane.YES_OPTION) {
	    	String sql = "DELETE FROM Supplier WHERE ids = ?";
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, ids);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
    }
    public byte[] getImageById(int id) {
        byte[] image = null;
        try {
            String sql = "SELECT image FROM Supplier WHERE ids = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                image = rs.getBytes("image");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void getSupplierValue(JTable table, String search) {
    	String sql = "SELECT * FROM Supplier WHERE CONCAT(IFNULL(ids, ''), IFNULL(names, ''), IFNULL(phones, ''), IFNULL(nameproduct, '')) LIKE ? ORDER BY ids ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[10];
                row[0] = rs.getInt("ids");
                row[1] = rs.getString("names");
                row[2] = rs.getString("phones");
                row[3] = rs.getString("address");
                row[4] = rs.getString("nameproduct");
                row[5] = rs.getInt("qtyproduct");
                row[6] = rs.getInt("priceofoneproduct");
                row[7] = rs.getInt("totalcapital");
                byte[] imgData = rs.getBytes("image");
                ImageIcon icon = null;
                if (imgData != null) {
                    Image img = Toolkit.getDefaultToolkit().createImage(imgData);
                    Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImg);
                }
                row[8] = icon;
                row[9] = rs.getString("day");
                model.addRow(row);
            }
            table.getColumnModel().getColumn(0).setPreferredWidth(180);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(180);
            table.getColumnModel().getColumn(3).setPreferredWidth(400);
            table.getColumnModel().getColumn(4).setPreferredWidth(500);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(280);
            table.getColumnModel().getColumn(7).setPreferredWidth(200);
            table.getColumnModel().getColumn(8).setPreferredWidth(200);
            table.setRowHeight(200); 

            table.getColumnModel().getColumn(8).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
    			@Override
    			public void setValue(Object value) {
    				if (value instanceof ImageIcon) {
    					setIcon((ImageIcon) value);
    					setText(""); 
    				} else {
    					super.setValue(value);
    				}
    			}
    		});
            table.getColumnModel().getColumn(9).setPreferredWidth(300);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
