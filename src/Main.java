public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        // Création d'utilisateurs
        User user1 = new User(1, "Alice", "alice@example.com");
        User user2 = new User(2, "Bob", "bob@example.com");

        // Enregistrement des utilisateurs
        userService.registerUser(user1);
        userService.registerUser(user2);

        // Récupération d'un utilisateur
        User foundUser = userService.getUser(1);
        System.out.println("Found user: " + foundUser);
    }
}
