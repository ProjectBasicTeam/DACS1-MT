package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;

public class Purchase extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tftotalprice;
	private JTextField tfphonep;
	private JTextField tfidhdp;
	private JTextField tfqtyp;
	private JTextField tfsearchp;
	private JTable table1, table2;
	private JLabel lbdayp;
	private JLabel lbtimep;
	private JButton btnbuyp;
	private JButton btndeleteitemp;
	private JButton btnresetp;
	private JLabel lbadd;
	private JLabel lbsubtract;
	private JPanel pnclock;
	private JTextField tfname;
	private JTextField tfqty;
	private JTextField tfprice;
	private JTextField tfid;
	private JButton btnaddintemp;
	private JLabel lbcheck;
	private int totalprice;
	
	
	public Purchase() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnentry = new JPanel();
		pnentry.setLayout(null);
		pnentry.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		pnentry.setBackground(new Color(136, 190, 240));
		pnentry.setBounds(969, 11, 330, 924);
		panel.add(pnentry);
		
		btnbuyp = new JButton("Thanh toán");
		btnbuyp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnbuyp.setForeground(new Color(52, 219, 4));
		btnbuyp.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnbuyp.setBackground(new Color(255, 255, 255));
		btnbuyp.setBounds(20, 697, 290, 50);
		pnentry.add(btnbuyp);
		
		btndeleteitemp = new JButton("Xoá món đồ");
		btndeleteitemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndeleteitemp.setForeground(new Color(225, 26, 26));
		btndeleteitemp.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btndeleteitemp.setBackground(new Color(255, 255, 255));
		btndeleteitemp.setBounds(20, 771, 290, 50);
		pnentry.add(btndeleteitemp);
		
		btnresetp = new JButton("Làm mới");
		btnresetp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnresetp.setForeground(new Color(202, 202, 0));
		btnresetp.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnresetp.setBackground(new Color(255, 255, 255));
		btnresetp.setBounds(20, 845, 290, 50);
		pnentry.add(btnresetp);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tổng số tiền");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2.setBounds(20, 576, 290, 41);
		pnentry.add(lblNewLabel_1_2_2);
		
		tftotalprice = new JTextField();
		tftotalprice.setHorizontalAlignment(SwingConstants.CENTER);
		tftotalprice.setText("0");
		tftotalprice.setFont(new Font("Segoe UI", Font.BOLD, 30));
		tftotalprice.setColumns(10);
		tftotalprice.setBounds(20, 628, 290, 42);
		pnentry.add(tftotalprice);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_1.setBounds(20, 456, 290, 41);
		pnentry.add(lblNewLabel_1_2_2_1);
		
		tfphonep = new JTextField();
		tfphonep.setHorizontalAlignment(SwingConstants.LEFT);
		tfphonep.setFont(new Font("Segoe UI", Font.BOLD, 24));
		tfphonep.setColumns(10);
		tfphonep.setBounds(20, 508, 290, 42);
		pnentry.add(tfphonep);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Mã hoá đơn");
		lblNewLabel_1_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2.setBounds(20, 111, 290, 41);
		pnentry.add(lblNewLabel_1_2_2_2);
		
		tfidhdp = new JTextField();
		tfidhdp.setText("########");
		tfidhdp.setHorizontalAlignment(SwingConstants.CENTER);
		tfidhdp.setFont(new Font("Segoe UI", Font.BOLD, 26));
		tfidhdp.setColumns(10);
		tfidhdp.setBounds(20, 163, 290, 42);
		pnentry.add(tfidhdp);
		
		lbadd = new JLabel("+");
		lbadd.setVerticalAlignment(SwingConstants.BOTTOM);
		lbadd.setHorizontalTextPosition(SwingConstants.LEADING);
		lbadd.setHorizontalAlignment(SwingConstants.CENTER);
		lbadd.setForeground(new Color(36, 118, 217));
		lbadd.setFont(new Font("Segoe UI", Font.BOLD, 60));
		lbadd.setBackground(new Color(80, 118, 135));
		lbadd.setBounds(20, 261, 80, 80);
		pnentry.add(lbadd);
		
		tfqtyp = new JTextField();
		tfqtyp.setText("0");
		tfqtyp.setHorizontalAlignment(SwingConstants.CENTER);
		tfqtyp.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfqtyp.setColumns(10);
		tfqtyp.setAlignmentX(0.0f);
		tfqtyp.setBounds(110, 282, 110, 50);
		pnentry.add(tfqtyp);
		
		lbsubtract = new JLabel("-");
		lbsubtract.setVerticalTextPosition(SwingConstants.TOP);
		lbsubtract.setVerticalAlignment(SwingConstants.BOTTOM);
		lbsubtract.setHorizontalTextPosition(SwingConstants.LEADING);
		lbsubtract.setHorizontalAlignment(SwingConstants.CENTER);
		lbsubtract.setForeground(new Color(36, 118, 217));
		lbsubtract.setFont(new Font("Segoe UI", Font.BOLD, 60));
		lbsubtract.setBackground(new Color(80, 118, 135));
		lbsubtract.setBounds(230, 261, 80, 80);
		pnentry.add(lbsubtract);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Số lượng");
		lblNewLabel_1_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_1.setBounds(20, 216, 290, 41);
		pnentry.add(lblNewLabel_1_2_2_2_1);
		
		btnaddintemp = new JButton("Thêm");
		btnaddintemp.setForeground(new Color(121, 215, 190));
		btnaddintemp.setBackground(new Color(255, 255, 255));
		btnaddintemp.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnaddintemp.setBounds(75, 369, 180, 50);
		pnentry.add(btnaddintemp);
		
		JLabel lblNewLabel_1_2_2_2_2 = new JLabel("Bảng điều khiển");
		lblNewLabel_1_2_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2.setBounds(20, 11, 290, 57);
		pnentry.add(lblNewLabel_1_2_2_2_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBackground(new Color(136, 190, 240));
		panel_1.setBounds(10, 11, 949, 470);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2_2_2_2_3 = new JLabel("Chọn món đồ");
		lblNewLabel_1_2_2_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_3.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_3.setBounds(10, 11, 335, 45);
		panel_1.add(lblNewLabel_1_2_2_2_2_3);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(389, 11, 134, 30);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		tfsearchp = new JTextField();
		tfsearchp.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearchp.setColumns(10);
		tfsearchp.setBounds(533, 11, 347, 42);
		panel_1.add(tfsearchp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Purchase.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(890, 11, 49, 42);
		panel_1.add(lblNewLabel);
		
		table1 = new JTable();
		table1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		table1.setRowHeight(200);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn m\u00F3n h\u00E0ng", "Gi\u00E1 m\u00F3n h\u00E0ng", "H\u00ECnh \u1EA3nh", "S\u1ED1 l\u01B0\u1EE3ng c\u00F2n"
			}
		));
		table1.getColumnModel().getColumn(0).setPreferredWidth(160);
		table1.getColumnModel().getColumn(1).setPreferredWidth(400);
		table1.getColumnModel().getColumn(2).setPreferredWidth(300);
		table1.getColumnModel().getColumn(3).setPreferredWidth(200);
		table1.getColumnModel().getColumn(4).setPreferredWidth(130);
		
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 67, 929, 392);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBackground(new Color(136, 190, 240));
		panel_2.setBounds(10, 492, 949, 443);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2_2_2_2_2 = new JLabel("Dánh sách lựa chọn thanh toán");
		lblNewLabel_1_2_2_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_2.setBounds(10, 11, 511, 57);
		panel_2.add(lblNewLabel_1_2_2_2_2_2);
		
		table2 = new JTable();
		table2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"T\u00EAn m\u00F3n h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(400);
		table2.getColumnModel().getColumn(1).setPreferredWidth(60);
		table2.getColumnModel().getColumn(2).setPreferredWidth(200);
		table2.setRowHeight(30);

		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 74, 682, 358);
		panel_2.add(scrollPane_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(702, 11, 237, 421);
		panel_2.add(panel_3);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(128, 0, 0), 5),  "Th\u1EDDi gian", TitledBorder.CENTER, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD | Font.BOLD, 30) , new Color(255,255,255)));
		panel_3.setBackground(new Color(136, 190, 240));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày/Tháng/Năm");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 311, 221, 44);
		panel_3.add(lblNewLabel_1);
		
		lbdayp = new JLabel("Loading...");
		lbdayp.setForeground(new Color(255, 255, 255));
		lbdayp.setHorizontalAlignment(SwingConstants.CENTER);
		lbdayp.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lbdayp.setBounds(10, 366, 221, 44);
		panel_3.add(lbdayp);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giờ");
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(10, 211, 217, 44);
		panel_3.add(lblNewLabel_1_2);
		
		lbtimep = new JLabel("Loading...");
		lbtimep.setForeground(new Color(255, 255, 255));
		lbtimep.setHorizontalAlignment(SwingConstants.CENTER);
		lbtimep.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lbtimep.setBounds(10, 256, 221, 44);
		panel_3.add(lbtimep);
		
		pnclock = new ClockPanel();
		pnclock.setBounds(41, 42, 160, 160);
		panel_3.add(pnclock);
		
		tfname = new JTextField();
		tfname.setHorizontalAlignment(SwingConstants.LEFT);
		tfname.setFont(new Font("Segoe UI", Font.BOLD, 24));
		tfname.setColumns(10);
		tfname.setBounds(0, 0, 1, 1);
		panel_2.add(tfname);
		
		tfqty = new JTextField();
		tfqty.setHorizontalAlignment(SwingConstants.LEFT);
		tfqty.setFont(new Font("Segoe UI", Font.BOLD, 24));
		tfqty.setColumns(10);
		tfqty.setBounds(1, 0, 1, 1);
		panel_2.add(tfqty);
		
		tfprice = new JTextField();
		tfprice.setHorizontalAlignment(SwingConstants.LEFT);
		tfprice.setFont(new Font("Segoe UI", Font.BOLD, 24));
		tfprice.setColumns(10);
		tfprice.setBounds(2, 0, 1, 1);
		panel_2.add(tfprice);
		
		tfid = new JTextField();
		tfid.setHorizontalAlignment(SwingConstants.LEFT);
		tfid.setFont(new Font("Segoe UI", Font.BOLD, 24));
		tfid.setColumns(10);
		tfid.setBounds(3, 0, 1, 1);
		panel_2.add(tfid);
		
		lbcheck = new JLabel("");
		lbcheck.setBounds(0, 0, 1, 1);
		panel_2.add(lbcheck);

	}
	
	public void setTftotalprice(JTextField tftotalprice) {
		this.tftotalprice = tftotalprice;
	}

	public void setTfphonep(JTextField tfphonep) {
		this.tfphonep = tfphonep;
	}

	public void setTfidhdp(JTextField tfidhdp) {
		this.tfidhdp = tfidhdp;
	}

	public void setTfqtyp(JTextField tfqtyp) {
		this.tfqtyp = tfqtyp;
	}

	public void setTfsearchp(JTextField tfsearchp) {
		this.tfsearchp = tfsearchp;
	}

	public void setTable1(JTable table1) {
		this.table1 = table1;
	}

	public void setTable2(JTable table2) {
		this.table2 = table2;
	}

	public void setLbdayp(JLabel lbdayp) {
		this.lbdayp = lbdayp;
	}

	public void setLbtimep(JLabel lbtimep) {
		this.lbtimep = lbtimep;
	}

	public void setBtnbuyp(JButton btnbuyp) {
		this.btnbuyp = btnbuyp;
	}

	public void setBtndeleteitemp(JButton btndeleteitemp) {
		this.btndeleteitemp = btndeleteitemp;
	}

	public void setBtnresetp(JButton btnresetp) {
		this.btnresetp = btnresetp;
	}

	public JTable getTable1() {
		return table1;
	}
	public JTable getTable2() {
		return table2;
	}
	public JLabel getLbdayp() {
		return lbdayp;
	}
	public JLabel getLbtimep() {
		return lbtimep;
	}
	public JTextField getTfidhdp() {
		return tfidhdp;
	}
	public JTextField getTfqtyp() {
		return tfqtyp;
	}
	public JTextField getTfsearchp() {
		return tfsearchp;
	}
	public JTextField getTfphonep() {
		return tfphonep;
	}
	public JTextField getTftotalprice() {
		return tftotalprice;
	}
	public JButton getBtnbuyp() {
		return btnbuyp;
	}
	public JButton getBtndeleteitemp() {
		return btndeleteitemp;
	}
	public JButton getBtnresetp() {
		return btnresetp;
	}
	public JLabel getLbadd() {
		return lbadd;
	}
	public JLabel getLbsubtract() {
		return lbsubtract;
	}
	public JPanel getPnclock() {
		return pnclock;
	}
	public JTextField getTfname() {
		return tfname;
	}
	public JTextField getTfqty() {
		return tfqty;
	}
	public JTextField getTfprice() {
		return tfprice;
	}
	public JTextField getTfid() {
		return tfid;
	}
	public JButton getBtnaddintemp() {
		return btnaddintemp;
	}
	public JLabel getLbcheck() {
		return lbcheck;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
}
