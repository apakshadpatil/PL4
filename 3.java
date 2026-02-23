import java.sql.*;
import java.util.Scanner;

public class JdbcSelectTest {

    static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASS = "actual_password"; 

    public static void main(String[] args) {

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Scanner sc = new Scanner(System.in)
        ) {

            int choice;

            do {
                System.out.println("\n===== Library Management System =====");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. Update Book");
                System.out.println("4. Search Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Enter a number.");
                    sc.next();
                }

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        addBook(conn, sc);
                        break;

                    case 2:
                        deleteBook(conn, sc);
                        break;

                    case 3:
                        updateBook(conn, sc);
                        break;

                    case 4:
                        searchBook(conn, sc);
                        break;

                    case 5:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 5);

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    // ADD BOOK
    public static void addBook(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            if (price < 0 || quantity < 0) {
                System.out.println("Price and Quantity must be positive.");
                return;
            }

            String sql = "INSERT INTO books (title, author, price, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, quantity);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " book added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    // DELETE BOOK
    public static void deleteBook(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter Book ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM books WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Book deleted successfully.");
            else
                System.out.println("Book not found.");

        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    // UPDATE BOOK
    public static void updateBook(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter Book ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter New Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            if (price < 0 || quantity < 0) {
                System.out.println("Invalid values.");
                return;
            }

            String sql = "UPDATE books SET price = ?, quantity = ? WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, price);
            pstmt.setInt(2, quantity);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Book updated successfully.");
            else
                System.out.println("Book not found.");

        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // SEARCH BOOK
    public static void searchBook(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter Title or Author to search: ");
            String keyword = sc.nextLine();

            String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n-----------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-10s %-10s\n",
                    "BookID", "Title", "Author", "Price", "Qty");
            System.out.println("-----------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.printf("%-10d %-20s %-20s %-10.2f %-10d\n",
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
            }

            if (!found)
                System.out.println("No books found.");

            System.out.println("-----------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Error searching book: " + e.getMessage());
        }
    }
}
