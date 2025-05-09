package Views;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import Controllers.AccountController;
import Controllers.EmtimekeepingController;
import Controllers.MenuManager;
import Controllers.VerifyAccountController;
import Services.AccountManagers;

import java.awt.Cursor;
import javax.swing.ImageIcon;

public class DashboardManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardlayout;
	private JPanel panelcard;
	private JPanel pn1, pn2, pn3, pn4;
	private JPanel pn12, pn22, pn32, pn42;
	private JLabel lb1, lb2, lb3, lb4;
	private Color clpurple = new Color(44, 41, 62);
	private MenuManager menu;
	private HomeManager homeManager = new HomeManager();
	private Purchase purchase = new Purchase();
	private Details details = new Details();
	private JLabel lblogout;
	private JLabel lbnamedb;
	private JLabel lblNewLabel_4;
	private Account accountView;
	private Employeetimekeeping em;
	public String MnId;
	private JLabel lbid;
	private int id;
	private JLabel lbfix;

	public int getId() {
		return id;
	}

	public String getMnId() {
		return MnId;
	}

	public void setMnId(String mnId) {
		MnId = mnId;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public HomeManager getHomeManager() {
		return homeManager;
	}

	public Details getDetails() {
		return details;
	}

	public Account getAccountView() {
		return accountView;
	}

	public void setvalueaccount(int id, String name) {
		lbnamedb.setText(name);
		accountView.getLbnameacc().setText(name);
		accountView.getLbid().setText(String.valueOf(id));
		this.MnId = String.valueOf(id);
		lbid.setText(MnId);

	}

	public JPanel getPanelcard() {
		return panelcard;
	}

	public void setPanelcard(JPanel panelcard) {
		this.panelcard = panelcard;
	}

	public CardLayout getCardlayout() {
		return cardlayout;
	}

	public void setCardlayout(CardLayout cardlayout) {
		this.cardlayout = cardlayout;
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

	private void Menu() {
		cardlayout = new CardLayout();
		panelcard = new JPanel();
		panelcard.setBounds(400, 100, 1309, 946);
		panelcard.setLayout(cardlayout);
		contentPane.add(panelcard);
		panelcard.add(purchase, "2");
		panelcard.add(details, "3");
		em = new Employeetimekeeping();
		panelcard.add(em, "4");
		panelcard.add(new VerifyAccount(), "5");
		accountView = new Account();
		panelcard.add(accountView, "6");
		panelcard.add(homeManager, "1");
		cardlayout.show(panelcard, "1");
	}

	private void init() {
		Menu();
		new MenuManager(id, this);
		new VerifyAccountController(this);
		String username = lbnamedb.getText();
		AccountController ac = new AccountController(id, accountView);
		EmtimekeepingController ec = new EmtimekeepingController(id, em);
	}

	public DashboardManager(int id, String name) {
		this.id = id;
		this.MnId = String.valueOf(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1960, 1102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);

		JPanel pnheader = new JPanel();
		pnheader.setBackground(new Color(200, 32, 32));
		pnheader.setBounds(0, 0, 1710, 100);
		contentPane.add(pnheader);
		pnheader.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ BÁN HÀNG");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 50));
		lblNewLabel_1.setBounds(608, 23, 572, 66);
		pnheader.add(lblNewLabel_1);

		lbnamedb = new JLabel("Loadiing...");
		lbnamedb.setForeground(new Color(255, 255, 255));
		lbnamedb.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 22));
		lbnamedb.setBounds(186, 50, 299, 44);
		pnheader.add(lbnamedb);

		lblNewLabel_4 = new JLabel("Tài khoản:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_4.setBounds(0, 50, 124, 43);
		pnheader.add(lblNewLabel_4);

		lbid = new JLabel("Loadiing...");
		lbid.setForeground(Color.WHITE);
		lbid.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 22));
		lbid.setBounds(186, 0, 299, 44);
		pnheader.add(lbid);

		JLabel lblNewLabel_4_1 = new JLabel("Mã tài khoản:");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(10, 0, 148, 43);
		pnheader.add(lblNewLabel_4_1);

		JPanel pnsidebar = new JPanel();
		pnsidebar.setBackground(new Color(55, 57, 58));
		pnsidebar.setBounds(0, 100, 400, 947);
		contentPane.add(pnsidebar);
		pnsidebar.setLayout(null);

		pn1 = new JPanel();
		pn1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn1.setBackground(new Color(55, 57, 58));
		pn1.setBounds(0, 220, 400, 70);
		pnsidebar.add(pn1);
		pn1.setLayout(null);

		lb1 = new JLabel("  Mua hàng");
		lb1.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/purchased.png")));
		lb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb1.setForeground(Color.GRAY);
		lb1.setHorizontalAlignment(SwingConstants.LEFT);
		lb1.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lb1.setBounds(44, 0, 356, 70);
		pn1.add(lb1);

		pn12 = new JPanel();
		pn12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn12.setBackground(new Color(55, 57, 58));
		pn12.setBounds(10, 0, 20, 70);
		pn1.add(pn12);

		pn2 = new JPanel();
		pn2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn2.setBackground(new Color(55, 57, 58));
		pn2.setBounds(0, 291, 400, 70);
		pnsidebar.add(pn2);
		pn2.setLayout(null);

		lb2 = new JLabel("  Hoá đơn chi tiết");
		lb2.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/Detaild.png")));
		lb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb2.setForeground(Color.GRAY);
		lb2.setHorizontalAlignment(SwingConstants.LEFT);
		lb2.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lb2.setBounds(44, 0, 356, 70);
		pn2.add(lb2);

		pn22 = new JPanel();
		pn22.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn22.setBackground(new Color(55, 57, 58));
		pn22.setBounds(10, 0, 20, 70);
		pn2.add(pn22);

		pn3 = new JPanel();
		pn3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn3.setBackground(new Color(55, 57, 58));
		pn3.setBounds(0, 362, 400, 70);
		pnsidebar.add(pn3);
		pn3.setLayout(null);

		lb3 = new JLabel("  Chấm công nhân viên");
		lb3.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/Employeed.png")));
		lb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb3.setForeground(Color.GRAY);
		lb3.setHorizontalAlignment(SwingConstants.LEFT);
		lb3.setFont(new Font("Segoe UI", Font.BOLD, 29));
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

		lb4 = new JLabel("  Thông tin tài khoản");
		lb4.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/infod.png")));
		lb4.setHorizontalAlignment(SwingConstants.LEFT);
		lb4.setForeground(Color.GRAY);
		lb4.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lb4.setBounds(44, 0, 356, 70);
		pn4.add(lb4);

		pn42 = new JPanel();
		pn42.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pn42.setBackground(new Color(55, 57, 58));
		pn42.setBounds(10, 0, 20, 70);
		pn4.add(pn42);

		JPanel pnnamedb = new JPanel();
		pnnamedb.setLayout(null);
		pnnamedb.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		pnnamedb.setBackground(new Color(55, 57, 58));
		pnnamedb.setBounds(10, 51, 380, 111);
		pnsidebar.add(pnnamedb);

		JLabel lblNewLabel = new JLabel("POKEM    N TGC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 23, 360, 64);
		pnnamedb.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/pokebal50.png")));
		lblNewLabel_2.setBounds(179, 29, 50, 50);
		pnnamedb.add(lblNewLabel_2);

		JPanel pnfix = new JPanel();
		pnfix.setLayout(null);
		pnfix.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		pnfix.setBackground(new Color(55, 57, 58));
		pnfix.setBounds(55, 734, 85, 70);
		pnsidebar.add(pnfix);

		lbfix = new JLabel("");
		lbfix.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/fix.png")));
		lbfix.setHorizontalAlignment(SwingConstants.CENTER);
		lbfix.setForeground(Color.WHITE);
		lbfix.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbfix.setBounds(0, 0, 85, 70);
		pnfix.add(lbfix);

		JPanel pnlogout = new JPanel();
		pnlogout.setLayout(null);
		pnlogout.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlogout.setBackground(new Color(55, 57, 58));
		pnlogout.setBounds(256, 734, 85, 70);
		pnsidebar.add(pnlogout);

		lblogout = new JLabel("");
		lblogout.setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/logout.png")));
		lblogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblogout.setForeground(Color.WHITE);
		lblogout.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblogout.setBounds(0, 0, 85, 70);
		pnlogout.add(lblogout);

		init();
	}

	public JLabel getLblogout() {
		return lblogout;
	}

	public void setLbnamedb(JLabel lbnamedb) {
		this.lbnamedb = lbnamedb;
	}

	public JLabel getLbnamedb() {
		return lbnamedb;
	}

	public JLabel getLbid() {
		return lbid;
	}
	public JLabel getLbfix() {
		return lbfix;
	}
}
