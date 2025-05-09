package Controllers;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import Views.DashboardAdmin;
import Views.Login;


public class MenuAdmin {
	private CardLayout cardLayout;
    private JPanel panelCard;
    private DashboardAdmin dbadmin;
    private Color clgray = new Color(128, 128, 128);
    private Color clwhite = new Color(245, 240, 245);
    private Color clred = new Color(89, 31, 26);
    private Color clpurple = new Color(55, 57, 58);
    private Color clredd = new Color(200, 32, 32);

    public MenuAdmin(DashboardAdmin dbadmin) {
        this.dbadmin = dbadmin;
    	this.cardLayout = dbadmin.getCardlayout();
        this.panelCard = dbadmin.getPanelcard();
        
        addListeners();
    }

    private void addListeners() {
    	this.dbadmin.getLblogout().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int a = JOptionPane.showOptionDialog(dbadmin, "Bạn có muốn đăng xuất bây giờ không?","Đăng xuất",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
				if (a == JOptionPane.YES_OPTION) {
					new Login().setVisible(true);
					dbadmin.dispose();
            }
      
            }
        });
    	this.dbadmin.getLbfix().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	JOptionPane.showMessageDialog(null, "Nếu có lỗi về kĩ thuật. Xin vui lòng liên hệ kĩ thuật viên fix lỗi SĐT 0905901165");
            }
        });
        this.dbadmin.getLb1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToPanel("1", dbadmin.getPn1(), dbadmin.getLb1(), dbadmin.getPn12());
            }
        });

        this.dbadmin.getLb2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	switchToPanel("2", dbadmin.getPn2(), dbadmin.getLb2(), dbadmin.getPn22());            }
        });

        this.dbadmin.getLb3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	switchToPanel("3", dbadmin.getPn3(), dbadmin.getLb3(), dbadmin.getPn32());
            }
        });
        this.dbadmin.getLb4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	switchToPanel("4", dbadmin.getPn4(), dbadmin.getLb4(), dbadmin.getPn42());
            }
        });
        this.dbadmin.getLb5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	switchToPanel("5", dbadmin.getPn5(), dbadmin.getLb5(), dbadmin.getPn52());
            }
        });
        this.dbadmin.getLb6().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	switchToPanel("6", dbadmin.getPn6(), dbadmin.getLb6(), dbadmin.getPn62());            }
        });
    }

    private void switchToPanel(String panelName, JPanel selectedPanel, JLabel selectedLabel, JPanel selectedIndicator) {
        cardLayout.show(panelCard, panelName);
        
        // Reset màu và icon cho tất cả panel
        resetPanel(dbadmin.getPn1(), dbadmin.getLb1(), dbadmin.getPn12(), "/icon/Home.png");
        resetPanel(dbadmin.getPn2(), dbadmin.getLb2(), dbadmin.getPn22(), "/icon/suplierd.png");
        resetPanel(dbadmin.getPn3(), dbadmin.getLb3(), dbadmin.getPn32(), "/icon/categoryd.png");
        resetPanel(dbadmin.getPn4(), dbadmin.getLb4(), dbadmin.getPn42(), "/icon/Accountd.png");
        resetPanel(dbadmin.getPn5(), dbadmin.getLb5(), dbadmin.getPn52(), "/icon/historic.png");
        resetPanel(dbadmin.getPn6(), dbadmin.getLb6(), dbadmin.getPn62(), "/icon/moneyd.png");

        // Đổi màu và icon cho panel được chọn
        selectedPanel.setBackground(clredd);
        selectedLabel.setForeground(clwhite);
        selectedIndicator.setBackground(clwhite);

        // Cập nhật icon của label được chọn
        if (selectedLabel == dbadmin.getLb1()) {
        	dbadmin.getLb1().setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/home_light.png")));
        } else if (selectedLabel == dbadmin.getLb2()) {
        	dbadmin.getLb2().setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/suplierl.png")));
        } else if (selectedLabel == dbadmin.getLb3()) {
        	dbadmin.getLb3().setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/categoryl.png")));
        } else if (selectedLabel == dbadmin.getLb4()) {
        	dbadmin.getLb4().setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/acountl.png")));
        } else if (selectedLabel == dbadmin.getLb5()) {
        	dbadmin.getLb5().setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/historicl.png")));
        } else if (selectedLabel == dbadmin.getLb6()) {
        	dbadmin.getLb6().setIcon(new ImageIcon(DashboardAdmin.class.getResource("/icon/moneyl.png")));
        }
    }

    private void resetPanel(JPanel panel, JLabel label, JPanel indicator, String iconPath) {
        panel.setBackground(clpurple);
        label.setForeground(clgray);
        indicator.setBackground(clpurple);
        if (iconPath != null) {
            label.setIcon(new ImageIcon(DashboardAdmin.class.getResource(iconPath)));
        }
    }
}
