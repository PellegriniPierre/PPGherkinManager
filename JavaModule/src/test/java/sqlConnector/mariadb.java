package sqlConnector;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class mariadb {
    public static ResultSet mariadbConnector() throws SQLException {
        String Query = "SELECT * from Users";
        Connection conn = DriverManager.getConnection("jdbc:mariadb://20.13.162.105:3307/wordpress" + "root" + "somewordpress");
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
