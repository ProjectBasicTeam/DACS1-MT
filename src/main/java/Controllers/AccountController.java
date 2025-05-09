package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Services.AccountManagers;
import Views.Account;
import Views.DashboardManager;

public class AccountController {
	private DashboardManager db;
	private Account view;
	private AccountManagers ser;
	private int aid;
	String[] value = new String[7];

	public AccountController(int id, Account view) {
	    this.ser = AccountManagers.getInstance();
	    this.view = view; // gán đúng instance đang hiển thị
	    this.aid = id;
	    setValueTf(id);
	    addListeners();
	}
	private boolean isEmpty() {
		if (view.getTfnametk().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfpasswordtk().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập mật khẩu tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTflocation().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfadrresstk().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập địa chỉ chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphonetk().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphonetk().getText().length() > 11) {
			JOptionPane.showMessageDialog(view, "Số điện thoại quá dài", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphonetk().getText().length() < 10) {
			JOptionPane.showMessageDialog(view, "Số điện thoại quá ngắn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	public void updateAccount() {
	    try {
	        int id = Integer.parseInt(view.getTfidtk().getText());
	        String name = view.getTfnametk().getText();
	        String password = view.getTfpasswordtk().getText();
	        String branch = view.getTflocation().getText();
	        String address = view.getTfadrresstk().getText();
	        String phone = view.getTfphonetk().getText();

	        AccountManagers.getInstance().updateAccount2(id, name, password, branch, address, phone);

	        JOptionPane.showMessageDialog(view, "Cập nhật tài khoản thành công!");
	        
	        
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(view, "ID phải là số!");
	    }
	}
	void deleteAccount() {
		int id = Integer.parseInt(view.getTfidtk().getText());
		AccountManagers.getInstance().deleteAccount(id);
		JOptionPane.showMessageDialog(view, "Xoá tài khoản thành công!");
	}
	void setValueTf(int id) {
		value = ser.getAccountValue(id);
		view.getTfidtk().setText(value[0]);
	    view.getTfnametk().setText(value[1]);
	    view.getTfpasswordtk().setText(value[2]);
	    view.getTflocation().setText(value[3]);
	    view.getTfadrresstk().setText(value[4]);

	    if (value.length > 6) {
	        view.getTfphonetk().setText(value[5]);
	    }
	}
	
	private void addListeners() {
		view.getBtnsave().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    		updateAccount();
		    	}
		    }
		});
		view.getBtndeleteacc().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	deleteAccount();
		    	System.exit(0);
		    }
		});
	}
}



	

