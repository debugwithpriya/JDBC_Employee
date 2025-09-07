🏢 Employee Management System (JDBC CRUD Project)
📌 Project Overview

This is a Java-based Employee Management System built using JDBC (Java Database Connectivity) with MySQL as the database.
The project demonstrates basic CRUD (Create, Read, Update, Delete) operations on an employee table and provides a menu-driven console application for managing employee records.

✨ Features

➕ Add Employee – Insert a new employee record.

🔍 Find Employees By Title – Search employees by job title.

🔍 Find Employee By Designation – Search employees by designation.

💰 Find Employees Between Salary Range – Retrieve employees whose salary falls within a given range.

✏️ Update Salary By Employee ID – Modify salary of an employee using their ID.

✏️ Update Designation By Salary Greater Than – Update designation of employees earning above a certain salary.

❌ Delete Employee By Designation – Remove employees matching a given designation.

❌ Delete Employee By Email – Remove employees by their email address.

🛠️ Technologies Used

Java (JDK 8 or higher)

JDBC API

MySQL Database

Properties File (DB_config.properties) for DB credentials

📂 Project Structure
EmployeeManagementSystem/
│
├── src/
│   ├── com.jsp.jdbc.employeedb/
│   │   └── App.java                # Main menu-driven application
│   ├── com.jsp.jdbc.employeedb.dao/
│   │   └── EmployeeDao.java        # DAO class for CRUD operations
│
├── DB_config.properties            # Database configuration file
└── README.md                       # Project documentation

⚙️ Setup Instructions
1. Clone Repository
git clone https://github.com/debugwithpriya/EmployeeManagementSystem.git


2. Configure Database

Create a MySQL database and employee table:

CREATE DATABASE jdbc_employeedb;

USE jdbc_employeedb;

CREATE TABLE employee (
    id INT PRIMARY KEY,
    title VARCHAR(50),
    email VARCHAR(100),
    des VARCHAR(50),
    salary INT
);

3. Add Database Config

Update DB_config.properties file with your database credentials:

url=jdbc:mysql://localhost:3306/jdbc_employeedb
user=root
password=yourpassword

4. Run the Project

Compile and run the project:

javac -d bin src/com/jsp/jdbc/employeedb/*.java src/com/jsp/jdbc/employeedb/dao/*.java
java -cp bin com.jsp.jdbc.employeedb.App

🎯 Sample Menu Output
===== Employee CRUD Menu =====
1. Add Employee
2. Find Employees By Title
3. Find Employee By Designation
4. Find Employee Between Salary Range
5. Update Salary By Employee Id
6. Update Designation By Salary Greater Than
7. Delete Employee By Designation
8. Delete Employee By Email
9. Exit
Enter your choice:
