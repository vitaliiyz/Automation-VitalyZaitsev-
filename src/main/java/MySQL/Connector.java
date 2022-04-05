package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

    Connection connect;
    Statement statement;

    public Connection createConnection() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa11?user=testqa11&password=testqa11");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connect;
    }

    public Statement getConnect() {
        try {
            statement = createConnection().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }

    public void closeConnect() {
        try {
            getConnect().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
