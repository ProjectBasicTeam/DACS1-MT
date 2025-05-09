package Controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Services.AccountManagers;
import Services.ConnectMySQL;
import Views.Account;
import Views.DashboardAdmin;
import Views.DashboardManager;
import Views.VerifyAccount;

public class VerifyAccountController {
    private VerifyAccount view;
    private DashboardManager dashboard;
    private CardLayout cardLayout;
    private JPanel panelCard;
    private Account accountView;
    private AccountManagers ser;
    public VerifyAccountController(DashboardManager dashboard) {
    	this.accountView = dashboard.getAccountView();
        this.cardLayout = dashboard.getCardlayout();
        this.panelCard = dashboard.getPanelcard();
        this.view = new VerifyAccount();  
        this.ser = AccountManagers.getInstance();
        panelCard.add(view, "5");
        
        this.view.getBtnaccept().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmpty()) {
                    String namelogin = dashboard.getLbnamedb().getText().trim();
                    String name = view.getTfnamev().getText().trim();
                    String password = String.valueOf(view.getPasswordField().getPassword());

                    

                    if (namelogin.equals(name)) {
                        
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;

                        try {
                            con = ConnectMySQL.getConnected();
                            if (con == null || con.isClosed()) {
                                JOptionPane.showMessageDialog(view, "Kết nối tới cơ sở dữ liệu thất bại!");
                                return;
                            }

                            String sql = "SELECT * FROM AccountManagers WHERE namea = ? AND passworda = ?";
                            stmt = con.prepareStatement(sql);
                            stmt.setString(1, name);
                            stmt.setString(2, password);

                            rs = stmt.executeQuery();

                            if (rs.next()) {
                                JOptionPane.showMessageDialog(view, "Xác thực thành công.");

                                cardLayout.show(panelCard, "6");
                                
                            } else {
                                JOptionPane.showMessageDialog(view, "Sai tên đăng nhập, mật khẩu hoặc quyền.");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(view, "Lỗi truy vấn cơ sở dữ liệu: " + ex.getMessage());
                        } finally {
                            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
                            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
                            try { if (con != null && !con.isClosed()) con.close(); } catch (SQLException ignored) {}
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Sai tên đăng nhập, mật khẩu hoặc quyền.");
                    }
                }
            }
        });

    }
	private boolean isEmpty() {
		if (view.getTfnamev().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (String.valueOf(view.getPasswordField().getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập mật khẩu tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		return true;
	}

   
    
}
