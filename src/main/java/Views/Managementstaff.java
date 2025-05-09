package Views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Controllers.AccountManagersController;

import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class Managementstaff extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JTextField tfidql;
	private JTextField tfnameql;
	private JTextField tfpasswordql;
	private JTextField tflocationql;
	private JTextField tfphoneql;
	private JTextField tfsearch;
	private JButton btnedit;
	private JButton btnadd;
	private JScrollPane scrollPane;
	private JButton btnreset;
	private JButton btndelete;
	private JTextField tfadressql;
	private DefaultTableModel tablemodel;
	private int rowIndex;
	private JLabel lblNewLabel_1_2_1_3;
	private JComboBox cbx;
	
	
	
	
	private void init() {
		new AccountManagersController(this);
	}
	public Managementstaff() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(36, 118, 217));
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 917);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnentry = new JPanel();
		pnentry.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnentry.setBackground(new Color(136, 190, 240));
		pnentry.setBounds(938, 11, 361, 895);
		panel.add(pnentry);
		pnentry.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tài khoảng quản lý:");
		lblNewLabel_1.setBounds(20, 29, 294, 30);
		pnentry.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		tfidql = new JTextField();
		tfidql.setEditable(false);
		tfidql.setBounds(20, 70, 318, 42);
		pnentry.add(tfidql);
		tfidql.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfidql.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên chi nhánh quản lý:");
		lblNewLabel_1_1.setBounds(20, 119, 294, 30);
		pnentry.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		tfnameql = new JTextField();
		tfnameql.setBounds(20, 160, 318, 42);
		pnentry.add(tfnameql);
		tfnameql.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnameql.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_2.setBounds(20, 211, 183, 30);
		pnentry.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		tfpasswordql = new JTextField();
		tfpasswordql.setBounds(20, 252, 318, 42);
		pnentry.add(tfpasswordql);
		tfpasswordql.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfpasswordql.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chi nhánh:");
		lblNewLabel_1_2_1.setBounds(20, 305, 183, 30);
		pnentry.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Số điện thoại chi nhánh:");
		lblNewLabel_1_2_1_1.setBounds(20, 493, 294, 30);
		pnentry.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		tfphoneql = new JTextField();
		tfphoneql.setBounds(20, 534, 318, 42);
		pnentry.add(tfphoneql);
		tfphoneql.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfphoneql.setColumns(10);
		
		tflocationql = new JTextField();
		tflocationql.setBounds(20, 346, 318, 42);
		pnentry.add(tflocationql);
		tflocationql.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tflocationql.setColumns(10);
		
		btnadd = new JButton("Thêm");
		btnadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.setForeground(new Color(52, 219, 4));
		btnadd.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnadd.setBounds(39, 679, 286, 40);
		pnentry.add(btnadd);
		
		btnedit = new JButton("Sửa");
		btnedit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnedit.setBackground(new Color(255, 255, 255));
		btnedit.setForeground(new Color(0, 0, 255));
		btnedit.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnedit.setBounds(39, 730, 286, 40);
		pnentry.add(btnedit);
		
		btndelete = new JButton("Xoá");
		btndelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndelete.setBackground(new Color(255, 255, 255));
		btndelete.setForeground(new Color(225, 26, 26));
		btndelete.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btndelete.setBounds(39, 781, 286, 40);
		pnentry.add(btndelete);
		
		btnreset = new JButton("Làm mới");
		btnreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setForeground(new Color(202, 202, 0));
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnreset.setBounds(39, 832, 286, 40);
		pnentry.add(btnreset);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Địa chỉ chi nhánh:");
		lblNewLabel_1_2_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_2.setBounds(20, 399, 233, 30);
		pnentry.add(lblNewLabel_1_2_1_2);
		
		tfadressql = new JTextField();
		tfadressql.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfadressql.setColumns(10);
		tfadressql.setBounds(20, 440, 318, 42);
		pnentry.add(tfadressql);
		
		lblNewLabel_1_2_1_3 = new JLabel("Vai trò:");
		lblNewLabel_1_2_1_3.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_3.setBounds(20, 583, 294, 30);
		pnentry.add(lblNewLabel_1_2_1_3);
		
		cbx = new JComboBox();
		cbx.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbx.setFont(new Font("Segoe UI", Font.BOLD, 20));
		cbx.setModel(new DefaultComboBoxModel(new String[] {"Quản trị viên", "Quản lý bán hàng"}));
		cbx.setBounds(20, 617, 318, 42);
		pnentry.add(cbx);
		
		JPanel pnbox = new JPanel();
		pnbox.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnbox.setBackground(new Color(136, 190, 240));
		pnbox.setBounds(30, 20, 870, 870);
		panel.add(pnbox);
		pnbox.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(26, 21, 134, 30);
		pnbox.add(lblNewLabel_1_2_1_1_1);
		
		tfsearch = new JTextField();
		tfsearch.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearch.setColumns(10);
		tfsearch.setBounds(190, 21, 594, 42);
		pnbox.add(tfsearch);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Managementstaff.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(794, 21, 49, 42);
		pnbox.add(lblNewLabel);
		
		 
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		table.setRowHeight(40);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 tk qu\u1EA3n l\u00FD", "T\u00EAn chi nh\u00E1nh qu\u1EA3n l\u00FD", "M\u1EADt kh\u1EA9u", "Chi nh\u00E1nh", "\u0110\u1ECBa ch\u1EC9 chi nh\u00E1nh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Vai tr\u00F2"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(4).setPreferredWidth(575);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		table.getColumnModel().getColumn(6).setPreferredWidth(300);
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(10, 90, 850, 769);
		pnbox.add(scrollPane);
		init();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setTfidql(JTextField tfidql) {
		this.tfidql = tfidql;
	}

	public void setTfnameql(JTextField tfnameql) {
		this.tfnameql = tfnameql;
	}

	public void setTfpasswordql(JTextField tfpasswordql) {
		this.tfpasswordql = tfpasswordql;
	}

	public void setTflocationql(JTextField tflocationql) {
		this.tflocationql = tflocationql;
	}

	public void setTfphoneql(JTextField tfphoneql) {
		this.tfphoneql = tfphoneql;
	}

	public void setTfsearch(JTextField tfsearch) {
		this.tfsearch = tfsearch;
	}

	public void setBtnedit(JButton btnedit) {
		this.btnedit = btnedit;
	}

	public void setBtnadd(JButton btnadd) {
		this.btnadd = btnadd;
	}

	public void setBtnreset(JButton btnreset) {
		this.btnreset = btnreset;
	}

	public void setBtndelete(JButton btndelete) {
		this.btndelete = btndelete;
	}

	public JTextField getTflocationql() {
		return tflocationql;
	}
	public JButton getBtnedit() {
		return btnedit;
	}
	public JButton getBtnadd() {
		return btnadd;
	}
	public JTextField getTfsearch() {
		return tfsearch;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTextField getTfnameql() {
		return tfnameql;
	}
	public JTextField getTfpasswordql() {
		return tfpasswordql;
	}
	public JTextField getTfphoneql() {
		return tfphoneql;
	}
	public JButton getBtnreset() {
		return btnreset;
	}
	public JButton getBtndelete() {
		return btndelete;
	}
	public JTextField getTfidql() {
		return tfidql;
	}
	public DefaultTableModel getTablemodel() {
		return tablemodel;
	}
	public JTextField getTfadressql() {
		return tfadressql;
	}
	public void setTfadressql(JTextField tfadressql) {
		this.tfadressql = tfadressql;
	}
	public void setTablemodel(DefaultTableModel tablemodel) {
		this.tablemodel = tablemodel;
	}
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}	
	public JComboBox getCbx() {
		return cbx;
	}
}
