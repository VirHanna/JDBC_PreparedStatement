package goit.jdbc;

import goit.jdbc.exception.DatabaseQueryException;
import goit.jdbc.dto.LongestProject;
import goit.jdbc.dto.MaxProjectCountClient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> findLongestProject(LocalDate startDate, LocalDate endDate) {
        return executeQuery(
                "sql/find_longest_project.sql",
                pstmt -> {
                    pstmt.setDate(1, java.sql.Date.valueOf(startDate));
                    pstmt.setDate(2, java.sql.Date.valueOf(endDate));
                },
                rs -> new LongestProject(
                        rs.getInt("ID"),
                        rs.getInt("MONTH_COUNT"))
        );
    }

    public List<MaxProjectCountClient> findMaxProjectsClient(int projectCount) {
        return executeQuery(
                "sql/find_max_projects_client.sql",
                pstmt -> pstmt.setInt(1, projectCount),
                rs -> new MaxProjectCountClient(
                        rs.getString("NAME"),
                        rs.getInt("PROJECT_COUNT"))
        );
    }

    private <T> List<T> executeQuery(String sqlPath, PreparedStatementSetter setter, ResultSetMapper<T> mapper) {
        List<T> result = new ArrayList<>();
        try {
            String sql = Files.readString(Path.of(sqlPath));
            try (Connection conn = Database.getInstance().getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                setter.setParameters(pstmt);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        result.add(mapper.map(rs));
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new DatabaseQueryException("Error while executing query from file: " + sqlPath, e);
        }
        return result;
    }

    @FunctionalInterface
    private interface PreparedStatementSetter {
        void setParameters(PreparedStatement pstmt) throws SQLException;
    }

    @FunctionalInterface
    private interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }
}
