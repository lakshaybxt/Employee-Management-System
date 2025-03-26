import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Add an employee
    public void addEmployee(Employee emp) {
        String query = "INSERT INTO employees (name, age, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setInt(2, emp.getAge());
            stmt.setString(3, emp.getDepartment());
            stmt.setDouble(4, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Update an employee
    public void updateEmployee(int id, String name, int age, String department, double salary) {
        String query = "UPDATE employees SET name=?, age=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, department);
            stmt.setDouble(4, salary);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Employee updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete an employee
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
