package com.cart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cart.entity.ItemDetails;
import com.cruds.db.DBConnectionManager;

public class ItemDAO {

	public static boolean create(ItemDetails item)
	{
		int rows = 0;
		String sql = "INSERT INTO Items VALUES (?,?)";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setInt(2, item.getPrice());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return rows > 0;
		}
	}
}
