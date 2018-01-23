import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRsvDao implements Reservations {
    private Connection connection = null;

    public MySQLRsvDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/restaurant_db",
                    "root",
                    "codeup"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error initializing the MySQL driver.", e);
        }
    }

    @Override
    public List<Reservation> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservations");
            return createReservationsFromResult(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all reservations.", e);
        }
    }

    @Override
    public Long insert(Reservation rsv) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(rsv), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            // We use this to make sure we have the first Result
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new reservation.", e);
        }
    }

    private String createInsertQuery(Reservation rsv) {
        return "INSERT INTO reservations(user_id, num_people, date, time) VALUES "
                + "(" + rsv.getUserId() + ", "
                + "'" + rsv.getNum_people() +"', "
                + "'" + rsv.getDate() +"', "
                + "'" + rsv.getTime() + "')";
    }

    private Reservation extractReservation(ResultSet rs) throws SQLException {
        return new Reservation(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getInt("num_people"),
                rs.getString("date"),
                rs.getString("time")
        );
    }

    private List<Reservation> createReservationsFromResult(ResultSet rs) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        while (rs.next()) {
            reservations.add(extractReservation(rs));
        }
        return reservations;
    }
}