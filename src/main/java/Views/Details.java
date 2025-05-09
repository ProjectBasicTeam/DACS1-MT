package Views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Models.BuyItemM;
import Services.DetailsManagers;
import java.awt.Cursor;

public class Details extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfsearchd;
	private JTextField tfidhdd;
	private JTextField tfdayd;
	private JTextField tftotalpriced;
	private JTextField tfphoned;
	private JTable table1, table2;
	private JButton btnacceptd;
	private JButton btnexportd;
	private JButton btndeleled;
	private JButton btnbackd;
	private JTextField tftimed;
	private JTextField tfqty;
	private DetailsManagers serd;
	private String[] value = new String[7];
	public void LoadDataB() {
		ArrayList<BuyItemM> list = serd.loadBuy();

		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.setRowCount(0);

		for (BuyItemM e : list) {
			model.addRow(new Object[] {e.getStt(), e.getName(), e.getQty(), e.getPrice(), e.getTotalprice()

			});
		}
		table1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table1.getColumnModel().getColumn(1).setPreferredWidth(353);
		table1.getColumnModel().getColumn(2).setPreferredWidth(60);
		table1.getColumnModel().getColumn(3).setPreferredWidth(150);
		table1.getColumnModel().getColumn(4).setPreferredWidth(180);
		
	}
	public void reloadvalue() {
		value = serd.getInfoBuyValue();
		tfidhdd.setText(value[1]);
		tftotalpriced.setText(value[2]);
		tfqty.setText(value[3]);
		tfphoned.setText(value[4]);
		tftimed.setText(value[5]);
		tfdayd.setText(value[6]);
	}
	private void init() {
		this.serd = DetailsManagers.getInstance();
	}
	
	public Details() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1309, 946);
		panel.setBackground(new Color(183, 228, 249));
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBackground(new Color(136, 190, 240));
		panel_2.setBounds(10, 11, 633, 924);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1_2_2_2_2_2 = new JLabel("Hoá đơn");
		lblNewLabel_1_2_2_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_2.setBounds(62, 11, 511, 57);
		panel_2.add(lblNewLabel_1_2_2_2_2_2);
		
		table1 = new JTable();
		table1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		table1.setRowHeight(40);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "T\u00EAn m\u00F3n \u0111\u1ED3", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table1.getColumnModel().getColumn(1).setPreferredWidth(353);
		table1.getColumnModel().getColumn(2).setPreferredWidth(60);
		table1.getColumnModel().getColumn(3).setPreferredWidth(150);
		table1.getColumnModel().getColumn(4).setPreferredWidth(180);
		
		JScrollPane scrollPane_1 = new JScrollPane(table1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 74, 613, 497);
		panel_2.add(scrollPane_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã hoá đơn");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(10, 582, 191, 30);
		panel_2.add(lblNewLabel_1_1);
		
		tfidhdd = new JTextField();
		tfidhdd.setBackground(new Color(255, 255, 255));
		tfidhdd.setEditable(false);
		tfidhdd.setHorizontalAlignment(SwingConstants.CENTER);
		tfidhdd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfidhdd.setColumns(10);
		tfidhdd.setBounds(10, 623, 200, 42);
		panel_2.add(tfidhdd);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày mua");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(220, 676, 191, 30);
		panel_2.add(lblNewLabel_1_1_1);
		
		tfdayd = new JTextField();
		tfdayd.setHorizontalAlignment(SwingConstants.CENTER);
		tfdayd.setBackground(new Color(255, 255, 255));
		tfdayd.setEditable(false);
		tfdayd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfdayd.setColumns(10);
		tfdayd.setBounds(217, 717, 200, 42);
		panel_2.add(tfdayd);
		
		btnacceptd = new JButton("Xác nhận hoá đơn");
		btnacceptd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnacceptd.setForeground(new Color(52, 219, 4));
		btnacceptd.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnacceptd.setBackground(new Color(255, 255, 255));
		btnacceptd.setBounds(20, 789, 250, 50);
		panel_2.add(btnacceptd);
		
		btndeleled = new JButton("Xoá hoá đơn");
		btndeleled.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndeleled.setForeground(new Color(225, 26, 26));
		btndeleled.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btndeleled.setBackground(new Color(255, 255, 255));
		btndeleled.setBounds(20, 863, 250, 50);
		panel_2.add(btndeleled);
		
		btnexportd = new JButton("Xuất hoá đơn");
		btnexportd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexportd.setForeground(new Color(255, 128, 0));
		btnexportd.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnexportd.setBackground(new Color(255, 255, 255));
		btnexportd.setBounds(337, 789, 250, 50);
		panel_2.add(btnexportd);
		
		btnbackd = new JButton("Quay về");
		btnbackd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnbackd.setForeground(new Color(202, 202, 0));
		btnbackd.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnbackd.setBackground(new Color(255, 255, 255));
		btnbackd.setBounds(337, 863, 250, 50);
		panel_2.add(btnbackd);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng số tiền");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_1_2.setBounds(217, 582, 191, 30);
		panel_2.add(lblNewLabel_1_1_2);
		
		tftotalpriced = new JTextField();
		tftotalpriced.setBackground(new Color(255, 255, 255));
		tftotalpriced.setEditable(false);
		tftotalpriced.setHorizontalAlignment(SwingConstants.CENTER);
		tftotalpriced.setText("0");
		tftotalpriced.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tftotalpriced.setColumns(10);
		tftotalpriced.setBounds(217, 623, 200, 42);
		panel_2.add(tftotalpriced);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SĐT của khách");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1_1.setBounds(423, 676, 200, 30);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		tfphoned = new JTextField();
		tfphoned.setHorizontalAlignment(SwingConstants.CENTER);
		tfphoned.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfphoned.setColumns(10);
		tfphoned.setBounds(423, 717, 200, 42);
		panel_2.add(tfphoned);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Thời gian (giờ)");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_1_3.setBounds(10, 676, 191, 30);
		panel_2.add(lblNewLabel_1_1_3);
		
		tftimed = new JTextField();
		tftimed.setBackground(new Color(255, 255, 255));
		tftimed.setEditable(false);
		tftimed.setHorizontalAlignment(SwingConstants.CENTER);
		tftimed.setText("00:00");
		tftimed.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tftimed.setColumns(10);
		tftimed.setBounds(10, 717, 200, 42);
		panel_2.add(tftimed);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Tổng số lượng");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_1_4.setBounds(423, 582, 191, 30);
		panel_2.add(lblNewLabel_1_1_4);
		
		tfqty = new JTextField();
		tfqty.setBackground(new Color(255, 255, 255));
		tfqty.setEditable(false);
		tfqty.setHorizontalAlignment(SwingConstants.CENTER);
		tfqty.setText("0");
		tfqty.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfqty.setColumns(10);
		tfqty.setBounds(423, 623, 200, 42);
		panel_2.add(tfqty);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2_1.setBackground(new Color(136, 190, 240));
		panel_2_1.setBounds(653, 11, 646, 924);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_1_2_2_2_2_2_1 = new JLabel("Lịch sử hoá đơn đã thanh toán");
		lblNewLabel_1_2_2_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_2_1.setBounds(10, 11, 626, 57);
		panel_2_1.add(lblNewLabel_1_2_2_2_2_2_1);
		
		table2 = new JTable();
		table2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table2.setRowHeight(40);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 l\u1ECBch s\u1EED thanh to\u00E1n", "M\u00E3 ho\u00E1 \u0111\u01A1n", "T\u1ED5ng ti\u1EC1n \u0111\u00E3 b\u00E1n", "T\u1ED5ng s\u1ED1 l\u01B0\u1EE3ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i kh\u00E1ch h\u00E0ng", "Th\u1EDDi gian (gi\u1EDD)", "Ng\u00E0y mua"
			}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(150);
		table2.getColumnModel().getColumn(1).setPreferredWidth(200);
		table2.getColumnModel().getColumn(2).setPreferredWidth(250);
		table2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table2.getColumnModel().getColumn(4).setPreferredWidth(200);
		table2.getColumnModel().getColumn(5).setPreferredWidth(240);
		table2.getColumnModel().getColumn(6).setPreferredWidth(180);
		
		JScrollPane scrollPane_1_1 = new JScrollPane(table2);
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setBounds(10, 124, 623, 789);
		panel_2_1.add(scrollPane_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(86, 79, 134, 30);
		panel_2_1.add(lblNewLabel_1_2_1_1_1);
		
		tfsearchd = new JTextField();
		tfsearchd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearchd.setColumns(10);
		tfsearchd.setBounds(230, 79, 347, 42);
		panel_2_1.add(tfsearchd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Details.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(587, 79, 49, 42);
		panel_2_1.add(lblNewLabel);
		init();

	}
	
	public void setTfsearchd(JTextField tfsearchd) {
		this.tfsearchd = tfsearchd;
	}

	public void setTfidhdd(JTextField tfidhdd) {
		this.tfidhdd = tfidhdd;
	}

	public void setTfdayd(JTextField tfdayd) {
		this.tfdayd = tfdayd;
	}

	public void setTftotalpriced(JTextField tftotalpriced) {
		this.tftotalpriced = tftotalpriced;
	}

	public void setTfphoned(JTextField tfphoned) {
		this.tfphoned = tfphoned;
	}

	public void setTable1(JTable table1) {
		this.table1 = table1;
	}

	public void setTable2(JTable table2) {
		this.table2 = table2;
	}

	public void setBtnacceptd(JButton btnacceptd) {
		this.btnacceptd = btnacceptd;
	}

	public void setBtnexportd(JButton btnexportd) {
		this.btnexportd = btnexportd;
	}

	public void setBtndeleled(JButton btndeleled) {
		this.btndeleled = btndeleled;
	}

	public void setBtnbackd(JButton btnbackd) {
		this.btnbackd = btnbackd;
	}

	public JTextField getTftotalpriced() {
		return tftotalpriced;
	}
	public JTextField getTfphoned() {
		return tfphoned;
	}
	public JTextField getTfidhdd() {
		return tfidhdd;
	}
	public JTextField getTfdayd() {
		return tfdayd;
	}
	public JButton getBtnacceptd() {
		return btnacceptd;
	}
	public JButton getBtnexportd() {
		return btnexportd;
	}
	public JButton getBtndeleled() {
		return btndeleled;
	}
	public JButton getBtnbackd() {
		return btnbackd;
	}
	public JTable getTable2() {
		return table2;
	}
	public JTable getTable1() {
		return table1;
	}
	public JTextField getTfsearchd() {
		return tfsearchd;
	}
	public JTextField getTfqty() {
		return tfqty;
	}
	public JTextField getTftimed() {
		return tftimed;
	}
}
