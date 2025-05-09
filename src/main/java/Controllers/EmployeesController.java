package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Services.EmployeesManagers;
import Views.DashboardAdmin;
import Views.Employees;
import Views.Managementsalary;
import Models.EmployeesM;

public class EmployeesController {
	private Employees view;
	private EmployeesManagers ser;
	
	public EmployeesController(Employees view) {
	
		this.view = view;
		this.ser = EmployeesManagers.getInstance();
		
		LoadDataEM();
		addListeners();
	}
	public void LoadDataEM() {
		ArrayList<EmployeesM> list = ser.loadEmployees();

		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setRowCount(0); 
		
		for (EmployeesM e : list) {
			model.addRow(new Object[]{
				e.getIdnv(),
				e.getNamenv(),
				e.getGendernv(),
				e.getPhonenv(),
				e.getCccdnv(),
				e.getBirth(),
				e.getWorknv(),
				e.getBrancha()
			});
		}
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(180);
		view.getTable().getColumnModel().getColumn(1).setPreferredWidth(350);
		view.getTable().getColumnModel().getColumn(2).setPreferredWidth(100);
		view.getTable().getColumnModel().getColumn(3).setPreferredWidth(150);
		view.getTable().getColumnModel().getColumn(4).setPreferredWidth(150);
		view.getTable().getColumnModel().getColumn(5).setPreferredWidth(150);
		view.getTable().getColumnModel().getColumn(6).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(7).setPreferredWidth(400);	
	}
	
	private boolean isEmpty() {
		if (view.getTfidnv().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập mã nhân viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfnamenv().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên nhân viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfcccdnv().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập căn cước công dân nhân viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfcccdnv().getText().length() > 13) {
			JOptionPane.showMessageDialog(view, "Căn cước công dân phải đủ 12 số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfcccdnv().getText().length() < 11) {
			JOptionPane.showMessageDialog(view, "Căn cước công dân phải đủ 12 số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTflocationnv().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập tên chi nhánh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfdatenv().getDate() == null) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập ngày tháng năm sinh", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphonenv().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphonenv().getText().length() > 11) {
			JOptionPane.showMessageDialog(view, "Số điện thoại quá dài", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} if (view.getTfphonenv().getText().length() < 10) {
			JOptionPane.showMessageDialog(view, "Số điện thoại quá ngắn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	public void resetEmployee() {
		view.getTfsearchnv().setText("");
		view.getTfidnv().setText("");
		view.getTfnamenv().setText("");
		view.getCbgendernv().setSelectedIndex(0);
		view.getTfphonenv().setText("");
		view.getTfcccdnv().setText("");
		view.getTfdatenv().setDate(null);
		view.getCbworkernv().setSelectedIndex(0);
		view.getTflocationnv().setText("");
		LoadDataEM();
	}
	public void addEmployee() {
	    try {
	        int id = Integer.parseInt(view.getTfidnv().getText());
	        String name = view.getTfnamenv().getText();
	        String gender = (String) view.getCbgendernv().getSelectedItem();
	        String phone = view.getTfphonenv().getText();
	        String cccd = view.getTfcccdnv().getText();
	        java.util.Date utilBirthDate = view.getTfdatenv().getDate(); 
	        Date birth = new Date(utilBirthDate.getTime());
	        String work = (String) view.getCbworkernv().getSelectedItem();
	        String branch = view.getTflocationnv().getText();

	        EmployeesM em = new EmployeesM(id, name, gender, phone, cccd, birth, work, branch);

	        ser.insertEmployees(em);

	        JOptionPane.showMessageDialog(view, "Thêm nhân viên thành công!");
	       
	        LoadDataEM();
	        
	        resetEmployee();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(view, "ID phải là số!");
	    }
	}
	public void updateEmployee() {
	    try {
	    int id = Integer.parseInt(view.getTfidnv().getText());
        String name = view.getTfnamenv().getText();
        String gender = (String) view.getCbgendernv().getSelectedItem();
        String phone = view.getTfphonenv().getText();
        String cccd = view.getTfcccdnv().getText();
        java.util.Date utilBirthDate = view.getTfdatenv().getDate(); 
        Date birth = new Date(utilBirthDate.getTime());
        String work = (String) view.getCbworkernv().getSelectedItem();
        String branch = view.getTflocationnv().getText();

	        ser.updateEmployees(id, name, gender, phone, cccd, birth, work, branch);

	        JOptionPane.showMessageDialog(view, "Cập nhật nhân viên thành công!");
	        LoadDataEM();
	        resetEmployee();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(view, "ID phải là số!");
	    }
	}
	public void deleteEmployee() {
		try {
			int id = Integer.parseInt(view.getTfidnv().getText());

	        ser.deleteEmployees(id);

	        LoadDataEM();
	        resetEmployee();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(view, "ID phải là số!");
	    }
	}
	
	private void addListeners() {
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow != -1) {
                    	Object idObj = view.getTable().getValueAt(selectedRow, 0);
                    	view.getTfidnv().setText(idObj != null ? idObj.toString() : "");

                    	Object nameObj = view.getTable().getValueAt(selectedRow, 1);
                    	view.getTfnamenv().setText(nameObj != null ? nameObj.toString() : "");

                    	Object phoneObj = view.getTable().getValueAt(selectedRow, 3);
                    	view.getTfphonenv().setText(phoneObj != null ? phoneObj.toString() : "");

                    	Object cccdObj = view.getTable().getValueAt(selectedRow, 4);
                    	view.getTfcccdnv().setText(cccdObj != null ? cccdObj.toString() : "");

                    	Object branchObj = view.getTable().getValueAt(selectedRow, 7);
                    	view.getTflocationnv().setText(branchObj != null ? branchObj.toString() : "");

                    	Object genderObj = view.getTable().getValueAt(selectedRow, 2);
                    	if (genderObj != null) view.getCbgendernv().setSelectedItem(genderObj.toString());

                    	Object workObj = view.getTable().getValueAt(selectedRow, 6);
                    	if (workObj != null) view.getCbworkernv().setSelectedItem(workObj.toString());

                    	Object birthObj = view.getTable().getValueAt(selectedRow, 5);
                    	if (birthObj instanceof java.sql.Date) {
                    	    java.sql.Date sqlDate = (java.sql.Date) birthObj;
                    	    view.getTfdatenv().setDate(sqlDate);
                    	} else {
                    	    view.getTfdatenv().setDate(null);
                    	}
                       
                        
                    }
                }
            }
        });
		view.getTfphonenv().addKeyListener(new KeyAdapter() {
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
		    	resetEmployee();
		    } 
		});
		view.getBtnadd().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(isEmpty()) {
		    		addEmployee();
		    	}
		    }
		});
		view.getBtnedit().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    		updateEmployee();
		    	}
		    }
		});
		view.getBtndelete().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    		deleteEmployee();
		    	}
		    }
		});
		view.getTfsearchnv().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearchnv().getText(); 
//		        view.getTable().setModel(new DefaultTableModel(null, new Object[]{"Mã nhân viên", "Tên nhân viên", "Giới tính", "Số điện thoại", "CCCD", "Ngày sinh", "Công việc", "Tên chi nhánh làm việc"}));
		        ser.getEmployeesValue(view.getTable(), search); 
		    }
		});
	}
}