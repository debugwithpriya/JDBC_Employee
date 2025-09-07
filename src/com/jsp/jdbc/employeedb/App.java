package com.jsp.jdbc.employeedb;

import com.jsp.jdbc.employeedb.dao.EmployeeDao;


import java.util.Scanner;
import com.jsp.jdbc.employeedb.dao.EmployeeDao;

public class App {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Employee CRUD Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employees By Title");
            System.out.println("3. Find Employee By Designation");
            System.out.println("4. Find Employee Between Salary Range");
            System.out.println("5. Update Salary By Employee Id");
            System.out.println("6. Update Designation By Salary Greater Than");
            System.out.println("7. Delete Employee By Designation");
            System.out.println("8. Delete Employee By Email");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.addEmployee();
                    break;
                case 2:
                    dao.findEmployeesByTitle();
                    break;
                case 3:
                    dao.findEmployeeByDes();
                    break;
                case 4:
                    dao.findEmployeeBetweenSalary();
                    break;
                case 5:
                    dao.updateSalaryByEmployeeId();
                    break;
                case 6:
                    dao.updateDesBySalaryGreaterThan();
                    break;
                case 7:
                    dao.deleteEmployeeByDes();
                    break;
                case 8:
                    dao.deleteEmployeesByEmail();
                    break;
                case 9:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
