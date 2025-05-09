package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Services.AccountManagers;
import Services.ConnectMySQL;
import Views.Account;
import Views.DashboardAdmin;
import Views.DashboardManager;
import Views.Login;

public class LoginController {
	private Login view;
	private AccountManagers ser;

	public LoginController(Login view) {
		this.ser= AccountManagers.getInstance();
		this.view= view;
		 addListeners();
	}
	private boolean isEmpty() {
		if (view.getTfname().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (String.valueOf(view.getTfpassword().getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập mật khẩu tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		return true;
	}
	void  addListeners() {
		view.getBtnlogin().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(isEmpty()) {
		    		 try {
		    		String name = view.getTfname().getText();
			         String password = String.valueOf(view.getTfpassword().getPassword());
			         String role = view.getCbx().getSelectedItem().toString();
			         Connection con = ConnectMySQL.getConnected();
			         String sql = "SELECT * FROM AccountManagers WHERE namea = ? AND passworda = ? AND rolea = ?";
			            PreparedStatement stmt = con.prepareStatement(sql);
			            stmt.setString(1, name);
			            stmt.setString(2, password);
			            stmt.setString(3, role);
			            
			            ResultSet rs = stmt.executeQuery();
			            if (rs.next()) {
			                JOptionPane.showMessageDialog(view, "Đăng nhập thành công với quyền " + role + "!");

			                view.dispose();

			                // Mở giao diện tương ứng
			                if (role.equals("Quản trị viên")) {
			                    new DashboardAdmin().setVisible(true);  
			                } else if (role.equals("Quản lý bán hàng")) {
			                	Account acc = new Account();
			                	int id = ser.getAccountId(name.trim());
			                	acc.setFindid(id);
			                	
			                	DashboardManager dashboard = new DashboardManager(id, name);
			                	dashboard.setvalueaccount(id, name); 
			                	dashboard.setVisible(true);

			                	
			                }
			            } else {
			                JOptionPane.showMessageDialog(view, "Sai tên đăng nhập, mật khẩu hoặc quyền.");
			            }

//			            rs.close();
//			            stmt.close();
//			            con.close();
		    		 } catch (SQLException e1) {
		                    e1.printStackTrace();
		             }
		    	}
		    }
		});
	}
}
