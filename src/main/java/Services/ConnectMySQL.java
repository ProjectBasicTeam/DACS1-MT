package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
    
    public static final String USERNAME = "root";
    public static final String PASSWORD = ""; // Cập nhật nếu mật khẩu đã thay đổi
    private static final String DATABASE_NAME = "qlibanhang"; // Khớp với cơ sở dữ liệu trong XAMPP
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME + "?useSSL=false&serverTimezone=UTC";

    public static Connection getConnected() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Kết nối cơ sở dữ liệu thành công");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Driver MySQL không tìm thấy - " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnected();
        if (conn != null) {
            System.out.println("Kết nối thành công");
        } else {
            System.out.println("Kết nối thất bại");
        }
    }
}