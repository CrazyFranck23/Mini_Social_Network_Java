import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Cette classe s'occupera de la persistance des objets User.
// Elle permet aussi de se connecter à MySQL et gérer les utilisateurs dans la base de données.

public class UserRepository {
    private Connection connect() {
        Connection connection = null;
        try {
            // Charger le driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/social_network", "franck", "franck");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void save(User user) {
        String sql = "INSERT INTO users (userId, username, email) VALUES (?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User find(int userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";
        User user = null;
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getInt("userId"),
                        resultSet.getString("username"),
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
