package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Controllers.MenuAdmin;
import Views.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JScrollPane;

public class DashboardAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pn1,pn2,pn3,pn4,pn5,pn6,pn12,pn22,pn32,pn42,pn52,pn62,pnfix, pnlogout;
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6,lbfix,lblogout;
	private CardLayout cardlayout;
	private JPanel panelcard;
	private JScrollPane scrollPane;
	private JPanel pnnamedb;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	
	 
	void Menu() {
	    cardlayout = new CardLayout();
	    panelcard = new JPanel();
	    panelcard.setLayout(cardlayout);
	    
	    // HomeAdmin có thanh cuộn riêng
	    HomeAdmin homePanel = new HomeAdmin();
	    JScrollPane scrollPaneHome = new JScrollPane(homePanel);
	    scrollPaneHome.getVerticalScrollBar().setUnitIncrement(30); // Tăng tốc độ cuộn

	    // Thêm vào card layout
	    panelcard.add(scrollPaneHome, "1");  // Chỉ HomeAdmin có thanh cuộn
	    panelcard.add(new Supplier(), "2");
	    panelcard.add(new Category(), "3");
	    panelcard.add(new Managers(), "4");
	    panelcard.add(new History(), "5");
	    panelcard.add(new Revenue(), "6");

	    cardlayout.show(panelcard, "1"); // Mặc định hiển thị HomeAdmin
	    
	    // Thêm panelcard vào contentPane
	    panelcard.setBounds(399, 100, 1309, 946);
	    contentPane.add(panelcard);
	}

	void init() {
		Menu();
		new MenuAdmin(this);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardAdmin frame = new DashboardAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DashboardAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1721, 1149);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnheader = new JPanel();
		pnheader.setLayout(null);
		pnheader.setBackground(new Color(200, 32, 32));
//		pnheader.setBackground(new Color(255, 255, 255));

		pnheader.setBounds(0, 0, 1710, 100);
		contentPane.add(pnheader);
		
		lblNewLabel_1 = new JLabel("QUẢN TRỊ VIÊN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 50));
		lblNewLabel_1.setBounds(581, 11, 572, 66);
		pnheader.add(lblNewLabel_1);
		
		JPanel pnsidebar = new JPanel();
		pnsidebar.setLayout(null);
		pnsidebar.setBackground(new Color(55, 57, 58));
		pnsidebar.setBounds(0, 100, 400, 947);
		contentPane.add(pnsidebar);
		
		 pn1 = new JPanel();
		pn1.setLayout(null);
		pn1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn1.setBackground(new Color(55, 57, 58));
		pn1.setBounds(0, 220, 400, 70);
		pnsidebar.add(pn1);
		
		 lb1 = new JLabel("  Trang chủ");
		 lb1.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/Home.png")));
		 lb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb1.setHorizontalAlignment(SwingConstants.LEFT);
		lb1.setForeground(Color.GRAY);
		lb1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lb1.setBounds(44, 0, 356, 70);
		pn1.add(lb1);
		
		 pn12 = new JPanel();
		pn12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn12.setBackground(new Color(55, 57, 58));
		pn12.setBounds(10, 0, 20, 70);
		pn1.add(pn12);
		
		 pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn2.setBackground(new Color(55, 57, 58));
		pn2.setBounds(0, 291, 400, 70);
		pnsidebar.add(pn2);
		
		 lb2 = new JLabel("  Nhà cung cấp");
		 lb2.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/suplierd.png")));
		 lb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb2.setHorizontalAlignment(SwingConstants.LEFT);
		lb2.setForeground(Color.GRAY);
		lb2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lb2.setBounds(44, 0, 356, 70);
		pn2.add(lb2);
		
		 pn22 = new JPanel();
		pn22.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn22.setBackground(new Color(55, 57, 58));
		pn22.setBounds(10, 0, 20, 70);
		pn2.add(pn22);
		
		 pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn3.setBackground(new Color(55, 57, 58));
		pn3.setBounds(0, 362, 400, 70);
		pnsidebar.add(pn3);
		
		 lb3 = new JLabel("  Quản lý kho");
		 lb3.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/categoryd.png")));
		 lb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb3.setHorizontalAlignment(SwingConstants.LEFT);
		lb3.setForeground(Color.GRAY);
		lb3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lb3.setBounds(44, 0, 356, 70);
		pn3.add(lb3);
		
		 pn32 = new JPanel();
		pn32.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn32.setBackground(new Color(55, 57, 58));
		pn32.setBounds(10, 0, 20, 70);
		pn3.add(pn32);
		
		 pn4 = new JPanel();
		pn4.setLayout(null);
		pn4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn4.setBackground(new Color(55, 57, 58));
		pn4.setBounds(0, 433, 400, 70);
		pnsidebar.add(pn4);
		
		 lb4 = new JLabel("  Quản lý tài khoản");
		 lb4.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/Accountd.png")));
		 lb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb4.setHorizontalAlignment(SwingConstants.LEFT);
		lb4.setForeground(Color.GRAY);
		lb4.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lb4.setBounds(44, 0, 356, 70);
		pn4.add(lb4);
		
		 pn42 = new JPanel();
		pn42.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn42.setBackground(new Color(55, 57, 58));
		pn42.setBounds(10, 0, 20, 70);
		pn4.add(pn42);
		
		 pn5 = new JPanel();
		pn5.setLayout(null);
		pn5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn5.setBackground(new Color(55, 57, 58));
		pn5.setBounds(0, 504, 400, 70);
		pnsidebar.add(pn5);
		
		 lb5 = new JLabel("  Quản lý lịch sử");
		 lb5.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/historic.png")));
		 lb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb5.setHorizontalAlignment(SwingConstants.LEFT);
		lb5.setForeground(Color.GRAY);
		lb5.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lb5.setBounds(44, 0, 356, 70);
		pn5.add(lb5);
		
		 pn52 = new JPanel();
		pn52.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn52.setBackground(new Color(55, 57, 58));
		pn52.setBounds(10, 0, 20, 70);
		pn5.add(pn52);
		
		pn6 = new JPanel();
		pn6.setLayout(null);
		pn6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn6.setBackground(new Color(55, 57, 58));
		pn6.setBounds(0, 575, 400, 70);
		pnsidebar.add(pn6);
		
		lb6 = new JLabel("  Doanh thu");
		lb6.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/moneyd.png")));
		lb6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb6.setHorizontalAlignment(SwingConstants.LEFT);
		lb6.setForeground(Color.GRAY);
		lb6.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lb6.setBounds(44, 0, 356, 70);
		pn6.add(lb6);
		
		pn62 = new JPanel();
		pn62.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn62.setBackground(new Color(55, 57, 58));
		pn62.setBounds(10, 0, 20, 70);
		pn6.add(pn62);
		
		pnfix = new JPanel();
		pnfix.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		pnfix.setBackground(new Color(55, 57, 58));
		pnfix.setBounds(66, 825, 85, 70);
		pnsidebar.add(pnfix);
		pnfix.setLayout(null);
		
		lbfix = new JLabel("");
		lbfix.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/fix.png")));
		lbfix.setBounds(0, 0, 85, 70);
		pnfix.add(lbfix);
		lbfix.setHorizontalAlignment(SwingConstants.CENTER);
		lbfix.setForeground(new Color(255, 255, 255));
		lbfix.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		pnlogout = new JPanel();
		pnlogout.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlogout.setBackground(new Color(55, 57, 58));
		pnlogout.setLayout(null);
		pnlogout.setBounds(241, 825, 85, 70);
		pnsidebar.add(pnlogout);
		
		lblogout = new JLabel("");
		lblogout.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/logout.png")));
		lblogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblogout.setForeground(Color.WHITE);
		lblogout.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblogout.setBounds(0, 0, 85, 70);
		pnlogout.add(lblogout);
		
		pnnamedb = new JPanel();
		pnnamedb.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		pnnamedb.setBackground(new Color(55, 57, 58));
		pnnamedb.setBounds(10, 34, 380, 111);
		pnsidebar.add(pnnamedb);
		pnnamedb.setLayout(null);
		
		lblNewLabel = new JLabel("POKEM    N TCG");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 23, 360, 64);
		pnnamedb.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/pokebal50.png")));
		lblNewLabel_2.setBounds(179, 29, 50, 50);
		pnnamedb.add(lblNewLabel_2);
		
		
		init();
	}


	public JPanel getPn1() {
		return pn1;
	}

	public void setPn1(JPanel pn1) {
		this.pn1 = pn1;
	}

	public JPanel getPn2() {
		return pn2;
	}

	public void setPn2(JPanel pn2) {
		this.pn2 = pn2;
	}

	public JPanel getPn3() {
		return pn3;
	}

	public void setPn3(JPanel pn3) {
		this.pn3 = pn3;
	}

	public JPanel getPn4() {
		return pn4;
	}

	public void setPn4(JPanel pn4) {
		this.pn4 = pn4;
	}

	public JPanel getPn5() {
		return pn5;
	}

	public void setPn5(JPanel pn5) {
		this.pn5 = pn5;
	}

	public JPanel getPn6() {
		return pn6;
	}

	public void setPn6(JPanel pn6) {
		this.pn6 = pn6;
	}

	public JPanel getPn12() {
		return pn12;
	}

	public void setPn12(JPanel pn12) {
		this.pn12 = pn12;
	}

	public JPanel getPn22() {
		return pn22;
	}

	public void setPn22(JPanel pn22) {
		this.pn22 = pn22;
	}

	public JPanel getPn32() {
		return pn32;
	}

	public void setPn32(JPanel pn32) {
		this.pn32 = pn32;
	}

	public JPanel getPn42() {
		return pn42;
	}

	public void setPn42(JPanel pn42) {
		this.pn42 = pn42;
	}

	public JPanel getPn52() {
		return pn52;
	}

	public void setPn52(JPanel pn52) {
		this.pn52 = pn52;
	}

	public JPanel getPn62() {
		return pn62;
	}

	public void setPn62(JPanel pn62) {
		this.pn62 = pn62;
	}

	public JPanel getPnfix() {
		return pnfix;
	}

	public void setPnfix(JPanel pnfix) {
		this.pnfix = pnfix;
	}

	

	public JLabel getLb1() {
		return lb1;
	}

	public void setLb1(JLabel lb1) {
		this.lb1 = lb1;
	}

	public JLabel getLb2() {
		return lb2;
	}

	public void setLb2(JLabel lb2) {
		this.lb2 = lb2;
	}

	public JLabel getLb3() {
		return lb3;
	}

	public void setLb3(JLabel lb3) {
		this.lb3 = lb3;
	}

	public JLabel getLb4() {
		return lb4;
	}

	public void setLb4(JLabel lb4) {
		this.lb4 = lb4;
	}

	public JLabel getLb5() {
		return lb5;
	}

	public void setLb5(JLabel lb5) {
		this.lb5 = lb5;
	}

	public JLabel getLb6() {
		return lb6;
	}

	public void setLb6(JLabel lb6) {
		this.lb6 = lb6;
	}

	public JLabel getLbfix() {
		return lbfix;
	}

	public void setLbfix(JLabel lbfix) {
		this.lbfix = lbfix;
	}

	public JLabel getLblogout() {
		return lblogout;
	}

	public void setLblogout(JLabel lblogout) {
		this.lblogout = lblogout;
	}

	public CardLayout getCardlayout() {
		return cardlayout;
	}

	public void setCardlayout(CardLayout cardlayout) {
		this.cardlayout = cardlayout;
	}

	public JPanel getPanelcard() {
		return panelcard;
	}

	public void setPanelcard(JPanel panelcard) {
		this.panelcard = panelcard;
	}
}
