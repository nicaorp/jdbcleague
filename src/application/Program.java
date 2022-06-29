package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnetcion();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * from players");
			
			while (rs.next()) {
				System.out.println("Player: " + rs.getString("Name") + " | Age: " + rs.getInt("Age"));
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}
}
