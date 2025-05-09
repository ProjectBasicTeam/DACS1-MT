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

import Models.EmTimeKeepingM;
import Models.EmployeesSalary;
import Services.AccountManagers;
import Services.EmployeesManagers;
import Views.Employeetimekeeping;

public class EmtimekeepingController {
	private Employeetimekeeping view;
	private int eid;
	private String branch;
	private AccountManagers ser1;
	private EmployeesManagers ser2;
	public EmtimekeepingController(int id, Employeetimekeeping view) {
		this.eid = id;
		this.view = view;
		this.ser1 = AccountManagers.getInstance();
		this.ser2 = EmployeesManagers.getInstance();
		loadData(eid);
		branch = ser1.getAccountbrancha(eid);
		addListeners();
	}
	
	
	private void loadData(int id) {
	 String brancha = ser1.getAccountbrancha(id);
	 ArrayList<EmTimeKeepingM> list = ser2.loadEmployee3(brancha);

		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setRowCount(0); 
		
		for (EmTimeKeepingM e : list) {
			model.addRow(new Object[]{
				e.getIdnv(),
				e.getNamemv(),
				e.getPhonenv(),
				e.getWork(),
				e.getAwol(),
				e.getLate(),
				e.getStatus()
			});
		}
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(150);
		view.getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
		view.getTable().getColumnModel().getColumn(2).setPreferredWidth(160);
		view.getTable().getColumnModel().getColumn(3).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(4).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(5).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(6).setPreferredWidth(600);
		
	}

	private void saveETK() {
	    String choosestatus = (String) view.getCbstatust().getSelectedItem();
	    String chooselate = (String) view.getCblate().getSelectedItem();
	    int idnv = Integer.parseInt(view.getTfidt().getText());
	    if (view.getTfidt().getText().isEmpty()) {
	        JOptionPane.showMessageDialog(view, "Vui lòng chọn nhân viên từ bảng!");
	        return;
	    }
	    if (choosestatus.equals("Chưa có tình hình")) {
	        JOptionPane.showMessageDialog(view, "Xin vui lòng chọn tình trạng hôm nay của nhân viên!");
	        return;
	    }
	    if (choosestatus.equals("Vắng không rõ lý do") && chooselate.equals("Có")) {
	        JOptionPane.showMessageDialog(view, "Nhân viên đã vắng thì không thể đi trễ được!");
	        return;
	    }
	    int shift = ser2.getEmployeeShift(idnv);
	    int awol = ser2.getEmployeeAwol(idnv);
	    int late = ser2.getEmployeeLate(idnv);

	    
	    if (choosestatus.equals("Sáng (9:00-15:00)") || choosestatus.equals("Tối (15:00-21:00)")) {
	        shift += 1;
	    } else if (choosestatus.equals("Sáng-Tối (9:00-21:00)")) {
	        shift += 2;
	    }

	    
	    if (choosestatus.equals("Vắng không rõ lý do")) {
	        awol += 1;
	    }

	    
	    if (chooselate.equals("Có")) {
	        late += 1;
	        choosestatus = choosestatus+", có đi làm trễ!";
	    }

	    
	    ser2.updateETK(idnv, shift, awol, late, choosestatus);
	    resetData();
	    loadData(eid);
	}
	private void editETK() {
	    String choosestatus = view.getTftemp().getText();
	    int idnv = Integer.parseInt(view.getTfidt().getText());
	    JOptionPane.showMessageDialog(view, "Vui lòng chọn tình trạng để sửa tình trạng hôm nay của nhân viên!");
	    view.getCbstatust().setSelectedIndex(0);
	    view.getCblate().setSelectedIndex(0);
	    
	    int shift = ser2.getEmployeeShift(idnv);
	    int awol = ser2.getEmployeeAwol(idnv);
	    int late = ser2.getEmployeeLate(idnv);
	    if (view.getTfidt().getText().isEmpty()) {
	        JOptionPane.showMessageDialog(view, "Vui lòng chọn nhân viên từ bảng!");
	        return;
	    }
	    if (choosestatus.equals("Sáng (9:00-15:00)") || choosestatus.equals("Tối (15:00-21:00)")) {
	        shift -= 1;
	    } else if (choosestatus.equals("Sáng-Tối (9:00-21:00)")) {
	        shift -= 2;
	    }
	    if (choosestatus.equals("Sáng (9:00-15:00), có đi làm trễ!") || choosestatus.equals("Tối (15:00-21:00), có đi làm trễ!")) {
	        shift -= 1;
	        late -=1;
	    } else if (choosestatus.equals("Sáng-Tối (9:00-21:00), có đi làm trễ!")) {
	        shift -= 2;
	        late -= 1;
	    }
	    if (choosestatus.equals("Vắng không rõ lý do")) {
	        awol -= 1;
	    }
	    
	    ser2.updateETK(idnv, shift, awol, late, "");

	    loadData(eid);
	}
	private void resetData() {
		loadData(eid);
		view.getTfidt().setText("");
		view.getTfnamet().setText("");
		view.getTfphonet().setText("");
		view.getTfwork().setText("");
		view.getTftemp().setText("");
		view.getTfsearcht().setText("");
	}
	private void resetAllStatus() {
		ser2.setNullStatus(branch);
		loadData(eid);
	}
	private void addListeners() {
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow != -1) {
                    	Object idObj = view.getTable().getValueAt(selectedRow, 0);
                    	view.getTfidt().setText(idObj != null ? idObj.toString() : "");

                    	Object nameObj = view.getTable().getValueAt(selectedRow, 1);
                    	view.getTfnamet().setText(nameObj != null ? nameObj.toString() : "");

                    	Object phoneObj = view.getTable().getValueAt(selectedRow, 2);
                    	view.getTfphonet().setText(phoneObj != null ? phoneObj.toString() : "");

                    	Object workObj = view.getTable().getValueAt(selectedRow, 3);
                    	view.getTfwork().setText(workObj != null ? workObj.toString() : "");

                    	Object statusObj = view.getTable().getValueAt(selectedRow, 6);
                    	view.getTftemp().setText(statusObj != null ? statusObj.toString() : "");
                    	if (statusObj != null) {view.getCbstatust().setSelectedItem(statusObj.toString());}
                    	else {
                    		view.getCbstatust().setSelectedItem(0);
                    	}
                    	
                    }
                }
            }
        });
		view.getBtnsave().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	saveETK();
		    }
		});
		view.getBtneditstatus().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	editETK();
		    }
		});
		view.getBtnreset().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	resetData();
		    }
		});
		view.getBtnresetstatus().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	resetAllStatus();
		    }
		});
		view.getTfsearcht().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearcht().getText(); 
		        ser2.getEmployeesValue3(view.getTable(), branch, search); 
		    }
		});
	}
}
