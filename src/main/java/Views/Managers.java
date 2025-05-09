package Views;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controllers.MenuManagers;


public class Managers extends JPanel{
	private JPanel pncontainer,panel;
	private CardLayout cardLayout;
	private MenuManagers ControllMenu;
	
	void MenuJPanel() {
		cardLayout = new CardLayout();
		pncontainer = new JPanel(cardLayout);
		pncontainer.setBackground(new Color(255, 255, 255));
		pncontainer.setBounds(0, 30, 1309, 917);
		panel.add(pncontainer);
		pncontainer.add(new Managementstaff(), "Panel 1");
		pncontainer.add(new Employees(), "Panel 2");
		pncontainer.add(new Managementsalary(), "Panel 3");
		ControllMenu = new MenuManagers(this);
		
		JMenuBar menuBar = ControllMenu.getMenuBar();
		
		menuBar.setBounds(0, 0, 115, 30); 
		menuBar.setVisible(true);
		menuBar.setBackground(new Color(255, 255, 255));

        add(menuBar);
        panel.add(menuBar);
	}
	
	void init() {
		MenuJPanel();
	}
	
	public Managers() {
		setLayout(null);
		
		panel = new JPanel();
        panel.setBackground(new Color(200,32,32));
		panel.setBounds(0, 0, 1309, 946);
		add(panel);
		panel.setLayout(null);
		
		
		init();
	}
	public JPanel getPncontainer() {
		return pncontainer;
	}
	public void setPncontainer(JPanel pncontainer) {
		this.pncontainer = pncontainer;
	}
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	
	
	
}
