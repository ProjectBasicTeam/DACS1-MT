package Controllers;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Views.Managers;



public class MenuManagers {
	private JMenuBar menuBar;
    private Managers mainPanel;
	public MenuManagers(Managers mainPanel) {
		this.mainPanel = mainPanel;
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Lựa chọn quản lý");
        JMenuItem menuItem1 = new JMenuItem("Tài khoản");
        JMenuItem menuItem2 = new JMenuItem("Nhân viên");
        JMenuItem menuItem3 = new JMenuItem("Lương tháng");

        menuItem1.addActionListener(e -> mainPanel.getCardLayout().show(mainPanel.getPncontainer(), "Panel 1"));
        menuItem2.addActionListener(e -> mainPanel.getCardLayout().show(mainPanel.getPncontainer(), "Panel 2"));
        menuItem3.addActionListener(e -> mainPanel.getCardLayout().show(mainPanel.getPncontainer(), "Panel 3"));


        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menuBar.add(menu);
	}
	public JMenuBar getMenuBar() {
        return menuBar;
    }
    
}
