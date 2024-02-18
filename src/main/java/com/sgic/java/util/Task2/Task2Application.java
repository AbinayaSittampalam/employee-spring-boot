package com.sgic.java.util.Task2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Task2Application{
	// Getters and setters
	private int id;
	private String name;
	private String position;
	private String department;
	public Task2Application() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void Database() {
		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
			if (connection != null) {
				System.out.println("Connected");

				String insertQuery = "INSERT INTO employee1 (id, name, position, department) VALUES (?, ?, ?, ?)";

				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, position);
				preparedStatement.setString(4, department);

				int rowsAffected = preparedStatement.executeUpdate();

			}
		} catch (SQLException e) {
			System.err.println("Failed to connect to the database!");
			e.printStackTrace();

		}
	}
}