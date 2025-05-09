package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Controllers.RevenueController;

public class Revenue extends JPanel{
	private JPanel pnchartdt;
	private JLabel lblweek;
	private JLabel lbmonth;
	private JLabel lbyear;
	private JLabel lball;
	private JButton btnweek;
	private JButton btnmonth;
	private JButton btnyear;
	private void init() {
		new RevenueController(this);
	}
	
	public Revenue() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 217, 221));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		pnchartdt = new JPanel();
		pnchartdt.setBackground(new Color(255, 255, 255));
		pnchartdt.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pnchartdt.setBounds(28, 285, 1255, 629);
		panel.add(pnchartdt);
		
		btnweek = new JButton("Tuần");
		btnweek.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnweek.setBackground(new Color(255, 255, 255));
		btnweek.setBounds(110, 52, 189, 39);
		panel.add(btnweek);
		
		btnmonth = new JButton("Tháng");
		btnmonth.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnmonth.setBackground(Color.WHITE);
		btnmonth.setBounds(110, 111, 189, 39);
		panel.add(btnmonth);
		
		btnyear = new JButton("Năm");
		btnyear.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnyear.setBackground(Color.WHITE);
		btnyear.setBounds(110, 172, 189, 39);
		panel.add(btnyear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(309, 11, 874, 255);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTngTtC = new JLabel("Tổng tất cả doanh thu:");
		lblTngTtC.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTngTtC.setBounds(10, 185, 288, 41);
		panel_1.add(lblTngTtC);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng mức doanh thu trong năm nay:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 130, 360, 41);
		panel_1.add(lblNewLabel_1_1);
		
		lbyear = new JLabel("+ 0 (VNĐ)");
		lbyear.setForeground(new Color(15, 169, 96));
		lbyear.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbyear.setBounds(411, 130, 434, 41);
		panel_1.add(lbyear);
		
		lball = new JLabel("+ 0 (VNĐ)");
		lball.setForeground(new Color(15, 169, 96));
		lball.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lball.setBounds(411, 185, 434, 41);
		panel_1.add(lball);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng mức doanh thu trong tuần này:");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 20, 371, 41);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblTngMcDoanh = new JLabel("Tổng mức doanh thu trong tháng này:");
		lblTngMcDoanh.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTngMcDoanh.setBounds(10, 75, 371, 41);
		panel_1.add(lblTngMcDoanh);
		
		lblweek = new JLabel("+ 0 (VNĐ)");
		lblweek.setForeground(new Color(15, 169, 96));
		lblweek.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblweek.setBounds(411, 20, 434, 41);
		panel_1.add(lblweek);
		
		lbmonth = new JLabel("+ 0 (VNĐ)");
		lbmonth.setForeground(new Color(15, 169, 96));
		lbmonth.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbmonth.setBounds(411, 75, 434, 41);
		panel_1.add(lbmonth);
		init();
	}
	public JPanel getPnchartdt() {
		return pnchartdt;
	}
	public JLabel getLblweek() {
		return lblweek;
	}
	public JLabel getLbmonth() {
		return lbmonth;
	}
	public JLabel getLbyear() {
		return lbyear;
	}
	public JLabel getLball() {
		return lball;
	}
	public JButton getBtnweek() {
		return btnweek;
	}
	public JButton getBtnmonth() {
		return btnmonth;
	}
	public JButton getBtnyear() {
		return btnyear;
	}
}
