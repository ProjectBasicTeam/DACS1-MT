package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Account;
 

public class AccountManagers {
	private static AccountManagers instance;
	
	public static AccountManagers getInstance() {
		if(instance == null) {
			instance = new AccountManagers();
		}
		return instance;
	}
	
	
	public AccountManagers() {
		
	}
	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public int getMaxrow() {
		int row = 0; 
		try {
			st =con.createStatement();
			rs = st.executeQuery("SELECT MAX(ida) FROM AccountManagers");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row+1;
	}
    public ArrayList<Account> loadAccount() {
		ArrayList<Account> list = new ArrayList<>();
		try {
			
			String sql = "SELECT * FROM AccountManagers ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int ida = rs.getInt(1);
				String namea = rs.getString(2);
				String passworda = rs.getString(3);
				String brancha = rs.getString(4);
				String addressa = rs.getString(5);
				String phonea = rs.getString(6);
				String rolea = rs.getString(7);
				Account account = new Account(ida, namea, passworda, brancha, addressa,phonea, rolea);
				
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public void insertAccount(Account account) {
        String sql = "INSERT INTO AccountManagers (ida, namea, passworda, brancha, addressa, phonea, rolea) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, account.getIda());
            ps.setString(2, account.getNamea());
            ps.setString(3, account.getPassworda());
            ps.setString(4, account.getBrancha());
            ps.setString(5, account.getAddressa());
            ps.setString(6, account.getPhonea());
            ps.setString(7, account.getRolea());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAccount(int ida, String namea, String passworda, String brancha, String addressa, String phonea,String rolea) {
    	String sql = "UPDATE AccountManagers SET namea = ?,passworda = ?,brancha = ?,addressa = ?, phonea = ?, rolea = ?WHERE ida = ?";
    	try {
			ps = con.prepareStatement(sql);
			ps.setString(1,namea);
			ps.setString(2,passworda);
			ps.setString(3,brancha);
			ps.setString(4,addressa);
			ps.setString(5,phonea);
			ps.setString(6,rolea);
			ps.setInt(7,ida);
			ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void updateAccount2(int id, String name, String password, String branch, String address, String phone) {
        String sql = "UPDATE AccountManagers SET namea = ?, passworda = ?, brancha = ?, addressa = ?, phonea = ? WHERE ida = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, branch);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) {
		 int a = JOptionPane.showOptionDialog(null, "Bạn có chắc muốn xoá tài khoản hay không?", 
                 "Xoá tài khoản", 
                 JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE, 
                 null, null, null);
		 if (a == JOptionPane.YES_OPTION) {
			try {
				ps = con.prepareStatement("DELETE FROM AccountManagers WHERE ida = ?");
				ps.setInt(1,id);
				ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
    public void getAccountValue(JTable table, String search) {
        String sql = "SELECT * FROM AccountManagers WHERE CONCAT(IFNULL(ida, ''), IFNULL(namea, ''), IFNULL(brancha, '')) LIKE ? ORDER BY ida ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[7];
                row[0] = rs.getInt("ida");
                row[1] = rs.getString("namea");
                row[2] = rs.getString("passworda");
                row[3] = rs.getString("brancha");
                row[4] = rs.getString("addressa");
                row[5] = rs.getString("phonea");
                row[6] = rs.getString("rolea");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(200);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
            table.getColumnModel().getColumn(3).setPreferredWidth(400);
            table.getColumnModel().getColumn(4).setPreferredWidth(575);
            table.getColumnModel().getColumn(5).setPreferredWidth(300);
            table.getColumnModel().getColumn(6).setPreferredWidth(300);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public int getAccountId(String namea) {
        int id = 0;
        try {
            ps = con.prepareStatement("SELECT ida FROM AccountManagers WHERE namea = ?");
            ps.setString(1, namea.trim());
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ida");
            } else {
                System.out.println("⚠️ Không tìm thấy người dùng với tên: " + namea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public int getAccountIdFromBrancha(String brancha) {
        int id = 0;
        try {
            ps = con.prepareStatement("SELECT address FROM AccountManagers WHERE bracha = ?");
            ps.setString(1, brancha.trim());
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ida");
            } else {
                System.out.println("⚠️ Không tìm thấy người dùng với tên: " + brancha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public String getAccountbrancha(int id) {
        String brancha = null;
        try {
            ps = con.prepareStatement("SELECT brancha FROM AccountManagers WHERE ida = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                brancha = rs.getString("brancha"); 
            } else {
                System.out.println("⚠️ Không tìm thấy chi nhánh với id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brancha;
    }
    public String getAccountaddress(String brancha) {
        String address = null;
        try {
            ps = con.prepareStatement("SELECT addressa FROM AccountManagers WHERE brancha = ?");
            ps.setString(1, brancha);
            rs = ps.executeQuery();
            if (rs.next()) {
            	address = rs.getString("addressa"); 
            } else {
                System.out.println("⚠️ Không tìm thấy chi nhánh với id: " + brancha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
    public String[] getAccountValue(int id) {
		String[] value = new String[7];
		try {
			ps = con.prepareStatement("SELECT * FROM AccountManagers WHERE ida = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				value[0] = rs.getString("ida");
				value[1] = rs.getString("namea");
				value[2] = rs.getString("passworda");
				value[3] = rs.getString("brancha");
				value[4] = rs.getString("addressa");
				value[5] = rs.getString("phonea");
				value[6] = rs.getString("rolea");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
    public void loadBranchToComboBox(JComboBox<String> cblocationpd) {
        String sql = "SELECT brancha FROM AccountManagers WHERE rolea = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"Quản lý bán hàng");
            rs = ps.executeQuery(); 

            cblocationpd.removeAllItems(); 

            while (rs.next()) {
                String branch = rs.getString("brancha");
                cblocationpd.addItem(branch);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu chi nhánh!");
        }
    }
}
