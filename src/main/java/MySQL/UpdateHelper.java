package MySQL;

import java.sql.SQLException;

public class UpdateHelper extends Connector {

    public int update(String query) {
        try {
            return getConnect().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

}
