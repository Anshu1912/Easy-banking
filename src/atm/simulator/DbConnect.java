package atm.simulator;

import java.sql.*;

public class DbConnect {

    Connection c;
    Statement s;

    public DbConnect() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulator", "root", "ATM@simulator");
            s = c.createStatement();

        } catch (Exception e) {

        }

    }

}
