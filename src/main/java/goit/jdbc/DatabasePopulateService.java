package goit.jdbc;

import goit.jdbc.exception.DatabaseQueryException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            String sql = Files.readString(Path.of("sql/populate_db.sql"));
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Data added successfully");
        } catch (Exception e) {
            throw new DatabaseQueryException("Failed to populate the database", e);
        }
    }
}
