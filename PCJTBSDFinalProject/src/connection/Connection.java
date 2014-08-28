/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Naveen
 */
public class Connection {

    private static Connection connection;

    private Connection() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    public java.sql.Connection connection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/neelagiri", "root", "123");
        return conn;
    }

    public void putData(String sql) throws Exception {
        java.sql.Connection c = connection();
        Statement st = c.createStatement();
        st.executeUpdate(sql);
    }

    public ResultSet getData(String sql) throws Exception {
        java.sql.Connection c = connection();
        Statement st = c.createStatement();
        ResultSet r = st.executeQuery(sql);
        return r;
    }
}
