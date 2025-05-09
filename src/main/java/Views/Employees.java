package Views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import Controllers.EmployeesController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class Employees extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfidnv;
	private JTextField tfcccdnv;
	private JTextField tfnamenv;
	private JTextField tflocationnv;
	private JTextField tfphonenv;
	private JTextField tfsearchnv;
	private JDateChooser tfdatenv;
	private JTable table;
	private JComboBox cbworkernv;
	private JComboBox cbgendernv;
	private JButton btnadd;
	private JButton btnedit;
	private JButton btndelete;
	private JButton btnreset;
	private DefaultTableModel tablemodel;

	private void init() {
		new EmployeesController(this);
	}
	public Employees() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(183, 228, 249));
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(-2, 0, 1309, 917);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnentry1 = new JPanel();
		pnentry1.setLayout(null);
		pnentry1.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry1.setBackground(new Color(136, 190, 240));
		pnentry1.setBounds(10, 11, 1289, 364);
		panel.add(pnentry1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(28, 28, 294, 30);
		pnentry1.add(lblNewLabel_1);
		
		tfidnv = new JTextField();
		tfidnv.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfidnv.setColumns(10);
		tfidnv.setBounds(28, 69, 260, 42);
		pnentry1.add(tfidnv);
		
		JLabel lblNewLabel_1_1 = new JLabel("CCCD:");
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(28, 143, 119, 30);
		pnentry1.add(lblNewLabel_1_1);
		
		tfcccdnv = new JTextField();
		tfcccdnv.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfcccdnv.setColumns(10);
		tfcccdnv.setBounds(28, 184, 260, 42);
		pnentry1.add(tfcccdnv);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(298, 28, 294, 30);
		pnentry1.add(lblNewLabel_1_2);
		
		tfnamenv = new JTextField();
		tfnamenv.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnamenv.setColumns(10);
		tfnamenv.setBounds(298, 69, 318, 42);
		pnentry1.add(tfnamenv);
		
		JLabel lblNewLabel_1_3 = new JLabel(" Tên chi nhánh làm việc:");
		lblNewLabel_1_3.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_3.setBounds(298, 258, 294, 30);
		pnentry1.add(lblNewLabel_1_3);
		
		tflocationnv = new JTextField();
		tflocationnv.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tflocationnv.setColumns(10);
		tflocationnv.setBounds(298, 299, 318, 42);
		pnentry1.add(tflocationnv);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số điện thoại:");
		lblNewLabel_1_4.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_4.setBounds(298, 143, 294, 30);
		pnentry1.add(lblNewLabel_1_4);
		
		tfphonenv = new JTextField();
		tfphonenv.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfphonenv.setColumns(10);
		tfphonenv.setBounds(298, 184, 318, 42);
		pnentry1.add(tfphonenv);
		
		btnadd = new JButton("Thêm nhân viên");
		btnadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnadd.setForeground(new Color(52, 219, 4));
		btnadd.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.setBounds(1014, 50, 249, 50);
		pnentry1.add(btnadd);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(28, 258, 119, 30);
		pnentry1.add(lblNewLabel_1_1_1);
		
		cbgendernv = new JComboBox();
		cbgendernv.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		cbgendernv.setFont(new Font("Segoe UI", Font.BOLD, 25));
		cbgendernv.setBackground(Color.WHITE);
		cbgendernv.setBounds(28, 299, 260, 42);
		pnentry1.add(cbgendernv);
		
		cbworkernv = new JComboBox();
		cbworkernv.setModel(new DefaultComboBoxModel(new String[] {"Trống", "Nhân viên bán hàng", "Thu ngân", "Nhân viên phục vụ", "Quản lý cửa hàng", "Bảo vệ", "Lao công"}));
		cbworkernv.setFont(new Font("Segoe UI", Font.BOLD, 25));
		cbworkernv.setBackground(Color.WHITE);
		cbworkernv.setBounds(626, 69, 318, 42);
		pnentry1.add(cbworkernv);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Công việc:");
		lblNewLabel_1_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1_1.setBounds(626, 28, 294, 30);
		pnentry1.add(lblNewLabel_1_1_1_1);
		
		btnedit = new JButton("Cập nhật");
		btnedit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnedit.setForeground(new Color(0, 0, 255));
		btnedit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnedit.setBackground(new Color(255, 255, 255));
		btnedit.setBounds(1014, 130, 249, 50);
		pnentry1.add(btnedit);
		
		btndelete = new JButton("Xoá nhân viên");
		btndelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btndelete.setForeground(new Color(225, 26, 26));
		btndelete.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btndelete.setBackground(new Color(255, 255, 255));
		btndelete.setBounds(1014, 210, 249, 50);
		pnentry1.add(btndelete);
		
		btnreset = new JButton("Làm mới");
		btnreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnreset.setForeground(new Color(202, 202, 0));
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setBounds(1014, 290, 249, 50);
		pnentry1.add(btnreset);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_4_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_4_1.setBackground(Color.BLACK);
		lblNewLabel_1_4_1.setBounds(626, 143, 294, 30);
		pnentry1.add(lblNewLabel_1_4_1);
		
		tfdatenv = new JDateChooser();
		tfdatenv.getCalendarButton().setBackground(new Color(255, 255, 255));
		tfdatenv.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfdatenv.setBounds(626, 184, 318, 42);
		pnentry1.add(tfdatenv);
		
		JPanel pnentry2 = new JPanel();
		pnentry2.setLayout(null);
		pnentry2.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry2.setBackground(new Color(136, 190, 240));
		pnentry2.setBounds(10, 378, 1289, 528);
		panel.add(pnentry2);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table.setRowHeight(40);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "CCCD", "Ng\u00E0y sinh", "C\u00F4ng vi\u1EC7c", "T\u00EAn chi nh\u00E1nh l\u00E0m vi\u1EC7c"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(300);
		table.getColumnModel().getColumn(7).setPreferredWidth(400);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(10, 70, 1269, 447);
		pnentry2.add(scrollPane);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(717, 17, 134, 30);
		pnentry2.add(lblNewLabel_1_2_1_1_1);
		
		tfsearchnv = new JTextField();
		tfsearchnv.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearchnv.setColumns(10);
		tfsearchnv.setBounds(861, 17, 347, 42);
		pnentry2.add(tfsearchnv);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Employees.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(1218, 17, 49, 42);
		pnentry2.add(lblNewLabel);
		init();
	}

	public void setTfidnv(JTextField tfidnv) {
		this.tfidnv = tfidnv;
	}

	public void setTfcccdnv(JTextField tfcccdnv) {
		this.tfcccdnv = tfcccdnv;
	}

	public void setTfnamenv(JTextField tfnamenv) {
		this.tfnamenv = tfnamenv;
	}

	public void setTflocationnv(JTextField tflocationnv) {
		this.tflocationnv = tflocationnv;
	}

	public void setTfphonenv(JTextField tfphonenv) {
		this.tfphonenv = tfphonenv;
	}

	public void setTfsearchnv(JTextField tfsearchnv) {
		this.tfsearchnv = tfsearchnv;
	}

	public void setTfdatenv(JDateChooser tfdatenv) {
		this.tfdatenv = tfdatenv;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setCbworkernv(JComboBox cbworkernv) {
		this.cbworkernv = cbworkernv;
	}

	public void setCbgendernv(JComboBox cbgendernv) {
		this.cbgendernv = cbgendernv;
	}

	public void setBtnadd(JButton btnadd) {
		this.btnadd = btnadd;
	}

	public void setBtnedit(JButton btnedit) {
		this.btnedit = btnedit;
	}

	public void setBtndelete(JButton btndelete) {
		this.btndelete = btndelete;
	}

	public void setBtnreset(JButton btnreset) {
		this.btnreset = btnreset;
	}

	public JTextField getTfidnv() {
		return tfidnv;
	}
	public JTextField getTfnamenv() {
		return tfnamenv;
	}
	public JComboBox getCbworkernv() {
		return cbworkernv;
	}
	public JTextField getTfcccdnv() {
		return tfcccdnv;
	}
	public JTextField getTfphonenv() {
		return tfphonenv;
	}
	public JDateChooser getTfdatenv() {
		return tfdatenv;
	}
	public JComboBox getCbgendernv() {
		return cbgendernv;
	}
	public JTextField getTflocationnv() {
		return tflocationnv;
	}
	public JButton getBtnadd() {
		return btnadd;
	}
	public JButton getBtnedit() {
		return btnedit;
	}
	public JButton getBtndelete() {
		return btndelete;
	}
	public JButton getBtnreset() {
		return btnreset;
	}
	public JTextField getTfsearchnv() {
		return tfsearchnv;
	}
	public JTable getTable() {
		return table;
	}
}
