package Views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Controllers.EmployeesSalaryController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Managementsalary extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfids;
	private JTextField tfnames;
	private JTextField tflocations;
	private JTextField tfnumbanks;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnacceptsalary;
	private JButton btnedit;
	private JButton btnexportpdf;
	private JTextField tfphones;
	private JTextField tfsearch;
	private JButton btnreset;
	private JLabel lblNewLabel_1_1;
	private JTextField tfshifts;
	private JLabel lblNewLabel_1_6;
	private JTextField tfslaryshifts;
	private JLabel lblNewLabel_1_7;
	private JTextField tfsalarys;
	private DefaultTableModel tablemodel;
	private JTextField tfworks;
	private JButton btndelete;
	
	
	private void init() {
		new EmployeesSalaryController(this);
	}
	
	public Managementsalary() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 917);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnentry1 = new JPanel();
		pnentry1.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry1.setBackground(new Color(136, 190, 240));
		pnentry1.setBounds(10, 15, 1289, 330);
		panel.add(pnentry1);
		pnentry1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(28, 28, 294, 30);
		pnentry1.add(lblNewLabel_1);
		
		tfids = new JTextField();
		tfids.setEditable(false);
		tfids.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfids.setColumns(10);
		tfids.setBounds(28, 69, 260, 42);
		pnentry1.add(tfids);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(298, 28, 294, 30);
		pnentry1.add(lblNewLabel_1_2);
		
		tfnames = new JTextField();
		tfnames.setEditable(false);
		tfnames.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnames.setColumns(10);
		tfnames.setBounds(298, 69, 318, 42);
		pnentry1.add(tfnames);
		
		JLabel lblNewLabel_1_3 = new JLabel(" Tên chi nhánh làm việc:");
		lblNewLabel_1_3.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_3.setBounds(298, 128, 294, 30);
		pnentry1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số điện thoại:");
		lblNewLabel_1_4.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_4.setBounds(28, 122, 260, 30);
		pnentry1.add(lblNewLabel_1_4);
		
		tflocations = new JTextField();
		tflocations.setEditable(false);
		tflocations.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tflocations.setColumns(10);
		tflocations.setBounds(298, 163, 318, 42);
		pnentry1.add(tflocations);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số tài khoảng ngân hàng:");
		lblNewLabel_1_5.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_5.setBackground(Color.BLACK);
		lblNewLabel_1_5.setBounds(626, 122, 294, 30);
		pnentry1.add(lblNewLabel_1_5);
		
		tfnumbanks = new JTextField();
		tfnumbanks.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnumbanks.setColumns(10);
		tfnumbanks.setBounds(626, 163, 318, 42);
		pnentry1.add(tfnumbanks);
		
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
		btnedit.setBounds(1017, 28, 249, 40);
		pnentry1.add(btnedit);
		
		btnacceptsalary = new JButton("Xác nhận lương");
		btnacceptsalary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnacceptsalary.setForeground(new Color(52, 219, 4));
		btnacceptsalary.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnacceptsalary.setBackground(new Color(255, 255, 255));
		btnacceptsalary.setBounds(1017, 86, 249, 40);
		pnentry1.add(btnacceptsalary);
		
		btnexportpdf = new JButton("Xuất pdf");
		btnexportpdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexportpdf.setForeground(new Color(128, 64, 64));
		btnexportpdf.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnexportpdf.setBackground(new Color(255, 255, 255));
		btnexportpdf.setBounds(1017, 202, 249, 40);
		pnentry1.add(btnexportpdf);
		
		tfphones = new JTextField();
		tfphones.setEditable(false);
		tfphones.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfphones.setColumns(10);
		tfphones.setBounds(28, 163, 260, 42);
		pnentry1.add(tfphones);
		
		btnreset = new JButton("Làm mới");
		btnreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnreset.setForeground(new Color(202, 202, 0));
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setBounds(1017, 259, 249, 40);
		pnentry1.add(btnreset);
		
		lblNewLabel_1_1 = new JLabel("Làm bao nhiêu ca:");
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(28, 216, 259, 30);
		pnentry1.add(lblNewLabel_1_1);
		
		tfshifts = new JTextField();
		tfshifts.setHorizontalAlignment(SwingConstants.CENTER);
		tfshifts.setText("0");
		tfshifts.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfshifts.setColumns(10);
		tfshifts.setBounds(28, 257, 259, 42);
		pnentry1.add(tfshifts);
		
		lblNewLabel_1_6 = new JLabel("Tiền/Ca:");
		lblNewLabel_1_6.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_6.setBackground(Color.BLACK);
		lblNewLabel_1_6.setBounds(298, 216, 294, 30);
		pnentry1.add(lblNewLabel_1_6);
		
		tfslaryshifts = new JTextField();
		tfslaryshifts.setHorizontalAlignment(SwingConstants.CENTER);
		tfslaryshifts.setText("0");
		tfslaryshifts.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfslaryshifts.setColumns(10);
		tfslaryshifts.setBounds(298, 257, 318, 42);
		pnentry1.add(tfslaryshifts);
		
		lblNewLabel_1_7 = new JLabel("Lương tháng này:");
		lblNewLabel_1_7.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_7.setBackground(Color.BLACK);
		lblNewLabel_1_7.setBounds(626, 216, 294, 30);
		pnentry1.add(lblNewLabel_1_7);
		
		tfsalarys = new JTextField();
		tfsalarys.setHorizontalAlignment(SwingConstants.CENTER);
		tfsalarys.setText("0");
		tfsalarys.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfsalarys.setColumns(10);
		tfsalarys.setBounds(626, 257, 318, 42);
		pnentry1.add(tfsalarys);
		
		btndelete = new JButton("Làm mới tháng này");
		btndelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndelete.setForeground(new Color(255, 128, 0));
		btndelete.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btndelete.setBackground(new Color(255, 255, 255));
		btndelete.setBounds(1017, 144, 249, 40);
		pnentry1.add(btndelete);
		
		tfworks = new JTextField();
		tfworks.setEditable(false);
		tfworks.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfworks.setColumns(10);
		tfworks.setBounds(626, 69, 318, 42);
		pnentry1.add(tfworks);
		
		JPanel pnentry2 = new JPanel();
		pnentry2.setForeground(new Color(136, 190, 240));
		pnentry2.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry2.setBackground(new Color(136, 190, 240));
		pnentry2.setBounds(10, 353, 1289, 553);
		panel.add(pnentry2);
		pnentry2.setLayout(null);
		
		table = new JTable();
		table.setRowHeight(40);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "T\u00EAn chi nh\u00E1nh l\u00E0m vi\u1EC7c", "C\u00F4ng vi\u1EC7c", "S\u1ED1 t\u00E0i kho\u1EA3n ng\u00E2n h\u00E0ng", "Ca", "Ti\u1EC1n/Ca", "L\u01B0\u01A1ng th\u00E1ng n\u00E0y", "S\u1ED1 l\u1EA7n \u0111i tr\u1EC5 trong th\u00E1ng", "S\u1ED1 l\u1EA7n ngh\u1EC9 trong th\u00E1ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(500);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(250);
		table.getColumnModel().getColumn(8).setPreferredWidth(300);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		table.getColumnModel().getColumn(10).setPreferredWidth(200);
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 71, 1269, 473);
		pnentry2.add(scrollPane);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(729, 18, 134, 30);
		pnentry2.add(lblNewLabel_1_2_1_1_1);
		
		tfsearch = new JTextField();
		tfsearch.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearch.setColumns(10);
		tfsearch.setBounds(873, 18, 347, 42);
		pnentry2.add(tfsearch);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Managementsalary.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(1230, 18, 49, 42);
		pnentry2.add(lblNewLabel);
		init();
	}

	public JTextField getTfids() {
		return tfids;
	}

	public void setTfids(JTextField tfids) {
		this.tfids = tfids;
	}

	public JTextField getTfnames() {
		return tfnames;
	}

	public void setTfnames(JTextField tfnames) {
		this.tfnames = tfnames;
	}

	public JTextField getTflocations() {
		return tflocations;
	}

	public void setTflocations(JTextField tflocations) {
		this.tflocations = tflocations;
	}

	public JTextField getTfnumbanks() {
		return tfnumbanks;
	}

	public void setTfnumbanks(JTextField tfnumbanks) {
		this.tfnumbanks = tfnumbanks;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	

	public JButton getBtnacceptsalary() {
		return btnacceptsalary;
	}

	public void setBtnacceptsalary(JButton btnacceptsalary) {
		this.btnacceptsalary = btnacceptsalary;
	}

	public JButton getBtnedit() {
		return btnedit;
	}

	public void setBtnedit(JButton btnedit) {
		this.btnedit = btnedit;
	}

	public JButton getBtnexportpdf() {
		return btnexportpdf;
	}

	public void setBtnexportpdf(JButton btnexportpdf) {
		this.btnexportpdf = btnexportpdf;
	}

	public JTextField getTfphones() {
		return tfphones;
	}

	public void setTfphones(JTextField tfphones) {
		this.tfphones = tfphones;
	}

	public JTextField getTfsearch() {
		return tfsearch;
	}

	public void setTfsearch(JTextField tfsearch) {
		this.tfsearch = tfsearch;
	}

	public JButton getBtnreset() {
		return btnreset;
	}

	public void setBtnreset(JButton btnreset) {
		this.btnreset = btnreset;
	}

	public JTextField getTfshifts() {
		return tfshifts;
	}

	public void setTfshifts(JTextField tfshifts) {
		this.tfshifts = tfshifts;
	}

	public JTextField getTfslaryshifts() {
		return tfslaryshifts;
	}

	public void setTfslaryshifts(JTextField tfslaryshifts) {
		this.tfslaryshifts = tfslaryshifts;
	}

	public JTextField getTfsalarys() {
		return tfsalarys;
	}

	public void setTfsalarys(JTextField tfsalarys) {
		this.tfsalarys = tfsalarys;
	}
	public JTextField getTfworks() {
		return tfworks;
	}
	public JButton getBtndelete() {
		return btndelete;
	}
	
}
