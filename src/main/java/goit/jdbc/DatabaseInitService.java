package goit.jdbc;

import goit.jdbc.exception.DatabaseQueryException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String sql = Files.readString(Path.of("sql/init_db.sql"));
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Database initialized");
        } catch (Exception e) {
            throw new DatabaseQueryException("Failed to initialize the database", e);
        }
    }
}
