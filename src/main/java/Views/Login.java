package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.LoginController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfname;
	private JPasswordField tfpassword;
	private JButton btnlogin;
	private JComboBox cbx;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Gọi kiểm tra/tạo DB trước khi mở Login UI

					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void init() {
		new LoginController(this);
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 222, 54));
		contentPane.setForeground(new Color(64, 67, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(959, 134, 303, 59);
		contentPane.add(lblNewLabel);

		JLabel lb1 = new JLabel("Tên đăng nhập:");
		lb1.setForeground(new Color(0, 0, 0));
		lb1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lb1.setBounds(889, 222, 150, 30);
		contentPane.add(lb1);

		tfname = new JTextField();
		tfname.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tfname.setBounds(889, 263, 450, 50);
		contentPane.add(tfname);
		tfname.setColumns(10);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(new Color(0, 0, 0));
		lblMtKhu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMtKhu.setBounds(889, 324, 150, 30);
		contentPane.add(lblMtKhu);

		tfpassword = new JPasswordField();
		tfpassword.setToolTipText("");
		tfpassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tfpassword.setBounds(889, 362, 450, 50);
		contentPane.add(tfpassword);

		cbx = new JComboBox();
		cbx.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbx.setBackground(new Color(255, 255, 255));
		cbx.setFont(new Font("Segoe UI", Font.BOLD, 25));
		cbx.setModel(new DefaultComboBoxModel(new String[] { "Quản trị viên", "Quản lý bán hàng" }));
		cbx.setBounds(889, 459, 450, 50);
		contentPane.add(cbx);

		JLabel lblLaChnQuyn = new JLabel("Lựa chọn quyền:");
		lblLaChnQuyn.setForeground(new Color(0, 0, 0));
		lblLaChnQuyn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblLaChnQuyn.setBounds(889, 423, 173, 30);
		contentPane.add(lblLaChnQuyn);

		btnlogin = new JButton("Đăng nhập");
		btnlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnlogin.setBackground(new Color(255, 255, 255));
//		btnlogin.setBackground(new Color(254, 222, 54));
		btnlogin.setForeground(new Color(0, 0, 0));
		btnlogin.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnlogin.setBounds(889, 567, 450, 60);
		contentPane.add(btnlogin);

		JLabel lbpikachu = new JLabel("");
		ImageIcon[] images = { new ImageIcon(Login.class.getResource("/icon/pikachu1.png")),
				new ImageIcon(Login.class.getResource("/icon/pikachu2.png")),
				new ImageIcon(Login.class.getResource("/icon/pikachu3.png")),
				new ImageIcon(Login.class.getResource("/icon/pikachu4.png")) };

		new Thread(() -> {
			int index = 0;
			while (true) {
				lbpikachu.setIcon(images[index]);
				index = (index + 1) % images.length;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		lbpikachu.setBounds(10, 11, 790, 730);
		contentPane.add(lbpikachu);
		init();
	}

	public void setTfname(JTextField tfname) {
		this.tfname = tfname;
	}

	public void setTfpassword(JPasswordField tfpassword) {
		this.tfpassword = tfpassword;
	}

	public void setBtnlogin(JButton btnlogin) {
		this.btnlogin = btnlogin;
	}

	public void setCbx(JComboBox cbx) {
		this.cbx = cbx;
	}

	public JTextField getTfname() {
		return tfname;
	}

	public JButton getBtnlogin() {
		return btnlogin;
	}

	public JPasswordField getTfpassword() {
		return tfpassword;
	}

	public JComboBox getCbx() {
		return cbx;
	}
}
