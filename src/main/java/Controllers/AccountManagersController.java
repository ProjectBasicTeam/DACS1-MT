package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Models.Account;
import Services.AccountManagers;
import Views.Managementstaff;

public class AccountManagersController {
	private Managementstaff view;
	private AccountManagers service;

	public AccountManagersController(Managementstaff view) {
		this.view = view;
		this.service = AccountManagers.getInstance(); 
		LoadData();
		addListeners();
		view.getTfidql().setText(String.valueOf(service.getMaxrow()));
	}

	public void LoadData() {
		ArrayList<Account> list = service.loadAccount();

		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setRowCount(0); 
		
		for (Account acc : list) {
			model.addRow(new Object[]{
				acc.getIda(),
				acc.getNamea(),
				acc.getPassworda(),
				acc.getBrancha(),
				acc.getAddressa(),
				acc.getPhonea(),
				acc.getRolea()
			});
		}
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(200);
		view.getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
		view.getTable().getColumnModel().getColumn(2).setPreferredWidth(250);
		view.getTable().getColumnModel().getColumn(3).setPreferredWidth(400);
		view.getTable().getColumnModel().getColumn(4).setPreferredWidth(575);
		view.getTable().getColumnModel().getColumn(5).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(6).setPreferredWidth(300);
	}
	public void resetAccount() {
		view.getTfidql().setText("");
    	view.getTfnameql().setText("");
    	view.getTfpasswordql().setText("");
    	view.getTflocationql().setText("");
    	view.getTfadressql().setText("");
    	view.getTfphoneql().setText("");
    	view.getTfsearch().setText("");
    	view.getCbx().setSelectedIndex(0);
	}
	
	private boolean isEmpty() {
		if (view.getTfnameql().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfpasswordql().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập mật khẩu tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTflocationql().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfadressql().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập địa chỉ chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphoneql().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphoneql().getText().length() > 11) {
			JOptionPane.showMessageDialog(view, "Số điện thoại quá dài", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphoneql().getText().length() < 10) {
			JOptionPane.showMessageDialog(view, "Số điện thoại quá ngắn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	public void addAccount() {
	    try {
	        int id = Integer.parseInt(view.getTfidql().getText());
	        String name = view.getTfnameql().getText();
	        String password = view.getTfpasswordql().getText();
	        String branch = view.getTflocationql().getText();
	        String address = view.getTfadressql().getText();
	        String phone = view.getTfphoneql().getText();
	        String role = (String) view.getCbx().getSelectedItem();
	        Account account = new Account(id, name, password, branch, address, phone,role);

	        AccountManagers.getInstance().insertAccount(account);

	        JOptionPane.showMessageDialog(view, "Thêm tài khoản thành công!");
	        LoadData();
	        resetAccount();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(view, "ID phải là số!");
	    }
	}
	public void updateAccount() {
	    try {
	        int id = Integer.parseInt(view.getTfidql().getText());
	        String name = view.getTfnameql().getText();
	        String password = view.getTfpasswordql().getText();
	        String branch = view.getTflocationql().getText();
	        String address = view.getTfadressql().getText();
	        String phone = view.getTfphoneql().getText();
	        String role = (String) view.getCbx().getSelectedItem();

	        AccountManagers.getInstance().updateAccount(id, name, password, branch, address, phone,role);

	        JOptionPane.showMessageDialog(view, "Cập nhật tài khoản thành công!");
	        LoadData();
	        resetAccount();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(view, "ID phải là số!");
	    }
	}
	public void deleteAccount() {
		int id = Integer.parseInt(view.getTfidql().getText());
		AccountManagers.getInstance().deleteAccount(id);
		LoadData();
		JOptionPane.showMessageDialog(view, "Xoá tài khoản thành công!");
		resetAccount();
	}

	private void addListeners() {
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow != -1) {
                        view.getTfidql().setText(view.getTable().getValueAt(selectedRow, 0).toString());
                        view.getTfnameql().setText(view.getTable().getValueAt(selectedRow, 1).toString());
                        view.getTfpasswordql().setText(view.getTable().getValueAt(selectedRow, 2).toString());
                        view.getTflocationql().setText(view.getTable().getValueAt(selectedRow, 3).toString());
                        view.getTfadressql().setText(view.getTable().getValueAt(selectedRow, 4).toString());
                        view.getTfphoneql().setText(view.getTable().getValueAt(selectedRow, 5).toString());
                        String role = view.getTable().getValueAt(selectedRow, 6).toString();
                        view.getCbx().setSelectedItem(role);
                    }
                }
            }
        });
		view.getTfphoneql().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if (!Character.isDigit(input) && input != '\b') {
					e.consume();
					JOptionPane.showMessageDialog(view, "Xin vui lòng chỉ nhập số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		view.getBtnreset().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	resetAccount();
		    }
		});
		view.getBtnadd().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	view.getTfidql().setText(String.valueOf(service.getMaxrow()));
		    	if(isEmpty()) {
		    		addAccount();
		    	}
		    }
		});
		view.getBtnedit().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    		updateAccount();
		    	}
		    }
		}); 
		view.getBtndelete().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    		deleteAccount();
		    	}
		    }
		});
		view.getTfsearch().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearch().getText(); 
		        view.getTable().setModel(new DefaultTableModel(null, new Object[]{"Mã tk quản lý", "Tên chi nhánh quản lý", "Mật khẩu", "Chi nhánh", "Địa chỉ chi nhánh", "Số điện thoại", "Vai Trò"}));
		        service.getAccountValue(view.getTable(), search); 
		    }
		});
	}
	
}
