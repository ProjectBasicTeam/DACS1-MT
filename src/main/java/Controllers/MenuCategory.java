package Controllers;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Views.Category;

public class MenuCategory {
    private JMenuBar menuBar;
    private Category mainPanel;

    public MenuCategory(Category mainPanel) {
        this.mainPanel = mainPanel;
        menuBar = new JMenuBar();

        JMenu menu = new JMenu("Lựa chọn quản lý");
        JMenuItem menuItem1 = new JMenuItem("Kho chính");
        JMenuItem menuItem2 = new JMenuItem("Danh sách chi nhánh");

        menuItem1.addActionListener(e -> mainPanel.getCardLayout().show(mainPanel.getPncontainer(), "Panel 1"));
        menuItem2.addActionListener(e -> mainPanel.getCardLayout().show(mainPanel.getPncontainer(), "Panel 2"));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
