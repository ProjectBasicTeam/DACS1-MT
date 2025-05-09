package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import Models.EmployeesM;
import Models.ProfitM;

public class StatisticManagers {
	private static StatisticManagers instance;

	public static StatisticManagers getInstance() {
		if (instance == null) {
			instance = new StatisticManagers();
		}
		return instance;
	}

	public StatisticManagers() {
	}

	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	public int gettotalEmployees() {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) AS total_employees FROM Employees;");
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("total_employees");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public int gettotaldetail() {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) AS total_details FROM History1;");
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("total_details");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public long gettotalprice() {
		long qty = 0;
		try {
			ps = con.prepareStatement("SELECT SUM(totalprice) AS total_totalprice FROM History1;");
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getLong("total_totalprice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public int gettotalboxinwarehouse() {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT SUM(quantityproduct) AS total_quantityproduct FROM Warehouseproduct;");
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("total_quantityproduct");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public int gettotalfund() {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT SUM(totalcapital) AS total_totalcapital FROM Supplier;");
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("total_totalcapital");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public ArrayList<ProfitM> loadProfit() {
        ArrayList<ProfitM> list = new ArrayList<>();
        try {
            
            String sql = "SELECT totalprice, day FROM History1 ORDER BY day DESC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); 
            while (rs.next()) {
                int totalprice = rs.getInt("totalprice");
                Date day = rs.getDate("day");
                ProfitM pro = new ProfitM(totalprice, day);
                list.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	 public double[] getMonthlyProfits() {
	        double[] profits = new double[12]; // Array to store profits for each month (Jan to Dec)

	        try {
	            // Query to get total revenue per month from History1
	            String revenueQuery = "SELECT MONTH(day) AS month, SUM(totalprice) AS total_revenue " +
	                                 "FROM History1 " +
	                                 "GROUP BY MONTH(day)";
	            ps = con.prepareStatement(revenueQuery);
	            rs = ps.executeQuery();
	            double[] revenues = new double[12];
	            while (rs.next()) {
	                int month = rs.getInt("month") - 1; // Month is 1-12, array index is 0-11
	                revenues[month] = rs.getDouble("total_revenue");
	            }

	            // Query to get total capital per month from Supplier
	            String capitalQuery = "SELECT MONTH(day) AS month, SUM(totalcapital) AS total_capital " +
	                                 "FROM Supplier " +
	                                 "GROUP BY MONTH(day)";
	            ps = con.prepareStatement(capitalQuery);
	            rs = ps.executeQuery();
	            double[] capitals = new double[12];
	            while (rs.next()) {
	                int month = rs.getInt("month") - 1; // Month is 1-12, array index is 0-11
	                capitals[month] = rs.getDouble("total_capital");
	            }

	            // Calculate profit for each month (revenue - capital)
	            for (int i = 0; i < 12; i++) {
	                profits[i] = revenues[i] - capitals[i];
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return profits;
	    }
	// Tính tổng doanh thu tuần này
	    public long getRevenueThisWeek() {
	        long revenue = 0;
	        try {
	            // Lấy ngày hiện tại
	            Calendar cal = Calendar.getInstance();
	            cal.set(Calendar.HOUR_OF_DAY, 0);
	            cal.set(Calendar.MINUTE, 0);
	            cal.set(Calendar.SECOND, 0);
	            cal.set(Calendar.MILLISECOND, 0);

	            // Đặt ngày bắt đầu tuần (thứ 2 là ngày đầu tuần)
	            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
	            Date startOfWeek = new Date(cal.getTimeInMillis());

	            // Đặt ngày kết thúc tuần (thứ 2 + 6 ngày = Chủ nhật)
	            cal.add(Calendar.DAY_OF_WEEK, 6);
	            Date endOfWeek = new Date(cal.getTimeInMillis());

	            // Truy vấn tổng doanh thu trong khoảng thời gian tuần này
	            String sql = "SELECT SUM(totalprice) AS total_revenue FROM History1 WHERE day BETWEEN ? AND ?";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, startOfWeek);
	            ps.setDate(2, endOfWeek);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                revenue = rs.getLong("total_revenue");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return revenue;
	    }

	    // Tính tổng doanh thu tháng này
	    public long getRevenueThisMonth() {
	        long revenue = 0;
	        try {
	            // Lấy ngày hiện tại
	            Calendar cal = Calendar.getInstance();
	            cal.set(Calendar.HOUR_OF_DAY, 0);
	            cal.set(Calendar.MINUTE, 0);
	            cal.set(Calendar.SECOND, 0);
	            cal.set(Calendar.MILLISECOND, 0);

	            // Đặt ngày đầu tháng
	            cal.set(Calendar.DAY_OF_MONTH, 1);
	            Date startOfMonth = new Date(cal.getTimeInMillis());

	            // Đặt ngày cuối tháng
	            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	            Date endOfMonth = new Date(cal.getTimeInMillis());

	            // Truy vấn tổng doanh thu trong khoảng thời gian tháng này
	            String sql = "SELECT SUM(totalprice) AS total_revenue FROM History1 WHERE day BETWEEN ? AND ?";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, startOfMonth);
	            ps.setDate(2, endOfMonth);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                revenue = rs.getLong("total_revenue");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return revenue;
	    }

	    // Tính tổng doanh thu năm nay
	    public long getRevenueThisYear() {
	        long revenue = 0;
	        try {
	            // Lấy ngày hiện tại
	            Calendar cal = Calendar.getInstance();
	            cal.set(Calendar.HOUR_OF_DAY, 0);
	            cal.set(Calendar.MINUTE, 0);
	            cal.set(Calendar.SECOND, 0);
	            cal.set(Calendar.MILLISECOND, 0);

	            // Đặt ngày đầu năm
	            cal.set(Calendar.DAY_OF_YEAR, 1);
	            Date startOfYear = new Date(cal.getTimeInMillis());

	            // Đặt ngày cuối năm
	            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
	            Date endOfYear = new Date(cal.getTimeInMillis());

	            // Truy vấn tổng doanh thu trong khoảng thời gian năm nay
	            String sql = "SELECT SUM(totalprice) AS total_revenue FROM History1 WHERE day BETWEEN ? AND ?";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, startOfYear);
	            ps.setDate(2, endOfYear);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                revenue = rs.getLong("total_revenue");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return revenue;
	    }
	    public Map<String, Double> getDailyRevenueThisWeek() {
	        Map<String, Double> dailyRevenue = new HashMap<>();
	        try {
	            Calendar cal = Calendar.getInstance();
	            cal.set(Calendar.HOUR_OF_DAY, 0);
	            cal.set(Calendar.MINUTE, 0);
	            cal.set(Calendar.SECOND, 0);
	            cal.set(Calendar.MILLISECOND, 0);

	            // Đặt ngày bắt đầu tuần (thứ 2)
	            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
	            Date startOfWeek = new Date(cal.getTimeInMillis());

	            // Đặt ngày kết thúc tuần (Chủ nhật)
	            cal.add(Calendar.DAY_OF_WEEK, 6);
	            Date endOfWeek = new Date(cal.getTimeInMillis());

	            // Truy vấn doanh thu theo ngày trong tuần
	            String sql = "SELECT DAYNAME(day) AS day_name, SUM(totalprice) AS total_revenue " +
	                         "FROM History1 " +
	                         "WHERE day BETWEEN ? AND ? " +
	                         "GROUP BY day, DAYNAME(day)";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, startOfWeek);
	            ps.setDate(2, endOfWeek);
	            rs = ps.executeQuery();

	            // Khởi tạo tất cả các ngày trong tuần với giá trị 0
	            String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	            for (String day : daysOfWeek) {
	                dailyRevenue.put(day, 0.0);
	            }

	            // Cập nhật doanh thu từ kết quả truy vấn
	            while (rs.next()) {
	                String dayName = rs.getString("day_name");
	                double revenue = rs.getDouble("total_revenue");
	                dailyRevenue.put(dayName, revenue);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dailyRevenue;
	    }

	    // Lấy doanh thu từng ngày trong tháng hiện tại
	    public Map<Integer, Double> getDailyRevenueThisMonth() {
	        Map<Integer, Double> dailyRevenue = new HashMap<>();
	        try {
	            Calendar cal = Calendar.getInstance();
	            cal.set(Calendar.HOUR_OF_DAY, 0);
	            cal.set(Calendar.MINUTE, 0);
	            cal.set(Calendar.SECOND, 0);
	            cal.set(Calendar.MILLISECOND, 0);

	            // Đặt ngày đầu tháng
	            cal.set(Calendar.DAY_OF_MONTH, 1);
	            Date startOfMonth = new Date(cal.getTimeInMillis());

	            // Đặt ngày cuối tháng
	            int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	            cal.set(Calendar.DAY_OF_MONTH, daysInMonth);
	            Date endOfMonth = new Date(cal.getTimeInMillis());

	            // Truy vấn doanh thu theo ngày trong tháng
	            String sql = "SELECT DAY(day) AS day_of_month, SUM(totalprice) AS total_revenue " +
	                         "FROM History1 " +
	                         "WHERE day BETWEEN ? AND ? " +
	                         "GROUP BY DAY(day)";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, startOfMonth);
	            ps.setDate(2, endOfMonth);
	            rs = ps.executeQuery();

	            // Khởi tạo tất cả các ngày trong tháng với giá trị 0
	            for (int day = 1; day <= daysInMonth; day++) {
	                dailyRevenue.put(day, 0.0);
	            }

	            // Cập nhật doanh thu từ kết quả truy vấn
	            while (rs.next()) {
	                int day = rs.getInt("day_of_month");
	                double revenue = rs.getDouble("total_revenue");
	                dailyRevenue.put(day, revenue);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dailyRevenue;
	    }

	    // Lấy doanh thu từng tháng trong năm hiện tại
	    public Map<Integer, Double> getMonthlyRevenueThisYear() {
	        Map<Integer, Double> monthlyRevenue = new HashMap<>();
	        try {
	            Calendar cal = Calendar.getInstance();
	            cal.set(Calendar.HOUR_OF_DAY, 0);
	            cal.set(Calendar.MINUTE, 0);
	            cal.set(Calendar.SECOND, 0);
	            cal.set(Calendar.MILLISECOND, 0);

	            // Đặt ngày đầu năm
	            cal.set(Calendar.DAY_OF_YEAR, 1);
	            Date startOfYear = new Date(cal.getTimeInMillis());

	            // Đặt ngày cuối năm
	            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
	            Date endOfYear = new Date(cal.getTimeInMillis());

	            // Truy vấn doanh thu theo tháng trong năm
	            String sql = "SELECT MONTH(day) AS month, SUM(totalprice) AS total_revenue " +
	                         "FROM History1 " +
	                         "WHERE day BETWEEN ? AND ? " +
	                         "GROUP BY MONTH(day)";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, startOfYear);
	            ps.setDate(2, endOfYear);
	            rs = ps.executeQuery();

	            // Khởi tạo tất cả các tháng với giá trị 0
	            for (int month = 1; month <= 12; month++) {
	                monthlyRevenue.put(month, 0.0);
	            }

	            // Cập nhật doanh thu từ kết quả truy vấn
	            while (rs.next()) {
	                int month = rs.getInt("month");
	                double revenue = rs.getDouble("total_revenue");
	                monthlyRevenue.put(month, revenue);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return monthlyRevenue;
	    }
}
