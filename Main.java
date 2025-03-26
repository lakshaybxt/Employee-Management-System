import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Department: ");
                    String department = scanner.next();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    Employee emp = new Employee(0, name, age, department, salary);
                    employeeDAO.addEmployee(emp);
                    break;

                case 2:
                    for (Employee e : employeeDAO.getAllEmployees()) {
                        System.out.println(e.getId() + " | " + e.getName() + " | " + e.getAge() + " | " + e.getDepartment() + " | " + e.getSalary());
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter New Department: ");
                    String newDept = scanner.next();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    employeeDAO.updateEmployee(updateId, newName, newAge, newDept, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employeeDAO.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
