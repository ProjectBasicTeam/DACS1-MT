package Views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Controllers.HomeAdminController;
import java.awt.Dimension;

public class HomeAdmin extends JPanel{
	private JTable table;
	private JLabel lbtotaldetail;
	private JLabel lbtotalprofit;
	private JLabel lbtotalemployees;
	private JLabel lbtotalalldt;
	private JLabel lballbox;
	private JLabel lbtotalfunds;
	private JPanel pnchartcycle;
	private JPanel pnchart;
	private JButton btnexportweek;
	private JButton btnexportmonth;
	private JButton btnexportyear;
	private void init() {
		new HomeAdminController(this);
	}
	public HomeAdmin() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 217, 221));
		panel.setBounds(0, 0, 1309, 1606);
		add(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1309, 1550));
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 0, 1309, 946); // Giới hạn chiều cao để kích hoạt thanh cuộn
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(30);
		add(scrollPane);
		
		JPanel pntotalnv = new JPanel();
		pntotalnv.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pntotalnv.setBackground(new Color(255, 255, 255));
		pntotalnv.setBounds(21, 29, 307, 200);
		panel.add(pntotalnv);
		pntotalnv.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeAdmin.class.getResource("/icon/bag.png")));
		lblNewLabel.setBounds(207, 60, 80, 80);
		pntotalnv.add(lblNewLabel);
		
		lbtotalemployees = new JLabel("0");
		lbtotalemployees.setForeground(new Color(196, 39, 39));
		lbtotalemployees.setBackground(new Color(196, 39, 39));
		lbtotalemployees.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtotalemployees.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalemployees.setBounds(10, 50, 145, 33);
		pntotalnv.add(lbtotalemployees);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_1_1_1.setBounds(165, 50, 50, 33);
		pntotalnv.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_4 = new JLabel("Nhân viên");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setForeground(new Color(196, 39, 39));
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_4.setBackground(new Color(196, 39, 39));
		lblNewLabel_4_4.setBounds(10, 126, 145, 33);
		pntotalnv.add(lblNewLabel_4_4);
		
		JPanel pntotalhd = new JPanel();
		pntotalhd.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pntotalhd.setBackground(new Color(255, 255, 255));
		pntotalhd.setLayout(null);
		pntotalhd.setBounds(972, 29, 307, 200);
		panel.add(pntotalhd);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(HomeAdmin.class.getResource("/icon/detail.png")));
		lblNewLabel_3.setBounds(207, 60, 80, 80);
		pntotalhd.add(lblNewLabel_3);
		
		lbtotalfunds = new JLabel("0");
		lbtotalfunds.setForeground(new Color(119, 161, 230));
		lbtotalfunds.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalfunds.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtotalfunds.setBounds(10, 50, 187, 33);
		pntotalhd.add(lbtotalfunds);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Tiền vốn (VNĐ)");
		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_1.setForeground(new Color(119, 161, 230));
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_3_1.setBounds(10, 126, 173, 33);
		pntotalhd.add(lblNewLabel_4_3_1);
		
		JPanel pntotalbuybox = new JPanel();
		pntotalbuybox.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pntotalbuybox.setBackground(new Color(255, 255, 255));
		pntotalbuybox.setLayout(null);
		pntotalbuybox.setBounds(655, 29, 307, 200);
		panel.add(pntotalbuybox);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(HomeAdmin.class.getResource("/icon/box.png")));
		lblNewLabel_2.setBounds(207, 60, 80, 80);
		pntotalbuybox.add(lblNewLabel_2);
		
		lballbox = new JLabel("0");
		lballbox.setForeground(new Color(252, 186, 127));
		lballbox.setHorizontalAlignment(SwingConstants.CENTER);
		lballbox.setFont(new Font("Tahoma", Font.BOLD, 24));
		lballbox.setBounds(10, 50, 145, 33);
		pntotalbuybox.add(lballbox);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Box tồn kho");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setForeground(new Color(252, 186, 127));
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_2_1.setBounds(10, 126, 145, 33);
		pntotalbuybox.add(lblNewLabel_4_2_1);
		
		JPanel pntotalallprice = new JPanel();
		pntotalallprice.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pntotalallprice.setBackground(new Color(255, 255, 255));
		pntotalallprice.setLayout(null);
		pntotalallprice.setBounds(338, 29, 307, 200);
		panel.add(pntotalallprice);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HomeAdmin.class.getResource("/icon/moneyy.png")));
		lblNewLabel_1.setBounds(207, 60, 80, 80);
		pntotalallprice.add(lblNewLabel_1);
		
		lbtotalalldt = new JLabel("0");
		lbtotalalldt.setForeground(new Color(15, 169, 96));
		lbtotalalldt.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalalldt.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtotalalldt.setBounds(10, 50, 187, 33);
		pntotalallprice.add(lbtotalalldt);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Doanh thu (VNĐ)");
		lblNewLabel_4_1_1.setForeground(new Color(15, 169, 96));
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_1_1.setBounds(22, 126, 175, 33);
		pntotalallprice.add(lblNewLabel_4_1_1);
		
		JPanel pnpiechart = new JPanel();
		pnpiechart.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pnpiechart.setBackground(new Color(255, 255, 255));
		pnpiechart.setBounds(21, 251, 757, 400);
		panel.add(pnpiechart);
		pnpiechart.setLayout(null);
		
		pnchartcycle = new JPanel();
		pnchartcycle.setBounds(10, 11, 737, 378);
		pnpiechart.add(pnchartcycle);
		
		JPanel pnhistorymoneyday = new JPanel();
		pnhistorymoneyday.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pnhistorymoneyday.setBackground(Color.WHITE);
		pnhistorymoneyday.setBounds(788, 251, 491, 640);
		panel.add(pnhistorymoneyday);
		pnhistorymoneyday.setLayout(null);
		
		table = new JTable();
		table.setForeground(new Color(15, 169, 96));
		table.setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.setRowHeight(40);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Ti\u1EC1n l\u1EDDi", "Ng\u00E0y"
			}
		));
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 64, 471, 565);
		pnhistorymoneyday.add(scrollPane_1);
		
		JLabel lblNewLabel_5 = new JLabel("Danh mục lịch sử lợi nhuận");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 471, 42);
		pnhistorymoneyday.add(lblNewLabel_5);
		
		JPanel pnprofit = new JPanel();
		pnprofit.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pnprofit.setBackground(Color.WHITE);
		pnprofit.setBounds(21, 662, 757, 229);
		panel.add(pnprofit);
		pnprofit.setLayout(null);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Chi tiết thu lời");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_1_1.setBounds(146, 11, 471, 42);
		pnprofit.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("Lợi nhuận năm 2025:");
		lblNewLabel_5_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_5_1_1_1_2.setBounds(35, 87, 269, 35);
		pnprofit.add(lblNewLabel_5_1_1_1_2);
		
		lbtotalprofit = new JLabel("+ 0 (VNĐ)");
		lbtotalprofit.setHorizontalAlignment(SwingConstants.LEFT);
		lbtotalprofit.setForeground(new Color(15, 169, 96));
		lbtotalprofit.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtotalprofit.setBounds(377, 85, 348, 33);
		pnprofit.add(lbtotalprofit);
		
		JLabel lblNewLabel_5_1_1_1_2_1 = new JLabel("Số hoá đơn mua hàng:");
		lblNewLabel_5_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_1_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_5_1_1_1_2_1.setBounds(35, 151, 269, 35);
		pnprofit.add(lblNewLabel_5_1_1_1_2_1);
		
		lbtotaldetail = new JLabel("+ 0 (Hoá đơn)");
		lbtotaldetail.setHorizontalAlignment(SwingConstants.LEFT);
		lbtotaldetail.setForeground(new Color(255, 128, 0));
		lbtotaldetail.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtotaldetail.setBounds(377, 149, 348, 33);
		pnprofit.add(lbtotaldetail);
		
		pnchart = new JPanel();
		pnchart.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pnchart.setBackground(Color.WHITE);
		pnchart.setBounds(21, 975, 1260, 535);
		panel.add(pnchart);
		pnchart.setLayout(null);
		
		JPanel pn_btn = new JPanel();
		pn_btn.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pn_btn.setBackground(new Color(255, 255, 255));
		pn_btn.setBounds(21, 902, 1258, 62);
		panel.add(pn_btn);
		pn_btn.setLayout(null);
		
		btnexportweek = new JButton("Tuần");
		btnexportweek.setBackground(new Color(255, 255, 255));
		btnexportweek.setForeground(new Color(0, 128, 64));
		btnexportweek.setFont(new Font("Arial", Font.BOLD, 20));
		btnexportweek.setBounds(410, 11, 244, 40);
		pn_btn.add(btnexportweek);
		
		JLabel lblNewLabel_4 = new JLabel("Xuất Excel thông tin lợi nhuận theo:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_4.setBounds(10, 11, 373, 40);
		pn_btn.add(lblNewLabel_4);
		
		btnexportmonth = new JButton("Tháng");
		btnexportmonth.setBackground(new Color(255, 255, 255));
		btnexportmonth.setForeground(new Color(0, 128, 64));
		btnexportmonth.setFont(new Font("Arial", Font.BOLD, 20));
		btnexportmonth.setBounds(692, 11, 244, 40);
		pn_btn.add(btnexportmonth);
		
		btnexportyear = new JButton("Năm");
		btnexportyear.setBackground(new Color(255, 255, 255));
		btnexportyear.setForeground(new Color(0, 128, 64));
		btnexportyear.setFont(new Font("Arial", Font.BOLD, 20));
		btnexportyear.setBounds(979, 11, 244, 40);
		pn_btn.add(btnexportyear);
		init();
	}
	public JLabel getLbtotaldetail() {
		return lbtotaldetail;
	}
	public JLabel getLbtotalprofit() {
		return lbtotalprofit;
	}
	public JLabel getLbtotalemployees() {
		return lbtotalemployees;
	}
	public JLabel getLbtotalalldt() {
		return lbtotalalldt;
	}
	public JLabel getLballbox() {
		return lballbox;
	}
	public JLabel getLbtotalfunds() {
		return lbtotalfunds;
	}
	public JTable getTable() {
		return table;
	}
	public JPanel getPnchartcycle() {
		return pnchartcycle;
	}
	public JPanel getPnchart() {
		return pnchart;
	}
	public JButton getBtnexportweek() {
		return btnexportweek;
	}
	public JButton getBtnexportmonth() {
		return btnexportmonth;
	}
	public JButton getBtnexportyear() {
		return btnexportyear;
	}
}
