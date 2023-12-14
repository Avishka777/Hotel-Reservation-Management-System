package com.EventPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
This DAO class provides CRUD database operations for the table weddings in the database.
*/
public class WeddingDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/hotel?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_WEDDINGS_SQL = "INSERT INTO weddings" + "  (fullName, phone, email, attendees, additional, uid) VALUES " + " (?, ?, ?, ?, ?, ?);";
	//private static final String SELECT_WEDDING_BY_ID = "select id,fullName, phone, email, attendees, additional from weddings where uid =?";
	private static final String SELECT_WEDDING_BY_IDD = "select id,fullName, phone, email, attendees, additional from weddings where id =?";
	private static final String SELECT_ALL_WEDDINGS = "select id,fullName, phone, email, attendees, additional from weddings where uid =?";
	private static final String DELETE_WEDDINGS_SQL = "delete from weddings where id = ?;";
	private static final String UPDATE_WEDDINGS_SQL = "update weddings set fullName = ?,phone= ?, email =?,attendees= ?,additional= ? where id = ?;";

	public WeddingDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertWedding(Wedding wedding) throws SQLException {
		System.out.println(INSERT_WEDDINGS_SQL);
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WEDDINGS_SQL)) {
			preparedStatement.setString(1, wedding.getFullName());
			preparedStatement.setString(2, wedding.getPhone());
			preparedStatement.setString(3, wedding.getEmail());
			preparedStatement.setInt(4, wedding.getAttendees());
			preparedStatement.setString(5, wedding.getAdditional());
			preparedStatement.setInt(6, wedding.getUid());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Wedding selectWedding(int id) {
		Wedding wedding = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WEDDING_BY_IDD);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idd = rs.getInt(1);
				String fullName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				int attendees = rs.getInt(5);
				String additional = rs.getString(6);
				System.out.println("result");
				wedding = new Wedding(idd, fullName, phone, email,attendees,additional);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return wedding;
	}

	public List<Wedding> selectAllWeddings(int uid) {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Wedding> weddings = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WEDDINGS);)
			{
			preparedStatement.setInt(1, uid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("fullName");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				int attendees = rs.getInt("attendees");
				String additional = rs.getString("additional");
				weddings.add(new Wedding(id, fullName, phone, email,attendees,additional));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return weddings;
	}

	public boolean deleteWedding(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_WEDDINGS_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
	}

	public boolean updateWedding(Wedding wedding) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_WEDDINGS_SQL);) {
			statement.setString(1, wedding.getFullName());
			statement.setString(2, wedding.getPhone());
			statement.setString(3, wedding.getEmail());
			statement.setInt(4, wedding.getAttendees());
			statement.setString(5, wedding.getAdditional());
			statement.setInt(6, wedding.getId());
			
			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
