package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Controllers.WarehouseTransferController;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Warehouse extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfsearch1;
	private JTextField tfqty;
	private JButton btnaccept;
	private JComboBox cblocationpd;
	private JTable table1;
	private JTable table2;
	private JTextField tfsearch2;
	private JLabel lbadd;
	private JLabel lbsubtract;
	private JTextField tfid;
	private JButton btnNewButton;
	private JLabel lbwhere;
	private JButton btntransderwarehousep;
	private JButton btndelletet;

	private void init() {
		new WarehouseTransferController(this);
	}

	public Warehouse() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(183, 228, 249));
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 917);
		add(panel);
		panel.setLayout(null);

		JPanel pnbox = new JPanel();
		pnbox.setLayout(null);
		pnbox.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnbox.setBackground(new Color(136, 190, 240));
		pnbox.setBounds(10, 11, 1290, 380);
		panel.add(pnbox);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(622, 19, 134, 30);
		pnbox.add(lblNewLabel_1_2_1_1_1);

		tfsearch1 = new JTextField();
		tfsearch1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearch1.setColumns(10);
		tfsearch1.setBounds(766, 17, 455, 42);
		pnbox.add(tfsearch1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Warehouse.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(1231, 17, 49, 42);
		pnbox.add(lblNewLabel);
		table1 = new JTable();
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table1.setRowHeight(40);
		table1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, }, new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng" }));
		table1.getColumnModel().getColumn(0).setPreferredWidth(180);
		table1.getColumnModel().getColumn(1).setPreferredWidth(500);
		table1.getColumnModel().getColumn(2).setPreferredWidth(100);

		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 70, 1270, 300);
		pnbox.add(scrollPane);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sản phẩm trong kho");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_1_1.setBounds(161, 10, 395, 50);
		pnbox.add(lblNewLabel_1_1_1_1_1);

		JPanel pnbox2 = new JPanel();
		pnbox2.setLayout(null);
		pnbox2.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnbox2.setBackground(new Color(136, 190, 240));
		pnbox2.setBounds(10, 530, 1290, 380);
		panel.add(pnbox2);
		table2 = new JTable();
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table2.setRowHeight(40);
		table2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "STT", "Chi nh\u00E1nh", "\u0110\u1ECBa ch\u1EC9 chi nh\u00E1nh",
						"M\u00E3 s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng" }));
		table2.getColumnModel().getColumn(0).setPreferredWidth(100);
		table2.getColumnModel().getColumn(1).setPreferredWidth(200);
		table2.getColumnModel().getColumn(2).setPreferredWidth(550);
		table2.getColumnModel().getColumn(3).setPreferredWidth(300);
		table2.getColumnModel().getColumn(4).setPreferredWidth(100);
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 69, 1270, 300);
		pnbox2.add(scrollPane_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("SẢN PHẨM TRONG TỪNG CHI NHÁNH");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1_1_1_1_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 11, 551, 50);
		pnbox2.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1_1.setBounds(622, 13, 134, 30);
		pnbox2.add(lblNewLabel_1_2_1_1_1_1);

		tfsearch2 = new JTextField();
		tfsearch2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearch2.setColumns(10);
		tfsearch2.setBounds(766, 11, 455, 42);
		pnbox2.add(tfsearch2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Warehouse.class.getResource("/icon/search.png")));
		lblNewLabel_2.setBounds(1231, 11, 49, 42);
		pnbox2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(136, 190, 240));
		panel_1.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		panel_1.setBounds(10, 395, 1290, 124);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Chọn chi nhánh:");
		lblNewLabel_1_1_1_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_1.setBounds(20, 11, 201, 30);
		panel_1.add(lblNewLabel_1_1_1_1);

		cblocationpd = new JComboBox();
		cblocationpd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cblocationpd.setFont(new Font("Segoe UI", Font.BOLD, 25));
		cblocationpd.setBackground(Color.WHITE);
		cblocationpd.setBounds(20, 56, 275, 42);
		panel_1.add(cblocationpd);

		tfqty = new JTextField();
		tfqty.setAlignmentX(0.0f);
		tfqty.setHorizontalAlignment(SwingConstants.CENTER);
		tfqty.setText("0");
		tfqty.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfqty.setColumns(10);
		tfqty.setBounds(669, 58, 70, 50);
		panel_1.add(tfqty);

		JLabel lblNewLabel_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1_1.setBounds(640, 11, 119, 30);
		panel_1.add(lblNewLabel_1_1);

		lbadd = new JLabel("+");
		lbadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbadd.setVerticalAlignment(SwingConstants.BOTTOM);
		lbadd.setHorizontalTextPosition(SwingConstants.LEADING);
		lbadd.setForeground(new Color(74, 142, 225));
		lbadd.setBackground(new Color(36, 118, 217));
		lbadd.setHorizontalAlignment(SwingConstants.CENTER);
		lbadd.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lbadd.setBounds(605, 58, 50, 50);
		panel_1.add(lbadd);

		lbsubtract = new JLabel("-");
		lbsubtract.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbsubtract.setVerticalTextPosition(SwingConstants.TOP);
		lbsubtract.setVerticalAlignment(SwingConstants.BOTTOM);
		lbsubtract.setHorizontalTextPosition(SwingConstants.LEADING);
		lbsubtract.setHorizontalAlignment(SwingConstants.CENTER);
		lbsubtract.setForeground(new Color(74, 142, 225));
		lbsubtract.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lbsubtract.setBackground(new Color(36, 118, 217));
		lbsubtract.setBounds(753, 58, 50, 50);
		panel_1.add(lbsubtract);

		btnaccept = new JButton("Chuyển vào chi nhánh");
		btnaccept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnaccept.setForeground(new Color(52, 219, 4));
		btnaccept.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnaccept.setBackground(new Color(255, 255, 255));
		btnaccept.setBounds(806, 11, 220, 42);
		panel_1.add(btnaccept);

		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setForeground(new Color(74, 142, 225));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBackground(new Color(36, 118, 217));
		lblNewLabel_1.setBounds(301, 15, 160, 30);
		panel_1.add(lblNewLabel_1);

		tfid = new JTextField();
		tfid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfid.setColumns(10);
		tfid.setBounds(301, 56, 294, 42);
		panel_1.add(tfid);

		btntransderwarehousep = new JButton("Chuyển về kho");
		btntransderwarehousep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btntransderwarehousep.setForeground(new Color(255, 128, 0));
		btntransderwarehousep.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btntransderwarehousep.setBackground(new Color(255, 255, 255));
		btntransderwarehousep.setBounds(806, 72, 220, 42);
		panel_1.add(btntransderwarehousep);

		lbwhere = new JLabel("########");
		lbwhere.setForeground(new Color(255, 255, 255));
		lbwhere.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbwhere.setBackground(Color.BLACK);
		lbwhere.setBounds(471, 15, 125, 30);
		panel_1.add(lbwhere);

		btnNewButton = new JButton("Làm mới");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(202, 202, 0));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(1036, 11, 220, 40);
		panel_1.add(btnNewButton);

		btndelletet = new JButton("Xoá SP chi nhánh");
		btndelletet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndelletet.setForeground(new Color(225, 26, 26));
		btndelletet.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btndelletet.setBackground(new Color(255, 255, 255));
		btndelletet.setBounds(1036, 72, 220, 42);
		panel_1.add(btndelletet);
		init();
	}

	public JTextField getTfsearch1() {
		return tfsearch1;
	}

	public void setTfsearch1(JTextField tfsearch1) {
		this.tfsearch1 = tfsearch1;
	}

	public void setTfqty(JTextField tfqty) {
		this.tfqty = tfqty;
	}

	public void setBtnaccept(JButton btnaccept) {
		this.btnaccept = btnaccept;
	}

	public void setCblocationpd(JComboBox cblocationpd) {
		this.cblocationpd = cblocationpd;
	}

	public void setTable1(JTable table1) {
		this.table1 = table1;
	}

	public void setTable2(JTable table2) {
		this.table2 = table2;
	}

	public void setTfsearch2(JTextField tfsearch2) {
		this.tfsearch2 = tfsearch2;
	}

	public void setLbadd(JLabel lbadd) {
		this.lbadd = lbadd;
	}

	public void setLbsubtract(JLabel lbsubtract) {
		this.lbsubtract = lbsubtract;
	}

	public JButton getBtnaccept() {
		return btnaccept;
	}

	public JTextField getTfsearch() {
		return tfsearch1;
	}

	public JComboBox getCblocationpd() {
		return cblocationpd;
	}

	public JTextField getTfqty() {
		return tfqty;
	}

	public JLabel getLbadd() {
		return lbadd;
	}

	public JLabel getLbsubtract() {
		return lbsubtract;
	}

	public JTextField getTfsearch2() {
		return tfsearch2;
	}

	public JTable getTable1() {
		return table1;
	}

	public JTable getTable2() {
		return table2;
	}

	public JTextField getTfid() {
		return tfid;
	}

	public JButton getBtnreset() {
		return btnNewButton;
	}

	public JLabel getLbwhere() {
		return lbwhere;
	}

	public JButton getBtntransderwarehousep() {
		return btntransderwarehousep;
	}
	public JButton getBtndelletet() {
		return btndelletet;
	}
}
