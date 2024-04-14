package com.jspiders.contactmanagerwithjdbc.jdbclogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCLogic {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	public static void addData(int id, String firstName, String lastName, long mobileNumber, String email,
			String category) {
		try {
			openConnection();
			query = "INSERT INTO user values(?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setLong(4, mobileNumber);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, category);
			preparedStatement.execute();
			System.out.println("Data Added Successfully!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void closeConnection() throws SQLException {
		preparedStatement.close();
		connection.close();

	}

	private static void openConnection() throws SQLException {

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactjdbc", "root", "root");

	}

	public static void viewData() {
		try {
			openConnection();
			query = "Select * from user";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void updateFirstName(String firstName, int id) {

		try {
			openConnection();
			query = "UPDATE user set firstname = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, firstName);
			preparedStatement.setInt(2, id);
			int update = preparedStatement.executeUpdate();
			if (update == 1) {
				System.out.println("First Name updated successfully!");
			}else {
				System.out.println("Contact with id " + id + " does not exist");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void updateLastName(String lastName, int id) {

		try {
			openConnection();
			query = "UPDATE user set lastname = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, lastName);
			preparedStatement.setInt(2, id);
			int update = preparedStatement.executeUpdate();
			if (update == 1) {
				System.out.println("Last Name updated successfully!");
			}else {
				System.out.println("Contact with id " + id + " does not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void updateMobileNumber(long mobileNumber, int id) {

		try {
			openConnection();
			query = "UPDATE user set mobilenumber = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, mobileNumber);
			preparedStatement.setInt(2, id);
			int update = preparedStatement.executeUpdate();
			if (update == 1) {
				System.out.println("Mobile Number updated successfully!");
			}else {
				System.out.println("Contact with id " + id + " does not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void updateEmail(String email, int id) {

		try {
			openConnection();
			query = "UPDATE user set email = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			int update = preparedStatement.executeUpdate();
			if (update == 1) {
				System.out.println("Email updated successfully!");
			}else {
				System.out.println("Contact with id " + id + " does not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void updateCategory(String category, int id) {

		try {
			openConnection();
			query = "UPDATE user set category = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, id);
			int update = preparedStatement.executeUpdate();
			if (update == 1) {
				System.out.println("Category updated successfully!");
			}else {
				System.out.println("Contact with id " + id + " does not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void searchById(int id) {

		try {
			openConnection();
			query = "Select * from user where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void searchByFirstName(String firstName) {

		try {
			openConnection();
			query = "Select * from user where firstname = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, firstName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void searchByLastName(String lastName) {
		try {
			openConnection();
			query = "Select * from user where lastname = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, lastName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void searchByMobileNumber(long mobileNumber) {
		try {
			openConnection();
			query = "Select * from user where mobilenumber = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, mobileNumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void searchByEmail(String email) {
		try {
			openConnection();
			query = "Select * from user where email = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void searchByCategory(String category) {
		try {
			openConnection();
			query = "Select * from user where category = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id = " + resultSet.getInt(1));
				System.out.println("First Name = " + resultSet.getString(2));
				System.out.println("Last Name = " + resultSet.getString(3));
				System.out.println("Mobile Number = " + resultSet.getLong(4));
				System.out.println("Email = " + resultSet.getString(5));
				System.out.println("Category = " + resultSet.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteData(int id) {

		try {
			openConnection();
			query = "Delete from user where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int delete = preparedStatement.executeUpdate();
			if (delete == 1) {
				System.out.println("Contact Deleted successfully!");
			}else {
				System.out.println("Contact with id " + id + " does not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
