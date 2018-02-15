package dao;

import models.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRsvDao implements Reservations {
    private Connection connection = null;

    public MySQLRsvDao(Config config) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error initializing the MySQL driver.", e);
        }
    }

    @Override
    public List<Reservation> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM reservations");
            ResultSet rs = stmt.executeQuery();
            return createReservationsFromResult(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all reservations.", e);
        }
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM reservations where user_id = ?");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createReservationsFromResult(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the reservation.", e);
        }
    }

    @Override
    public Long insert(Reservation rsv) {

        String insertQuery = "INSERT INTO reservations(user_id, num_people, date, time) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, rsv.getUserId());
            stmt.setInt(2, rsv.getNum_people());
            stmt.setString(3, rsv.getDate());
            stmt.setString(4, rsv.getTime());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            // We use this to make sure we have the first Result
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new reservation.", e);
        }
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