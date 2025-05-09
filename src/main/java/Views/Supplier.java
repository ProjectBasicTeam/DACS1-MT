package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import Controllers.SupplierController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Supplier extends JPanel{
	private JTextField tfidcc;
	private JTextField tfnamecc;
	private JTextField tfphonecc;
	private JTextField tfqtycc;
	private JTextField tfnamesp;
	private JTextField tfpricecc;
	private JTextField tftotalcc;
	private JDateChooser tfdate;
	private JTable table;
	private JLabel lbnameimg;
	private JButton btnadd;
	private JButton btnedit;
	private JButton btndelete;
	private JButton btnreset;
	private JButton btnexportexcel;
	private JLabel lblNewLabel_1_2_1_1_2;
	private JTextField tfsearch;
	private JLabel lblNewLabel;
	private DefaultTableModel tablemodel;
	private JTextField tfaddresscc;
	private JButton btnimage;
	private JPanelWithImage imagePanel;
	

	
	private void SupllierTable() {
		tablemodel = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Mã cung cấp", "Nhà cung cấp", "Số điện thoại","Địa chỉ lấy hàng", "Tên sản phẩm", "Số lượng đã nhập", "Giá của một sản phẩm", "Tổng số vốn đã chi", "Hình ảnh", "Thời gian nhập hàng"
				}
			);
		
			table.setModel(tablemodel);
	}
	
	private void init() {
		new SupplierController(this);
	}
	public Supplier() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnentry = new JPanel();
		pnentry.setLayout(null);
		pnentry.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnentry.setBackground(new Color(136, 190, 240));
		pnentry.setBounds(10, 11, 1289, 384);
		panel.add(pnentry);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp:");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(20, 11, 294, 30);
		pnentry.add(lblNewLabel_1);
		
		tfidcc = new JTextField();
		tfidcc.setBackground(new Color(255, 255, 255));
		tfidcc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfidcc.setColumns(10);
		tfidcc.setBounds(20, 50, 318, 42);
		pnentry.add(tfidcc);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhà cung cấp:");
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(20, 98, 294, 30);
		pnentry.add(lblNewLabel_1_1);
		
		tfnamecc = new JTextField();
		tfnamecc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnamecc.setColumns(10);
		tfnamecc.setBounds(20, 137, 318, 42);
		pnentry.add(tfnamecc);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(20, 185, 318, 30);
		pnentry.add(lblNewLabel_1_2);
		
		tfphonecc = new JTextField();
		tfphonecc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfphonecc.setColumns(10);
		tfphonecc.setBounds(20, 224, 318, 42);
		pnentry.add(tfphonecc);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1.setBounds(348, 11, 183, 30);
		pnentry.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Số lượng đã nhập:");
		lblNewLabel_1_2_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_1.setBounds(348, 98, 294, 30);
		pnentry.add(lblNewLabel_1_2_1_1);
		
		tfqtycc = new JTextField();
		tfqtycc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfqtycc.setColumns(10);
		tfqtycc.setBounds(348, 137, 318, 42);
		pnentry.add(tfqtycc);
		
		tfnamesp = new JTextField();
		tfnamesp.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfnamesp.setColumns(10);
		tfnamesp.setBounds(348, 50, 318, 42);
		pnentry.add(tfnamesp);
		
		btnadd = new JButton("Lưu");
		btnadd.setForeground(new Color(52, 219, 4));
		btnadd.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.setBounds(1038, 27, 210, 40);
		pnentry.add(btnadd);
		
		btnedit = new JButton("Sửa");
		btnedit.setForeground(new Color(0, 0, 255));
		btnedit.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnedit.setBackground(new Color(255, 255, 255));
		btnedit.setBounds(1039, 81, 210, 40);
		pnentry.add(btnedit);
		
		btndelete = new JButton("Xoá");
		btndelete.setForeground(new Color(225, 26, 26));
		btndelete.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btndelete.setBackground(new Color(255, 255, 255));
		btndelete.setBounds(1038, 135, 210, 40);
		pnentry.add(btndelete);
		
		btnreset = new JButton("Làm mới");
		btnreset.setForeground(new Color(202, 202, 0));
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setBounds(1038, 189, 210, 40);
		pnentry.add(btnreset);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Giá của một sản phẩm:");
		lblNewLabel_1_2_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_2.setBounds(348, 185, 308, 30);
		pnentry.add(lblNewLabel_1_2_1_2);
		
		tfpricecc = new JTextField();
		tfpricecc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfpricecc.setColumns(10);
		tfpricecc.setBounds(348, 224, 318, 42);
		pnentry.add(tfpricecc);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Thời gian nhập hàng:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_1_1.setBounds(676, 11, 294, 30);
		pnentry.add(lblNewLabel_1_2_1_1_1);
		
		tftotalcc = new JTextField();
		tftotalcc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tftotalcc.setColumns(10);
		tftotalcc.setBounds(348, 316, 318, 42);
		pnentry.add(tftotalcc);
		
		btnimage = new JButton("Duyệt");
		btnimage.setForeground(new Color(0, 0, 0));
		btnimage.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnimage.setBackground(new Color(255, 255, 255));
		btnimage.setBounds(900, 316, 140, 40);
		pnentry.add(btnimage);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Hình ảnh sản phẩm:");
		lblNewLabel_1_2_1_1_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_1_1_1.setBounds(676, 98, 294, 30);
		pnentry.add(lblNewLabel_1_2_1_1_1_1);
		
		lbnameimg = new JLabel("name.jpg");
		lbnameimg.setForeground(new Color(0, 0, 0));
		lbnameimg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbnameimg.setBounds(1050, 318, 217, 40);
		pnentry.add(lbnameimg);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Tổng số vốn đã chi:");
		lblNewLabel_1_2_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_2_1.setBounds(348, 277, 308, 30);
		pnentry.add(lblNewLabel_1_2_1_2_1);
		
		tfdate = new JDateChooser();
		tfdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfdate.setBounds(676, 50, 318, 42);
		pnentry.add(tfdate);
		
		btnexportexcel = new JButton("Xuất Excel");
		btnexportexcel.setForeground(new Color(64, 0, 64));
		btnexportexcel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnexportexcel.setBackground(new Color(255, 255, 255));
		btnexportexcel.setBounds(1039, 247, 210, 40);
		pnentry.add(btnexportexcel);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Địa chỉ lấy hàng:");
		lblNewLabel_1_2_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2.setBounds(20, 277, 318, 30);
		pnentry.add(lblNewLabel_1_2_2);
		
		tfaddresscc = new JTextField();
		tfaddresscc.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tfaddresscc.setColumns(10);
		tfaddresscc.setBounds(20, 316, 318, 42);
		pnentry.add(tfaddresscc);
		
		imagePanel = new JPanelWithImage();
		imagePanel.setBackground(new Color(255, 255, 255));
		imagePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagePanel.setBounds(690, 158, 200, 200);
		pnentry.add(imagePanel);
		
		JPanel pnentry2 = new JPanel();//Detaild detall
		pnentry2.setLayout(null);
		pnentry2.setBorder(new LineBorder(new Color(64, 0, 0), 4));
		pnentry2.setBackground(new Color(136, 190, 240));
		pnentry2.setBounds(10, 398, 1289, 537);
		panel.add(pnentry2);
		
		table = new JTable();
		table.setRowHeight(250);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				" M\u00E3 nh\u00E0 cung c\u1EA5p", "T\u00EAn nh\u00E0 cung c\u1EA5p", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9 l\u1EA5y h\u00E0ng", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u00E3 nh\u1EADp", "Gi\u00E1 c\u1EE7a m\u1ED9t s\u1EA3n ph\u1EA9m", "T\u1ED5ng s\u1ED1 v\u1ED1n \u0111\u00E3 chi", "H\u00ECnh \u1EA3nh", "Th\u1EDDi gian nh\u1EADp h\u00E0ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(4).setPreferredWidth(400);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setPreferredWidth(280);
		table.getColumnModel().getColumn(8).setPreferredWidth(250);
		table.getColumnModel().getColumn(9).setPreferredWidth(180);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 70, 1269, 464);
		pnentry2.add(scrollPane);
		
		lblNewLabel_1_2_1_1_2 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_1_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_2_1_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1_1_2.setBounds(43, 14, 134, 30);
		pnentry2.add(lblNewLabel_1_2_1_1_2);
		
		tfsearch = new JTextField();
		tfsearch.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfsearch.setColumns(10);
		tfsearch.setBounds(202, 11, 1005, 42);
		pnentry2.add(tfsearch);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Supplier.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(1217, 11, 49, 42);
		pnentry2.add(lblNewLabel);
		init();
	}
	public JLabel getLbnameimg() {
		return lbnameimg;
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
	public JButton getBtnexportexcel() {
		return btnexportexcel;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTfidcc() {
		return tfidcc;
	}
	public void setTfidcc(JTextField tfidcc) {
		this.tfidcc = tfidcc;
	}
	public JTextField getTfnamecc() {
		return tfnamecc;
	}
	public void setTfnamecc(JTextField tfnamecc) {
		this.tfnamecc = tfnamecc;
	}
	public JTextField getTfphonecc() {
		return tfphonecc;
	}
	public void setTfphonecc(JTextField tfphonecc) {
		this.tfphonecc = tfphonecc;
	}
	public JTextField getTfqtycc() {
		return tfqtycc;
	}
	public void setTfqtycc(JTextField tfqtycc) {
		this.tfqtycc = tfqtycc;
	}
	public JTextField getTfnamesp() {
		return tfnamesp;
	}
	public void setTfnamesp(JTextField tfnamesp) {
		this.tfnamesp = tfnamesp;
	}
	public JTextField getTfpricecc() {
		return tfpricecc;
	}
	public void setTfpricecc(JTextField tfpricecc) {
		this.tfpricecc = tfpricecc;
	}
	public JTextField getTftotalcc() {
		return tftotalcc;
	}
	public void setTftotalcc(JTextField tftotalcc) {
		this.tftotalcc = tftotalcc;
	}
	public JDateChooser getTfdate() {
		return tfdate;
	}
	public void setTfdate(JDateChooser tfdate) {
		this.tfdate = tfdate;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public void setLbnameimg(JLabel lbnameimg) {
		this.lbnameimg = lbnameimg;
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
	public void setBtnexportexcel(JButton btnexportexcel) {
		this.btnexportexcel = btnexportexcel;
	}
	
	public void setTfsearch(JTextField tfsearch) {
		this.tfsearch = tfsearch;
	}
	public JTextField getTfsearch() {
		return tfsearch;
	}
	public JTextField getTfaddresscc() {
		return tfaddresscc;
	}
	public JButton getBtnimage() {
		return btnimage;
	}
	public JPanelWithImage getImagePanel() {
		return imagePanel;
	}
}
