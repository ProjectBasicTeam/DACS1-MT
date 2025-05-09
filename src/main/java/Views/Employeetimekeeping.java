package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Employeetimekeeping extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfsearcht;
	private JTextField tfidt;
	private JTextField tfnamet;
	private JTextField tfphonet;
	private JTable table;
	private JComboBox cbstatust;
	private JButton btnsave;
	private JButton btneditstatus;
	private JButton btnreset;
	private JButton btnresetstatus;
	private JTextField tfwork;
	private DefaultTableModel tablemodel;
	private JComboBox cblate;
	private JTextField tftemp;
	
	
	
	private void init() {
	}
	
	public Employeetimekeeping() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2_1.setBackground(new Color(136, 190, 240));
		panel_2_1.setBounds(10, 8, 872, 924);
		panel.add(panel_2_1);
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(50);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "C\u00F4ng vi\u1EC7c", "S\u1ED1 l\u1EA7n v\u1EAFng kh\u00F4ng r\u00F5 l\u00FD do th\u00E1ng n\u00E0y", "S\u1ED1 l\u1EA7n \u0111i tr\u1EC5 th\u00E1ng n\u00E0y", "T\u00ECnh tr\u1EA1ng l\u00E0m vi\u1EC7c h\u00F4m nay"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		table.getColumnModel().getColumn(6).setPreferredWidth(600);

		JScrollPane scrollPane_1_1 = new JScrollPane(table);
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setBounds(10, 64, 852, 849);
		panel_2_1.add(scrollPane_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_1.setBounds(322, 13, 134, 30);
		panel_2_1.add(lblNewLabel_1_2_1_1_1);
		
		tfsearcht = new JTextField();
		tfsearcht.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearcht.setColumns(10);
		tfsearcht.setBounds(466, 11, 337, 42);
		panel_2_1.add(tfsearcht);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Employeetimekeeping.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(813, 11, 49, 42);
		panel_2_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_2_2_2_2_1 = new JLabel("Bảng nhân viên");
		lblNewLabel_1_2_2_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_2_1.setBounds(10, 11, 305, 46);
		panel_2_1.add(lblNewLabel_1_2_2_2_2_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2_1_1.setBackground(new Color(136, 190, 240));
		panel_2_1_1.setBounds(892, 11, 400, 924);
		panel.add(panel_2_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Tình trạng làm việc hôm nay:");
		lblNewLabel_1_1_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_1_1_2.setBounds(20, 436, 331, 30);
		panel_2_1_1.add(lblNewLabel_1_1_1_2);
		
		cbstatust = new JComboBox();
		cbstatust.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbstatust.setModel(new DefaultComboBoxModel(new String[] {"Chưa có tình hình", "Sáng (9:00-15:00)", "Tối (15:00-21:00)", "Sáng-Tối (9:00-21:00)", "Nghỉ có phép", "Vắng không rõ lý do"}));
		cbstatust.setFont(new Font("Segoe UI", Font.BOLD, 25));
		cbstatust.setBackground(Color.WHITE);
		cbstatust.setBounds(20, 476, 360, 42);
		panel_2_1_1.add(cbstatust);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(20, 60, 294, 30);
		panel_2_1_1.add(lblNewLabel_1);
		
		tfidt = new JTextField();
		tfidt.setEditable(false);
		tfidt.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfidt.setColumns(10);
		tfidt.setBounds(20, 101, 362, 42);
		panel_2_1_1.add(tfidt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(20, 154, 294, 30);
		panel_2_1_1.add(lblNewLabel_1_1);
		
		tfnamet = new JTextField();
		tfnamet.setEditable(false);
		tfnamet.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnamet.setColumns(10);
		tfnamet.setBounds(20, 195, 362, 42);
		panel_2_1_1.add(tfnamet);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại của nhân viên:");
		lblNewLabel_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(20, 248, 351, 30);
		panel_2_1_1.add(lblNewLabel_1_1_1);
		
		tfphonet = new JTextField();
		tfphonet.setEditable(false);
		tfphonet.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfphonet.setColumns(10);
		tfphonet.setBounds(20, 288, 360, 42);
		panel_2_1_1.add(tfphonet);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Công việc:");
		lblNewLabel_1_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1_1.setBounds(20, 342, 294, 30);
		panel_2_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2_2_2_2_2 = new JLabel("Bảng điều khiển");
		lblNewLabel_1_2_2_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_2_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_2.setBounds(10, 0, 380, 57);
		panel_2_1_1.add(lblNewLabel_1_2_2_2_2_2);
		
		btnreset = new JButton("Làm mới dữ liệu");
		btnreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
			
		btnreset.setForeground(new Color(202, 202, 0));
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setBounds(20, 780, 360, 50);
		panel_2_1_1.add(btnreset);
		
		btnsave = new JButton("Lưu");
		btnsave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnsave.setForeground(new Color(52, 219, 4));
		btnsave.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.setBounds(20, 640, 360, 50);
		panel_2_1_1.add(btnsave);
		
		btneditstatus = new JButton("Sửa lại tình trạng");
		btneditstatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
			
		btneditstatus.setForeground(new Color(0, 0, 255));
		btneditstatus.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btneditstatus.setBackground(new Color(255, 255, 255));
		btneditstatus.setBounds(20, 710, 360, 50);
		panel_2_1_1.add(btneditstatus);
		
		btnresetstatus = new JButton("Làm mới tình trạng");
		btnresetstatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnresetstatus.setForeground(new Color(255, 128, 0));
		btnresetstatus.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnresetstatus.setBackground(new Color(255, 255, 255));
		btnresetstatus.setBounds(20, 850, 360, 50);
		panel_2_1_1.add(btnresetstatus);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Hôm nay có đi trễ hay không?");
		lblNewLabel_1_1_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1_2_1.setBounds(20, 530, 360, 30);
		panel_2_1_1.add(lblNewLabel_1_1_1_2_1);
		
		cblate = new JComboBox();
		cblate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cblate.setModel(new DefaultComboBoxModel(new String[] {"Không", "Có", "Đã xin phép"}));
		cblate.setFont(new Font("Segoe UI", Font.BOLD, 25));
		cblate.setBackground(Color.WHITE);
		cblate.setBounds(20, 570, 360, 42);
		panel_2_1_1.add(cblate);
		
		tfwork = new JTextField();
		tfwork.setEditable(false);
		tfwork.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfwork.setColumns(10);
		tfwork.setBounds(20, 382, 360, 42);
		panel_2_1_1.add(tfwork);
		
		tftemp = new JTextField();
		tftemp.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tftemp.setEditable(false);
		tftemp.setColumns(10);
		tftemp.setBounds(0, 901, 1, 1);
		panel_2_1_1.add(tftemp);
		init();
	}
	
	public void setTfsearcht(JTextField tfsearcht) {
		this.tfsearcht = tfsearcht;
	}

	public void setTfidt(JTextField tfidt) {
		this.tfidt = tfidt;
	}

	public void setTfnamet(JTextField tfnamet) {
		this.tfnamet = tfnamet;
	}

	public void setTfphonet(JTextField tfphonet) {
		this.tfphonet = tfphonet;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	

	public void setCbstatust(JComboBox cbstatust) {
		this.cbstatust = cbstatust;
	}

	public void setBtnsave(JButton btnsave) {
		this.btnsave = btnsave;
	}

	public void setBtneditstatus(JButton btneditstatus) {
		this.btneditstatus = btneditstatus;
	}

	public void setBtnreset(JButton btnreset) {
		this.btnreset = btnreset;
	}

	public void setBtnresetstatus(JButton btnresetstatus) {
		this.btnresetstatus = btnresetstatus;
	}

	public JTable getTable() {
		return table;
	}
	public JTextField getTfsearcht() {
		return tfsearcht;
	}
	public JTextField getTfidt() {
		return tfidt;
	}
	public JTextField getTfnamet() {
		return tfnamet;
	}
	public JTextField getTfphonet() {
		return tfphonet;
	}
	
	public JComboBox getCbstatust() {
		return cbstatust;
	}
	public JButton getBtnsave() {
		return btnsave;
	}
	public JButton getBtneditstatus() {
		return btneditstatus;
	}
	public JButton getBtnreset() {
		return btnreset;
	}
	public JButton getBtnresetstatus() {
		return btnresetstatus;
	}
	public JTextField getTfwork() {
		return tfwork;
	}
	public JComboBox getCblate() {
		return cblate;
	}
	public JTextField getTftemp() {
		return tftemp;
	}
}
