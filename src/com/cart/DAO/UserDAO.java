package com.cart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cart.entity.UserCredentials;
import com.cruds.db.DBConnectionManager;

public class UserDAO {

	public static boolean authenticate(UserCredentials user)
	{
		boolean bol = false;
		String sql = "SELECT USERID FROM Credentials WHERE USERID = ? AND PASSWORD = ?";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				bol = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return bol;
		}
	}
	
	public static boolean create(UserCredentials user)
	{
		int rows = 0;
		String sql = "INSERT INTO Credentials VALUES (?,?)";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getPassword());
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return rows > 0;
		}
	}
}
