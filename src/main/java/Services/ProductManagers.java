package Services;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.ProductM;
import Models.ProductM2;
import Models.ProductTransferM;
import Models.SupplierM;

public class ProductManagers {
	private static ProductManagers instance;

	public static ProductManagers getInstance() {
		if(instance == null) {
			instance = new ProductManagers();
		}
		return instance;
	}
	
	
	public ProductManagers() {
		
	}
	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public int getMaxrow() {
		int row = 0; 
		try {
			st =con.createStatement();
			rs = st.executeQuery("SELECT MAX(stt) FROM Warehouseproduct");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row+1;
	}
    public String getNameatWarehouse(int stt) {
        String name = null;
        try {
            ps = con.prepareStatement("SELECT nameproduct FROM Warehouseproduct WHERE stt  = ?");
            ps.setInt(1, stt);
            rs = ps.executeQuery();
            if (rs.next()) {
            	name = rs.getString("nameproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public ArrayList<ProductM> loadProduct() {
		ArrayList<ProductM> list = new ArrayList<>();
		try {
			
			String sql = "SELECT * FROM Warehouseproduct ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int stt = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				int qty = rs.getInt(5);
				byte[] image = rs.getBytes(6);
				
				ProductM product = new ProductM(stt,id, name, price,qty,image);
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public ArrayList<ProductM2> loadProduct2() {
		ArrayList<ProductM2> list = new ArrayList<>();
		try {
			
			String sql = "SELECT idproduct, nameproduct, quantityproduct FROM Warehouseproduct ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				
				ProductM2 product = new ProductM2(id, name,qty);
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public void insertProductInWareHouse(ProductM p) {
    	 String sql = "INSERT INTO Warehouseproduct (stt, nameproduct , priceproduct , quantityproduct , image) VALUES (?, ?, ?, ?, ?)";
         try {
             ps = con.prepareStatement(sql);
             ps.setInt(1, p.getStt());
             ps.setString(2, p.getNameproduct());
             ps.setInt(3, p.getPriceproduct());
             ps.setInt(4, p.getQtyproduct());
             ps.setBytes(5, p.getImage());
             ps.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    public void updateQtyProduct(int stt,int newQty) {
        String sql = "UPDATE Warehouseproduct SET quantityproduct = ? WHERE stt = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, newQty);
            ps.setInt(2, stt); 
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProduct(ProductM p) {
        String sql = "UPDATE Warehouseproduct SET idproduct = ?, nameproduct = ?, priceproduct = ?, quantityproduct = ?, image = ? WHERE stt = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getIdproduct());
            ps.setString(2, p.getNameproduct());
            ps.setInt(3, p.getPriceproduct());
            ps.setInt(4, p.getQtyproduct());
            ps.setBytes(5, p.getImage());
            ps.setInt(6, p.getStt()); 
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public byte[] getImageById(int id) {
        byte[] image = null;
        try {
            String sql = "SELECT image FROM Warehouseproduct WHERE stt = ?";
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
    public void deleteProduct(int id) {
    	int a = JOptionPane.showOptionDialog(null, "Bạn có chắc muốn xoá sản phẩm trong kho hay không?", 
                "Xoá sản phẩm", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, null, null);
		 if (a == JOptionPane.YES_OPTION) {
	    	String sql = "DELETE FROM Warehouseproduct WHERE stt = ?";
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
    }
    public void getproductValue(JTable table, String search) {
    	String sql = "SELECT * FROM Warehouseproduct WHERE CONCAT(IFNULL(idproduct, ''), IFNULL(nameproduct, ''), IFNULL(priceproduct, ''), IFNULL(stt, '')) LIKE ? ORDER BY stt ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getInt("stt");
                row[1] = rs.getString("idproduct");
                row[2] = rs.getString("nameproduct");
                row[3] = rs.getString("priceproduct");
                row[4] = rs.getString("quantityproduct");
                byte[] imgData = rs.getBytes("image");
                ImageIcon icon = null;
                if (imgData != null) {
                    Image img = Toolkit.getDefaultToolkit().createImage(imgData);
                    Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImg);
                }
                row[5] = icon;
                
                model.addRow(row);
            }
            
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(180);
            table.getColumnModel().getColumn(2).setPreferredWidth(400);
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(200);
            table.setRowHeight(200); 

            table.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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
    public ArrayList<ProductTransferM> loadTransferProduct() {
		ArrayList<ProductTransferM> list = new ArrayList<>();
		try {
			
			String sql = "SELECT * FROM BranchProduct  ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int id = rs.getInt(1);
				String brancha = rs.getString(2);
				String addressa = rs.getString(3);
				String idproduct = rs.getString(4);
				int qty = rs.getInt(5);
				
				
				ProductTransferM product = new ProductTransferM(id,brancha, addressa, idproduct,qty);
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public int getMaxrow2() {
		int row = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT MAX(idbranchproduct) FROM BranchProduct ");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row+1;
	}
    public void insertProductTransferBrancha(ProductTransferM p) {
   	 String sql = "INSERT INTO BranchProduct  (idbranchproduct , brancha , addressa  , idproduct , quantityproduct) VALUES (? ,?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, getMaxrow2());
            ps.setString(2, p.getBrancha());
            ps.setString(3, p.getAddress());
            ps.setString(4, p.getIdproduct());
            ps.setInt(5, p.getQty());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
    public void updateProduct2(String idproduct,int qtyproduct) {
        String sql = "UPDATE Warehouseproduct SET quantityproduct = ? WHERE idproduct = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, qtyproduct);
            ps.setString(2, idproduct);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateQtyAtBranch(String idproduct,String brancha, int newQty) {
    	String sql = "UPDATE BranchProduct SET quantityproduct = ? WHERE idproduct = ? AND brancha = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, newQty);
            ps.setString(2,idproduct);
            ps.setString(3, brancha);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getqtyatWarehouse(String idproduct) {
        int qty = 0;
        try {
            ps = con.prepareStatement("SELECT quantityproduct FROM Warehouseproduct WHERE idproduct  = ?");
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
    public int getqtyatWarehousefromstt(int stt) {
        int qty = 0;
        try {
            ps = con.prepareStatement("SELECT quantityproduct FROM Warehouseproduct WHERE stt  = ?");
            ps.setInt(1, stt);
            rs = ps.executeQuery();
            if (rs.next()) {
                qty = rs.getInt("quantityproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qty;
    }
    public int getqtyatBranchfromidproduct(String idproduct) {
        int qty = 0;
        try {
            ps = con.prepareStatement("SELECT quantityproduct FROM BranchProduct WHERE idproduct  = ?");
            ps.setString(1, idproduct);
            rs = ps.executeQuery();
            if (rs.next()) {
                qty = rs.getInt("quantityproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qty;
    }
    public int getqtyatTranferBrancha(String idproduct, String brancha) {
        int qty = 0;
        try {
            ps = con.prepareStatement("SELECT quantityproduct FROM BranchProduct WHERE idproduct  = ? AND brancha = ?");
            ps.setString(1, idproduct.trim());
            ps.setString(2, brancha.trim());
            rs = ps.executeQuery();
            if (rs.next()) {
                qty = rs.getInt("quantityproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qty;
    }
   
    public void deleteTransferProduct(String idproduct,String brancha) {
	    	String sql = "DELETE FROM BranchProduct WHERE idproduct  = ? AND brancha = ?";
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, idproduct.trim());
	            ps.setString(2, brancha.trim());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
    
    public void getProductWarehouseValue(JTable table, String search) {
        String sql = "SELECT * FROM Warehouseproduct WHERE CONCAT(IFNULL(idproduct, ''), IFNULL(nameproduct, '')) LIKE ? ORDER BY stt ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getString("idproduct");
                row[1] = rs.getString("nameproduct");
                row[2] = rs.getString("quantityproduct");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(180);
    		table.getColumnModel().getColumn(1).setPreferredWidth(500);
    		table.getColumnModel().getColumn(2).setPreferredWidth(100);

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void getBranchProductValue(JTable table, String search) {
        String sql = "SELECT * FROM BranchProduct WHERE CONCAT(IFNULL(brancha , ''), IFNULL(idproduct , '')) LIKE ? ORDER BY idbranchproduct  ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt("idbranchproduct");
                row[1] = rs.getString("brancha");
                row[2] = rs.getString("addressa");
                row[3] = rs.getString("idproduct");
                row[4] = rs.getString("quantityproduct");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(550);
            table.getColumnModel().getColumn(3).setPreferredWidth(300);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
}
