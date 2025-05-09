package Views;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Controllers.VerifyAccountController;

import java.awt.*;
import java.awt.event.ActionListener;

public class VerifyAccount extends JPanel {
    private JTextField tfnamev;
    private JPasswordField passwordField;
    private JButton btnaccept;
    
  
    public VerifyAccount() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(183, 228, 249));
        panel.setBounds(0, 0, 1309, 946);
        add(panel);
        panel.setLayout(null);

        JPanel pnentry = new JPanel();
        pnentry.setLayout(null);
        pnentry.setBorder(new LineBorder(new Color(255, 255, 255), 5));
        pnentry.setBackground(new Color(136, 190, 240));
        pnentry.setBounds(271, 11, 802, 924);
        panel.add(pnentry);

        JLabel lblXcThcBn = new JLabel("Xác thực bạn có phải là quản lý của tài khoản");
        lblXcThcBn.setBackground(new Color(36, 118, 217));
        lblXcThcBn.setBounds(10, 92, 782, 59);
        pnentry.add(lblXcThcBn);
        lblXcThcBn.setHorizontalAlignment(SwingConstants.CENTER);
        lblXcThcBn.setForeground(new Color(255, 255, 255));
        lblXcThcBn.setFont(new Font("Segoe UI", Font.BOLD, 33));

        JLabel lb1 = new JLabel("Tên đăng nhập:");
        lb1.setBackground(new Color(36, 118, 217));
        lb1.setBounds(166, 246, 326, 50);
        pnentry.add(lb1);
        lb1.setForeground(new Color(36, 118, 217));
        lb1.setFont(new Font("Segoe UI", Font.BOLD, 30));

        tfnamev = new JTextField();
        tfnamev.setBounds(166, 300, 450, 50);
        pnentry.add(tfnamev);
        tfnamev.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tfnamev.setColumns(10);

        JLabel tfpasswordv = new JLabel("Mật khẩu:");
        tfpasswordv.setBackground(new Color(36, 118, 217));
        tfpasswordv.setBounds(166, 370, 293, 50);
        pnentry.add(tfpasswordv);
        tfpasswordv.setForeground(new Color(36, 118, 217));
        tfpasswordv.setFont(new Font("Segoe UI", Font.BOLD, 30));

        passwordField = new JPasswordField();
        passwordField.setBounds(166, 424, 450, 50);
        pnentry.add(passwordField);
        passwordField.setFont(new Font("Segoe UI", Font.BOLD, 20));

        btnaccept = new JButton("Xác thực");
        btnaccept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnaccept.setBounds(166, 610, 450, 60);
        pnentry.add(btnaccept);
        btnaccept.setForeground(new Color(36, 118, 217));
        btnaccept.setFont(new Font("Segoe UI", Font.BOLD, 30));
        btnaccept.setBackground(Color.WHITE);
    }

    public String getUsername() {
        return tfnamev.getText();
    }
    
    public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getTfnamev() {
		return tfnamev;
	}

	public void setTfnamev(JTextField tfnamev) {
		this.tfnamev = tfnamev;
	}

	public JButton getBtnaccept() {
		return btnaccept;
	}

	

    
}

