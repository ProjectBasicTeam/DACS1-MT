package Services;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.EmTimeKeepingM;
import Models.ProductM;
import Models.PurchaseM;
import Models.TempPurchaseM;

public class PurchaseManagers {
	private static PurchaseManagers instance;

	public static PurchaseManagers getInstance() {
		if (instance == null) {
			instance = new PurchaseManagers();
		}
		return instance;
	}

	public PurchaseManagers() {

	}

	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	public int getMaxrow() {
		int row = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT MAX(idtb) FROM TempBuy ");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int getCountBranchP(String brancha) {
		int row = 0;
		try {
			ps = con.prepareStatement("SELECT MAX(idbranchproduct) FROM BranchProduct WHERE brancha = ?");
			ps.setString(1, brancha.trim());
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public ArrayList<PurchaseM> loadPurchase(String brancha) {
		ArrayList<PurchaseM> list = new ArrayList<>();
		try {
			String sql = "SELECT b.idproduct, w.nameproduct, w.priceproduct, w.image, b.quantityproduct FROM BranchProduct b JOIN Warehouseproduct w ON b.idproduct = w.idproduct WHERE b.brancha = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, brancha);
			rs = ps.executeQuery();
			while (rs.next()) {
				String idp = rs.getString(1);
				String namep = rs.getString(2);
				int price = rs.getInt(3);
				byte[] image = rs.getBytes(4);
				int qty = rs.getInt(5);

				PurchaseM purchase = new PurchaseM(idp, namep, price, image, qty);

				list.add(purchase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<TempPurchaseM> loadTempBuy() {
		ArrayList<TempPurchaseM> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM TempBuy";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(2);
				String name = rs.getString(3);
				int qty = rs.getInt(4);
				int price = rs.getInt(5);

				TempPurchaseM temp = new TempPurchaseM(id, name, qty, price);

				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertTemp(TempPurchaseM p) {
		String sql = "INSERT INTO TempBuy (idproduct, nameproduct,  quantityproduct,  priceproduct) VALUES (?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getQty());
			ps.setInt(4, p.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertIdhd(String idhd) {
		String sql = "INSERT INTO IDHDrandom  (IDHD) VALUES (?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idhd);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getIdhd() {
		String id = null;
		try {
			ps = con.prepareStatement("SELECT IDHD  FROM IDHDrandom  LIMIT 1;");
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("IDHD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void deleteIdhd(String idhd) {
		String sql = "DELETE FROM IDHDrandom WHERE IDHD = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idhd);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getqtyatTemp(String idproduct) {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT quantityproduct FROM TempBuy WHERE idproduct  = ?");
			ps.setString(1, idproduct.trim());
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("quantityproduct");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}

	public void updateQtyAtTemp(String idproduct, int newQty) {
		String sql = "UPDATE TempBuy SET quantityproduct = ? WHERE idproduct = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, newQty);
			ps.setString(2, idproduct);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Deletealltempbuy() {
		try {
			ps = con.prepareStatement("TRUNCATE TABLE TempBuy;");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getIdproductTB(int idtb) {
        String idproduct = null;
        try {
            ps = con.prepareStatement("SELECT idproduct FROM TempBuy WHERE idtb = ?");
            ps.setInt(1, idtb);
            rs = ps.executeQuery();
            if (rs.next()) {
            	idproduct = rs.getString("idproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idproduct;
    }
	public String getIdproductBranch(int idtb, String branch) {
        String idproduct = null;
        try {
            ps = con.prepareStatement("SELECT idproduct FROM BranchProduct WHERE idbranchproduct = ? AND brancha = ?");
            ps.setInt(1, idtb);
            ps.setString(2, branch.trim());
            rs = ps.executeQuery();
            if (rs.next()) {
            	idproduct = rs.getString("idproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idproduct;
    }
	public String getIdproductTB2(String name) {
        String idproduct = null;
        try {
            ps = con.prepareStatement("SELECT idproduct FROM TempBuy WHERE nameproduct  = ?");
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
	public void delete1Item(String idproduct) {
		String sql = "DELETE FROM TempBuy WHERE idproduct = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idproduct);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getTotalqtyTemp() {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT SUM(quantityproduct) AS totalquantity FROM TempBuy;");
			rs = ps.executeQuery();
			while (rs.next()) {
				qty = rs.getInt("totalquantity");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public void getPurchaseValue(JTable table, String brancha, String search) {
	    String sql = "SELECT b.idproduct, w.nameproduct, w.priceproduct, w.image, b.quantityproduct " +
	                 "FROM BranchProduct b " +
	                 "JOIN Warehouseproduct w ON b.idproduct = w.idproduct " +
	                 "WHERE b.brancha = ? AND CONCAT(IFNULL(b.idproduct, ''), IFNULL(w.nameproduct, ''), IFNULL(w.priceproduct, ''), IFNULL(b.quantityproduct, '')) LIKE ?";

	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, brancha); // Chi nhánh cần tìm
	        ps.setString(2, "%" + search + "%"); // Tìm kiếm

	        rs = ps.executeQuery();

	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Xóa bảng cũ

	        Object[] row;
	        while (rs.next()) {
	            row = new Object[5];
	            row[0] = rs.getString("idproduct");
	            row[1] = rs.getString("nameproduct");
	            row[2] = rs.getInt("priceproduct");

	            byte[] imgData = rs.getBytes("image");
	            ImageIcon icon = null;
	            if (imgData != null) {
	                Image img = Toolkit.getDefaultToolkit().createImage(imgData);
	                Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	                icon = new ImageIcon(scaledImg);
	            }
	            row[3] = icon;
	            row[4] = rs.getInt("quantityproduct");
	            model.addRow(row);
	        }
	        
	        table.getColumnModel().getColumn(0).setPreferredWidth(160);
	        table.getColumnModel().getColumn(1).setPreferredWidth(400);
	        table.getColumnModel().getColumn(2).setPreferredWidth(300);
	        table.getColumnModel().getColumn(3).setPreferredWidth(200);
	        table.getColumnModel().getColumn(4).setPreferredWidth(130);
	        table.setRowHeight(200);

	        table.getColumnModel().getColumn(3).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
