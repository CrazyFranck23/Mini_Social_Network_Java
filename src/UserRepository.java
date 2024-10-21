import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    // Sauvegarder un utilisateur
    public void save(User user) {
        users.add(user);
        System.out.println("User saved: " + user);
    }

    // Trouver un utilisateur par son ID
    public User find(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    // Simuler un affichage de tous les utilisateurs
    public List<User> findAll() {
        return users;
    }
}
