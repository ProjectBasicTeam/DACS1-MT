package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.EmtimekeepingController;
import Models.Account;
import Models.EmTimeKeepingM;
import Models.EmployeesM;
import Models.EmployeesSalary;

public class EmployeesManagers {
private static EmployeesManagers instance;

	public static EmployeesManagers getInstance() {
		if(instance == null) {
			instance = new EmployeesManagers();
		}
		return instance;
	}
	
	
	public EmployeesManagers() {
		
	}
	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
    Statement st;
    ResultSet rs;
    public ArrayList<EmployeesM> loadEmployees() {
		ArrayList<EmployeesM> list = new ArrayList<>();
		try {
			
			String sql = "SELECT * FROM Employees ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int idnv = rs.getInt(1);
				String namenv = rs.getString(2);
				String gendernv = rs.getString(3);
				String phonenv = rs.getString(4);
				String cccdnv = rs.getString(5);
				Date birth = rs.getDate(6);
				String worknv = rs.getString(7);
				String brancha = rs.getString(8);
				EmployeesM employee = new EmployeesM(idnv, namenv, gendernv, phonenv, cccdnv,birth, worknv, brancha);
				
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public void insertEmployees(EmployeesM em) {
        String sql = "INSERT INTO Employees (idnv, namenv, gendernv, phonenv, cccdnv, birth, worknv, brancha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getIdnv());
            ps.setString(2, em.getNamenv());
            ps.setString(3, em.getGendernv());
            ps.setString(4, em.getPhonenv());
            ps.setString(5, em.getCccdnv());
            String formattedDate = em.getFormattedBirth();
            Date date = Date.valueOf(formattedDate);  
            ps.setDate(6, date);
            ps.setString(7, em.getWorknv());
            ps.setString(8, em.getBrancha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateEmployees(int idnv, String namenv,  String gendernv, String phonenv, String cccdnv,Date birth, String worknv, String brancha) {
    	String sql = "UPDATE Employees SET namenv = ?,gendernv = ?,phonenv = ?,cccdnv = ?, birth = ?, worknv = ?,  brancha = ? WHERE idnv = ?";
    	try {
    		
			ps = con.prepareStatement(sql);
			ps.setString(1,namenv);
			ps.setString(2, gendernv);
			ps.setString(3, phonenv);
			ps.setString(4,cccdnv);
			ps.setDate(5, birth);
			ps.setString(6, worknv);
			ps.setString(7, brancha);
			ps.setInt(8, idnv);
			ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void deleteEmployees(int id) {
		 int a = JOptionPane.showOptionDialog(null, "Bạn có chắc muốn xoá nhân viên hay không?", 
                "Xoá nhân viên", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, null, null);
		 if (a == JOptionPane.YES_OPTION) {
			try {
				ps = con.prepareStatement("DELETE FROM Employees WHERE idnv = ?");
				ps.setInt(1,id);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null , "Xoá nhân viên thành công!");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
    public void getEmployeesValue(JTable table, String search) {
        String sql = "SELECT * FROM Employees WHERE CONCAT(IFNULL(idnv, ''), IFNULL(namenv, ''), IFNULL(phonenv, ''),IFNULL(cccdnv, '')) LIKE ? ORDER BY idnv ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getInt("idnv");
                row[1] = rs.getString("namenv");
                row[2] = rs.getString("gendernv");
                row[3] = rs.getString("phonenv");
                row[4] = rs.getString("cccdnv");
                row[5] = rs.getString("birth");
                row[6] = rs.getString("worknv");
                row[7] = rs.getString("brancha");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(180);
    		table.getColumnModel().getColumn(1).setPreferredWidth(350);
    		table.getColumnModel().getColumn(2).setPreferredWidth(100);
    		table.getColumnModel().getColumn(3).setPreferredWidth(150);
    		table.getColumnModel().getColumn(4).setPreferredWidth(150);
    		table.getColumnModel().getColumn(5).setPreferredWidth(150);
    		table.getColumnModel().getColumn(6).setPreferredWidth(300);
    		table.getColumnModel().getColumn(7).setPreferredWidth(400);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public ArrayList<EmployeesSalary> loadEmployeesSalary() {
		ArrayList<EmployeesSalary> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Employees ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int idnv = rs.getInt(1);
				String namenv = rs.getString(2);
				String phonenv = rs.getString(4);
				String worknv = rs.getString(7);
				String brancha = rs.getString(8);
				String banknv = rs.getString(9);
				int shiftnv = rs.getInt(10);
				int salaryshiftnv = rs.getInt(11);
				int salarynv = rs.getInt(12);
				int late = rs.getInt(14);
				int awol = rs.getInt(13);
				EmployeesSalary employeesalary = new EmployeesSalary(idnv, namenv, phonenv, brancha, worknv,banknv,shiftnv,salaryshiftnv,salarynv,late,awol);
				
				list.add(employeesalary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public void updateEmployeesSalary(int idnv, String banknv, int shiftnv, int salaryshiftnv, int salarynv, int late, int awol) {
    	String sql = "UPDATE Employees SET banknv = ?, shiftnv = ?, salaryshiftnv = ?, salarynv = ?, late = ?, awol = ? WHERE idnv = ?";

    	try {
    		 
			ps = con.prepareStatement(sql);
			ps.setString(1,banknv);
			ps.setInt(2, shiftnv);
			ps.setInt(3, salaryshiftnv);
			ps.setInt(4, salarynv);
			ps.setInt(5, late);
			ps.setInt(6, awol);
			ps.setInt(7, idnv);
			ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void updateEmployeesSalary2(int idnv, String banknv, int shiftnv, int salaryshiftnv, int salarynv) {
    	String sql = "UPDATE Employees SET banknv = ?, shiftnv = ?, salaryshiftnv = ?, salarynv = ? WHERE idnv = ?";

    	try {
    		 
			ps = con.prepareStatement(sql);
			ps.setString(1,banknv);
			ps.setInt(2, shiftnv);
			ps.setInt(3, salaryshiftnv);
			ps.setInt(4, salarynv);
			ps.setInt(5, idnv);
			ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void getEmployeesValue2(JTable table, String search) {
        String sql = "SELECT * FROM Employees WHERE CONCAT(IFNULL(idnv, ''), IFNULL(namenv, ''), IFNULL(phonenv, ''),IFNULL(brancha, '')) LIKE ? ORDER BY idnv ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[11];
                row[0] = rs.getInt("idnv");
                row[1] = rs.getString("namenv");
                row[2] = rs.getString("phonenv");
                row[3] = rs.getString("brancha");
                row[4] = rs.getString("worknv");
                row[5] = rs.getString("banknv");
                row[6] = rs.getString("shiftnv");
                row[7] = rs.getString("salaryshiftnv");
                row[8] = rs.getString("salarynv");
                row[9] = rs.getString("late");
                row[10] = rs.getString("awol");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(180);
    		table.getColumnModel().getColumn(1).setPreferredWidth(400);
    		table.getColumnModel().getColumn(2).setPreferredWidth(180);
    		table.getColumnModel().getColumn(3).setPreferredWidth(400);
    		table.getColumnModel().getColumn(4).setPreferredWidth(300);
    		table.getColumnModel().getColumn(5).setPreferredWidth(500);
    		table.getColumnModel().getColumn(6).setPreferredWidth(100);
    		table.getColumnModel().getColumn(7).setPreferredWidth(250);
    		table.getColumnModel().getColumn(8).setPreferredWidth(300);
    		table.getColumnModel().getColumn(9).setPreferredWidth(200);
    		table.getColumnModel().getColumn(10).setPreferredWidth(200);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void getEmployeesValue3(JTable table,String branch,  String search) {
        String sql = "SELECT idnv, namenv, phonenv, worknv, awol, late, status FROM Employees WHERE brancha = ? AND CONCAT(IFNULL(idnv, ''), IFNULL(namenv, ''), IFNULL(phonenv, '')) LIKE ? ORDER BY idnv ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, branch);
            ps.setString(2, "%" + search + "%");
            rs = ps.executeQuery();

            // Lấy mô hình bảng để cập nhật dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            Object[] row;
            while (rs.next()) {
                row = new Object[11];
                row[0] = rs.getInt("idnv");
                row[1] = rs.getString("namenv");
                row[2] = rs.getString("phonenv");
                row[3] = rs.getString("worknv");
                row[4] = rs.getString("awol");
                row[5] = rs.getString("late");
                row[6] = rs.getString("status");
                model.addRow(row);
            }

            // Đặt lại cấu hình cột sau khi cập nhật dữ liệu
            table.getColumnModel().getColumn(0).setPreferredWidth(150);
    		table.getColumnModel().getColumn(1).setPreferredWidth(400);
    		table.getColumnModel().getColumn(2).setPreferredWidth(160);
    		table.getColumnModel().getColumn(3).setPreferredWidth(300);
    		table.getColumnModel().getColumn(4).setPreferredWidth(300);
    		table.getColumnModel().getColumn(5).setPreferredWidth(300);
    		table.getColumnModel().getColumn(6).setPreferredWidth(600);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public String[] getEmployeeValue(int id) {
		String[] value = new String[15];
		try {
			ps = con.prepareStatement("SELECT * FROM Employees WHERE idnv = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				value[0] = rs.getString("idnv");
				value[1] = rs.getString("namenv");
				value[2] = rs.getString("gendernv");
				value[3] = rs.getString("phonenv");
				value[4] = rs.getString("cccdnv");
				value[5] = rs.getString("birth");
				value[6] = rs.getString("worknv");
				value[7] = rs.getString("brancha");
				value[8] = rs.getString("banknv");
				value[9] = rs.getString("shiftnv");
				value[10] = rs.getString("salaryshiftnv");
				value[11] = rs.getString("salarynv");
				value[12] = rs.getString("awol");
				value[13] = rs.getString("late");
				value[14] = rs.getString("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
    public ArrayList<EmTimeKeepingM> loadEmployee3(String brancha) {
		ArrayList<EmTimeKeepingM> list = new ArrayList<>();
		try {
			
			String sql = "SELECT * FROM Employees WHERE brancha = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, brancha);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				int idnv = rs.getInt(1);
				String namenv = rs.getString(2);
				String phonenv = rs.getString(4);
				String worknv = rs.getString(7);
				int awol = rs.getInt(13);
				int late = rs.getInt(14);
				String status = rs.getString(15);
				EmTimeKeepingM employee = new EmTimeKeepingM(idnv, namenv, phonenv,worknv, awol,late,status);
				
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
    public void updateETK(int idnv,int shift , int awol, int late, String status) {
    	String sql = "UPDATE Employees SET shiftnv = ?, awol = ?, late = ?, status = ? WHERE idnv = ?";
    	try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, shift);
			ps.setInt(2, awol);
			ps.setInt(3, late);
			ps.setString(4, status);
			ps.setInt(5, idnv);
			ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public int getEmployeeShift(int id) {
        int shift = 0;
        try {
            ps = con.prepareStatement("SELECT shiftnv FROM Employees WHERE idnv = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                shift = rs.getInt("shiftnv"); 
            } else {
                System.out.println("⚠️ Không tìm thấy số ca: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shift;
    }
    public int getEmployeeAwol(int id) {
        int awol = 0;
        try {
            ps = con.prepareStatement("SELECT awol FROM Employees WHERE idnv = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                awol = rs.getInt("awol"); 
            } else {
                System.out.println("⚠️ Không tìm thấy số lần vắng: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return awol;
    }
    public int getEmployeeLate(int id) {
        int Late = 0;
        try {
            ps = con.prepareStatement("SELECT late FROM Employees WHERE idnv = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Late = rs.getInt("late"); 
            } else {
                System.out.println("⚠️ Không tìm thấy số lần đi trễ: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Late;
    }
    public void setNullStatus(String brancha) {
    	String sql = "UPDATE Employees SET status = '' WHERE brancha = ?";
    	try {
			ps = con.prepareStatement(sql);
			ps.setString(1, brancha);
			ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
