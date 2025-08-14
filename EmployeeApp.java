import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeApp {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeedatabase";
    private static final String DB_USER = "root"; // Your MySQL username
    private static final String DB_PASSWORD = "dhanush2005"; // Your MySQL password

    private Connection conn;
    private Scanner sc;

    public EmployeeApp() {
        sc = new Scanner(System.in);
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("✅ Connected to database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------------ PERSONAL INFO CRUD ------------------------
    public void addPersonalInfo() {
        String sql = "INSERT INTO personalinfo(Employee_ID, Name, DOB, Gender, Contact_No, Address, Emergency_Contact_No) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee ID: ");
            pstmt.setInt(1, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Name: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter DOB (YYYYMMDD): ");
            pstmt.setInt(3, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Gender: ");
            pstmt.setString(4, sc.nextLine());
            System.out.print("Enter Contact No: ");
            pstmt.setInt(5, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Address: ");
            pstmt.setString(6, sc.nextLine());
            System.out.print("Enter Emergency Contact No: ");
            pstmt.setInt(7, sc.nextInt());

            pstmt.executeUpdate();
            System.out.println("✅ Personal Info added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPersonalInfo() {
        String sql = "SELECT * FROM personalinfo";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("Employee_ID") + " | " +
                                   rs.getString("Name") + " | " +
                                   rs.getInt("DOB") + " | " +
                                   rs.getString("Gender") + " | " +
                                   rs.getInt("Contact_No") + " | " +
                                   rs.getString("Address") + " | " +
                                   rs.getInt("Emergency_Contact_No"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePersonalInfo() {
        String sql = "UPDATE personalinfo SET Name=? WHERE Employee_ID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to update: ");
            pstmt.setInt(2, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter new Name: ");
            pstmt.setString(1, sc.nextLine());
            pstmt.executeUpdate();
            System.out.println("✅ Personal Info updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePersonalInfo() {
        String sql = "DELETE FROM personalinfo WHERE Employee_ID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to delete: ");
            pstmt.setInt(1, sc.nextInt());
            pstmt.executeUpdate();
            System.out.println("✅ Personal Info deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------------ EDUCATION INFO CRUD ------------------------
    public void addEducationInfo() {
        String sql = "INSERT INTO employeeeducationinfo(Degree_Type, Field_of_Study, Institution_Name, Graduation_Date, CourseWorks) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Degree Type: ");
            pstmt.setString(1, sc.nextLine());
            System.out.print("Enter Field of Study: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter Institution Name: ");
            pstmt.setString(3, sc.nextLine());
            System.out.print("Enter Graduation Date (YYYY): ");
            pstmt.setInt(4, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Course Works: ");
            pstmt.setString(5, sc.nextLine());

            pstmt.executeUpdate();
            System.out.println("✅ Education Info added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEducationInfo() {
        String sql = "SELECT * FROM employeeeducationinfo";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("Degree_Type") + " | " +
                                   rs.getString("Field_of_Study") + " | " +
                                   rs.getString("Institution_Name") + " | " +
                                   rs.getInt("Graduation_Date") + " | " +
                                   rs.getString("CourseWorks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEducationInfo() {
        String sql = "UPDATE employeeeducationinfo SET Institution_Name=? WHERE Degree_Type=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Degree Type to update: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter new Institution Name: ");
            pstmt.setString(1, sc.nextLine());
            pstmt.executeUpdate();
            System.out.println("✅ Education Info updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEducationInfo() {
        String sql = "DELETE FROM employeeeducationinfo WHERE Degree_Type=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Degree Type to delete: ");
            pstmt.setString(1, sc.nextLine());
            pstmt.executeUpdate();
            System.out.println("✅ Education Info deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------------ EMPLOYMENT INFO CRUD ------------------------
    public void addEmploymentInfo() {
        String sql = "INSERT INTO employmentinfo(Job_Title, Department, Hire_Date, Employee_Status, Supervisor_or_Manager, Exit_Date, Termination_Type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Job Title: ");
            pstmt.setString(1, sc.nextLine());
            System.out.print("Enter Department: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter Hire Date (YYYYMMDD): ");
            pstmt.setString(3, sc.nextLine());
            System.out.print("Enter Employee Status: ");
            pstmt.setString(4, sc.nextLine());
            System.out.print("Enter Supervisor or Manager: ");
            pstmt.setString(5, sc.nextLine());
            System.out.print("Enter Exit Date (YYYY or 0 if not applicable): ");
            pstmt.setInt(6, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Termination Type: ");
            pstmt.setString(7, sc.nextLine());

            pstmt.executeUpdate();
            System.out.println("✅ Employment Info added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmploymentInfo() {
        String sql = "SELECT * FROM employmentinfo";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("Job_Title") + " | " +
                                   rs.getString("Department") + " | " +
                                   rs.getString("Hire_Date") + " | " +
                                   rs.getString("Employee_Status") + " | " +
                                   rs.getString("Supervisor_or_Manager") + " | " +
                                   rs.getInt("Exit_Date") + " | " +
                                   rs.getString("Termination_Type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmploymentInfo() {
        String sql = "UPDATE employmentinfo SET Department=? WHERE Job_Title=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Job Title to update: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter new Department: ");
            pstmt.setString(1, sc.nextLine());
            pstmt.executeUpdate();
            System.out.println("✅ Employment Info updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmploymentInfo() {
        String sql = "DELETE FROM employmentinfo WHERE Job_Title=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Job Title to delete: ");
            pstmt.setString(1, sc.nextLine());
            pstmt.executeUpdate();
            System.out.println("✅ Employment Info deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------------ MENU SYSTEM ------------------------
    public void menu() {
        while (true) {
            System.out.println("\n===== Employee Database Menu =====");
            System.out.println("1. Personal Info");
            System.out.println("2. Education Info");
            System.out.println("3. Employment Info");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: personalInfoMenu(); break;
                case 2: educationInfoMenu(); break;
                case 3: employmentInfoMenu(); break;
                case 0: close(); System.out.println("👋 Exiting..."); return;
                default: System.out.println("❌ Invalid option!");
            }
        }
    }

    private void personalInfoMenu() {
        System.out.println("\n--- Personal Info Menu ---");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();
        switch (ch) {
            case 1: addPersonalInfo(); break;
            case 2: viewPersonalInfo(); break;
            case 3: updatePersonalInfo(); break;
            case 4: deletePersonalInfo(); break;
            default: System.out.println("❌ Invalid option!");
        }
    }

    private void educationInfoMenu() {
        System.out.println("\n--- Education Info Menu ---");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();
        switch (ch) {
            case 1: addEducationInfo(); break;
            case 2: viewEducationInfo(); break;
            case 3: updateEducationInfo(); break;
            case 4: deleteEducationInfo(); break;
            default: System.out.println("❌ Invalid option!");
        }
    }

    private void employmentInfoMenu() {
        System.out.println("\n--- Employment Info Menu ---");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();
        switch (ch) {
            case 1: addEmploymentInfo(); break;
            case 2: viewEmploymentInfo(); break;
            case 3: updateEmploymentInfo(); break;
            case 4: deleteEmploymentInfo(); break;
            default: System.out.println("❌ Invalid option!");
        }
    }

    public void close() {
        try {
            if (conn != null) conn.close();
            if (sc != null) sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        EmployeeApp app = new EmployeeApp();
        app.menu();
    }
}
