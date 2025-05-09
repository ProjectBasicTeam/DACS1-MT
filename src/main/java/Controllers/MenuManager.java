package Controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Services.AccountManagers;

import java.awt.CardLayout;
import Views.DashboardManager;
import Views.Details;
import Views.HomeManager;
import Views.Login;
import Views.Purchase;


public class MenuManager {
    private CardLayout cardLayout;
    private JPanel panelCard;
    private DashboardManager dashboard;
    private int eid;
    private AccountManagers ser;
    private Color clgray = new Color(128, 128, 128);
    private Color clwhite = new Color(245, 240, 245);
    private Color clred = new Color(89, 31, 26);
    private Color clpurple = new Color(55, 57, 58);
    private Color clredd = new Color(200, 32, 32);
    
    public MenuManager(int id, DashboardManager dashboard) {
        this.dashboard = dashboard;
        this.cardLayout = dashboard.getCardlayout();
        this.panelCard = dashboard.getPanelcard();
        this.eid = id;
        ser = AccountManagers.getInstance(); 
        HomeManager homePanel = dashboard.getHomeManager();
        new HomeManagerController(eid,homePanel, this);
        
        Details detail = dashboard.getDetails();
        Purchase purchase = dashboard.getPurchase();
        new DetailController(eid, detail, purchase, this);
        new PurchaseController(eid, purchase, detail, this);
        addListeners();
    }
    private void addListeners() {
    	dashboard.getLbfix().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Nếu có lỗi về kĩ thuật. Xin vui lòng liên hệ kĩ thuật viên fix lỗi SĐT 0905901165");

            }
        });
    	dashboard.getLblogout().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int a = JOptionPane.showOptionDialog(dashboard, "Bạn có muốn đăng xuất bây giờ không?","Đăng xuất",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
				if (a == JOptionPane.YES_OPTION) {
					new Login().setVisible(true);
					dashboard.dispose();
				}
            }
        });
    	dashboard.getLb1().addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 switchToPanel("2", dashboard.getPn1(), dashboard.getLb1(), dashboard.getPn12());
             }
         });
    	dashboard.getLb2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToPanel("3", dashboard.getPn2(), dashboard.getLb2(), dashboard.getPn22());
            }
        });
    	dashboard.getLb3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToPanel("4", dashboard.getPn3(), dashboard.getLb3(), dashboard.getPn32());
            }
        });
    	dashboard.getLb4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToPanel("5", dashboard.getPn4(), dashboard.getLb4(), dashboard.getPn42());
            }
        });

    }
    private void switchToPanel(String panelName, JPanel selectedPanel, JLabel selectedLabel, JPanel selectedIndicator) {
        cardLayout.show(panelCard, panelName);
        
        // Reset màu và icon cho tất cả panel
        resetPanel(dashboard.getPn1(), dashboard.getLb1(),dashboard.getPn12(), "/icon/purchased.png");
        resetPanel(dashboard.getPn2(), dashboard.getLb2(),dashboard.getPn22(), "/icon/Detaild.png");
        resetPanel(dashboard.getPn3(), dashboard.getLb3(),dashboard.getPn32(), "/icon/Employeed.png");
        resetPanel(dashboard.getPn4(), dashboard.getLb4(),dashboard.getPn42(), "/icon/infod.png");

        // Đổi màu và icon cho panel được chọn
        selectedPanel.setBackground(clredd);
        selectedLabel.setForeground(clwhite);
        selectedIndicator.setBackground(clwhite);

        // Cập nhật icon của label được chọn
        if (selectedLabel == dashboard.getLb1()) {
        	dashboard.getLb1().setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/purchasel.png")));
        } else if (selectedLabel == dashboard.getLb2()) {
        	dashboard.getLb2().setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/detall.png")));
        } else if (selectedLabel == dashboard.getLb3()) {
        	dashboard.getLb3().setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/Employeel.png")));
        } else if (selectedLabel == dashboard.getLb4()) {
        	dashboard.getLb4().setIcon(new ImageIcon(DashboardManager.class.getResource("/icon/infol.png")));
        } 
    }

    private void resetPanel(JPanel panel, JLabel label, JPanel indicator, String iconPath) {
        panel.setBackground(clpurple);
        label.setForeground(clgray);
        indicator.setBackground(clpurple);
        if (iconPath != null) {
            label.setIcon(new ImageIcon(DashboardManager.class.getResource(iconPath)));
        }

    } 
    public void navigateToPanel(String panelName) {
        if (panelName.equals("2")) {
            switchToPanel("2", dashboard.getPn1(), dashboard.getLb1(), dashboard.getPn12());
        } else if (panelName.equals("3")) {
            switchToPanel("3", dashboard.getPn2(), dashboard.getLb2(), dashboard.getPn22());
        } else if (panelName.equals("4")) {
            switchToPanel("4", dashboard.getPn3(), dashboard.getLb3(), dashboard.getPn32());
        } else if (panelName.equals("5")) {
            switchToPanel("5", dashboard.getPn4(), dashboard.getLb4(), dashboard.getPn42());
        }
    }

}	    
        

