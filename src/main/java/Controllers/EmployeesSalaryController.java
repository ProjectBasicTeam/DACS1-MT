package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Models.EmployeesM;
import Models.EmployeesSalary;
import Services.EmployeesManagers;
import Views.Employees;
import Views.Managementsalary;

public class EmployeesSalaryController {
	private Managementsalary view;
	private EmployeesManagers ser;
	public EmployeesSalaryController(Managementsalary view) {
		this.view = view;
		this.ser = EmployeesManagers.getInstance();
		LoadData();
		addListeners();
	}
	public void LoadData() {
		ArrayList<EmployeesSalary> list = ser.loadEmployeesSalary();

		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setRowCount(0); 
		
		for (EmployeesSalary e : list) {
			model.addRow(new Object[]{
				e.getIdnv(),
				e.getNamenv(),
				e.getPhonenv(),
				e.getBrancha(),
				e.getWorknv(),
				e.getBanknv(),
				e.getShiftnv(),
				e.getSalaryshiftnv(),
				e.getSalarynv(),
				e.getLate(),
				e.getAwol()
			});
		}
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(180);
		view.getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
		view.getTable().getColumnModel().getColumn(2).setPreferredWidth(180);
		view.getTable().getColumnModel().getColumn(3).setPreferredWidth(400);
		view.getTable().getColumnModel().getColumn(4).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(5).setPreferredWidth(500);
		view.getTable().getColumnModel().getColumn(6).setPreferredWidth(100);
		view.getTable().getColumnModel().getColumn(7).setPreferredWidth(250);
		view.getTable().getColumnModel().getColumn(8).setPreferredWidth(300);
		view.getTable().getColumnModel().getColumn(9).setPreferredWidth(200);
		view.getTable().getColumnModel().getColumn(10).setPreferredWidth(200);
	}
	private boolean isEmpty() {
		 if (view.getTfnumbanks().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập căn cước công dân nhân viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		return true;
	}
	private void updateemployeesSalary() {
		 try {
			    int id = Integer.parseInt(view.getTfids().getText());
		        String bank = view.getTfnumbanks().getText();
		        int shift = Integer.parseInt(view.getTfshifts().getText());
		        int salaryshift = Integer.parseInt(view.getTfslaryshifts().getText());
		        int salary = Integer.parseInt(view.getTfsalarys().getText());
		        

			        ser.updateEmployeesSalary2(id, bank, shift, salaryshift, salary);

			        JOptionPane.showMessageDialog(view, "Cập nhật tiền lương của nhân viên thành công thành công!");
			        LoadData();
			        resetEmployeesSalary();
			    } catch (NumberFormatException e) {
			        JOptionPane.showMessageDialog(view, "ID phải là số!");
			    }
	}
	private void resetEmployeesSalary() {
		view.getTfsearch().setText("");
		view.getTfids().setText("");
		view.getTfnames().setText("");
		view.getTfphones().setText("");
		view.getTflocations().setText("");
		view.getTfworks().setText("");
		view.getTfnumbanks().setText("");
		view.getTfshifts().setText("0");
		view.getTfslaryshifts().setText("0");
		view.getTfsalarys().setText("0");
		LoadData();
	}
	private void acceptEmployeesSalary() {
			
		int shift = Integer.parseInt(view.getTfshifts().getText());
		int shiftsalary = Integer.parseInt(view.getTfslaryshifts().getText());
		if(shift > 0 && shiftsalary > 0) {
		int salary = shift * shiftsalary;
		view.getTfsalarys().setText(String.valueOf(salary));
		} else {
	        JOptionPane.showMessageDialog(view, "Không thể xác nhận lương tháng này!");
		}
	}
	private void deleteEmployeesSalary() {
		view.getTfshifts().setText("0");
		view.getTfsalarys().setText("0");
		try {
		    int id = Integer.parseInt(view.getTfids().getText());
	        String bank = view.getTfnumbanks().getText();
	        int shift = Integer.parseInt(view.getTfshifts().getText());
	        int salaryshift = Integer.parseInt(view.getTfslaryshifts().getText());
	        int salary = Integer.parseInt(view.getTfsalarys().getText());
	        

		        ser.updateEmployeesSalary(id, bank, shift, salaryshift, salary, 0, 0);

		        JOptionPane.showMessageDialog(view, "Đã xoá tiền lương tháng này của nhân viên thành công thành công!");
		        LoadData();
		        resetEmployeesSalary();
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(view, "ID phải là số!");
		    }
	}
	private int tinhThue(int tntt) {
	    int[] bac = {5_000_000, 5_000_000, 8_000_000, 14_000_000, 20_000_000, 28_000_000};
	    double[] thueSuat = {0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35};
	    int thue = 0;

	    for (int i = 0; i < bac.length; i++) {
	        if (tntt <= bac[i]) {
	            thue += (int)(tntt * thueSuat[i]);
	            return thue;
	        } else {
	            thue += (int)(bac[i] * thueSuat[i]);
	            tntt -= bac[i];
	        }
	    }
	    thue += (int)(tntt * thueSuat[6]);
	    return thue;
	}
	private void exportSalaryforEmployees() {
		Calendar calendar = Calendar.getInstance();
        String currentMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String currentYear = String.valueOf(calendar.get(Calendar.YEAR));
		String[] value = new String[16];
		int id = Integer.parseInt(view.getTfids().getText());
		value = ser.getEmployeeValue(id);
		JTextArea textArea = new JTextArea();
		textArea.append("CỬA HÀNG: CARD POKEMON TCG VN\n\n");
		textArea.append("\t\tPHIẾU LƯƠNG NHÂN VIÊN\n\n");
		textArea.append("\t\t\t\tTháng: " + currentMonth + "  Năm: " + currentYear + ".\n\n");
		textArea.append("\n");
		textArea.append("I) Thông tin nhân viên:\n");
        textArea.append("- Mã nhân viên: " + value[0]+ ".\n");
        textArea.append("- Họ & tên: " + value[1]+ ".\n");
        textArea.append("- Số điện thoại: " + value[3]+ ".\n");
        textArea.append("- Vị trí công việc: " + value[6]+ ".\n");
        textArea.append("- Đang làm việc tại chi nhánh: " + value[7]+ ".\n\n");
        
        textArea.append("II) Chi tiết thông tin lương nhân viên nhận được:\n");
        int late =  Integer.parseInt(value[13]);
        int awol = Integer.parseInt(value[12]);
        int shift = Integer.parseInt(value[9]);
        if (shift == 0) {
        	textArea.append("\"Đã chấm dứt hợp đồng\"\n\n");
        } else {
        textArea.append("- Số ca đã làm trong tháng này: " + value[9]+ " (ca).\n");
        textArea.append("- Số tiền làm việc nhận được trong 1 ca: " + value[10]+ " (VNĐ/ca).\n");
        textArea.append("- Lương tháng này nhân viên nhận được: " + value[11]+ " (VNĐ).\n");
        int grossSalary = Integer.parseInt(value[11]);
        int giamTruBanThan = 11_000_000;
        int thuNhapTinhThue = grossSalary - giamTruBanThan;
        if (thuNhapTinhThue < 0) thuNhapTinhThue = 0;

        int thue = tinhThue(thuNhapTinhThue);
        int netSalary = grossSalary - thue;

        textArea.append("- Thu nhập tính thuế: " + thuNhapTinhThue + " (VNĐ).\n");
        textArea.append("- Thuế TNCN phải đóng: " + thue + " (VNĐ).\n");
        textArea.append("- Lương thực nhận: " + netSalary + " (VNĐ).\n");
        textArea.append("- Tài khoản ngân hàng: " + value[8] + ".\n\n");
        }
        textArea.append("III) Tình trạng làm việc tháng này: \n");
        textArea.append("- Số ca làm việc trong tháng "+ currentMonth + ": " + value[9] + " (lần).\n");
        textArea.append("- Số lần đi trễ trong tháng "+ currentMonth + ": " + value[13] + " (lần).\n");
        
        if (late <= 2) {
        	textArea.append("- Yêu cầu từ chủ cửa hàng: \"Không có ý kiến gì\".\n");
        } else if (late <= 5) {
        	textArea.append("- Yêu cầu từ chủ cửa hàng: \"Nhắc nhở hãy chú ý đến công việc đi làm đúng giờ và hãy trách nhiệm với công việc\".\n");
        } else if (late <= 10) {
        	textArea.append("- Yêu cầu từ chủ cửa hàng: \"Nhắc nhở hãy chú ý đến công việc đi làm đúng giờ\".\n");
        } else {
        	textArea.append("- Yêu cầu từ chủ cửa hàng: \"Từ ngày hôm nay hãy nhận lương và chấm dứt hợp đồng\".\n");
        }
        textArea.append("- Số lần nghỉ việc không rõ lý do trong tháng "+ currentMonth + ": " + value[12] + " (lần).\n");
        if (awol < 2) {
        	textArea.append("- Yêu cầu từ chủ cửa hàng: \"Không có ý kiến gì\"\n\n");
        } else if (awol < 8) {
        	textArea.append("- Yêu cầu từ chủ cửa hàng:: \"Khiển trách yêu cầu bạn phải đi làm đầy đủ và hãy trách nhiệm với công việc\".\n\n");
        } else {
        	textArea.append("- Yêu cầu từ chủ cửa hàng: \"Từ ngày hôm nay hãy nhận lương và chấm dứt hợp đồng\".\n\n");
        }
        textArea.append("IV) Đánh giá công việc bạn làm trong 1 tháng qua:\n\n");
        if(late <= 4 && awol <= 4) {
        	textArea.append("\t\"Cảm ơn bạn đã đóng góp làm việc tại cửa hàng!\".\n");
        } else if (late <= 10 && awol <= 8) {
        	textArea.append("\t\"Cảm ơn bạn đã đóng góp làm việc tại cửa hàng những hãy chú ý đến công việc hơn nhé!\".\n");
        } else {
        	textArea.append("\t\"Cảm ơn bạn đã đóng góp làm việc tại cửa hàng. Từ ngày hôm nay chúng tôi xin chấm dứt hợp đồng với nhân viên " + value[1] + "\".\n\n");
        }
        textArea.append("\n---------------------------------------------------------------------------------------------------------------\n");
        textArea.append("Người lập phiếu:\t\t\tNgười nhận phiếu:\n");
        textArea.append("     (Ký tên) \t\t\t\t       (Ký tên)\n");
        textArea.append("\n\n");
        try {
			textArea.print();
		} catch (PrinterException e) {
			e.printStackTrace();
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
                    	view.getTfids().setText(idObj != null ? idObj.toString() : "");
                    	Object nameObj = view.getTable().getValueAt(selectedRow, 1);
                    	view.getTfnames().setText(nameObj != null ? nameObj.toString() : "");
                    	Object phoneObj = view.getTable().getValueAt(selectedRow, 2);
                    	view.getTfphones().setText(phoneObj != null ? phoneObj.toString() : "");
                    	Object locationObj = view.getTable().getValueAt(selectedRow, 3);
                    	view.getTflocations().setText(locationObj != null ? locationObj.toString() : "");
                    	Object workObj = view.getTable().getValueAt(selectedRow, 4);
                    	view.getTfworks().setText(workObj != null ? workObj.toString() : "");
                    	Object bankObj = view.getTable().getValueAt(selectedRow, 5);
                    	view.getTfnumbanks().setText(bankObj != null ? bankObj.toString() : "");
                    	Object shiftObj = view.getTable().getValueAt(selectedRow, 6);
                    	view.getTfshifts().setText(shiftObj != null ? shiftObj.toString() : "");
                    	Object SalaryshiftObj = view.getTable().getValueAt(selectedRow, 7);
                    	view.getTfslaryshifts().setText(SalaryshiftObj != null ? SalaryshiftObj.toString() : "");
                    	Object salaryObj = view.getTable().getValueAt(selectedRow, 8);
                    	view.getTfsalarys().setText(salaryObj != null ? salaryObj.toString() : "");
                        
                    }
                }
            }
        }); 
		view.getBtnreset().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	resetEmployeesSalary();
		    }
		});
		view.getBtnedit().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    		updateemployeesSalary();
		    	}
		    }
		});
		view.getBtnacceptsalary().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	acceptEmployeesSalary();
		    }
		});
		view.getBtndelete().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	deleteEmployeesSalary();
		    }
		});
		view.getBtnexportpdf().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isEmpty()) {
		    	exportSalaryforEmployees();
		    	}
		    }
		});
		view.getTfsearch().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String search = view.getTfsearch().getText(); 
		        view.getTable().setModel(new DefaultTableModel(null, new Object[]{"Mã nhân viên", "Tên nhân viên", "Số điện thoại","Tên chi nhánh làm việc" ,"Công việc", "Số tài khoản ngân hàng" , "Ca", "Tiền/Ca","Lương tháng này", "Số lần đi trễ tháng này", "Số lần nghỉ trong tháng này"}));
		        ser.getEmployeesValue2(view.getTable(), search); 
		    }
		});
	}
}
