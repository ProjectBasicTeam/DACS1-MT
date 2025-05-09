package Views;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import Controllers.MenuCategory;
import java.awt.CardLayout;
import java.awt.Color;

public class Category extends JPanel {
    private JPanel pncontainer, panel;
    private CardLayout cardLayout;
    private MenuCategory ControllMenu;

    void MenuJPanel() {
        cardLayout = new CardLayout();
        pncontainer = new JPanel(cardLayout);
        pncontainer.setBackground(new Color(255, 255, 255));
        pncontainer.setBounds(0, 30, 1309, 917);
        panel.add(pncontainer);

        pncontainer.add(new WarehouseProduct(), "Panel 1");
        pncontainer.add(new Warehouse(), "Panel 2");
        
        ControllMenu = new MenuCategory(this);
        JMenuBar menuBar = ControllMenu.getMenuBar();
        menuBar.setBounds(0, 0, 115, 30);
        menuBar.setBackground(new Color(255, 255, 255));

        add(menuBar);
        panel.add(menuBar);
    }

    void init() {
        MenuJPanel();
    }

    public Category() {
        setLayout(null);
        panel = new JPanel(); 
        panel.setBackground(new Color(200, 32, 32));
        panel.setBounds(0, 0, 1309, 946);
        panel.setLayout(null);
        add(panel);
        
        init();
    }

    public JPanel getPncontainer() {
        return pncontainer;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
