package Views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controllers.AccountController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;

public class Account extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfidtk;
	private JTextField tfnametk;
	private JTextField tfpasswordtk;
	private JTextField tflocation;
	private JTextField tfadrresstk;
	private JTextField tfphonetk;
	private JButton btnsave;
	private JButton btndeleteacc;
	private JLabel lbnameacc;
	private String userAccountName;
	private int findid; 
	private JLabel lbid;
	
	public void setLbid(JLabel lbid) {
		this.lbid = lbid;
	}

	public int getFindid() {
		return findid;
	}

	public void setFindid(int findid) {
		this.findid = findid;
	}

	void init() {
	}
	
	public Account() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(183, 228, 249));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panel_3.setBackground(new Color(136, 190, 240));
		panel_3.setBounds(57, 47, 1170, 823);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1_2_2_2_2_1 = new JLabel("Thông tin tài khoản:");
		lblNewLabel_1_2_2_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2_2_2_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_2_2_2_1.setBounds(21, 24, 510, 57);
		panel_3.add(lblNewLabel_1_2_2_2_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tài khoảng quản lý:");
		lblNewLabel_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(66, 115, 400, 40);
		panel_3.add(lblNewLabel_1);
		
		tfidtk = new JTextField();
		tfidtk.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfidtk.setColumns(10);
		tfidtk.setBounds(66, 165, 402, 42);
		panel_3.add(tfidtk);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên chi nhánh quản lý:");
		lblNewLabel_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(66, 225, 400, 40);
		panel_3.add(lblNewLabel_1_1);
		
		tfnametk = new JTextField();
		tfnametk.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfnametk.setColumns(10);
		tfnametk.setBounds(66, 275, 402, 42);
		panel_3.add(tfnametk);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(661, 115, 400, 40);
		panel_3.add(lblNewLabel_1_2);
		
		tfpasswordtk = new JTextField();
		tfpasswordtk.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfpasswordtk.setColumns(10);
		tfpasswordtk.setBounds(661, 165, 402, 42);
		panel_3.add(tfpasswordtk);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chi nhánh:");
		lblNewLabel_1_2_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1.setBounds(66, 335, 300, 40);
		panel_3.add(lblNewLabel_1_2_1);
		
		tflocation = new JTextField();
		tflocation.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tflocation.setColumns(10);
		tflocation.setBounds(66, 385, 402, 42);
		panel_3.add(tflocation);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Địa chỉ chi nhánh:");
		lblNewLabel_1_2_1_2.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_2_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_2.setBounds(659, 225, 400, 40);
		panel_3.add(lblNewLabel_1_2_1_2);
		
		tfadrresstk = new JTextField();
		tfadrresstk.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfadrresstk.setColumns(10);
		tfadrresstk.setBounds(659, 275, 402, 42);
		panel_3.add(tfadrresstk);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Số điện thoại chi nhánh:");
		lblNewLabel_1_2_1_1.setForeground(new Color(36, 118, 217));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_2_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1_1.setBounds(659, 335, 400, 40);
		panel_3.add(lblNewLabel_1_2_1_1);
		
		tfphonetk = new JTextField();
		tfphonetk.setFont(new Font("Segoe UI", Font.BOLD, 25));
		tfphonetk.setColumns(10);
		tfphonetk.setBounds(659, 385, 402, 42);
		panel_3.add(tfphonetk);
		
		btnsave = new JButton("Cập nhật");
		btnsave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnsave.setForeground(new Color(52, 219, 4));
		btnsave.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.setBounds(189, 602, 360, 50);
		panel_3.add(btnsave);
		
		btndeleteacc = new JButton("Xoá tài khoản");
		btndeleteacc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndeleteacc.setForeground(new Color(225, 26, 26));
		btndeleteacc.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btndeleteacc.setBackground(new Color(255, 255, 255));
		btndeleteacc.setBounds(596, 602, 360, 50);
		panel_3.add(btndeleteacc);
		
		lbnameacc = new JLabel();
		lbnameacc.setForeground(new Color(252, 250, 238));
		lbnameacc.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbnameacc.setBackground(Color.BLACK);
		lbnameacc.setBounds(556, 24, 400, 57);
		panel_3.add(lbnameacc);
		
		lbid = new JLabel();
		lbid.setForeground(new Color(252, 250, 238));
		lbid.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbid.setBackground(Color.BLACK);
		lbid.setBounds(46, 780, 0, 14);
		panel_3.add(lbid);
		init();
	}
	
	public void setTfidtk(JTextField tfidtk) {
		this.tfidtk = tfidtk;
	}

	public void setTfnametk(JTextField tfnametk) {
		this.tfnametk = tfnametk;
	}

	public void setTfpasswordtk(JTextField tfpasswordtk) {
		this.tfpasswordtk = tfpasswordtk;
	}

	public void setTflocation(JTextField tflocation) {
		this.tflocation = tflocation;
	}

	public void setTfadrresstk(JTextField tfadrresstk) {
		this.tfadrresstk = tfadrresstk;
	}

	public void setTfphonetk(JTextField tfphonetk) {
		this.tfphonetk = tfphonetk;
	}

	public void setBtnsave(JButton btnsave) {
		this.btnsave = btnsave;
	}

	public void setBtndeleteacc(JButton btndeleteacc) {
		this.btndeleteacc = btndeleteacc;
	}

	public JTextField getTfidtk() {
		return tfidtk;
	}
	public JTextField getTfnametk() {
		return tfnametk;
	}
	public JTextField getTflocation() {
		return tflocation;
	}
	public JTextField getTfpasswordtk() {
		return tfpasswordtk;
	}
	public JTextField getTfadrresstk() {
		return tfadrresstk;
	}
	public JTextField getTfphonetk() {
		return tfphonetk;
	}
	public JButton getBtnsave() {
		return btnsave;
	}
	public JButton getBtndeleteacc() {
		return btndeleteacc;
	}
	public JLabel getLbnameacc() {
		return lbnameacc;
	}
	public JLabel getLbid() {
		return lbid;
	}
}
