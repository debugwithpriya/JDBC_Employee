package com.jsp.jdbc.employeedb.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class EmployeeDao {
	Scanner scan = new Scanner(System.in);

	public void addEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_config.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);

			PreparedStatement pst = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?)");
			System.out.println("Enter Employee Id: ");
			pst.setInt(1, scan.nextInt());
			System.out.println("Enter Employee Title: ");
			pst.setString(2, scan.next());
			System.out.println("Enter Employee Email: ");
			pst.setString(3, scan.next());
			System.out.println("Enter Employee Designation: ");
			pst.setString(4, scan.next());
			System.out.println("Enter Employee Salary: ");
			pst.setString(5, scan.next());

			int rowsInserted = pst.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println(rowsInserted + "data inserted successfully");
			}

			else {
				System.out.println("Data not inserted");
			}

			conn.close();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findEmployeesByTitle() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_config.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			PreparedStatement pst = conn.prepareStatement("SELECT * From employee WHERE TITLE = ?");

			System.out.println("Enter Title");
			pst.setString(1, scan.next());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
			}

			conn.close();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findEmployeeByDes() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_Config.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM employee WHERE DES = ?");

			System.out.println("Enter Employee Designation: ");
			pst.setString(1, scan.next());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
			}

			conn.close();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findEmployeeBetweenSalary() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_config.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM employee WHERE salary between  ? And ? ");

			System.out.println("Enter Employee Min Salary: ");
			pst.setString(1, scan.next());

			System.out.println("Enter Employee Max Salary: ");
			pst.setString(2, scan.next());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
			}

			conn.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateSalaryByEmployeeId() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_Config.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			PreparedStatement pst = conn
					.prepareStatement("UPDATE jdbc_employeedb.employee SET SALARY = ? WHERE id = ? ");

			System.out.println("Enter Employee Salary You Want to Update");
			pst.setString(1, scan.next());
			System.out.println("Enter Employee Id where you want to update Salary");
			pst.setString(2, scan.next());
			int rs = pst.executeUpdate();
			if (rs > 0) {
				System.out.println(rs + " row updated");
			}

			else {
				System.out.println("row not updated");

			}
			conn.close();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateDesBySalaryGreaterThan() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_Config.properties");
			Properties p = new Properties();
			p.load(fr);

			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			PreparedStatement ps = conn
					.prepareStatement("UPDATE jdbc_employeedb.employee SET des = ? WHERE salary > ?");

			System.out.println("Enter Employee Designation You Want to Update");
			ps.setString(1, scan.next());

			System.out.println("Enter Employee Salary");
			ps.setString(2, scan.next());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println(rs + " row updated");
			}

			else {
				System.out.println("row not updated");

			}
			conn.close();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEmployeeByDes() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("DB_Config.properties");
			Properties p = new Properties();
			p.load(fr);

			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE des = ?");

			System.out.println("Enter Designation which employee u want to delete");
			ps.setString(1, scan.next());

			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println(rs + " row updated");
			}

			else {
				System.out.println("row not updated");

			}
			conn.close();
		}

		catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteEmployeesByEmail() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			FileReader fr = new FileReader("DB_Config.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE des = ?");
			System.out.println("Enter Email which employee u want to delete");
			ps.setString(1, scan.next());

			int rs = ps.executeUpdate();

			if (rs > 0) {
				System.out.println(rs + " row updated");
			}

			else {
				System.out.println("row not updated");

			}
			conn.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
