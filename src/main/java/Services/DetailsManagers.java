package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.BuyItemM;
import Models.InfoBuyM;
import Models.TempPurchaseM;

public class DetailsManagers {
	private static DetailsManagers instance;

	public static DetailsManagers getInstance() {
		if (instance == null) {
			instance = new DetailsManagers();
		}
		return instance;
	}

	public DetailsManagers() {
	}

	Connection con = ConnectMySQL.getConnected();
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	public ArrayList<BuyItemM> loadBuy() {
		ArrayList<BuyItemM> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Purchase ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int stt = rs.getInt(1);
				String idproduct = rs.getString(2);
				String name = rs.getString(3);
				int qty = rs.getInt(4);
				int price = rs.getInt(5);
				int totalprice = rs.getInt(6);
				String brancha = rs.getString(7);
				String idhd = rs.getString(8);

				BuyItemM buy = new BuyItemM(stt,idproduct, name, qty, price,totalprice, brancha,idhd);

				list.add(buy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getMaxrow() {
		int row = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT MAX(idpur) FROM Purchase ");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public String getIdproductBuy(int idpur) {
        String idproduct = null;
        try {
            ps = con.prepareStatement("SELECT idproduct FROM Purchase WHERE idpur = ?");
            ps.setInt(1, idpur);
            rs = ps.executeQuery();
            if (rs.next()) {
            	idproduct = rs.getString("idproduct");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idproduct;
    }
	public int getqtyatBuy(String idproduct) {
		int qty = 0;
		try {
			ps = con.prepareStatement("SELECT quantityproduct FROM Purchase WHERE idproduct  = ?");
			ps.setString(1, idproduct.trim());
			rs = ps.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("quantityproduct");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}
	public void Deleteallbuy() {
		try {
			ps = con.prepareStatement("TRUNCATE TABLE Purchase;");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertBuyItem(BuyItemM p) {
		String sql = "INSERT INTO Purchase (idpur, idproduct, nameproduct,  quantityproduct,  priceproduct, totalprice, brancha, idhd) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getStt());
			ps.setString(2, p.getIdproduct());
			ps.setString(3, p.getName());
			ps.setInt(4, p.getQty());
			ps.setInt(5, p.getPrice());
			ps.setInt(6, p.getTotalprice());
			ps.setString(7, p.getBrancha());
			ps.setString(8, p.getIdhd());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateInfoBuynull() {
		String sql = "UPDATE Infobuy SET idhd = ?, totalprice = ?, totalqty = ?, phonecustomer = ?, hour = ?, day = ? WHERE stt = 1";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "########");
	        ps.setInt(2, 0);
	        ps.setInt(3, 0);
	        ps.setString(4, "");
	        ps.setString(5, "00:00");
	        ps.setDate(6, null);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateInfoBuy(InfoBuyM i) {
		String sql = "UPDATE Infobuy SET idhd = ?, totalprice = ?, totalqty = ?, phonecustomer = ?, hour = ?, day = ? WHERE stt = 1";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, i.getIdhd());
	        ps.setInt(2, i.getTotalprice());
	        ps.setInt(3, i.getTotalqty());
	        ps.setString(4, i.getPhonecustomer());
	        ps.setString(5, i.getHour());
	        ps.setDate(6, i.getDay());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String[] getInfoBuyValue() {
		String[] value = new String[7];
		try {
			ps = con.prepareStatement("SELECT * FROM Infobuy WHERE stt = 1");
			rs = ps.executeQuery();
			if (rs.next()) {
				value[0] = rs.getString("stt");
				value[1] = rs.getString("idhd");
				value[2] = rs.getString("totalprice");
				value[3] = rs.getString("totalqty");
				value[4] = rs.getString("phonecustomer");
				value[5] = rs.getString("hour");
				value[6] = rs.getString("day");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
}
