package Views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class HomeManager extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnStart;
	private JButton btnresetstatus;
	

	public HomeManager() {
		
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(136, 190, 240));
		panel_1.setBounds(91, 83, 1101, 756);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnStart = new JButton("Bắt đầu");
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnStart.setBackground(new Color(255, 255, 255));
		btnStart.setForeground(new Color(36, 118, 217));
		btnStart.setBounds(421, 326, 282, 51);
		panel_1.add(btnStart);
		
		btnresetstatus = new JButton("Làm mới tình trạng");
		btnresetstatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnresetstatus.setForeground(new Color(202, 202, 0));
		btnresetstatus.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnresetstatus.setBackground(new Color(255, 255, 255));
		btnresetstatus.setBounds(661, 659, 282, 51);
		panel_1.add(btnresetstatus);
		
		JLabel lblNewLabel = new JLabel("<html>Trước khi bắt đầu hãy làm mới tình trạng của tất cả nhân viên.<br>"
		        + "(Nếu có mất điện hay việc gì thì không cần ấn nút \"Làm mới tình trạng\")</html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 640, 578, 94); // Điều chỉnh lại kích thước để nội dung hiển thị đẹp hơn
		panel_1.add(lblNewLabel);


		
	}
	public JButton getBtnStart() {
		return btnStart;
	}
	public JButton getBtnresetstatus() {
		return btnresetstatus;
	}
	
}
