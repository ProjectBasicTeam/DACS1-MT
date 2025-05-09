package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Controllers.HistoryController;

import javax.swing.SwingConstants;

public class History extends JPanel{
	private JTextField tfsearch;
	private JLabel lbtime;
	private JLabel lbday;
	private JTable table1, table2;
	private JButton btnreload;
	private JButton btnexportExcel;
	private JButton btnexportexcel2;
	
	private void init() {
		new HistoryController(this);
	}
	
	public History() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnentry2 = new JPanel();
		pnentry2.setLayout(null);
		pnentry2.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry2.setBackground(new Color(136, 190, 240));
		pnentry2.setBounds(10, 11, 895, 924);
		panel.add(pnentry2);
		
		table1 = new JTable();
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.setRowHeight(40);
		table1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "IDHD", "T\u1ED5ng ti\u1EC1n", "T\u1ED5ng s\u1ED1 l\u01B0\u1EE3ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i kh\u00E1ch h\u00E0ng", "Ng\u00E0y", "Th\u1EDDi gian (gi\u1EDD)", "Chi nh\u00E1nh b\u00E1n"
			}
		));
		table1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table1.getColumnModel().getColumn(1).setPreferredWidth(200);
		table1.getColumnModel().getColumn(2).setPreferredWidth(300);
		table1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table1.getColumnModel().getColumn(4).setPreferredWidth(180);
		table1.getColumnModel().getColumn(5).setPreferredWidth(200);
		table1.getColumnModel().getColumn(6).setPreferredWidth(300);
		table1.getColumnModel().getColumn(7).setPreferredWidth(400);
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 65, 875, 393);
		pnentry2.add(scrollPane);
		table2 = new JTable();
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setRowHeight(40);
		table2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, ""},
			},
			new String[] {
				"stt", "IDHD", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1", "Th\u00E0nh ti\u1EC1n", "Ng\u00E0y", "Chi nh\u00E1nh"
			}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(60);
		table2.getColumnModel().getColumn(1).setPreferredWidth(120);
		table2.getColumnModel().getColumn(2).setPreferredWidth(200);
		table2.getColumnModel().getColumn(3).setPreferredWidth(400);
		table2.getColumnModel().getColumn(4).setPreferredWidth(60);
		table2.getColumnModel().getColumn(5).setPreferredWidth(300);
		table2.getColumnModel().getColumn(6).setPreferredWidth(300);
		table2.getColumnModel().getColumn(7).setPreferredWidth(180);
		table2.getColumnModel().getColumn(8).setPreferredWidth(400);
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 520, 875, 393);
		pnentry2.add(scrollPane_1);
		
		JLabel lblNewLabel_1_2_1_1_2_1_2_1_2 = new JLabel("BẢNG THÔNG TIN HOÁ ĐƠN");
		lblNewLabel_1_2_1_1_2_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2_1_2_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_2_1_2.setBounds(250, 11, 430, 30);
		pnentry2.add(lblNewLabel_1_2_1_1_2_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_1_2_1_2_1_3 = new JLabel("BẢNG CHI TIẾT HOÁ ĐƠN");
		lblNewLabel_1_2_1_1_2_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2_1_2_1_3.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_2_1_3.setBounds(283, 469, 333, 30);
		pnentry2.add(lblNewLabel_1_2_1_1_2_1_2_1_3);
		
		JPanel pnentry2_1 = new JPanel();
		pnentry2_1.setLayout(null);
		pnentry2_1.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry2_1.setBackground(new Color(136, 190, 240));
		pnentry2_1.setBounds(915, 135, 384, 390);
		panel.add(pnentry2_1);
		
		JLabel lblNewLabel_1_2_1_1_2_1_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_2_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_1.setBounds(48, 79, 291, 30);
		pnentry2_1.add(lblNewLabel_1_2_1_1_2_1_1);
		
		tfsearch = new JTextField();
		tfsearch.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearch.setColumns(10);
		tfsearch.setBounds(48, 120, 291, 42);
		pnentry2_1.add(tfsearch);
		
		btnreload = new JButton("Làm mới");
		btnreload.setForeground(new Color(202, 202, 0));
		btnreload.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnreload.setBackground(new Color(255, 255, 255));
		btnreload.setBounds(48, 203, 290, 40);
		pnentry2_1.add(btnreload);
		
		btnexportExcel = new JButton("Xuất Excel bảng 2");
		btnexportExcel.setForeground(new Color(64, 0, 0));
		btnexportExcel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnexportExcel.setBackground(new Color(255, 255, 255));
		btnexportExcel.setBounds(48, 327, 289, 40);
		pnentry2_1.add(btnexportExcel);
		
		JLabel lblNewLabel_1_2_1_1_2_1_2_1_1 = new JLabel("MỤC TÌM KIẾM");
		lblNewLabel_1_2_1_1_2_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2_1_2_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_2_1_1.setBounds(64, 24, 263, 30);
		pnentry2_1.add(lblNewLabel_1_2_1_1_2_1_2_1_1);
		
		btnexportexcel2 = new JButton("Xuất Excel bảng 1");
		btnexportexcel2.setForeground(new Color(64, 0, 0));
		btnexportexcel2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnexportexcel2.setBackground(Color.WHITE);
		btnexportexcel2.setBounds(48, 267, 289, 40);
		pnentry2_1.add(btnexportexcel2);
		
		JPanel pnentry2_1_1 = new JPanel();
		pnentry2_1_1.setLayout(null);
		pnentry2_1_1.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry2_1_1.setBackground(new Color(136, 190, 240));
		pnentry2_1_1.setBounds(915, 592, 384, 343);
		panel.add(pnentry2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_2_1_2 = new JLabel("Giờ\r\n");
		lblNewLabel_1_2_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_2.setBounds(120, 112, 134, 30);
		pnentry2_1_1.add(lblNewLabel_1_2_1_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_1_2_1_1_1 = new JLabel("Ngày");
		lblNewLabel_1_2_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_1_1.setBounds(120, 230, 134, 30);
		pnentry2_1_1.add(lblNewLabel_1_2_1_1_2_1_1_1);
		
		lbtime = new JLabel("Loading...");
		lbtime.setHorizontalAlignment(SwingConstants.CENTER);
		lbtime.setForeground(Color.WHITE);
		lbtime.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbtime.setBounds(44, 166, 295, 30);
		pnentry2_1_1.add(lbtime);
		
		lbday = new JLabel("Loading...");
		lbday.setHorizontalAlignment(SwingConstants.CENTER);
		lbday.setForeground(Color.WHITE);
		lbday.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbday.setBounds(44, 287, 280, 30);
		pnentry2_1_1.add(lbday);
		
		JLabel lblNewLabel_1_2_1_1_2_1_2_1 = new JLabel("THỜI GIAN HIỆN TẠI");
		lblNewLabel_1_2_1_1_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2_1_2_1.setBounds(25, 32, 333, 30);
		pnentry2_1_1.add(lblNewLabel_1_2_1_1_2_1_2_1);
		init();
	}
	public JLabel getLbtime() {
		return lbtime;
	}
	public JLabel getLbday() {
		return lbday;
	}
	
	public JTextField getTfsearch() {
		return tfsearch;
	}
	
	public JTable getTable1() {
		return table1;
	}
	public JTable getTable2() {
		return table2;
	}
	public JButton getBtnreload() {
		return btnreload;
	}
	public JButton getBtnexportExcel() {
		return btnexportExcel;
	}
	public JButton getBtnexportexcel2() {
		return btnexportexcel2;
	}
}
