package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
    private ArrayList<EmployeePayroll> employees;

    public EmployeePayrollService() {
        employees = new ArrayList<EmployeePayroll>();
    }

    public void readEmployeePayrollData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of employees: ");
        int employeeCount = scanner.nextInt();

        for (int i = 0; i < employeeCount; i++) {
            System.out.println("Enter the details of the employee " + (i + 1) + ": ");

            System.out.println("Enter the id of the employee: ");
            int id = scanner.nextInt();

            System.out.println("Enter the name of the employee: ");
            String name = scanner.next();

            System.out.println("Enter the salary of the employee: ");
            double salary = scanner.nextDouble();

            System.out.println();

            this.employees.add(new EmployeePayroll(id, name, salary));
        }

        scanner.close();
    }

    public void writeEmployeePayrollData() {
        if (this.employees.size() == 0) {
            System.out.println("There are no employees");
            return;
        }

        for (int i = 0; i < this.employees.size(); i++) {
            System.out.println("Employee " + (i + 1) + ": ");
            employees.get(i).display();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();

        employeePayrollService.readEmployeePayrollData();
        employeePayrollService.writeEmployeePayrollData();
    }
}
