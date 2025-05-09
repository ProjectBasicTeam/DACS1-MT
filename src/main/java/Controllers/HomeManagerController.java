package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Services.AccountManagers;
import Services.EmployeesManagers;
import Views.HomeManager;

public class HomeManagerController {
    private HomeManager view;
    private MenuManager menuManager;
    private int eid;
    private AccountManagers ser1;
    private EmployeesManagers ser2;
    public HomeManagerController(int id, HomeManager view, MenuManager menuManager) {
        this.view = view;
        this.menuManager = menuManager;
        this.eid = id;
        ser2 = EmployeesManagers.getInstance();
        ser1 = AccountManagers.getInstance();
        this.view.getBtnresetstatus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ser2.setNullStatus(ser1.getAccountbrancha(eid));
            }
        });
        this.view.getBtnStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                menuManager.navigateToPanel("2");
            }
        });
    }
}

