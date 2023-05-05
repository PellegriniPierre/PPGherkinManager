package sqlConnector;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class mariadb {
    public static @NotNull ResultSet mariadbConnector() throws SQLException {
        String Query = "SELECT * from TABLE1 JOIN TABLE2 on TABLE1.id = TABLE2.id";
        String connStringUrl = "jdbc:mariadb://20.13.162.105:3307/wordpress";
        Connection conn = DriverManager.getConnection(connStringUrl + "root" + "somewordpress");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Query);
        while(rs.next()){
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            System.out.println("ID: " + id + ";" + "nom: " + nom );
        }
        ResultSetMetaData metadata = rs.getMetaData();
        System.out.println(metadata);
        conn.close();

        System.out.println(rs.getString(1));
        return rs;
    }
}
