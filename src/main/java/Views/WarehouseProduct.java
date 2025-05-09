package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Controllers.WarehouseProductController;
import java.awt.Cursor;

public class WarehouseProduct extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField tfsearch;
	private JTextField tfidpd;
	private JTextField tfnamepd;
	private JTextField tfqtypd;
	private JTable table;
	private JPanelWithImage imagePanel;
	private JButton btnbrowseimg;
	private JTextField tfpricepd;
	private DefaultTableModel tablemodel;
	private JLabel lbname;
	private JTextField tfstt;
	private JButton btnreset;
	private JButton btndelete;
	private JButton btnedit;
	
	
	private void init() {
		new WarehouseProductController(this);
		
	}
	public WarehouseProduct() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 917);
		add(panel);
		panel.setLayout(null);
		
		JPanel pnbox = new JPanel();
		pnbox.setLayout(null);
		pnbox.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnbox.setBackground(new Color(136, 190, 240));
		pnbox.setBounds(30, 20, 870, 870);
		panel.add(pnbox);
		
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
		lblNewLabel.setIcon(new ImageIcon(WarehouseProduct.class.getResource("/icon/search.png")));
		lblNewLabel.setBounds(794, 21, 49, 42);
		pnbox.add(lblNewLabel);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		table.setRowHeight(200);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"stt", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1 s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n kho", "H\u00ECnh \u1EA3nh"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 90, 850, 769);
		pnbox.add(scrollPane);
		
		JPanel pnentry = new JPanel();
		pnentry.setLayout(null);
		pnentry.setBorder(new LineBorder(new Color(64, 0, 0), 5));
		pnentry.setBackground(new Color(136, 190, 240));
		pnentry.setBounds(938, 11, 361, 895);
		panel.add(pnentry);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(20, 11, 294, 30);
		pnentry.add(lblNewLabel_1);
		
		tfidpd = new JTextField();
		tfidpd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfidpd.setColumns(10);
		tfidpd.setBounds(20, 52, 318, 42);
		pnentry.add(tfidpd);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(20, 101, 294, 30);
		pnentry.add(lblNewLabel_1_1);
		
		tfnamepd = new JTextField();
		tfnamepd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfnamepd.setColumns(10);
		tfnamepd.setBounds(20, 142, 318, 42);
		pnentry.add(tfnamepd);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số lượng:");
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(20, 193, 183, 30);
		pnentry.add(lblNewLabel_1_2);
		
		tfqtypd = new JTextField();
		tfqtypd.setEditable(false);
		tfqtypd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfqtypd.setColumns(10);
		tfqtypd.setBounds(20, 234, 318, 42);
		pnentry.add(tfqtypd);
		
		imagePanel = new JPanelWithImage();
        imagePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        imagePanel.setBounds(85, 328, 200, 200);
        pnentry.add(imagePanel);
        
		JLabel lblNewLabel_1_2_1 = new JLabel("Hình ảnh:");
		lblNewLabel_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1.setBounds(20, 287, 183, 30);
		pnentry.add(lblNewLabel_1_2_1);
		
		btnedit = new JButton("Sửa");
		btnedit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnedit.setForeground(new Color(0, 128, 192));
		btnedit.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnedit.setBackground(new Color(255, 255, 255));
		btnedit.setBounds(40, 704, 286, 40);
		pnentry.add(btnedit);
		
		btndelete = new JButton("Xoá");
		btndelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndelete.setForeground(new Color(225, 26, 26));
		btndelete.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btndelete.setBackground(new Color(255, 255, 255));
		btndelete.setBounds(40, 768, 286, 40);
		pnentry.add(btndelete);
		
		btnreset = new JButton("Làm mới");
		btnreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnreset.setForeground(new Color(202, 202, 0));
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setBounds(40, 832, 286, 40);
		pnentry.add(btnreset);
		
		btnbrowseimg = new JButton("Duyệt ảnh");
		btnbrowseimg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnbrowseimg.setBackground(new Color(255, 255, 255));
		btnbrowseimg.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnbrowseimg.setBounds(20, 539, 130, 45);
		pnentry.add(btnbrowseimg);
		
		lbname = new JLabel("name.jpg");
		lbname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lbname.setBounds(160, 539, 191, 45);
		pnentry.add(lbname);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giá sản phẩm:");
		lblNewLabel_1_2_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_2.setBounds(20, 594, 183, 30);
		pnentry.add(lblNewLabel_1_2_2);
		
		tfpricepd = new JTextField();
		tfpricepd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfpricepd.setColumns(10);
		tfpricepd.setBounds(20, 635, 318, 42);
		pnentry.add(tfpricepd);
		
		tfstt = new JTextField();
		tfstt.setFont(new Font("Segoe UI", Font.BOLD, 15));
		tfstt.setColumns(10);
		tfstt.setBounds(0, 0, 1, 1);
		pnentry.add(tfstt);
		init();
	}
	
	public void setTfsearch(JTextField tfsearch) {
		this.tfsearch = tfsearch;
	}

	public void setTfidpd(JTextField tfidpd) {
		this.tfidpd = tfidpd;
	}

	public void setTfnamepd(JTextField tfnamepd) {
		this.tfnamepd = tfnamepd;
	}

	public void setTfqtypd(JTextField tfqtypd) {
		this.tfqtypd = tfqtypd;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setImagePanel(JPanelWithImage imagePanel) {
		this.imagePanel = imagePanel;
	}

	public void setBtnbrowseimg(JButton btnbrowseimg) {
		this.btnbrowseimg = btnbrowseimg;
	}

	public JTextField getTfsearch() {
		return tfsearch;
	}
	
	public JButton getBtnbrowseimg() {
		return btnbrowseimg;
	}
	public JPanelWithImage getImagePanel() {
		return imagePanel;
	}
	public JTextField getTfidpd() {
		return tfidpd;
	}
	public JTextField getTfnamepd() {
		return tfnamepd;
	}
	public JTextField getTfqtypd() {
		return tfqtypd;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTfpricepd() {
		return tfpricepd;
	}
	public JLabel getLbname() {
		return lbname;
	}
	public JTextField getTfstt() {
		return tfstt;
	}
	public JButton getBtnreset() {
		return btnreset;
	}
	public JButton getBtndelete() {
		return btndelete;
	}
	public JButton getBtnedit() {
		return btnedit;
	}
}
