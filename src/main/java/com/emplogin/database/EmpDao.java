package com.emplogin.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emplogin.bean.EmpBean;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class EmpDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/dem?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";



	private static final String SELECT_USER_BY_ID = "select id,name,email,country,phoneno,job,salary from users where id =?";
	private static final String SELECT_USERS = "select id,name,email,country,phoneno,job,salary from users ";
	private static final String SELECT_DATA = "select id,name,email,country,phoneno,job,salary from users where email =?, country =?";

	public EmpDao() {
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

	public void insertingUser(EmpBean user) throws SQLException {
	
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT_DATA")) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getCountry());
			System.out.println(preparedStatement);
		
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	

	public EmpBean selectUser(int id) {
		EmpBean user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				int phoneno = rs.getInt("phoneno");
				String job = rs.getString("job");
			
				int salary = rs.getInt("salary");
				user = new EmpBean(id, name, email, country,phoneno,job,salary);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<EmpBean> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<EmpBean> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				int phoneno = rs.getInt("phoneno");
				String job = rs.getString("job");
				
				int salary = rs.getInt("salary");
				users.add(new EmpBean(id, name, email, country,phoneno,job,salary));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
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